package console.academy;


// load {} 문제


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AcademyCollectionObjectInOutLogic {
	//member constant
	public static final int MAX_PERSON=3;
	
	//member field
	//Person[] person;
	List<Person> person;
	
	//생성자
	public AcademyCollectionObjectInOutLogic() {	
		person = new Vector<>();
		loadPerson();
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
	 *  
	 *  
	 *  파일의 객체 읽어오기 -> 생성자에서, loadperson
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
				savePerson();
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
	
	// 6. 저장
	private void savePerson() {
		//파일 저장용 메소드
		/*
		  컬렉션에 저장된 데이타를 파일로 저장하는 로직]
		  데이타 소스:컬렉션(메모리)-입력스트림 불필요
		  데이타 목적지:파일(Persons.dat)-ObjectOutputStream필터사용
		 
		  인스턴스화된 객체인 person을 저장(사전에 Person을 직렬화 해야 한다)
		 */
		
		// 컬렉션에 객체 저장되어있는지 판단
		if(person.isEmpty()) {
			System.out.println("파일로 저장할 명단이 없어요");
			return;
		}
		
		// 컬렉션에 저장된 객체가 있는 경우
		//PrintWriter out = null;
		ObjectOutputStream out = null;
		try {
			//out = new PrintWriter(new FileWriter("src/console/academy/Members.txt"),true);
			out = new ObjectOutputStream(new FileOutputStream("src/console/academy/Persons.txt"));
			// 컬렉션에 저장된 데이터를 파일로 출력
//			for(Person p:person) {
//				out.println(p.get());
//			}
			out.writeObject(person);	//person은 List<Person>타입
			System.out.println("파일이 저장되었습니다.");
		} catch(IOException e) {
			// file 저장 중 에러
			System.out.println("파일 저장 중 오류 - "+e.getMessage());
		}
		finally {
			try {
				if(out != null) out.close();
			}
			catch (Exception e) {}
		}
		
	}
	
	private void loadPerson() {
		// serial 이용시 필터는 ObjectInputStream
		
		//파일을 읽어 컬렉션에 저장하는 메소드
		/*
		 * 데이터 소스 : 파일 -> 노드 스트림은 FileInputStream , 필터는 ObjectInputStream
		 * 데이터 목적지: 컬렉션(메모리) -> 출력스트림 불필요
		 */
		
		
		//BufferedReader br = null;
		ObjectInputStream ois = null;
		try {
			//br = new BufferedReader(new FileReader("src/console/academy/Members.txt"));
			ois = new ObjectInputStream(new FileInputStream("src/console/academy/Persons.txt"));
			
			/*
			// 한 line 씩 읽어오기
			String line;
			
			// 정규 표현식 ver.
			Pattern pattern = Pattern.compile("이름: ([가-힣]{2,}), 나이: ([0-9]{1,3}), (과목|학번): (.+)");

			
			while((line=br.readLine())!=null) {
				// split ver. : :와 ,로 구분
//				String[] comma = line.split(",");
//				String name = comma[0].split(":")[1];
//				int age = Integer.parseInt(comma[1].split(":")[1].trim());
//				String extend = comma[2].split(":")[1];
//				if(line.indexOf("학번")!=-1) person.add(new Student(name,age,extend));
//				else person.add(new Teacher(name,age,extend));
				
				// 정규 표현식 ver.
				Matcher matcher = pattern.matcher(line);
				if(matcher.matches()) {
					String name = matcher.group(1);
					int age = Integer.parseInt(matcher.group(2));
					String extend = matcher.group(4);	
					if(line.indexOf("학번")!=-1) person.add(new Student(name,age,extend));
					else person.add(new Teacher(name,age,extend));
				}
				
		}
		*/
//		} catch (FileNotFoundException e) {
//			System.out.println("저장된 파일이 없습니다.");
//		} catch(IOException e) {
//			System.out.println("파일 읽기 중 오류");
//		}
			
			person = (List<Person>)ois.readObject();
		}
			catch(Exception e) {}
			finally {
			//if(br!=null)
				try {
					//br.close();
					if(ois!=null) ois.close();
				} catch (IOException e) {}//{	System.out.println("String 닫기 중 오류");	}
			}
		
		
	}


}	//AcademyLogic
