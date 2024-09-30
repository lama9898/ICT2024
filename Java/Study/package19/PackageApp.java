// 1. 패키지 선언문
package package19;

//2. import 선언문
/*
 * import: 다른 패키지에 있는 클래스들을 가져다 쓸 때 사용하는 선언문
 * 패키지명.하위패키지명 ... 클래스명 이런식으로
 * 단, java.lang 패키지 안에 있는 클래스들은 기본 패키지로, import할 필요가 없음
 * 패키지면.*; // *는 모든 클래스나 인터페이스들을 의미하므로, 모두 불러오기 때문에 비추천
 */
import java.util.Date;


//

public class PackageApp {

	public static void main(String[] args) {
		// 1'-a. 다른 패키지에 있는 클래스 접근 방법 : import해서 사용(패키지 지정 불필요)
		Date utilDate = new Date();
		System.out.println(utilDate);
		
		// 1'-b. 다른 패키지에 있는 클래스 접근 방법 : import 불필요(직접 패키지명까지 지정)
		java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());
		System.out.println("sqlDate : "+ sqlDate);

	}	//main

}	//class

/*
[컴파일된 .class파일들을 .jar로 묶기]
1. 실행용으로 묵을 수도 있고
	※먼저 main이 있는 클래스를 한번은 실행해야한다
	(하나의 자바 프로젝트를 하나의 실행 프로그램으로 만들자 즉 해당 프로젝트에
	     main메소드가 있는 클래스가 하나가 되도록)
	1) File - Export-Java-Runnable Jar file선택-Next
	2) Launch Configuration:main메소드가 있는 클래스 선택
	   Export Destination:.jar로 저장할 위치 및 파일명 지정
	3) 콘솔창을 실행하여 2)번에서 생성한 .jar가 있는 디렉토리로 이동후
	    java -jar 파일명.jar  로 프로그램 실행
	
	위와 같이 묶는 경우 해당 프로젝트의 모든 패키지가 jar로 묶인다
	따라서 새 프로젝트를 만들어 실행하고자하는 파일이 들어 있는 패키지나 클래스만 별도로
	복사해서 실행가능한 .jar로 배포하는 것이 좋다
	
2. 라이브러리용으로 묶을 수도 있다
	2-1)클래스를 라이브리러(jar)로 배포하기
	   
		프로젝트 선택후 마우스 우클릭-Export-Java-Jar file선택-Next-
	 	배포하고자하는 패키지 선택(common.utility)
	    Export Destination:.jar로 저장할 위치 및 파일명 지정 그리고 Next~ Finish
	2-2)jar로 묶는 라이브러리 프로젝트에서 가져다 쓰기
	
		
		Build Path : 프로젝트마다 빌드 패스 해야 한다
		새 프로젝트 생성후 해당 프로젝트 마우스 우클릭-Build Path-Configure Bulid Path-Libraries탭-Classpath 선택
		-Add External JARs후 배포한 jar파일 선택
*/