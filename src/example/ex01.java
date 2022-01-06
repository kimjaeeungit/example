package example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


//Generic
//raw type 데이터의 정의
//interface
//추상화 정도가 추상클래스보다 심한 클래스
//추상메서드만 존재 상수만을 필드로 가진다
//anonymous class
//이름없는 클래스
//lambda
class Test {

}

interface MyInter {
	String method(int i);

}


public class ex01 {
	
	public static void m1(MyInter my) {
		
	}

	public static MyInter m2() {
		
		MyInter inter2 = new MyInter() {
			@Override
			public String method(int i) {
				return "" + i + i;
			}
		};
		return inter2;
	}

	public static MyInter m3() {
		return i -> i + "";
	}

	
	public static void main(String[] args) {
		/*MyInter inter = new MyInter() {
			@Override
			public String method(int i) {
				return i + i + "";
			}
		};*/
		MyInter inter =i -> i + i + "";
		
		m1(i->i+"");
		MyInter inter5 = m2();

		MyInter inter2 = new MyInter() {
			@Override
			public String method(int i) {
				return "" + i + i;
			}
		};
		

		MyInter inter4 = i -> i + i + "";

		MyInter inter3 = (i) -> i + "" + i;
		System.out.println(inter.method(10)); // 20
		System.out.println(inter2.method(10)); // 1010
		System.out.println(inter3.method(10));
		System.out.println(inter4.method(10));

		// ; >> statement
		// ;X >> expression
		
		
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				 System.out.println("multi 1");
			}
		});
		//수식
		//Thread thread = new Thread(() -> System.out.println("multi 1"));
		//문장
//		Thread thread = new Thread(() -> {System.out.println("multi 1");});
		

		thread.start();

		List<String> list = new ArrayList<>();
		list.add("3");
		list.add("4");
		list.add("5");

		// list 3,4,5
		List<Integer> list2 = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			list2.add(Integer.parseInt(list.get(i)));
		}
		System.out.println("list2" + list2);

		List<Long> list3 = list.stream().map(li -> {
			return Long.parseLong(li);
		}).collect(Collectors.toList());

		// List<Long> list4 = list.stream().map(new Function<String, Long>() {
		// @Override
		// public Long apply(String t) {
		// return Long.parseLong(t);
		// }
		// }).collect(Collectors.toList());
		List<Integer> list4 = list.stream().map(Integer::parseInt).collect(Collectors.toList());
		// Integer i1 = 10;
		// Integer i2 = 20;
		// System.out.println(i1.intValue()+i2.intValue());
		// long Long
		System.out.println(list3);
		list.forEach(t -> System.out.println(t));
		list.forEach(System.out::println);

		// Integer.parseInt("abcd");

		Comparator c = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		};
		
		
		list4.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		});
		System.out.println(list4);
		System.out.println("ab".compareTo("ae"));
		// 메서드 참조

		List<String> strList = Stream.of("a", "b", "z", "d", "ee", "ab", "ae").collect(Collectors.toList());

		System.out.println(strList);

		strList.sort((o1, o2) -> o2.compareTo(o1));
//		strList.sort(String::compareTo);
		Collections.sort(strList);
		System.out.println(strList);

	
	
			//배열
			int[] arr = {32,1,5,23};
	    	 	  //일반 for문
			for(int i = 0 ; i < arr.length ; i++) {
				System.out.println(arr[i]);
			}
			//향상된 for문
			for(int a : arr) {
				System.out.println(a);
			}
			//리스트
			List<Integer> list5 = Stream.of(10, 2, 3, 4).collect(Collectors.toList());
			//향상된 for문
			for(Integer i : list5) {
				System.out.println(i);
			}
			//forEach
			list.forEach(System.out::println);
	}

}
