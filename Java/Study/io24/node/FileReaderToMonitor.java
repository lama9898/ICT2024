package io24.node;

import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

/*
	파일로부터 한 문자씩 읽어서 모니터에 출력
	데이터 소스 : 파일
		노드 스트림: FileReader(문자 기반)
	데이터 목적지: 모니터
		노드 스트림: System.out(바이트 기반)
		브릿지 스트림: OutputStreamWriter

 */

public class FileReaderToMonitor {

	public static void main(String[] args) throws IOException {
		// 1. 입력 스트림 생성
		FileReader fr = new FileReader("src/io24/node/KeyboardWriter.txt");
		
		// 2. 출력 스트림 생성
		//PrintStream out = System.out;
		
		// 3. 브릿지 스트림으로 1바이트씩 출력 스트림으로 내보내는 데이터를 문자단위로 변화
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		
		int data;
		
		
		//비교군 fr로 읽어서 out으로 출력
		/*
		while((data=fr.read())!=-1) {
			out.write(data);
			out.flush();
		}
		*/
		
		// fr로 읽어서 osw로 출력하기
		while((data=fr.read())!=-1) {
			osw.write(data);
			osw.flush();
		}
		
		// 4. 스트림 닫기
		fr.close();

	} //main

}
