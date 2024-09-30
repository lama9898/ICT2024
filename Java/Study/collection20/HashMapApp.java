package collection20;

// 복습...어려움..

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import console.academy.Student;


/*
	HashMap: Map(인터페이스)계열의 컬렉션 클래스
		- key 와 value(객체)의 쌍으로 객체 저장
		- 키값은 중복이 안된다
		- 키값으로 검색하기 때문에 다른 컬렉션보다 검색 속도가 빠르다
		- 내부적으로 set으로 저장
	
		데이타 꺼내올때:
		keySet():Set<?>타입 반환
		get(키값):키값에 해당하는 value(객체)값 반환
		keys()  :Enumeration<?>타입 반환(Hashtable의 메소드)
		values():Collection<?>타입 반환,value값만 반환
	 */

public class HashMapApp {

	public static void main(String[] args) {
		// 1. 컬렉션 객체 생성 - Raw Type
		Map map = new HashMap();
		
		// 2. 객체 저장 : Object put(키값, 객체값);
		// 				반환값(value의 타입) : 키 값으로 저장시 이전에 저장된 value(객체) 반환(덮어쓰기, 키값은 중복되면 X)
		//									이전에 저장된 value(객체)가 없을 시 null
		
		System.out.println("name이라는 키 값으로 이전에 저장된 객체: "+map.put("name","김씨"));
		map.put("age", 20);	//원래는 int형 넣으면 안됨 (Integer) 오토박싱
		map.put("gender", "남자");
		map.put("address", new String("논현동"));
		
		// 3. 저장된 객체 수 : int size()
		System.out.println("저장된 객체 수: "+map.size());
		
		// 4. 키값을 중복해서 저장 : 저장은 되나 기존 키 값에 해당 하는 값이 새로운 객체로 대체됨
		System.out.println("name이라는 키 값으로 이전에 저장된 객체: "+map.put("name", "Mr.Kim"));
		System.out.println("키 값 중복 저장 후 저장된 객체 수: "+map.size());
		
		// 5. 출력
		// 5-1) 키 값을 아는 경우 : Object get(키값)
		System.out.println("키 값을 알 때 : "+map.get("name"));
		//for(Object o:map) {	}	//map에는 확장 for문을 직접적으로 적용 불가
		// 확장 for문은 배열이나 반복가능한(Iterable) 객체(Set,List 계열 컬렉션)에만 적용이 가능하다
		
		// 5-2)키값을 모를때
			// a. Set<?> keySet()메소드 호출:키값들을 Set계열의 컬렉션 형태로 반환
			// b. STEP1에서 얻은 Set계열 컬렉션에 확장 for문 적용해서 키값 얻기
			// c. get(키값)으로 Value(객체)값 얻는다.
		
		// a. key 값들이 저장된 set컬렉션 얻기
		Set keys = map.keySet();	//Set컬렉션은 순서없음
		// b.
		for(Object o:keys) {
			// c.
			Object value = map.get(o);
			System.out.println(String.format("%s : %s", o,value));
		}
		
		// 5-3) Value만 얻어 올 때 : values()
		Collection values = map.values();
		System.out.println("[ values(객체들)만 얻기 ]");
		for(Object o:values) {
			System.out.println(o);
		}

		// 6. 검색 : 
		/*
		 * boolean containsKey(key) - 해당 키가 존재하면 true, false
		 * boolean containsValue(value) - 해당 값이 존재하면 true, false
		 */
		
		System.out.println(map.containsKey("name"));
		System.out.println(map.containsKey("tall"));
		System.out.println(map.containsValue("남자"));
		System.out.println(map.containsValue("남성"));
		
		// 7. 삭제
		/*
		 * Object remove(키값) - 삭제된 키 값에 해당하는 value(객체) 반환
		 */
		
		System.out.println("삭제된 객체(value) : "+map.remove("gender"));
		System.out.println("삭제 후 출력 :");
		for(Object o:keys) {
			Object value = map.get(o);
			System.out.println(String.format("%s : %s", o,value));
		}
		
		// 8. 전체 삭제
		/*
		 * removeAll()은 없음, clear()로 삭제
		 */
		map.clear();
		System.out.println("clear 이후 저장된 객체 수: "+map.size());
		
		/*
		 * Hashtable 클래스(Map계열)에서는 keySet(), values(), get("키값") 으로 모두꺼내올 수 있다.
		 * 또한 keys() 메소드를 통해서도 가능
		 * HashMap 클래스에서는 keys()메소드가 없음
		 */
		
		map = new Hashtable();
		map.put("기관", "한국 개발원");
		map.put("위치","강남");
		map.put("대표", "염기호");
		Enumeration em = ((Hashtable)map).keys();
		while(em.hasMoreElements()) {
			//키 값 얻기
			Object key = em.nextElement();
			
			//value 값 얻기
			Object value = map.get(key);
			
			System.out.println(String.format("%s : %s", key,value));
		}
		
		// 타입 파라미터 지정 : Generic Type(타입 안정성(컴파일 시점에 타입체크), 형변환 불필요)
		Map<String,Student> genericMap = new HashMap<String,Student>();
		
		// 컬렉션에 저장할 객체 생성
		Student stu1 = new Student("A",20,"2024학번");
		Student stu2 = new Student("B",24,"2020학번");
		Student stu3 = new Student("C",19,"2025학번");
		Student stu4 = new Student("D",27,"2017학번");
		
		// 객체 저장
		genericMap.put("학생1",stu1);
		genericMap.put("학생2",stu2);
		genericMap.put("학생3",stu3);
		genericMap.put("학생4",stu4);
		
		System.out.println(" 키 값을 알 때");
		System.out.println(genericMap.get("학생1").get());
		System.out.println(" 키 값을 모를 때");
		Set<String> kies = genericMap.keySet();	//set의 String을 반환해줌
		for(String kie:kies) {
			Student value = genericMap.get(kie);
			System.out.println(String.format("%s : %s", kie,value.get()));
		}
		
	}

}
