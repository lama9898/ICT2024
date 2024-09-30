package io24.node;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
	키보드로 읽어서(무조건 바이트 단위로 읽음(System.in) 문자 단위로 파일에 출력 -> 문제발생!
	
	브릿지 스트림을 이용해서 1바이트씩 읽은 데이터를 문자단위로 변환한다. : InputStreamReader
	
	데이타 소스:키보드 - System.in(1바이트씩 읽음)
	브릿지 스트림:InputStreamReader(1바이트를 문자단위로 변환)
	데이타 목적지:파일 - FileWriter(한 문자씩 출력)
	[자바IO에서 한글이 깨지는 경우]
	-1바이트씩 읽어서 한 문자씩 출력시 (깨짐)
	  :InputStreamReader브릿지 스트림 이용
	-한 문자씩 읽어서 1바이트로 출력시
	  :OutputStreamWriter브릿지 스트림 이용
	※1바이트씩 읽어서 1바이트씩 출력하거나
	  한문자 씩 읽어서 한문자 씩 출력 할때는
	  한글이 깨지지 않음.
*/

public class KeyboardToFileWriter {

	public static void main(String[] args) throws IOException {
		// 1. 바이트 기반 입력 스트림 생성
		InputStream is = System.in;
		
		// 2. 브릿지 스트림을 이용해서 바이트 기반 입력을 문자기반으로 변환하기
		//InputStreamReader isr = new InputStreamReader(is /*바이트 기반 노드 스트림*/);
		InputStreamReader isr = new InputStreamReader(System.in);
		
		// 3. 문자 기반의 출력 스트림 생성
		FileWriter fw = new FileWriter("src/io24/node/KeyboardWriter.txt");
		
		int data;
		// is로 읽고 fw로 출력시 한글 깨짐 ( 바이트 -> 문자 (비교군))
//		while((data = is.read())!=-1) {
//			fw.write(data);
//			fw.flush();
//		}
		
		// 4.isr로 읽어서 fw로 출력
		// Reader 타입의 read()는 바이트 단위가 아니라 문자 단위로 읽음
		// 고로 총 바이트수를 카운트로 알아내기는 힘듦
		int totalChar = 0;
		int repeatCount=0;
		
		// 필터 효과 적용 전
		/*
		while((data=isr.read())!=-1) {
			totalChar++;
			repeatCount++;
			//문자단위로 읽음
			fw.write(data);
			fw.flush();
		}
		
		System.out.println(String.format("총 문자 수: %s, 반복횟수: %s",totalChar,repeatCount));
		*/
		
		// 필터 효과 적용 후
		char[] cbuf = new char[10];
		//read(char[] cbuf)는 읽은 문자 수 반환
		// 실제 데이터는 cbuf에 저장
		// rad(byte[])와 차이점은 read(char[])는 배열이 다 안채워져도 엔터를 만나면 읽은 문자 수 반환
		while((data=isr.read(cbuf))!=-1) {
			totalChar+=data;
			repeatCount++;
			
			//write(char[], 0, 읽을 문자수)
			fw.write(cbuf,0,data);
			fw.flush();
		}
		
		System.out.println(String.format("총 문자 수: %s, 반복횟수: %s",totalChar,repeatCount));
		
		fw.close();

	}	// main

}
