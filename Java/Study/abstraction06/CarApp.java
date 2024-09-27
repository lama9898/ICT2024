package abstraction06;

class Car{
	
	// const
	public static final String AUTO="자동";
	public static final String MANUAL="수동";
	
	// field
	String carModel;	//제네시스, 투싼, ...
	String carGear = AUTO;	//차량기어
	int carYear;	//차 연식
	Person owner;	//차량 소유주
	
	// method
	void drive() {
		System.out.println(owner.name+"가(이) "+carModel+"를(을) 운전한다.");
	}
	
	// 초기화용 메소드
	void initalize() {
		carModel = "제네시스 G80";
		carYear = 2024;
		owner = new Person();
		owner.age = 20;
		owner.name = "덕복희";
		owner.weight = 70;
		
	}
	
	void printCar() {
		System.out.println("--차량정보--");
		System.out.println("모델명 : "+carModel);
		System.out.println("연식 : "+carYear);
		System.out.println("기어 : " + carGear);
		System.out.println("소유주");
		owner.printPerson();	//owner 아직 할당X => null pointer 에러
	}
	
	
}	// car


public class CarApp {

	public static void main(String[] args) {
		/*
		 * car클래스(설계도)로 car타입의 메모리 생성(객체화,인스턴스화)
		 */
		Car car1 = new Car();
		System.out.println("필드 초기화용 메소드 'initalize' 호출 전 -");
		//car1.printCar();
		
		System.out.println("필드 초기화용 메소드 'initalize' 호출 후 -");
		car1.initalize();
		car1.printCar();
		
		Car car2 = new Car();
		car2.carModel="포르쉐";
		car2.carYear=2024;
		// 클래스의 멤버(변수,메소드, 상수)에 static이 붙으면 클래스명으로 접
		car2.carGear=Car.MANUAL; 	//인스턴스 변수보다는 클래스명으로 접근
		car2.owner = new Person();
		car2.owner.age = 30;
		car2.owner.name = "덕얌희";
		car2.owner.weight = 60;
		car2.printCar();
		car2.drive();

	}	//main

}	//class
