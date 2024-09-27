package controlstatement03;

import java.io.IOException;

public class WhileStatement {

	public static void main(String[] args) throws IOException {
		// 1. while문
		/*
		 *	[초기식]
		 *	while(반복조건) {
		 *		[반복조건이 참인 상태에 실행할 명령문들]
		 *		[증감식]
		 *	}
		 *
		 *	무한루프 : 
		 *	while(true){	}
		 * 
		 * ▶ 반복문으로 반복횟수가 정해지지 않은 경우 주로 사용
		 */
		
		// while(int 1=0) { } //초기식은 for문에서만 사용가능
		
		// 1~10까지의 누적합
		int i=1,sum=0;
		while(i<=10) { // (반복조건)
			sum+=i;	// (명령문)
			i++;	// (증감식)
		}
		System.out.println("while문 1~10까지의 합 : "+sum);
		System.out.println("while문이 끝난 후 i : "+i);// i = 11일때 break
		
		// 문제1]
		/*	1부터 1000까지의 숫자중 3의 배수이거나 5의 배수인 숫자의 합을 구하라, 3과 5의 공배수는 제외시켜라
		 * 
		 */
		i=1;sum=0;
		while(i<=1000) {
			if((i%3==0)^(i%5==0)) {	sum+=i;	}
			i++;
		}
		System.out.println("1~1000까지의 3의배수/5의 배수의 합(공배수 제외) =" +sum);
		
		System.out.println("문자열을 입력하세요");
		// 사용자가 몇 자를 입력할지 모르기 때문에 while문 사용(for문도 가능)
		char word;
		while((word=(char)System.in.read())!=13) {
			//사용자 입력 문자열 그대로 다시 출력하기
			System.out.print(word);
			// 1) read 실행(사용자 입력)   2)word에 저장   3)코드값 13인지 확인
			// 코드값 13 = \r			
		}
		System.out.println();
		
		//for(;(word=(char)System.in.read()) != 13;) System.out.println(word);
		
		// 4x4
		/*
		 *  0 0 0 1 (1,4)
		 *  0 0 1 0 (2,3)
		 *  0 1 0 0 (3,2)
		 *  1 0 0 0 (4,1)
		 */
		int k1=1;
		int j1=4;	//k row, j column
		while(k1<=4) {
			while(j1>=1) {
				if(k1==j1) System.out.printf("%-2d",1);
				else System.out.printf("%-2d",0);
				
				j1--;
			}
			System.out.println();
			k1++;
			j1=4;	// ★ nested while문에서 j=0이 되었기 때문에 초기화 시켜줘야함.
		}
		// 위의 문제를 해결한 내용
		int k2=1;
		while(k2<=4) {
			int j2=4;
			while(j2>=1) {
				if(k2==j2) System.out.printf("%-2d",1);
				else System.out.printf("%-2d",0);
				
				j2--;
			}
			System.out.println();
			k2++;
		}
		
		/*
		 * 별표찍기
		 * 
		 * 	*			k=1, j =1,2,3,4,5
		 * 	* *			k=2, j =1,2,3,4,5
		 * 	* * *
		 * 	* * * *
		 * 	* * * * *
		 * 
		System.out.println("[15번 반복]");
		for(int k=1;k<=5;k++) {
			for(int j=1;k>=j;j++) {
				if(k>=j) System.out.printf("%-2c",'*');
			}
			System.out.println();
		}
		*/
		int k=1;
		while(k<=5) {
			int j =1;
			while(k>=j) {
				if(k>=j) System.out.printf("%-2c",'*');
				j++;
			}
			System.out.println();
			k++;
		}
		
		/*
		for(int m=1;m<=9;m++) {
		for(int n=2;n<=9;n++) {
			System.out.printf(" %d * %d = %d\t",n,m,n*m);
			//System.out.printf(" %d * %d = %-3d",n,m,n*m);
		}
		System.out.println();
		}
		
		 */
		k=1;
		while(k<=9) {
			int j=2;
			while(j<=9) {
				System.out.printf(" %d * %d = %d\t",k,j,k*j);
				j++;
			}
			System.out.println();
			k++;			
		}
		
		//무한 루프 :
		while(true) {
			System.out.println("무한 루프");
			break;
		}
		System.out.println("infinite loop break"); //unreachable code : 무한루프 뒤의 코드 이므로, 닿을 수 없는 코드
		
		
		
		
		// 1byte씩 스트림에서 읽어옴
	}

}
