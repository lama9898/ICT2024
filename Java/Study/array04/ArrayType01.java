package array04;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayType01 {

	public static void main(String[] args) {
		/* 배열 : 하나의 이름(배열명)으로 같은 자료형의 데이터를 여러개 저장할 수 있는 메모리 구조
		 * 	- 메모리가 연속적으로 생김, 참조형 
		 * 
		 */
		
		// ■ 1. 1차원(선형) 배열선언
		/* arrNum이라는 배열명으로 int형의 배열을 선언.
		 * arrNum이라는 이름으로 stack영역에 주소를 저장할 수 있는 메모리가 생김
		 */
		int[] arrNum;	// == int arrNum[];
		// arrNum=10; 데이터 저장 불가, 주소만 저장 가능
		// System.out.println(arrNum);
		
		
		// ■ 2. 메모리 할당 : 실제 값을 저장할 수 있는 메모리를 heap영역에 생성하기 위해 new 연산자 사용
		//  - new연산자 ㅣ 실제 데이터를 저장할 메모리를 heap영역에 할당하라는 의미
		
		arrNum = new int[5]; //참조형변수의 메모리 할당시 반드시 new 연산자 이용
		// int[5]의 메모리 주소가 arrNum에 저장, int배열은 0으로 초기화되어있음.
		System.out.println(arrNum);	//배열 주소 출력
		System.out.println(arrNum[0]);	// 배열명[숫자]를 배열요소명이라 함, 숫자는 배열 인덱스, 인덱스는 0부터 시작
		System.out.println(arrNum[4]);	//배열명[숫자]는 변수처럼 사용가능
		
		
		// ■ 3. 배열의 값 할당
		/*  - 배열은 초기화하지 않아도 해당 자료형의 기본값으로 설정됨.
		 *  int: 0
		 *  double:0.0
		 *  boolean : false
		 *  char : ' '
		 *  참조형 : null
		 */
		System.out.println("[배열에 값 할당 전]");
		for(int i=0;i<5;i++) {
			System.out.printf("arrNum[%d] = %d\n",i,arrNum[i]);
		}
		
		arrNum[0]= 10;
		arrNum[1]= 20;
		arrNum[2]= 30;
		arrNum[4]= 50;
		System.out.println("[배열에 값 할당 후]");
		for(int i=0;i<5;i++) {
			System.out.printf("arrNum[%d] = %d\n",i,arrNum[i]);
		}
		//arrNum[5]=60;	// Exception : Index 5 out of bounds for length 5, 실행시 에러
		
		// 배열의 크기
		System.out.println("배열의 크기 = arr.Num.length = "+arrNum.length);
		for(int i=0;i<arrNum.length;i++) {
			/*
			if(i==arrNum.length-1)//마지막 요소인 경우
				System.out.printf("arrNum[%d] = %d",i,arrNum[i]);
			else
				System.out.printf("arrNum[%d] = %d, ",i,arrNum[i]);
			*/
			System.out.printf(i==arrNum.length-1?"arrNum[%d] = %d\n":"arrNum[%d] = %d, ",i,arrNum[i]);
		}	// 배열의 크기 For문
		
		// ■ 4.배열 선언과 동시에 메모리 할당
		String strArray[] = new String[3];	// 참조형 변수 초기화 → null
		System.out.println(strArray);	// 메모리 주소 저장되어있음
		
		System.out.println("[String 배열에 값 할당 전]");
		for(int i=0;i<strArray.length;i++) {
			System.out.printf("arrNum[%d] = %s\n",i,strArray[i]);
		}
		
		strArray[0] = "ICT";
		strArray[1] = "한국";
		strArray[2] = "인재 개발원";
		
		System.out.println("[String 배열에 값 할당 후]");
		for(int i=0;i<strArray.length;i++) {
			System.out.printf("arrNum[%d] = %s\n",i,strArray[i]);
		}
		
		// ■ 5.배열 선언과 동시에 초기화
		// 5-1) 배열 초기화자 이용
		double[] dbArr1 = {100,3.14,99.9};	//{ } : 배열 초기화자
		// 배열 초기화자 내의 값 수만큼만 생성
		System.out.println("배열 초기화자만 이용");
		for(int i=0;i<dbArr1.length;i++) {
			System.out.printf("dbArr1[%d] = %s\n",i,dbArr1[i]);
		}
		// 5-2) new 자료형[]{}
		System.out.println("new 자료형[]{} 이용");
		double[] dbArr2 = new double[] {100,3.14,99.9};
		for(int i=0;i<dbArr2.length;i++) {
			System.out.printf("dbArr2[%d] = %s\n",i,dbArr2[i]);
		}
		
		// boolean[] blArr;
		// blArr= {true,3>2,3>2&&5<3,false};	// 배열 선언 후 초기화자로 초기화 불가능. 초기화자는 선언과 동시에 사용만 가능
		boolean[] blArr = {true,3>2,3>2&&5<3,false};
		for(int i=0;i<blArr.length;i++) { System.out.printf("blArr[%d] = %s\n",i,blArr[i]);	}
		
		Scanner sc = new Scanner(System.in);
		// 학생 수만큼 이름 입력받기
		System.out.println("학생 수를 입력해주세요");
		int numberOfStudents = sc.nextInt();
		System.out.println("입력받은 학생 수: "+numberOfStudents);	//스트림에 \n \r 30 남아있음 → nextLine하면 엔터값 읽어옴 → 엔터값 없애기
		sc.nextLine(); //엔터값을 읽어서 사용안하기
		String[] names = new String[numberOfStudents]; // 학생 수 만큼 메모리 생성
		for(int i=0;i<numberOfStudents;i++) {
			System.out.printf("%d번째 학생의 이름을 입력하세요\n",i+1);
			names[i] = sc.nextLine();
		}
		// 출력
		for(int i=0;i<names.length;i++) { System.out.printf("%d번째 학생의 이름은 %s\n",i+1,names[i]);	}
		
		int[] score = {98,99,180,34,1090,67,990,1004,19,5004,189,55,66,78,890,990,2000};
		int sum=0;
		
		
		// 문제1] score 총합, 평균
		for(int i=0;i<score.length;i++) {
			sum+=score[i];
		}
		System.out.printf("총점:%d, 평균:%.2f\n",sum,(double)sum/score.length);
		
		// 문제2] score배열에 저장된 값 중 최대값을 구하여라
		int max=0;
		for(int i=0;i<score.length;i++) {
			if(max<score[i]) max = score[i];
		}
		System.out.println("최대값:"+max);
		
		// 문제3] 일차원 배열을 크기 순서대로 재배치후 출력하자 (내림차순)
		int temp=0;
		
//		for(int i=0;i<score.length;i++) {
//			for(int j=0;j<score.length-1;j++) {
//				if(score[i]>=score[j]) {
//					temp = score[j];
//					score[j]=score[i];
//					score[i]=temp;
//				}
//			}
//		}

//		for(int i=0;i<score.length;i++) {
//			for(int j=0;j<i;j++) {
//				if(score[i]>=score[j]) {
//					temp = score[j];
//					score[j]=score[i];
//					score[i]=temp;
//				}
//			}
//		}
		
		/*	BEST :
		for(int i=0;i<score.length-1;i++) {
			for(int j=i+1;j<score.length;j++) {
				if(score[i]<score[j]) {
					temp = score[j];
					score[j]=score[i];
					score[i]=temp;
				}
			}
		}		 
		 */

		// [배열 정리하기] - 컬렉션 수업에서 참고
		Arrays.sort(score);		// dafault가 오름차순. 인자가 참조형 클래스타입이 아니어도 됨
		// 내림차순 : 기본 자료형 타입이 아닌 참조형 타입의 배열이어야함.
		//	Arrays.sort(T[],Collections.reverseOrder())
		//	Arrays.sort(T[],Comparator<> super T>)
		//	int[]를 Integer[]로 변환하여 넣기
		// Integer [] score = new Integer[score.length];
		// for(int i=0li<score.length;i++) score[i]=score[i];
		// 첫번째 방법 : Arrays.sort(score,Collections.reverseOrder()
		// 두번재 방법
		/* 	
		 	Arrays.sort(score,new Compaarator<Integer>({
		 	@Override
		 	public int compare(Integer o1, Integer o2) {
				// 오름차순 : return o1-o2;
				// 내림차순 : return o2-o1;
			}
			});

		 */
		
		for(int i=0;i<score.length;i++) {
			System.out.printf("%-6d",score[i]);
		}
		

		
	}	//main

}	//class
