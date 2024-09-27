package method05;

import java.util.Scanner;

public class MethodShape04 {

	//메소드 형식 4:매개변수도 있고 반환값도 있는 경우
	/*
	접근지정자 [modifier] 반환타입 메소드명(매개변수들){
		처리할 일;
		return 결과값;
	}
	가장 활용빈도가 높은 메소드 타입]
	*/
	
	// 문제5] 인원수를 매개변수로 전달받아서, 인원수 만큼 나이를 사용자로부터 입력받고, 그 나이의 평균을 반환하는 메소드 정의
	static double avgAge(int num) {
		Scanner sc = new Scanner(System.in);
		//int[] ages = new int[num];
		int ageSum=0;
		
		// 인원수만큼 반복하면서 나이 입력, ageSum에 누적
		for(int i=0;i<num;i++) {
			System.out.println(i+1+"번째 사람의 나이를 입력해주세요");
			//ages[i]=sc.nextInt();
			//ageSum+=ages[i];
			ageSum+=sc.nextInt();
		}
		//System.out.printf("평균 나이는 %d세입니다.\n",ageSum/num);
		
		return (double)ageSum/num;
	}	//double avgAge, 문제5]
	
	
	// 문제6] 여러 개의 숫자를 입력받아서 그 중에 최대값을 구하는 메소드를 정의
	//	숫자의 개수는 매개변수로 전달받음, 숫자의 개수 만큼 사용자로부터 숫자를 입력받아 최대값을 구해 그 최대값을 반환하는 메소드
	
	static int maxNumber(int num) {
		Scanner sc = new Scanner(System.in);
		int max=0;
		int x;
		
		/*	// 배열 사용
		 *  int[] numbers = new int[num];
		 *  for(int i=0;i<num;i++) {
				System.out.println(i+1+"번째 숫자 입력해주세요");
				numbers[i] = sc.nextInt();
				if(i==0) max = numbers[0];
				else if(max<numbers[i]) max = numbers[i];
			}
			return max;
		 * 
		 */
		
		for(int i=0;i<num;i++) {
			System.out.println(i+1+"번째 숫자 입력해주세요");
			x = sc.nextInt();
			if(i==0) max = x;
			else if(x>=max) { max = x; }
			// 음수 중에서는 최대값 못구함! 다음부터는 if(i==0)인 경우 해주기
		}
			
		return max;
	}	// int maxNumber, 문제6]
	
	// 문제7] 매개변수로 두 숫자와 연산자를 받아서 결과값을 반환하는 메소드
	static int returnOperator(int num1, int num2, char op) {
		int result=0;
		
		switch(op) {
		case '+': result= num1+num2;break;
		case '-': result= num1-num2;break;
		case '*': result= num1*num2;break;
		case '/': result= num1/num2;break;
		default : System.out.println("무엇인가 잘못되었습니다.");
		//default : return -2147483648;
		}
		
		return result;	// +-*/ 인 경우에만 return -> default를 항상 정해줘서 return해야함, 해당 return 값은 int의 가장 작은값 return
	}	// int returnOperator
	
	
	
	public static void main(String[] args) {
		
		//System.out.println("평균 나이는 "+avgAge(5)+"입니다.");
		//System.out.printf("나이 평균 : %.1f\n",avgAge(3));
		//System.out.printf("최대값은 %d입니다.\n",maxNumber(4));
		int returnValue =  returnOperator(10,10,'+');
		System.out.println(returnValue);
		//if(returnValue==-2147483648) { System.out.println("잘못된 연산자입니다."); }
		//else System.out.println("연산 결과는 " +returnValue);
	}	//main

}	//class