package stringclass11;

// 복습, 코드 비교 필요 ★

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

	public static void main(String[] args) {
		// 어떤 문자열이 특정 패턴을 갖는지 판단하거나 데이터를 추출할 때 정규 표현식을 사용함.
		
		// ■ 1. 추출 시 사용
		Scanner sc = new Scanner(System.in);
		
		// 	1-1) 정규표현식 작성(이메일 패턴)
		String refex = "[a-zA-Z]+@[A-Za-z0-9]+\\.[a-zA-Z]{2,}";	// 그냥 .은 임의의 한글자를 의미
														// {2,} : 2개 이상
		
		// 	1-2) Pattern 객체 생성 : Pattern Pattern.compile("패턴 문자열")
		Pattern pattern = Pattern.compile(refex);
		System.out.println(pattern.pattern()); // pattern()은 정규식(패턴 문자열)을 반환해줌
		
		//	1-3) 패턴을 검사할 문자열 만들기
		System.out.println("이메일을 입력하세요");
		String email = sc.nextLine();
		
		// 	1-4) Pattern객체로 Matcher객체 생성 : Matcher Pattern 객체.matcher("패턴 일치하는지 검증할 대상 문자열") 
		// 사용자가 입력한 email과 정규표현식과 일치하는지 검사 : matcher 개체 만들기
		Matcher matcher = pattern.matcher(email);
		
		//	1-5) Matcher 객체의 주요 메소드
		//	1-5)a. boolean matches() : 대상 문자열 전체가 <정확히> 패턴과 일치할 경우 true반환
		System.out.println(matcher.matches()? "이메일 형식":"이메일 형식이 아니다");
		// 아래 start(), end() 메소드는 반드시 매칭된 경우에만 호출해야 한다.
		// java.lang.IllegalStateException : No match available 에러 발생
		
		// 	1-5)b. start() : 매칭되는 문자열 시작 위치 반환
		//	1-5)c. end() : 매칭되는 문자열 긑 다음 문자 위치 반환
		
		if(matcher.matches()) {
			System.out.println("패턴이 일치하는 문자열의 시작 위치 :"+matcher.start());
			System.out.println("패턴이 일치하는 문자열의 끝 위치 : "+matcher.end());
		}
		
		//	1-5)d. boolean find([인덱스]) : 대상 문자열 전체에서 패턴과 일치하는 부분 문자열을 찾으면 true
		//		- 전체 문자열에서 패턴과 일치하는 부분 문자열들을 찾을 때 주로 사용함(group()함수와 함께)
		//		- 인덱스 미 지정 시 0번 분터 찾기 시작
		//		- 입력 예 : 나의 이메일은 aaa@aaa.aa이고 내친구의 이메일은 bb@bbb.bb이다.
		
		while(matcher.find()) {
			System.out.println("찾은 이메일 : "+matcher.group());
		}
		
		//  ▲ 대상 문자열의 패턴이 정규표현식에 매칭되는지 검사만 하고자 할 때
		//  이때는 Matcher객체 생성 불필요함
		System.out.println(Pattern.matches(refex, email)?"이메일 형식이다":"이메일 형식이 아니다");
		//	그룹관련 함수들
		String value="[17.07.11 23:29:11] [INFO ]  [eclipse.galileo-bean-thread-50618297 galileo.site.SiteBean:317 ] - ##galileo_bean end. MessageExchange_ID:id:localhost-15a6308ba1c-6:86071562";
		
		// 방법1 : \d사용 ([0-9])
		//pattern = Pattern.compile(regex);
		pattern = Pattern.compile("\\[(\\d{2}\\.\\d{2}\\.\\d{2}\s\\d{2}:\\d{2}:\\d{2})\\]\\s\\[([A-Z]{4})\\s\\]\\s{2}\\[(.+)\\]\\s-\\s##(.+)");
									/* 추출하려는 내용은 괄호로 묶음*/													/*임의의 한문자로 퉁*/
		
		// 방법2 : [0-9] 사용
		//pattern = Pattern.compile("\\[([0-9]{2}\\.[0-9]{2}\\.[0-9]{2}\s[0-9]{2}:[0-9]{2}:[0-9]{2})\\]\\s\\[([A-Z]{4})\\s\\]\\s{2}\\[(.+)\\]\\s-\\s##(.+)");
		
		
		// 같은 내용
		//pattern = Pattern.compile("\\[([0-9]{2}\\.[0-9]{2}\\.[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2})\\] \\[([A-Z]{4}) \\] {2}\\[(.+)\\] - ##(.+)");
		
		matcher = pattern.matcher(value);
		System.out.println("패턴 일치 여부(전체 문자열) : "+matcher.matches());
		
		// groupCount() : 패턴 내 그룹핑한(괄호지정한 것들) 전체 갯수를 반환. 패턴이 일치 안해도됨
		System.out.println("그룹 수 : "+matcher.groupCount());
		
		// group()
		/*	- 항상 패턴이 일치하는지 판단 후 matcher.group(그룹번호) 사용
		 * 	- 일치하지 않을 때는 java.lang.IllegalStateException 에러 발생
		 * 	- group()는 패턴과 일치하는 문자열 전체 반환
		 *	- group(그룹번호)는 () 묶는 문자열 반환(그룹번호는 0부터 시작)
		 *	- 그룹 0번은 전체 문자열 즉 group()과 같음
		 * 
		 */
		if(matcher.matches()) {
			
//			System.out.println("그룹번호 미 지정(전체 문자열) : "+matcher.group());
//			System.out.println("그룹번호 0 지정(전체 문자열) : "+matcher.group(0));
//			System.out.println("그룹번호 1 지정(첫번째 괄호) : "+matcher.group(1));
//			System.out.println("그룹번호 2 지정(두번째 괄호) : "+matcher.group(2));
//			System.out.println("그룹번호 3 지정(세번째 괄호) : "+matcher.group(3));
//			System.out.println("그룹번호 4 지정(네번째 괄호) : "+matcher.group(4));
			for(int i=1;i<=matcher.groupCount();i++) {
				System.out.println(String.format("그룹 %d번:%s ",i,matcher.group(i)));
			}
		}
		
		value = "00000 000% 1. Before Marshalling";
//		pattern = Pattern.compile("00000 000% 1. Befor Marshalling");
		// 추출할 내용을 먼저 괄호로 감쌈
//		pattern = Pattern.compile("(00000) (000)% 1. (Before Marshalling)");
		pattern = Pattern.compile("([0-9]{5})\\s{2}(\\d{3})% \\d{1,}\\. (.+)");
		matcher = pattern.matcher(value);
		
		if(matcher.matches()) {
			for(int i=1;i<=matcher.groupCount();i++)
				System.out.println(String.format("그룹 %d번:%s", i, matcher.group(i)));
		}
		
		value="2005-04-30 17:16:14 95 45.114.2.130 200 TCP_MISS 2222 404 GET http images.netmechanic.com /images/webtools/webmaster_tools.gif - - DIRECT images.netmechanic.com image/gif \\\"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0; CAWORLD2k4; .NET CLR 1.1.4322; .NET CLR 1.0.3705)\\\" PROXIED Computers/Internet - 192.16.170.44 SG-HTTP-Service - none -";
		//문]위 로그에서 아이피(45.114.2.130),응답코드(200),캐시결과(TCP_MISS),
		//   HTTP메소드(GET)를 정규표현식을 이용하여 추출하여라.
		//   아이피는 한자리가 0~255 사이,응답코드는 3자리,HTTP메소드는 3자리 이상이다
		//   캐시결과는 3자리_4자리로 하자  - TCP_MISS
//		pattern = Pattern.compile("(.+) ([0-9]{0,3}\\.[0-9]{0,3}\\.[0-9]{0,3}\\.[0-9]{0,3})\\s([0-9]{0,3})\\s([A-Z]{3}\\w[A-Z]{4})(.+)([A-Z]{3,})(.+)");
//"2005-04-30 17:16:14 95 45.114.2.130 200 TCP_MISS 2222 404 GET http images.netmechanic.com /images/webtools/webmaster_tools.gif - - DIRECT images.netmechanic.com image/gif \\\"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0; CAWORLD2k4; .NET CLR 1.1.4322; .NET CLR 1.0.3705)\\\" PROXIED Computers/Internet - 192.16.170.44 SG-HTTP-Service - none -"

		
		pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}:\\d{2} \\d{2} (\\d{1,3}\\.[0-9]{1,3}\\.\\d{1,3}\\.\\d{1,3}) ([0-9]{3}) ([A-Z]{3}_[A-Z]{4}) \\d{4} \\d{3} ([A-Z]{3,}).+");
		pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2} \\d{2} (\\d{1,3}\\.[0-9]{1,3}\\.\\d{1,3}\\.\\d{1,3}) ([0-9]{3}) ([A-Z]{3}_[A-Z]{4}) \\d{4} \\d{3} ([A-Z]{3,}) (.+)");
		matcher = pattern.matcher(value);
		
		if(matcher.matches()) {
			System.out.println("문제");
			for(int i=1;i<=matcher.groupCount();i++)
				System.out.println(String.format("그룹 %d번:%s", i, matcher.group(i)));
		}
		
		
		
	}	//main

}	//class
