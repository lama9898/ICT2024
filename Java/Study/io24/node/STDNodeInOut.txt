package io24.node;

// 매우 zzZ

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/*
[표준 입출력 장치:]
표준 입력장치:키보드
표준 출력장치:모니터

키보드(데이타 소스)로부터 데이타를 읽어서
모니터(데이타 목적지)에 출력하자

노드 스트림: 데이타 소스나 목적지에 직접 연결 할 수 있는 스트림.
            
★ 키보드에 직접 연결할 수 있는 바이트 기반의 노드 스트림(입력 스트림):System.in

모니터에 직접 연결할 수 있는 바이트 기반으 노드스트림(출력 스트림):System.out

*/

public class STDNodeInOut {

	public static void main(String[] args) throws IOException{
		// 1. 바이트 기반의 입력용 노드 스트림 생성 (키보드와 직접 연결이 가능하기 때문에)
		InputStream is = System.in;
		// input은 바이트 기반, output은 string 
		
		// 2.바이트 기반의 출력용 노드스트림 생성(모니터와 직접 연결이 가능한 노드 스트림)
		PrintStream out = System.out;
		
		// 3. is(입력스트림)로 읽고 out(출력스트림)으로 출력
		// 3-1) is 로 키보드로부터 입력받기
		// int read() : 입력스트림으로부터 1바이트씩 읽어서 그 값을 아스키 코드값으로 반환
		//int code = is.read(); // int code = System.in.read(); 와 같음
		// "A"입력시 -> "A\r\n" -> read()하면 한번에 한글자씩
		
		//3-2) out로 모니터에 출력
		//out.println("입력한 문자: "+code);	//println -> PrintStream에 있음
		
		// 4-1) print()계열 메소드로 출력 : 아스키 코드값을 출력, print계열은 flush할 필요 없음(출력스트림에 있는 것을 목적지에 보내려면)
		//out.println("입력한 문자: "+code); // System.out.println("입력한 문자: code); 와 같음
		//out.write(code);
		//out.flush();
		//out.close();
		
		// 4-2) write()계열 메소드는 입력한 문자 그대로 출력
		// write 계열 메소드는 자동 flush가 안된다.
		// 즉, 출력 스트림에 있는 값을 데이터 목적지로 보내려면 flush()해주거나 close()를 해줘야 함.
		//out.write(code);
		//out.println("프로그램 끝");
		//out.flush();
		//out.close();
		//out.println(); //	스트림 닫기, 출력 스트림 닫으면 이후 출력 풉ㄹ가, 단 입출력 스트림은 닫지 않아도 무방
		
		/*
		out.println(code); 	//ABC이후 엔터  ->
		out.println(is.read()); // B: 66
		out.println(is.read()); // C : 67
		out.println(is.read()); // 14 \r
		out.println(is.read()); // 10 \n
		*/
		
		// 사용자가 입력한 문자 그대로 출력하기 즉 ABC를 그대로 모니터(콘솔)에 출력
		/*
		 * ctrl + z(이클립스용 콘솔)를 입력할 때 read()는 -1을 반환
		 * 엔터값: \r\n => \r =13, \n =10
		 */
		int ascii;
		/*
		while((ascii=is.read())!=-1) {
			// 1) write계열 사용
			//out.write(ascii);
			//out.flush();
			
			// 2) print계열 사용(한글 깨짐)
			out.print((char)ascii);
			
		}*/
		// 사용자가 입력한 문자열을 변수에 그대로 저장
		// read()메소드로 Scanner클래스의 nextLine()메소드 기능 구현하기
		/*
		out.println("아이디를 입력하세요:");
		StringBuilder buf = new StringBuilder();
		while((ascii= is.read())!=13) {
			buf.append((char)ascii);
		}
		out.println("입력한 아이디:"+buf);
		*/
		int totalByte = 0,repeatCount=0;
		StringBuilder buf = new StringBuilder();
		//ABCDE 12345(엔터) : 총 13byte
		/*
		while((ascii= is.read())!=13) {
			totalByte++;	//11이 나올것
			repeatCount++; //11이 나올것	//"read는 한바이트씩 읽는다!"
			buf.append((char)ascii);
		}
		out.println(String.format("총 바이트 수 : %s, 반복 횟수 : %s, 입력문자열 : %s",totalByte,repeatCount, buf));
		*/
		
		// 필터 효과 적용 : read(byte b)
		byte[] b = new byte[10];
		/*
		 * read() : 1바이트씩 읽어서 "읽은 문자"의 "아스키 코드값"으로 반환
		 * read(byte[]) : 1바이트씩 읽어서 읽은 문자를 바이트형 배열에 채움
		 * 				  , 입력스트림에 있는 모든 문자를 읽은 경우/바이트형 배열이 다 채워진 경우 "읽은 바이트 수"를 반환
		 */
		boolean isEnter = false; // ctrl+z안 누르고 엔터로 빠져나오기 위해
		while((ascii=is.read(b))!=-1) {
			totalByte+=ascii;
			repeatCount++;
			for(int i=0;i<ascii;i++) {	//읽은 바이트수(ascii)만큼 반복하면서
				if(b[i]!=13 && b[i]!=10) buf.append((char)b[i]);
				else if(b[i]==13) { isEnter=true;break; }
			}
			if(isEnter) break;
		}
		
		out.println(String.format("총 바이트 수 : %s, 반복 횟수 : %s, 입력문자열 : %s",totalByte,repeatCount, buf));
	}
	// steam은 fifo구조, '큐'

}
