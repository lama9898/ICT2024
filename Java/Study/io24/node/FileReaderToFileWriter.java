package io24.node;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
	문자 스트림: 문자(한글:2바이트,영문자,숫자:1바이트)단위로 데이타를 읽고 쓴다.
	
	문자 스트림중 파일에 직접 연결이 가능한 노드 스트림:FileReader/FileWriter
	
	주로 이진 파일보다 텍스트 파일을 다룰때 주로 사용		 
	
	
	데이타 소스:파일 ,노드 스트림(문자 단위):FileReader
	데이타 목적지:파일,노드 스트림(문자 단위):FileWriter
	
	* File관련 각 노드 스트림의 예외 발생 종류
	------+-----------------+--------------+-----------------+--------------
	구분  | FileInputStream |  FileReader  |FileOutputStream | FileWriter
			바이트 기반				문자기반			바이트 기반			문자기반
	------+-----------------+--------------+-----------------+-------------
	생성자|              FileNotFoundException	             |IOException
	------+--------------------------------+-----------------+--------------
	read()|			IOException            |
	------+--------------------------------+----------------------------------
	write()                                |           IOException
	---------------------------------------+---------------------------------
	close()							IOException
	------------------------------------------------------------------------	 
	※ IOException는 FileNotFoundException의 부모
*/

public class FileReaderToFileWriter {

	public static void main(String[] args) throws IOException {
		// 문제] FileInputStreamToMonitorFile.java를 문자단위로 읽어서
		//		FileInputStreamToMonitorFile.txt파일로 문자단위로 저장
		
		// 1. 입력 스트림 생성
		FileReader fr = new FileReader("src/io24/node/FileInputStreamToMonitorFile.java");
		
		// 2. 출력 스트림 생성
		FileWriter fw = new FileWriter("src/io24/node/FileInputStreamToMonitorFile.txt");

		// 3. fr로 읽고 fw로 출력
		int data;
		
		while((data=fr.read())!=-1) {
			fw.write(data);
			fw.flush();
		}
		
		// 4. 스트림 닫기
		fr.close();
		fw.close();
	}	//main

}
