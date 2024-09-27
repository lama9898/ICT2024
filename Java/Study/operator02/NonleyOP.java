package operator02;

public class NonleyOP {

	public static void main(String[] args) {
		/* 논리연산자 */
		/*	- 논리연산(이항연산자/단항연산자)의 결과값은 true,false
		 * 
		 *  - && : and 연산자 (논리곱), 두 항이 참일때만 참, '그리고'
		 *  - || : or 연산자 (논리합), 두 항중 하나만 참이어도 참, '또는, 혹'
		 *  - !(단항연산자) : not 연산자(논리부정) 단항이 참이면 → 거짓, 거짓이면 → 참, '아니다'
		 *  - ^(이항연산자) : xor 연산자(배타적), 두 항이 서로 다르면 참, 같으면 거짓
		 *  
		 *  - 논리 연산자 우선순위 : ! > && > ||,^
		 *  - &&와 &, ||와 |의 결과값은 각각 같음.
		 *  - &&은 첫째항이 거짓이면 두번째항을 계산하지 않음.
		 *  - &은 첫째항이 거짓이어도 두번째항을 계산함.
		 *  - 산술 > 비교 > 논리 연산자 순으로 우선순위 적용됨
		 */
		
		int num1 = 15, num2 = 10;
		boolean b = num1 >= num2 && num1==num2; //논리식
		System.out.printf("%d >= %d && %d==%d의 결과는 %b\n",num1,num2,num1,num2,b);
		b = true || false;
		System.out.printf("%b || %b의 결과는 %b\n",true,false,b);
		b = num1 <= num2 ^ num1 != num2;
		System.out.printf("%d <= %d ^ %d != %d의 결과는 %b\n",num1,num2,num1,num2,b);
		b=10%3>6-2*2&&10<6*2||5*3!=10;
		System.out.println("b는 "+b);
		b = !true||true^false&&true;
		//not true or true nor false and true
		//true nor false
		//true
		
		/*
		System.out.println("b는 "+b);
		Ref ref = new Ref();
		System.out.println(ref.data==100);	//true
		*/
		
		/*	
		Ref ref = null;
		
		// nullpointer exception; ref = null, null에 접근하여 data를 불러올수없음
		//System.out.println(ref.data ==100);
		System.out.println(ref != null && ref.data=100);
		System.out.println(ref !=null & ref.data==100);
		//nullpotiner exception , ref.data에 접근 시 에러
		*/

		
		
	}	//main

}	//class

class Ref {
	int data = 100;
}
