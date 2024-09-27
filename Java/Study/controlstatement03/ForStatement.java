package controlstatement03;

public class ForStatement {

	public static void main(String[] args) {
		// 1. for문
		/* 
		 	for(초기식;반복조건(조건식);증감식)	{	
		 		[반복 조건이 참인 상태에서 실행할 명령문]
		 		- 순서 -
		 		 1) 초기식 (초기식은 딱 한번만 실행)
		 		 2) 반복조건 확인
		 		  	- 참인 경우 for 블락 내의 명령문 실행
		 		  	- 거짓인 경우 for블락 break. 끝
		 		 3) 증감식
		 		 4) 반복조건 확인
		 		 ... 반복 : 조건을 만족하는 한 반복.
		 	}
		 	
		 	▶ for문은 반복횟수가 정해진 경우 주로 사용함.
		 	
		 */
		
		// 반복문을 이용해서 1부터 10까지의 누적합 구하기
		int sum=0;
		for(int i=1;i<=10;i++) {
			sum = sum+i;
			//sum+=i;
		}	//sum = 0+1+2+3+4+5+6+7+8+9+10
		System.out.println("1부터 10까지의 누적합 = "+sum);
		
		// 1부터 10까지의 숫자 중 2의 배수의 합:2+4+6+8
		sum=0;
		// 1-2)a. 2씩 증가하도록 증감식 작성
		for(int i=2;i<=10;i+=2) {
			sum+=i;
		}
		System.out.println("1부터 10까지의 숫자 중 2의 배수의 누적합 = "+sum);
		
		sum=0;
		// 1-2)b. 1씩 증가, 2의 배수일때만 누적
		for(int i =1;i<=10;i++) {	// int i가 여러번 선언이 가능한 이유 : i는 for블락 내에서만 선언되었기 떄문에 
			if(i%2==0)	sum+=i;
		}
		System.out.println("1부터 10까지의 숫자 중 2의 배수의 누적합 = "+sum);
		
		// i는 for문 안에서만 선언되었기 때문에 사용불가. for문 내에서 생성 후 for문 끝나면 메모리에서 할당해제됨
		// i를 사용하고 싶은 경우 for문 밖에서 선언하면 가능
		// System.out.println("for문이 끝난후 i의 값:"+i);
		int i =5;
		for(;i<10;i++) {}
		System.out.println("for문이 끝난 후 i의 값 : "+i);
		
		for(int k=3;k>0;k--) {
			System.out.println("Let's go home");
		}
		// for(int k=10;k>0;k--); {System.out.println("HELLO WORLD");}
		// 위의 경우 for후 ;로 끝났으므로 반복문이 아님
		
		// 문제1]
		/* 1부터 100까지 숫자중 3의 배수이거나 5의 배수인 숫자의 합을 구해라
		 * 3과 5의 공배수인 경우, 누적합에 단 한번만 포함시켜라
		 */
		sum=0;
		for(i=1;i<=100;i++) {
			if(i%3==0) { sum+=i; }
			else if(i%5==0) { sum+=i; }
			// else if(i%15==0) sum-=i; -> 여기 까지 안오기 때문에 일어나지 않는 연산.
		}
		System.out.println("1~100까지 3의 배수 또는 5의 배수 누적합 (공배수 중복 제외)"+sum);
	
		/* BEST :
		 * for(i=1;i<=100;i++){
		 * 	if((i%3==0)||(i%5==0)) { sum+=i; }
		 * }
		 */
		
		// 문제2]
		/* 1부터 100까지 숫자중 3의 배수이거나 5의 배수인 숫자의 합을 구해라
		 * 3과 5의 공배수인 경우 제외시켜라
		 */
		
		// BEST 1, ||,&&
		sum=0;
		for(i=1;i<=100;i++) {
			if((i%3==0||i%5==0)&&(i%15!=0)) { sum+=i; }
		}
		System.out.println("1~100까지 3의 배수 또는 5의 배수 누적합 (공배수 제외)"+sum);
		
		// BEST 2, XOR
		sum=0;
		for(i=1;i<=100;i++) {
			if(i%3==0 ^ i%5==0) { sum+=i; }
		}	
		System.out.println("1~100까지 3의 배수 또는 5의 배수 누적합 (공배수 제외)"+sum);
		
		
		// 2. 이중 for문
		/* 이중(중첩, nested) for문: for문 안의 for문
		 * 이중 for문에서 바깥 for문은 행(row)을 의미
		 * 안쪽 for문은 열(column)을 나타냄
		 *  2행x3열, □ : cell
		 *  □ □ □
		 *  □ □ □
		 */
		
		int repeatCount =1;
		for(int k=0;k<3;k++) {	//k : 0,1,2
			System.out.printf("[k가 %d일때]\n",k);
			for(int j=1;j<=3;j++) {	//j : 1,2,3
				System.out.printf("[j는 %d, 반복횟수:%d]\n",j,repeatCount++);
			}
		}
		
		// 4x4
		/*
		 *  0 0 0 1 (1,4)
		 *  0 0 1 0 (2,3)
		 *  0 1 0 0 (3,2)
		 *  1 0 0 0 (4,1)
		 */
		
		// 방법 1
		for(int k=1;k<=4;k++) {
			for(int j=1;j<=4;j++) {
				if(k+j==5) System.out.printf("%-2d",1);
				else System.out.printf("%-2d",0);
			}
			System.out.println();
		}
		
		System.out.println("=========");
		// 방법 2
		for(int k=1;k<=4;k++) {
			for(int j=4;j>=1;j--) {
				if(k==j) System.out.printf("%-2d",1);
				else System.out.printf("%-2d",0);
			}
			System.out.println();
		}
		
		/*       복습할 부분        */
		
		/*
		 * 별표찍기
		 * 
		 * 	*			k=1, j =1,2,3,4,5
		 * 	* *			k=2, j =1,2,3,4,5
		 * 	* * *
		 * 	* * * *
		 * 	* * * * *
		 * 
		 * 
		 *	     *		k=1, j=5
		 *	    * *		k=2, j=4,6
		 *	   * * *	k=3, j=3,5,7
		 *	  * * * *	k=4, j=2,4,6,8
		 *	 * * * * *	k=5, j=1,3,5,7,9
		 */
		System.out.println("[25번 반복]");
		for(int k=1;k<=5;k++) {
			for(int j=1;j<=5;j++) {
				if(k>=j) System.out.printf("%-2c",'*');
			}
			System.out.println();
		}
		
		System.out.println("[15번 반복]");
		for(int k=1;k<=5;k++) {
			for(int j=1;k>=j;j++) {
				if(k>=j) System.out.printf("%-2c",'*');
			}
			System.out.println();
		}
		
		// 구구단 출력
		/*	2 * 1 = 2	3 * 1 = 3 ...	9 * 1 = 9
		 *  2 * 2 = 4 ...
		 * ...
		 *  2 * 9 = 18
		 */
		
		for(int m=1;m<=9;m++) {
			for(int n=2;n<=9;n++) {
				System.out.printf(" %d * %d = %d\t",n,m,n*m);
				//System.out.printf(" %d * %d = %-3d",n,m,n*m);
			}
			System.out.println();
		}
		
		
		//무한반복
		for(;;) {
			System.out.printf("home\n");
			break;	// 반복문 빠져나올때도 이용
		}
		System.out.println(""); //unreachable code : 무한루프 뒤의 코드 이므로, 닿을 수 없는 코드
		
	}	//main

}	//class
