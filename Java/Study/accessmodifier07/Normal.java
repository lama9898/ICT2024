package accessmodifier07;

public class Normal extends Super{
	void access() {
		//privateMethod();	
		// 두 클래스는 상속관계로 같은 패키지 안에 있기 때문에 생략형, protected, public 접근이 가능하기 대문에 모두 상속
		this.packageMethod();
		this.protectedMethod();
		publicMethod();
	}
}
