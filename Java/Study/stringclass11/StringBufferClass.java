package stringclass11;

public class StringBufferClass {

	public static void main(String[] args) {
		// StringBuffer 클래스
		/* ※ String클래스는 String클래스의 메서드를 이용해서 새로운 문자열을 생성하여도 원래 문자열은
		 * 	  변하지 않고(immutable 특성) 새롭게 생성된 문자열을 저장하기 위해서 메모리가 새롭게 생성된다.
		 * 	 - 이런 메모리 낭비를 막기위해서 StringBuffer클래스가 사용됨.
		 * 	 - StringBuffer클래스는 원래의 값이 변한다.
		 */
		
		// [StringBuffer클래스의 주요 메서드]
		// ■ 1.
		//StringBuffer buf = "Minsc";	// StringBuffer는 직접 대입 불가
		//StringBuffer를 생성하면서 문자열 초기화 하지 않기
		StringBuffer buf = new StringBuffer();
		System.out.println("buf : "+buf);	//주소가 나와야 하는데, 빈문자열""이 나옴
		System.out.println("buf.toString() : "+buf.toString());
		System.out.println("저장된 문자열의 길이 : "+buf.length());
		System.out.println("기본 버퍼 크기 : "+buf.capacity());
		
		String str=new String("");
		System.out.println("str : "+str);
		System.out.println("str.toString() : "+str.toString());
		System.out.println("저장된 문자열의 길이 : "+str.length());
		//System.out.println("기본 버퍼 크기 : "+str.capacity());	//string은 capacity가 없음
		
		System.out.println("[append method]--------------");
		System.out.println("[문자열 저장후]");
		buf.append("Neil Newbon");	//StringBuffer 메소드는 StringBuffer 타입 반환
		System.out.println("buf : "+buf);	//주소가 나와야 하는데, 빈문자열""이 나옴
		System.out.println("buf.toString() : "+buf.toString());
		System.out.println("저장된 문자열의 길이 : "+buf.length());
		System.out.println("기본 버퍼 크기 : "+buf.capacity());
		
		buf.append("Astarion").append("달링!");	//16byte 초과
		System.out.println("[문자열 추가후]--------------");
		System.out.println("buf : "+buf);
		System.out.println("buf.toString() : "+buf.toString());
		System.out.println("저장된 문자열의 길이 : "+buf.length());
		System.out.println("기본 버퍼 크기 : "+buf.capacity());
		
		// ■ 2. trimToSize() : 저장된 문자열만큼 버퍼크기를 줄인다.
		System.out.println("[trimToSize() method]--------------");
		buf.trimToSize();
		System.out.println("buf : "+buf);
		System.out.println("기본 버퍼 크기 : "+buf.capacity());
		
		// ■ 3. StringBuffer delete(int start, int end)	: start인덱스부터 end-1 인덱스까지의 문자열을 삭제
		System.out.println("[delete() method--------------");
		buf.delete(4, 14);
		System.out.println("삭제 후 buf : "+buf);
		System.out.println("삭제 후 버퍼 크기 : "+buf.capacity());
		
		// ■ 4. StringBuffer deleteCharAt(int index) : index위치의 하나의 문자 삭제
		System.out.println("[deleteCharAt() method]--------------");
		System.out.println(buf.deleteCharAt(3));
		
		// ■ 5. StringBuffer insert(int index, STring str) : index 위치에 특정 문자열 삽입
		System.out.println("[insert() method]--------------");
		System.out.println(buf.insert(4, "JAV"));
		System.out.println("문자열 맨 앞에 삽입 : "+buf.insert(0,"123456789"));
		
		// ■ 6. StringBuffer replace(int start, int end, String str) : start 인덱스부터 end-1인덱스까지의 문자열을 str로 바꿈
		System.out.println(buf.replace(9, 12,"자바"));
		
		// [특정 문자열로 초기화 하면서 StringBuffer 객체 생성]
		buf = new StringBuffer("123456789");
		System.out.println("buf : "+buf);	//주소가 나와야 하는데, 빈문자열""이 나옴
		System.out.println("buf.toString() : "+buf.toString());
		System.out.println("저장된 문자열의 길이 : "+buf.length());
		System.out.println("기본 버퍼 크기 : "+buf.capacity());	// 기본 16에 인자인 문자열의 길이가 plus됨
		
		// ■ 7. StringBuffer reverse() 문자열을 반대로 배치
		System.out.println("[reverse() method");
		System.out.println(buf.reverse());
		
		
		// ■ 8. String 타입을 StringBuffer타입으로 변환하기
		str = "HELLO NEIL";
		//buf = (StringBuffer)str;	//type mismatch, 형변환 및 대입연산 불가(상속X)
		buf = new StringBuffer(str); //StringBuffer의 생성자를 사용하여 대입
		System.out.println("HELLO NEIL을 거꾸로"+buf.reverse());
		
		// 문제 1] 
		System.out.println("내가 만든 reverse()사용 : "+reverse(str));
		
		

	}	//main

	private static String reverse(String str) {
		String reverse="";
		for(int i=str.length()-1;i>=0;i--) {
			reverse+=str.charAt(i);
		}
		
		return reverse;

		// 방법 1-1) char[] 2개 사용, 새 배열에 생성
		/*	char[] src = str.toCharArray();
		 * 	char[] dest = new char[str.length];
		 * 	for(int i=src.length-1;i>=0;i--)
		 * 		dest[src.length-1-i] = src[i];
		 * 	return String.valueOf(dest);
		 */
		
		// 방법 1-2) 반복은 1/2로 줄이고 char[]하나 사용, swap
		/*	char[] src = str.toCharArray();
		 * 	for(int i=0;i<src.length/2;i++){
		 * 		char temp = src[i];
		 * 		src[i] = src[src.length-1-i];
		 * 		src[src.length-1-i] = temp;
		 * 	}
		 * 	return String.valueOf(src);
		 *	//짝수, 홀수 다를 수 있음 
		 *
		 */
		
		// 방법 1-3) char[] 요소를 String에 누적
		/*	char[] src = str.toCharArray();
		 *	String reverse="";
		 *	for(int i=src.length-1;i>=0;i--) reverse+=src[i];
		 *	return reverse;
		 * 
		 */
		
		
	}

}	//class
