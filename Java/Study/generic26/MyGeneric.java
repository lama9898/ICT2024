package generic26;

import java.util.List;

public class MyGeneric<T> {
	//String s;
	private T field;
	//public static T staticField;	
	// 정적으로 만들수없기 때문에 에러, Cannot make a static reference to the non-static type T

	public T getField() {
		return field;
	}

	public void setField(T field) {
		this.field = field;
	}
	
//	public static void staticMethod(T param) {
//		//Cannot make a static reference to the non-static type T
		// 어떤 타입인지도 모르고 메모리를 줄수는 없기때문에 오류
//	}
	
	//static 없는 제너릭 메소드 : 인스턴스화 해서 인스턴스 변수로 호출
	public <T> T instanceGenericMethod(T...t) {
		
		//return field;// cannot convert from T to T. 
		// == MyGeneric<T>의 타입 파라미터인 T와 반환타입인 T는 무관!
		return t[t.length-1]; //배열의 마지막 요소 반환
	}
	
	//static이 붙은 제너릭 메소드 : 클래스명으로 접근해서 호출
	public static <T> T staticGerenericMethod(T ... t){
		for(T element:t) System.out.println(element);
		return t[0]; //배열의 첫번째 요소 반환
	}
	
	// 타입 제한하기
	// 일반 메소드로 타입 제한하기
	public static void generalMethod(List<? extends Number> numbers) {
		int total=0;
		for(Number number:numbers) {
			total+=number.intValue();
		}
		System.out.println("컬렉션에 저장된 요소의 총합 : "+total);
	}
	
	//위 generalMethod를 제너릭 메소드로 변환하기
	public static <T extends Number> void staticGeneralMethodForTypeRestrict(List<T> numbers) {
		// static <T extends Number> void의 <>안에서는 ? 쓰면안됌!
		int total=0;
		for(Number number:numbers) {
			total+=number.intValue();
		}
		System.out.println("컬렉션에 저장된 요소의 총합(제너릭 메소드) : "+total);
	}
	
	
}	//class MyGeneric
