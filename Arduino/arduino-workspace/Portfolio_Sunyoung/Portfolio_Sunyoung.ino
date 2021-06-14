int redPin1 = 8;
int redPin2 = 7;

void setup() {
  pinMode(redPin1, OUTPUT);
  pinMode(redPin2, OUTPUT);
}

void loop() {
  digitalWrite(redPin1, HIGH);
  delay(500);
  digitalWrite(redPin1, LOW);

  digitalWrite(redPin2, HIGH);
  delay(500);
  digitalWrite(redPin2, LOW);
}
