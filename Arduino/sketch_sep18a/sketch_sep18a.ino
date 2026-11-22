int valorPot=0;
const int Pot=34;
const int led1= 5;
const int led2= 18;
const int led3= 19;
const int led4= 21;
const int led5= 22;
int luminosidad =0;
void setup() {
  pinMode(Pot, INPUT);
  Serial.begin(9600);
  pinMode(led1, OUTPUT);
  pinMode(led2, OUTPUT);
  pinMode(led3, OUTPUT);
  pinMode(led4, OUTPUT);
  pinMode(led5, OUTPUT);
}

void loop() {
valorPot = analogRead(Pot);
int brilloled=map(valorPot,0,819,0,255);
int brilloled2=map(valorPot,819,1637,0,255);
int brilloled3=map(valorPot,1638,2456,0,255);
int brilloled4=map(valorPot,2457,3275,0,255);
int brilloled5=map(valorPot,3276,4095,0,255);
analogWrite(led1,brilloled);
Serial.println("valor potenciometro");
Serial.println(valorPot);
Serial.println("Valor brillo led 1");
Serial.println(brilloled);


analogWrite(led2,brilloled2);
Serial.println("valor brillo led 2");
Serial.println(brilloled2);

analogWrite(led3,brilloled3);
Serial.println("valor brillo led 3");
Serial.println(brilloled3);

analogWrite(led4,brilloled4);
Serial.println("valor brillo led 4");
Serial.println(brilloled4);

analogWrite(led5,brilloled5);
Serial.println("valor brillo led 5");
Serial.println(brilloled5);

}
