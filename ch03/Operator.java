package ch03;

public class Operator {
	public static void main(String[] args) {
		int x = 1;
		++x; //전위연산
		System.out.println(x);

		int y = 1;
		y++;//전위연산
		System.out.println(y);
		int z = y++;
		System.out.println(y);
		
		
		int a = 11;
		int b = 4;
		int d = a % b;
		System.out.println(d);
		
		//대입연산
		int c = 10;
		c += 5; //5를 더하고 대입 -> c = c + 5
		
		System.out.println(c);
		
		// 삼항연산
		int score = 60;
		String result =  score >= 60 ? "합격" : "불합격";
		System.out.println(result);
		
		char grade = score >= 90 ? 'A' : score >= 80 ? 'B' : 'C';
		System.out.println(grade);
		
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		double area = ((double)((lengthTop+lengthBottom)*height/2));
		System.out.println(area);
		
		
		
	}
}






















