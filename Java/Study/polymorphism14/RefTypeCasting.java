package polymorphism14;

// 참조형 사이의 형변환 (Type Casting)
/*
 *  - 두 클래스간의 상속관계가 존재할 때 형변환이 가능하다.
 *  - 형 변환시 타입캐스팅 연산자 : (자료형) 사용
 *  - 부모 → 자식 : 자식 인스턴스에 저장 Down Casting
 *  - 자식 → 부모 : 부모 인스턴스에 저장 Up Casting
 *  
 *  Up Casting : 묵시적 형변환
 *  	부모_인스턴스_변수 = 자식_인스턴스_변수;
 *   - 캐스팅 연산자 사용할 필요 X
 *   
 *  Down Casting : 명시적 형변환, 강제적 형변환
 *  	자식_인스턴스_변수 = (자식타입)부모_인스턴스_변수
 *   - 캐스팅 연산자 반드시 사용
 *   - 부모의 인스턴스변수에 자식의 인스턴스 변수가 저장되어 있지 않으면 다운캐스팅 하더라도 실행시 에러발생
 *   - 다운 캐스팅 조건 : 반드시 부모의 인스턴스 변수에 자식의 인스턴스 변수가 저장되어있어야 함
 */

class Base{
	
	void base() {
		System.out.println("Base의 메소드 : base()");
	}
	
}

class Derived extends Base{
	void derived() {
		System.out.println("Base의 메소드 : derived()");
	}
	
	@Override
	void base() {
		System.out.println("Derived(자식)에서 오버라이딩한 메소드 : base()");
	}
}


public class RefTypeCasting {

	public static void main(String[] args) {
		Base base = new Base();
		base.base();
		
		Derived derived = new Derived();
		derived.base();
		
		//Derived del = (Derived)base;	//  java.lang.ClassCastException
		System.out.println("base가 참조하는 타입(대입 연산 전)"+base.getClass().getName());
		base = derived;
		System.out.println("base가 참조하는 타입(대입 연산 후)"+base.getClass().getName());
		//base.derived();	//자식에서 새롭게 정의한 멤버는 부모 타입의 인스턴스 변수로는 접근불가 : 해결방안은 형변환 다운캐스팅
		((Derived)base).derived();
	}

}









