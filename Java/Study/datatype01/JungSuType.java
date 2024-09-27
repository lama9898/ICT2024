package datatype01;

public class JungSuType {

	public static void main(String[] args) {
		/* 	원칙 1) 큰 자료형과 작은 자료형의 연산 결과는 큰 자료형을 따른다.
		 *  원칙 2) 같은 자료형끼리의 연산 결과는 같은 자료형이 된다.
		 *  예외 - int형보다 작은 자료형(byte, short, char)끼리의 연산 결과는 int형이다. == 적용이 X	*/
		
		/*	1. 기본 자료중 수치형에서도 정수형의 대표 자료형은 int */

		// 1-1) byte 범위 : -128 ~ 127
		byte b1;//변수 선언
		b1 = 127;// 초기화 최대127 까지 가능 
		System.out.println("b1 : "+b1);
		//b1 = 128;// 128은 int형 상수로 불가 : byte 범위 = -128 ~ 127
		b1 = (byte)128; // 강제 형변환 시 예상치 못한 -128 이라는 값이 저장됨
		System.out.println("b1 : "+b1);
		
		/*	2. int형보다 작은 자료형 자료형(byte, short, char)끼리의 연산 결과는 int형	*/
		byte b2 = 20,b3 = 30;
		//byte b4 = b2+b3;//변수+변수 값이 1비트단위를 넘어가는 값일수 있음.
		int num1 = b2+b3;//1바이트+1바이트를 4바이트에 담음.
		System.out.println("num1 :"+num1);
		byte b4 = (byte)(b2+b3);//바이트 변환하면 가능.
		System.out.println("b4 :"+b4);
		
		/*	3. int+int = int, long+int = long, long+long=long */
		int num2 = 100, num3 = 200;
		long ln1 = 1000,ln2 = 2000;
		num1 = num2 + num3;//int형 연산
		System.out.println("num1 :"+num1);
		long ln3 = ln1 + ln2;//long형 연산
		System.out.println("ln3 :"+ln3);
		
		// 3-3)a.int + int -> long 가능
		long num4 = (int)ln1 + num2; 
		// 3-3)b.long + int 후 int형으로 강제형변환
		num4 = (int)(ln1 + num2);
		// 3-3)c. long만 int형으로 형변환 후 int와 연산
		num4 = (int)ln1 + num2;
		
		// 3-4) long 뒤에 L로 int와 구분하기
		long ln4 = 2200000000L;
		System.out.println("ln4 :"+ln4);
		
		// 4. 숫자 앞에 0이 붙으면 8진수를 의미
		num4 = 0412;
		System.out.println("num4 :"+num4);
		
		// 5. 숫자 앞에 0x가 붙으면 16진수를 의미
		num4 = 0x10A;
		System.out.println("num4 :"+num4);
		System.out.println();
		
		
	}	// main

}	//class
