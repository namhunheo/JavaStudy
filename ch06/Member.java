package ch06;

public class Member {
	//필드  --- 필드는 상단에!
	int age = 30;
	
	//생성자
	Member() {
		
	}
	
	//메소드
	int add(int x, int y) {
		System.out.println(age);
		return x+y;
	}
}
