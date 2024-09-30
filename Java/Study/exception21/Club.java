package exception21;

public class Club {
	void entrance(String clothes, int age) throws NotGoodApperanceException {
		if("남루".equals(clothes)) throw new NotGoodApperanceException();
		else if("정장".equals(clothes) && age<20) throw new NotGoodApperanceException("나이가 너무 어려요");
		else if("정장".equals(clothes) && age>40) throw new NotGoodApperanceException("나이가 너무 많아요");
		
		System.out.println("입장하세요...즐...거운 생활");
	}
}
