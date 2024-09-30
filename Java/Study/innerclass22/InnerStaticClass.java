package innerclass22;

// 내부 정적 클래스 : 클래스안의 클래스로 class 앞에 static 이 붙음 (※ static 은 원래 클래스 앞에 붙을 수 없음, 내부 클래스만 가능)
/*
 * - 외부 클래스의 인스턴스형 멤버는 사용불가
 * - 외부클래스명$내부클래스명.class 로 파일 생성
 */

class OuterStatic{
	//field
	int outerInstanceVar;
	// ▼
	//int sameVar;
	static int sameVar;
	static int outerStaticVar;
	
	// ■ 2) 내부 클래스 인스턴스화 하기
	InnerClass inner = new InnerClass();
	
	void outerInstanceMethod() {
		// ▼ → ■
		// ■ 1) 외부에서 내부 접근하기 : 정적 내부클래스의 정적 멤버는 인스턴스화 없이 바로 사용 가능
		System.out.println(InnerClass.innerStaticVar);
		InnerClass.innerStaticMethod();
		
		//■ 3) 내부의 인스턴스형 멤버는 인스턴스화 해서 변수로 접근
		System.out.println(inner.innerInstanceVar);
		inner.innerInstanceMethod();
	}
	
	static void outerStaticMethod() {
		// ■ 4) 외부에서 내부 접근하기
		// System.out.println(inner.innerInstanceVar); //내부의 인스턴스형 멤버는 접근 불가
		System.out.println(InnerClass.innerStaticVar);
		InnerClass.innerStaticMethod();
	}
	
	static class InnerClass{
		//field
		int innerInstanceVar;
		int sameVar=1;
		static int innerStaticVar;
		
		public InnerClass() {
			System.out.println("내부 클래스의 생성자");
		}
		
		void innerInstanceMethod() {
			// 내부에서 외부에 접근하기 : static 내부 클래스의 경우 외부의 인스턴스형 멤버에 접근 불가
			//System.out.println(outerInstanceVar);	//static 외의 멤버 접근 불가
			//outerInstanceMethod();	
			System.out.println(outerStaticVar);
			outerStaticMethod();
			// OuterStatic.sameVar // : static이 안붙어 있으므로 멤버 접근 불가 ▼
			OuterStatic.sameVar = sameVar; // 외부 <= 내부
			// 외부의 멤버와 내부 멤버 충돌할때
		}
		
		static void innerStaticMethod() {
			// 내부에서 외부에 접근하기
			//System.out.println(outerInstanceVar);
			//outerInstanceMethod();
			System.out.println(outerStaticVar);
			outerStaticMethod();
			// 정적 내부 클래스는 외부의 정적멤버만 사용가능
		}
	}
}


public class InnerStaticClass {
	
	
	public static void main(String[] args) {
		// 별도의 다른 클래스에서는 내부클래스 인스턴스화 불가
		//Innerclass inner = new InnerClass(); //블가
		
		// 외부 클래스를 인스턴스화 할 필요없음
		// 내부 인스턴스형 멤버 접근시 - 내부 정적 클래스 인스턴스화
		// 외부 클래스명.내부클래스명 인스턴스 변수 = new 외부 클래스명.내부클래스명()
		// 빌더 패턴으로 주로 사용함
		OuterStatic.InnerClass inner = new OuterStatic.InnerClass();
		inner.innerInstanceMethod();
		System.out.println(inner.innerInstanceVar);
		
		System.out.println(OuterStatic.InnerClass.innerStaticVar);

	}	// main

}	// class
