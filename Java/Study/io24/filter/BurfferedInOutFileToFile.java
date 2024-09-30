package io24.filter;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
	파일(FileReaderToMonitor.java)로 부터 데이타를 1바이트씩 읽어	
	파일(FileReaderToMonitor.txt)에 1바이트씩 출력하자
	입력을 위한 노드 스트림:FileInputStream
	출력을 위한 노드 스트림:FileOutputStream		
	단,필터 스트림을 이용하자.	
*/

public class BurfferedInOutFileToFile {

	public static void main(String[] args) throws IOException {
		// 1. 필터를 끼운 입력 스트림 생성
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src/io24/node/FileReaderToMonitor.java"));
		// 2. 필터를 끼운 출력 스트림 생성
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src/io24/filter/FileReaderToMonitor.txt"));
		
		// 3. bis로 읽고 bos로 출력
		int data; // txt파일은 문자단위로 하는 게 빠름
		while((data=bis.read())!=-1) {
			bos.write(data);
			bos.flush();
		}
		
		// 4. 스트림 닫기 둘다 표준입출력 X
		bis.close();
		bos.close();
	}

}
