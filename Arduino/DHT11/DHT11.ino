const int sensor=23;
#include <DHT.h>
#define DHTTYPE DHT11
DHT dht(sensor, DHTTYPE);
void setup() {
Serial.begin(9600);
dht.begin();
}

void loop() {
float humedad= dht.readHumidity();
float temperatura= dht.readTemperature();
if (isnan(humedad) || isnan(temperatura))
{
  Serial.print("Fallo de lectura");
  delay(1000);
}
Serial.print("Humedad:");
Serial.println(humedad);
Serial.print("Temperatura:");
Serial.println(temperatura);
delay(2000);
}