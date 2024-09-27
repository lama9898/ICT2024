package operator02;

public class HaldangOP {

	public static void main(String[] args) {
		/* 할당(대입)연산자 */
		/*	= : 변수에 값을 대입하는 연산자
		 *  - 축약 표현 : +=,-=, *=, %= 등등
		 *  - 변수 ±= 값 → 변수 = 변수+값
		 */
		
		int num1; // 변수 선언
		num1 = 100;	//대입 연산자는 오른쪽부터 실행 후 결과값을 왼쪽 변수에 대입
		int num2;
		num2 = num1;
		// 산술연산자에만 적용
		num1+=100; //num1 = num1+100
		System.out.printf("num1:%d, num2:%d\n",num1,num2);
		
		num1 %=num2; //num1 = num1 % num2
		System.out.printf("num1:%d, num2:%d\n",num1,num2);
		
		num2 *= 2+10; // num2 = num2* (2+10), 대입연산자는 오른족부터 실행
		System.out.printf("num1:%d, num2:%d\n",num1,num2);
		
		//num1 &&=num2; //논리연산자에는 적용 불가능
		
		/* 증감연산자(단항 연산자) */
		/*	++, --
		 *  - 자기자신을 +1증가/-1감소
		 *  - 단독으로 쓰일때는 위치에 따른 차이가 없음
		 *  - 다른 연산자와 결합시에는 위치에 따라 차이가 생김
		 *  - ±변수 : (변수+1) 후 연산참여 "전위 연산자"
		 *  - 변수± : 연산작용 후 +1 "후위 연산자"
		 */
		int num3 = 10;
		
		// 다른 연산과 함께 사용시
		// 후위 연산은 다른 연산을 먼저 수행한 후 마지막에 자기자신을 증가/감소 시킴 
		System.out.printf("x:%d\n",num3);
		System.out.printf("++x:%d\n",++num3);	//전위연산자
		System.out.printf("x++:%d\n",num3++);	//후위연산자
		System.out.printf("x++ after:%d\n",num3);
		
		int num4 =10;
		//int result = num3 + num4++;	//	num3:12, num4:11, result:22
		// 과정 :
		//num4 + num3 = 10 +12
		//result = 22
		//num4 = num4 + 1, num4 = 11
		int result = num3 + ++num4;		//	num3:12, num4:11, result:23

		System.out.printf("num3:%d, num4:%d, result:%d\n",num3,num4,result);	
		
		
		
		
	}	//main

}	//class
