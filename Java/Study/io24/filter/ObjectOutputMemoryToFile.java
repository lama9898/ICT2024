package io24.filter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectOutputMemoryToFile implements Serializable{

	public static void main(String[] args) throws IOException {
		// 1. 데이터 소스(메모리) 준비 : 입력 스트림 불필요
		Person p1 = new Person("aaa",20,"인청");
		Person p2 = new Person("aa",22,"부산");
		Person p3 = new Person("도로로",100,"퍼렁별");
		
		// 2. 필터를 끼운 출력 스트림 생성
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/io24/filter/person.txt"));
		
		// 3. 인스턴화된 객체를 oos로 출력
		// 사전 준비사항 : 객체를 파일로 저장하려면 먼저 해당 객체는 직렬화가 되어있어야 함.
		//				직렬화 안된 경우 java.io.NotSerializableException 발생
		// 해결 방법 : implements Serializable
		oos.writeObject(p1);
		oos.writeObject(p2);
		oos.writeObject(p3);
		
	}

}
