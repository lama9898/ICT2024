package polymorphism14;

/*
 * instance of 연산자
 * 	- 두 클래스간의 형 변환이 가능한지 판단하는 연산자
 *  - 해당 인스턴스 변수가 어떤 타입의 변수인지 판단 가능
 *  - 두 클래스 간에 상속관계가 있어야 함 : 즉 is-a 관계가 성립해야함
 *  - 해당 인스턴스 변수가 해당 타입이면 true, 아니면 false
 *  
 *  형식 : 인스턴스변수 instanceof 클래스타입
 * 
 */

class Super {}
class Normal extends Super{}


public class InstanceOfOP {
	public static void main(String[] args) {
		//1. 두 클래스간 상속관계가 존재 하지 않을때
		String str = new String("Java");
		StringBuffer buf = new StringBuffer();
		
		
		//str = buf //불가
		//buf = str //불가
		//str = (String)buf;	//불가
		//buf = (StringBuffer)str;	//불가
		//  상속관계 미 존재시 대입 연산 및 형변환 불가
		
		// 상속관계 없을때 instanceOf 연산자 사용시 컴파일 에러가 남
		//System.out.println(str instanceof StringBuffer);
		//System.out.println(buf instanceof String);
		System.out.println(str instanceof String);
		System.out.println(str instanceof Object);
		
		Object obj = new Object();
		//String strObj = obg;	//obj가 부모
		//String strObj = (String)obj;	// 에러 : Object는 obj의 메모리만 있음. String 메모리 없음
		
		obj = new String("가능");	//
		String strObj = (String)obj;
		// 2. 두 클래스간 상속관계가 존재 할 때
		/*
		 * instanceof 연산자로 선 판단하지 않고 형변환시
		 * 
		 * - 상속 관계는 존재하나 형변환이 불가한 경우 : 컴파일 에러는 발생하지 않으나 실행시 에러 (런타임에러) : ClassCastException
		 * - 실행시 에러를 피하기 위해 반드시 instanceof 로 판단 후 형변환 하기
		 * 
		 */
		
		Object obj1 = new Object();
		System.out.println(obj1 instanceof String);	// false
		if(obj1 instanceof String) {
			String strObj1 =(String)obj;
			System.out.println("형변환 일어남1");
		}
		obj1 = new String("Java");
		System.out.println(obj instanceof String);
		if(obj1 instanceof String) {
			String strObj1 =(String)obj;
			System.out.println("형변환 일어남2");
		}
		
		Super s = new Super();
		System.out.println(s instanceof Super);	//true
		System.out.println(s instanceof Object); //true
		System.out.println(s instanceof Normal); //false s를 normal로 형변환 불가
		//Normal n = (Normal)s;	//ClassCastException
		s = new Normal();	//자식타입의 메모리 주소 넣어놓기
		System.out.println(s instanceof Normal);
		Normal n = (Normal)s;	//실행가능
		
		
	}

}
