package exception21;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionCatch {

	/*
	 * - catch절을 여러개 사용할 수 있다
	 * - 여러개 사용시 자식 예외클래스부터 catch해야함
	 * - 부모 예외 클래스를 자식 예외 클래스보다 상위에 위치시켜 놓으면 부모가 예외를 모두 잡아먹기 때문에
	 * 		자식예외클래스의 catch절에는 unreachable catch block이 되어 컴파일이 안됨.
	 * - 부모 예외 클래스는 맨 마지막에 배치해야 함
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[2];
		
		try {
			System.out.println("arr[0]에 입력할 숫자는?");
			String firstStr = sc.nextLine();
			arr[0] = Integer.parseInt(firstStr);	//NumberFormatException, InputMismatchException
			
			System.out.println("arr[1]에 입력할 숫자는?");
			arr[1] = sc.nextInt();
			System.out.println("두 숫자 나누기"+arr[0]/arr[1]);	//ArithmeticException
		}
//		catch(Exception e) {
//			System.out.println("예외가 발생햇어요");
//		}
//		catch(NumberFormatException e) {
//			System.out.println("숫자만");
//		}
//		catch(InputMismatchException e) {
//			System.out.println("숫자만");
//		}
//		catch(ArithmeticException e) {
//			System.out.println("0으로 나눌 수 없음");
//		}
		
		
//		catch(NumberFormatException e) {
//			System.out.println("숫자만");
//		}
//		catch(InputMismatchException e) {
//			System.out.println("숫자만");
//		}
//		catch(ArithmeticException e) {
//			System.out.println("0으로 나눌 수 없음");
//		}
//		catch(Exception e) {
//			System.out.println("예외가 발생햇어요");
//		}
		// 모든 exception을 하나의 블락으로 잡기
		catch(Exception e) {
			if(e instanceof NumberFormatException) System.out.println("arr[0]에는 숫자만");
			else System.out.println("예외가 발생했어요");
		}
		

	}	//main

}	//class


