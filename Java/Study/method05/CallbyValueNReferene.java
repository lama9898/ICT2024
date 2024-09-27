package method05;

public class CallbyValueNReferene {
	
	// ■ 1. Call by Value : 메소드 호출과 관련된 개념으로 매개변수에 값을 전달(복사)하는 경우
	//	- 매개변수의 타입이 기본 자료형(primative type)인 경우, 값이 매개변수에 전달
	
	static void callByValue(int first, int second) {
		int temp = first;
		first = second;
		second = temp;
		System.out.printf("In call by Value method, first : %d, second %d\n", first,second);
		
	}	// void callByValue
	
	// ■ 2. Call by Reference : 메소드 호출과 관련된 개념으로 매개변수에 메모리의 주소값을 전달하는 경우
	/*	- 매개변수의 타입이 참조형인 경우 (배열, 클래스, 인터페이스 등)
		- 값이 아니라 주소값이 매개변수에 전달됨 → 같은 메모리를 참조한다.
		- call by reference를 적용해서 매개변수에 여러개의 값을 동시에 전달할 수도 있고, 여러개의 값을 반환할 수도 있음
		- 반환타입이 void여도 반환되는 효과가 나타남
	 */
	
	static void callByReference(int[] arr) {
		int temp = arr[0];
		arr[0] = arr[1];
		arr[1] = temp;
		System.out.printf("In call by Reference method, arr[0] : %d, arr[1] %d\n", arr[0],arr[1]);
		
	}	// void callByReference
	
	

	public static void main(String[] args) {
		
		// □ 1. call by value
		int first=1, second=2;
		System.out.printf("Call by Value 호출 전, first : %d, second : %d\n", first,second);
		callByValue(first,second);
		System.out.printf("Call by Value 호출 후, first : %d, second : %d\n", first,second);
		
		
		System.out.printf("\n================================================\n\n", first,second);
		// □ 2. call by reference
		int[] ref = new int[2];
		ref[0]=1;
		ref[1]=10;
		System.out.printf("Call by Reference 호출 전, ref[0] : %d, ref[1] : %d\n", ref[0],ref[1]);
		callByReference(ref);
		System.out.printf("Call by Reference 호출 후, ref[0] : %d, ref[1] : %d\n", ref[0],ref[1]);
		
	}	// main

}	// class
