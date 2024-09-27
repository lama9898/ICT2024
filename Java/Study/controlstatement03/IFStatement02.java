package controlstatement03;

import java.io.IOException;

public class IFStatement02 {

	public static void main(String[] args) throws IOException {
		// ■ 1. if문 기본 형식 2 : if-else 문
		/*
		 * if([조건식]) {
		 * 	// 조건식이 참인 경우 실행
		 * }
		 * else {
		 * 	// 조건식이 거짓인 경우 실행
		 * 	// else는 if가 없으면 에러, else 단독으로 사용 불가
		 * }
		 * 
		 *	▽ 경우의 수가 두가지 일때 사용
		 */
		
		int num1 = 100;
		
		// ①
		System.out.println("[if문 형식 첫번째로 짝/홀수 판단]");
		if(num1%2==0) System.out.println("Even");
		if(num1%2!=0) System.out.println("Odd");
		// ②
		System.out.println("[if문 형식 두번째로 짝/홀수 판단]");
		if(num1%2==0) System.out.println("Even");
		else System.out.println("Odd");
		
		/* 두 방법의 차이점 :
		 *  ①은 num1%2==0, num1%2!=0 확인으로 연산 두번
		 *	②은 num1%2==0 연산만 진행함
		*/
		
		// ■ 2. 삼항 연산자
		/*	▽ if else문과 같음
		 * 	▽ 코드짧게 표현하기 위해 사용, if-else를 기술하지 못하는 곳에도 기술가능(System.out.println() 같은 경우)
		 *  ▽ [변수] = [조건식] ? [참인 경우의 값] : [거짓인 경우의 값];
		 */
		
		System.out.println("[삼항 연산자로 짝/홀수 판단]");
		String result = (num1%2==0) ? "짝수": "홀수";
		System.out.println(result);
		System.out.println((num1%2==0) ? "짝수": "홀수");
		
		System.out.println("[짝/홀수 판단후 짝수인 경우 100이상인지 판단 - if else 문]");
		if(num1%2==0) {
			if(num1 >= 100) System.out.println("짝수이면서 100이상");
			else System.out.println("짝수이면서 100미만");
		}
		System.out.println("[짝/홀수 판단후 짝수인 경우 100이상인지 판단 - 삼항 연산자]");
		System.out.println( num1%2==0 ? num1>=100? "짝수이면서 100이상" :"짝수이면서 100미만" : "");
		
		/*	if 연산으로 a출력, b는 {블락}으로 묶여있지않으므로 그냥 출력, c는 b로 인해 if와 단절되므로 오류
		if(num1%2!=0) 
			System.out.println("num1은 "+num1);  //...a
			System.out.println(num1+ "은 홀수");	//...b
		
		else {
			System.out.println(num1+ "은 짝수");	//...c
		}
		*/
		
		System.out.println("하나의 문자를 입력하세요");
		int ascii = System.in.read(); //: 사용자 입력의 아스키 코드값을 반환
		
		
		// 문제1 ] 한 문자를 입력받아 숫자인지 아닌지, if else문과 삼항 연산자를 이용하여 판단하여라.
		
		System.out.println("[if else 버전]");
		if(((char)ascii>='0'&&(char)ascii<='9'))
			System.out.println("숫자입니다.");
		else
			System.out.println("숫자가 아닙니다.");
		
		System.out.println("[삼항 연산자 버전]");
		System.out.println(((char)ascii>='0'&&(char)ascii<='9')? "숫자입니다":"숫자가 아닙니다.");
		System.in.skip(2);//엔터키:\n,\r 스킵
		
		System.out.println("다시 한 문자를 입력하세요");
		char word = (char)System.in.read();
		/* 문제2 ]
		   숫자인지 판단후 2의 배수를 판단하고
		   2의 배수면 "2의 배수" 출력,아니면 "2의배수가 아님"출력
		   또한 숫자가 아니고
		   알파벳이라면 대소문자를 판단한후
		   대문자인경우 "대문자" 출력, 소문자인 경우 "소문자"출력
		   if~else문 사용
		   가정]숫자나 알파벳만 입력한다고 가정하자.
		*/
		
		boolean isNum = word>='0'&& word<='9';
		boolean isChar = (word>='A'&&word<='Z')||(word>='a'&&word<='z');
		System.out.println("[if else 버전]");
		if(isNum) {
			if((word-'0')%2==0) System.out.println("2의 배수");
			else System.out.println("2의 배수가 아님");
		}
		else {
			if(isChar) {
				if(word>='A'&&word<='Z') System.out.println("대문자");
				else System.out.println("소문자");
			}
		}
		System.out.println("[삼항 연산자 버전]");
		System.out.println(isNum?((word-'0')%2==0?"2의 배수":"2의배수가 아님"):(word>='A'&&word<='Z'?"대문자":(word>='a'&&word<='z')?"소문자":""));
		

	}	//main

}	//class
