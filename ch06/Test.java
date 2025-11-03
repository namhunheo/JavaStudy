package ch06;

import java.util.Scanner;

public class Test {
	public static  void main(String[] args) {
		Test t = new Test();
		int result = t.solution(5000,
				new int[] {10000, -13000, -4000, -2000, 6500, -20000});
		System.out.println(result);
	}
	
	public int solution (int m, int[] ledger) {
		int account = 0;
		m *= -1;
		for (int i=0; i<ledger.length; i++) {
			int temp = account + ledger[i]; //입금,출금액
			if (m <= temp) {
				account = temp;
			}
		}
		return account;
	}
}
