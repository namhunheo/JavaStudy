package ch12.sec05;

import java.awt.List;
import java.util.ArrayList;

public class StringBuilderEx {

	public static void main(String[] args) {
//		long start = System.currentTimeMillis();
//		String str = "";
//		for (int i=0; i<100000; i++) {
//			str += i;
//		}
//		long end = System.currentTimeMillis();
//		System.out.println("소요시간: "+ (end-start));

		// 소요시간: 2325
		
		long start = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<100000; i++) {
			sb.append(i);
		}
		long end = System.currentTimeMillis();
		System.out.println("소요시간: "+ (end-start));

		//소요시간: 3
		
//		int a = 10;
//		List list = new ArrayList();
//		list.add(a);
//		
//		Integer b = a;
//		int c = b;
//		
//		Long d= 30L;
//		int e = d.intValue();
	}

}
