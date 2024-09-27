package polymorphism14;

/*
-자바의 모든 클래스의 최상위 부모는 Object클래스이다
-Object클래스의 toString()메소드는 객체의 주소를
 String으로 반환해주는 메소드다
-Object클래스의 equals()메소드는
 두 객체간의 인스턴스비교
 즉 주소값 비교,주소가 같으면 true,다르면 false반환
 Object클래스의 String toString()메소드]
		 :객체의 주소를 문자열로 반환
		  패키지명.클래스명@주소(16진수)
 ※toString()메소드 오버라이딩시 반드시 hashCode()메소드도 오버라이딩하자		 
 Object클래스의 boolean equals()메소드]
        : 비교 클래스의
          인스턴스변수.equals(대상클래스의 인스턴스변수)
          두 객체의 주소비교
*/


class MyClass{
	int data;
	
	public MyClass(int data) {
		super();
		this.data = data;
	}

	//실제 저장된 데이터가 반환되도록 Object로부터 상속받은 toString()메소드 오버라이딩 해보기
	
	// ※toString()메소드 오버라이딩시 반드시 hashCode()메소드도 오버라이딩하자  : 문자열 변환시 16진수 변환이 있기 때문
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(data);
	}
	
	/*
	@Override
	public int hashCode() {
		return data;
	}
	*/

	@Override
	public boolean equals(Object obj) {

		if(obj instanceof MyClass) {
			MyClass mc = (MyClass)obj;
			if(this.data == mc.data) {	return true; }
			else return false;	// 값이 다른 경우
		}
		return false;	// 타입이 myclass아닌경우 비교자체가 불가능 하니 false
	}
	
	// toString()오버라이딩 후메모리 주소를 문자열로 반환하기 위한 메소드
	// 단, hashCode()를 오버라이딩X
	int getHashCode(){
		return super.hashCode();
	}
	
	String getAddress() {
		return super.toString();
	}	
}

class Point{
	int x,y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// 문제1] x=10, y=20처럼 반환하도록 하고 toString()메소드 오버라이딩
	@Override
	public String toString() {
		return "x="+this.x+", y="+this.y;
		//return String.format("x=%d,y=%d", x,y);
	}
	
	// 문제2] 저장된 x좌표와 y좌표가 같은지 비교하도록 equals메소드 오버라이딩
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point p = (Point)obj;
			if(this.x==p.x&&this.y==p.y) return true;
			else return false;
		}
		else return false;
	}
}


public class ObjectClass {

	public static void main(String[] args) {
		MyClass mc1 = new MyClass(10);
		MyClass mc2 = new MyClass(10);
		
		System.out.println(" [두 객체의 toString() 호출] ");
		System.out.println(mc1);
		System.out.println(mc1.toString());
		System.out.println(mc1.getClass().getName()+'@'+Integer.toHexString(mc1.hashCode()));
		System.out.println(mc2);
		System.out.println(mc2.toString());
		System.out.println(mc2.getClass().getName()+'@'+Integer.toHexString(mc2.hashCode()));
		
		System.out.println(" [두 객체를 eqauls() 메소드로 비교] ");
		
		System.out.println("mc1의 10진수 형태의 주소: "+ mc1.getHashCode()+", 16진수: "+Integer.toHexString(mc1.getHashCode()));
		System.out.println("mc2의 10진수 형태의 주소: "+ mc2.getHashCode()+", 16진수: "+Integer.toHexString(mc2.getHashCode()));
		System.out.println(mc1.equals(mc2));	//object의 equals 이용 : heterogeneous
		
		System.out.println("mc1의 클래스명@16진수 형태의 주소: "+ mc1.getAddress());
		System.out.println("mc2의 클래스명@16진수 형태의 주소: "+ mc2.getAddress());

		Point point1 = new Point(10,20);
		Point point2 = new Point(10,20);
		System.out.println("[toString 호출]");
		System.out.println(point1);
		System.out.println(point2);
		System.out.println("[equals() 호출]");
		System.out.println(point1.equals(point2));
		
		
	}

}
