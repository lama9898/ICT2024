package exception21;
//나만의 예외클래스 만들기

public class NotGoodApperanceException extends Exception{
	//일반 자바 클래스~! -> 예외 클래스로 만들기 위해서는
	// 1. Exception 클래스를 상속받아서 예외클래스로 만들기
	
	// 2. 생성자 정의
	public NotGoodApperanceException() {
		super("복장 불량은 입장불가");
		// Exception 의 인자 생성자인 Exception(String message 호출)
		// 인자인 message는 getMessage()로 호출할 떄 반환되는 예외 메세지임
	}
	public NotGoodApperanceException(String message) {
		super(message);
	}
}
