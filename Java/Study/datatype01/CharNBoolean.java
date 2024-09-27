package datatype01;

public class CharNBoolean {

	public static void main(String[] args) {
		/* 
		 * 아스키 코드 : 1byte로 표현할 수 있는 문자 (영문자, 숫자)
		 * 십진수로 정의한 값을 아스키 코드라 함
		 * ex) A =65(1000001), a =97
		 * 
		 * 유니코드 : 1byte로 표현이 안되는 문자 (한글, 한자 등) -> 2byte는 필요함
		 * -> u16진수로 정의한 값 = '유니코드'
		 */
		
		// 1. Charater형, 문자형
		
		/*	1-1) "□"(double quotation)는 String Type */
		//char ch1="가";	// "가" is String type
		//char ch1=(char)"가";	//cannot convert String to char
			//기본 자료형과 참조형은 서로 형변환이 불가, 메모리 구조가 다르기 때문
			//char는 '□'(single quotation)으로 감싸기
		
		
		/*	1-2) '□□' 불가, 문자는 반드시 하나 */
		//char ch1='가나';
		
		char ch1='가';
		System.out.println("ch1 = "+ch1);
				
		/* 1-3) char형과 int형 연산결과는 int형 */
		char ch2 = 'A';
		int num1 = 2;
		System.out.print("ch2 + num1 = ");
		//char ch3 = ch2+num1; //문자형(1byte) = 문자형(1byte) + 정수형int(4byte)
		System.out.println(ch2+num1);
		//연산에 참여시 코드 값으로 참가
		// 1-3) a.int형에 담기
		int num2 = ch2+num1;
		System.out.println("num2 : "+num2);
		// 1-3) b.연산결과 전체를 char으로 형변환
		char ch3 = (char)(ch2+num1);
		System.out.println("ch3 : "+ch3);
		System.out.println("num2를 char형으로 변환 : "+(char)num2);
		
		/* 1-4) 문자의 코드 값 알아보기 */
		System.out.println("A = "+(int)'A');
		System.out.println("'가'라는 문자를 코드값으로 변환 = "+(int)'가');
		System.out.println("65 코드값은 "+(char)65);
		System.out.println("");
		// (int)문자 = 아스키/유니코드 값
		// (char)숫자 = 해당 코드값의 문자
		
		
		/* 2. char형에 데이터 저장하는 방법 */
		 // 	(1) ''으로 감싸서 하나의 문자로 저장
		 // 	(2) 십진수 혹은 16진수로 저장
		 // 	(3) \\u16진수 형태의 값을 저장할 수 있음
		 //		(4) 십진수로 저장하는 경우 그 숫자는 아스키 코드/유니코드 값이 됨.
		
		/* 2-1) int형 상수 자동 변환 저장 (2024/03/21) */
		char ch4 = '1'; // 문자 '1'의 코드값은 49
		char ch4_1 = 49; // 49(정수)는 int형 상수, 에러 안나는 이유 : 자동으로 변환되기 때문(부호가 없는 2byte로)
		System.out.println("ch4는 " + ch4 + "이고, ch4_1도 " + ch4_1);
		
		char ch5='가';
		char ch5_1=44032; //44032는 16진수로 AC00로 변경가능
		char ch5_2=0xAC00; // == 44032
		char ch5_3='\uAC00'; // 'single quotation'안에서 AC00이 유니코드라는 것을 나타내기 위해 \\u 추가
		// \\u하는 이유는 \하나만 붙이면 이스케이프 문자 발동
		System.out.println("ch5 = " +ch5+",ch5_1 = " + ch5_1+", ch5_2="+ ch5_2+", ch5_3="+ ch5_3);
		
		/* 3. Boolean */
		
		//boolean b1 =100; //boolean은 true/false값만 들어가야 함
		boolean b1 = true;
		boolean b2 = false;
		
		// 3-1) 산술연산 불가
		//System.out.println(b1+b2);
		//'the operator + is not defined' = boolean과 boolean은 더할 수 없다.
		//System.out.println(b1>b2);
		//'the operator > is not defined'
		
		// 3-2) 논리 연산 가능
		System.out.println(b1&&b2);
		boolean b3 = '가' >30000; //'가'는 char형, 연산에 참여시 코드 값으로 연산에 참여 -> 44032값으로 연산 참여 -> true
		System.out.println(b3);
				
	}	//main

}	//class
