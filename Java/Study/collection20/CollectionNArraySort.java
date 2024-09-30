package collection20;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
[배열이나 컬렉션(Only List계열만)에 저장된 객체(데이타) 정렬하기]
※단,배열의 타입 혹은 List계열 컬렉션에 저장된 객체의 타입은
 반드시 1.Comparable인터페이스를 상속받고 2.compareTo()메소드 오버라이딩(sort메소드 인자가 하나일때)
배열 정렬:
  오름차순(디폴트):
  		Arrays.sort(배열) - 이때 배열은 기본 자료형 타입의 배열이어도 상관없다
  		Arrays.sort(T[],Comparator<? super T>) - 참조형 타입의 배열이어야 한다. T는 Comparable이 구현 불필요
  		// T : 기본자료형X, 참조형만 허용
  내림차순:참조형 타입의 배열이어야 한다	 
  		Arrays.sort(T[],Collections.reverseOrder()) T는 Comparable 구현 필요
  		Arrays.sort(T[],Comparator<? super T>) T는 Comparable이 구현 불필요
컬렉션 정렬:
	오름 차순(디폴트):
		Collections.sort(List계열 컬렉션) List계열 컬렉션에 저장할 객체는 은 Comparable이 구현
		Collections.sort(List계열 컬렉션,[Comparator<? super T>]) List계열 컬렉션에 저장할 객체는 은 Comparable이 구현 불필요
	내림 차순:	
		Collections.sort(List계열 컬렉션,Collections.reverseOrder()) List계열 컬렉션에 저장할 객체는 은 Comparable이 구현
		Collections.sort(List계열 컬렉션,[Comparator<? super T>]) List계열 컬렉션에 저장할 객체는 은 Comparable이 구현 불필요
*/

public class CollectionNArraySort {

	public static void main(String[] args) {

		// 1. 정렬
		System.out.println("[Arrays클래스로 배열 정렬하기]");
		String[] names = {"홍길동","가길동","도길동","나길동","마길동"};
		
		// 1-1) 오름차순 정렬
		System.out.println("1. 오름차순으로 정렬");
		
		
		// 1-1) a.
		//Arrays.sort(names);	//원본 배열이 재배치 됨 : 'in-place 방식'
		
		// 1-1) b.
		Arrays.sort(names,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// 문자열일때는 compareTo, 숫자데이터는 -(빼기)하면 됨!
				return o1.compareTo(o2); // o2.compareTo(o1)는 내림차순
			}
		});//익명클래스
		
		for(String name:names)	System.out.println(name.toString());
		
		// 1-2) 내림차순 정렬
		System.out.println("2. 내림차순으로 정렬");
		// 1-2) a.
		//Arrays.sort(names,Collections.reverseOrder());
		
		// 1-2) b.
		Arrays.sort(names,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// 문자열일때는 comparTo, 숫자데이터는 -(빼기)하면 됨!
				return o2.compareTo(o1); // o2.compareTo(o1)는 내림차순
			}
		});
		
		for(String name:names)	System.out.println(name.toString());
		
		// 2. 유용한 메소드
		System.out.println("Arrays 클래스의 유용한 메소드");
		System.out.println("1. 배열의 요소들을 하나의 문자열([요소1,요소2,...])로 변환 : Arrays.toString(배열)");
		System.out.println(Arrays.toString(names));
		
		System.out.println("2. 배열을 List계열 컬렉션으로 변환 : Arrays.asList(T ... a)");
		List<String> list = Arrays.asList("홍길동","가길동","도길동","나길동","마길동"); //Arrays.asList(names);
		for(String s:list) {
			System.out.println(s);
		}
		
		System.out.println("3. List컬렉션을 배열로 변환: List컬렉션.toArray()");
		Object[] objArray = list.toArray();
		System.out.println(Arrays.toString(objArray));

		List<Integer> numbers = Arrays.asList(90,45,89,10024,68,298,54);
		System.out.println("1. 컬렉션 오름차순으로 정렬");
		// 1)
		Collections.sort(numbers);	// 반드시 List 타입
		
		// 2)
		Collections.sort(numbers,new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) { return o1-o2; } //오름, o2-o1 = 내림 
			
		});
		
		for(Integer number:numbers) {
			System.out.println(number);
		}

		System.out.println("2. 컬렉션 내림차순으로 정렬");
		// 1)
		//Collections.sort(numbers,Collections.reverseOrder());
		
		// 2)
		Collections.sort(numbers,new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) { return o2-o1; }
			
		});
	
		for(Integer number:numbers) {
			System.out.println(number);
		}

		//Collections Utility 클래스 미 사용
		//List컬렉션에도 객체 정렬을 위한 sort()가 jdk 8.0에서 추가
		//8.0 전에는 Collections Utility 클래스 사용하엿음
		numbers.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				//오름차순
				return o1-o2;	//== numbers.sort(Comparator.naturalOrder());
								// 단, 컬렉션에 저장된 타입의 Comparable 구현이 필수이다. 
				// 내림차순 : return o2-o1;	// == 
			}
		});
		
	}

}
