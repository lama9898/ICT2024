package stringclass11;

class A{}
class B{}

public class StringBasic {

	public static void main(String[] args) {
		int num1 = 20, num2 =20;
		String strResult = num1==num2?"데이터의 같다":"데이터가 다르다";
		System.out.println(strResult);
		
		// ■ 1. 값(데이터) 비교
		/*	- 기본 자료형에서의 ==는 실제 저장된 값을 비교하는 비교 연산자
		 * 	- 참조형에서의 ==는 주소 비교이다 (같은 클래스 타입끼리만 비교가능)
		 */
		
		// ◆ 1-1) 인스턴스 비교
		A a = new A();
		B b = new B();
		//	strResult = a==b?"데이터의 같다":"데이터가 다르다";	// 실행불가! 클래스 타입이 다르기 때문
		
		A a1 = new A();
		strResult = a==a1?"데이터의 같다":"데이터가 다르다";
		System.out.println(strResult);
		System.out.printf("a : %s, a1 : %s\n",a,a1);
		System.out.println("a, a1 equals : "+ a.equals(a1));
		
		//	a = b; 	// 클래스 타입이 다르기 때문에 대입연산(+형변환)도 불가
		// 단 타입이 다르더라도 두 클래스간의 상속관계가 존재하면 대입 및 형변환 가능
		
		a = a1;
		strResult = a==a1?"데이터의 같다":"데이터가 다르다";
		System.out.println(strResult);
		System.out.printf("a : %s, a1 : %s\n",a,a1);
		
		// ■ 2. 타입이 다르더라도 주소 비교 가능 : equals() 메소드 사용
		strResult = a.equals(b) ? "주소가 같다":"주소가 다르다";
		System.out.println(strResult);
		System.out.printf("a:%s, b:%s\n", a,b);
		
		String str1 = new String("Tomato");
		String str2 = new String("Tomato");
		System.out.println("--- new 연산자 사용 ---");
		System.out.println("1. == 주소로 비교시 "+ (str1==str2));
		System.out.println("2. equals( )로 비교시 "+ str1.equals(str2));
		// string 문자열 비교시 무조건 equals() 메소드 사용!
		/*
		 * String 클래스에서 실제 저장된 문자열 비교시에는 equals() 메소드 사용 (==불가)
		 * 
		 * String 클래스에서 Object클래스의 equals()메소드를 주소값 비교가 아닌 실제 저장된 문자열 값을 비교하도록 오버라이딩 해놓음
		 * Object 클래스의 equals() 메소드는 원래 타입이 다르더라도 두객체 간의 주소 비교를 하는 메소드
		 */
		
		
		String str6 = "Hello";
		String str7 = "Hello";
		System.out.println("--- 문자열 생성 new없이 ---");
		System.out.println("1. == 주소로 비교시 "+ (str1==str2));	//true
		System.out.println("2. equals( )로 비교시 "+ str1.equals(str2));	//true
		
		//대소문자 구분 없이 비교할 때
		System.out.println("--- 문자열의 대소문자 구분 ---");
		str7 = "hello";
		System.out.println("1. == 주소로 비교시 "+ (str1==str2));
		System.out.println("2. equalsIgnoreCase( )로 비교시 "+str6.equalsIgnoreCase(str7));
		
		// Wrapper 클래스처럼 String 클래스에서도 Object 클래스의 toString() 메소드를
		// 메모리 주소가 아닌 실제 저장된 문자열을 반환하도록 오버라이딩 해 놓음
		String str8 = new String("자바");
		String str9 = "자바";
		System.out.println(str8);// 원래 주소가 나와야하는데, 값이 나옴
		System.out.println(str8.toString());
		System.out.println("== 주소로 비교시 "+ (str8==str9));
		
		
	}

}
