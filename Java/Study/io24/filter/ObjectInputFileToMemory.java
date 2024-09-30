package io24.filter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class ObjectInputFileToMemory {

	public static void main(String[] args) throws FileNotFoundException,IOException, ClassNotFoundException {
		// 1.필터를 끼운 입력 스트림 생성
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/io24/filter/person.txt"));
		
		// 2.ois로 읽어서 person타입에 저장
		Object obj = ois.readObject();
		
		if(obj instanceof Person) {
			Person p1 = (Person)obj;
			System.out.println(p1);
		}
		Person p2 = (Person)ois.readObject();
		System.out.println(p2);
		Person p3 = (Person)ois.readObject();
		System.out.println(p3);
//		ois.readObject(); // java.io.FileNotFoundException 에러 발생
		
		ois.close();

	}

}
