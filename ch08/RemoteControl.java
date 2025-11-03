package ch08;

public interface RemoteControl {
	//추상메소드
	//public abstract
	void turnOn();
	
	//상수
	//public static final
	double PI = 3.14;
	
	// default 메소드 -> 일반 메소드
	// public
	default int add(int x, int y) {
		test2();
		return x+y;
	}
	
	//static 메소드(인터페이스명으로 직접 접근하여 사용)
	//public static
	static void test() {
		test3();
	}
	
	//////////////거의 사용 x
	//private (인터페이스 내부에서만 사용 가능)
	private void test2() {
		
	}
	private static void test3() {
		
	}
}
