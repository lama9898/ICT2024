package io24.node;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class InOutExample {

	public static void main(String[] args) throws IOException {
		// 문제] STDNodeInOut.java 파일의 내용을 읽어서 모니터와 파일로 출력하여라.
		// 파일로 출력시 파일명은 STDNodeInOut.txt로
		
		FileInputStream fis = new FileInputStream("src/io24/node/STDNodeInOut.java");
		OutputStream out = System.out;
		FileOutputStream fos = new FileOutputStream("src/io24/node/STDNodeInOut.txt");
		
		int data;
		
//		while((data=fis.read())!=-1) {
//			out.write(data);
//			out.flush();
//			fos.write(data);
//			fos.flush();
//		}
//		
		
		byte[] b = new byte[1024];
		while((data=fis.read(b))!=-1) {
			// write(배열명,0,읽은 바이트 수) : 읽은 바이트 수만큼 출력
			out.write(b,0,data);
			out.flush();
		
			fos.write(b, 0, data);
		fos.flush();
		}
		
		fis.close();
		fos.close();

	}	// main

}
