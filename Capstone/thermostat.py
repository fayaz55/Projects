# Copyright 2018 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

from __future__ import print_function

import random
import sys
import socket
import time
import datetime
import gspread
import oauth2client.client
import json
import os
import argparse

from oauth2client.service_account import ServiceAccountCredentials

import httplib2
from oauth2client import client


import Adafruit_DHT
from colors import bcolors
import RPi.GPIO as GPIO

GPIO.setmode(GPIO.BCM)
GPIO.setup(17, GPIO.IN) #PIR Room 1
GPIO.setup(27, GPIO.IN) #PIR Room 2 
DHT_SENSOR_PIN = 22
DHT_SENSOR_PIN1 = 4

GPIO.setmode(GPIO.BCM)
GPIO.setup(18, GPIO.OUT) # Servo Pin

Motor = GPIO.PWM(18,50) # 50 Hz Frequency
Motor.start(0) # initialization

#json filename for credentials
JSON = 'leafy.json'
json_key = json.load(open(JSON))

scope = ['https://spreadsheets.google.com/feeds','https://www.googleapis.com/auth/drive']
creds = ServiceAccountCredentials.from_json_keyfile_name('leafy.json', scope)
client = gspread.authorize (creds)

sheet = client.open('Results_Raspberry_Pi').sheet1


ADDR = '192.168.86.79'
PORT = 10000
# Create a UDP socket
client_sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

server_address = (ADDR, PORT)

device_id = sys.argv[1]
if not device_id:
    sys.exit('The device id must be specified.')

print('Bringing up device {}'.format(device_id))


def SendCommand(sock, message, log=True):
    print('sending "{}"'.format(message))
    sock.sendto(message.encode(), server_address)

    # Receive response
    print('waiting for response')
    response = sock.recv(4096)
    print('received: "{}"'.format(response))

    return response
    
    #""" returns message received """
    #if log:
    #    print('sending: "{}"'.format(message), file=sys.stderr)

    #sock.sendto(message.encode('utf8'), server_address)

    # Receive response
    #if log:
    #    print('waiting for response', file=sys.stderr)
    #    response, _ = sock.recvfrom(4096)
    #if log:
    #    print('received: "{}"'.format(response), file=sys.stderr)

    #return response


#print('Bring up device 1')


def MakeMessage(device_id, action, Month = '', Day = '', Time ='', Temp1 = '', Hum1 = '', Room1 ='', Temp2 = '', Hum2 = '', Room2= ''):
    if Room1:
        return '{{ "device" : "{}", "action":"{}", "Month" : "{}", "Day" : "{}", "Time" : "{}","Temp1" : "{}", "Hum1" : "{}", "Room1" : "{}", "Temp2" : "{}", "Hum2" : "{}", "Room2" : "{}"}}'.format(
            device_id, action, Month, Day, Time, Temp1, Hum1, Room1, Temp2, Hum2, Room2)
    else:
        return '{{ "device" : "{}", "action":"{}" }}'.format(device_id, action)


def RunAction(action, data=''):
    global client_sock
    message = '{{ "device" : "{}", "action":"{}", "data" : "{}" }}'.format(
            device_id, action, data)
    if not message:
        return
    print('Send data: {} '.format(message))
    event_response = SendCommand(client_sock, message)
    print('Response: {}'.format(event_response))
    #message = MakeMessage(device_id, action, data)
    #if not message:
    #    return
    #print('Send data: {} '.format(message))
    #event_response = SendCommand(client_sock, message)
    #print('Response {}'.format(event_response))

def Thermostat():
    h1, t1 = Adafruit_DHT.read_retry(22, DHT_SENSOR_PIN)
    h2, t2 = Adafruit_DHT.read_retry(22, DHT_SENSOR_PIN1)
    PIR = GPIO.input(17)
    PIR1 = GPIO.input(27)
    w = datetime.datetime.now().strftime("%H:%M")
    v = datetime.datetime.today().strftime("%A")
    x = datetime.datetime.today().strftime("%B")
    
    # DHT22 Sensor 1 PIN22
    h1 = "{:.1f}".format(h1)
    t1 = "{:.1f}".format(t1)
    # DHT22 Sensor 2 PIN4
    h2 = "{:.1f}".format(h2)
    t2 = "{:.1f}".format(t2)
    sys.stdout.write(
        '\r >>' + bcolors.CGREEN + bcolors.BOLD +
        'Month : {}, Day: {}, Year: {},Temp1: {}, Hum1: {}, PIR1: {}, Temp2: {}, Hum2: {}, PIR2: {}'.format(v,x,w,t1, h1,PIR,t2,h2,PIR1) + bcolors.ENDC + ' <<')
    #'PIR1: {}, PIR2: {}'.format(PIR,PIR1) + bcolors.ENDC + ' <<')
    sys.stdout.flush()

    message = MakeMessage(
        device_id, 'event', '{}'.format(x),'{}'.format(v), '{}'.format(w),'{}'.format(t1),'{}'.format(h1),'{}'.format(PIR),'{}'.format(t2),'{}'.format(h2),'{}'.format(PIR1))

    SendCommand(client_sock, message, True)

def Predict(M = '', D = '', T = ''):
    num = sheet.get_all_values()
    x = len(num) -1

    while x>0:
        if (num[x][2]==M) & (num[x][3] == D) & (num[x][4]==T):
            result=num[x][0]
            print(result)
            break
        x= x-1
    if result == '1':
        Motor.ChangeDutyCycle(4)
        time.sleep(1)
        Motor.ChangeDutyCycle(0)
        time.sleep(2)
        print("Motor ON")
    else:
        Motor.ChangeDutyCycle(2)
        time.sleep(0.3)
        Motor.ChangeDutyCycle(0)
        time.sleep(2)
        print("Motor OFF")

try:
    random.seed()
    RunAction('detach')
    RunAction('attach')
    RunAction('motor', 'Motor is online')
    RunAction('subscribe')
    time.sleep(2)
    RunAction('sub')
    
    Thermostat()
    period = 10
    t1=0
    
    while True:
        t = time.time()
        if t-t1>=period:
            Thermostat()
            t1=time.time()    
            response = client_sock.recv(4096).decode('utf8')
            print('Client received {}'.format(response))
            Predict('January','Friday','0:00')
        if response.upper() == 'ON' or response.upper() == b'ON':
            #GPIO.output(LED_IOPIN, GPIO.HIGH)
            Motor.ChangeDutyCycle(4)
            time.sleep(1)
            Motor.ChangeDutyCycle(0)
            time.sleep(2)
                
        elif response.upper() == "OFF" or response.upper() == b'OFF':
            #GPIO.output(LED_IOPIN, GPIO.LOW)
            Motor.ChangeDutyCycle(2)
            time.sleep(0.3)
            Motor.ChangeDutyCycle(0)
            time.sleep(2)
            
            
finally:
    print('closing socket', file=sys.stderr)
    client_sock.close()
