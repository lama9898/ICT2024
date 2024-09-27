package datatype01;

public class StringType {

	public static void main(String[] args) {
		/*	1. String형(문자열, > 참조형)	*/
		/*	- 기본자료형이 아님. 문자열을 저장할 수 있는 데이터 타입.	 ※클래스도 결국 자료형(Data Type) 중 하나
		 *  - 자바에서 문자열을 나타낼때는 " "(double quotation)으로 감싼다.
		 *  - '+'는 숫자 연산에 사용될 때는 [더하기]를 의미, but 문자열에 사용될 때는 [문자열 연결](concatenating)을 의미
		 */
		
		// 1-1) 참조형과 기본 자료형 사이에 형변환(Type Casting) 불가
		int number = 99;
		//type mismatch : int를 String에 넣을 수 없음
		
		// 1-1)a.
		//String strNumber = number;	//불가
		//String strNumber = (String)number;	//불가
		// 1-1)b.
		//int initNum = (int)"100";	//불가
		
		String strNumber ="100";
		System.out.println("strNumber(String) + number(int) :" + strNumber + number); // 출력시 : "10099"
		
		// 1-2) String 변수 선언
		// 1-2)a. new 연산자를 사용하여 문자열 저장
		String newString = new String("new 연산자 사용");
		// 1-2)b. 기본 자료형처럼 문자열 저장(new연산자 미 사용, 차이가 있긴 있음)
		String stringLikeBasic = "기본 자료형처럼 문자열 저장";
		System.out.println("new 연산자 사용 : "+ newString + ", String으로 변수 선언 : "+ stringLikeBasic);
		
		// 1-3) 문자열에서의 +의 의미 : 연결
		String plusString;
		plusString = newString + "," + stringLikeBasic;
		System.out.println("plusString : "+plusString);
		
		int kor = 100, eng=100, math=100;
		// 'Total score' + 100 + 100 + 100 => 'Total score100' + 100 + 100 ...
		System.out.println("Total score : " + kor + eng + math);
		// 'Total score' + (100 + 100 + 100) => 'Total score' + 300
		System.out.println("Total score : " + (kor+eng+math));
		

	}	//main

}	//class
