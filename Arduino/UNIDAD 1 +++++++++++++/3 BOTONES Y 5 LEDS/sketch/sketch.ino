const int boton1 = 23;
const int boton2 = 22;
const int boton3 = 21;
const int led1 = 19;
const int led2 = 18;
const int led3 = 5;
const int led4 = 4;
const int led5 = 2;


int leds[] = {led1, led2, led3, led4, led5};  
int totalLeds = 5;

void setup() {
  pinMode(boton1, INPUT_PULLDOWN);
  pinMode(boton2, INPUT_PULLDOWN);
  pinMode(boton3, INPUT_PULLDOWN);
  pinMode(led1, OUTPUT);
  pinMode(led2, OUTPUT);
  pinMode(led3, OUTPUT);
  pinMode(led4, OUTPUT);
  pinMode(led5, OUTPUT);
}

void loop() {
  if (digitalRead(boton1) == HIGH)
{
  digitalWrite(led2, HIGH);
  delay(1000);
  digitalWrite(led4, HIGH);
  delay(1000);
  digitalWrite(led1, HIGH);
  delay(1000);
  digitalWrite(led3, HIGH);  delay(1000);
  digitalWrite(led5, HIGH);
}


if (digitalRead(boton2) == HIGH) {
    // Creamos un arreglo con los índices
    int orden[totalLeds];
    for (int i = 0; i < totalLeds; i++) {
      orden[i] = i;
    }

    // Mezclamos el arreglo (Fisher-Yates shuffle)
    for (int i = totalLeds - 1; i > 0; i--) {
      int j = random(0, i + 1);
      int temp = orden[i];
      orden[i] = orden[j];
      orden[j] = temp;
    }

    // Encendemos los LEDs en orden aleatorio
    for (int i = 0; i < totalLeds; i++) {
      digitalWrite(leds[orden[i]], HIGH);
      delay(1000);
    }
}

if (digitalRead(boton3) == HIGH)
{
  digitalWrite(led1, LOW);
  digitalWrite(led2, LOW);
  digitalWrite(led3, LOW);
  digitalWrite(led4, LOW);
  digitalWrite(led5, LOW);
 
}
}
