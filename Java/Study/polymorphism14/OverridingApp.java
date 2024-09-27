package polymorphism14;

import java.util.Date;

public class OverridingApp {

	public static void main(String[] args) {
		/* Homogeneous
		 * 인스턴스 변수 : Child 타입, 메모리 : Child 타입
		 */
		Child child1 = new Child("정대만",19,"Childe Member var1");
		System.out.println("자식 타입의 인스턴스 변수로 오버라이딩한 메소드 호출");
		child1.sleep(19);
		child1.exercise();
		child1.printParent();
		System.out.println("자식 타입의 인스턴스 변수로 자식에서 새롭게 확장한 메소드 호출");
		child1.newExtendMethod();
		child1.walk(10);
		child1.walk(new Date());	//상속받은 메소드 재정의 하지 않고 바로 사용
		
		
		// parent는 child 담기 가능, child는 parent담기 불가
		/* Heterogeneous
		 * 인스턴스 변수 : Parent 타입, 메모리 : Child 타입
		 *  - 인스턴스 변수가 부모타입이든 자식타입이든, 무조건 오버라이딩한 메소드가 호출됨
		 *  - 단, 오버라이딩을 하지 않았다면 상속받은 부모의 메소드 호출
		 *  - 만약 오버라이딩한 메소드 호출시 부모의 메소드 사용하고자 한다면 super키워드로 접근해서 재정의 하면 됨.
		 */
		Parent parent = new Child("고길동",30,"Child Member Var2");
		System.out.println("부모 타입의 인스턴스 변수로 오버라이딩한 메소드 호출");
		parent.sleep(19);
		parent.exercise();
		parent.printParent();
		System.out.println("부모 타입의 인스턴스 변수로 자식에서 새롭게 확장한 메소드 호출");
		//parent.newExtendMethod();	// 메소드 정의 X라는 에러 : parent 타입에 없기 때문, undefined
		//parent.walk(10);	// 에러 남, undefined
		parent.walk(new Date());
		
		
		
		// 형변환 : 부모타입의 인스턴스 변수로 자식에서 새롭게 확장한 멤버(변수,메소드)에 접근하기 위해서는 형변환을 해야함
		Child ch = (Child)parent;
		ch.newExtendMethod();
		ch.walk(10);
		
		((Child)parent).newExtendMethod();

	}	//main

}//class
