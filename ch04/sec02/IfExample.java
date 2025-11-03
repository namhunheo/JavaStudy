package ch04.sec02;

public class IfExample {
	public static void main(String[] args) {
		int score = 87;
		
		if(score >= 90) {
			System.out.println("점수가 90보다 큽니다.");
			System.out.println("등급은 A입니다.");
		} else { 
			System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 B입니다.");
		}
		
		//주사위(눈이 6개), 1부터
		//int n = (int)(Math.rnadom()*개수) + 시작값;
		int n = (int)(Math.random()*6) + 1;
		System.out.println(n);
		
		//동전 앞/뒤면
		int n1 = (int)(Math.random()*2) + 1;
		System.out.println(n1);

	}
}














