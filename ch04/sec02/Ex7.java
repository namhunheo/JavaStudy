package ch04.sec02;

import java.util.Scanner;

public class Ex7 {
	public static void main(String[] args) {
		/*
		 반복
		 - 출력
		 - 입력
		 	- 입력값이 1이면 예금액 입력, 잔고+
		 	- 입력값이 2이면 출금액 입력, 잔고-
		 	- 입력값이 3이면 잔고 출력
		 	- 입력값이 4이면 종료
		 * */
		Scanner scanner = new Scanner(System.in);
		int balance = 0;
		while (true) {
			System.out.println("--------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("--------------------------");
			System.out.println("선택> ");
			
			String num = scanner.nextLine();
			if ("1".equals(num)) {
				System.out.println("예금액> ");
				int price = Integer.parseInt(scanner.nextLine());
				balance += price;
			} else if ("2".equals(num)) {
				System.out.println("출금액> ");
				int price = Integer.parseInt(scanner.nextLine());
				balance -= price;
			} else if ("3".equals(num)) {
				System.out.println("잔고> " + balance);
			} else if ("4".equals(num)) {
				System.out.println("프로그램 종료");
				break;
			}		
		}
	}
}
