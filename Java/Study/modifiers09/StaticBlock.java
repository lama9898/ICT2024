package modifiers09;

public class StaticBlock {
	
	int instanceVar;
	void instanceMethod() {}
	
	static int staticVar;
	static void staticMethod() {}
	
	// ■ 1. static 블락
	// 실행 시기 : class loader 할 때
	// database와 연결하는 코드 기술 시 사용
	static {
		System.out.println("[static block 시작]");
	
		//System.out.println(instanceVar);	//불가	
		//instanceMethod();	//불가
		System.out.println(staticVar); //가능
		staticMethod(); //가능
		int localVar = 10;	//static 블락 내에서 선언한 지역변수
		
		System.out.println("static 블락 내에서 선언한 지역변수 : "+localVar);
		System.out.println("[static block 끝]");		// static 블락은 main보다 먼저 실행됨.
	}
	
	// ■ 2. 생성자
//	public StaticBlock() {
//		System.out.println("[StaticBlock의 생성자]");	
//	}
	
	// ■ 1-1)
//	public static void main(String[] args) {
//		System.out.println("[main 메소드]");	
//
//	}	//main

}	// class StaticBlock
