import os
import time
import Adafruit_DHT
import RPi.GPIO as GPIO

GPIO.setmode(GPIO.BCM)
GPIO.setup(17, GPIO.IN) #PIR Room 1
GPIO.setup(27, GPIO.IN) #PIR Room 2

#Temp/Humidity Room 1 
DHT_SENSOR = Adafruit_DHT.DHT22
DHT_PIN = 4

#Temp/Humidity Room 2 
DHT_SENSOR1 = Adafruit_DHT.DHT22
DHT_PIN1 = 22 


try:
    f = open('/home/pi/humidity.csv', 'a+')
    if os.stat('/home/pi/humidity.csv').st_size == 0:
            f.write('Date,Time,Temperature 1,Humidity 1,PIR 1,Temperature 2,Humidity 2,PIR 2\r\n')
except:
    pass

while True:
    #Room 1
    humidity, temperature = Adafruit_DHT.read_retry(DHT_SENSOR, DHT_PIN)
    PIR = GPIO.input(17)
    
    #Room 2
    humidity1, temperature1 = Adafruit_DHT.read_retry(DHT_SENSOR1, DHT_PIN1)
    PIR1 = GPIO.input(27)

    if humidity is not None and temperature is not None:
        f.write('{0},{1},{2:0.1f}*C,{3:0.1f}%,{4},{5:0.1f}*C,{6:0.1f}%,{7}\r\n'.format(time.strftime('%m/%d/%y'), time.strftime('%H:%M:%S'), temperature, humidity, PIR,temperature1,humidity1,PIR1))
        print("Room 1")
        print("Temperature: %0.1f *C" %temperature)
        print("Humidity: %0.1f" %humidity ,"%");
        print("PIR : ", PIR);
        
        print("Room 2")
        print("Temperature: %0.1f *C" %temperature1)
        print("Humidity: %0.1f" %humidity1,"%");
        print("PIR : ", PIR1);
    else:
        print("Failed to retrieve data from humidity sensor")

    time.sleep(5)
 