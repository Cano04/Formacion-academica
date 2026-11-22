
int LED1 = 5;
int LED2 = 18;
int LED3 = 19;
int LED4 = 21;
int LED5 = 22;
//int LED6 = 14;
//int LED7 = 13;

int PMO = 34;
int potVal = 0;

int intervalo = 585;

void setup() {
  pinMode(LED1, OUTPUT);
  pinMode(LED2, OUTPUT);
  pinMode(LED3, OUTPUT);
  pinMode(LED4, OUTPUT);
  pinMode(LED5, OUTPUT);


  pinMode(PMO, INPUT);
  Serial.begin(115200);
}

void loop() {
  potVal = analogRead(PMO);

  digitalWrite(LED1, HIGH);
  digitalWrite(LED2, HIGH);
  digitalWrite(LED3, HIGH);
  digitalWrite(LED4, HIGH);
  digitalWrite(LED5, HIGH);


  if (potVal != 0) {
     if (potVal <= intervalo) {
      digitalWrite(LED1, LOW);
    } else if (potVal <= intervalo *2) {
      digitalWrite(LED2, LOW);
    } else if (potVal <= intervalo *3) {
      digitalWrite(LED3, LOW);
    } else if (potVal <= intervalo *4) {
      digitalWrite(LED4, LOW);
    } else if (potVal <= intervalo *5) {
      digitalWrite(LED5, LOW);
      digitalWrite(LED1, LOW);
      digitalWrite(LED2, LOW);
      digitalWrite(LED3, LOW);
      digitalWrite(LED4, LOW);
      digitalWrite(LED5, LOW);

      delay(1000);
    }
  }

  Serial.println(potVal);
}
