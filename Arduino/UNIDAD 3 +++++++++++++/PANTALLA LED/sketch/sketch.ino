#include <LiquidCrystal_I2C.h>
#include <Wire.h>
#include <DHT.h>

const int sensor = 18;
#define DHTTYPE DHT11  // Cambié de DHT22 a DHT11

DHT dht(sensor, DHTTYPE);
LiquidCrystal_I2C LCD(0x27, 16, 2);

void setup() {
  // Inicializar puerto serie para ver mensajes de error
  Serial.begin(9600);

  // Inicializar LCD
  LCD.init();

  // Activar retroiluminación
  LCD.backlight();

  // Mostrar mensaje de bienvenida en el LCD
  LCD.setCursor(0, 0);
  LCD.print("Iniciando...");

  // Inicializar sensor DHT11
  dht.begin();
  delay(2000);  // Espera para que el sensor se estabilice
}

void loop() {
  // Leer humedad y temperatura
  float humedad = dht.readHumidity();
  float temperatura = dht.readTemperature();

  // Verificar si la lectura fue exitosa
  if (isnan(humedad) || isnan(temperatura)) {
    Serial.println("Error en la lectura");
    LCD.clear();
    LCD.setCursor(0, 0);
    LCD.print("Error de lectura");
    delay(2000);
    return;  // Salir del loop y volver a intentar
  }

  // Mostrar valores en el LCD
  LCD.clear();
  LCD.setCursor(0, 0);
  LCD.print("T:");
  LCD.print(temperatura);
  LCD.print("C");

  LCD.setCursor(0, 1);
  LCD.print("H:");
  LCD.print(humedad);
  LCD.print("%");

  delay(2000);  // Esperar 2 segundos antes de la siguiente lectura
}
