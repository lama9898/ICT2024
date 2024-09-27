package encapsulation13;

// " this. "
/*
 *  - this : 인스턴스환 된 자기자신의 클래스를 지칭
 *  - 인스턴스형 멤버에 접근할때 사용하는 키워드 → 반드시 static이 안붙어있는 인스턴스형 메소드 안에서만 사용가능
 *  - this 키워드는 정적 메서드안에서 사용할 수 없음!
 *  - 지역변수와 멤버변수를 구분할때 주로 사용
 */


public class ThisKeyword {
	
	//instance member
	int instanceVar, anotherInstanceVar;
	void instanceMethod() {
		//this는 인스턴스형 메소드 안에서만 사용가능
		//this.하면 자기 자신의 모든 멤버가 표시됨(인스턴스,정적). 정적인 멤버도 접근 가능하지만 지양
		System.out.println(this.instanceVar);
		System.out.println(this.staticVar);	//warning! 정적 멤버는 정적인 방법으로 접근하기
		System.out.println(staticVar);	// 자기 자신 클래스이므로 굳이 클래스명 붙일 필요없음
	}
	void initialize(int instanceVar, int another, int staticVar) {
		//instanceVar = instanceVar;	//매배변수 = 매개변수 값; 으로 해석됨
		//멤버변수와 지역변수 이름이 같은 경우 지역변수가 우선됨
		this.instanceVar = instanceVar;
		anotherInstanceVar = another;
		
		//this.staticVar = staticVar;	// warning!
		ThisKeyword.staticVar = staticVar;	// 이런경우에는 이렇게
		//정적멤버와 지역변수의 이름이 동일할때는 클래스명으로 접근해서 구분하기
	}
	
	// 정적 멤버
	static int staticVar;
	static void staticMethod() {
		//System.out.println(this.);	//정적함수에서 this. 사용 불가!
		
	}
	
	
	public static void main(String[] args) {
		ThisKeyword thisKeyword = new ThisKeyword();
		thisKeyword.initialize(10, 200, 3000);
		System.out.println("thisKeyword.instanceVar: "+thisKeyword.instanceVar);
		System.out.println("thisKeyword.anotherInstanceVar: "+thisKeyword.anotherInstanceVar);
		System.out.println("staticVar: "+staticVar);
	}	//main

}	//class
