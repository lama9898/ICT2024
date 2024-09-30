package io24.filter;

// zzZ

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/*
 * 키보드로부터 입력받아서 모니터로 출력하자, 단 브릿지 스트림을 통해 문자단위로 변환하고 필터스트림을 통해 필터림하자
 * BufferedReader/BufferedWriter필터 스트림 사용
 */

public class BufferedRWKeyboardToMonitor {

	public static void main(String[] args) throws IOException {
		// system.in은 inputstream 타입
		// new BufferedReader(System.in) // Reader타입이 와야함. Input stream을 reader타입으로 바꾸기
		
		// 1. 필터를 끼운 입력 스트림 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 2. 필터를 끼운 출력 스트림 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 3. br로 읽고 bw로 출력하기
		// BufferedReader의 readLine()메소드 : 스트림의 끝에 도달하면 null을 반환/ 읽은 문자열이 없는 경우 null 반환, 엔터값은 읽지 X
		String data;
		while((data = br.readLine())!=null) {
			// 방법1. 읽어온 데이터 위에 엔터값 추가
			//bw.write(data+"\r\n");
			//bw.flush();
			
			// 방법 2: 줄바꿈 기능을 하는 메소드 호출 : newLine();
			bw.write(data);
			bw.newLine();
			bw.flush();
			
			
		/*	PrintWriter 출력용 필터 스트림
		 * - printWriter 객체 생성시 생성자의 두번째 인자로 true를 주면 autoflush를 지원함 -> flush() 호출할 필요X
		 * - BufferedWriter는 줄바꿈을 위해 \r\n 추가 또는 newLine()메서드 호출 필요하지만
		 * 	  PrintWriter는 줄바꿈을 지원하는 println(String str)메소드를 제공함
		 * - 문자기반으로 입출력시 Buffered Reader로 읽고 PrintWriter로 출력하면 편함
		
		*/
			
			//br로 읽고 pw로 출력
			PrintWriter pw = new PrintWriter(System.out,true);
			while((data=br.readLine())!=null) {
				pw.println(data);
				// flush 불필요, 브릿지 사용 불필요, 줄바꿈 불필요
			}
			
		}
	}

}
