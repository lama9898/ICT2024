package console;

import java.util.Scanner;

public class RockPaperScissors {

	public static final int SCISSORS=1;
	public static final int ROCK=2;
	public static final int PAPER=3;
	public static final int EXIT=9;
	
	public static void main(String[] args) {
		System.out.println(Math.random());
		
		/*
		 * Math클래스의 random()메소드:
		 * 0.0사이에서 1.0사이의 double형값을 무작위로 발생시켜주는 메소드(단,1.0은 미 포함)
		 *
		 * 특정 범위의 숫자를 랜덤하게 발생 시키려면
		 *
		 * (int)(Math.random()*차이값)+시작값
		 * 단,끝값은 포함 안됨
		 * 끝값을 포함 시키려면 +1
		 * (int)(Math.random()*(차이값+1))+시작값
		 *
		 * 예] 5부터 15사이의 숫자를 랜덤하게 발생시키려면
		 * 차이값: 15-5 =10;
		 * 시작값: 5
		 * 끝값:15
		 *
		 * (int)(Math.random()*10)+5 : 단,15는 발생 안됨
		 *
		 * 끝값도 발생시키려면
		 * (int)(Math.random()*11)+5
		 */
		
		int randomNumber = (int)(Math.random()*10)+1;
		//System.out.println(randomNumber);
		
		// 4~8까지의 값 발생
		// 시작값 : 4, 끝값:8, 차이값:4
		//randomNumber = 
		System.out.println((int)(Math.random()*5)+4);
		
		
		Scanner sc = new Scanner(System.in);
		int computer;
		int user;
		while(true) {
		
			// 1) menu
			System.out.println("=========== [ 메뉴 ] ===========\n");
			System.out.println("     1.가위  2.바위 3.보 9.종료    \n");
			System.out.println("===============================");
			System.out.println("위 메뉴 번호를 입력하세요");
			
			// 2) computer makes random number
			//int computer = (int)(Math.random()*차이값)+시작값
			computer = (int)(Math.random()*3)+1;
			// System.out.println("컴퓨터: "+computer);
			
			// 3) 사용자 입력받기
			user = sc.nextInt();
			if(user==EXIT)	{ System.out.println("즐거운 시간되셨나요? 이제는 집에 가야 할 시간이랍니다."); break; }
			
			// 4) 게임 승리여부 판단
			// System.out.println("사용자 : "+ user + ", 컴퓨터: "+computer);
			System.out.printf("[당신 : %s, 컴퓨터 : %s ]\n"
					,user==SCISSORS?"가위":user==ROCK?"바위":"보"
					, computer==SCISSORS?"가위":computer==ROCK?"바위":"보");
			if((user==SCISSORS && computer==PAPER)||(user==ROCK&&computer==SCISSORS)||(user==PAPER&&computer==ROCK)) {
				System.out.println("결과 : 이겼어요\n");
			}
			else if((user==SCISSORS && computer==SCISSORS)||(user==ROCK&&computer==ROCK)||(user==PAPER&&computer==PAPER)) {
				System.out.println("결과 : 비겼어요\n");
			}
			else System.out.println("결과 : 졌어요\n");
		}	//while

	}	//main

}	//class
