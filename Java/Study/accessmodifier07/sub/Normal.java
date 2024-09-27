package accessmodifier07.sub;

import accessmodifier07.Super;

public class Normal extends Super{
	// 다른 패키지에 있음으로 생략형 접근 불가 : 패키지 다르기 때문
	// protected는 상속관계이기 때문에 패키지 달라도 접근 가능
	// Super는 import 필요
	
	void access() {
		//privateMethod();	
		// 두 클래스는 상속관계로 같은 패키지 안에 있기 때문에 생략형, protected, public 접근이 가능하기 대문에 모두 상속
		//this.packageMethod();
		this.protectedMethod();
		publicMethod();
	}
}
