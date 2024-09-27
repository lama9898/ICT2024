package operator02;

public class BeekyoOp {

	public static void main(String[] args) {
		/* 비교연산자 */
		/*  - 비교연산자(이항연산자)의 결과는 true아니면 false(boolean)
		 *  - > , >= , < , <= , != , ==
		 *  - 비교연산자는 모두 우선 순위가 같다
		 *  - 산술연산자가 비교연산자보다 우선순위가 높다
		 *  - 비교연산자를 사용한 식은 비교식
		 * 
		 */
		
		int num1 = 10, num2 = 20;
		System.out.println(num1>num2);
		boolean b = num1 == num2;
		System.out.printf("%d==%d의 결과 : %b\n", num1, num2, b);
		b = num1 != num2;
		System.out.printf("%d!=%d의 결과 : %b\n", num1, num2, b);

		b = 15%3*2+4>(10-2)*4!=true; //비교식
		//	5*2+4>8*4!=true
		//  10+4>32 != true
		//  14>32 != true : true
		
		System.out.printf("15%%3*2+4>(10-2)*4!=true의 결과 : %b",b);
		
		
	}	//main

}	//class
