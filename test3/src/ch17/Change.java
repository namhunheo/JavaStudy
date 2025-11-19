package ch17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Change {

	public static void main(String[] args) {
		/*
		 배열 <-> 리스트 변환
		 */
		int[] array1 = {1,2,3};

		// List로 변환
		List<Integer> list1 = new ArrayList<>();
		for (int i=0; i<array1.length; i++) {
			list1.add(array1[i]);
		}
		System.out.println(list1);
		List<Integer> list2 = Arrays.asList( //list로 변환
				Arrays.stream(array1).boxed().toArray(Integer[]::new)); //Integer[] 배열
		System.out.println(list2);
		
		// 리스트를 기본자료형()
		int[] array2 = list1.stream().mapToInt(i->i).toArray();
		int[] array3 = new int[list1.size()];
		for(int i=0; i<array3.length; i++) {
			array3[i] = list1.get(i);
		}
		System.out.println(Arrays.toString(array3));
		
		//문자열(참조자료형)
		String[] array4 = {"김길동", "박길동", "홍길동"};
		List<String> list3 = Arrays.asList(Arrays.stream(array4).toArray(String[]::new));

		String[] array5 = list3.stream().toArray(String[]::new);
		System.out.println(Arrays.toString(array5));
	}

}
