package interface18;

/*
-클래스가 객체의 설계도라면 인터페이스는
  클래스의 설계도라 할 수 있다
 ※클래스는 인터페이스를 상속받을 수 있지만
  인터페이스는 클래스를 상속 받을 수 없다.
-자바는 단일 상속이 원칙이나 인터페이스를 이용해서
 다중 상속을 구현할 수 있다.
 ,(콤마)로 구분해서 여러개의 인터페이스를
 상속 받을 수 있다.
-추상 클래스처럼 상속이 목적으로 상속받은 클래스는
 추상 메소드를 오버라이딩해야 하기때문에
 동일한 API(메소드)를 사용할 수 있다.
-멤버로는 추상메소드와 상수(final변수)로만 구성된다.
-접근지정자는 public과 default접근지정자만 가질 수 잇다
 modifier(static,final)는 가질 수 없다.
-인터페이스에 있는 추상메소드는 public과 abstract란
 키워드를 생략한다.
	
	자식의 오버라딩 메서드에서는 반드시 public을 붙여야 한다.
	
 -인터페이스의 상수 또한 public static final을 생략해도,
    컴파일러가 자동으로 붙여준다.	
  -클래스가 인터페이스를 상속받을때는 implements키워드
   인터페이스가 인터페이스를 상속받을때는 extends키워드
 - 인터페이스는 생성자가 없다.
*/

// interface MyInter{} // [o] default (package/생략형) 접근지정자 사용
// static interface MyInter{} // x 클래스와 동일함
// final interface MyInter{} // x 클래스와 다르다

interface MyInter1{	// 보통 interface 앞에는 abstract 생략
	//public MyInter1() { }	// Interfaces cannot have constructors
	
	public static final int INT_MAX = Integer.MAX_VALUE;
	double DOUBLE_MAX = Double.MAX_VALUE;	// public static final 이 생략된 것과 같다.
	
	public abstract void noOmit();
	void omit();	// public abstract 가 생략된것과 같다.
}

interface MyInter2{
	void omit();
}

abstract class AbstractClass{
	/*  
	 * 추상 클래스안에서 추상 메소드
	 * 정의시에는 반드시 abstract 키워드를 붙인다!
	 * 인터페이스는 생략 가능
	 */
	abstract void abstractMethod();	//추상클래스에서는 추상메소드는 항상 abstract 키워드 붙여주기(일반 메소드와 구분을 위해)
	// 생략 접근지정자 package
}

class MyClass implements MyInter1, MyInter2{
	// MyInter1, MyInter2 의 omit을 오버라이딩 하면 에러남! 둘다 이름이 같은데 누구를 오버라이딩하는것인가?
	// 이런경우 앞쪽의 인터페이스의 omit을 오버라이딩
	
	/*추상 클래스안셍서 추상 메소드
    
	정의시 반드시 abstract 키위드를 붙임
	단)인터페이스에서는 생략가능*/
	@Override
	public void noOmit() { }
	
	
	@Override
	public void omit() { }
}

// 인터페이스가 인터페이스 상속
// -extends 키워드 사용, 클래스와 다르게 콤마,로 구분해서 여러개의 인터페이스 상속 가능

interface MyInter3 extends MyInter1,MyInter2{
	void abstractMethod(); //새롭게 확장한 추상 메소드
	// 접근지정자 public
}

class LazyClass extends AbstractClass implements MyInter3{

	@Override
	public void noOmit() { }

	@Override
	public void omit() { }
	
	@Override
	public void abstractMethod() { }
	//AbstractClass : abstract void abstractMethod() - package
	//MyInter3 :void abstractMethod() - public
	// 접근지정자가 더 큰 메소드가 우선
	// 추상 메소드의 원형이 같은 경우 접근지정자가 더 넓은 메소드를 오버라이딩 해야함.
}

public class InterfaceBasic {

	public static void main(String[] args) {
		//MyInter1 mi1 = new MyInter1(); // 인터페이스 역시 추상 클래스처럼 인스턴스화 불가
		//이질화는 가능! 인터페이스명 인터페이스타입_인스턴스변수명 = enw 자식클래스명();
		MyInter1 mi1 = new MyClass();
		mi1.omit();
		mi1.noOmit();
		// 인터페이스 상수접근
		System.out.println(MyInter1.INT_MAX);
		System.out.println(LazyClass.DOUBLE_MAX);
		
		MyInter2 mi2 = new MyClass();
		mi2.omit();	// noOmit은 MyInter1에 정의되어있기때문에 보이지 않음
		((MyClass)mi2).noOmit();
		((MyInter1)mi2).noOmit();
		// 인터페이스는 상속관계가 없어도 형변환이 가능하다
	}

}
