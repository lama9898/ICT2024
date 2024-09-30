package lambda27;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamBasic {

	public static void main(String[] args) {
		System.out.println("[스트림 소스: 배열]");
		String[] mountains= {"한라산","지리산","덕유산","치악산","비슬산"};
		Stream<String> arrayStream =Arrays.stream(mountains);
		System.out.println("방법1 : 익명클래스 사용");
		arrayStream.forEach(new Consumer<String>() {
			@Override
			public void accept(String mountain) {
				System.out.println(mountain);
			}
		});
		System.out.println("방법2 : 람다식 사용");
		//최종 연산(forEach) 후 스트림응 닫힘 -> 고로 스트림 객체를 다시생성해야함.
		arrayStream = Arrays.stream(mountains);
		arrayStream.forEach(m -> System.out.println(m));
		
		System.out.println("방법3 : 메소드 참조연산자 사용");
		arrayStream = Arrays.stream(mountains);
		arrayStream.forEach(System.out::println);
		
		// Stream 객체의 메소드는 원본객체를 변형시키지 않음 immutable
		System.out.println("[Arrays.sort()로 정렬 : 원본데이터 변경]");
		//Arrays.sort(mountains);
		//for(String mountain:mountains) System.out.println(mountain);
		
		System.out.println("[스트림 객체.sorted()로 정렬 : 원본데이터 변경안됨]");
		System.out.println("-----오름차순----");
		arrayStream = Arrays.stream(mountains);
		arrayStream.sorted().forEach(System.out::println);
		System.out.println("-----내림차순----");
		arrayStream = Arrays.stream(mountains);
		/* 익명클래스사용
		 stringStream.sorted(new Comparator<String>() {
		 	@Override
		 	public int compare(String o1, String o2){
		 		return o2.compareTo(o1);
		 	}
		 	}).forEach(System.out::println();
		 */
		
		// 람다식 사용
		arrayStream.sorted((o1,o2)->o2.compareTo(o1)).forEach(System.out::println);
		
		
		System.out.println("---- 정럴 후 원본 출력 ----");
		for(String mountain:mountains) System.out.println(mountain);
		
		System.out.println("[스트림 소스 : 컬렉션");
		List<String> collections = Arrays.asList(mountains);
		//System.out.println("[Collections.sort()로 정렬: 원본 데이터 변경됨");
		//Collections.sort(collections);
		System.out.println("[스트림객체.sorted()로 정렬: 원본 데이타 변경 안됨]");
		
		//컬렉션 데이터로 스트림 생성
		Stream<String> collectionStream = collections.stream();
		//오름차순
		System.out.println("-----오름차순-----");
		collectionStream.sorted().forEach(System.out::println);
		
		//내림차순
		System.out.println("-----내림차순-----");
		collectionStream = collections.stream();
		collectionStream.sorted((o1,o2)->o2.compareTo(o1)).forEach(System.out::println);
		System.out.println("---- 정럴 후 원본 출력 ----");
		for(String mountain:collections) System.out.println(mountain);
				

		
	}

}
