package method05;

public class MethodShape01 {
	
	/*
	메소드(method):객체에서 행동을 의미
	프로그래밍 관점에서 보면 (데이타를 가지고)어떤 일을
	처리하는 하나의 부품
	※메소드는 class안에서 정의 해야하고
	  메소드안에서는 메소드를 정의 할 수 없다
	※메소드 정의시 반드시 반환타입(자료형)이 있어야 한다.
	※메소드명은 변수 명명규칙처럼 만들면 된다.
	 소문자로 시작(동사형), 해당 메소드의 목적을 알 수 있도록 의미 있는 이름으로 지어야함.
	※메소드는 중복코딩 제거의 장점이 있다
	[메소드 정의]	
				
	접근지정자(Access Modifier) [Modifier] 반환타입 메소드명([매개변수들]){
				
		처리할 일;
		[return 결과값;]	 
	}
	[메소드 형식 1]
	:매개변수도 없고 반환값도 없는 경우
	결과값을 반환하지 않을때 반환 타입은 void
	※주로 [출력하는 기능]을 담당한다.
	
	
	접근지정자 [modifier] void 메소드명(){
		처리할 일;
		return;
	}
	*/
	
	// ■ 1. 메소드 정의(선언)
	static void noParamNoReturn() {
		System.out.println("======= MAIN MENU =======");
		System.out.println(" 1.New 2.Continue 3.Exit");
		System.out.println("=========================");
		
	}	// 매개변수X, return값X 함수
	
	// 1-2) 같은 지역 내에서 이름,매개변수가 모두 중복되는 함수 선언 불가
	// static void noParamNoReturn() {	}
	
	static void noParamNoReturn2() {}	//내용이 없는 경우에도 메소드
	static void noParamNoReturn3() {
		int returnValue=100;
		
		// ■ 3. 메소드 실행
		
		// 3-1).
		// return returnValue; // void 메소드에서는 return값을 반환할 수 없음, 컴파일 에러
		
		// 3-2). returnType void와 return 값
		System.out.println("return문 이전");
		//return;	// 메소드 종료
		// System.out.println("return문 이후");// return 이후의 내용은 실행이 X, Unreachable Code에러
		
		// 반환타입이 void인 메소드에서 return;문은 주로 어떤 특정 조건하에서 메소드를 빠져 나갈때 주로 사용한다.
		
		if(returnValue%2==0) {	System.out.println(returnValue+"짝수"); return;	}
		System.out.println(returnValue+"홀수");
		// 짝수인경우 return되므로 else를 따로 쓰지 않아도 괜찮다.
		// 절대 실행이 안되는 명령문이 아니기 때문에 Unreachable Code에러가 발생하지 않음.
	}


	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		
		// 1-1) 메소드 호출 필요, 호출X → 실행X
		// ■ 2. 메소드 호출 : 메소드 원형 그대로 호출
		noParamNoReturn();
		
		// 2-1) return값이 없기 때문에 오류
		// System.out.println(noParamNoReturn());
		
		noParamNoReturn3();
		

	}	// main

}	// class
