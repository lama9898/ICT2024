package method05;

import java.io.IOException;
import java.util.Scanner;

/*
	메소드 형식 2:매개변수는 없고 반환 값이 있는 경우
	※ 메소드 형식2 은 주로 메소드안에서 데이터를 생성(예:사용자로부터 값을 입력받기)하여
	  그 값으로 처리한 후 그 결과값을 반환하고자 할때
	  주로 사용
	접근지정자 [modifier] 반환자료형(반환타입) 메소드명(){
		 
		  처리할 일;
		 return  결과값;
		
	}	
	결과값을 메소드를 호출한 쪽에 반환 할때는
	return이라는
	키워드 사용	
*/

public class MethodShape02 {
	

	//	▼ 1-1)b.
	static int noParamYesReturn() {
		int sum=0;
		for(int i=0;i<=10;i++) { sum+=i; }
		
		// ▼ 1-2) method dataType이 있는 경우 반드시 반환값이 있어야 함. (void 아닌경우)
		// return;
		
		return sum;
		// System.out.println("return문 이후");	//Unreachable Code 에러 발생
	}
	
	// ● 사용자(1명)로부터 국영수 점수를 입력받아 평균을 구해서 학점을 반환하는 메소드 정의
	static String getGrade() {
		Scanner sc = new Scanner(System.in);
		
		// 과목 타이틀 출력
		String [] subjects = {"국어", "영어", "수학"};
		// 점수 저장용 배열
		int[] score = new int[subjects.length];	//subjects.length==3
		// 총점 저장용
		int total = 0;
		
		for(int i=0;i<subjects.length;i++) {
			System.out.print(subjects[i]+"점수: ");
			score[i]=sc.nextInt();
			total+=score[i];
		}
		// 평균 구해서 학점 반환
		// ● 방법 1) 변수에 결과값 저장 후 변수 반환
		/*
		String result;
		switch(total/30) {
			case 10:
			case 9:result="A학점";break;
			case 8:result="B학점";break;
			case 7:result="C학점";break;
			case 6:result="D학점";break;
			default:result="F학점";
		}
		
		return result;
		*/
		
		// ● 방법 2) 직접 return, break문 불필요
		switch(total/30) {
			case 10:
			case 9:return "A학점";
			case 8:return "B학점";
			case 7:return "C학점";
			case 6:return "D학점";
			default:return "F학점";
		}
		
		
	}
	
	
	// 문제 1]
	/*
	   메소드 안에서 사용자로부터 숫자 두개(Scanner)와
	   산술 연산자(System.in.read()사용)를 입력받는 (+,-,*,/)
	   메소드로
	   산술 결과는 메소드 안에서 바로 출력하고
	   산술 연산자 기호를 반환하는 메소드를 정의 해라.
	   그리고 main메소드에서 호출하여
	   사용자가 입력한 연산자를 출력하여라.
	*/
	
	static char operatorMethod() throws IOException {
		int a,b,result=0;
		char op;
		Scanner sc = new Scanner(System.in);	//
		
		System.out.println("숫자1을 입력하세요");
		a = sc.nextInt();	//
		
		System.out.println("산술 연산자를 입력하세요 (+,-,*,/)");
		op =(char)System.in.read();
		System.in.skip(2);
		
		System.out.println("숫자2를 입력하세요");
		b = sc.nextInt();

		
		switch(op) {
		case '+': result= a+b;break;
		case '-': result= a-b;break;
		case '*': result= a*b;break;
		case '/': result= a/b;
		}
		
		System.out.printf("%d %c %d = %d\n",a,op,b,result);
		
		return op;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		// ■ 1. 메소드 정의
		/* ▼ 1-1)a. 메소드 내의 메소드 정의 불가!
		static int noParamYesReturn() {	}
		*/
		
		
		// ■ 2. 메소드 호출
		/*
		 * 1) call :
		 * 
		 * 2) invoke :
		 */
		
		// ▼ 2-1) call
		noParamYesReturn();	//noParamYesReturn는 55라는 값을 반환할 뿐
		
		// ▼ 2-2)a. 반환값을 변수에 저장
		int value = noParamYesReturn();
		System.out.println("1부터 10까지의 누적합= "+value);
		// ▼ 2-2)b. 변수 미사용, 반환값 바로 출력하기
		System.out.println("1부터 10까지의 누적합= "+ noParamYesReturn());
		
		// ● 함수호출
		System.out.println("학점 구하기"+getGrade());
		
		char inputOP = operatorMethod();
		System.out.println("input operator is '"+inputOP+"'");

	}	// main

}	// class

