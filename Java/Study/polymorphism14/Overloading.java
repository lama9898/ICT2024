package polymorphism14;

import java.util.Date;

public class Overloading {

	// Overloading : 중복정의
	/*
	 * 	하나의 클래스 안에서 같은 이름의 메소드를 여러개 정의할 수 있다.
	 * 
	 *  조건 :
	 *  	- 매개변수 갯수가 다름
	 *  	- 갯수가 같다면 매개변수 타입이 다름
	 *  	- 타입과 갯수가 같다면 매개변수 순서가 다름
	 *  	- 반환 타입 관계없음
	 */
	
	//int noOverloading(String str, Date date) {	return 0;	}
	//String noOverloading(String str2, Date date2) {	return "";	}	// 반환타입은 관계없음!
	
	// method Overloading ...
	
	// 1. 매개변수 타입 다름.
	void paramTypeDiff(int param) { }
	void paramTypeDiff(float param) { }
	void paramTypeDiff(double param) { }
	
	// 2. 매개변수가 다른 경우
	void paramCountDiff() { }
	void paramCountDiff(int param1) { }
	void paramCountDiff(int param1, int param2) { }
	
	// 3. 매개변수 타입이 같고 개수도 같음. 순서 다르게
	void paramOrderDiff(int param1, float param2, double param3) { }
	void paramOrderDiff(float param2, double param3, int param1) { }
	void paramOrderDiff(double param3, int param1, float param2) { }
	
	// 4. 매개변수 개수에 따라서 매번 오버로딩 하지 않고 VarArgs라는 기능을 이용해서 하나의 메소드로 처리
	/*
	 *  : datatype name(datatype ... argsName){ }
	 */
	
//	static int getTotal(int args) {
//		int sum=0;
//		sum+=args;
//		return sum;
//	}
//	static int getTotal(int args1, int args2) {
//		int sum=0;
//		sum= args1+args2;
//		return sum;
//	}
//	static int getTotal(int args1, int args2,int args3) {
//		int sum=0;
//		sum= args1+args2+args3;
//		return sum;
//	}
	
	// VarArgs 기능 사용
	static int getTotal(int ... args) {
		System.out.printf("args:%s,배열크기:%d\n",args,args.length);
		int sum=0;
		for(int i=0;i<args.length;i++) {
			sum+=args[i];
		}
		return sum;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("총합 : "+getTotal(10));
		System.out.println("총합 : "+getTotal(10,20));
		System.out.println("총합 : "+getTotal(10,20,30));
		
		
	}	//main

}	//class




