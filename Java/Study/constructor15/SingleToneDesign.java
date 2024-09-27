package constructor15;


// 싱글톤 디자인 : 클래스를 설계하는 디자인 패턴의 하나로, 하나의 인스턴스 즉 하나의 메모리 생성 후 이를 공유해서 사용
// 하나의 메모리를 서로 공유해서 사용함으로 값 변경시 문제가 발생 할 수 있음 -> 읽기 전용

/*	방법1. 생성자의 접근 지정자를 private, 정적 메소드로 해당 클래스의 객체를 반환하도록 정의
 *  방법2. 정적 메소드로 해당 클래스의 객체를 반환하도록 정의
 * 		 
 */

// 싱글톤으로 미 설계시
class NoSingleTone{
	int noShareVar;
	void print() { System.out.println("noShareVar"+noShareVar); }
}

// 싱글톤으로 설계시
class SingleTone{
	int shareVar;
	// 2'. 해당 클래스의 객체 생성
	private static SingleTone single = new SingleTone();
	// static 제거 불가, 인스턴스형 멤버이기 때문
	
	// 1. 접근지정자를 private
	private SingleTone() { }
	
	// 멤버 메소드
	// 2. 정적 메소드로 해당 클래스의 객체를 반환하도록 정의
	public static SingleTone getInstance() { 
		return single;	//single = SingleTone객체 주소
	}	// Calendar도 SingleTone, 달력은 모두가 공유하기 때문에
	
	
	void print() { System.out.println("shareVar"+shareVar); }
}

public class SingleToneDesign {

	
	public static void main(String[] args) {
		
		//싱글톤으로 미 설계 시 
		//new할때마다 메모리가 생김
		NoSingleTone no1 = new NoSingleTone();
		no1.noShareVar = 100;
		no1.print();
		
		NoSingleTone no2 = new NoSingleTone();
		no2.noShareVar =200;
		no2.print();
		
		
		//System.out.println(String.format());
		System.out.println(String.format("no1:%s,no2:%s,noshareVar(no1);%s,noshareVar(no2):%s",no1,no2,no1.noShareVar,no2.noShareVar));
		
		//싱글톤으로 설계시
		//SingleTone st1 = new SingleTone();	//private이기때문에 안보임.
		SingleTone st1 = SingleTone.getInstance();
		st1.shareVar=100;
		st1.print();
		
		SingleTone st2 = SingleTone.getInstance();
		st2.shareVar=200;
		st2.print();
		
		System.out.println(String.format(
				"st1:%s,st2:%s,shareVar(st1);%s,shareVar(st2):%s",st1,st2,st1.shareVar,st2.shareVar));
	}
}
