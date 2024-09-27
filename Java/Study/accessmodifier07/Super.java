package accessmodifier07;
//2024.04.04


public class Super {
	//필드
	private void privateMethod() {}
	void packageMethod() {}
	protected void protectedMethod() {}
	public void publicMethod() {}
	//자기 클래스 안에서는 모든 멤버 접근 가능
	void call() {
		privateMethod();
		packageMethod();
		protectedMethod();
		publicMethod();
	}
}
