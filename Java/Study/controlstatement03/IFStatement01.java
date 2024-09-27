package controlstatement03;

import java.io.IOException;

public class IFStatement01 {

	public static void main(String[] args) throws IOException {
		// < 조건문 >
		// if문(+if-else), switch문 두 가지가 있음
		/* - 조건식은 비교식/논리식이어야 함
		 * - 즉 조건식은 결과값이 true/false의 결과를 갖는 식 또는 직접 boolean값을 줌
		*/
		/*	1. if문
		 	if(조건식) {
		 		조건식이 참일 경우 실행할 명령문
		 	}
		 	- { } 생략가능(여러줄은 생략X), 실행문들을 하나로 묶는 블락역할
		 */
		
		/* 1-1) Java는 결과값이 boolean이 아닌 식은 조건식으로 불가 */
		int num1 = 10;
		//if(num1 % 2) {		}	// 조건식의 결과 = 산술 → 불가
		
		/* 1-2) 조건식은 비교식 아니면 논리식 혹은 boolean 값 (true,false) */
		//비교식
		if(num1%2==0) {	System.out.printf("%d는 짝수이다.\n", num1);	}	// 짝수일때는 "~짝수이다", 홀수일때는 실행안함
		if(num1%2!=0) {	System.out.printf("%d는 홀수이다.\n", num1);	}	// 홀수일때
		//논리식
		if(num1%2==0 && num1 >=10) {	System.out.printf("%d는 짝수이고, 10보다 크거나 같다.\n", num1);	}

		if(true) System.out.println("항상 실행되는 명령문, 조건식이 언제나 true이기 때문");
		
		/* if(num1%2!=0); {	System.out.printf("%d는 홀수이다.\n", num1);	*/
		//블락스코프, 위 {블락}은 위 if문의 조건식 true/false와 관계없이 무조건 실행된다. 즉 위의 if문에 연결된 if문이 아니다.
		/*
		 * {int example = 10;}
		 * example = 11;
		 *	//{ } 내에서 선언된 example을 블락외에서 사용 불가능
		 */
		
		if(num1%2!=0) // {
			System.out.printf("num1은 %d이다.\n", num1);	//...(1)
			System.out.printf("%d는 홀수이다.\n", num1);	//...(2)
		//}
		// if의 블락스코프가 없기 때문에 (1)만 조건식으로 필터링되고, (2)는 정상적으로 출력
		
		
//		
//		System.out.println("1.하나의 몬자를 입력하세요.");
//		int code1 = System.in.read();	//입력한 글자의 아스키코드값을 돌려줌
//		/* System.in.read() 메소드 : 사용자 입력을 받을 때까지 블락상태가 됨. 즉 다음 코드 실행X. 입력한 문자의 아스키 코드값 반환 */
//		// 사용자에게 입력을 받을 때 까지 진행시키지 않음
//		System.out.println("사용자가 입력한 값(아스키 코드값):"+code1);
//		System.out.println("사용자가 입력한 값(아시크 코드 해당 문자):"+(char)code1);
//		System.out.println("프로그램 끝");
//		
//			
		//사용자가 입력한 문자가 숫자인지 아닌지를 판단하기
			
			
		/*
		System.out.println("1.하나의 문자를 입력하세요");
		int code2 = System.in.read();
		System.out.println("사용자가 입력한 값(아스키 코드값): "+code2);
		System.out.println("사용자가 입력한 값(문자): "+(char)code2);
			
		// 1) 아스키 코드값을 알 때
		boolean isNumber = code2 >=48 && code2 <=57;
		if(isNumber) System.out.println("입력한 문자는 숫자다");
		if(!isNumber) System.out.println("입력한 문자는 숫자가 아니다");
		
		// 2) 아스키 코드값을 모를 때
		isNumber = code2 >='0' && code2 <='9';
		if(isNumber) System.out.println("입력한 문자는 숫자다");
		if(!isNumber) System.out.println("입력한 문자는 숫자가 아니다");
		*/
			
		/*
		문]사용자가 입력한 문자가 알파벳이거나 숫자이면
		    "알파벳 혹은 숫자"라고 출력하고
		        아니면 "기타"라고 출력 하여라.
		    (아스키 코드값 모른다고 가정) else문 불가
		        참고로 영문 알파벳의		
		        아스키 코드값은 대문자 A(65)~Z(90) ,소문자 a(97) ~z(122)
		*/
		System.out.println("1.하나의 문자를 입력하세요.");
		int input = System.in.read();
		boolean isNumber = (input>='0' && input<='9')||(input >='A' && input <='Z')||(input >='a' && input <='z');
		if(isNumber) { System.out.println("알파벳 혹은 숫자"); }
		if(!isNumber) { System.out.println("기타"); }
		
		System.out.println("2.하나의 문자를 입력하세요.");
//		char word = (char)System.in.read();
//		// 실행안되고 종료 : 
//		System.out.println("입력한 문자:"+(int)word);
//		// \r = 13, \n = 10
//		
//		word = (char)System.in.read();
//		System.out.println("입력한 문자:"+(int)word);
//		word = (char)System.in.read();
//		System.out.println("입력한 문자:"+word);
//		
		// \n,\r 필요없음 → 엔터값을 읽어서 미 사용


		System.in.skip(2);
		char word = (char)System.in.read();
		System.out.println("입력한 문자:"+word);
		
		/*
		문]사용자가 입력한 값이 숫자인지 먼저 판단하고
		   숫자라면 2의 배수인지를 판단하여
		   2의 배수인 경우만 "2의 배수입니다"라고 출력하여라.
		   2의 배수가 아닌 경우 "2의 배수가 아니다"라고 출력
		   문자 '0'의 아스키 코드값:48,'1':49 '2':50......
		*/
		System.out.println("3.숫자를 입력하세요.");
		System.in.skip(2);
		char input2 = (char)System.in.read();
		isNumber = (input2>='0' && input2<='9');
		boolean isEven;
		
		if(isNumber) { 
			isEven = (int)input2 % 2==0;
			 if(isEven&&((int)input2!=48)) {
				 System.out.printf("%s은(는) 2의 배수입니다.\n",input2);
			 }
			 if(!(isEven)||((int)input2==48)) {
				 System.out.printf("%s은(는) 2의 배수가 아닙니다.\n",input2);
			 }
		}
		
		
		// 방법 1. if문 안의 if문으로 처리
		/*
		 * boolean isNumber = word >= '0' && word <= '9';
		 * boolean isMultiple = word % 2==0;
		 * isMultiple = (word -'0') % 2==0;	// word - '0': 입력한 숫자 그대로 나올수있음
		 * if(isNumber) {
		 * 		if(isMultiple) System.out.println("2의 배수입니다");
		 * 		if(!isMultiple) System.out.println("2의 배수입니다");
		 *  }
		 */
		
		// 방법 2. 하나의 조건식안에서 논리 연산으로 처리
		/*
		 * if(isNumber && isMultiple) { System.out.println("2의 배수입니다"); }
		 * if(isNumber && !isMultiple) { System.out.println("2의 배수입니다"); }
		 */
		
		
	}	//main

}	//class
