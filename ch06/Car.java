package ch06;

public class Car {
		
		//필드 선언
		String company = "현대자동차";
		String model;
		String color;
		int maxSpeed;
		
		//static 블럭
		static {
			System.out.println("static 블럭 실행");
		}
		// instance 블럭
		{
			System.out.println("instance 블럭 실행");
		}
		
		//생성자가 없으면 기본 생성자(매개변수가 없는)가 자동으로 생성
		Car() {
			System.out.println("생성자 실행");
			
		}
		
		Car(String model){
			this.model = model;
		}
		
		Car(String model, String color){
			this.model = model;
			this.color = color;
		}
		
		Car(String model, String color, int maxSpeed){
			this.model = model;
			this.color = color;
			this.maxSpeed = maxSpeed;
		}


}