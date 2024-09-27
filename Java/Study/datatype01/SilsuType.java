package datatype01;

import java.math.BigDecimal;

public class SilsuType {

	public static void main(String[] args) {
		//실수형에서 기본 데이터 타입은 double
		
		/* 1. [규칙1]
		 * 정수형과 실수형 연산시 연산결과는 실수형
		*/
		long ln = 100;
		float f1 = 200;
		//long ln1 = ln+f1; // long+float = float
		// 1-1) float에 저장
		float f2 = ln + f1;
		// 1-2) 결과를 long형으로 변환
		long ln1 = (long)(ln+f1);
		// 1-3) f1만 long형으로 변환
		ln1 = ln+(long)f1;
		// tip : 주로 소수점이하를 제거하고자 하면 int형으로 형변환
		
		float kor = 99, eng = 80, mat=96;
		float avg = (kor+eng+mat)/3;
		System.out.println("평균:"+avg);
		System.out.println("평균(소수점 제거):"+(int)avg);
		
		
		/* 2. [규칙2]
		 * 소수점이 붙으면 무조건 double형으로 인식됨
		 *  단, 소수섬점이 붙지 않은 값은 float에 담을 수 있다.
		*/
		// 2-1)기본 값은 double이므로 형변환 필요
		//float f3 = 3.14; // 3.14는 double형 상수
		float f3 = 100;
		System.out.println("f3 = " + f3);
		// 2-1)a. 형변환
		f3 = (float)3.14;
		System.out.println("f3 = " + f3);
		// 2-1)a. float 값으로 정하기
		f3 = 3.14f;
		System.out.println("f3 = " + f3);
		
		/* 3. [규칙3]
		 * 실수형도 같은 자료형끼리의 연산 결과는 같은 자료형, 큰 자료형과 작은 자료형과의 연산결과는 큰 자료형
		*/
		float ff1=100, ff2=3.14f, fresult;
		double d1=100, d2=3.14, dresult;
		fresult = ff1+ff2;
		System.out.println("fresult: "+fresult);
		dresult = d1+d2;
		System.out.println("dresult: "+dresult);
		dresult = d1+ff2;
		//float, double 소수점 표현 방법이 다름
		
		
		/* 4. 문제
		 * 
		 * 반지름이 10인 원의 면적을 구해라
		   단,면적을 저장하는 변수의 타입을 3가지 형태(int/float/double)의
		   자료형에 저장하여 출력하여라 그리고 소수점을 제거하여라
		   원의 면적:반지름*반지름*3.14
		   단,아래의  변수 radius 와 pi를 사용해서 구해라
		 * 
		 */
		
		int radius = 10;
		double pi = 3.14;
		int iarea;
		float farea;
		double darea;
		
		iarea = radius*radius*(int)pi;
		farea = radius*radius*(float)pi;
		darea = radius*radius*pi;
		
		System.out.println("-- Type casting before --");
		System.out.println("iarea = "+iarea);
		System.out.println("farea = "+farea);
		System.out.println("darea = "+darea);
		
		System.out.println("-- Type casting after --");
		iarea = (int)(radius*radius*pi);
		System.out.println("iarea = "+iarea);
		System.out.println("farea = "+(int)farea);
		System.out.println("darea = "+(int)darea);
		
		/* 5. 부동소수점,floating point 문제 */
		/* 부동소수점 : floating point, 큰 데이터 다룰 때 좋음
		 * 		0.1 + 0.2 = 0.3000003
		 * 고정소수점 : fixed point, 작은 데이터를 다룰 때 좋음
		 * 		0.1 + 0.2 = 0.3
		 */
		d1 = 0.1;
		d2 = 0.2;
		System.out.println("d1 + d2 = " + (d1+d2));
		// 예상: 0.3, 실제: 0.30000000000000004 "Floating Point Error"
		System.out.println("d1 * d2 = "+ (d1*d2));
		// 예상: 0.02, 실제: 0.020000000000000004
		System.out.println("d1+d2 = 0.3 is "+ ((d1+d2)==0.3));
		
		BigDecimal big1 = new BigDecimal("0.1");
		BigDecimal big2 = new BigDecimal("0.2");
		BigDecimal big3 = big1.add(big2);
		System.out.println(big3);
		
		System.out.print("Big3 == 0.2 is ");
		System.out.println(big3.compareTo(new BigDecimal("0.3"))==0);
	} //main

} //class
