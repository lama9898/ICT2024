package io24.node;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/*
	파일로부터(Keyboard.txt) 데이타를 읽어서 모니터와 파일(KeyboardCopy.txt)에 동시 출력	 
	파일에 직접 연결이 가능한 바이트 기반의 노드 스트림 이용
	
	※데이타 소스나 데이타 목적지에 따라  입출력 노드 스트림 결정
	
	데이타 소스:File
				바이트 기반의 입력 스트림:FileInputStream
			// * input stream이니까 바이트 기반
		
	데이타 목적지:Monitor
				바이트 기반의 출력 스트림:System.out-PrintStream타입
			  File
				바이트 기반의 출력 스트림:FileOutputStream
*/

public class FileInputStreamToMonitorFile {

	public static void main(String[] args) throws IOException {
		// 파일에서 입력받아서 모니터, 파일로 출력
		
		// 1.입력 스트림 생성
		FileInputStream fis = new FileInputStream("src/io24/node/Keyboard.txt");
		
		// 2.출력 스트림 생성
		// 2-1) 모니터
		OutputStream out = System.out;
		// 2-2) 파일
		FileOutputStream fos = new FileOutputStream("src/io24/node/KeyboardCopy.txt");
		
		// 3.fis로 읽고 fos와 out로 출력
		int data;
		while((data=fis.read())!=-1) {
			// 3-1) 모니터 출력
			out.write(data);
			out.flush();
			// 3-2) 파일 출력
			fos.write(data);
			fos.flush();
		}
		
		// 4. 스트림 닫기
		fis.close();
		fos.close();
	}

}
