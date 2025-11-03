//package ch05;
//
//import java.util.Scanner;
//
//public class Ex9 {
//	public static void main(String[] args) {
//		/*
//		 Scanner 객체 생성
//		 학생점수 배열 선언
//		 while
//		 	- 출력
//		 	1이면 
//		 		- 학생입력
//		 		- 학생수만큼 배열 초기화
//		 	2이면
//		 		- 배열개수만큼 반복 입력, 저장
//		 	3이면
//		 		- 배열 전체 출력
//		 	4이면
//		 		- 최고점수
//		 		- 평균 출력
//		 	5이면 종료
//		 */
//		Scanner scanner = new Scanner(System.in); //선언 + 초기화
//		int[] scores; //선언
//		while (true) {
//			System.out.println("--------------------------------------------");
//			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료" );
//			System.out.println("--------------------------------------------");
//			System.out.println("선택> ");
//			
//			String num = scanner.nextLine();
//			
//			if ("1".equals(num)) {
//				System.out.println("학생수> ");
//				int count = Integer.parseInt(scanner.nextLine());
//				scores += new int[count]; //초기화
//			} else if ("2".equals(num)) {
//				if (scores == null)
//					System.out.println("학생수를 먼저 입력하세요");
//					continue;
//				}
//				for  (int i=0; i<scores.length; i++)
//				
//				System.out.println("점수입력> ");
//				int scores = Integer.parseInt(scanner.nextLine());
//				scores += scores;
//			} else if ("3".equals(num)) {
//				
//			} else if ("4".equals(num)) {
//				int max_score = 0;
//				int total = 0;
//				for (int i=0; i<scores.length; i++) {
//					System.out.println("scores["+i+""]");
//					
//					
//					
//					
//				}
//			} else if ("5".equals(num)) {
//				
//			}
//		}
//		System.out.println("프로그램 종료");
//	}
//}
//
