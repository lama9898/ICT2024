package inheritance16;

public class PersonApp {

	public static void main(String[] args) {
		Student student1 = new Student();
		student1.printStudent();
		student1.addr = "백현동";
		student1.age = 24;
		student1.name="이수경";
		student1.stdNumber="32173098";
		System.out.println(student1.getStudent());
		
		Student student2 = new Student("이명헌",40,"아키타현","1988학번");
		student2.printStudent();
		student2.study();
		
		//Teacher teacher = new Teacher();	//기본생성자 사용 불가 = 인자생성자 만들었으니깐
		Teacher teacher = new Teacher("Neil Newbon",44,"England","Acting");
		teacher.printTeacher();

		// 자식 생성자 호출 시 : 부모 기본 생성자가 호출됨
		
		
	}

}
