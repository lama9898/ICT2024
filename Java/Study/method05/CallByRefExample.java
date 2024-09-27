package method05;

// void printArr 복습
public class CallByRefExample {

	// ○ 문제1]
	private static void setTotalNAverage(double[][] scores) {
		for(int i=0;i<scores.length;i++) {
			for(int j=0;j<scores[i].length-2;j++) {
				scores[i][scores[i].length-2]+=scores[i][j];
			}
			scores[i][4]=scores[i][3]/3;
		}
		
	} // void setTotalNAverage

	private static void printArr(double[][] arr) {
		String[] titles = {"국어","영어","수학","총점","평균"};
		for(int i=0;i<arr.length;i++) {
			System.out.printf("[ %d번째 학생의 성적 ] ", i+1);
			for(int j=0;j<arr[i].length;j++) {
				System.out.printf(j <=3 ?"%s :%-4.0f":"%s :%-4.2f" ,titles[j],arr[i][j]);
			}
			System.out.println();
		}
		
	} // void printArr

	
	public static void main(String[] args) {
		double [][] scores = {
				{100,100,100,0,0},
				{90,90,90,0,0},
				{95,95,95,0,0}
			};
		// ○ 문제1]
		// 총 3명 학생의 국영수 점수, 4번째는 총점, 5번째는 평균
		// 각 학생의 총점,평균
		// 반환X, 매개변수 1개
		
		setTotalNAverage(scores);
		printArr(scores);

	}	// main

}	// class