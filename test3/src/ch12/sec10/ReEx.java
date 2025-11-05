package ch12.sec10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReEx {

	public static void main(String[] args) {
//		boolean result = Pattern.matches("b[a-z]*", "bat");
//		System.out.println(result);
		
		Pattern p = Pattern.compile("b[a-z]*");
		Matcher m  = p.matcher("bat");
		System.out.println(m.matches());
		System.out.println(p.matcher("bed").matches());
		
		String source = "안녕하세요 저는 홍길동인데요, 제 번호는 010-8958-4225. 제 친구 번호는 02-0292-1111";
		p = Pattern.compile("(0\\d{1,2}) - (\\d{3,4}) - (\\d{4})");
		
		m = p.matcher(source);
//		System.out.println(m.matches());
		while (m.find()) {
			System.out.println(m.group());
		}
	}
}
