const int led = 19;
const int boton = 22;
const int boton2 = 23;

 

void setup() {
  pinMode(boton, INPUT_PULLDOWN);
  pinMode(led, OUTPUT);
  pinMode(boton2, INPUT_PULLDOWN);
}


void loop() {
if (digitalRead(boton) == HIGH)
{
  digitalWrite(led, HIGH);
}

if (digitalRead(boton2) == HIGH)
{
  digitalWrite(led, LOW);
}
}
