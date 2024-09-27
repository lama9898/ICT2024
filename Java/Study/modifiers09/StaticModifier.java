package modifiers09;
	/*
	- 멤버변수는 크게 정적멤버 변수와 인스턴스형
	  멤버변수로 나눈다
	- 멤버메소드도 정적메소드 와 인스턴스형 메소드로 나눈다.
	-멤버변수나 멤버 메소드 앞에 static이라는 modifier가
	 붙으면
	 정적 멤버 즉 정적 멤버변수이거나 정적 메소드이다.
	 예]   int age;//인스턴스형 멤버변수
	     static int age;//정적 멤버변수
	     public void method(){};//인스턴스형 메소드
	     public static void method(){};//정적 메소드
	     단,class앞에는 static을 붙일 수 없다
	※ 정적멤버(상수 ,변수 혹은 메소드)의 메모리는 JVM에서
	   클래스를 로드할 시점에 생기고
	   인스턴스형 멤버는 JVM에서 인터프리터 할때 메모리가
	   생성된다.(즉 new연산자로 인스턴스화 할때 생긴다)
	※ 클래스의 멤버에 접근시 접근 방법
		
		 1]인스턴스형 멤버 : 인스턴스변수.멤버
		
		   클래스명 인스턴스변수 = new 생성자();
		   인스턴스변수.멤버;
		
		 2]정적 멤버 :클래스명.멤버
		  - 정적멤버는 (메소드/변수/상수) 모든 객체가 공유한다. 즉, 메모리에 한개만 생성된다.
	*/

//static class StaticClass{}	// static 불가 : static 지정자는 클래스의 member(변수,상수,메소드 등)에만 붙일 수 있다.

class Mystatic{
	
	// 멤버 변수
	int instanceVar;	//인스턴스형 멤버변수 : 반드시 클래스를 인스턴스화 해야 인스턴스 변수로 접근 가능.
	
	// 정적 멤버 변수
	static int staticVar; //정적 멤버 변수 : 인스턴스화하지 않아도 사용가능, 클래스명으로 접근.
	// jvm에서 클래스 로드할 때 메모리가 생성되므로
	
	//멤버 메소드
	void instanceMethod() {
		// 인스턴스형 메소드 안에서는 모든 멤버(인스턴스형, 정적멤버)를 사용할 수 있다.
		System.out.println(instanceVar);	//o
		System.out.println(staticVar);	//o
	}
	
	// 정적 멤버 메소드
	static void staticMethod() {
		// 정적 메소드 안에서는 인스턴스형 멤버(변수, 메소드등)를 사용할 수 없다.
		//System.out.println(instanceVar);	//x
		System.out.println(staticVar);	//o
	}
	
}	//class Mystatic

public class StaticModifier {
	// 인스턴스형 멤버
	int instanceVar;
	void instanceMethod() {}
	
	static int staticVar;
	static void staticMethod() {}
	
	public static void main(String[] args) {
		// main에 'static' 붙어있음
		
		//instanceMethod(); → StaticModifier temp = new StaticModifier(); instanceMethod();
		//Cannot make a static reference to the non-static method instanceMethod() from the type StaticModifier
		
		System.out.println(Mystatic.staticVar);
		Mystatic.staticMethod();
		Mystatic ms1 = new Mystatic();
		System.out.println(ms1.instanceVar);
		ms1.instanceMethod();
		//Mystatic 클래스의 인스턴스형 멤버 접근은 인스턴스 변수 생성 후 가능
		
		System.out.println(ms1.staticVar);//The static field Mystatic.staticVar should be accessed in a static way
		// 정적 멤버도 인스턴스 변수로 접근 가능하나, 인스턴스 멤버로 착각 할 수 있기 때문에, 멤버변수가 아닌 정적변수로 접근하는 것이 바람직.
		
		// 정적 멤버는 인스턴스화된 객체마다 갖고 있는 멤버가 아님! 하나만 생성되서 모든 객체가 공유함
		// 그래서 모든 객체가 공통으로 사용하는 변수나 메소드에 주로 static을 붙임

		// 메소드의 개별 필드 변수 없이, 매개변수로 전달된 데이터로만 일을 처리하는 메소드는 static을 붙이기.
		
		// 정적 멤버 : 클래스명.멤버로 접근, 자기 클래스안에서 접근하기 때문에 클래스명은 보통 생략함.
		System.out.println(staticVar);
		staticMethod();
		
		// 인스턴스 멤버 : 반드시 인스턴스화 후 접근
		StaticModifier sm = new StaticModifier();
		System.out.println(sm.instanceVar);
		sm.instanceMethod();
		
	}

}
