package etcclass12;

import java.util.Random;

public class MathClass {


	private static int abs(int value) {		
		// 문제1] abs 메소드 정의
		if(value<0) {  return (-1)*value;	}	//음수면 -1 곱했어용
		else return value;
		// return value>=0?value:-1*value;
	}
	

	private static long round(double value) {
		// 문제2] round 메소드 정의

		//1. value의 소수점 첫째자리 구하기
		int roundFlag = (int)(value*10%10);
		
		//2. 양수/음수 구분 하기
		//3. 반올림 값에 따라 올림/내림
		if(value>=0)	//양수
			if(roundFlag>=5) { // x.5이상, 올림
				return (int)value+1;
			}
			else {	// x.5 미만, 내림
				return (int)value;
			}
		else {			//음수
			if(abs(roundFlag)>=5) { // -x.5이상, 내림
				return (int)value-1;
			}
			else {	// -x.5 미만, 올림
				return (int)value;
			}			
		}
	}
	


	private static int pow(int num, int loop) {
		int result=1;
		for(int i=1; i<=loop;i++) { 
			result = result * num;
		}
		return result;
	}

	
	
	public static void main(String[] args) {
		// Math클래스는 인스턴스화(객체화)가 불가
		//Math math = new Math();	//is not visible
		
		//System.out.println(Math.PI);
		
		// Math클래스의 주요 메소드

		 // 절대값 : static 반환타입 abs(매개변수): 반환타입은 매개변수의 타입에 따라 결정됨
		float f = -3.14F;
		double d = -100.9;
		int num = 100;
		System.out.println("1. abs() 메소드");
		System.out.println(Math.abs(f));
		System.out.println(Math.abs(d));
		System.out.println(Math.abs(num));
		
		System.out.println("1'. 수제 abs() 메소드");
		System.out.println(abs(-100));
		System.out.println(abs(100));
		System.out.println(abs(-99));		
		System.out.println("====================");
		
		// 올림값 : static double ceil(double a)
		// 소수점에서 큰 수로 가장 가까운 정수 찾기
		// 3.4 → 4, 3.9 →4, -3.4 → -3
				System.out.println("2. ceil() 메소드");
		System.out.println(Math.ceil(3.4));
		System.out.println(Math.ceil(3.9));
		System.out.println(Math.ceil(-3.4));
		System.out.println(Math.ceil(-3.9));		
		System.out.println("====================");
		
		// 내림값 : static double floor(double a)
		// 3.4 → 3, 3.9 →3, -3.4 → -4
				System.out.println("3. floor() 메소드");
		System.out.println(Math.floor(3.4));
		System.out.println(Math.floor(3.9));
		System.out.println(Math.floor(-3.4));
		System.out.println(Math.floor(-3.9));
		System.out.println("====================");
		
		// 반올림 : 무조건 소수점 첫째자리에서 반올림
		// static long round(double a)
		// static int round(float a)
		System.out.println("4. round() 메소드");
		System.out.print(Math.round(3.49)+"\t");	//3
		System.out.print(Math.round(3.51)+"\t");	//4
		System.out.print(Math.round(-1.4)+"\t");	//-1
		System.out.print(Math.round(-0.8)+"\t");	//-1
		System.out.println(Math.round(-0.3));	//0
		
		System.out.println("4'. 수제 round() 메소드");
		System.out.print(round(3.49)+"\t");	//3
		System.out.print(round(3.51)+"\t");	//4
		System.out.print(round(-1.4)+"\t");	//-1
		System.out.print(round(-0.8)+"\t");	//-1
		System.out.println(round(-0.3));	//0
		System.out.println("====================");
		
		// 지수 : static double pow(double a, double b)
		// a의 b승
		System.out.println("5. pow() 메소드");
		System.out.print(Math.pow(2, 3)+"\t");
		System.out.println(Math.pow(3, 3));
		System.out.println("5'. 수제 pow() 메소드");
		System.out.print(pow(2, 3)+"\t");
		System.out.println(pow(3, 3));
		System.out.println("====================");
		
		// Math.random() 과 같은 기능을 제공해주는 Random 클래스
		// 5~10까지 랜덤하게 발생
		// (int)(Math.random()*(차이값+1))+시작값
		// Random클래스의 인스턴스변수.nextInt(차이값+1)+시작값
		Random rand = new Random();
		System.out.println(rand.nextInt(6)+5);
		rand.setSeed(42);
		// seed : 난수를 발생시키는 알고리즘이 사용하는 씨앗값
		// seed 값 설정 : 동일한 패턴(고정된)의 난수를 발생시킨다.
		
		// 1에서 10사이의 숫자를 무작위로 10개를 발생
		for(int i=0;i<10;i++) {
			int random = rand.nextInt(10)+1;
			System.out.printf("%-3d",random);
		}
		
		
	}	//main




}	//class
