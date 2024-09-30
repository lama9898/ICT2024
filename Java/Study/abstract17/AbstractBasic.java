package abstract17;

/*
[추상 클래스-불완전한 설계도]
1]class 앞에 abstract(modifier)를 붙이면
  그 클래스는 추상 클래스가 된다
2]어떤 클래스가 추상 메소드를 가지면
  그 클래스를 반드시
  추상 클래스로 만들어 줘야 한다
  단, 추상 메소드가 없어도 abstract만 붙이면
  추상 클래스가 될 수 있다.
 
  ※추상 메소드란?
    - 메소드 앞에 abstract키워드가 붙은 것
    - 메소드 원형만 있고 구현부가 없는것
      예] 접근지정자 abstract 반환타입 메소드명([매개변수]);
    - 추상메소드는 오버라이딩이 목적이다

3]추상 클래스는 인스턴스화 할 수 없다.즉 메모리에 객체를
  생성할 수 없다 즉 new연산자로 메모리를 할당 할 수 없다.
 
4]추상클래스는 상속이 목적이다
5]추상 클래스를 상속받은 자식클래스(sub class)에서는
   만약 추상 클래스가(super class) 하나라도 추상 메소드를
   가지고 있다면 반드시 오버라이딩 해야 한다
   즉 동일한 API를 사용할 수 있다.
  
  
6]만약 자식클래스에서 부모클래스의 추상메소드를 오버라이딩 하지
  않으려면 자식도 추상 클래스로 만들어야 한다
  
7] 추상클래스는 new해서 인스턴스화 할 수 없지만
     추상클래스 타입의 인스턴스 변수에
     자식클래스의 메모리를 할당 할 수 있다(Heterogenious)
  
*/

// 추상클래스 1. 추상 메소드가 없는 추상 클래스
abstract class NoHavingAbstractMethod{
	public static final int MAX_INT = Integer.MAX_VALUE;
	int instanceVar;
	static int staticVar;
	void instanceMethod() {};
	static void staticMethod() {};
}

// 추상클래스 2. 추상 메소드를 가진 클래스
abstract class HavingAbstractMethod {
	abstract void abstractMethod();
	// 추상 메소드를 멤버로 가지면 반드시 추상 클래스가 되어야함.
}

class NoHavingChild extends NoHavingAbstractMethod{
	int newVar;
	// 추상 메소드를 가지지 않은 추상 클래스를 상속받은 경우, 강제적으로 오버라이딩을 할 의무는 없음
	// 정적 메소드는 오버라이딩 불가

	@Override
	void instanceMethod() { }
}

class HavingChild extends HavingAbstractMethod{

	@Override	
	void abstractMethod() {	}	// 의무적으로 오버라이딩한 메소드
	void newMethod() { }		// 자식에서 추가한 메소드	
}

// 추상클래스 3. 추상메소드를 가진 추상 클래스를 상속받은 자식클래스에서 의무적으로 오버라이딩을 하지 않으려면 자식클래스도 추상 클래스로
abstract class HavingChildeNoOverriding extends HavingAbstractMethod{
	abstract void abstractNewMethod();
}

class HavingNewChild extends HavingChildeNoOverriding{

	@Override	//부모 것
	void abstractNewMethod() {
		// TODO Auto-generated method stub
		
	}

	@Override	//부모의 부모 것
	void abstractMethod() {
		// TODO Auto-generated method stub
		
	}
	
}

public class AbstractBasic {

	public static void main(String[] args) {
		// NoHavingAbstractMethod sample1 = new NoHavingAbstractMethod();	//추상메서드는 인스턴스화 불가

		NoHavingAbstractMethod sample2 = new NoHavingChild();
		HavingAbstractMethod sample3 = new HavingChild();
		
		sample3.abstractMethod();// 오버라이딩한 메소드
		((HavingChild)sample3).newMethod();
		
		//추상클래스의 정적멤버 : 자식/부모 클래스명.정적멤버
		NoHavingAbstractMethod.staticMethod();
		NoHavingChild.staticMethod();
		
	}	//main

}	//class
