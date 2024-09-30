package io24.node;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
	[이미지 카피]
	데이타 소스:파일
	   노드 스트림:FileInputStream
	데이타 목적지:파일
	   노드 스트림:FileOutputStream
	
	※이미지 파일 처럼 바이너리 파일(jpeg,gif,bmp,avi,mpeg,zip,dll,exe파일등)을
	 복사할때는 바이트 기반의 노드 스트림인 FileInputStream/FileOutputStream을 사용한다.
	 
	  단, Text파일등을 복사할때는 문자 기반의 노드 스트림인 FileReader/FileWriter사용하는게 유리
*/

public class ImageToImage {

	public static void main(String[] args) {
		// 1. 입출력 스트림 객체 선언
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			// 2. 입력 스트림 생성
			fis = new FileInputStream("src/io24/node/이질화.bmp");	//FileNotFoundException
			
			// 3. 출력 스트림 생성
			fos = new FileOutputStream("src/io24/node/이질화복사.bmp");
			
			// 4. fis로 읽고 fos로 출력
			int data;
			long startTime = System.currentTimeMillis();
			
			// 필터 효과 적용전 : 13초
			/*
			while((data =fis.read())!=-1) {	//IOException
				fos.write(data);
				fos.flush();
			}
			*/
			
			// 필터 효과 적용후 :
			byte[] b = new byte[1024];
			while((data=fis.read(b))!=-1) {
				// write(배열명,0,읽은 바이트 수) : 읽은 바이트 수만큼 출력
				fos.write(b, 0, data);
				fos.flush();
			}
			
			
			long endTime = System.currentTimeMillis();
			System.out.println("이미지 복사 소요 시간 :"+(endTime - startTime)/1000.0+"초");
		} catch(FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch(IOException e) {
			System.out.println("파일 읽기시 오류");
		}
		finally {
			try {
				if(fis!=null) fis.close();
				if(fos!=null) fos.close();
			} catch(IOException e) { e.printStackTrace(); }
		}
		
	}	// main

}
