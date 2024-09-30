package lambda27;

public class CalculatorApp {

	public static void main(String[] args) {
		System.out.println("[방법 1 - 인터페이스를 구현한 클래스 사용 : 빼기만 가능]");
		// 단:Calculator 타입 객체 여러개를 만들어도 빼기만 할 수 있음
		// 장:재사용가능, Calculator 타입 객체 또 생성가능
		Calculator calculator = new Calculator();
		System.out.println(calculator.calc(10, 5));
		
		System.out.println("[방법2 - 익명 클래스를 사용 : 모든 연산 가능]");
		// 장:별도의 클래스 (Calculator) 불필요. 방법1보다 코드가 간결
		// 단:재사용 불가
		CalculatorInterface minus = new CalculatorInterface() {
			@Override
			public int calc(int a, int b) {
				return a-b;
			}
		};
		System.out.println(minus.calc(10, 5));
		CalculatorInterface plus = new CalculatorInterface() {
			@Override
			public int calc(int a, int b) {
				return a+b;
			}
		};
		System.out.println(plus.calc(10, 5));
		
		System.out.println("[방법3 - 람다식 사용 : 모든 연산 가능]");
		// 장:클래스(Calculator) 불필요, 방법2보다 코드 간결
		// 단:재사용 불가
		// 람다식(익명함수: 함수의 표현방식 중 하나)은 CalculatorInterface의 추상메소드 형태여야 함.
		// 	  - 즉 함수형 인터페이스의 추상메소드를 람다식으로 구현한다.
		CalculatorInterface subtract = (x,y) -> x-y;
		System.out.println(subtract.calc(10, 5));
		CalculatorInterface add = (x,y) -> x+y;
		System.out.println(add.calc(10, 5));
		CalculatorInterface multiple = (x,y) -> x*y;
		System.out.println(multiple.calc(10, 5));
		CalculatorInterface divide = (x,y) -> x/y;
		System.out.println(divide.calc(10, 5));
		// 위처럼 추상 메소드 하나로 다양한 기능 구현 가능

		System.out.println("[람다식(익명함수)을 메소드의 인자로 전달");
		receiveLambda((a,b)-> a%b, 10,5);
		
		System.out.println("[람다식(익명함수)을 반환하는 메소드");
		System.out.println(returnLambda(10).calc(10, 5));
		
	}	//main
	// 람다식(익명함수)을 파라미터로 받는 메소드
	// 파라미터의 타입은 함수형 인터페이스 타입이어야함
	static void receiveLambda(/*인자는 함수형 인터페이스 타입이 와야 함*/ CalculatorInterface lambda, int x, int y) {
		System.out.println(lambda.calc(x, y));
	}
	
	// 람다식(익명함수)을 반환하는 메소드
	// 반환 타입은 함수형 인터페이스 타입이어야함
	static CalculatorInterface returnLambda(int z) {
		return (a,b) -> a*b+z;
	}
}















