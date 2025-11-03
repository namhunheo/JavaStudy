package ch05;

import java.util.Arrays;

public class ArrayEx {
	public static void main(String[] args) {
		String[] arr = {"하나", "둘", "셋"};
		System.out.println("개수:"+arr.length);
		System.out.println(arr[0]);
		//존재하지 않는 인덱스 접근근
//		System.out.println(arr[3]); ----> 이 배열은 해당되는 값이 없기 때문에 실행 시, 에러

		int[] scores = {80,90,87};
		int total = 0;
		for (int i=0; i<scores.length; i++) {
			total += scores[i];
		}
		//향상된 for문
		int total2 = 0;
		for (int score : scores) {
			total2 += score;
		}
		
		System.out.println(total);	
		System.out.println(total2);	
		
		double avg = (double)total / scores.length;
		System.out.println(avg);
		
		scores = new int[] {80,90,87}; //새로운(새주소) 배열 생성
		
		//값을 미리 지정하지 않는 경우
		int[] scores2 = new int[10]; //10개의 길이(요소) 배열 생성
		System.out.println(Arrays.toString(scores2));
		//기본값
		//기본자료형 : 0
		//침조자료형 : null
		int age;
//		System.out.println(age); //초기화 안하면 사용 불가
		ArrayEx ex = new ArrayEx();
//		System.out.println(ex.age);
		
		
		//메소드 실행
		print(scores); //매개값
		print(new int[] {1,2,3,4});

		
		//다차원 배열
		//2차원 배열 -> 배열 안에 배열
		int[][] matrix = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		System.out.println(matrix.length);
		System.out.println(Arrays.toString(matrix[0]));
		System.out.println(matrix[0][0]);
		int[] vector = matrix[0];
		System.out.println(vector[0]);
		//행렬(좌표)
		System.out.println(matrix[1][1]);
		
		//2차원 배열 모든 요소 출력
		//중첩 for문
		for (int i=0; i<matrix.length; i++) {
			for  (int j=0; j<matrix[i].length; j++) {
				System.out.println(matrix[i][j]);
			}
		}
		for (int[] m : matrix) {
			for (int n : m) {
				System.out.println(n);
			}
		}
		
		int[] newScores = new int[3];
		System.arraycopy(scores, 0, newScores, 0, scores.length);
		System.out.println(Arrays.toString(newScores));
		int[] scores3 = Arrays.copyOf(scores, scores.length);
		System.out.println(Arrays.toString(scores3));
	}
	
		

		
	
	//메소드 선언
	public static void print(int[] arr) { //arr -> 매개변수
		System.out.println(Arrays.toString(arr));
	}
	
}






































