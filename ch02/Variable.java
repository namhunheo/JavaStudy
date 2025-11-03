package ch02;

public class Variable {
	public static void main(String[] args) {
		int age; // 정수타입의 age라는 이름의 변수를 선언
		//System.out.println(age); //미초기화 시, 사용불가
		
		//변수에 값을 대입(저장)
		//처음 대입 -> 초기화
		age = 10; //10이라는 값을 age(변수)에 대입연산
		//age = 3.14; //다른 타입은 대입 불가
		
		//선언과 대입(초기화) 동시
		//int grade = 4;
		
		//변수명 -> 의미있는 이름으로!
		//int a = 30; //나이 의미 포함 x
		//int age = 30; //나이 의미 포함 o
		
		//여러 의미를 갖는 경우
		//ex) 학생나이
		//int studentage = 20; //지저분하므로 x
		//카멜표기법
		//int studentAge = 20; 
		//스네이크 표기법
		//int student_age = 20;
		
		//회사직원이름
//		String companyEmployeeName = "홍길동"
//		System.out.println(companyEmployeeName)
		
		int 나이 = 10;
		
		byte a = 10;
		byte b = 10;
		// 연산이 일어나면 int로 바뀜
		//byte c = a + b;
		//byte d = age;
		//아래의 Type mismatch 에러가 뜨는 이유
		//: age는 int이기 때문에 byte와 충돌
	
		char e = 'A'; // 하나의 문자
		char g = 65;
		int f = e + 1;
		System.out.println(f);
		
		float h = 3.14F;
		float h2 = 3.14F;
		float j = h + h2;
		
		//문자열
		String n = "A";
		String n2 = ""; //빈문자열
		String n3 = " "; //공백문자열
		String n4 = null; //값자체가 없음
		
		// 결과 : true -> 문자자체가 같아서.
		String n7 = "홍길동";
		String n8 = "홍길동";
		System.out.println(n7 == n8);
		
		//클래스로 객체 생성
		// 결과 : false
		String n9 = new String("홍길동");
		String n10 = new String("홍길동");
		// 참조자료형은 주소값으로 비교
		System.out.println(n9 == n10);
	
		//문자열일때 값으로 비교
		//주소는 다르지만 값이 같으면 true
		System.out.println(n9.equals(n10));
		
	
	}
	
	
	
	
}
