package lambda27;

public class Calculator implements CalculatorInterface{

	@Override
	public int calc(int a, int b) {
		// 계산기 기능 중 하나만 가능 : (-)만 구현한 상태
		// Calculator 타입 객체 여러개를 만들어도 빼기만 할수있음
		return a-b;
	}

}
