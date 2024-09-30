package exception21;


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionFinally {
	
	/*
		finally절:예외가 발생하든 안하든 반드시 실행 하고자하는 명령문들을 기술.
		1) try ~catch절
		  -예외 직접 처리
		2) try ~catch~finally절
			-예외 직접 처리후 반드시 실행할 문장도 처리
		3) try ~finally절
			-예외는 던지고(throws) 예외가 발생하든 안하든  반드시 실행할 문장 처리
		※  finally절안에 있는 명령문은
		   return문을 만나더라도 실행됨,
		   단,System.exit(0)를 만나면 당연히 실행안됨.
		*/
		/*
		   [1.외부 자원 사용시 발생하는 예외 클래스들(컴파일 예외) 처리 방법]
		   1-1. 직접 처리하지 말고 던지자
		         해당 메소드명 옆에 throws 예외클래스명
		   1-2. 예외를 개발자가 직접 처리 try~catch절 이용
		    try{
		            예외가 발생할 만한 코드
		    }
		    catch(예외클래스 인스턴스변수){
		          예외발생시 catch절에서 처리
		    }
		    	※try는 단독으로 못쓰고
		    	try~catch 혹은
		    	try~finally절 혹은
		    	try~catch~finally의 쌍으로 사용한다.
		   	※런타임예외는 던져봤자 의미 없다.
		           반드시 try~catch절로 직접 처리해야 한다
		  	※main메소드에서는 런타임 예외는 반드시 try~catch
		          컴파일예외는 던지거나 try~catch해도 됨.
	  */

	
	// 컴파일 발생 예외 메소드
	static void compile() throws IOException {	//system.in.read를 읽어오는 경우 붙여주기
		System.out.println("한 문자 입력?");
		//try {	//1-2)
		int code = System.in.read();
		System.out.println("입력한 문자: "+(char)code);
		//}
		//catch(IOException e) {
		//	e.printStackTrace();
		//}
	}
	
	static void tryFinally() throws IOException {
		try {
			compile();
		}
		finally {
			System.out.println("반드시 실행할 명령문");
		}
	}
	
	//런타임 예외 발생 메소드
	static void runTime() {
		Integer.parseInt("백억원");
	}
	
	static void tryCatchFinally() {
		Scanner sc = new Scanner(System.in);
		int age = -10;
		try {
			System.out.println("age?");
			age = sc.nextInt();
			//return;	//위 명령문에서 에러나면 catch로 가고 return은 실행X, return도 finally절 실행하고 나감
			System.exit(0);
		}
		catch(InputMismatchException e) {
			System.out.println("나이는 숫자만");
		}
		finally { //에러 나든 안나든 출력
			System.out.println("당신의 10년후 나이:" +(age+10));
		}
		//System.out.println("당신의 10년후 나이:" +(age+10)); //age는 트라이 블럭 내 에러 -> int age 밖으로 빼주기
		
	}
	
	public static void main(String[] args) /* 1-1) throws IOException */{ 
		// 컴파일 예외는 던지거나 try-catch 하거나
		// 1-1) 던지기
		// compile();
		
		// 1-2) try-catch 하기
		/*
		try {
			compile();
		}
		catch(IOException e) {	//compile의 throws IOException 주석처리 하는 경우 빨간줄 : exception없는데 잡으려고 해서
			e.printStackTrace();										// compile에서 exception try-catch로 잡아주기
		}
		*/
		try {
			compile();
		}catch (IOException e) {
			e.printStackTrace();
		}
		try {
			runTime(); //main에 throws NumberFormatException 던져도 소용 없음(런타임에러이기 때문)
		}catch(Exception e) {
			System.out.println("숫자형식이 아니에요 : "+e.getMessage());
		}

		tryCatchFinally();

	}

}
