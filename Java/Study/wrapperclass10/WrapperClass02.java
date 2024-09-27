package wrapperclass10;

import java.util.Scanner;

public class WrapperClass02 {

	public static void main(String[] args) {
		/*	■ 1. Integer Wrapper 클래스의 주요 메소드
		 * 1-1) 숫자형식의 문자열을 숫자로 변경 : "94" → 94
		 * 		static int parseInt(String s);
		 * 		static Integer valueOf(Sting s);
		 * 			- valueOf.~~~.~~ 식으로 메소드를 이을 수 있음 : "메소드 체인"
		 */
		
		String strNumber = "1000";
		System.out.println("10 + strNumber ="+ (10+strNumber));
		System.out.println("strNumber를 숫자로 변경(parseInt 이용해서): "+ (10+Integer.parseInt(strNumber)));
		System.out.println("strNumber를 숫자로 변경(valueOf 이용해서): "+ (10+Integer.valueOf(strNumber)));
		
		// 1-2)
		Scanner sc = new Scanner(System.in);
		//System.out.println("나이를 입력하세요");
		// 1-2)a. nextInt로 입력받는 경우
		//int age = sc.nextInt();
		// 실수로 int가 아닌 값을 입력하면 에러 : java.util.InputMismatchException
		
		//System.out.println("당신의 10년 후 나이는 "+(age+10));
		
		
		// 1-2)b. nextLine()으로 입력받는 경우
		//String strAge = sc.nextLine();
		
		//System.out.println("당신의 10년 후 나이는 "+(Integer.parseInt(strAge)+10));
		//System.out.println("당신의 10년 후 나이는 "+(Integer.valueOf(strAge)+10));
		// 실수로 int가 아닌 값을 입력하면 에러 :  java.lang.NumberFormatException

		// Auto Boxing
		
		// Integer.parseInt(strNumber). 불가
		Integer numObj =Integer.parseInt(strNumber);
		System.out.println("문자열(strNumber) 1000을 byte형 값으로 변경(parseInt) : "+ numObj.byteValue());
		// Integer.valueOf(strNumber). 가능
		System.out.println("문자열(strNumber) 1000을 byte형 값으로 변경(valueOf) : "+ Integer.valueOf(strNumber).byteValue());
		
		
		// 1-3)
		String money = "일억원";
		//Integer.parseInt(money);	// 실행시에 java.lang.NumberFormatException 에러 발생, valueOf도 동일
		String floatString = "3.14";	//'.'때문에 숫자형식이 아님
		//Integer.parseInt(floatString);// 실행시에 java.lang.NumberFormatException 에러 발생
		
		System.out.println(Double.parseDouble(floatString));
		// 실수형태(소수점이 포함된) 문자열을 실수로 변경시 : Float / Double 타입 사용
		System.out.println(Float.parseFloat(floatString));
		
		
		// ■ 2. 숫자를 문자열로 변경하기
		// static String toString(int i);	:클래스명으로 접근
		// String toString();	:인스턴스 변수로 접근
		// Overloading
		
		int num2 = 1000;
		// num2에 저장된 숫자 1000을 문자열 "1000"으로 변경하기
		
		// 2-1)a. 정적 메소드 사용
		System.out.println(Integer.toString(num2)+10);
		// 2-1)b. 인스턴스 형 메소드 사용
		// auto boxing needed
		Integer intObj2 = num2;
		System.out.println(intObj2.toString()+10);
		
		
		// ■ 3-1. 2진수 / 8진수 / 16진수 문자열을 10진수로 바꿀 때
		// static int parseInt(String s, int radix)
		// static Integer valueOf(String s, int radix)
		
		System.out.println("이진수 형태의 문자열 1000을 십진수로: "+Integer.parseInt(strNumber,2));	// 2진수 형태
		System.out.println("이진수 형태의 문자열 1000을 십진수로: "+Integer.parseInt(strNumber,8));	// 8진수 형태
		System.out.println("이진수 형태의 문자열 1000을 십진수로: "+Integer.parseInt(strNumber,16)); // 16진수 형태
		
		// ■ 3-2. 10진수를 2진수 / 8진수 / 16진수로
		System.out.println(Integer.toHexString(15));
		// a =10, b=11, c=12, d=13, e= 14
	
		
		
	}

}
