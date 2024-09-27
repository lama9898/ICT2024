package array04;

public class ArrayType02 {

	public static void main(String[] args) {
		// 2차원 배열 : 1차원 배열이 수직으로 쌓인 것(평면)
		// ■ 1. 배열 선언
		
		int[][] arrNum;	// 스택 영역에 주소를 저장할 수 있는 arrNum이라는 이름의 메모리 생성
		
		arrNum = new int[2][3];	// 2행 3열 2차원 배열 생성
		System.out.println(arrNum);	//2행3열 배열의 시작주소
		System.out.println(arrNum[0]); //arrNum[]과 주소가 다름, arrNum = 전체
		System.out.println(arrNum[1]); //arrNum[], arrNum[1]과 주소가 다름, arrNum[0] = 1행주소
		System.out.println(arrNum[0][0]);
		
		System.out.println("[ 할당 전 ]");
		for(int i=0;i<2;i++) {	//i를 행인덱스로
			for(int j=0;j<3;j++) {	//j를 열인덱스로
				System.out.printf("(%d행, %d열): %-3d",i,j,arrNum[i][j]);
			}
			System.out.println();
		}
		
		// ■ 2. 초기화
		arrNum[0][0]=1;
		arrNum[0][1]=2;
		arrNum[0][2]=3;
		arrNum[1][0]=4;
		arrNum[1][1]=5;
		arrNum[1][2]=6;
		
		System.out.println("[ 할당 후 ]");
		for(int i=0;i<2;i++) {	//i를 행인덱스로
			for(int j=0;j<3;j++) {	//j를 열인덱스로
				System.out.printf("(%d행, %d열): %-3d",i,j,arrNum[i][j]);
			}
			System.out.println();
		}
		
		// ★ 2차원 배열에서	 행의 수 = 배열명.length
		// ★ 			 열의 수 = 배열명[행인덱스].length
		// 자바의 배열은 행마다 열의 수가 다를 수 있음
		
		System.out.println("행의 수 : "+arrNum.length);
		System.out.println("0행의 열의 수 : "+arrNum[0].length);
		System.out.println("1행의 열의 수 : "+arrNum[1].length);
		
		System.out.println("[ 행 및 열의 수를 length속성으로 변경 ]");
		for(int i=0;i<arrNum.length;i++) {	//i를 행인덱스로
			for(int j=0;j<arrNum[i].length;j++) {	//j를 열인덱스로
				System.out.printf("(%d행, %d열): %-3d",i,j,arrNum[i][j]);
			}
			System.out.println();
		}
		
		
		// ▽ 열의 수를 행마다 다르게 할당하기
		int dynamic[][] = new int[2][];	// 열의 수를 동적으로 할당하기 위해 열의 수 미지정
		System.out.println(dynamic);	// 주소 나옴
		System.out.println("dynamic[0] : "+dynamic[0]);	// array가 아직 완전하지 않기 때문에 null
		System.out.println("dynamic[1] : "+dynamic[1]);	
		dynamic[0]=new int[3];
		System.out.println("[ dynamic[0],[1] 할당 후 ]");
		System.out.println("dynamic[0] : "+dynamic[0]);	
		dynamic[1]=new int[1];
		System.out.println("dynamic[1] : "+dynamic[1]);	
		
		System.out.printf("0행의 시작주소: %s, 0행의 열의수: %s\n",dynamic[0],dynamic[0].length);
		System.out.printf("1행의 시작주소: %s, 1행의 열의수: %s\n",dynamic[1],dynamic[1].length);
		
		for(int i=0;i<dynamic.length;i++) {	//i를 행인덱스로
			for(int j=0;j<dynamic[i].length;j++) {	//j를 열인덱스로
				System.out.printf("(%d행, %d열): %-3d",i,j,dynamic[i][j]);
			}
			System.out.println();
		}
		
		
		// 초기화
		for(int i=0;i<dynamic.length;i++) {
			for(int j=0;j<dynamic[i].length;j++) {
				dynamic[i][j]= i+j;
			}
		}
		
		System.out.println("[ 할당 후 ]");
		for(int i=0;i<dynamic.length;i++) {
			for(int j=0;j<dynamic[i].length;j++) {
				System.out.printf("%d행,%d열( )%-3d",i,j,dynamic[i][j]);
			}
		}
		
		
		// ■ 3.2차원 배열 선언과 동시에 초기화
		/*
		 * 바깥 { }는 초기화를 위한 중괄호(초기화자)
		 * 바깐 { } 안의 { }의 수가 행의 수를 의미
		 * 안쪽 { } 안의 값의 수가 열의 수를 의미
		 */
		int[][] arrInit= {{1,2},{3,4,5},{6}}; //안쪽 중괄호 갯수가 행의 객수 의미
		System.out.println("[초기화자 사용]");
		for(int i=0;i<arrInit.length;i++) {
			for(int j=0;j<arrInit[i].length;j++) {
				System.out.printf("%-3d",arrInit[i][j]);
			}
		}
		
		//메모리 할당, 대머리할당
		/*
		 * 1 9 9 9 9
		 * 9 1 9 9 9
		 * 9 9 1 9 9
		 * 9 9 9 1 9
		 * 
		 */
		System.out.println("\n - 문 제 - ");
		
		// 문제1] : 2차원 배열을 선언하는데, 선언과 동시에 메모리 할당
		int box[][] = new int[4][5];
		
		// 문제2] : 위의 값을 문1번에서 선언한 배열에 저장해라. 
		for(int i=0;i<box.length;i++) {
			for(int j=0;j<box[i].length;j++) {
				if(i==j) { box[i][j]=1; }
				else { box[i][j]=9; }
			}
		}
		// 문제3] : 2차원 배열에 저장된 값을 위 모양대로 출력하여라.
		for(int i=0;i<box.length;i++) {
			for(int j=0;j<box[i].length;j++) {
				//System.out.print(" "+box[i][j]);
				System.out.printf("%-2d",box[i][j]);
			}
			System.out.println();
		}
		
		
	}	//main

}	//class