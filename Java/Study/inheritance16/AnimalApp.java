package inheritance16;

public class AnimalApp {

	public static void main(String[] args) {
		Dog scratch = new Dog("포유류",2,"수컷","슈나우저");
		scratch.printDog();
		scratch.bark();
		System.out.println(scratch.age);	//자식 인스턴스 변수로 동일한 필드명에 접근시 무조건 자식의 필드에 접근
		// ◆ 자식의 인스턴스 변수로 동일한 필드가 존재할때 부모의 필드에 접근하기
		// ◆ 1) 부모의 age를 반환하는 메소드를 정의(dog 44)
		System.out.println(scratch.getSuperAge());
		
		// ◆ 2) 형변환
		System.out.println(((Animal)scratch).age);
		
	}

}

