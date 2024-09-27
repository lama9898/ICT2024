package array04;

import java.util.Scanner;

public class ArrayExample {

	public static final int SUBJECTS =3;	//
	public static void main(String[] args) {
		
		/*
		  1] 학생수를 사용자로부터 입력받자
		     -Scanner클래스 사용
		  2] 입력받은 학생 수만큼 국영수 점수 및 총점를 저장할수 있는
		     int형 배열을 선언하고  메모리를 할당해라
		  3] 학생 수만큼 각 학생의 국영수 점수를 입력받아
		     2]에서 생성한 배열에 저장해라.*
		      -Scanner클래스 사용
		  4] 각 학생의 국영수 점수 및 총점 그리고 평균을 출력하여라. 		
		  */
		
		int studentNumber=0;
		int[][] scores;
		
		String[] subjects= {"국어","영어","수학"};	//
		
		// 1)학생수를 사용자로부터 입력받자
		Scanner sc = new Scanner(System.in);
		
		System.out.println("학생 수를 입력해주세요");	//
		studentNumber=sc.nextInt();	//숫자+엔터 쳐도 3만 입력됨. \n\r은 남아있음
				
		// 2)입력받은 학생 수만큼 국영수 점수 및 총점를 저장할수 있는 int형 배열을 선언하고  메모리를 할당해라
		scores = new int[studentNumber][SUBJECTS+1];	//총점도 저장
		
		// 3)학생 수만큼 각 학생의 국영수 점수를 입력받아 2]에서 생성한 배열에 저장해라.*
		for(int i=0;i<studentNumber;i++) {
			System.out.println(i+1+"번째 학생의 점수를 입력해주세요");
			for(int j=0;j<subjects.length;j++) {
				System.out.println(subjects[j]+"점수를 입력하세요.");
//				switch(j) {
//				case 0: System.out.println("국어점수를 입력해주세요");break;
//				case 1: System.out.println("영어점수를 입력해주세요");break;
//				case 2: System.out.println("수학점수를 입력해주세요");break;
//				}
				scores[i][j] = sc.nextInt();
				scores[i][scores[i].length-1]+=scores[i][j];	// 총점 = 누적 점수				
			}
		}
		
		// 4) 각 학생의 국영수 점수 및 총점 그리고 평균을 출력하여라.
		for(int i=0;i<studentNumber;i++) {
			System.out.println("- - - - - - - - - - - - - - - -");
			System.out.println("       " + (i+1)+"번째 학생 성적");
			System.out.println("- - - - - - - - - - - - - - - -");
			// 국영수, 총점, 평균
			System.out.printf("국어:%d, 영어:%d, 수학:%d\n총점:%d, 평균:%.2f\n"
					, scores[i][0],scores[i][1],scores[i][2], scores[i][3], (double)scores[i][3]/SUBJECTS);
		}

	}	//main

}	//class
