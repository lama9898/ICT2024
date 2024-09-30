package io24.filter;

// zzZ

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/*
	파일로 부터 1바이트씩 읽어서
	모니터에 출력하자
	단, 입력과 출력시 필터를 끼우자 	
	데이타 소스: 파일 - 노드 스트림:FileInputStaream
	데이타 목적지:모니터 - 노드 스트림:System.out
	필터 스트림:BufferedInputStream/BufferedOutputStream
*/

public class BufferedInOutFileToMonitor {

	public static void main(String[] args) throws IOException {
		// 1. 필터를 끼운 입력 스트림 생성
		BufferedInputStream bis = new BufferedInputStream
				(new FileInputStream("src/io24/filter/KeyboardBuffered.txt"));
		
		// 2. 필터를 끼운 출력 스트림 생성
		BufferedOutputStream bos = new BufferedOutputStream(System.out);

		// 3. bis로 읽고 bos로 출력
		int data;
		while((data=bis.read())!=-1) {	// 파일의 끝 도달시 -1 반환
			bos.write(data);
			bos.flush();
		}
		bis.close();
	}

}
