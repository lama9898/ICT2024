package io24.filter;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
	키보드로부터 데이타를 읽어
	파일(KeyboardBuffered.txt)로 출력해라
	(1바이트 기반의 노드 스트림 사용)
	단, 입력/출력시 필터를 끼워라.
	
	데이타 소스: 키보드 -노드 스트림:System.in
	데이타 목적지: 파일 - 노드 스트림:FileOutputStream
	필터 스트림:BufferedInputStream/BufferedOutputStream
*/

public class BufferedInOutKeyboardToFile {

	public static void main(String[] args) throws IOException {
		// 1. 필터를 끼운 입력 스트림 생성
		BufferedInputStream bis = new BufferedInputStream(System.in);
		// 2. 필터를 끼운 출력 스트림 생성
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src/io24/filter/KeyboardBuffered.txt"));
		
		// 3. bis로 읽고 bos로 출력
		int data;
		while((data=bis.read())!=-1) {
			bos.write(data);
			bos.flush();
		}
		// 4.스트림 닫기
		bos.close();

	}

}
