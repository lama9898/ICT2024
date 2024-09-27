package etcclass12;

import java.text.ParseException;

// 정리하기

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateClass {
	
	private static String getDate(Date date) {
		
		
		return String.format("%d년 %d월 %d일 %d시 %d분 %d초",
				date.getYear()+1900, date.getMonth()+1, date.getDate(), date.getHours(), date.getMinutes(), date.getSeconds()
				);
	}
	
	private static String getDate(Calendar date) {	// overloading
		
		
		return String.format("%d년 %d월 %d일 %s %d시 %d분 %d초"
				, date.get(Calendar.YEAR), date.get(Calendar.MONTH)+1, date.get(Calendar.DATE)
				, date.get(Calendar.AM_PM)==1?"PM":"AM", date.get(Calendar.HOUR), date.get(Calendar.MINUTE), date.get(Calendar.SECOND)
				);
	}
	

	private static String dayOfWeek(int i) {
		switch(i) {
		case 0:	return "일요일";
		case 1: return "월요일";
		case 2:	return "화요일";
		case 3:	return "수요일";
		case 4:	return "목요일";
		case 5:	return "금요일";
		default:return "토요일";
		}
	}

	public static void main(String[] args) throws ParseException {
		/*
		 * Date 클래스 : 날짜 정보를 다루는 클래스로 대부분 Deprecated 되었음
		 * 	- Date() 기본 생성자나 Date(long date) 인자 생성자를 제외한 모든 생성자와 대부분의 메소드가 없어질 예정
		 * 	- java.util 패키지에 있음!
		 * 	- Date클래스의 toString() 메소드도 메모리의 주소를 문자열로 반환하는 것이 아니라 저장된 날짜 데이터를 문자열로 반환되도록 오버라이딩 됨
		 */
		
		Date today = new Date();	// 현재 시스템 날짜 정보
		System.out.println("today: "+today);
		System.out.println("today.toString(): "+today.toString());
		System.out.println("연도: "+(today.getYear()+1900));
		System.out.println("요일: "+dayOfWeek((today.getDay())));
		
		Date pastDay = new Date(1970-1900,1-1,1,0,0,1);	//1970-1-1 0:0:1 : 1970년 1월 1일 0시 0분 1초
		System.out.println(getDate(pastDay));

		long diff = pastDay.getTime();	// 날짜차이 계산시 많이 사용, 유일하게 deprecated 안된 date함수, 밀리초 단위로 반환
		System.out.println(diff);	// 1000이 나와야 하는데, -32399000 -> KST는 GMT보다 9시간 빠름
		System.out.println(diff+(9*60*60*1000));
		
		// Calendar 클래스
		/* 생성자로 Calender객체를 인스턴스화 할 수 없음 (추상클래스)
		 	- 접근지정자가 protected
			- Calendar 클래스는 Single tone Design으로 정의됨.
			- getInstance() method로 인스턴스화
			- java.util에 존재
			
		*/
		Calendar cal = Calendar.getInstance();	//현재 시스템 날짜 정보
		System.out.println("cal : "+ cal);
		System.out.println("cal.toString() : "+cal.toString());
		System.out.println("연도 : "+ cal.get(Calendar.YEAR));
		System.out.println("요일 : "+ cal.get(Calendar.DAY_OF_WEEK));
		// 1: 일요일, 2:월요일, ... 7: 토요일
		System.out.println("요일 : "+ dayOfWeek(cal.get(Calendar.DAY_OF_WEEK)-1));
		System.out.println(getDate(cal));
		// calendar -> date : calendar.getTime()
		// date -> calendar : calendar.setTiem()
		System.out.println(getDate(cal.getTime()));//calendar를 date로
		
		// 특정 날짜 설정 방법 : void setTime(Date)
		// 	- Date 타입날짜를 Calendar타입의 날짜로 설정
		cal.setTime(pastDay);
		System.out.println(getDate(cal));
		
		// 특정 날짜 설정 방법 2: set() 메소드
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.set(2024,5-1,2);	//월은 0based, 1월이 0
		cal2.set(2024,4-1,2,12,41,10);	// 설정안하면 현재 시간으로
		System.out.println(getDate(cal1));
		System.out.println(getDate(cal2));
		
		
		// SimpleDateFormat 클래스 :java.text 패키지에 있는 클래스로 날짜 관련정보를 얻는 데 유용한 클래스
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss EEEE");
		// global : SimpleDateFormat(String pattern, Locale locale)
		System.out.println("dateFormat: "+dateFormat);
		System.out.println("dateFormat.toString(): "+dateFormat.toString());
		
		// Date타입을 String형으로 반환해주는 메소드
		// : 날짜패턴에 맞게 반환해줌
		//	date타입을 string으로 변환 : String format(Date d);
		System.out.println("오늘 날짜 : "+dateFormat.format(today));
		System.out.println("과거 날짜 : "+dateFormat.format(pastDay));
		
		
		// 중간에 날짜 패턴 변경 : applyPattern(String 날짜 패턴)
		/*
		 * a는 오전오후
		 * at 쓰고 싶으면 'at'으로 표현
		 */
		dateFormat.applyPattern("yyy/MM/dd");
		System.out.println("오늘 날짜 : "+dateFormat.format(today));
		System.out.println("과거 날짜 : "+dateFormat.format(pastDay));
		
		// 날짜형식의 문자열을 Date타입으로 반환 해주는 메소드
		/*
		 * Date parse("날짜형식의 문자열");
		 * 	- 날짜형식의 문자열이 날짜패턴과 반드시 일치해야함. 그렇지 않으면 에러
		 * ex) dateFormat.applyPattern("yyy/MM/dd"); 였으면 반드시 해당 형식에 맞게
		 */
		String strDate="2024/1/1";	//월,일은 꼭 두자리 안해도 에러X
		System.out.println(dateFormat.parse(strDate));
		
		
		// 패턴을 반환하는 메소드 : String toPattern()
		System.out.println(dateFormat.toPattern());
		
		// date객체는 빼기 불가
		//System.out.println(today-pastDay);	// 원래 today와 pastDay에는 주소가 저장되어있음 -> 빼기 불가
		// getTime의 값으로 시간차를 구할 수 있음
		SimpleDateFormat simple = new SimpleDateFormat("yyyy.MM.dd");
		String startDate = "2024.3.19";
		String endDate = "2024.9.30";
			// String -> Date 타입으로 변환 : parse()
		Date sd = simple.parse(startDate);
		Date ed = simple.parse(endDate);
		
			// getTime() 호출
		long sTime = sd.getTime();
		long eTime = ed.getTime();
		diff = eTime - sTime;
		System.out.println("1000분의 1초 단위"+diff);
		System.out.println("초 단위"+diff/1000);
		System.out.println("분 단위"+diff/1000/60);
		System.out.println("시간 1초 단위"+diff/1000/60/60);
		System.out.println("일 1초 단위"+diff/1000/60/60/24);
		
		// 문제
		// 그 사람과 사귀기 시작한 날이 2024/1/15일이다. 100일째 되는 날은 언제인가?
		
		// 방법 1 : getTime()으로 시간을 얻어서 + 혹은 -
		// 1) 날짜를 Date타입으로 변환
		Date firstDate = simple.parse("2024.1.15");
		// 2) 100일을 1000분의 1초 단위로 변환해서 위의 firstTimer와 더하기
		sTime = firstDate.getTime();
		eTime = sTime + (long)100*24*60*60*1000;	// == 100일
		System.out.println(eTime);
		// 출력시 long temp = 100*24*60*60*1000 이 500650408로 나옴 why? 정수형은 4byte 따라서 long으로 형변환
		System.out.println("그녀와 100일째 되는 날 : " + simple.format(new Date(eTime)));
		
		// 방법 2 : Calendar 객체의 .add(int field, int amount) : amount는 음수/양수
		Calendar firstCal = Calendar.getInstance();
		firstCal.set(2024,0,15);
		firstCal.add(Calendar.DAY_OF_MONTH,100);
		System.out.println("그녀와 100일째 되는 날 : " +simple.format(firstCal.getTime()));
		
		// 번외
		firstCal.set(2024,0,15);
		firstCal.add(Calendar.DATE, 100);
		System.out.println("그녀와 100일째 되는 날 : " +simple.format(firstCal.getTime()));
		
		
		
		/*
		startDate = "2024.1.15";
		sd = simple.parse(startDate);
		sTime = sd.getTime();
		eTime = sTime + 100*24*60*60*60*1000;
		
		System.out.println("");
		
		*/
		
		// Date 클래스 날짜 차이관련 메소드
		//1) 두 날짜 사이의 선후관계를 파단하는 메소드
		// boolean after()후 / before()전
		//System.out.println(sDate.after(fDate));	// 
		
		// 두 날짜가 같은지 비교 : sDate.equals(fDate);
		// 같으면 참, 다르면 거짓. 메모리 주소 비교가 아닌 날짜 비교하도록 오버라이딩 됨
		
		// int compare to(Date anotherDate)
		// - 두 날짜가 같으면 0반환, 날짜 차이는 계산 안됨. 다르다면 양수나 음수 반환
		
		
		
	}
	



}
