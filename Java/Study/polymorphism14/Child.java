package polymorphism14;

//강사님 코드랑 비교
import java.util.Date;

public class Child extends Parent{
	//멤버변수
	String newExtendVar;	//새롭게 확장한 멤버, 부모에는 없음
	//인자 생성자

	public Child(String name, int age, String newExtendVar) {
		super(name, age);
		this.newExtendVar = newExtendVar;
	}
	//멤버 메소드
	void newExtendMethod() {	//자식에서 새롭게 확장한 멤버
		System.out.println("자식에서 새롭게 확장한 메소드");
	}
	
	private void eat() {	// 오버라이딩 X : 규칙에는 맞지만, private이기 때문에, 자식에서 새롭게 확장한 멤버
		//부모의 private 메소드는 오버라이딩이 절대 불가함
		System.out.println("자식은 식사중");
	}
	
	@Override	// "어노테이션", 주석의 일종, 컴파일러에게 오버라이딩한 메소드 라는 것을 알려줌
	//public String sleep(float age) {	//변수의 타입이 부모의 원본 메소드와 같아야함
	public String sleep(int age) {	//오버라이딩 O, 접근 지정자는 부모와 같거나 부모보다 넓어야 함
		System.out.println("자식은 수면중 - 오버라이딩");
		return null;
	}
	
	// int walk(Date date) { // protected > package
	int walk(int today) {	// 오버라이딩 안하고 오버로딩함 : 이름은 같지만 매개변수의 타입이 다름, 자식에서 새롭게 확장한 메소드와 같음
		System.out.println("나이가 "+age+"살인 자식이 산책중 - 오버로딩");
		return 0;
	}
	
	@Override
	public void exercise() {
		System.out.println("자식은 운동중 - 오버라이딩");
	}
	
	// @Override	// 정적메소드는 Override 불가!
	static void staticMethod() {	//정적메소드는 오버라이딩의 대상이 될 수 없음, 정적메소드는 클래스마다가 고유하게 가짐(클래스당 하나만)
		System.out.println("자식의 정적 메소드");
	}
	@Override
	String getParent() {
		// TODO Auto-generated method stub
		return super.getParent()+", 자식 필드: "+newExtendVar+" - 오버라이딩";
	}
	@Override
	void printParent() {
		// 부모의 메소드를 그대로 사용하도록 재정의
		//super.printParent();
		
		// 부모의 메소드를 그대로 사용하지 않고 새롭게 재정의
		System.out.println(getParent()+" - 오버라이딩");
		
		
	}
}
