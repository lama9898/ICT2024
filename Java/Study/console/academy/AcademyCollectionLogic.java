package console.academy;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class AcademyCollectionLogic {
	//member constant
	public static final int MAX_PERSON=3;
	
	//member field
	//Person[] person;
	List<Person> person;
	
	//생성자
	public AcademyCollectionLogic() {	
		person = new Vector<>();
	}
	
	//method
	/*
	 * 1) 메뉴 출력용 메소드
	 *  - 매개변수 : no, 반환타입 : void
	 *  
	 * 2) 메뉴 번호 입력용 메소드
	 *  - 매개변수 : no, 반환타입 : int
	 *  
	 * 3) 메뉴 번호에 따른 분기용 메소드
	 *  - 매개변수 : int(메인메뉴), 반환타입 : void
	 *  
	 * 4) 서브메뉴 출력용 메소드
	 *  - 매개변수 : no, 반환타입 : void
	 *  
	 * 5) 서브메뉴에 따른 학생 미 교사 데이터 입력용 메소드
	 *  - 매개변수 : int, 반환타입 : void
	 *  
	 * 6) 정원 확인용 메소드
	 *  - 매개변수 : int sub, 
	 *  - null체크
	 */
	
	// 1)
	public void printMainMenu() {
		System.out.println("====================메인 메뉴====================");
		System.out.println(" 1.입력 2.출력 3.수정 4.삭제 5.검색 6.파일저장 9.종료");
		System.out.println("===============================================");
		System.out.println("메인 메뉴번호를 입력하세요?");
	} //printMainMenu()
	
	// 2)
	public int getMenuNumber() {
		// 정상적인 메뉴 번호를 입력할때까지 계속 입력받도록. 숫자가 아닌 문자 입력시 메뉴번호만 출력, 다시 입력 - try-catch 사용
		Scanner sc = new Scanner(System.in);
//		String menuStr = sc.nextLine().trim();
//		return Integer.parseInt(menuStr);
		try {

			int menu = sc.nextInt();
			return menu;
		}
		catch(InputMismatchException e){
			System.out.println("숫자를 입력해주세요.");
			return 0;
		}
		/*
		 * String menuStr의 경우 :
		 * 
		 * int menu=-1;
		 * while(true){
		 * 	try{
		 * 		menuStr = sc.nextLine().trim();
		 * 		menu = Integer.parseInt(menuStr);
		 * 		break;
		 * 	}
		 * 	catch(Exception e){
		 * 		System.out.println("메뉴 번호만..");
		 * 		continue;
		 * 	}
		 * }
		 * 
		 * return menu;
		 */

	} //getMenuNumber()
	
	
	//3)
	public void seperateMainMenu(int mainMenu) {
		switch(mainMenu) {
			case 1://입력
				while(true) {
					printSubMenu();	//서브메뉴
					int subMenu = getMenuNumber();//서브메뉴 번호 입력받기
					if(subMenu==3) break;
					switch(subMenu) {
						case 1:
						case 2:
							setPerson(subMenu);break;
						default: System.out.println("서브메뉴에 없는 번호입니다.");
					}
				}
				break;
			case 2://출력
				printPerson();
				break;
			case 3://수정
				updatePerson();
				break;
			case 4://삭제
				deletePerson();
				break;
			case 5://검색
				searchPerson();
				break;
			case 6://파일저장
				break;
			case 9://종료
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);	// 프로그램 바로 종료
			default: System.out.println("메뉴에 존재하지 않는 번호입니다.");
		}
	} //seperateMainMenu()


	//4)
	private void printSubMenu() {
		System.out.println("++++++++++서브 메뉴++++++++++");
		System.out.println("1.학생 2.교사 3.메인메뉴로 이동");
		System.out.println("+++++++++++++++++++++++++++");
		System.out.println("서브 메뉴번호를 입력하세요?");
		
	}///printSubMenu()
	
	//5)
	private void setPerson(int subMenu) {		//입력받기, sub메뉴
		//6) 정원이 다 찼는지 여부 판단
		if(person.size()==MAX_PERSON) {
			System.out.println("정원이 다 찼어요");
			return;
		}
		// 정원이 덜 찬경우
		Scanner sc = new Scanner(System.in);
		
		System.out.print(">>> 이름 입력 :");
		String name = sc.nextLine().trim();
		
		System.out.print(">>> 나이 입력 :");
		int age = -1;
		while(true) {
			try {
				age = Integer.parseInt(sc.nextLine().trim());
				break;
			}catch(NumberFormatException e) {
				System.out.println("나이는 숫자로 입력");
			}
		}
		
		
		//학생, 교사 구분 분기
		switch(subMenu) {
			case 1: // student
				System.out.print(">>> 학번 입력 :");
				String stNumber = sc.nextLine().trim();
				person.add(new Student(name,age,stNumber));
				break;
			default: // teacher
				System.out.print(">>> 과목 입력 :");
				String tSubject = sc.nextLine().trim();
				person.add(new Teacher(name,age,tSubject));
		} //switch
		
	}
	
	private void printPerson() {
		// 학생 / 교사 구분없이 출력
//		for(int i=0;i<MAX_PERSON;i++) {
//			if(person[i]!= null) person[i].print();
//		}
		
		//BEST
		StringBuffer student = new StringBuffer("[학생 목록]\r\n");
		StringBuffer teacher = new StringBuffer("[교사 목록]\r\n");
		
		for(Person p : person) {
			//if(person[i]!= null) {	//null이면 그냥 끝나기 때문에 따로 체크 필요 X
				if(p instanceof Student) student.append(p.get()+"\r\n");
				else teacher.append(p.get()+"\r\n");
			
			//System.out.println(student+teacher);//주소 더하기가 안됨
			System.out.println(student+teacher.toString());
		}	
	}
	
	// 검색
	private void searchPerson() {
		Person findPerson = findPersonByName("검색");
		//System.out.println(findPerson);	//주소나옴
		if(findPerson!=null) {
			System.out.println(String.format("[%s로 검색한 결과]", findPerson.name));
			findPerson.print();
		}

	}
	
	// 7-1) 수정, 삭제, 검색에 이용, '이름'으로 찾음
	private Person findPersonByName(String msg) {
		System.out.println(msg+"할 사람의 이름을 입력하세요.");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine().trim();
		
		for(Person p:person) {
			if(p.name.equals(name))
				return p;
		}
		System.out.println(name+"로(으로) 검색된 정보가 없어요.");
		return null;
	}

	// 수정
	private void updatePerson() {
		Person findPerson = findPersonByName("수정");
		if(findPerson != null) {
			Scanner sc = new Scanner(System.in);
			System.out.printf("(현재 %s세) 몇 세로 수정하시겠습니까?\n",findPerson.age);
			while(true) {
				try {
					findPerson.age = Integer.parseInt(sc.nextLine().trim());
					break;
				}
				catch(Exception e) {
					System.out.println("나이는 숫자만 입력하세요");
				}
			}
			
			//학생인지 교사인지 판단
			if(findPerson instanceof Student) {
				System.out.printf("(현재 학번 %s) 몇 학번으로 수정하시겠습니까?\n",((Student)findPerson).stNumber);	//★
				((Student)findPerson).stNumber = sc.nextLine().trim();
			}
			else {
				System.out.printf("(현재 과목 %s) 무슨 과목으로 수정하시겠습니까?\n",((Teacher)findPerson).subject);
				((Teacher)findPerson).subject = sc.nextLine().trim();
			}
			
			System.out.printf("[%s가(이) 아래와 같이 수정] \n", findPerson.name);
			findPerson.print();
		}
		
	}

	//삭제
	private void deletePerson() {
		Person findPerson = findPersonByName("삭제");
		Scanner sc = new Scanner(System.in);
		if(findPerson !=null) {
			for(Person p : person) {
				if(findPerson.equals(p)) {
					person.remove(p);
					System.out.printf("%s의 데이터를 삭제하겠습니다.\n",findPerson.name);
					break;
				}
			}
		}
	}

}	//AcademyLogic
