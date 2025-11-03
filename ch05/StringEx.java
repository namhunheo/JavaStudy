package ch05;

import java.util.Arrays;

public class StringEx {
	public static void main(String[] args) {
		// String(문자열)은 immutable(불변임)
//		String msg = "안녕하세요";	
//		char a = msg.charAt(0);
//		System.out.println(a);	
//		
//		String msg2 = msg.replace("안", "언"); //새로운 객체
//		System.out.println(msg2);
//		System.out.println(msg);
		
		
//		//길이
//		System.out.println(msg.length());
//		
//		for (int i=0; i<=msg.length(); i++);
//			System.out.println(msg.charAt(i));
//		
//		
//		//substring (부분집합, 잘라내기)
//		System.out.println(msg.substring(0, 2));
//		System.out.println(msg.substring(2));
//		
//		//indexOf (위치 찾기, 특정 단어 포함여부)
//		System.out.println(msg.indexOf("하"));
//		//특정단어가 포함되어 있는지 여부(미포함시 -1)
//		if (msg.indexOf("욕") > -1) {
//			//포함 
//		}
//		//특정단어로 시작하는지 여부
//		if (msg.startsWith("안녕")) { // msg.indexOf("안녕") == 0
//			System.out.println("맞네?");
//		}
//		
//		//split 특정문자로 쪼개기
//		//예)csv: comma seperate value
//		String csv = "홍길동, 이순신";
//		//,로 구분해서 쪼개기(분리)
//		String[] arr = csv.split(",");
//		System.out.println(Arrays.toString(arr));
//		
		
//		String address = "	서울시	마포구	서교동1234	";
//		//공백제거
//		System.out.println(address.strip()); //좌우공백 제거
//		//모든공백제거
//		System.out.println(address.replace(" ", ""));
//		
//		
		
		
		System.out.println(System.currentTimeMillis());
		String fileName = "내사진.jpg";
		
		String ext = fileName.substring(fileName.indexOf("."));
		System.out.println(ext);
		String fileName2 = System.nanoTime() + ext;
		System.out.println(fileName2);
		
		
		//배열은 같은 데이터 타입만 사용 가능
		int[] arr2 = {1,2,3,4,5};
		arr2[0] = 6;
		System.out.println(Arrays.toString(arr2));
//		arr2[0] = "안녕";
		// 한번 생성된 배열의 길이는 늘리거나 줄일 수 없음.
		
		int[] arr3 = {1,2,3,4,5};
		int[] arr4 = {1,2,3,4,5};
		System.out.println(arr3 == arr4);
		int[]arr5 = arr3;
		System.out.println(arr5 == arr3);
		arr5[0] = 6;
		System.out.println(Arrays.toString(arr3));
		
		int x = 10;
		int y = x;
		y = 20;
		System.out.println(x);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
