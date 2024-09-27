package controlstatement03;

import java.io.IOException;
import java.util.Scanner;

public class IFStatement03 {
	
	public static void main(String[] args) throws IOException {
		
		// ■ 3. if문 기본 형식 3 : if-elseif 문
		/*
		 * if([조건식1]) {
		 * 	// 조건식1이 참인 경우 실행
		 * }
		 * else if([조건식2]){
		 *	// 조건식1이 거짓이고,
		 * 	// 조건식2이 참인 경우 실행
		 * }
		 * else if([조건식3]){
		 * 	// 조건식1,2이 거짓이고,
		 * 	// 조건식3이 참인 경우 실행
		 * }
		 * ...
		 * else{
		 * 
		 * }
		 */
		
		int kor=99,eng=80,math=89;
		double avg = (kor+eng+math)/3.0;

		if(avg>=90) {	System.out.println("A학점");	}
		else if(avg>=80) {	System.out.println("B학점");	}
		else if(avg>=70) {	System.out.println("C학점");	}
		else if(avg>=60) {	System.out.println("D학점");	}
		else {	System.out.println("F학점");	}
		
		System.out.println("하나의 문자를 입력하세요.");
		char word =  (char)System.in.read();
		
		/* 문제1]
		   숫자인지 판단후 2의 배수를 판단하고
		   2의 배수면 "2의 배수" 출력,아니면 "2의배수가 아님"출력
		   또한 숫자가 아니고
		   알파벳이라면 대소문자를 판단한후
		   대문자인경우 "대문자" 출력, 소문자인 경우 "소문자"출력		 
		   단,if ~else if()만이용
		*/
		
		System.out.println("문제 1------");
		boolean isNum = word>='0'&&word<='9';
		boolean isAlp = (word>='a'&&word<='z')||(word>='A'&&word<='Z');
		if(isNum) {
			if((word-'0')%2==0&&word!='0') System.out.println("2의 배수");
			else if((word-'0')%2!=0) System.out.println("2의 배수가 아님");
			else if(word=='0') System.out.println("0입니다.");
		}
		else if(isAlp) {
			if(word>='a'&&word<='z') System.out.println("소문자");
			else if(word>='A'&&word<='Z') System.out.println("대문자");
		}
		else System.out.println("숫자와 알파벳이 아닙니다.");
		System.out.println("-----------");
		
		/* 문제2]
		 * 위에서 입력받은 문자가 숫자이면 "숫자", 알파벳이면 "알파벳"
		 * 숫자도 알파벳도 아니면 "기타"를 출력하여라.
		 * if - else if - else 문 사용
		 */
		System.out.println("문제 2------");
		if(isNum) System.out.println("숫자");
		else if(isAlp) System.out.println("알파벳");
		else System.out.println("기타");
		System.out.println("-----------");
		
		Scanner sc = new Scanner(System.in);	//입력, import java.util.Scanner;
		System.out.println("첫 번째 숫자를 입력하세요.");
		int num1 = sc.nextInt();	//숫자 외 입력 시 에러
		
		System.out.println("두 번째 숫자를 입력하세요.");
		int num2 = sc.nextInt();
		
		System.out.println("세 번째 숫자를 입력하세요.");
		int num3 = sc.nextInt();
		
		System.out.printf("num1:%d, num2:%d, num3:%d\n",num1,num2,num3);
		
		// 문제3] (종합) 세 숫자 중 최대 값을 구하는 로직을 작성하자 (if문 형식 3가지 중 아무거나 사용 가능)
		System.out.println("문제 3------");
		if(num1>num2) {
			if(num1>num3) System.out.printf("최대값은 num1(%d)",num1);
			else if(num3>num1) System.out.printf("최대값은 num3(%d)",num3);
			else if(num1==num3) System.out.printf("최대값은 num1, num3(%d)",num1);
		}
		else if(num1<num2) {
			if(num2>num3) System.out.printf("최대값은 num2(%d)",num2);
			else if(num3>num2) System.out.printf("최대값은 num3(%d)",num3);
			else if(num2==num3) System.out.printf("최대값은 num2, num3(%d)",num2);
		}
		else if(num1==num2) {
			if(num1>num3) System.out.printf("최대값은 num1, num2(%d)",num1);
			else if(num1<num3) System.out.printf("최대값은 num3(%d)",num3);
			else if(num1==num3) System.out.printf("최대값은 num1, num2, num3(%d)",num1);
		}
		
		/* BEST : 
		 * int max = num1;
		 * if(max<num2) max=num2;
		 * else if(max<num3) max=num3;
		 * System.out.println("최대값 : " + max);
		 */

		
	}	//main
	
}	//class
