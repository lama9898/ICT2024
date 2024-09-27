package operator02;

public class SansulOP {

	public static void main(String[] args) {
		/* 산술연산자 */
		/*	- 산술연산자(이항 연산자)의 결과는 다양
		 *  - 산술연산자내 에서의 연산 우선순위 : ( * % / ) > ( + - )
		 *  	> *:곱하기, %:나머지, /:나누기
		 *  - 우선순위가 같은 경우 왼쪽에서 → 오른쪽으로 연산
		 *  - 산술 연산자를 써서 식을 만들면 산술식
		 */
		
		int result = 3*2 + 5%2 - 6/3*5;
		//	순서:		  1     2     3
		//				 5	   6	4
		System.out.printf("3*2 + 5%%2 - 6/3*5의 결과 : %d",result);
		//코드상 문제 X, 실행시 오류 : "런타임 오류"
		//printf 속 %로 인해 오류 : %%로 해결

	}	//main

}	//class
