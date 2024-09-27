package datatype01;

public class VariableDeclaration {

	public static void main(String[] args) {
		/*-----  1.  ----*/
		System.out.println("[변수 선언방법 첫번째]"); //'sysout' + [ctrl + space]
		
		//자료형(data type) 변수명;
		int num; //(컴파일 할때는 X) 실행하면 메모리에 할당
		/* 1-1) 컴파일 오류, ※지역변수는 초기화하지 않고 사용시 컴파일 오류
		System.out.println(num);
		*/
		/* 1-2) 변수 초기화*/
		num=100; // num이라는 메모리에 100이라는 값을 할당
		System.out.println(": "+num);
		
		/*-----  2.  ----*/
		System.out.println("[변수 선언방법 두번째 - 선언과 동시에 초기화]");
		int initNum = 200;
		//초기화 시에는 왼쪽부터 연산(initNum 메모리 생성 후 200할당)
		//원래는 할당연산자 오른쪽이 먼저 실행됨
		System.out.println(": "+initNum);
		
		/*-----  3.  ----*/
		System.out.println("[변수 선언방법 세번째 - 동시에 같은 타입의 변수 여러개를 선언, 초기화]");
		//반드시 자료형이 같아야 함.
		// > , < 로 구분하여 같은 자료형의 변수 여러개를 선언하기 가능. 초기화도 같이 할 수 있음
		int fnum, snum = 1000, tnum;
		/* 3-1) 컴파일 오류, fnum은 아직 초기화가 안되었기 때문
		System.out.println(fnum); 
		*/
		/* 3-2) 변수 초기화 */
		fnum = snum;
		System.out.print(": "+fnum);
		
		/* 3-3) 컴파일 오류, tnum 변수 초기화 안되었기 때문
		fnum = snum + tnum;
		 */
		/* 3-4) 변수 초기화 */
		tnum = 500;
		fnum = snum + tnum;
		System.out.println(", fnum = " + fnum); //여기서의 +는 산술연산이 아닌 연결의 의미
		
		
		/*-----  4.  ----*/
		/* 4-1) 대입연산자
		100은 상수, num은 변수, 상수에 변수 대입 불가, 상수값 변경 불가
		대입연산자(할당연산자, =)의 왼쪽에는 값이 변경될 수 있는 변수가 와야 함.
		오른쪽에는 값이나, 값이 저장된 변수가 위치
		100 = fnum;
		*/
		/* 4-2) 같은 지역(블락)안에서 동일한 이름의 변수 선언불가
		int fnum;
		 */
		/* 4-3) 명명규칙 */
		int fNum; //Java는 대소문자를 엄격하게 구분함에 따라 동일이름이어도 대소문자가 다른 경우 다른 변수
		//int 4you; //숫자로 시작하는 경우 X
		int specialvar;
		//int spicial#var; //특수문자 포함 불가 (_,$ 사용가능)
		int _undervar,under_var,undervar_; //_사용가능
		int $dollar,doll$ar, dollar$; //사용가능
		//int public; //예약어 사용불가
		int puBlic; //예약어 아니기 때문에 사용가능
		
		
	}	//main

}	//class
