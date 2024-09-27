package datatype01;

public class TypeCasting {

	public static void main(String[] args) {
		
		/* 형변환 */
		
		// 1. 자동 형변환, 묵시적 형변환 
		byte b1;
		b1= 127;
		short s1;
		s1 = b1; // 자동 형변환
		System.out.printf("b1은 %d, s1은 %d\n",b1,s1);
		
		int num1 = b1+s1; //b1+s1의 결과값은 4byte, int형 ∴ 같은 자료형이므로 자동형변환 일어나지 않음
		
		char ch1 = 65; // 'A'
		//char ch2 = b1;
		// char는 2byte인데 에러나는 이유 : 예외! char는 부호X, byte는 부호O
		// 형변환이 필요. b1은 변수임으로 음수가 저장되어있을 수 있음. but 코드값(char형)은 음수가 없음
		
		b1=97;
		char ch2 = (char)b1;
		System.out.printf("ch2=%c\n",ch2);
		
		
		
		// 2. 강제 형변환, 명시적 형변환
		
		
		// ◆ 2-1) 데이터 손실
		short s2 = 100;
		//byte b2 = s2; //1바이트 내용안에 1바이트담기 불가
		byte b2 = (byte)s2;
		System.out.printf("[data 미 손실] b2는 %d\n", b2);
		
		//data 손실 일어나는 경우
		int num3 = 300;
		//b2 = num3; //1byte짜리에 4byte짜리 담지 못함
					 //byte = 127까지만 담을 수 잇는데, num3은 300
		b2 = (byte)num3;
		System.out.printf("[data 손실] b2는 %d\n", b2);	//손실로 인해 값이 44로 나옴
		
		// ◆ 2-2) 데이터 손실 방지 방법
		double d1 = 3.14;
		//int num4 = num3+d1;	//전체 연산 결과는 8byte, 실수형. num4는 int형 4byte
		// 방법 1 double형에 담기(형변환X)
		double d2 = num3+d1;
		// 방법 2 연산결과 전체를 int형으로
		int num4 = (int)(num3+d1);
		//방법 3 //<위험>>double 형만 int형으로
		num4 = num3+(int)(d1);
		
	}	//main

}	//class
