package console.academy;

public class Teacher extends Person {
	//field
	String subject;	//student에서 확장한 멤버

	//생성자
	public Teacher(String name, int age, String strNumber) {
		super(name, age);
		this.subject = strNumber;
	}

	//method
	@Override
	String get() {
		// TODO 학번 추가
		return String.format("%s, 과목: %s", super.get(),subject);
	}

	@Override
	void print() {
		// TODO
		System.out.println(get());
	}
}
