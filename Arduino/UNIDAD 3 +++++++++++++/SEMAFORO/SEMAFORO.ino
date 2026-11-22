// bibloteca sensor dht
#include "DHT.h"
// DEFINIR PINES 
const int ledRojo = 21;
const int ledAmarillo = 22;
const int ledVerde = 23;
const int pinSensor = 5;
#define DHTTYPE DHT11
DHT dht (pinSensor, DHTTYPE);

void setup() {
  //SERIAL
  Serial.begin(9600);

  //modos de operacio 
  pinMode(ledRojo, OUTPUT);
  pinMode(ledAmarillo, OUTPUT);
  pinMode(ledVerde, OUTPUT);

  dht.begin();
}

void loop() {
  float humedad = dht.readHumidity();
  float temperatura = dht.readTemperature();
  if(isnan(humedad)|| isnan(temperatura)){
    Serial.print("Valor incorrecto de lectura");
    delay(1000);
  }
  Serial.print("humedad:");
    Serial.println(humedad);
     Serial.println(" %");
    Serial.print("temperatura:");
    Serial.println(temperatura);
    Serial.println(" °C");

    // Apagar todos los LEDs antes de decidir cuál encender
  digitalWrite(ledRojo, LOW);
  digitalWrite(ledAmarillo, LOW);
  digitalWrite(ledVerde, LOW);

  // Encender LEDs según la temperatura
  if (temperatura >= 33) {
    digitalWrite(ledRojo, HIGH);
  } else if (temperatura >= 27 && temperatura <= 32) {
    digitalWrite(ledAmarillo, HIGH);
  } else if (temperatura >= 27) {
    digitalWrite(ledVerde, HIGH);
  }
    delay(2000);
}