#include <Wire.h>
#include <LiquidCrystal_I2C.h>

LiquidCrystal_I2C lcd(0x27, 16, 2);

const int POT = 25;
const int leds[] = {33, 32, 12, 14, 23};
const int numLeds = 5;

int valorP = 0;
int valor = 0; 
int nivelActual = 1;
int brilloNivel = 0;

int valorAnterior = -1; 
int nivelAnterior = -1;

unsigned long previousMillis = 0;
const long pwmInterval = 10;
int pwmCounter = 0;

void setup() {
  Serial.begin(9600);
  pinMode(POT, INPUT);
  for (int i = 0; i < numLeds; i++) {
    pinMode(leds[i], OUTPUT);
    digitalWrite(leds[i], LOW);
  }

  lcd.init();
  lcd.backlight();
  lcd.clear();
  lcd.setCursor(0, 0);
  lcd.print("Iniciando...");
  delay(1000);
  lcd.clear();
}

void loop() {
  long suma = 0;
  for (int i = 0; i < 10; i++) {
    suma += analogRead(POT);
    delay(5);
  }
  valorP = suma / 10;

  
  valor = map(valorP, 0, 4095, 0, 100);
  valor = constrain(valor, 0, 100);

  nivelActual = (valor / 20) + 1;
  if (nivelActual > 5) nivelActual = 5;
  
  brilloNivel = (valor % 20) * 5;
  if (valor == 100) {
    brilloNivel = 100;
  }

  Serial.print("ValorP: "); Serial.print(valorP);
  Serial.print(" | Valor: "); Serial.print(valor);
  Serial.print(" | Nivel: "); Serial.print(nivelActual);
  Serial.print(" | BrilloNivel: "); Serial.println(brilloNivel);

  unsigned long currentMillis = millis();
  if (currentMillis - previousMillis >= pwmInterval) {
    previousMillis = currentMillis;
    pwmCounter++;
    if (pwmCounter > 100) pwmCounter = 0;

    for (int i = 0; i < nivelActual - 1; i++) {
      digitalWrite(leds[i], HIGH);
    }

    if (nivelActual <= numLeds) {
      if (pwmCounter < brilloNivel) {
        digitalWrite(leds[nivelActual - 1], HIGH);
      } else {
        digitalWrite(leds[nivelActual - 1], LOW);
      }
    }

    for (int i = nivelActual; i < numLeds; i++) {
      digitalWrite(leds[i], LOW);
    }
  }

  if (valor != valorAnterior || nivelActual != nivelAnterior) {
    lcd.clear();
    lcd.setCursor(0, 0);
    lcd.print("NIVEL ");
    lcd.print(nivelActual);
    lcd.print(": ");
    lcd.print(brilloNivel);
    lcd.print("%   ");

    lcd.setCursor(0, 1);
    lcd.print("Valor: "); 
    lcd.print(valorP); 
    lcd.print("    "); 

    valorAnterior = valor;
    nivelAnterior = nivelActual;
  }
}