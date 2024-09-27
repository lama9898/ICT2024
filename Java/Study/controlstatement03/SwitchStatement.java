package controlstatement03;

import java.io.IOException;
import java.util.Scanner;

public class SwitchStatement {

	public static void main(String[] args) throws IOException {
		// ■ 4. switch 문 : 조건에 따라서 분기하는 제어문
		/*	△ 조건식은 정수식이어야 함. 연산의 결과값이 byte/short/char/int/String/Enum 타입으로 나오는식.
		 * 	△ long형은 해당 안됨.
		 * 	△ 정수식은 산술식이거나 직접 변수를 정수식에 사용하는 경우만 이용 가능
		 *  △ 수식의 결과값이 이산적일때 switch문 사용 ex)1,2, a ... 연속적인 경우 사용 불가.
		 *  △ break가 없는 경우 : 먼저 해당 case를 찾고, 순차적으로 다른 case의 명령문들도 모두 차례로 실행됨(해당 case문 이후의 case문들)
		 *  	★ break문 꼭 추가하기!★
		 * 
		 * 	switch(정수식) {
		   	case 값1 :
		     	명령문1;
		     	....
		        break;	// break문 만나면 블락 바로 나감. break문 없으면 다음 case내의 명령문도 실행
		    case 값2 :
		     	명령문2;
		        break;
		    ......
		    case 값n :
		     	명령문n;
		        break;
		  
		    [default :
		     	명령문m;
		     	[break;]
		    ]
		 * }
		 * 
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요.");
		int inputNum = sc.nextInt();
		System.out.println("입력한 숫자 : "+inputNum);

		System.out.println("\n[if문으로 나머지값 판단]");
		int remain = inputNum % 3; //0,1,2
		if(remain==0)	System.out.println("나머지 : 0");
		else if(remain==1)	System.out.println("나머지 : 1");
		else	System.out.println("나머지 : 2");
		System.out.println();
		
		System.out.println("[switch문으로 나머지값 판단]");
		switch(remain) {
			case 0:	System.out.println("나머지 : 0");
				break;
			case 1:	System.out.println("나머지 : 1");
				break;
			case 2:	System.out.println("나머지 : 2");
				break;	//break 꼭 안넣어도됨, 이후의 명령문이 없어서 자동으로 빠져나오기 때문
		}
		
		switch(inputNum%3) {	//inputNume%3==0 ← 자바는 정수식에 boolean값(비교식, 논리식) 사용 불가
			case 0 : System.out.println("나머지 : 0");
			break;
			case 1:	System.out.println("나머지 : 1");
			break;
			case 2:	System.out.println("나머지 : 2");
			break;
		}
		
		byte b = 5;
		switch(b) {
			case 1: System.out.println("b에 저장된 값 1");
			//case 1: System.out.println("b에 저장된 값 1");
			//case는 분기 시 중복값 사용 불가 : duplicate case 에러
			case 2: System.out.println("b에 저장된 값 2");	
			case 5: System.out.println("b에 저장된 값 5");
			case 10: System.out.println("b에 저장된 값 10");
		}
		
		long ln = 5;
		//switch(ln) { }	//switch에는 long형 이용 불가
		//switch(ln%3) {	//ln%3 = long형 변수이므로 실행 불가
		
		System.out.println("첫번째 숫자 입력");
		int num1 = sc.nextInt();
		System.out.println("연산자 기호(+,-,*,/) 입력");
		char op = (char)System.in.read();
		System.out.println("두번째 숫자 입력");
		int num2 = sc.nextInt();
		
		switch(op) {	//+-*/
			case '+':	System.out.printf("%d + %d = %d\n",num1,num2,num1+num2);break;
			case '-':	System.out.printf("%d - %d = %d\n",num1,num2,num1-num2);break;
			case '*':	System.out.printf("%d * %d = %d\n",num1,num2,num1*num2);break;
			case '/':	System.out.printf("%d / %d = %d\n",num1,num2,num1/num2);break;
			default: System.out.println("잘못된 연산자 기호입니다.");
		}
		
		System.out.println("수강하려는 과목은 무엇입니까?");
		sc.nextLine();
		String subject = sc.nextLine();
		switch(subject) {
		case "국어" : System.out.println("과목은 국어");break;
		case "수학" : System.out.println("과목은 수학");break;
		default: System.out.println("개설되지 않은 과목입니다.");
		}
		
		switch(inputNum) {
			case 1:
			case 2:
			case 100:
			case 200:	System.out.println("사용자가 입력한 값은, 1 또는 2 또는 100 또는 200 중 하나입니다.");break;
			case 300:	System.out.println("사용자가 입력한 300 입니다.");break;
			default: System.out.println("위 사례에 해당하는 값이 업습니다.");
		}
		
		System.out.println("국어 점수를 입력하시오");
		int kor = sc.nextInt();
		System.out.println("영어 점수를 입력하시오");
		int eng = sc.nextInt();
		System.out.println("수학 점수를 입력하시오");
		int math = sc.nextInt();
		
		// 문제3]
		/* 평균을 구해서 90점이상 "A학점"출력
		 * 80점이상이면 "B학점 ... 60점 이상 "D학점, 60점 미만 "F학점" 출력
		 * switch문 사용 
		 */
		int avg_switch = (kor+eng+math)/3;
		char grade='F';
		switch(avg_switch) {
			case 100,99,98,97,96,95,94,93,92,91,90: grade='A';break;
			case 89,88,87,86,85,84,83,82,81,80 : grade='B';break;
			case 79,78,77,76,75,74,73,72,71,70 : grade='C';break;
			case 69,68,67,66,65,64,63,62,61,60 : grade='D';break;
			default: System.out.println("F학점입니다.");
		}
		System.out.printf("%c학점입니다.",grade);
		
		/* BEST : 
		 * switch(avg_switch/10){
		 * case 10: grade='A';break;
		 * case 9 : grade='A';break;
		 * case 8 : grade='B';break;
		 * case 7 : grade='C';break;
		 * case 6 : grade='D';break;
		 * default : grade='F';
		 * }
		 */
		
		
		
	}	// main
	
	// 'main' + [ctrl + spacebar] => main 생성
	//  scanner는 JDK 5.0부터 추가

}	//class
