package io24.filter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/*
	파일로부터 데이터를 읽어서(노드 스트림 : FileReader)
	모니터로 출력 (필터스트림을 통해 필터링 : BufferedReader/PrintWriter)
 */

public class BufferedRWFileToMonitor {

	public static void main(String[] args) throws IOException {
		// 1. 필터끼운 입력 스트림 생성
		BufferedReader br = new BufferedReader(new FileReader("src/io24/filter/FileReaderToMonitor.txt"));
		
		// 2. 핕터끼운 출력 스트림 생성
		PrintWriter pw = new PrintWriter(System.out,true);
		
		// 3. br로 읽고 pw로 출력
		// 문제] 라인번호를 붙여서 출력하고 "java"를 한글 "자바"로 바꿔서 출력해라.
		String data;
		int lineCount=1; //
		while((data=br.readLine())!=null) {
			pw.print(lineCount+" "); //
			if(data.contains("java")) {//
				pw.println(data.replace("java", "자바"));//
			}
			else pw.println(data);
			lineCount++;//
		}
		/* best answer
			String data;
			int line=1;
			while((data=br.readLine())!=null) {
				pw.println(String.format("%-4s%s", line++,data.replace("java","자바");
		}
		 */
		
		

		// 4. 스트림 닫기
		br.close();
	}

}
