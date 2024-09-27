package datatype01;

public class ConstantVariable {

	/*	상수(Constant)	*/
	/*	 : 저장된 값이 절대 변하지 않는 메모리의 한 종류
	 *  - 선언 방법 : final 자료형 변수명 = 초기값;
	 *  - 상수명은 보통 변수와 구분하기 위해서 [대문자]로 작성
	 *  - 상수 선언 후 중간에 값을 변경하면 에러 발생
	 *  - 상수는 프로그램의 가독성을 높이고, 유지 보수시 유리함. 고정된 데이터를 상수로 선언하기도 함
	 *  - 상수가 많은 경우 Enum 자료형 사용 (논리오류, 컴파일 에러 등을 방지 가능) 
	 */
	
	/*	※ 지역변수, 전역변수, 인스턴스 변수, 클래스 변수 ※
	 *  클래스 영역 내부 : field, 멤버변수, 전역변수(global)
	 *  메소드 영역 내부 : 지역변수(local)
	 */
	
	int a1; // 멤버변수
	// 클래스 내부, 메소드 외부의 위치에는 선언문만 작성가능. 실행문 불가
	//System.out.println("a1");	// ←실행불가
	
	// 1. 상수 선언 및 초기화
	//  - 클래스 내부에서 상수는 선언과 동시에 초기화 해줘야 함 또는 생성자를 통해서 초기화해야함
	// final double PI;
	static final double PI = 3.14; //PI는 double형 상수
	// static과 final은 보통 같이 있음
	
	
	// 2"
	static final int SCISSORS = 1;
	static final int ROCK = 2;
	static final int PAPER = 3;
	
	public static void main(String[] args) {
		int a2; //지역변수
		// 보통 지역상수는 이용하지 않음
		
		System.out.println("PI : " +PI);
		// 1-1) 상수는 값 변경 불가
		//PI = 3.141592653589793;
		
		final String NICKNAME; // 지역상수는 사용전까지는 초기화하지 않아도 괜찮음, but 지역상수는 이용하는 경우가 적음
		// 1-2) 초기화 안된 경우 사용불가
		//System.out.println(NICKNAME);
		NICKNAME = "Tomato";
		System.out.println("nickname: " + NICKNAME);
		
		// 1-3) 초기화된 상수는 값 변경 불가
		//NICKNAME = "Apple";
		
		// 2. 프로그램의 가독성을 높이기 위한 상수 선언, line 30 참고
		int computer=1, user=2;
		System.out.println("컴퓨터 LOSE - 가독성 낮다");
		
		computer = SCISSORS;
		user = ROCK;
		System.out.println("컴퓨터 LOSE - 가독성 높아짐");
		
	}	//main

}	//class
