package constructor15;

import common.utils.CommonUtils;

public class StringConstuctor {
	
	public static void main(String[] args) {
		//String과 StringBuffer 사이는 서로 생성자로 변환
		//String클래스의 생성자
		// 1-1). byte형 배열을 문자열로 변환하기
		// 		String(byte[] bytes) 생성자 이용
		//		String(byte[]bytes,int offset_index, int length)
		byte[] bArr = {65,66,67,68,69,48,96};
		String byteToString = new String(bArr);
		System.out.println("byte[]를 String으로 변환: "+byteToString);
		byteToString = new String(bArr,2,2);
		System.out.println("byte[]를 String으로 변환: "+byteToString);
		
		// 1-2). 문자열을 byte형 배열로 변환하기
		bArr = byteToString.getBytes();
		System.out.println("String을 byte[]로 변환:");
		for(int i=0;i<bArr.length;i++) System.out.printf(String.format("bArr[%d]:%d\n",i,bArr[i]));
		
		// 2-1). char형 배열을 문자열로 변환
		// 생성자 또는 static String valueOf(char[]) 이용
		// String(char[] value)		String(char[] value, int offset_index, int count)
		char[] chArr= {'N','i','e','l',' ', 'N','e','w','b','o','n'};
		String charToString = new String(chArr);
		System.out.println("char[]를 String으로 변환: "+charToString);
		charToString = new String(chArr,5,2);
		System.out.println("char[]를 String으로 변환: "+charToString);
		
		// 2-2) 문자열을 char형 배열로 : String 클래스의 toCharArray()
		chArr = charToString.toCharArray();
		for(int i=0;i<chArr.length;i++) {
			System.out.println(String.format("chArr[%d]:%c",i,chArr[i]));
		}
		
		// 3. 아스키나 유니코드값이 저장된 int형 배열을 문자열로 변환
		int[] codePoints = {50,51,65,66,44032,94};
		String intToString = new String(codePoints,0,codePoints.length);
		System.out.println("int[]를 String으로 변환: "+intToString);
		
		
		
		// 문제1] 문자열을 int형 배열로 변환하여라
		String str = "ABC123가각";
		char[] stringToInt = str.toCharArray();
		int[] charToInt = new int[stringToInt.length];
		for(int i=0;i<stringToInt.length;i++) {
			charToInt[i] = (int)stringToInt[i];
			System.out.println("charToInt:"+charToInt[i]);
		}
		//codePoints = CommonUtils.toIntArray(str);
		
		

	}	//main

}	//class
