package console.academy;

public class AcademyApp {

	public static void main(String[] args) {
		// Array
		//배열
		//AcademyLogic logic = new AcademyLogic();
		//컬렉션
		//AcademyCollectionLogic logic = new AcademyCollectionLogic();
		//컬렉션 - 파일저장 추가  : BufferedReader/PrintWriter
		//AcademyCollectionLogicBufferedRWLogic logic = new AcademyCollectionLogicBufferedRWLogic();
		//컬렉션 - 파일저장 추가  : ObjectInputStream/ObjectOutputStream
		AcademyCollectionObjectInOutLogic logic = new AcademyCollectionObjectInOutLogic();
		
		while(true) {
			// 1) menu 출력
			logic.printMainMenu();
			
			// 2) 메인메뉴 입력받기
			int mainMenu = logic.getMenuNumber();

			// 3) 메인메뉴에 따른 분기
			logic.seperateMainMenu(mainMenu);
			
			
		}

	}

}
