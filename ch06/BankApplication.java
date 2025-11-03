package ch06;

import java.util.Scanner;

// 이 부분 생각못함
public class BankApplication {
	public static void main(String[] args) {
		/*
		 Scanner
		 배열 [100]
		 while
		 	출력
		 	숫자입력
		 	1이면
		 		계좌번호, 계좌주, 초기입금액 입력
		 		Account 객체 생성
		 		배열에 저장
			2이면
				배열의 전체 계좌를 출력
			3이면
				계좌번호 입력받고, 예금액 입력 받아서
				해당 계좌 번호의 잔액에서 +.
			4이면 
				계좌번호 입력받고, 예금액 입력 받아서
				해당 계좌 번호의 잔액에서 -.
			5이면
				종료.

		*/
		Scanner scan = new Scanner(System.in);
		Account[] accounts = new Account[100];
		int index = 0; //길이이자 다음 저장할 인덱스 
		
		while (true) {
			System.out.println("--------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금| 4.출금 | 5.종료" );
			System.out.println("--------------------------------------------");
			System.out.println("선택> ");
			String num = scan.nextLine();
								
			if("1".equals(num)) {
				System.out.println("---------");
				System.out.println("계좌생성" );
				System.out.println("---------");
				System.out.println("계좌번호: ");
				String number = scan.nextLine();
				System.out.println("계좌주: ");
				String owner = scan.nextLine();
				System.out.println("초기입금액: ");
				int money = Integer.parseInt(scan.nextLine());
				Account account = new Account(number, owner, money); // 객체생성(초기화)
				//배열에 저장
				accounts[index++] = account;
//				
//				System.out.println(account.getNumber());
//				System.out.println(account.getOwner());
//				System.out.println(account.getBalance());
				
			} else if ("2".equals(num)) {
				System.out.println("---------");
				System.out.println("계좌목록" );
				System.out.println("---------");
				for (int i=0; i<index; i++) {
					System.out.println(accounts[i].getNumber()+"\t"
										+accounts[i].getOwner()+"\t"
										+accounts[i].getBalance());
					
				}
			} else if ("3".equals(num)) {
				System.out.println("---------");
				System.out.println("예금" );
				System.out.println("---------");
				System.out.println("계좌번호: ");
				String number = scan.nextLine();
				System.out.println("예금액: ");
				int money = Integer.parseInt(scan.nextLine());
				for (int i=0; i<index; i++) {
					if (accounts[i].getNumber().equals(number)) { //입력한 계좌번호 배열의 i번쨰의 계좌번호랑 같은지
						//예금 + 
						accounts[i].setBalance(accounts[i].getBalance() + money);
					}
				}
			} else if ("4".equals(num)) {
				System.out.println("---------");
				System.out.println("출금" );
				System.out.println("---------");
				System.out.println("계좌번호: ");
				String number = scan.nextLine();
				System.out.println("출금액: ");
				int money = Integer.parseInt(scan.nextLine());
				for (int i=0; i<index; i++) {
					if (accounts[i].getNumber().equals(number)) { //입력한 계좌번호 배열의 i번쨰의 계좌번호랑 같은지
						//출금 - 
						accounts[i].setBalance(accounts[i].getBalance() - money);
					}
				}
				System.out.println("결과: 계좌가 생성되었습니다.");
			} else if ("5".equals(num)) {
				System.out.println("프로그램 종료");
				break;
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		}
	}
}
