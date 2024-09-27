package accessmodifier07;

public class General {
	
	void access() {
		Super sup = new Super();
		
		//sup.privateMethod();
		
		sup.packageMethod();
		sup.protectedMethod();
		sup.publicMethod();
	}

}
