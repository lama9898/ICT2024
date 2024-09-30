package innerclass22;

// 내부 정적 클래스 : 빌더 패턴(클래스 설계시 디자인 패턴의 하나)으로 객체 생성에 사용
/*
 * 빌더 패턴 : 객체 생성과 관련된 디자인패턴, 인자가 많은 객체 생성할 대 유리(필수인자만 세팅가능)
 */

class Member{
	// ■ 규칙 1. 멤버 변수는 private으로 설정
	// 필수항목인 경우
	private String id;
	private String name;
	// 선택항목인 경우
	private String tel;
	private String addr;
	
	// ■ 규칙 2. 내부 정적 클래스 정의
	public static class Builder{
		// ■ 규칙 3. 외부 클래스와 똑같은 멤버변수(필드)를 갖는다.
		private String id;
		private String name;
		private String tel;
		private String addr;

		// ■ 규칙 4. 내부 클래스 인자 생성자 생성 (필수 항목이 없는 경우 모두 setter로 초기화)
		// 4-a. 필수항목만 받는 인자 생성자 생성
		public Builder(String id, String name) {
			this.id = id;
			this.name = name;
		}
		
		// ■ 규칙 5. 선택항목인 멤버변수를 초기화 하는 setter 생성(void가 아니라 Builder 타입으로, 반환은 this로)
		public Builder setTel(String tel) {
			this.tel = tel;
			return this;
		}
		
		public Builder setAddr(String addr) {
			this.addr = addr;
			return this;
		}
		
		// ■ 규칙 7. 외부 클래스 타입(Member)을 반환하는 메소드 정의
		public Member build() {
			return new Member(this);
		}
		
		
	} // inner class Builder
	
	// ■ 규칙 6. 내부 정적 클래스 타입(Builder)을 인자로 받는 생성자 정의하기
	public Member(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.tel = builder.tel;
		this.addr = builder.addr;
	}
	
	@Override
	public String toString() {
		return String.format("ID : %s, 이름 : %s, 전화번호 : %s, 주소 :%s", id,name,tel,addr);
	}
}	//outer class Member



public class InnerStaticBuilder {

	public static void main(String[] args) {
		// ■ → ◆
		// ◆ 1) 필수항목으로만 Member 객체 생성
		Member member1 = new Member.Builder("llama03", "Lee").build();
		System.out.println(member1);
		
		//
		Member member2 = new Member.Builder("llama04", "Kim").setTel("010-1234-5678").build();
		System.out.println(member2);
		
		Member member3 = new Member.Builder("llama05", "Park")
				.setTel("010-0000-0000").setAddr("서현동").build();
		System.out.println(member3);
		

	}	// main

}	//class InnerStaticBuilder
