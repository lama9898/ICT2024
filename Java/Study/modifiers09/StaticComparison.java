package modifiers09;

import java.util.Scanner;

//<복습>
/*
 * 멤버 변수(x,y)에 저장된 값으로 덧셈을 하는 계산기에서는 x와 y값을 저장하는 멤버변수를 static으로 지정하면 안됨
 * 각 계산기(인스턴스 객체)마다 공유 메모리(static)에 저장된 값을 사용하기 때문.
 * x,y값을 멤버 변수에 있는 값을 사용하지 않고, add(x,y) 메소드의 인자로 받아서 덧셈을 한다면 이때는 add(x,y) 메소들를 static으로 공유해주는게 유리
 */

class CalcHavingInstance{
	int x,y;	// 인스턴스형 멤버변수(필드)
	void add() {	// 매개변수에 값을 안받고 멤버변수에 저장된 값으로 더하기 하는 메소드
		System.out.println("덧셈결과: x+y="+(x+y));
	}
}
	
class CalcHavingStatic{
	static int x,y;
	void add() {
		System.out.println("덧셈결과: x+y="+(x+y));
	}
}

class CalcAddStatic{
	static void add(int x, int y) {
		System.out.println("덧셈결과: x+y="+(x+y));
	}
}

public class StaticComparison {
	
	//■ 오버라이딩
	int value;
	
	public StaticComparison(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		//return super.toString();
		return String.valueOf(value);
	}

	public static void main(String[] args) {

		
		System.out.println("필드 x,y 및 add()가 인스턴스형인 경우");
		CalcHavingInstance chi1 = new CalcHavingInstance();
		chi1.x=10;
		chi1.y=20;
		chi1.add();
		CalcHavingInstance chi2 = new CalcHavingInstance();
		chi2.add();
		chi1.x=100;
		chi2.y = 200;
		chi2.add();
		chi1.add();
		
		
		System.out.println("필드 x,y가 정적인 경우");
		CalcHavingStatic.x=10;
		CalcHavingStatic.y=20;
		CalcHavingStatic chs1 = new CalcHavingStatic();
		chs1.add();
		CalcHavingStatic chs2 = new CalcHavingStatic();
		chs2.add();
		CalcHavingStatic.x=100;
		CalcHavingStatic.y=200;
		chs2.add();
		chs1.add();
		
		System.out.println("add()가 정적인 경우");
		CalcAddStatic.add(10,20);
		CalcAddStatic.add(100,200);
		
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		System.out.println(sc);
		System.out.println(sc.toString());
		System.out.println(sc.getClass().getName());
		
		Integer num = new Integer(10);
		System.out.println(num);
		System.out.println(num.toString());	//■ 오버라이딩 : object의 toSring을 오버라이딩함, 저장된 데이터를 문자열로 반환하도록
	}

}
