package generic26;

import java.util.Arrays;

import java.util.Date;

import console.academy.Student;

public class GenericApp {	// 제너릭 클래스가 아닌 일반 클래스

	//제너릭 메소드
	public static<T> T genericMethod(T param) {
		return param;
	}
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// 1. 제너릭 메소드 호출(메소드 사용)
		// 방법 1) <T>메소드명(인자) 호출시 타입에 맞는 데이터만 인자로 전달할 수 있다.
		//System.out.println(GenericApp.<Integer>genericMethod("제너릭"));
		// integer로 지정했기 때문에 integer만 넣어야함. 문자 불가, 컴파일시 타입체크
		System.out.println(GenericApp.<Integer>genericMethod(1004));
		
		System.out.println(GenericApp.genericMethod("제너릭")); //반환타입 String
		System.out.println(GenericApp.genericMethod(10004)); //반환타입 Integer
		System.out.println(GenericApp.genericMethod(new java.sql.Date(new Date().getTime())));//반환타입 Date
		
		System.out.println("-----------------------------------------");
		
		// 2. 제너릭 클래스 인스턴스화(클래스 사용)
		System.out.println("[타입 파라미터 미 지정]");
		MyGeneric rawType = new MyGeneric();	// 타입 파라미터 미 지정시 타입 파라미터 T는 Object 타입이 됨
		rawType.setField("not type parameter");
		Object field = rawType.getField();
		System.out.println("저장된 문자열 길이 출력"+((String)rawType.getField()).length());

		System.out.println("[타입 파라미터 지정]");
		//MyGeneric<T> genericType = new
		MyGeneric<Student> genericType = new MyGeneric<>();
		//genericType.setField("Type-Parameter");
		// 컴파일시 타입체크 가능, Student 타입만 가능함.
		genericType.setField(new Student("박일도",3000,"1234학번"));
		// object 타입이 아닌 student 타입이므로 형변환 불필요
		genericType.getField().print();
		
		System.out.println("-----------------------------------------");
		
		System.out.println("[인스턴스형 제너릭 메소드 호출]");
		//genericType.instanceGenericMethod(1,2,3,4,5);
		// <T> → List<Integer>
		System.out.println(genericType.instanceGenericMethod(Arrays.asList(1,2,3,4,5)));
		// <T> → List<Double>
		System.out.println(genericType.instanceGenericMethod(Arrays.asList(1.1,2.2,3.5,4.7,5.9)));
		
		System.out.println("[정적 제너릭 메소드 호출]");
		System.out.println(MyGeneric.staticGerenericMethod("토마토","블루베리","키위","바나나","오렌지","비트"));
		
		
		System.out.println("-----------------------------------------");
		System.out.println("[타입제한용 일반 메소드 호출]"); //-> 컴파일시 타입체크
		genericType.generalMethod(Arrays.asList(1,2,3,4,5));
		genericType.generalMethod(Arrays.asList(1.0,2.5,3.7,4.2,5.9));
		//genericType.generalMethod(Arrays.asList('a',2.5,'다',4.2,5.9));
		
		System.out.println("[타입제한용 정적 메소드 호출]"); //-> 컴파일시 타입체크
		MyGeneric.staticGeneralMethodForTypeRestrict(Arrays.asList(1,2,3,4,5));
		MyGeneric.staticGeneralMethodForTypeRestrict(Arrays.asList(1.0,2.5,3.7,4.2,5.9));
		//MyGeneric.staticGeneralMethodForTypeRestrict(Arrays.asList('a',2.5,'다',4.2,5.9));
		
	} //main

} //class Generic App
