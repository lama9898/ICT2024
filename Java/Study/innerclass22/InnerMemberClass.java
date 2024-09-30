package innerclass22;

// zzZ

/*
	[내부 멤버 클래스]:클래스안의 클래스로 static이 안붙음
	- 외부 클래스의 모든 멤버(정적이든 인스턴스형이든)를 사용할 수 있다.
	- 정적 멤버는 가질 수 없다(JDK15까지만)
	  단,JDK16이후 부터는 정적 멤버도 가질수 있게 되었다.
	  JDK16이후 부터는 제약이 완화되었다.
	  그래서 외부클래스와 별개의 다른 클래스에서도 외부클래스 인스턴스화 없이
	  내부의 정적 멤버에 접근 할수 있게 되었다
	 
	- 외부클래스명$내부클래스명.class로 파일이 생긴다.
	- 이벤트 기반 프로그래밍( GUI프로그래밍):윈도우 프로그래밍,웹프로그래밍,모바일 프로그래밍등
	   시 주로 사용
	
	 ※외부 클래스에서 내부 클래스의 멤버 접근에 관한 이론
	 
	  -외부 클래스에서는 내부 클래스의 멤버 접근 불가	
	  -외부 클래스에서 내부 클래스의 멤버에 접근하려면
	       내부 클래스를 인스턴스화 한 후에 접근할 수 있다
	   단,외부의 정적 메소드에서는 내부의 정적 멤버만 인스턴스화 없이
	   내부클래스명.정적멤버로 접근 가능
  
*/

class OuterClass{

	//field
	int outerInstanceVar;
	int sameVar;
	static int outerStaticVar;
	
	// ◆ 2-a)'. 외부 클래스에 내부 클래스 인스턴스화하기
	InnerClass inner = new InnerClass(); //＠＠＠ InnerClass inner
										 //: 필드 선언 후 생성자에서 public OuterClass(){inner = new Inner();}와 같음 
	//method
	void outerInstanceMethod() {
		// 외부에서 내부 접근 : 외부에서는 내부의 멤버에 접근이 불가 (접근하기 위해서는 반드시 내부 클래스를 인스턴스화 해야함 : ＠＠＠) 
		// System.out.println(innerInstanceVar);
		System.out.println(inner.innerInstanceVar);
	}
	
	static void outerStaticMethod() {
		//외부의 정적 멤버 : 
		//InstanceVar는 접근불가
		//System.out.println(inner.innerInstanceVar;);
		System.out.println(InnerClass.innerStaticVar);	
	}
	
	// 내부 멤버 클래스
	class InnerClass{
		//field
		int innerInstanceVar;
		int sameVar=1;
		static int innerStaticVar;	// JDK 16전까지는 컴파일 에러, 16이후로는 가능
		
		public InnerClass() {
			System.out.println("내부 클래스의 생성자");
		}
		
		void innerInstanceMethod() {
			// 내부 클래스에서는 외부의 모든 멤버 사용 가능
			// 복습 지점 zzzzzzzzzzzzzzzzzzzzzzzzzzzz
			System.out.println(OuterClass.this.outerInstanceVar);
			System.out.println(OuterClass.outerStaticVar);
			outerInstanceMethod();
			outerStaticMethod();
			// 외부 vs 내부멤버 충돌 시
			// 내부 클래스 내의 this는 내부 클래스, 내부클래스안에서 외부클래스명.this는 외부클래스
			//this.sameVar = sameVar	// 내부 멤버변수 = 내부 멤버변수
			OuterClass.this.sameVar = sameVar; // 외부 멤버변수 = 내부 멤버변수
			
		}
		
		static void innerStaticMethod() {	//클래스 로드 시 메모리에 생김 - class
			// 내부에서 외부 접근하기 : 외부의 정적멤버만 사용가능
			// System.out.println(outerInstance);	// 참조불가
			System.out.println(outerStaticVar);//static 멤버라서
			
			//outerInstanceMethod();
			outerStaticMethod();
		}
	// 컴파일하면 총 3개의 클래스파일(bin) 생김	
	}
}


public class InnerMemberClass {

	
	
	public static void main(String[] args) {
		//InnerClass inner = new InnerClass();	// 다른클래스의 내부클래스는 인스턴스화 할 수 없음
		//다른 클래스의 내부 클래스 인스턴스화 하기 ◆
		//◆ 1) 외부 클래스를 먼저 인스턴스화(필수)
		OuterClass outerclass = new OuterClass();
		//◆ 2-a) 외부클래스에 내부 클래스를 인스턴스한 경우
		System.out.println(outerclass.inner.innerInstanceVar);
		
		//◆ 2-b) 외부클래스에서 내부 클래스 인스턴스 안한 경우
		// 외부클래스명.내부클래스 변수명 = 외부클래스인스턴스변수.new 내부클래스명()
		OuterClass.InnerClass inner = outerclass.new InnerClass();
		System.out.println(inner.innerInstanceVar);
	}
}
