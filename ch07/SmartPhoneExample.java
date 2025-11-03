package ch07;

public class SmartPhoneExample {
	public static void main(String[] args) {
		//SmartPhone 객체 생성
		SmartPhone myPhone = new SmartPhone("갤럭시", "은색");
		
		//phone으로부터 상속받은 필드 읽기
		System.out.println("모델: "+ myPhone.model);
		System.out.println("색상: "+ myPhone.color);
		
		System.out.println("와이파이 상태: "+ myPhone.wifi);
		
		myPhone.bell();
		myPhone.sendVoice("여보세요");
		myPhone.receiveVoice("안녕, 나는 남훈");
		myPhone.sendVoice("아~오키");
		myPhone.handUp();
		
		//SmartPhone 메소드 호출
		myPhone.setWifi(true);
		myPhone.internet();
	}
}
