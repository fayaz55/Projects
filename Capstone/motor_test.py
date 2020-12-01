import os
import time
import Adafruit_DHT
import RPi.GPIO as GPIO

GPIO.setmode(GPIO.BCM)
GPIO.setup(18, GPIO.OUT) # Servo Pin

Motor = GPIO.PWM(18,50) # 50 Hz Frequency
Motor.start(0) # initialization
x=1;

time.sleep(4)
        
Motor.ChangeDutyCycle(4)
time.sleep(1)
Motor.ChangeDutyCycle(0)
time.sleep(2)


Motor.ChangeDutyCycle(2)
time.sleep(0.3)
Motor.ChangeDutyCycle(0)
time.sleep(2)
    
#Motor.stop()
#GPIO.cleanup()        
        
        
