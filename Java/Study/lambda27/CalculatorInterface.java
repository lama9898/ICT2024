package lambda27;

// @FunctionalInterface : '함수형 인터페이스'
/*
 * 	- 함수형 인터페이스는 추상 메소드를 하나만 갖는다
 * 	- 인터페이스에 @FunctionalInterface 어노테이션을 붙이면
 * 	 , 그 인터페이스는 함수형 인터페이스가 되서 무조건 추상메소드 하나만을 가져야함
 * 
 */
@FunctionalInterface
public interface CalculatorInterface {
	int calc(int a, int b);
	//void a(); // ← MyInterface is not a functional interface
}
