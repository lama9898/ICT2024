package collection20;

import java.util.Set;
import java.util.TreeMap;

/*
 * TreeMap : Map계열 컬렉션
 * 	- 키값이 정렬된 상태로 저장되어 잇음 (오름차순이 기본)
 *  - HashMap보다는 성능이 떨어지나 정렬된 키값으로 출력하고자 할 때 유리
 */


public class TreeMapApp {

	public static void main(String[] args) {
		TreeMap<Character,String> map = new TreeMap();

		//객체 저장]
		map.put('ㄷ', "도길동");
		map.put('ㅎ', "하길동");
		map.put('ㅁ', "마길동");
		map.put('ㄱ', "고길동");
		map.put('ㅎ', "홍길동");
		map.put('ㄱ', "곽길동");
				
		System.out.println("[ 키로 오름차순해서 정렬(기본값) ]");
		Set<Character> keys = map.keySet();
		
		for(Character key:keys) {
			String value = map.get(key);
			System.out.println(String.format("%s : %s", key,value));
			// ㄱ은 덮어쓰기됨
		}
		System.out.println("[ 키로 내림차순해서 정렬 ]");
		keys = map.descendingKeySet();	//내림차순 된 keyset
		for(Character key:keys) {
			String value = map.get(key);
			System.out.println(String.format("%s : %s", key,value));
			// ㄱ은 덮어쓰기됨
		}
	}

}
