#include "BluetoothSerial.h"

BluetoothSerial SerialBT;  // ✅ Este es el objeto correcto

const int ledPins[5] = {2, 3, 5, 18, 19};
bool ledStates[5] = {false, false, false, false, false};

void setup() {
  Serial.begin(9600);
  SerialBT.begin("ESP32OyP");  // ✅ Cambiado ESP_BT → SerialBT

  // Configurar pines de salida
  for (int i = 0; i < 5; i++) {
    pinMode(ledPins[i], OUTPUT);
    digitalWrite(ledPins[i], LOW);
  }

  // Mensajes de inicio
  Serial.println("✅ ESP32 listo. Enviar comandos 1-5 para LEDs, 'a' para todos ON, 'o' para apagar todos.");
  SerialBT.println("✅ ESP32 listo. Envía comandos 1-5 para alternar LEDs, 'a' todos ON, 'o' todos OFF.");
}

void loop() {
  if (SerialBT.available()) {
    char cmd = SerialBT.read();

    if (cmd >= '1' && cmd <= '5') {
      int ledIndex = cmd - '1';
      ledStates[ledIndex] = !ledStates[ledIndex];
      digitalWrite(ledPins[ledIndex], ledStates[ledIndex] ? HIGH : LOW);
      enviarMensajeEstado();
    } 
    else if (cmd == 'a') {
      for (int i = 0; i < 5; i++) {
        ledStates[i] = true;
        digitalWrite(ledPins[i], HIGH);
      }
      enviarMensajeEstado();
    } 
    else if (cmd == 'o') {
      for (int i = 0; i < 5; i++) {
        ledStates[i] = false;
        digitalWrite(ledPins[i], LOW);
      }
      enviarMensajeEstado();
    }
  }
}

void enviarMensajeEstado() {
  String mensaje = "Estado LEDs: ";
  for (int i = 0; i < 5; i++) {
    mensaje += "LED" + String(i + 1) + (ledStates[i] ? " ON, " : " OFF, ");
  }
  SerialBT.println(mensaje);
  Serial.println(mensaje);
}

