package constructor15;

// this()
/*	- 자기 자신의 기본 생성자를 의미
 * 	- 항상 생성자안에서만 사용 가능
 * 	- 생성자 안에서도 맨 첫번째 문장에 와야함.
 * 	- 멤버변수만큼 인자를 가진 인자 생성자를 호출하기 위해서 주로 사용(멤버변수보다 적은 인자를 가진 생성자 안에서)
 */

class Point {
	//field
	private int x,y;
	
	public Point() {
		//this.x=1;
		//this.y=2;
		this(1,2);
		System.out.println("기본 생성자");
	}
	
	public Point(int x) {
		//this.x=x;
		//this.y=2;
		this(x,2);
		System.out.println("인자 생성자 : x");
	}
	public Point(int x,int y) {
		this.x=x;
		this.y=y;
		System.out.println("인자 생성자:x,y");
	}
	void print() {
		//this(1,2) : X 생성자에서만 호출가능
		System.out.printf("x:%s, y:%s\n",x,y);
		
	}
}


public class Constructor03 {

	public static void main(String[] args) {
		Point point1 = new Point();
		point1.print();
		Point point2 = new Point(10);
		point2.print();
	}

}
