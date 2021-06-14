int redPin = 13;
int bluePin = 12;

void setup() {
  pinMode(redPin, OUTPUT);
  pinMode(bluePin, OUTPUT);

}

void loop() {
  //digitalWrite(redPin, HIGH);
  //digitalWrite(bluePin, HIGH);
  digitalWrite(redPin, HIGH);
  delay(500);
  digitalWrite(redPin, LOW);

  digitalWrite(bluePin, HIGH);
  delay(500);
  digitalWrite(bluePin, LOW);

}
