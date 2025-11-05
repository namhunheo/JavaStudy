package ch15.sec02.exam03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListEx {

	public static void main(String[] args) {
		List<Integer> alist = new ArrayList<>();
		List<Integer> llist = new LinkedList<>();
		
		for (int i=0; i<10000; i++) {
			alist.add(i);
			llist.add(i);
		}
		// ArrayList 실행시간
		long start = System.nanoTime();
		for (int i=0; i<alist.size(); i++) {
			alist.get(i);
		}
		long end = System.nanoTime();
		System.out.println("ArrayList: "+(end-start));
		
		//LinkedList 실행시간
		start = System.nanoTime();
		for (int i=0; i<alist.size(); i++) {
			llist.get(i);
		}
		end = System.nanoTime();
		System.out.println("LinkedList: "+(end-start));

	}

}
