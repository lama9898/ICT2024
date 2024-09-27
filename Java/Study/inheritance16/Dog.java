package inheritance16;

public class Dog extends Animal {

	// 컴파일러가 원래는 기본생성자를 자동으로 붙여줌, 부모의 기본 생성자가 호출이됨
	// 기본 생성자 없어서 생기는 빨간줄 해결하기
	// 1. Animal에 기본생성자 추가
	// 2. Animal 인자 생성자를 기본생성자로 변경
	// 3. Dog 기본 생성자에 Animal 인자 생성자 호출
	
	// tip!> 부모 생성자는 항상 기본 생성자 만들어 놓자
	
	// field
	String dogKind; // 확장한 멤버
	int age;	// 자식의 age 새로 선언 시 자식의 age가 우선순위 더 높음
				// 부모의 age 쓰기 위해서는 super keyword쓰기
	//this.age=10;
	//super.age=100;

	// 아래 기본 생성가 암묵적으로 추가된다
	public Dog() { super(); }
	// 인자 생성자
	public Dog(String species, int age, String gender, String dogKind) {
		super(species, age, gender);	// super()는 항상 첫 문장이어야 함!
		this.dogKind = dogKind;
		//this.age = age;		
	}
	
	void bark() {
		// super(); // 일반 함수에서는 호출 불가!, super()는 항상 생성자 안에서만 호출가능
		//System.out.println(this.age+"살인 "+dogKind+"가 짖다");	
		System.out.println(super.age+"살인 "+dogKind+"가 "+dogKind.substring(0,2)+"하고 짖었다");	
	}
	
	void printDog() {
		printAnimal();
		System.out.println(",개 종류: "+dogKind);
	}

	static void staticMethod() {
		//super.	//super.와 this. 키워드는 static 함수에서는 사용불가, 인스턴스 메소드에서만 사용이 가능하다.
	}
	
	// ◆ 1번 방법
	public int getSuperAge() {
		return super.age;
	}
}	
