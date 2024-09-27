package encapsulation13;

/*
 * EncapsulationDTO에 저장된 데이터를 가공 처리하는 로직을 갖는 클래스
 * 
 * - 초기화 로직
 * - 입금 로직
 * - 인출 로직
 * - 통장 정보 출력 로직
 */


public class EncapsulationDAO {
	// 멤버변수
	private EncapsulationDTO capDto = new EncapsulationDTO();
	
	// 멤버 메소드
	// -초기화 로직
	public void initialize(String name,String accoutNo,int balance) {
		capDto.setName(name);
		capDto.setAccountNo(accoutNo);
		capDto.setBalance(balance);
	}
	
	// -입금 로직
	public void deposit(int money) {
		capDto.setBalance(money+capDto.getBalance());
		System.out.println(money+"원이 입금되었습니다.");
		print();
	}
	
	// -인출 로직
	public void withDraw(int money) {
		if(capDto.getBalance()<money) {
			System.out.println("출금 잔액이 부족합니다.");
			print();
			return;
		}
		else
			capDto.setBalance(capDto.getBalance()-money);
			System.out.println(money+"원이 출금되었습니다.");
			print();
	}
	
	// -통장 정보 출력
	public void print() {
		System.out.println(String.format("[%s님의 계좌정보]\n계좌번호:%s\n잔액:%s"
				,capDto.getName(),capDto.getAccountNo(),capDto.getBalance()));
	}

}
