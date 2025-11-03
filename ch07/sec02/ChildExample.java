package ch07.sec02;

public class ChildExample {
	public static void main(String[] args) {
		//자식 객체 생성
		Child child = new Child();
		
		//부모타입의 변수에 자식 타입의 객체를 대입(자동타입 변환)
		Parent parent = child;
		
		//메소드 호출
		parent.method1(); //부모한테 있던 메소드
		parent.method2(); //부모도 있고, 자식도 있어 / 타입이 부모 (형변환된 경우 재정의된 메소드가 실행)
		//parent.method3(); 호출 불가능
		
		Child child2 = (Child)parent; //원래 child 였기 때문에 다시 child로 강제 형변환
	}
}
