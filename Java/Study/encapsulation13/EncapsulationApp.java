package encapsulation13;

// 캡슐화 = 은닉화
/*
 * - 관련있는 데이터를 하나로 묶는 것
 * - 멤버변수에 외부에서의 접근을 막는 것 , 메소드를 통해서 멤버변수의 값을 읽거나 설정
 * 
 * - Getter 접근지정자가 private인 멤버변수의값을 읽을 수 있는 메소드
 */

public class EncapsulationApp {

	public static void main(String[] args) {
		EncapsulationDAO dao = new EncapsulationDAO();
		
		//데이터 초기화
		dao.initialize("이명헌", "940-1215",1000);
		
		//통장 정리
		dao.print();
		
		//출금
		dao.withDraw(1500);
		dao.withDraw(500);
		
		//입금
		dao.deposit(15000);
	}

}
