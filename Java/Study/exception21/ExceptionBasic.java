package exception21;

import java.io.IOException;
import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 *  1. 컴파일 에러 "Checked Exception" :
 *    - 컴파일시 발생하는 에러(javac.exe)
 *    - Syntax에러(문법오류), IOException(예외 클래스), SQLException(예외클래스) 등
 *    - 컴파일이 안되면 실행이 안됨.
 *    - 컴파일 에러는 던지거나(throw) 직접 처리(try-catch)로 해결 
 *    	-- (외부 자원 시 발생하는 에러 : IOException, SQLException)
 *    	-- java 는 외부자원을 이용할 때 항상 예외 발생시킴
 *    - 문법오류는 직접 수정해야함

 */

public class ExceptionBasic {

	public static void main(String[] args) /*방법 1 throws IOException */{

		// 1-1) Syntax 에러
		//Int num; // I->i
		int num;
		if(true); {}
		//else //짝을 이루는 if 발견불가
		
		// 방법1 예외 던지기 : 호출한 메소드() throws 예외클래스{}
		
		// 방법1 예외 또 던지기 :
		// 방법 2 try-catch절로 직접 예외 처리
//		try {
//			System.in.read();
//		}
//		catch (IOException e) { e.printStackTrace();}
//		// e는 null이 아님
		
		// 2. 런타임 에러 Unchecked Exception
		/*
		 *  - 컴파일시에는 체크 X, 실행시에만 발생되는 에러
		 *  - RuntimeException 계열)
		 *  캡처 쓰기
		 *  
		 *  - 런타임 에러는 무조건 try-catch 사용!
		 */
		
		// ArrayIndexOutofBoundException : 배열의 크기를 벗어난 인덱스 사용시
		try {
			int[] array = new int[2];
			array[0]=100;
			System.out.println("arra[0]:"+array[0]);
			array[1]=200;
			System.out.println("arra[0]:"+array[0]);
			array[2]=300; // 에러발생 시 catch 블락으로 바로 넘어감
			System.out.println("arra[0]:"+array[0]);
			// syntax error는 없었음. java.lang.ArrayIndexOutOfBoundsException
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Exception!!! Ask to manager");
		}
		
		//[NumberFormatException] : 숫자형식의 문자열을 int형으로 변환시 해당 문자열이 숫자형식이 아닐때
		Scanner sc = new Scanner(System.in);
		System.out.println("나이 입력");
		try {
			//int age = sc.nextInt();
			String strAge = sc.nextLine();
			int age = Integer.parseInt(strAge);
			System.out.println("10년후 나이:"+(10+age));
		}
		catch(InputMismatchException | NumberFormatException e){
			System.out.println("나이는 숫자만");
		}
		
		// NullPointerException : 인스턴스 변수에 해당하는 객체의 메모리 주소가 저장이 안된 경우에 .으로 객체의 멤버에 접근할때 발생
		
		System.out.println(today);
		try {
			today.getTime();
		}catch(NullPointerException e) {
			System.out.println("주소가 없는(null) 인스턴스 변수로는 포인트 할 수 없음");
		}
		
		// "": 빈문자열, null아님
		// null : null값
		
		String empty="";
		System.out.println("빈 문자열의 길이: " +empty.length());
		String nullStr = null;
		try {
			System.out.println("nullStr의 길이: " + nullStr.length()); //null pointer exception
		}
		catch(NullPointerException e){
			System.out.println("nullStr은 null입니다.");
		}
		
		// [ArithmeticException] : 0으로 나눌 때 발생
		
		try {
			System.out.println(100/0);
		}catch(ArithmeticException e) {
			//예외 메세지 출력방법 
			// 1. 사용자 임의 예외 메세지
			//System.out.println("0으로 나눌 수 없어요");
			
			System.out.println(e);// java.lang.ArithmeticException: / by zero => 오버라이딩 된것!(주소안나오니까)
			// 2. 예외 클래스의 인스턴스 변수 이용: e.toString()
			// "예외 클래스" : "예외메세지" 형태를 문자열로 반환
			// System.out.println(e);
			
			// 3. e.getMessage() : 예외 메세지만 출력
			// System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	}	//main
	static Date today;
}
