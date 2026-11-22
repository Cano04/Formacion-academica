const int sensor = 27;
#include<DHT.h>
#define DHTYPE DHT22
DHT dht (sensor, DHTYPE);
void setup() {
  // put your setup code here, to run once:
  Serial.begin(115200);
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
 Serial.print("Humedad: ");
 Serial.println(humedad);
 Serial.print("Temperatura: ");
 Serial.println(temperatura);
 delay(2000);
}
