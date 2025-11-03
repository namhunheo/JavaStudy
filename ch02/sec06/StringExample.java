package ch02.sec06;

public class StringExample {
	public static void main(String[] args) {
		String name = "홍길동";
		String job = "프로그래머";
		System.out.println(name);
		System.out.println(job);

		
		
		System.out.println("나는");
		System.out.println("자바를\n");
		System.out.println("배웁니다\n");
		
	
		System.out.println("나는 자바를 배웁니다\n");
		System.out.println("나는 \"자바를\" 배웁니다\n");
		System.out.println("나는\t자바를\t배웁니다\n");
		
		System.out.println("나는\t자바를\t배웁니다\n");
		String text = """
				나는
				자바를
				배웁니다.""";
		System.out.println(text);
		
		
		// 문자열도 연산
		String n = "홍길동";
		String n2 = n + "님";
		System.out.println(n2);
		String n3 = "3" + 1;
		System.out.println(n3);
		String n4 = "3" + String.valueOf(1);
		//자바에서는 문자 + 숫자 = 숫자가 문자로 형변환 
		// -> 응용하면 아래와 같음.
		int age = 10;
		String age2 = age + "";
		
		
		
		
		
		
	}
		
}










