package accessmodifier07.sub;

import accessmodifier07.Super;

public class General {
	
	void access() {
		Super sup = new Super();	//import 필요
		
		//sup.privateMethod();
		
		//sup.packageMethod();	// 같은 패키지 내가 아님
		//sup.protectedMethod();// 패키지 다르고 상속받지 않아서
		sup.publicMethod();
		
		// 다른 패키지 안에 있기 때문에 package 접근자가 붙은 멤버는 is not visible
	}

}
