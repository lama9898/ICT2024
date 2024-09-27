package abstraction06;

public class GradeApp {

	public static void main(String[] args) {
		// ■ 1. GradeLogic 객체화(인스턴스화)
		GradeLogic logic = new GradeLogic();
		
		// ■ 2. 학생수 설정하는 메소드 호출
		logic.setNumberOfStudents();
		
		// GradeLogic - line 26
//		for(int i=0;i<logic.records.length;i++) {
//			System.out.printf("records[%d]:%s\n",i,logic.records[i]);
//		}
		logic.setNameNScore();
		
		// ■ 4. 등수설정
		logic.setRank();
		
		
		// ■ 5. 결과 출력용 메소드
		logic.print();
	}

}
