package abstraction06;

// 학생 한명의 성적을 저장
// 이름, 국영수점수, 총점, 평균, 등수 저장하는 자료형

public class GradeRecord {

	public static final int SUBJECTS=3;
	
	String studentName;
	int[] score = new int[SUBJECTS];
	int total;
	double avg;
	int rank=1;
	
	
}	// class GradeRecord
