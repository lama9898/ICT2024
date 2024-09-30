package lambda27;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MajorMethodOfStream {

	public static void main(String[] args) {
		// 스트림객체.map(람다식) : 스트림의 각 요소를 람다식을 적용해 변경하는 함수
		System.out.println("[ 스트림 객체의 주요 메소드 ]");
		System.out.println("1.map() 메소드");
		//Stream.of(new Integer[] {1,2,3,4,5});//Stream Integer 반환
		IntStream stream = IntStream.rangeClosed(1, 5);
		/*
		stream.map(new IntUnaryOperator() {
			// 익명 클래스로 람다식 표현을 위한 추상메소드 확인, 온라인 API에서 IntUnaryOperator검색
			@Override
			public int applyAsInt(int operand) {
				
				return 0;
			}
		});
		*/
		// 해당 추상메소드를 람다식으로 구현하기
		stream.map(x->x*x).forEach(System.out::println);
		//         중간연산   최종연산
		
		System.out.println("2.reduce() 메소드"); //reduce() : 최종연산
		// reduce(람다식): 스트림의 요소를 줄이는 함수
		/*
		IntStream.range(1, 6).reduce(new IntBinaryOperator() {
			
			@Override
			public int applyAsInt(int left, int right) {
				// TODO Auto-generated method stub
				return 0;
			}
		}); // 인자 2개 받아서 반환값은 하나
		*/
		//해당 추상메소드를 람다식으로 구현하기
		System.out.println(IntStream.range(1, 6).reduce((x1,x2)->x1+x2));
		//					  Optional int반환 -> .찍어보기
		// 출력 : OptionalInt[15] <- 주소는 아님. 누적합 15가 나옴
		System.out.println(IntStream.range(1, 6).reduce((x1,x2)->x1+x2).getAsInt());
		
		System.out.println("3.limit() 메소드");
		// limit(long maxSize) : maxSize 까지의 요소를 stream으로 생성
		IntStream.rangeClosed(5, 10).limit(3).forEach(System.out::println); // 5 6 7 8 9 10 -> 5 6 7
		
		System.out.println("4.skip() 메소드");
		// skip(long n): 스트림의 최초 요소부터 설정한 요소 수까지를 제외하고 새로운 stream 생성
		IntStream.rangeClosed(5, 10).skip(3).forEach(System.out::println); // 5 6 7 8 9 10 -> 8 9 10
		
		System.out.println("5.distinct() 메소드");
		// distinct() : 중복값 제거 후 새로운 스트림을 반환(요소들 중 같은 값을 가지는 요소가 있으면 그중 하나만 남기고 나머지는 제거)
		Stream<Integer> listStream = Arrays.asList(1,2,5,4,2,3,2,5,1,1).stream();
		listStream.distinct().sorted().forEach(x->System.out.println(x));
		
		System.out.println("6.filter() 메소드");
		// filter(람다식) : 조건을 만족하는 요소(조건 true에 해당하는 요소)만으로 새로운 stream 생성
		/*
		IntStream.rangeClosed(1, 10).filter(new IntPredicate() {
			
			@Override
			public boolean test(int value) {
				// TODO Auto-generated method stub
				return false;
			}
		})
		*/
		IntStream.rangeClosed(1, 10).filter(x->x%2==0).forEach(System.out::println);
		
		System.out.println("7.count() 메소드");
		//long count(): Stream의 요소 개수 반환
		System.out.println(IntStream.rangeClosed(9, 999).filter(x->x%2!=0).count());
		
		System.out.println("8.sum() 메소드"); // 각 요소의 총합 반환
		// sum(): Stream의 요소 총합 반환
		System.out.println(IntStream.rangeClosed(1, 10).filter(x->x%2==0).sum());
		
		System.out.println("9.max() 메소드"); // 각 요소의 총합 반환
		// OptionalInt max(),min(): Stream의 요소 최대/최소 값 반환
		System.out.println(IntStream.rangeClosed(1, 10).max().getAsInt());
		System.out.println("10.min() 메소드"); // 각 요소의 총합 반환
		System.out.println(IntStream.rangeClosed(1, 10).min().getAsInt());
		
		System.out.println("11.findAny() 메소드");
		// OptionalInt findAny() : 랜덤하게 스트림의 요소 반환, 비어있으면 Optional Int 반환
		// 랜덤하지만 1반환. findFirst 사용 추천
		System.out.println(IntStream.rangeClosed(1, 10).findAny().getAsInt());
		
		System.out.println("12.findFirst() 메소드");
		// OptionalInt findFirst() : 스트림의 첫번째 요소 반환, 비어있으면 Optional Int 반환
		System.out.println(IntStream.rangeClosed(1, 10).findFirst().getAsInt());
		
		System.out.println("13.collect() 메소드");
		// R collect(java.util.stream.Collectors) : 주로 스트림의 요소들을 하나의 문자열로 변환하거나 컬렉션으로 변환할 때 이용 
		// R은 Type parameter가 인자로 전달된 값에 따라 R의 타입이 결정된다
		// 스트림 요소를 수집해서 변환
		// collect도 대표적인 최종연산 메소드
		
		//문자열 스트림을 String으로 변환
		String streamToString = Arrays.asList("블","루","베","리").stream().collect(Collectors.joining(","));
		System.out.println(streamToString);
		//System.out.println(Arrays.asList("블","루","베","리").stream().sorted().collect(Collectors.joining(",")));
		
		//문자열 스트림을 List컬렉션으로 변환 ( List<String> )
		List<String> streamToCollection = Arrays.asList("블","루","베","리").stream().collect(Collectors.toList());
		for(String s:streamToCollection) System.out.println(s);
		
		
		//<Integer> Integer java.util.stream.IntStream.collect(
		// Supplier<Integer> supplier,
		// ObjIntConsumer<Integer> accumulator,
		// BiConsumer<Integer, Integer> combiner)
		
		/*
		 	R result = supplier.get();
		 	for (int element : this stream)
		 		accumulator.accept(result,element);
		 	return result;  
		  
		 */
		
		Integer result = IntStream.rangeClosed(1, 10).collect(new Supplier<Integer>() {
			@Override
			public Integer get() {
				return 10;
			}
		}, new ObjIntConsumer<Integer>() {
			//위의 get return 이 valuePassedBySupplierdp 에 대입
			//rangeclosed 1~10 이 elementofStream에 대입
			@Override
			public void accept(Integer valuePassedBySupplier, int elementofStream) {
				System.out.println("valuePassedBySupplier: "+valuePassedBySupplier
						+", elementofStream: "+elementofStream);
				
			}
		}, new BiConsumer<Integer, Integer>() {
			@Override
			public void accept(Integer valuePassedBySupplier1, Integer valuePassedBySupplier2) {
				// 단일 스레드일 경우 실행X, 다중 스레드일 경우 결과값 합침
				System.out.println("valuePassedBySupplier1: "+valuePassedBySupplier1
						+", valuePassedBySupplier2: "+valuePassedBySupplier2);
			}
		});
		System.out.println(result);
		IntStream.rangeClosed(1, 10).collect(()->0,(r,value)->r.compareTo(value),(result1,result2)->result1.equals(result2));
		//                                                     
		
		// boxed : Returns a Stream consisting of the elements of this stream,each boxed to an Integer. 
		//		   스트림 요소가 기본 자료형(int,boolean,char 등) 타입일 때 이를 boxing해서 wrapper 클래스 타입으로 변환하는 메소드
		//									(Integer,Boolean,Character)
		
		
		// 문제] 1~100까지 숫자 중 50이상이고 홀수이면서 5의 배수인 수의 합을 구하라
		// 람다식, 스트림 이용
		// range.filter.sum
		System.out.println("[스트림 미사용]");
		int sum=0;
		for(int i=1;i<=100;i++) {
			if(i>=50 && i%5==0 && i%2!=0)
				sum+=i;
		}
		System.out.println(sum);
		System.out.println("[스트림 사용]");
		System.out.println(IntStream.rangeClosed(1, 100).filter(x->x>=50 && x%2!=0 && x%5==0).sum());
		//System.out.println(IntStream.rangeClosed(1, 100).skip(49).filter(x->x%2!=0&&x%5==0).sum());
		//System.out.println(IntStream.rangeClosed(1, 100).filter(x->x>=50).filter(x->x%2!=0).filter(x%5==0).sum());
		
		
		
		
		
		
		
		
	} // main

} // class
