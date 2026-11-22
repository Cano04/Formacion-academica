#define LED  25 // Pin donde está conectado el LED

const int canal = 0;
const int resolucion = 8;
const int frecuencia = 5000;

void setup() {
  ledcSetup(canal, frecuencia, resolucion);   // Configurar canal PWM
  ledcAttachPin(LED, canal);                  // Asignar pin al canal
}

void loop() {
  for (int dutyCycle = 0; dutyCycle < 255; dutyCycle++) {
    ledcWrite(canal, dutyCycle);  // Ajustar brillo
    delay(30);
  }

  for (int dutyCycle = 255; dutyCycle > 0; dutyCycle--) {
    ledcWrite(canal, dutyCycle);
    delay(30);
  }
}
