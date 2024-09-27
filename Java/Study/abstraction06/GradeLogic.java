package abstraction06;

import java.util.Scanner;

// 학생수, gradeRecord타입의 배열 (배열크기는 학생수)
//		gradeRecord 타입의 배열 칸에는 gradeRecord 데이터의 메모리 주소가 저장
// 학생수를 설정하는 메소드, 점수를 입력받고 총점 및 평균을 구하는 메소드, 등수를 구하는 메소드, 결과를 출력하는 메소드

public class GradeLogic {

	// field
	int numberOfStudents;	//학생 수 저장
	GradeRecord[] records;	//학생 성적 저장
	String[] titles= {"국어","영어","수학"};
	Scanner sc = new Scanner(System.in);
	
	// method
	
	// 학생수를 설정하는 메소드	
	// 매개변수X, 반환X
	void setNumberOfStudents() {
		System.out.println("학생의 수를 입력하시오.");
		numberOfStudents = sc.nextInt();
		sc.nextLine();	//엔터값 읽어서 버리기
		
		records = new GradeRecord[numberOfStudents];
		
		//GradeApp.java- line 11
		for(int i=0;i<records.length;i++) {
			records[i] = new GradeRecord();
		}
	}
	
	// 점수를 입력받고 총점 및 평균을 구하는 메소드
	// 매개변수X, 반환X
	public void setNameNScore() {
		for(int i=0;i<numberOfStudents;i++) {
			System.out.printf("%d번째 학생 ",i+1);
			// i번째 학생의 이름 입력받기
			System.out.print("이름:");
			records[i].studentName = sc.nextLine();
			for(int j=0;j<GradeRecord.SUBJECTS;j++) {	//클래스 공통인것은 인스턴스 변수 말고 클래스로 가져오기
				System.out.println(titles[j]+"의 점수 입력:");
				records[i].score[j]=sc.nextInt();
				records[i].total+=records[i].score[j];
			}
			records[i].avg = (double)records[i].total/GradeRecord.SUBJECTS;
			sc.nextLine(); 	// \n\r값 버리기
		}
	}
	
	// 결과를 출력하는 메소드
	// 매개변수X, 반환X
	
	void print() {
		System.out.println("================================================");
		System.out.printf("%-10s%-5s%-5s%-5s%-5s%-8s%s%n","NAME","KOR","ENG","MATH","SUM","AVG","RANK");
		System.out.println("================================================");
		
		sortRank();
		
		for(int i=0;i<records.length;i++) {
			//이름 출력
			System.out.printf("%-10s",records[i].studentName);
			//국영수 출력
			for(int j=0;j<GradeRecord.SUBJECTS;j++) {
				System.out.printf("%-5s",records[i].score[j]);
			}
			//총점, 평균,등수
			System.out.printf("%-5s%-8.2f%s\n",records[i].total,records[i].avg, records[i].rank);
			
		}
	}	
	
	//등수를 구하는 메소드
	// 매개변수X, 반환X
	void setRank() {
		for(int i=0;i<numberOfStudents-1;i++) {
			for(int j=i+1;j<numberOfStudents;j++) {
				if(records[i].total<records[j].total) {
					records[i].rank++;
				}
				else if(records[i].total>records[j].total) {
					records[j].rank++;
				}
			}
		}
	}
	
	// 문제1] 점수 순서로 1등부터 출력되도록 records 배열을 정렬하여라.
	void sortRank() {
		GradeRecord tempRecord;
		for(int i=0;i<numberOfStudents-1;i++) {
			for(int j=i+1;j<numberOfStudents;j++) {
				if(records[i].total<records[j].total) {
					tempRecord = records[i];
					records[i]=records[j];
					records[j]=tempRecord;
				}
			}
		}
		
	}
	
}

//데이터 처리 로직