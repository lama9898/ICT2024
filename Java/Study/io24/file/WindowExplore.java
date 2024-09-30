package io24.file;

import java.io.File;
import java.lang.Math;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class WindowExplore {
	
	private static void printLine(int size,char symbol) {
		for(int i=0;i<size;i++) {
			System.out.print(symbol);
		}
		System.out.println();
	}//////
	
	private static String getSize(File file) {
		long size = (long)Math.ceil(file.length());
		if(size/1024>=1) return size/1024+"kB";
		else if(size/1024/1024>=1) return size/1024/1024+"GB";
		else return "0kB";
	}

//	private static String trimName(String path) {
//		int nameIndex = path.lastIndexOf(".");
//		String name= path.substring(0,nameIndex);
//		return name;
//	}
	public static void main(String[] args) {
		File f= new File("src/io24/node");
		// 문제] 윈도우탐색기처럼 상기 디렉토리 안에 있는 하위 디렉토리나 파일을 출력하여라
		// 단 디렉토리부터
		
		printLine(106, '=');
		System.out.println(String.format("%-50s%-32s%-12s%s","이름","수정한 날짜","유형","크기"));
		printLine(106, '=');
		// 유형: 파일 폴더 / 파일(확장자), 폴더 먼저
		// 크기는 kb단위(올림)
		
		
		File[] files = f.listFiles();
		long time;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
		String whatFile;
//		int nameIndex = path.lastIndexOf("\\");
//		return path.substring(nameIndex+1);
		
		for(File file:files) {
			time = file.lastModified();
			if(file.isDirectory())
				System.out.println(String.format("%-50s%-32s%-14s%s"
						,file.getName(),dateFormat.format(new Date(time)),"파일 폴더",""));
			
		}
		for(File file:files) {
			time = file.lastModified();
			if(file.isFile()) {
				int nameIndex = file.getPath().lastIndexOf(".");
				whatFile= file.getPath().substring(nameIndex+1);
				System.out.println(String.format("%-50s%-32s%-14s%s"
						,file.getName(),dateFormat.format(new Date(time)),whatFile,getSize(file)));
			}
		}
		
		
		/*
		 * BEST
		 */
//		StringBuilder sbDir = new StringBuilder();
//		StringBuilder sbFile = new StringBuilder();
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
//		File[] files = f.listFiles();
		
		//천단위 콤마찍기
		//NumberFormat nf1 = NumberFormat.getInstance(Locale.KOREA);
//		for(File file:files) {
//			String name = file.getName();
//			String lastModified = dateFormat.format(new Date(file.lastModified()));
//			if(file.isFile()) {	//파일 일때
//				//파일 유형
//				String ext = name.substring(name.lastIndexOf(".")+1).toUpperCase();
//				//파일 크기
//				int size = (int)Math.ceil((file.length()/1024.0));
//				sbFile.append(String.format("%-50s%-32s%-14s%sKB\n", name,lastModified,ext+" 파일",ntf1.format(size)));
//			}
//			else {	//폴더 일때
//				sbDir.append(String.format("%-50s%-32s%-14s\n", name,lastModified,""));
//			}
//		}
//		System.out.println(sbDir+sbFile.toString());
		
		
		// 천단위 , 찍기 : 교안자료실에 있음
	}

}
