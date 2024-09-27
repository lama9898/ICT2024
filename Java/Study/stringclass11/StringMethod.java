package stringclass11;

import java.util.Scanner;

// 복습
public class StringMethod {

	public static void main(String[] args) {
		/* String 클래스의 주요 메소드 */
		
		String str1="Baldur's Gate 3";
		String str2="Tomato";
		
		// ■ 1. int length() : 문자열의 길이 반환.
		System.out.println("[length() 메소드]");
		System.out.println("str1의 문자열 길이 : "+str1.length());	//15
		System.out.println("str1의 문자열 길이 : "+str2.length());	//6
		System.out.println();
		
		// ■ 2. char charAt(int index) : 문자열에서 index에 해당하는 하나의 문자 반환
		System.out.println("[charAt() 메소드]");
		System.out.println("str1의 4번째 문자 : "+str1.charAt(3)); //d
		System.out.println();
		
		// □ 2-1) 각 index 위치에 해당하는 문자들을 출력
		for(int i=0;i<str2.length();i++) {
			System.out.printf("%d index에 해당하는 문자 : %c\n",i,str2.charAt(i));
		}
		
		String idNumber = "012345-1234567";
		System.out.println(idNumber.charAt(7)=='1'?"남자":"여자");
		
		// ■ 3. int codePointAt(int index) : 문자열에서 index에 해당하는 아스키(유니코드) 코드값 반환
		System.out.println("[codePointAt() 메소드]");
		System.out.println("str1의 4번째 문자의 코드값 : "+str1.codePointAt(3));
		System.out.println("str2의 4번째 문자의 코드값 : "+str2.codePointAt(3));
		
		// ■ 4. int compareTo(String anotherString) : 두 문자열을 비교, 첫번째 문자부터 순차적으로 비교해 나감
		/* 	- 첫번째 문자열의 아스키 코드값이 크면 양수, 코드값이 작으면 음수, 같으면 0을 반환
		 * 	- 0 : 같다, - : 대문자(소문자), + : 소문자(대문자)
		 */
		System.out.println("[comparteTo() 메소드");
		String str3="ABc", str4="ABC";
		System.out.println(str3.compareTo(str4));	//32
		System.out.println(str4.compareTo(str3));	//-32
		System.out.println("ABCD".compareTo("ABCD")==0?"same":"diff");
		System.out.println("ABCD".compareTo("A"));	//3
		System.out.println("A".compareTo("ABCD"));	//-3
		System.out.println("ABCD".compareTo("a"));	//-32
		
		// ■ 5. String concat(String str) : 두 문자열을 연결할때 +와 같은 기능
		System.out.println("[concat() 메소드]");
		System.out.println("Baldur's".concat(" Gate").concat(" 3"));
		System.out.println("Baldur's"+" Gate"+" 3");
		
		// ■ 6. boolean contains(CharSequence s) : 문자열에 특정 문자열이 포함되어있는지 판단하는 메소드
		//												, 특정 문자열이 포함 되었으면 true 아니면 false
		System.out.println("[contains() 메소드]");
		System.out.println(str1.contains("Bal"));	//true
		System.out.println(str1.contains("bal"));	//false
		String email = "tomato@daum.net";
		System.out.println(email.contains("@")?"email":"not email");	//email
		
//???	// ■ 7. static String copyValueOf(char[] data)
		// 		static String copyValueOf(char[] data, int offset, int count)
		//		static String valueOf(char[] data)	: 배열 모든 부분을 문자열로 만들때 
		//		static String valueOf(char[] data, int offset, int count)	: 배열 특정 부분만 문자열로 만들때
		/* 		: char형 배열에 저장된 문자들을 String형으로 변환
		 * 		- 기본 자료형을 문자열로 변환할 때에도 사용할 수 있다.
		 * 		ex) 예: true - "true", 100 -> "100, ...
		 */
		
		
		System.out.println("valueOf() 메소드");
		char[] chArr= {'A','S','T','A','R','I','O','N'};
		System.out.println(String.valueOf(chArr));	// ASTARION
		System.out.println(String.valueOf(chArr,3,4));	// ARIO
		
		// □ 7-1)위 메소드 사용안하고 char형 배열에 저장된 문자들을 문자열로 변환하기
		String plus="";
		for(int i=0;i<chArr.length;i++)	{ plus+=chArr[i];	}
		System.out.println(plus);
		
		boolean b = true;
		System.out.println(String.valueOf(b));	//"true"
		
		double db = 3.141592;
		System.out.println(String.valueOf(db));	//"3.141592"
		
		// ■ 8. char[] toCharArray() : 문자열을 char형 배열로 반환
		System.out.println("[toCharArray() 메소드");
		chArr ="가나다라".toCharArray();
		for(int i=0;i<chArr.length;i++)	{	System.out.printf("chArr[%d]: %-2c\n", i, chArr[i]);	}
		
		
		// ■ 9. boolean endsWith(String suffix) : 문자열이 특정 문자열로 끝나면 true 아니면 false
		System.out.println("[endsWith() 메소드]");
		System.out.println("www.daum.net".endsWith("net"));	// true
		System.out.println("www.daum.net".endsWith("com")); // false
		
		// ■ 10. boolean startWith(String prefix) : 문자열이 특정 문자열로 시작하면 true 아니면 false
		System.out.println("[startsWith() 메소드]");
		System.out.println("www.daum.net".startsWith("www"));	// true
		System.out.println("www.daum.net".startsWith("https:")); // false
		System.out.println("www.daum.net".startsWith("daum",4)); // true
		
		// ■ 11. static String format(String format, Objecct, ... args)	: 출력형식을 지정하여 문자열로 반환할때
		System.out.printf("국어: %d, 영어: %d, 수학: %d, 평균:%.2f%n",90,90,90,270/3.0);
		System.out.println(String.format("국어: %d, 영어: %d, 수학: %d, 평균:%.2f%n",90,90,90,270/3.0));
		
		// ■ 12. byte[] getBytes() : 문자열을 byte형 배열로 반환, 배열로 반환 될때 아스키 코드값으로 변환됨 
		//	- 한글 적용 불가, 아스키 코드값만
		//	- static이 아님
		System.out.println("[getBytes() 메소드]");
		byte[] by = "ABCD".getBytes(); 	// by[0]:65, by[1]:66 ...
		for(int i=0;i<by.length;i++) {
			//아스키 코드로 출력
			System.out.println(String.format("by[%d]:%d",  i, by[i]));
			//문자번호로 출력
			System.out.println(String.format("by[%d]:%c",  i, by[i]));
		}
		
		// ■ 13. int indexOf(String str) : 문자열에서 특정 문자열의 시작 인덱스를 반환, 특정 문자열이 없는 경우 -1반환
		System.out.println("[indexoOf() 메소드");
		System.out.println("GALE".indexOf("ALE"));
		System.out.println("GALE".indexOf("E"));
		System.out.println("GALE".indexOf("A"));
		System.out.println("GALE".indexOf("aLE"));
		System.out.println("my.file.txt".lastIndexOf("."));	//"."의 마지막 출현 인덱스
		idNumber = "123456-12345670";
		int index = idNumber.indexOf("-")+1;
		System.out.println(idNumber.indexOf(index)==1?"male":"female");
		
		// ■ 14. int lastIndexOf(String) arr : 문자열에서 특정 문자열의 시작인덱스를 반환,
					// 뒤에서 부터 확인, 특정 문자열이 없는 경우 -1 반환 
		System.out.println("lastIndexOF() 메소드");
		System.out.println("JAVA".lastIndexOf("A"));	// 2
		System.out.println("JAVA".lastIndexOf("VA"));	// 1
		System.out.println("JAVA".lastIndexOf("aVA"));	// 0
		
//???	// ■ 15. String replace(char oldChar, char newChar)
		//		 String replace(CharSequence target, CharSequence replacement)
		System.out.println("[replace()/replaceAll() 메소드");
		String str5 = str1.replace('T','G');
		System.out.println(str5);		
		//  String에 저장된 문자열 데이터는 변하지 않는다. 'immutable'
		System.out.println(str1);
		System.out.println(str1.replace("Gate", "Door"));
		System.out.println(str1.replace("Baldur","Tomato"));
		System.out.println(str1.replace("3","1"));
				
		// replace All은 replace와 다르게 일반 문자열은 물론 정규표현식 형태의 문자열도 가능
		System.out.println(str1.replaceAll("a","o"));
		String password = "Ab12Cd34";
		// 첫번째 인자가 별표로 바꿀 비밀번호의 부분과 완전히 일치해야 함.
		System.out.println("비밀번호"+password.replace("Ab12Cd34","********"));
		System.out.println("비밀번호 : "+password.replaceAll("[0-9A-Za-z]", "*"));	//정규표현식 04.02
		
		
		// ■ 16. String[] split(String regex) : 문자열을 특정 구분자(혹은 정규표현식에 맞는 패턴)로 분리해서 String 형 배열로 반환
		//		- 해당 구분자가 없는 경우, 배열크기가 1인 String 형 배열이 생성되며서 모든 문자열이 9번방에 저장됨.
		System.out.println("[split() 메소드]");
		String tel="010-1234-5678";
		
		// 구분자 '-'로 분리
		String[] strArr = tel.split("-");
		for(int i=0;i<strArr.length;i++) {
			System.out.println(String.format("strArr[%d]: %s",i,strArr[i]));
		}
		
		// 구분자 '.'로 분리
		String today="2024.04.01";
		strArr = today.split(".");
		// System.out.println(strArr.length)=0, 밑의 for문 안돌아감.
		// .은 정규표현식에서 하나의 기호라서 읽을수 없음. .은 정규표현식에서 임의의 한문자를 의미하는 패턴으로 처리.
		strArr = today.split("\\.");	// 문자 .으로 처리
		for(int i=0;i<strArr.length;i++) {
			System.out.println(String.format("strArr[%d]: %s",i,strArr[i]));
		}
		
		// 구분자가 없는 문자열(하지만 패턴은 O), split 가능하나 코딩량이 많음
		String regex = "AB4CDE5F12XYZ";
		strArr = regex.split("[0-9]+");
		for(int i=0;i<strArr.length;i++) {
			System.out.println(String.format("strArr[%d]: %s",i,strArr[i]));
		}
		
		// ■ 17. String substring(int beginIndex)
		System.out.println("[substring() 메소드]");
		System.out.println("Lethal Company".substring(6));
		String filename="my.file.homework.ppt";
		int beginIndex = filename.lastIndexOf(".")+1;
		System.out.println("확장자:"+filename.substring(beginIndex));
		
		// ■ 18. String substring(int beginIndex, int endIndex)
		// 시작 인덱스부터 끝 인덱스-1 까지의 문자열 추출
		// 끝 인덱스는 포함X
		System.out.println("lee@daum.net".substring(4,8));
		
		// 문제 1] @와 . 사이의 문자열을 추출하여 출력하여라 for문사용
		String[] emails = {"a@b.c", "kim@nate.com","choi@cyworld.com","park@naver.com"};
		int startSub, endSub;
		for(int i=0;i<emails.length;i++) {
			startSub = emails[i].indexOf("@");
			endSub = emails[i].indexOf(".");
			System.out.println(emails[i].substring(startSub+1, endSub));
			//split으로 하는 방법 <------------- 다시보기
			/*
			 * System.out.println(emails[i].split("@")[1].split("\\.")[0]);
			 */
		}
		
		// ■ 19. String toLowerCase(),  ■ 20. String toUpperCase()
		System.out.println("[toUpperCase(), toLowerCase() 메소드]");
		System.out.println("대문자로 변경 : "+ str1.toUpperCase());
		System.out.println("소문자로 변경 : "+ str1.toLowerCase());
		// 대/소문자 구분없이 아이디 체크하기 : 회원의 아이디가 소문자 "park"이라고 가정
		// 1> equalsIgnoreCase(anotherString) 사용
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디 입력하세요");
		String id = sc.nextLine();
		System.out.println("paRK".equalsIgnoreCase(id)?"회원":"비회원 혹은 아이디 오류");
		
		// 2> toLowerCase()나 toUpperCase() 사용
		System.out.println("PARK".equals(id.toUpperCase())?"회원":"비회원 혹은 아이디 오류");
		System.out.println("park".equals(id.toLowerCase())?"회원":"비회원 혹은 아이디 오류");
		
		
		// ■ 21. String trim() : 양쪽 끝에 있는 공백 제거
		// 	- 문자열 값 비교전에는 항상 trim() 하기
		//	- 중간의 공백은 제거 불가
		System.out.println("before trim : X"+"  ASTARION   "+"Y");
		System.out.println("before trim : X"+"  ASTA RION   ".trim()+"Y");
		
		
		// ■ 22. boolean matches(String regex) : 문자열이 정규표현식 패턴에 일치하면 true, 아니면 false
		email = "tomato@sauce.com";
		System.out.println(email.matches("[a-z]+@[a-z]+\\.[a-z]"));
		System.out.println(email.matches("[a-z]+@[a-z]+\\.[a-z]+")?"email O":"email X");
		
		// String, StringBuffer, StringBuilder
		/*
		 * String : immutable
		 * StringBuffer, StringBuilder : mutable
		 * StringBuffer : synchronization O
		 * StringBuilder: synchronization X
		 */

	}	//main

}	//class
