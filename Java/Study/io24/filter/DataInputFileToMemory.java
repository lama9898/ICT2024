package io24.filter;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/*
	파일(encoding.txt)에 저장된 자바의 각 자료형 값을 디코딩(필터 사용)해서
	자바의 각 자료형(변수)에 저장하자
	그리고 확인차 모니터에 출력하자
	
	데이타 소스: 파일
	             노드 스트림 :FileInputStream
	데이타 목적지:자바의 각 변수-메모리
	                    모니터- 노드 스트림:System.out
	※DataOutputStream으로 필터링한(암호화된) 데이타는
	  DataInputStream클래스를 사용해서 읽어야 제대로 읽어 온다.	
	  단, 읽어 올때는 저장된  자료형 순서대로 읽어 와야 한다.	
*/

public class DataInputFileToMemory {

	public static void main(String[] args) throws IOException {
		// 1. 입력 스트림 생성
		DataInputStream dis = new DataInputStream(new FileInputStream("src/io24/filter/encoding.txt"));
		
		// 2. dis로 읽어서 자바의 각 자료형에 저장
		// 단 반드시 DataOutputStream으로 출력할 때의 순서를 꼭 지켜야 함!!
		byte b = dis.readByte();
		System.out.println(b);
		
		byte[] bArr = new byte[4];
		dis.read(bArr);
		System.out.println(Arrays.toString(bArr));
		
		char ch = dis.readChar();
		System.out.println(ch);
		
		int num = dis.readInt();
		System.out.println(num);
		
		boolean bool = dis.readBoolean();
		System.out.println(bool);
		
		System.out.println(dis.readUTF());

		//dis.readInt(); // 다 읽었는데 더 읽으려고 하면 에러 : java.io.EOFException
		//read()는 에러발생 X
		dis.close();
	}

}
