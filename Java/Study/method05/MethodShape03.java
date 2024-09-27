package method05;


// 문제2 다시보기
import java.util.Scanner;

public class MethodShape03 {

	//메소드 형식 3: 매개변수는 있고 반환값은 없는 경우
	/*
	접근지정자 [modifier] void 메소드명(매개변수들){
		처리할 일;
	}
	메소드에서 필요한 값을 매개변수를 통해서 받고
	그 값으로 일을 처리한 후 결과값을
	바로 출력하고자 할때 주로 사용
	*/
	
	// ■ 1. 메소드 정의 : start부터 end까지 누적합을 구하는 메소드
	static void printTotal(int start,int end) {
		int sum=0;
		for(int i=start;i<=end;i++) { sum+=i; }
		System.out.printf("%d부터 %d까지의 누적합은 %d\n",start,end,sum);
	}	// void printTotal
	
	
	// 문제2]
	/*
	 * 숫자 두개를 매개변수로 입력 받아서 즉 시작단과 끝단을 매개변수에 입력받아 해당 구구단을 출력하는 메소드를 정의하고 main메소드에서 호출
	 */
	
	static void multiple(int start,int end) {
		for(int m=1;m<=end;m++) {
			for(int n=start;n<=end;n++) {
				System.out.printf(" %d * %d = %d\t",n,m,n*m);
				//System.out.printf(" %d * %d = %-3d",n,m,n*m);
			}
			System.out.println();
		}
		
	}	// void multiple
	
	
	// 문제3] 국/영/수 세 과목의 점수를 매개변수로 전달받아 평균을 구하고
	//		학점을 출력하는 메소드를 정의해라
	//		그리고 main 메소드에서 호출하여 결과를 확인해라
	static void grade(int kor,int eng, int math) {
		int avg = (kor+eng+math)/30;
		char result;
		
		switch(avg) {
		case 10:
		case 9:result= 'A';break;
		case 8:result= 'B';break;
		case 7:result= 'C';break;
		case 6:result= 'D';break;
		default:result= 'F';
		}
		
		System.out.printf("%c학점 입니다.\n",result);
	
	}
	
	
	public static void main(String[] args) {
		// ■ 2. 메소드 호출
		int start=1,end=10;	// 지역이 다르므로 중복이름이어도 에러X
		printTotal(start,end);	//매개변수에 값 전달
		printTotal(1,100);
		printTotal(100,1000);

		multiple(4,9);
		
		grade(100,90,80);
		int [][] score= {
				{97,99,67},		{88,99,78},		{100,67,90},		{77,56,100},		{50,60,90}
		};
		
		// 문제4] 위에 정의한 grade()메소드를 호출하여 2차원 배열 score에 저장된 5명의 학생의 학점을 출력
		for(int i=0;i<score.length;i++) {
			System.out.printf("%d번째 학생은 ",i+1);
			grade(score[i][0],score[i][1],score[i][2]);
		}
		
		 
	}	//main

}	//class
