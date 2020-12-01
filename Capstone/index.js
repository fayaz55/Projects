 // The "Cloud Functions for Firebase" SDK to create Cloud Functions and setup triggers:
const functions = require( 'firebase-functions' );
// The Firebase Admin SDK to access the Firebase Realtime Database:
const admin = require( 'firebase-admin' );
admin.initializeApp();
exports.helloPubSub = functions.pubsub.topic( 'gateway-telemetry' ).onPublish((event,context) => {
const Month = event.json.Month;
const Day = event.json.Day;
const Time = event.json.Time;
const Temp1 = event.json.Temp1;
const Hum1 = event.json.Hum1;
const Temp2 = event.json.Temp2;
const Hum2 = event.json.Hum2;
const Room1 = event.json.Room1;
const Room2 = event.json.Room2;
console.log( `Temp1= ${ Temp1 } , Hum1= ${ Hum1 } °C, Temp2= ${ Temp2 } %, Hum2= ${ Hum2 } ` );
admin.database().ref( `devices-telemetry/thermostat` ).push({
Month: Month,
Day: Day,
Time: Time,
Temperature1: Temp1,
Humidity1: Hum1,
Room1: Room1,
Temperature2: Temp2,
Humidity2: Hum2,
Room2: Room2

})
});