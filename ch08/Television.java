package ch08;

public class Television implements RemoteControl {
	@Override
	public void turnOn() {
		System.out.println("tv를 켭니다.");
	}
}
