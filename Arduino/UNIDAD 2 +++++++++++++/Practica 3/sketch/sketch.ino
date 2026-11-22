const int led=18;
int luminosidad =0;

void setup() {
  pinMode(led, OUTPUT);
}

void loop() {
  for(luminosidad=0; luminosidad < 255; luminosidad ++)
{
  analogWrite(led,luminosidad);

  delay(30); 
}

  for(luminosidad=255; luminosidad > 0; luminosidad --)
{
  analogWrite(led,luminosidad);

  delay(30); 
}
}
