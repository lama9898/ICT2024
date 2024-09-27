package controlstatement03;

import java.io.IOException;
import java.util.Scanner;

public class DoWhileStatement {

	public static void main(String[] args) throws IOException {
		// 1. do-while문
		/* [초기식]
		 * do {
		 * 		[명령문]
		 * 		[증감식]
		 *  }while(반복조건);
		 *  
		 *  - 무한루프
		 *  do {	}while(true);
		 * 
		 * 	▶ 반드시 한번은 실행하고 나서 반복
		 *  ▶ while(반복조건) 뒤의 세미콜론;은 반드시 붙여야 함
		 */
		
		// 1부터 10까지 누적합
		int sum=0;
		int i=1;
		do {
			sum+=i;
			i++;
		}while(i<=10);
		System.out.println("1부터 10까지의 누적합 : "+sum);
		
		/* 1명이상의 점수를 입력받아 성적처리
		 * 더 입력받고 싶으면 아무키나 누르고 종료하고 싶으면 X나 x 입력
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		int kor,eng,math,exitCode;
		int avg;
		do {
			// 점수 입력받기
			System.out.println("국어점수를 입력하시오");
			kor=sc.nextInt();
			System.out.println("영어점수를 입력하시오");
			eng=sc.nextInt();
			System.out.println("수학점수를 입력하시오");
			math=sc.nextInt();
			
			// 학점 출력
			avg = (kor+eng+math)/30;
			switch(avg) {
				case 10: System.out.println("A학점");break;
				case 9: System.out.println("A학점");break;
				case 8: System.out.println("B학점");break;
				case 7: System.out.println("C학점");break;
				case 6: System.out.println("D학점");break;
				default: System.out.println("F학점");
			}
			System.out.println("추가입력시 아무키나 눌러주세요.\r\n종료하려면 'x'나 'X'를 누르세요.");
			exitCode = System.in.read();				
			}while(!(exitCode=='x'||exitCode=='X'));
		
		// 같은 내용은 while문으로
		while(true) {
			System.out.println("국어점수를 입력하시오");
			kor=sc.nextInt();
			System.out.println("영어점수를 입력하시오");
			eng=sc.nextInt();
			System.out.println("수학점수를 입력하시오");
			math=sc.nextInt();
			
			// 학점 출력
			avg = (kor+eng+math)/30;
			switch(avg) {
				case 10: System.out.println("A학점");break;
				case 9: System.out.println("A학점");break;
				case 8: System.out.println("B학점");break;
				case 7: System.out.println("C학점");break;
				case 6: System.out.println("D학점");break;
				default: System.out.println("F학점");
			}
			
			System.out.println("추가입력시 아무키나 눌러주세요.\r\n종료하려면 'x'나 'X'를 누르세요.");
			exitCode = System.in.read();						
			if((exitCode=='x'||exitCode=='X')) break;

		}
		

	}	// main

}	// class
