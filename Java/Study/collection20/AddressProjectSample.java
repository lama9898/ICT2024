package collection20;

//복습 ... 졸았음

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

import common.utils.CommonUtils;

public class AddressProjectSample {

	public static void main(String[] args) {
		Map<Character,List<Address>> addressBook = new HashMap<>();
		Scanner sc= new Scanner(System.in);
		// 1. 벨류 타입을 null로 초기화  저장할 개체
		List<Address> valueList = null;
		while(true) {
			System.out.println("이름을 입력하세요 (종료시 exit)");
			String name = sc.nextLine().trim();
			//System.out.println(CommonUtils.getInitialConsonant(name));
			if("EXIT".equalsIgnoreCase(name)) break;
			
			// 2. 입력한 이름에서 자음 얻기
			char consonant = CommonUtils.getInitialConsonant(name);
			if(consonant=='0') {
				System.out.println("한글명이 아닙니다.");
				continue;
			}
			//한글명일 때
			System.out.println("주소를 입력하세요");
			String addr = sc.nextLine().trim();
			System.out.println("나이를 입력하세요");
			int age = Integer.parseInt(sc.nextLine().trim());
			Date birthday = new Date(new java.util.Date().getTime());
					
					
			if(!addressBook.containsKey(consonant)) {
				valueList = new Vector<>();
			} // 키값이 없는 경우, 
			else {
				//키값이 존재하는 경우
				valueList = addressBook.get(consonant);
			}
			// 입력한 정보로 Address 타입 생성 후 맵의 value에 추가
			valueList.add(new Address(name,age,addr,birthday));
			
			// 4. 맵 컬렉션에 키값으로 저장
			addressBook.put(consonant,valueList);
			
		}
		//출력
		Set<Character> keys = addressBook.keySet();
		for(Character key:keys) {
			System.out.println(String.format("%c로 시작하는 명단 : ",key));
			List<Address> values = addressBook.get(key);
			for(Address value:values) System.out.println(value);
		}
		/*	문]찾고자 하는 사람의 이름을 입력받아
		    위 맵 컬렉션(addressBook)에 저장된 사람의 정보를 출력하자.
		    만약 해당하는 사람이 없으면 "해당하는 사람이 없어요"라고 출력하여라. 찾을때까지 계속 입력받도록 하여라.
		 */
//		System.out.print("찾을 사람의 이름을 입력하세요");
//		String name = sc.nextLine().trim();
//		char firstLetter = CommonUtils.getInitialConsonant(name);
//		for(Character key:keys) {
//			if(firstLetter == key) {
//				List<Address> values = addressBook.get(key);
//				for(Address value:values) {
//					if(value.equals(name)) {
//						System.out.println(value);
//					}
//				}
//			}
//		}
		
		while(true) {
			System.out.println("찾는 사람의 이름을 입력하세요");
			String name = sc.nextLine().trim();
			boolean isExist = false;
			for(Character key:keys) {
				List<Address> values = addressBook.get(key);
				for(Address value:values) {
					if(value.getName().equals(name)) {
						System.out.println(value);
						isExist = true;
						break;
					}
				}//for
				if(isExist) break;
			}//for
			if(isExist) break;
			System.out.println("하당하는 사람이 없어요");
		}

	}

}
