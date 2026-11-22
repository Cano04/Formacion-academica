//Declarar pines de los LEDS

const int verde = 18;
const int rojo = 19;
const int Naranja = 21;
const int amarillo = 22;
const int azul = 23;
void setup() {
  //Configurar el modo de los pines
  pinMode(verde, OUTPUT);
  pinMode(rojo, OUTPUT);
  pinMode(amarillo, OUTPUT);
  pinMode(Naranja, OUTPUT);
  pinMode(azul, OUTPUT);
}

void loop() {
  digitalWrite(verde, HIGH);
  delay(2000);
  digitalWrite(rojo, HIGH);
  delay(2000);
  digitalWrite(Naranja, HIGH);
  delay(2000);
  digitalWrite(amarillo, HIGH);
  delay(2000);
  digitalWrite(azul, HIGH);

  delay(2000);

  digitalWrite(azul, LOW);
  delay(2000);
  digitalWrite(amarillo, LOW);
  delay(2000);
  digitalWrite(Naranja, LOW);
  delay(2000);
  digitalWrite(rojo, LOW);
  delay(2000);
  digitalWrite(verde, LOW);

  delay(2000);
}
