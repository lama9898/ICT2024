package wrapperclass10;

/*
 * 		AutoBoxing ↔ AutoUnboxing
 * 
 * 	- 오토박싱, 오토 언박싱은 JDK 5.0 이상에서만 적용됨
 *  - wrapper 클래스와 기본 자료형과의 관계에서 나온 개념
 *  - 오토박싱 : 기본 자료형이 자동으로(Auto) 참조형(Wrapper 클래스)으로 바뀌는 것
 *  
 *  	ex) boxing int -> Integer
 *  	ex) unboxing Integer -> int
 */



public class WrapperClass01 {

	public static void main(String[] args) {
		// ■ 1. Wrapper 클래스 소개, 박싱
		//  1-1) a. JDK 1.4이전 버전에서의 코딩
		// JDK 9부터 new Integer(200)는 deprecated되었다.
		int num1 = 200;
		int num2 =20;
		int result = num1+num2;
		System.out.println("result : "+ result);
		
		Integer numObj1 = new Integer(200);	//num1과 같음
		Integer numObj2 = new Integer(20);
		//num1Obj는 주소 저장중...
		
		//  1-1) b. 
		// new Integer(200) 대신 Integer.valueOf(200)사용
		result = numObj1.intValue()+numObj2.intValue();
		System.out.println("result : "+ result);
		
		//  1-1) c. JDK 5.0 이후
		numObj1 = num1; // 4.0 이전은 에러 나는 코드
		
		
		//  ■ 2. 언박싱 Integer -> int
		int num3 = numObj1; // 4.0 이전은 에러 나는 코드
		Integer numObj3 = 300;
		/*
		 * Wrapper 클래스를 사용하는 이점 : 
		 * - Wrapper클래스 안의 여러 메소드 사용가능 ; 쉽게 정수를 이진수/8진수 ... 등으로 변환 가능
		 */
		
		// 2-1)
		System.out.println("int형 최대값 : "+Integer.MAX_VALUE);
		System.out.println("int형 최소값 : "+Integer.MIN_VALUE);
		System.out.println("num1을 8진수로 변환 : "+Integer.toOctalString(num1));
		System.out.println(0310);
		
		// 2-2)Unboxing
		/*
		 * 자바의 모든 클래스들은 Object라는 최상위 클래스로부터 상속을 받음
		 * Wrapper클래스들은 Object로부터 상속받은 toString()메소드를 오버라읻하여 인스턴스 변수 출력시 주소가 아니라 시제 저장한 값이 반환되도록 오버라이딩됨
		 */
		
		Integer remodel = new Integer(1004);
		System.out.println("remodel : "+remodel);
		System.out.println("remodel.toString() : "+remodel.toString());
		
		System.out.println("remodel : "+(remodel+1));
		System.out.println("remodel.toString() : "+(remodel.toString()+1));
		System.out.println("remodel의 클래스명 : "+ remodel.getClass().getName());
		System.out.println(remodel.hashCode());
		
		//원래 Object클래스의 toString() 메소드는 객체의 메모리 주소를 아래와 같은 문자열로 반환하도록 정의됨
		//(패키지명1.패키지명2...클래스명@16진수체계의 메모리주소)
		
		WrapperClass01 wc = new WrapperClass01();
		System.out.println("wc:"+wc);
		System.out.println("wc.toString():"+wc.toString());
		System.out.println(wc.hashCode());
		System.out.println("메모리 주소(10진수를 16진수로) :"+Integer.toHexString(wc.hashCode()));
		 
		
		// 1-2) 사람들이 wrapper 클래스를 만든이유
		Integer.toBinaryString(200);
		// num1. : 메소드 사용 불가, 기본자료형은 멤버 없음
		// numObj1. : 다양한 메소드 사용가능 
		
		// 1-3) 
		Integer numObject1 = Integer.valueOf(num1);	//static 메서드이므로 클래스명으로 접근
		System.out.println("num1(int)을 byte형 값으로 변환(Wrapper) : "+numObject1.byteValue());
		System.out.println("num1(int)을 byte형 값으로 변환(형변환) : "+(byte)num1);
		
		System.out.println("num1을 이진수로 변환 : "+Integer.toBinaryString(num1));
		System.out.println("num1을 이진수로 변환 : "+Integer.toHexString(num1));
		System.out.println("num1을 이진수로 변환 : "+Integer.toOctalString(num1));
		
		System.out.println("numObject1 : "+numObject1);
		System.out.println("numObject1.toString() : "+numObject1.toString());
	}

}
