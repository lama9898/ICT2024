package operator02;

public class BitOP {

	public static void main(String[] args) {
		/* 비트 연산자 : 비트 단위로 계산함 */
		/* 쉬프트(Shift) 연산자(이항연산자)
		 *  - 두 항이 반드시 정수여야한다.
		 *  [정수] << [이동할 비트수] : 왼쪽으로 비트수만큼 이동, 오른쪽에 남은 비트를 0으로 채움
		 *  [정수] >> [이동할 비트수] : 오른쪽으로 비트수만큼 이동, 왼쪽에 남은 비트를 부호비트로 채움, 1:음수, 0:양수
		 */
		
		byte b1 = 10, bit1 = 2;
		int result = b1 << bit1; //10을 왼쪽으로 2비트만큼 이동 : 00001010 << 2 → 00101000 : 40
		System.out.printf("%d << %d의 결과 : %d%n",b1,bit1,result);
		
		b1 = -9;
		result = b1 >> bit1; // -9를 오른쪽으로 2비트만큼 이동 : 10001001 >> 2 → 10100010 : - 
		System.out.printf("%d << %d의 결과 : %d%n",b1,bit1,result);
		
		// &-1) 논리연산자로 사용된 경우, 양 옆에 논리값이 온 경우
		// &-2) 비트연산자로 사용된 경우, 양 옆에 정수가 온 경우
		b1 = 3;
		byte b2 = -15;
		System.out.println("논리 연산자로 사용된 경우 : "+(false & 10>5));
		System.out.println("비트 연산자로 사용된 경우(AND) : "+(b1 & b2));
		// b1 = 3/00000011, b2 =-15/10001111
		
		System.out.println("비트 연산자로 사용된 경우(OR) : "+(b1 | b2));
		// 3: 0000 0011, -15: 1111 0001
		// 0000 1110

	}	//main

}	//class
