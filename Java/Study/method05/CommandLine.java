package method05;

public class CommandLine {

	// windows는 대표적인 GUI(Graphic User Interface)
	// CLI(Command Line Interface)
	
	/* 명령줄 인수, Command Line 인수
	 *  : main메서드의 매개변수인 param에 전달하는 값
	 *  ex) dos>java.exe CommandLine 100 가길동에서 args는 100를 담는 매개변수
	 *  
	 */
	
	public static void main(String[] args) {
		System.out.println("[commandline parameter]");
		System.out.println("이름: "+args[0]);
		System.out.println("나이: "+args[1]);
		System.out.println("사는 곳: "+args[2]);
		// args는 length가 0 라는 에러가 뜸
		// run as - run configurations
	}

}
