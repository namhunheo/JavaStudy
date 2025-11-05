package ch13;

import java.util.ArrayList;
import java.util.List;

import test3.Member;

public class GenericEx {

	public static void main(String[] args) {
//		List list = new ArrayList();
//		list.add(1);
//		list.add(3.14);
//		list.add(new Member());
		
//		for (int i=0; i<list.size(); i++) {
//			System.out.println((Member)list.get(i).getName());
//		}
		List<Member> list = new ArrayList<Member>();
		list.add(new Member());
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getName());
		}
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(3);
		System.out.println(list2.get(0).longValue());
	}

}
