package cho4.sec04;

public class PrintFrom1To10Example {
	public static void main(String[] args) {
		int i;
		int sum = 0;
		for(i = 1; i<=100; i++) {
			System.out.println(i);
			sum += 1;
		}
		System.out.println(sum);
		
		//구구단
		//중첩반복문
		//2단 출력
		int j;
		for(i = 2; i <= 9; i++) {
			for(j=1; j <= 9; j++) {
				int result;
				result = j * i;
				System.out.println(i + "*" + j + "=" + result);
			}
		}
		
		
		
	}
}
