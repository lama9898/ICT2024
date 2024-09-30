package console;

//복습하기

import java.util.Scanner;

import common.utils.CommonUtils;

public class RockPaperScissorsMethodVer {

	//메뉴 번호용 상수
	public static final int SCISSORS=1;
	public static final int ROCK=2;
	public static final int PAPER=3;
	public static final int REPLAY=4;
	public static final int EXIT=9;
	
	//메뉴 체크용 상수
	public static final char QUIT = 'Q';
	public static final char CONTINUE = 'C';
	public static final char NORMAL = 'N';
	
	static void showMenu() {
		System.out.println("=============== [ 메뉴 ] ===============\n");
		System.out.println(" 1.가위  2.바위  3.보  4.다시 시작  9.종료   \n");
		System.out.println("=======================================");
		System.out.println("위 메뉴 번호를 입력하세요");
	}
	
	static int getComputerNumber(int start, int end) {
		return (int)(Math.random()*(end-start+1))+start;
	}
	
	// 3) 사용자 입력받기
	static int getUserNumber() {
		Scanner sc = new Scanner(System.in);
		// 04.01 메뉴번호를 숫자로 입력받을때 : 숫자가 아닌 값을 입력받을 때 에러가 남
		// 04.01 메뉴번호를 숫자로 입력받을시
		// 04.01 return sc.nextInt()
		
		// 04.01 메뉴번호를 문자열로 입력받을대 : 입력 받을때는 에러나지 않는다, 값을 넘길때 에러
		// ♣ 문제1] 정상적인 메뉴번호(숫자형식)를 입력할 때까지 계속 입력 받도록 하여라
		// 즉 숫자가 아닌 문자 입력시에는 "메뉴 번호만.."을 출력하고
		// 다시 입력 받도록 하여라(CommonUtils의 isNumber()메소드 사용)
		String menu = sc.nextLine();
		//04.01
		if(CommonUtils.isNumber(menu)) {
			return Integer.parseInt(menu);
		}
		else {
			System.out.println("숫자를 입력해주세요.");
			return 4;
		}
		
		/*	04.01 BEST
		 *  while(true) {
		 *  	String menu = sc.nextLine();
		 *  	if(!CommonUtils.isNumber(menu)) {
		 *  		System.out.println("메뉴 번호만..");
		 *  		continue;
		 *  	}
		 *  	break;
		 *  } return Integer.parseInt(menu);
		 */
		
		
		
		//return Integer.parseInt(menu);	// 04.01 숫자형식이 아닌 경우 에러남
	}
	
	
	static String getRPS(int value) {
		// value에 따라 가위, 바위, 보 문자열을 반환하는 메소드
		// showResult에서 사용하기위해
		// return value ==SCISSORS? "가위" : value==ROCK ? "바위": "보";
		switch(value) {
		case SCISSORS : return "가위";
		case ROCK : return "바위";
		default : return "보";
		}
	}
	
	// 5)
	static void showResult(int computer,int user) {
		// 가위바위보 승리 판단 후 결과 출력용 메소드
		System.out.printf("[당신 : %s, 컴퓨터 : %s ]\n", getRPS(user), getRPS(computer));
		if((user==SCISSORS && computer==PAPER)||(user==ROCK&&computer==SCISSORS)||(user==PAPER&&computer==ROCK)) {
			System.out.println("결과 : 이겼어요\n");
		}
		else if((user==SCISSORS && computer==SCISSORS)||(user==ROCK&&computer==ROCK)||(user==PAPER&&computer==PAPER)) {
			System.out.println("결과 : 비겼어요\n");
		}
		else System.out.println("결과 : 졌어요\n");
	}
	
	
	// 4) 메뉴 번호 체크용 메소드
	static char checkMenu(int menu) {
		if(menu==EXIT) {	//9번
			System.out.println("즐거운 시간되셨나요? 이제는 집에 가야 할 시간이랍니다."); 
			return QUIT;
		}
		else if(menu==REPLAY) {	//4번
			showMenu();
			return CONTINUE;
		}
		else if(!(menu==SCISSORS || menu==ROCK || menu==PAPER)) {	//1,2,3이 아닐때
			System.out.println("메뉴에 없는 번호 입니다.");
			showMenu();
			return CONTINUE;
		}
		return NORMAL;	//1,2,3일때
	}

	
	
	public static void main(String[] args) {
		// System.out.println(Math.random());
		
		/*
		 * (int)(Math.random()*차이값)+시작값
		 * 단,끝값은 포함 안됨, 끝값을 포함 시키려면 +1
		 * (int)(Math.random()*(차이값+1))+시작값

		 *
		 * 끝값도 발생시키려면
		 * (int)(Math.random()*11)+5
		 */
		
		int computer;
		int user;
		
		// 1) menu
		showMenu();
		while(true) {			
			// 2) computer makes random number
			computer = getComputerNumber(1,3);
			//int computer = (int)(Math.random()*차이값)+시작값
			
			
	//복습하기
			// 3) 사용자 입력받기
			user = getUserNumber();
			
			// 4) 메뉴 체크 메소드로 분리전
			char check = checkMenu(user);
			if(check==QUIT) break;
			else if(check==CONTINUE) continue;
			
			/*
			if(user==EXIT)	{ System.out.println("즐거운 시간되셨나요? 이제는 집에 가야 할 시간이랍니다."); break; }
			else if(user==REPLAY) {
				showMenu();
				continue;
			}
			else if(!(user==SCISSOS||user==ROCK||user||PAPER)) {
				System.out.println("메뉴에 없는 번호 입니다.");
				showMenu();
			}
			*/
			// 5) 게임 승리여부 판단
			showResult(computer,user);

		}	//while


	}	//main

}	//class