package wrapperclass10;

import java.util.Scanner;
import java.util.regex.Pattern;

public class WrapperClass03 {
	

	
	
	// ♣ 문제 1] 인자로 전달받은 value가 숫자 형식이면 true반환 아니면 false를 반환하는 메소드를 정의해라
	// ex) "20" -> true, "20A1" -> false
	
	public static boolean isNumber(String value) {
		//System.out.println(value.length());
		for(int i=0;i<value.length();i++) {
			if(!Character.isDigit(value.codePointAt(i))){
				return false;
			}
		}
		
		/* ♧ 방법 1 : isDigit, codePointAt 사용
		 * 	for(int i=0;i<value.length();i++) {
			if(!Character.isDigit(Character.codePointAt(value,i))){
				return false;
			}
		}
		 */

		/* ♧ 방법 2 : codePointAt 만 사용
		 * for(int i=0;i<value.length();i++){
		 * 	int code = Character.codePointAt(value,i);
		 * 	if(!(code>='0' && code <= '9')) { return false; }
		 * 	}
		 */
		
		return true;
	}
	

	public static void main(String[] args) {
		// ■ 1. 문자 오토 박싱, 언박싱
		
		char ch='A';
		Character charObj = ch; // 문자 오토 박싱
		
		ch = charObj;	// 문자 오토 언박싱
		//ch = charObj.charValue();	// != 문자 오토 언박싱, char = char이기 때문
		
		// ■ 2. [Character 클래스의 주요 메소드]
		/*  ◆ 2-1. codePointAt 함수
		 * static int codePointAt(CharSequence seq, int index)
		 *  : 문자열에서 index에 해당하는 위치의 한 문자의 아스키 코드(유니코드) 값을 반환한다.
		 *   - index는 0부터 시작
		 */
		System.out.println("◆1. code point at 메소드");
		System.out.println(Character.codePointAt("ABCD", 2));	// : 67
		
		/*  ◆ 2-2. isDigit 함수
		 * static boolean isDigit(char ch)
		 * static boolean isDigit(int codePoint)
		 *  : 어느 한 문자가 숫자인지 아닌지 판단하는 메소드
		 *  ※ 함수에 is~~ 붙어있으면 결과값을 보통 boolean
		 */
		System.out.println("◆2. is digit 메소드");
		System.out.println(Character.isDigit('A'));	// : false
		System.out.println(Character.isDigit(65));	// : false
		System.out.println(Character.isDigit('2'));	// : true

		
		// ♣ 문제 1]
		System.out.println("문제1. 내가 만든 isNumber() 메소드");
		System.out.println(isNumber("1004"));	// : true가 나오도록
		System.out.println(isNumber("100사"));	// : false가 나오도록
		System.out.println(isNumber("10A4321"));	// : false가 나오도록
		
		Scanner sc = new Scanner(System.in);
		System.out.print("나이를 입력하세요 : ");
		String value = sc.nextLine();
		if(isNumber(value)) {
			System.out.println("당신의 10년후 나이는 "+(10+Integer.parseInt(value)));
		}
		else System.out.println("나이는 숫자만 입력해주세요");
		
		/*  ◆ 2-3. isLetter 함수
		 * static boolean isLetter(char ch)
		 * 	: 문자인지 아닌지 (언어 : 한글,한문,영어,일본어 등)에 해당하는 것만인지를 판단하는 메소드 
		 */
		System.out.println("◆3. is letter 메소드");
		System.out.println(Character.isLetter('가'));	//true
		System.out.println(Character.isLetter('A'));	//true
		System.out.println(Character.isLetter('福'));	//true
		System.out.println(Character.isLetter('9'));	//false
		System.out.println(Character.isLetter('$'));	//false
		
		/*  ◆ 2-4. isWhitespace 메소드
		 * static boolean isWhitespace(char ch)
		 * static boolean isWhitespace(int codePoint)
		 *	: 공백 문자인지 판단하는 메소드 
		 */
		System.out.println("◆4. is White space 메소드");
		System.out.println(Character.isWhitespace('가'));	//false
		System.out.println(Character.isWhitespace(' '));	//true
		// 빈 공백의 아스키 코드값은 32
		String whiteString = " H E L L O   ";
		int whiteCount = 0;
		for(int i=0;i<whiteString.length();i++) {
			if(Character.isWhitespace(Character.codePointAt(whiteString, i)))
				whiteCount++;
		}
		System.out.println("whiteString의 공백 수는 "+whiteCount+"개");
		

		/*  ◆ 2-5. 대소문자를 판단하는 메소드, 영문자에만 적용
		 * static boolean isLowerCase(char ch)
		 * static boolean isUpperCase(char ch)
		 * 	- 알파벳이 아닌 문자에 적용시 모두 false반환
		 */
		System.out.println("◆5. isLowerCase / is UpperCase 메소드");
		System.out.println(Character.isUpperCase('A'));	//true
		System.out.println(Character.isUpperCase('a'));	//false
		System.out.println(Character.isLowerCase('A'));	//false
		System.out.println(Character.isLowerCase('a'));	//true
		System.out.println(Character.isLowerCase('가'));	//false
		System.out.println(Character.isLowerCase('9'));	//false
		System.out.println(Character.isLowerCase('%'));	//false
		
		
		/*  ◆ 2-6. String 클래스의 toCharArray 메소드
		 * 
		 */
		value = "BasketBall";
		char[] chArray = value.toCharArray();
		System.out.println(chArray[0]);
		System.out.println(chArray[1]);
		System.out.println(chArray[2]);
		
		// ♣ 문제 2] 아이디를 입력받는데, 영문자 소문자와 숫자 혹은 영문자 소문자로만 입력받아야함
		// 대문자 X, 숫자로 시작X, 제대로된 아이디를 입력 받을때까지 계속 입력받도록 함
		// 아이디 입력받을 때 scanner의 nextLine사용
		// String 클래스의 toCharArrya()사용
		
		sc = new Scanner(System.in);
		System.out.println("아이디를 입력하세요");
//		String nickname = sc.nextLine();
//		boolean continueId = true;
//		
//		char[] nicknameToChar = nickname.toCharArray();
		
		/*
		while(true) {
			nickname = sc.nextLine();
			if(Character.isDigit(nicknameToChar[0])) {
				System.out.println("아이디를 다시 입력해주세요(첫문자는 숫자 불가)");
				continue;
			}
			for(int i=0;i<nicknameToChar.length;i++) {
				if(!(Character.isLetter(nicknameToChar[i])
						&&Character.isLowerCase(nicknameToChar[i])
						||Character.isDigit(nicknameToChar[i]))) {
					continueId = true;
					break;
				}
				else continueId = false;
				
				if((Character.isLetter(nicknameToChar[i])
						&&Character.isLowerCase(nicknameToChar[i])
						||Character.isDigit(nicknameToChar[i]))) {
				}
				
				
				
				
			}
			
			if(continueId)
				System.out.println("아이디를 다시 입력해주세요(소문자,숫자만 허용)");
			else break;
		}
		*/
		
		// BEST
		// ♣ 1.정규표현식 미사용
		boolean isCorrect = true;
		String nickname;
		char[] nicknameToChar;
		

		while(true) {
			nickname = sc.nextLine();
			nicknameToChar = nickname.toCharArray();
			isCorrect = true;
			for(int i=0;i<nicknameToChar.length;i++) {
				//숫자로 시작하거나, 소문자가 아니고, 숫자가 아닌경우
				if(Character.isDigit(nicknameToChar[0])||!Character.isLowerCase(nicknameToChar[i])&&!Character.isDigit(nicknameToChar[i])) {
					//중간의 숫자는 유효하기 때문에 &&!Character.isDigit(nicknameToChar[i])
					System.out.println("아이디를 다시 입력해주세요");
					isCorrect=false;
					break;
				}
			}
			
			if(isCorrect) {
				System.out.println("당신의 아이디는 "+nickname);
				break;
			}
			
			// 2. 정규표현식 사용 04.02
			/*
			nickname = sc.nextLine();
			boolean isMatch = Pattern.matches("[a-z]+[0-9a-z]*", nickname);
			// ==
			// boolean isMatch = nickname.matches("[a-z]+[0-9a-z]*");
			if(!isMatch) {
				System.out.println("아이디를 다시 입력해주세요");
				continue;
			}
			break;
			*/
		}
		
		
		
		/*  ◆ 2-6. 대소문자를 소문자로, 소문자를 대문자로 변환
		 * static char toUpperCase(char ch)
		 * static int toUpperCase(int code)
		 * static char toLowerCase(char ch)
		 * static int toLowerCase(int code)
		 */
		
		System.out.println(" to Lower Case / to Upper Case");
		
		// ♣ 문제 3]a. 사용자로부터 문자열(영문자)을 입력받아서 대문자는 소문자로, 소문자는 대문자로 변경하여 출력
		System.out.println("문제 3번 . 알파벳 문자열을 입력하세요");
		String alphabet = sc.nextLine();
		char[] alphaCheck = alphabet.toCharArray();
		
		for(int i=0;i<alphaCheck.length;i++) {
			if(Character.isLowerCase(alphaCheck[i])) {
				alphaCheck[i] = Character.toUpperCase(alphaCheck[i]);
			}
			else if(Character.isUpperCase(alphaCheck[i])) {
				alphaCheck[i] = Character.toLowerCase(alphaCheck[i]);
			}
			System.out.print(alphaCheck[i]);
		}
		// 원본을 변경하는 방법은 좋지않다!
		
		// 3가지 방법
		/* ♧ 방법 3-a)1. 직접 출력
		 *  for(int i=0;i<alphaCheck.length;i++) {
		 *  	if(Character.isUpperCase(alphaCheck[i])) { System.out.print(alphaCheck.toLowerCase(alphaCheck[i])); }
		 *  	else	{ System.out.print(alphaCheck.toUpperCase(alphaCheck[i])); }
		 *  }
		 */
		
		/* ♧ 방법 3-a)2. 원본변경
		 *  for(int i=0;i<alphaCheck.length;i++) {
		 *  	if(Character.isUpperCase(alphaCheck[i])) { alphaCheck[i] = Character.toUpperCase(alphaCheck[i]); }
		 *  	else	{ alphaCheck[i] = Character.toLowerCase(alphaCheck[i]); }
		 *  	System.out.print(alphaCheck[i]);
		 *  }
		 */
		
		/* ♧ 방법 3-a)3. 변수선언, 쪼개서 넣기
		 *  // System.out.println(""+'H'+'e'+'l'+'l'+'o');
		 *  String alphaString ="";
		 *  for(int i=0;i<alphaCheck.length;i++) {
		 *  	if(Character.isUpperCase(alphaCheck[i])) { alphaString += Character.toUpperCase(alphaCheck[i]; }
		 *  	else { alphaString += Character.toLowerCase(alphaCheck[i]); }
		 *  }
		 *  System.out.println(alphaString);
		 *  
		 */
		
		// ♣ 문제 3]b. 위의 최종 변환된 문자열을 거꾸로 출력하여라
		System.out.println();
		for(int i=alphaCheck.length-1;i>=0;i--) {
			System.out.print(alphaCheck[i]);
		}
		
		// ◆ 2-7.
		// 모든 Wrapper 클래스는 기본 자료형을 String형으로 변환 해 줄수 있는 toString() 같은 메소드를 공통으로 갖고있음
		short s =200;	//200 -> "200"
		
		// 방법 2-7)a : static String toString(기본 자료형 타입) 사용
		System.out.println(Short.toString(s)+200);
		
		// 방법 2-7)b : String toString() 사용
		Short shObj = s;
		System.out.println(shObj.toString()+200);
		
		// 방법 2-7)c : static Wrapper 클래스 valueOf(기본자료형) 사용해서 Wrapper 클래스 생성
		System.out.println(Short.valueOf(s).toString()+200);
		
		ch = '가';	//'가'
		System.out.println(Character.toChars(ch)); //"가", 문자열로 변환
		System.out.println(Character.valueOf(ch).toString());	//"가", 결과는 같음
		
		boolean b = true;	//ture -> "true"
		System.out.println(Boolean.toString(b));	//더 이상 boolean값이 아닌 string값
		System.out.println(Boolean.valueOf(b).toString());


		
	}	//main

}	//class
