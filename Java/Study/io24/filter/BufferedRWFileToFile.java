package io24.filter;

// 고치기
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/*
 * 문제 파일(BufferedInOutFileToFile.java) 읽어서 파일 (BufferedInOutFileToFile.txt)로 출력
 * 노드 스트림은 바이트 기반 사용
 * 문자 기반 필터 스트림(BufferedReader/PrintWriter)를 통해 필터링
 */

public class BufferedRWFileToFile {

	public static void main(String[] args) throws IOException {
		/* my answer wrong
		// 1. 필터끼운 입력 스트림 생성
		BufferedReader br = new BufferedReader
				(new FileReader("src/io24/filter/BufferedInOutFileToFile.java"));
		// 2. 필터 끼운 출력 스트림 생성
		PrintWriter pw = new PrintWriter
				(new FileWriter("src/io24/filter/BufferedInOutFileToFile.txt"),true);
		
		
		int data;
		while((data=br.read())!=-1) {
			pw.print(data);
		}
		
		br.close();
		pw.close();
		*/
		// 1. 필터끼운 입력 스트림 생성
		BufferedReader br = new BufferedReader
				(new InputStreamReader(new FileInputStream("src/io24/filter/BufferedInOutFileToFile.java")));
		// 2. 필터 끼운 출력 스트림 생성
		PrintWriter pw = new PrintWriter(new FileOutputStream("src/io24/filter/BufferedInOutFileToFile.txt"),true);
		
		String data;
		while((data=br.readLine())!=null) {
			pw.println(data);
		}
		
		br.close();
		pw.close();
		
	}

}
