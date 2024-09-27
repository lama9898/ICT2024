package controlstatement03;

public class BreakContinue {

	public static void main(String[] args) {
		/* 기타 제어문 : continue, break문
		 * 1. continue : continue문을 만나면 반복문 처음으로 마이동
		 * 		- for문 : continue 사용시 증감식 실행
		 * 		- while문 : continue 사용시 반복조건 실행
		 * 2. break : break문을 만나면 switch문, 반복문을 빠져나감
		 */
		
		// break;	// loop, switch 밖에서는 사용불가
		// continue	// loop 밖에서는 사용불가

		int i=0;
		while(i<100000000) {
			i++;
			System.out.printf("[ i가 %d일 때 ]\n",i);
			System.out.println("continue문 이전 출력");
			if(i%2==0) continue;
			System.out.println("continue문 이후 출력");
			
			System.out.println("break문 이전 출력");
			if(i==3) break;
			System.out.println("break문 이후 출력");
			// i++; 밑에 두면 continue문 때문에 무한루프 생성
		}
	}	//main

}	//class
