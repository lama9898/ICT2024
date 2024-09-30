package io24.filter;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.InputMismatchException;

import common.utils.CommonUtils;

/*
	파일로 부터 1바이트씩 읽어서
	모니터에 출력하자
	단, 입력과 출력시 필터를 끼우자 	
	데이타 소스: 파일 - 노드 스트림:FileInputStaream
	데이타 목적지:모니터 - 노드 스트림:System.out
	필터 스트림:BufferedInputStream/BufferedOutputStream
*/

public class BufferedRWKeyboardToFile {

	public static void main(String[] args) throws IOException {
		/*
		// 1. 필터 끼운 입력 스트림 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 2. 필터 끼운 출력 스트림 생성
		PrintWriter pw = new PrintWriter(new FileWriter("src/io24/filter/keyboardChar.txt"),true);
		
		// 3. br로 읽고 pw로 출력
		String data;
		while((data=br.readLine())!=null) {
			pw.println(data);
		}
		
		// 4. 스트림 닫기
		pw.close();
		*/
		
		//Scanner클래스의 nextLine() 및 nextInt()메소드와 같은 내가 만든 메소드 테스트
		System.out.println("이름 입력은 무엇입니까?");
		System.out.println("당신의 이름: "+nextLine());
		System.out.println("이름 나이는 무엇입니까?");
		System.out.println("당신의 10년 후 나이: "+nextInt()+10);

	}

	// Scanner클래스의 nextLine()과 nextInt() 메소드 만들어보기
	private static int nextInt() throws InputMismatchException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String data = null;
		try {
		data=br.readLine();
		} catch(IOException e) {	e.printStackTrace();	}
		if(CommonUtils.isNumber(data)) throw new InputMismatchException();
		return Integer.parseInt(data);
	}

	private static String nextLine() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String data = null;
		try {
		data=br.readLine();
		} catch(IOException e) {	e.printStackTrace();	}
		
		return data;
	}

}
