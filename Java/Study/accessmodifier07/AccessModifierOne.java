package accessmodifier07;

/*
	접근지정자:클래스와 클래스 사이 혹은 클래스의 멤버간의 접근을 제어하는 기능을 가진 한정자
	         private < default(생략형,package) < protected < public
	private:자기 클래스안에서만 접근가능.
	                다른 클래스에서는 접근 불가능
	public: 모든 클래스에서 접근 가능
	생략형(패키지접근지정자,디폴트접근지정자):
	같은 패키지내에 있는 클래스들끼리는 접근가능	
	[접근지정자를 붙일 수 있는곳]:
	1]접근지정자 [modifier] class 클래스명
	2]접근지정자 [modifier] final 자료형 멤버상수=초기값:접근지정자와 modifier는
	  순서는 상관없다
	  final 접근지정자 자료형 멤버상수=초기값
	3]접근지정자 [modifier] 자료형 멤버변수;
	4]접근지정자 [modifier] 반환타입 메소드명;
	  단, class 앞에 붙일 수 있는 접근지정자는 public과
	  생략형(package)만 붙일 수 있다.
	  결론: 인터페이스 와 클래스와 클래스의 모든 멤버에는 접근지정자를
	           붙일 수 있다.
		
*/

	//private class PrivateClass{ }	//클래스는 private 불가
	
	class PackageClass{	// ▼▼▼ main있는 클래스에 public class가 두개있을 수 X
		
	}


	public class AccessModifierOne {
		// 필드
		public int publicVar;
		int packageVar;
		private int privateVar;
		
		// 멤버 메소드
		public void publicMethod() {
			//다른 클래스에서 직접 호출이 불가능(접근불가) → 접근이 가능한 메소드에서 호출 →
			// 접근이 가능한 메소드에서 호출 한다
			privateMethod();
		}
		
		void packageMethod() {
			
		}
		
		private void privateMethod() {
			//private이 붙은 멤버는 자기 클래스안에서는 어디서든 접근 가능
			System.out.println(privateVar);
		}
		
	public static void main(String[] args) {
		
	}
}
