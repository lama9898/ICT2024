package io24.filter;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

/*
	키보드로 부터 데이타를 입력받아
	모니터에 출력하자
	단,필터 스트림을 이용하자
	데이타 소스:키보드
	            노드 스트림: System.in
	데이타 목적지:모니터
				노드 스트림: System.out
				
	필터 스트림:BufferedInputStream/BufferedOutputStream
*/

public class BufferedInOutKeyboardToMonitor {

	public static void main(String[] args) throws IOException {
		// 노드 스트림과 필터 스트림 연결 방법 : 필터 스트림의 생성자의 인자로 노드스트림을 전달
		
		// 1. 필터를 끼운 입력 스트림 생성
		BufferedInputStream bis = new BufferedInputStream(System.in);	//System.in : inputstream 타입
		// 2. 필터를 끼운 출력 스트림 생성
		BufferedOutputStream bos = new BufferedOutputStream(System.out);
		
		// 3. bis로 읽어서 bos로 출력
		int data;
		while((data=bis.read())!=-1) {
			bos.write(data);
			bos.flush();
		}

	}

}
