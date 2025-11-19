package ch15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortEx {

	public static void main(String[] args) {
		/*
		 배열 : Arrays.sort()
		 컬렉션 : Collections.sort()
		 
		 기본 자료형 : Arrays.sort(변수)
		 참조 자료형 : Arrays.sort(변수, Comparator 객체)
		 */
		//////////////////////////////////////////////////
		// 기본자료형 배열
		System.out.println("#######배열#######");
		int[] array = { 8, 1, 6, 2, 4 };
		Arrays.sort(array); // 정렬
		System.out.println("array : " + Arrays.toString(array));

		// 내림차순 안됨
		Integer[] array3 = { 8, 1, 6, 2, 4 };
		Arrays.sort(array3, Comparator.reverseOrder()); // 정렬
		System.out.println("array3 : " + Arrays.toString(array3));

		// 문자열 배열
		String[] array2 = { "서울", "광주", "제주", "대구" };
		Arrays.sort(array2); // 오름차순 정렬
		System.out.println(Arrays.toString(array2));

		// 내림차순 정렬
		Arrays.sort(array2, Comparator.reverseOrder());
		System.out.println(Arrays.toString(array2));
		
		System.out.println();
		//////////////////////////////////////////////////
		// 컬렉션

		List<Integer> list = new ArrayList<>();
		list.add(8);
		list.add(1);
		list.add(6);
		list.add(2);
		list.add(4);
		System.out.println("list : " + list);
		
		Collections.sort(list); // 오름차순
		System.out.println("list 오름차순 : " + list);
		
		Collections.sort(list, Comparator.reverseOrder()); // 내림차순
		System.out.println("list 내림차순 : " + list);
		System.out.println();
		/*
		 * 객체 정렬
		 * - Comparable 인터페이스를 구현 -> 번거로워서 잘 안씀
		 * - Comparator 인터페이스를 구현객체(익명구현객체, 람다식)
		*/
		
		// 커스텀 정렬
		// 리스트 안에 맵 객체
		// 맵 안에는 이름, 나이(나이순으로 정렬)
		List<Map<String, Object>> list2 = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("name", "홍길동");
		map.put("age", 20);
		list2.add(map);
//		map.put("name", "홍길동2");
//		map.put("age", 30);
//		list2.add(map);
//		map.put("name", "홍길동1");
//		map.put("age", 40);
//		list2.add(map);
//		for (Map m : list2) {
//			System.out.println(m); // map 안의 주소에 겹쳐버려서 마지막 값만 저장된다.
//		}
		
		map = new HashMap<>();
		map.put("name", "홍길동1");
		map.put("age", 10);
		list2.add(map);
		
		map = new HashMap<>();
		map.put("name", "홍길동2");
		map.put("age", 40);
		list2.add(map);
		System.out.println("기본 오름차순");
		for (Map m : list2) {
			System.out.println(m); // map을 새로 생성하므로 put이 잘 된다.
		}
		System.out.println();
		
		Collections.sort(list2, new Comparator<Map>() {
			@Override
			public int compare(Map o1, Map o2) {
//				return (int)o1.get("age") - (int)o2.get("age"); // 오름차순
				return (int)o2.get("age") - (int)o1.get("age"); // 내림차순
			}
		});
		
		System.out.println("age에 따른 오름차순");
		for(Map m : list2) {
			System.out.println(m);
		}
		System.out.println();
		
		// 2차원 배열
		int[][] array4 = {
				{1, 99}, {2, 98}, {3, 97}, {4, 96}
		};
		// 두번째 요소를 기준으로 오름차순
//		Arrays.sort(array4, new Comparator<int[]>() {
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				return o1[1] - o2[1];
//			}
//		});
		
		// 람다 표현식
		Arrays.sort(array4, (o1, o2) -> {
			return o1[1] - o2[1];
		});
		System.out.println("2차원 배열 오름차순 정렬");
		for (int[] a : array4) {
			System.out.println(Arrays.toString(a));			
		}
	}

}