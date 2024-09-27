package accessmodifier07.another;

import accessmodifier07.AccessModifierOne;
//import accessmodifier07.PackageClass;

//public class AccessModifierTwo {
//	//AccessModifierTwo 클래스는 AccessModifierOne 과 같은 패키지 안에 있다.
//	//AccessModifierOne의 멤버(변수, 메소드)에 접근해 보자
//	
//	// private이 붙은 멤버는 주로 public이 붙은 멤버 메소드를 통해서 간접으로 호출할 수 있다.
//	
//	// field
//	AccessModifierOne one; // 두 클래스 모두 같은 package 내에 있기 때문에 import해줄 필요가 없음.
//
//	//method
//	public void access() {
//		one = new AccessModifierOne();
//		//one.privateVar=10;	//The field AccessModifierOne.privateVar is not visible
//		one.packageVar=10;
//		one.publicVar=10;
//		//one.privateMethod();	//The method privateMethod() from the type AccessModifierOne is not visible
//		one.packageMethod();
//		one.publicMethod();
//		
//		//PackageClass클래스는 접근지정자 생략형이지만 AccessModifierTwo와 같은 패키지 안에 있기 때문에 접근가능
//		
//		PackageClass pack = new PackageClass();
//	}
//}

public class AccessModifierTwo {
	//AccessModifierTwo 클래스는 AccessModifierOne 과 다른 패키지 안에 있다.
	//AccessModifierOne의 멤버(변수, 메소드)에 접근해 보자
	
	// private이 붙은 멤버는 주로 public이 붙은 멤버 메소드를 통해서 간접으로 호출할 수 있다.
	
	// field
	AccessModifierOne one; // 두 클래스 다른 package에 있기 때문에 import해 줘야함.

	//method
	public void access() {
		one = new AccessModifierOne();
		//one.privateVar=10;	//The field AccessModifierOne.privateVar is not visible
		//one.packageVar=10;	//같은 패키지 내에 있지 않기 때문에 접근 불가
		one.publicVar=10;
		//one.privateMethod();	//The method privateMethod() from the type AccessModifierOne is not visible
		//one.packageMethod();
		one.publicMethod();
		
		//PackageClass클래스는 접근지정자 생략형이지만 AccessModifierTwo와 같은 패키지 안에 있기 때문에 접근가능
		
		//PackageClass pack = new PackageClass();	// : ▼▼▼ 해결방법 없음
		//packageClass 클래스는 접근지정자가 생략형
	}
}
