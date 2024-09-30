package collection20;

//복습★, 졸았음

// § Comparable 인터페이스 구현, Collections.sort(List컬렉션) 인자 하나짜리 사용

import java.sql.Date;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

// 방법 1. Comparable 인터페이스를 구현 : Collections.sort(List컬렉션) 인자 하나짜리를 사용
/*
 * 	- Collections.sort(리스트 컬렉션)를 적용하기위해서는 리스트 컬렉션에 저장된 객체(타입)은 반드시 Comparable을 구현해야함
 * 	// class Address implements Comparable<Address>{
 */

// 방법 2. Address 객체 사용

class Address {
	private String name;
	private int age;
	private String addr;
	private Date birthday;
		
	public Address(String name, int age, String addr, Date birthday) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return String.format("[이름: %s,나이: %s,주소: %s,생일: %s", name,age,addr,birthday);
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getAddr() {
		return addr;
	}

	public Date getBirthday() {
		return birthday;
	}
	
	public static final int SORT_BY_NAME=1;//디폴트
	public static final int SORT_BY_AGE=2;
	public static final int SORT_BY_ADDRESS=3;
	public static final int SORT_BY_BIRTHDAY=4;

	
	// 2-1) 방법 1. 정렬시 구분자로 사용할 정적 필드(디폴트는 이름으로 정렬하는 것)
	/*
	public static int sortField = SORT_BY_NAME;
	//◆◆◆◆◆◆◆◆
	@Override
	public int compareTo(Address target) {
		switch(sortField) {
			case SORT_BY_NAME:
				return this.name.compareTo(target.name);
			case SORT_BY_AGE:
				return this.age - target.age;
			case SORT_BY_ADDRESS:
				return this.addr.compareTo(target.addr);
			default:
				return this.birthday.compareTo(target.birthday);
		}
	}
	*/
	
	
}


public class AddressBookApp {
	
	// 방법 2.+ 정렬용 메소드 정의해서 사용
	/*	- 정렬시 Collections.sort(List컬렉션, Comparator 타입) 인자 두개 사용
	 * 1. 리스트 컬렉션에 저장할 객체인 Address가 Comparable 인터페이스를 구현할 필요가 없음
	 * 2. 정렬시 구분자로 사용할 정적 필드(sortField)도 필요 없음
	 * 
	 */
	public static void sort(int sortField,List<Address> values) {
		Collections.sort(values,new Comparator<Address>() {

			@Override
			public int compare(Address src, Address target) {
				switch(sortField) {
					case Address.SORT_BY_NAME:
						return src.getName().compareTo(target.getName());				
					case Address.SORT_BY_AGE:
						return src.getAge() - target.getAge();
					case Address.SORT_BY_ADDRESS:
						return src.getAddr().compareTo(target.getAddr());
				default:
					return src.getBirthday().compareTo(target.getBirthday());
				}
			}
		});
	}
	

	public static void main(String[] args) {
				
		// 1. 자음을 key값(String) 혹은 Character로 받음
		//	  List계열 컬렉션을 Value값에 넣음 - List<String>
		//	  Map계열 컬렉션-value에는 자음에 해당하는 이름들을 저장
		
		Map<Character,List<String>> nameAddress = new HashMap<>();
		// 1-1) 이름 저장용 List 계열 컬렉션 객체를 생성 및 이름 저장
		List<String> kieyeok = new Vector<>();
		kieyeok.add("권준호");
		kieyeok.add("강백호");
		kieyeok.add("김대남");
		kieyeok.add("김수겸");
		List<String> nieoun = Arrays.asList("노구식","남훈","나대룡");
		
		// 1-2) Map컬렉션(nameAddress)에 이름이 저장된 List계열 컬렉션 저장(연결)
		nameAddress.put('ㄱ',kieyeok);
		nameAddress.put('ㄴ', nieoun);
		
		System.out.println("** 키 값을 알 때 **");
		List<String> values = nameAddress.get('ㄱ');
		for(String value:values) System.out.println(value);
		
		System.out.println("** 키 값을 모를 때 **");
		// 1-2)a1 keySet()으로 Set컬렉션을 얻어서 해당 Set컬렉션에 확장 for문 사용
		Set<Character> keys = nameAddress.keySet();
		for(Character key:keys) {
			System.out.println(String.format("[%c로 시작하는 명단 ]", key));
			// 1-2)a2 get(key)으로 value얻기
			values = nameAddress.get(key);
			for(String value :values) System.out.println(value);
		}
		
		// 2. 초성을 Key값 - String / Character 로 받기
		//	  List계열 컬렉션을 Value값 - List<Map<String,Object>>
		//	  Map계열 컬렉션-Value에는 초성에 해당하는 이름, 주소, 생일, 나이를 저장
		
		Map<Character,List<Map<String,Object>>> address = new HashMap<>();
		
		// 2-1) 이름, 나이, 주소, 생일이 저장된 맵 컬렉션을 저장할 리스트 계열 컬렉션 객체를 생성
		// 방법 1: Comparable 인터페이스 구현 : Collections.sort(List컬렉션) 인자 하나짜리를 사용
		/*
		 * Collections.sort(리스트 컬렉션)을 적용하려면 리스트 컬렉션에 저장된 객체(타입)은 반드시 Comparable을 구현해야함
		 * -> ◆◆◆◆◆◆◆◆ (compareTo 구현)
		 */
		List<Map<String,Object>> kie = new Vector<>();
		List<Map<String,Object>> nie = new Vector<>();
		
		// 2-1)+ kie 객체에 구성인물 객체 생성하여 집어넣기
		Map<String,Object> k = new HashMap<>();
		k.put("name","권준호");
		k.put("age",20);
		k.put("addr", "분당구");
		k.put("birthday", new Date(new java.util.Date().getTime()));
		kie.add(k);
		
		k=new HashMap<>();
		k.put("name", "강백호");
		k.put("age", 18);
		k.put("addr", "중원구");
		k.put("birthday", new Date(new java.util.Date().getTime()));
		kie.add(k);
		
		Map<String,Object> n=new HashMap<>();
		n.put("name", "남훈");
		n.put("age", 20);
		n.put("addr", "수성구");
		n.put("birthday", new Date(new java.util.Date().getTime()));
		nie.add(n);
		n=new HashMap<>();
		n.put("name", "나대룡");
		n.put("age", 19);
		n.put("addr", "수성구");
		n.put("birthday", new Date(new java.util.Date().getTime()));
		nie.add(n);
		
		// 2-2) 주소록 저장하는 맵컬렉션에 리스트 저장
		address.put('ㄱ', kie);
		address.put('ㄴ', nie);
		
		// 객체 꺼내올때 : Set/List 계열(Collection계열) 모두 확장 for문 사용
		// Map계열은 keySet()으로 키값들이 저장된 Set계열 반환 받은 후 확장 for문 사용
		
		System.out.println("** 키 값을 알 때 **");
		List<Map<String,Object>> nieons = address.get('ㄴ');
		for(Map<String,Object> map:nieons) {
			Set<String> sets = map.keySet();
			for(String key:sets) {
				Object value = map.get(key);
				System.out.println(String.format("%s : %s", key,value));
			}
		}
		//아리까리?????????
		
		
		System.out.println("** 키 값을 모를 때 **");
		keys = address.keySet();
		for(Character key:keys) {
			System.out.println(String.format("** %c로 시작하는 명단", key));
			List<Map<String,Object>> vals = address.get(key);
			for(Map<String,Object> map: vals) {
				Set<String> sets = map.keySet();
				for(String ky:sets) {
					Object value = map.get(ky);
					System.out.println(String.format("%s : %s", ky,value));
				}
			}
		}
		
		// 2-2) 방법 2 : Address 클래스를 사용해서 2-1) 방법 1처럼 구현
		// 2-2) a. 주소를 저장할 리스트 계열 컬렉션을 생성
		Map<Character,List<Address>> addressBook = new HashMap<>();
		// 2-2) b. 주소 저장
		List<Address> kiec = new Vector<>();
		List<Address> niec = new Vector<>();
		// 2-2) c. 값 저장
		long epochTime = new java.util.Date().getTime();
		kiec.add(new Address("권준호", 52, "강동구", new Date(epochTime)));
		kiec.add(new Address("강백호", 49, "용산구", new Date(epochTime)));
		kiec.add(new Address("김대남", 50, "노원구", new Date(epochTime)));
		
		niec.add(new Address("노구식", 50, "노원구", new Date(epochTime)));
		niec.add(new Address("남훈", 52, "수성구", new Date(epochTime)));
		niec.add(new Address("나대룡", 51, "수성구", new Date(epochTime)));
		
		// 2-2) d. 키 값으로 리스트 컬렉션 객체를 맵(addressBook)에 저장
		addressBook.put('ㄱ', kiec);
		addressBook.put('ㄴ', niec);
		
		System.out.println("**** 클래스를 사용해서 구현한 경우 ****");
		keys = addressBook.keySet();
		for(Character key:keys) {
			System.out.println(String.format("** %c로 시작하는 명단", key));
			List<Address> vals = addressBook.get(key);
			
			//출력 전 정렬 하기
			// 방법 1로 정렬시 : 나이로 정렬시 아래 한줄 코드 추가됨
			//Address.sortField=Address.SORT_BY_AGE;
			//Collections.sort(vals);
			
			// 방법 2로 정렬시 : 
			sort(Address.SORT_BY_ADDRESS,vals);
			for(Address val:vals) System.out.println(val);
		}
		


	}	//main

}	//class AddressBookApp
