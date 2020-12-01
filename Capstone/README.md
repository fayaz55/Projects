# Internet of Things for Smart Building Management

## Introduction

Wireless communications and networking have become a significant role in everyday lives. With
the rise and development of the Internet of Things (IoT) applications, the next generation of wireless
communication systems will provide integrated support for these devices. IoT encompasses various
applications from wearables such as smart watches to connected car technologies such as autonomous
navigation and driving. These applications use various sensors to obtain data and with intelligent
decision making, these devices will provide precise feedback to ensure the optimum and desired
performance with little to no interaction from the user. For this project, the main objective is to design
and develop a set of demos involving multiple sensors that include the sensors for energy use and
sensors for home comfort. This will be done using an IoT board which will act as a hub for
communication of data acquisition from sensors and handle API requests from the cloud server. The IoT
board will be connected to various sensors such as sound, PIR, temperature and humidity. These sensors
will constantly send telemetry data to the IoT board and from there, this data is then sent and stored on
the cloud server. With the PIR sensor data and temperature data, machine learning algorithms will be
applied to make appropriate predictions based on homeowners usage. Once a prediction is made, an
API is sent back to the board to perform various actions such as opening or closing vents or detecting for
motion. This will result in little to no interaction of the homeowner/user with the IoT device. An android application 
was also made to notify the user of the actions taking place as well as an option to manually control parts of the
system.

## Files 
* `BrighFuture3_working_activities` Android Application used to interact with the system

* `BigQueryTestModel.sql` Query used to test model developed on BigQuery

* `BigQueryTrainModel.sql` Query used to train model based on data provided from sensors

* `cloudiot_mqtt_gateway.py` Python File used to establish a connection and send data to the cloud

* `humidity_logger_test.py` Python script used to ensure sensors are retrieving and storing data correctly

* `index.js` Cloud function script to push data onto Firebase

* `moter_test.py` Python script used to ensure motor controlling vents is correctly working

* `run-gateway` Bash script to run cloudiot_mqtt_gateway.py

* `sheets.py` Python script used to ensure data is successfully retrieved from the sheets api

* `thermostat.py` Final script used to send data to cloud, receive data and interact with sensors and motors  


## Products Used

* __Google Cloud Platform__ ( IoT Core, Dataflow, Pub/Sub, BigQuery, Cloud Functions, Storage, Sheets API, Firebase)
* __Android Studio__  
* __Raspberry Pi__ 
* __Trello__

## Group Members

* __Aali Waqar__
* __Ilmurat Ownuk__
* __Nikida Mavadia__

## References 
1. (n.d.). Logistic Regression For Dummies: A Detailed Explanation. Retrieved February 14, 2020, from https://towardsdatascience.com/logistic-regression-for-dummies-a-detailed-explanation-9597f76edf46
2. (2018, September 7). Understanding Logistic Regression in Python - DataCamp. Retrieved February 14,2020, from https://www.datacamp.com/community/tutorials/understanding-logistic-regression-python
3. (n.d.).MG995 High Speed Metal Gear Dual Ball Bearing Servo - Electronicos Scaldas. Retrieved February 14, 2020, from https://www.electronicoscaldas.com/datasheet/MG995_Tower-Pro.pdf
4. (n.d).“Build an Android App Using Firebase and the App Engine Flexible ...”. [Online]. Available: https://cloud.google.com/solutions/mobile/mobile-firebase-app-engine-flexible. [Accessed:
06-Dec.-2019].
5. ( n.d).“Configuring devices | Cloud IoT Core Documentation | Google Cloud”. [Online]. Available: https://cloud.google.com/iot/docs/how-tos/config/configuring-devices. [Accessed: 14-Feb.-2020]
6. (n.d).“Meet Android Studio | Android Developers”. [Online]. Available: https://developer.android.com/studio/intro. [Accessed: 14-Feb.-2020]
7. (n.d).“What is a Cloud Server? - Definition from Techopedia”. [Online]. Available: https://www.techopedia.com/definition/29019/cloud-server. [Accessed: 14-Feb.-2020]
8. (n.d).“Publishing over the MQTT bridge | Cloud IoT Core Documentation ...”. [Online]. Available: https://cloud.google.com/iot/docs/how-tos/mqtt-bridge. [Accessed: 14-Feb.-2020]
9. (n.d.) ”Cloud IoT API” [Online] Available: https://cloud.google.com/iot/docs/reference/cloudiot/rest/ [Accessed: 14-Feb.-2020]
10. Kumar. S. (2019) Binary Logistic Regression with BigQuery ML Retrieved on February 13, 2020 from https://medium.com/@Sushil_Kumar/binary-logistic-regression-with-bigquery-ml-c9caa5920a71
11. Google Cloud,(2020), Building And Using a Classification Model on Census Data, Google, Retrieved on February 13,2020 from https://cloud.google.com/bigquery-ml/docs/logistic-regression-prediction
12. IoT Is The Most Important Development of The 21st Century, SmartDataCollective, Retrieved on December 6, 2019 from https://www.smartdatacollective.com/iot-most-important-development-of-21st-century/
13. What is the Internet of Things, and how does it work?, Internet of Things blog, Retrieved on December 6, 2019 from https://www.ibm.com/blogs/internet-of-things/what-is-the-iot/?fbclid=IwAR3gPXdTaPiiTwyETB9At8OLs-AyUVP4LI_uX4HBmWsVYKdjQ_ASh1_R9Yk
14. Bauges, G, (2017) , Google Spreadsheets and Python, Twilio Blog, Retrieved on April 8, 2020, from https://www.twilio.com/blog/2017/02/an-easy-way-to-read-and-write-to-a-google-spreadsheet-in-python.html
15. Installation & Setup on Android | Firebase Realtime Database (2020). Retrieved on April 8, 2020, from https://firebase.google.com/docs/database/android/start/.
16. Query | JavaScript SDK | Firebase (2020). Retrieved on April 8, 2020, from https://firebase.google.com/docs/reference/js/firebase.database.Query .
17. Lourme, O. (2019) How to check the weather using GCP-Cloud IoT Core with ESP32 and Mongoose OS. Medium, Retrieved on April 8, 2020 from https://medium.com/free-code-camp/gcp-cloudiotcore-esp32-mongooseos-1st-5c88d8134ac7
18. Google Cloud (n.d.) Using Cloud IoT Core Gateways with a Raspberry Pi, Google, Retrieved on April 8,2020 from https://cloud.google.com/community/tutorials/cloud-iot-gateways-rpi
19. Start another activity (n.d), Android Developer , 2020. Retrieved on April 8, 2020 from https://developer.android.com/training/basics/firstapp/starting-activity
20. Weiss, Gabe. Cloud IoT step-by-step: Cloud to device communication (2019), Medium, Retrieve on March 13, 2020 from https://medium.com/google-cloud/cloud-iot-step-by-step-cloud-to-device-communication-655a92d548
ca
21. https://www.ee.ryerson.ca/capstone/topics/2019/AA05.html
22. https://firebase.google.com/docs/storage/gcp-integration
23. PVPDS. Navigation drawer with Activities in android studio( not fragments ) (2017), Retrieved on April 1 2020 from https://www.youtube.com/watch?v=M_4Oh2FeRYs
24. (n.d.),Controlling A Servor from the Raspberry Pi, Uoit, Retrieved On April 8, 2020 from https://rpi.science.uoit.ca/lab/servo/
25. (n.d.), Raspberry Pi: Measure Humidity and Temperature with DHT11/DHT22, Raspberry Pi Tutorials , Retrieved on April 8, 2020 from https://tutorials-raspberrypi.com/raspberry-pi-measure-humidity-temperature-dht11-dht22/