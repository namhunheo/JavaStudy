package ch04.sec02;

public class Ex4 {
	public static void main(String[] args) {
		/*
		 반복
		 	주사위1
		 	주사위2
		 	주사위1 + 주사위2 == 5 ? 중지 아니면 반복
		 */
		while (true) {
			int score1 = (int)(Math.random()*6)+1;
			int score2 = (int)(Math.random()*6)+1;			
			System.out.println("("+score1+","+score2+")");
			if (score1+score2 == 5) break;
		}
	}
}