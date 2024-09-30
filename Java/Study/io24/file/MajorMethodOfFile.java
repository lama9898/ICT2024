package io24.file;

import java.io.File;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

// 파일 클래스 주요 메소드

/*
 *  \ : 윈도우식 디렉토리 표기법
 *  / : UNIX(LINUX)식 디렉토리 표기법
 */

public class MajorMethodOfFile {
	
	private static String getName(String path) {
		// 문제 File클래스의 getName()과 같은 역할을 하는 나만의 메서드를 작성
		// 방법 1
		int nameIndex = path.lastIndexOf("\\");
		//nameIndex = path.lastIndexOf("\\") != -1 ? path.lastIndexOf("\\"):path.lastIndexOf("/");
		return path.substring(nameIndex+1);


		// 방법 2
		//String[] re = path.split("[/|\\\]");	// \\로 하면 \로 처리됨
		// return re[re.length-1];
	} // String getName
	
	public static void main(String[] args) {
		String wExistFile="D:\\LSK\\Workspace\\Java\\SEProj\\src\\HelloWorld.java";
		String wNoExistFile="D:\\LSK\\NoExist.txt";
		String uRelativeDir="src/io24/node";
		String uAbsoluteDir="D:/LSK/NODIR";
		
		// 1. file 객체 생성
		// 1-1) 파일에 대한 정보를 가진 file 객체
		File fwExistFile = new File(wExistFile);
		File fwNoExistFile = new File(wNoExistFile);
		
		// 1-2) 디렉토리에 대한 정보를 가진 file 객체
		File fuRelativeDir = new File(uRelativeDir);
		File fuAbsoluteDir = new File(uAbsoluteDir);
		//uri : 원격의 파일정보
		
		// 2. 파일명 혹은 디렉토리명 얻기 : String getName()
		System.out.println("[String getname()]");
		System.out.println(" fwExistFile의 파일명: "+ fwExistFile.getName());
		System.out.println(" fwNoExistFile의 파일명: "+ fwNoExistFile.getName());
		System.out.println(" fuRelativeDir의 디렉토리명: "+ fuRelativeDir.getName());
		System.out.println(" fuAbsoluteDir의 디렉토리명: "+ fuAbsoluteDir.getName());
		
		System.out.println("[내가 만든 getname()]");
		System.out.println(" wExistFile의 파일명: "+ getName(fwExistFile.getPath()));
		System.out.println(" wNoExistFile의 파일명: "+ getName(fwNoExistFile.getPath()));
		System.out.println(" uRelativeDir의 디렉토리명: "+ getName(fuRelativeDir.getPath()));
		System.out.println(" uAbsoluteDir의 디렉토리명: "+ getName(fuAbsoluteDir.getPath()));
	
		// 3. 파일/디렉토리 여부 판단
		/*
		 * boolean isFile() 혹은 boolean isDirectory()
		 * isFile() : 파일이 아니거나, 파일이 존재하지 않으면 false 반환
		 * ifDirectory() : 디렉토리가 아니거나, 디렉토리가 존재하지 않으면 false 반환
		 */
		System.out.println("[boolean isFile()/isDirectory()]");
		System.out.println(fwExistFile.isFile());	//T
		System.out.println(fwNoExistFile.isFile());	//F
		System.out.println(fuRelativeDir.isFile());	//F
		System.out.println(fuRelativeDir.isDirectory());	//T
		System.out.println(fuAbsoluteDir.isDirectory());	//F
		
		// 4. 파일 혹은 디렉토리 존재여부 판단 : boolean exists()
		// 존재 여부 판단 후 파일인지 디렉토리인지 판단하기
		System.out.println("[boolean exists()]");
		System.out.println(fwExistFile.exists());
		System.out.println(fwNoExistFile.exists());
		System.out.println(fuRelativeDir.exists());
		System.out.println(fuAbsoluteDir.exists());
		System.out.println(fwExistFile.exists()?(fwExistFile.isFile()?"파일":"디렉토리"):"존재X");
		
		// 5. 파일 혹은 디렉토리의 상대경로-getPath() / 절대경로-getAbsolutePath()
		// 보통 절대경로를 많이 씀
		// 자바 프로그램에서 상대경로로 표기하고 절대 경로를 얻고자할때 주로 getAbsolutePath()사용
		System.out.println("[String getPath() / getAbsolute()]");
		System.out.println("fuAbsoluteDir.getPath() 상대경로: " + fuAbsoluteDir.getPath());
		System.out.println("fuAbsoluteDir.getPath() 절대경로: " + fuAbsoluteDir.getAbsolutePath());
		System.out.println("fuRelativeDir.getPath() 상대경로: " + fuRelativeDir.getPath());
		System.out.println("fuRelativeDir.getPath() 절대경로: " + fuRelativeDir.getAbsolutePath());
		// 상대경로는 설정한 값 그대로 나옴
		
		// 6. 파일 / 디렉토리 크기 얻기(단위 바이트) : long length() (파일은 정확히 나오지만 디렉토리는 OS마다 다름)
		/*
		 * 디렉토리는 OS에 따라서 0을 반환하거나 일부 크기를 반환 할 수도 있다. 파일은 존재하면 해당 크기를 반환
		 * 존재하지 않으면 0 반환 (존재하지만 크기가 0일수도있음)
		 *  => length() 메소드 사용시 크기가 0인 경우 : 디렉토리(OS에 따라 다름), 파일형식이지만 파일존재X, 파일존재하지만 크기0
		 *  
		 *  디렉토리의 경우 XP는 무조건 0반환, win7,10은 크기 반환하지만 실제 크기는 아님
		 */
		System.out.println("[long length()]");
		System.out.println(fwExistFile.length()+"바이트");	//실제 크기
		System.out.println(fwNoExistFile.length()+"바이트");	// 존재 X 0
		System.out.println(fuRelativeDir.length()+"바이트");	// 존재 0
		System.out.println(fuAbsoluteDir.length()+"바이트");	// 존재 X 0
		
		// 7. 상위 부모 경로 얻기
		// 주로 디렉토리에 적용, 파일 객체 생성 시 상대경로든 절대경로든 여러 경로를 준 경우에 사용
		System.out.println("[String getParent()]");
		System.out.println(fwExistFile.getParent()); 
		System.out.println(fwNoExistFile.getParent());
		System.out.println(fuAbsoluteDir.getParent());
		System.out.println(fuRelativeDir.getParent()); // 절대 경로X, 바로 위까지만
		File fone = new File("file");
		System.out.println(fone.getParent()); // null
		File ftwo = new File("parent","child");
		System.out.println(ftwo.getParent());
		
		// 8. 디렉토리 혹은 파일 삭제
		// boolean delete() : 삭제 성공 시 true, 실패 시 false
		// 디렉토리는 안에 비어 있어야 삭제 가능
		System.out.println("[boolean delete()]");
		System.out.println(fwNoExistFile.delete());
		File sample = new File("D:\\LSK\\uhyo.png");
		System.out.println(sample.delete());
		
		System.out.println(fuRelativeDir.delete());
		System.out.println(new File("D:\\LSK\\뾰로롱").delete());
		
		// 9. 디렉토리 생성 : boolean mkdir() / mkdirs();
		// mkdir : 부모 디렉토리 존재 하지 않으면 생성 실패
		// mkdirs : 부모 디렉토리까지 생성해줌
		File fmkdir = new File("src/io24/node/temp");
		System.out.println(fmkdir.mkdir());
		System.out.println(new File("src/io24/node/nodir/temp").mkdir());	//false
		System.out.println(new File("src/io24/node/nodir/temp").mkdirs());
		
		// 10. 읽기쓰기 가능 판단
		// 윈도우계열 OS는 모든 파일이 디폴트로 실행가능
		System.out.println("[boolean canRead() / can Write() / can Execute()]");
		File fcan = new File("D:\\LSK\\can.txt");
		System.out.print(fcan.canRead()?"읽기가능":"읽기불가");
		System.out.print(fcan.canWrite()?"  쓰기가능":"  쓰기불가");
		System.out.println(fcan.canExecute()?"  실행가능":"  실행불가");
		
		// 11. 파일 혹은 디렉토리의 최근 수정된 시간 얻기
		/*
		 * long lastModified() 
		 * : 1970년 1월 1일 0시 0분 0초부터 현재까지 흘러운 시간을 1000분의  1초단위로 환산해서 long형으로 반환
		 */
		System.out.println("[long lastModified()");
		long time = fcan.lastModified();
		System.out.println(time);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
		String lastModified = dateFormat.format(new Date(time));
		System.out.println("최근 수정된 시간: "+lastModified);

		
		// 12. 파일 이름 변경 : boolean renameTo(File dest)
		/*
		 * src.renameTo(des) src와 dest는 둘다 파일 객체
		 * 같은 폴더 안 : 파일명 변경효과(rename)
		 * 다른 폴더 안 : 파일 이동 효과(cut and paste)
		 */
		System.out.println("[boolean renameTo()]");
		System.out.println(fcan.renameTo(new File("D:\\LSK\\change.txt")));
		System.out.println(new File("D:\\LSK\\change.txt").renameTo(new File("D:\\LSK\\move.txt")));
		
		
		// 13. 파일목록 및 디렉토리목록 얻어 오기
		/*
		 * String[] list() : 해당 디렉토리 안의 파일 및 디렉토리명만
		 * File[] listFiles() : 해당 디렉토리안에 있는 파일 및 디렉토리에 대한 파일객체 배열 반환
		 */
		System.out.println("[String[] list()/File[] listFiles()]");
		System.out.println("[파일 및 디렉토리명만 반환]");
		String[] names = fuRelativeDir.list();
		for(String s:names) System.out.println(s);
		System.out.println("[File[] 반환]");
		File[] files = fuRelativeDir.listFiles();
		for(File f:files) {
			// 파일명 혹은 디렉토리명
			String name = f.getName();
			// 최근 수정시간
			lastModified = dateFormat.format(new Date(f.lastModified()));
			// 파일인지 디렉토리인지 구분
			if(f.isFile()) System.out.print("파일명: "+name);
			else System.out.println("디렉토리명: "+name);
			System.out.println(", 수정된 시간: "+lastModified);
		}
		
	}	// main



}	// class Major Method Of File
