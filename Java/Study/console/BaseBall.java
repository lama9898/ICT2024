package console;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 복습 0328

public class BaseBall {
	
	// 1-1) 랜덤하게 숫자 발생시킨 후 중복되지 않게 인자로 전달된 배열에 저장하는 메소드
	public static void setRandomNumber(int[] random, int start, int end) {
		int randomNumber;
		boolean isDuplicated;
		for(int i=0;i<random.length;i++) {	// 총 3번 반복
			while(true) {
				randomNumber = (int)(Math.random()*(end-start+1))+start;
				// 랜덤하게 발생시킨 숫자의 중복 여부 체크를 위한 변수 필요 → isDuplicated
				isDuplicated = false;
				// 랜덤하게 발생시킨 숫자(randomNumber)와 배열(random)에 저장된 값의 중복 여부 체크
				for(int j=0;j<=i-1;j++) {
					if(randomNumber==random[j]) {
						isDuplicated = true;
						break;
					}
				}	//for(while(for
				if(!isDuplicated) {
					random[i] = randomNumber;
					break; // 중복X인 경우 i++
				}	// 중복인 경우 break안돼서 while 반복
			}	// for(while
		}	//for
		
		
	}	// void setRandomNumber
	
	// 2-1) 사용자 입력용 메소드
	private static void setUserNumber(int[] user) {
		Scanner sc = new Scanner(System.in);
		System.out.println("3자리 숫자를 입력하세요");
//		int userNumber = sc.nextInt();	//04.02
//		user[0]=userNumber/100;
//		user[1]=userNumber%100/10;
//		user[2]=userNumber%10;
//		
		//04.02
		//문]먼저 입력한 문자열이 숫자 형식인지 아닌지 판단하고
		//  숫자 형식이 아니라면 "숫자만 입력하세요" 출력하고
		//  숫자 형식이 아니라면 다시 입력받도록 하여라
		//  또한 숫자 형식인 경우에는 3자리만 입력 받도록 하고
		//  3자리가 아니면 "숫자는 3자리만 입력하세요"출력하고 다시 입력 받는다
		//  3자리라면 3자리가 중복이 안되도록 하여라..
		//  만약 중복된 경우 , "중복된 숫자가 있어요"라는 메시지를 출력하고
		//  다시 입력받도록 하여라.
		String userStr = sc.nextLine();
		Pattern pattern = Pattern.compile("(\\d{1})(\\d{1})(\\d{1})");
		Matcher matcher = pattern.matcher(userStr);
		if(matcher.matches()) {
			user[0]=Integer.parseInt(matcher.group(0));
			user[1]=Integer.parseInt(matcher.group(1));
			user[2]=Integer.parseInt(matcher.group(2));
//			System.err.println("setUserNumber end");
		}
		else	{ System.out.println("3자리 숫자를 입력하세요"); }
		
		

	}
	
	// 3-1) 스트라이크/볼 판단, 저장
	private static void setStrikeOrBall(int[] strikeOrBall, int[] computer, int[] user) {
		for(int i=0;i<computer.length;i++) {
			for(int j=0;j<user.length;j++) {
				// 자리수 같고, 값도 같은 경우 스트라이크
				if(i==j&&computer[i]==user[j]) strikeOrBall[0]++;
				// 자리수 다르고, 값이 같은 경우
				else if(i!=j && computer[i]==user[j]) strikeOrBall[1]++;
			}
		}
		
	}
	
	// 4-1) 게임 지속 여부 판단용 메소드
	private static void isContinue() {
		Scanner sc = new Scanner(System.in);
		System.out.println("종료하려면 'X'나 'x' \r\n계속하려면 아무키나 입력");
		String exitCode = sc.nextLine();
		if(exitCode.equalsIgnoreCase("X")) {
			System.out.println("종료되었습니다.");
			System.exit(0);		//프로그램 종료 시 사용하는 코드
		}	
	}


	public static void main(String[] args) {
		// 1) 랜덤하게 셋자리 숫자 발생시키자(컴퓨터)
		int computer[] = new int[3];	// 난수를 저장할 1차원 배열
		setRandomNumber(computer,1,9);
		int count =0;
		
		// 컴퓨터 숫자 확인
		for(int i=0;i<computer.length;i++) {
			System.out.printf(i==computer.length-1?"%-3d\n":"%-3d",computer[i]); 
		}
		
		while(true) {
			// 2) 사용자로부터 3자리 숫자를 입력받기, 배열에 저장
			int[] user = new int[3];
			setUserNumber(user);
			count++;
			
			for(int i=0;i<user.length;i++) {
				System.out.printf(i==user.length-1?"%-3d\n":"%-3d",user[i]);

			}

			
			// 3) 스트라이크/볼 판단, 저장
			int[] strikeOrBall = new int[2];
			setStrikeOrBall(strikeOrBall,computer,user);
			

			System.out.printf("%d Strike,%d Ball\n",strikeOrBall[0],strikeOrBall[1]);
			if(strikeOrBall[0]==3) {
				System.out.printf("축하합니다.%d번째 에 맞추었습니다.\n",count);
				break;
			}
		}
		
		// 4) 게임 지속 여부 확인 
		isContinue();



	}	//main


}	//class
