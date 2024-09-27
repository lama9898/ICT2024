package datatype01;

public class EscapeChar {

	public static void main(String[] args) {
		/* Escape 문자 */
		/*	: 출력시 원하는 형식에 맞게 출력하기 위해 사용하는 문자
		 *  - 특정 문자 앞에 '\'을 붙여 사용
		 *  - 이스케이프 문자는 모든 ""안에서 사용할 수 있음
		 *  - 이스케이프 문자는 모두 소문자여야 이용 가능
		 *  - \\t : tab, 공백
		 *  - \\n : line feed, 줄바꿈, 아스키 코드 값 : 10
		 *  - \\r : carriage return, 커서를 해당 줄에서 맨 처음으로, 아스키 코드 값 : 13
		 *  엔터키는 \r\n이다.
		 */
		
		/* 1. tab, line feed, carriage return */
		// ◆ 1-1) tab 
		System.out.println("1. Hit Home-run");
		System.out.println("2. Hi\t Home-run");
		
		// ◆ 1-2) line feed
		System.out.print("3. Welcome to Java!");
		System.out.print("Hi Java!");
		System.out.println("Let's Do it. Go Fighting!");
		System.out.print("4. Welcome to Java!\n");
		System.out.print("Hi Java!\n");
		System.out.print("Let's Do it. Go Fighting!\n");
		
		// ◆ 1-3) carriage return
		System.out.println("5.My nickname is Superman\rXX");
		// 원래는 "XX nickname is Superman"이 됨
		
		
		/* 2. quotation escape : 문자열의 시작/끝을 의미하는 문자가 아님을 컴파일러에게 알려주는 것 ("문자의 하나로 사용하였다.") */	
		// ◆ 2-1) \' single quotation 표시
		// '싱글쿼테이션'으로 감싸도 되는 곳에서는 의미가 있음. Java에서는 의미 없음(String은 무조건 "")
		System.out.println("6. My nickname is 'Tomato'");
		System.out.println("6'. My nickname is \'Tomato\'");
		// ◆ 2-2) \" double quotation 표시
		//System.out.println("My nickname is "Tomato"");
		System.out.println("7. My nickname is \"Tomato\"");
		
		
		/* 3. \\에서 뒤의 \은 이스케이프 문자 역할을 하는 특수문자가 아니라는 것을 알려주는 이스케이프문자의 이스케이프 문자 */
		System.out.println("8. D:\nDrive\table");
		System.out.println("8'. D:\\nDrive\\table");
		
		
		/* 4. Format String : 형식 문자열 */
		/*  : 출력형식을 지정하기 위한 형식 문자열
		 *  - %s, %d 등의 변환지시어(Conversion Specifier)를 사용해서 원하는 출력 형식을 만들 수 있음
		 *  - 변환지시어 사용할 수 있는 곳은 정해져 있음(특정 메소드: printf)
		 */
		
		// ◆ 4-1) 
		int kor=99, eng=80, math=96;
		double avg = (kor+eng+math)/3;
		//kor, eng, math는 int, 3도 int : 결과는 int
		avg = (kor+eng+math)/3.0;
		//(double)3으로도 사용가능
		
		// ◆ 4-2) 형식문자열
		System.out.println(avg);
		System.out.println("9.");
		System.out.println("[형식 문자열 미 사용]");
		System.out.println("국어 : "+kor+",영어 : "+eng+",수학 : "+math+", 평균 : "+avg);
		System.out.println("[형식 문자열 사용]");
		System.out.printf("국어 : %d, 영어 : %d, 수학 : %d, 평균 : %f%n",kor,eng,math,avg);
		//%n 대신 \n 사용가능
		
		// ◆ 4-3) 자리수 지정(소수점 맞추기)
		/* 		→ %숫자d
		 * ex) %4c : 한문자를 출력하는데, 전체 자릿수는 4 : ___k
		 * ex) %5d : 00000
		 * ex) % 6.2f : 3.141592 → __3.14XX	※ [ 전체자리수.소수점이하 자리수f ] 소수점도 자리 하나로 취급
		 * 
		 */
		//System.out.printf("%6.2f",3.141592); :'  3.14'
		
		
		System.out.println("[출력 자리수 미지정]");
		System.out.printf("국어 : %d, 영어 : %d, 수학 : %d, 평균 : %f%n",kor,eng,math,avg);
		System.out.println("[출력 자리수 지정(양수)]");
		System.out.printf("국어 : %4d,영어 : %4d,수학 : %4d,평균 : %7.2f%n",kor,eng,math,avg);
		System.out.println("[출력 자리수 지정(음수)]");
		System.out.printf("국어 : %-4d,영어 : %-4d,수학 : %-4d,평균 : %.2f%n",kor,eng,math,avg);
		
		// 기타
		System.out.printf("%c %b %.2f %s%n", '가',false,3.14159,"문자열");
		//모든 값을 %s로 출력해도 된다.
		System.out.printf("%s %s %s %s%n", '가',false,3.14159,"문자열");
		
		
		System.out.println("==========================================");
		System.out.printf("%23s%n","자바반 성적표");
		System.out.println("==========================================");
		System.out.format("%-10s%-12s%s%n","KOREA","ENGLISH","MATH");
		System.out.println("==========================================");
		System.out.printf("%-10s%-12s%s%n",100,99,78);
		System.out.printf("%-10s%-12s%s%n",kor,eng,math);
		System.out.println("==========================================");
		
	}	//main

}	//class
