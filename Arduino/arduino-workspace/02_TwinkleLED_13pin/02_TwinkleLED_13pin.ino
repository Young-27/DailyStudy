int ledPin = 13;

void setup() {
  pinMode(ledPin, OUTPUT);
  
}

void loop() {
  digitalWrite(ledPin, HIGH); // 5V의 전류를 흘려보냄
  delay(1000); // 1초간 시간지연시키겠다. (1초동안 불들어옴)

  digitalWrite(ledPin, LOW); // 0V의 전류를 흘려보냄
  delay(1000); // 1초간 시간지연시키겠다. (1초동안 불꺼짐)
}
