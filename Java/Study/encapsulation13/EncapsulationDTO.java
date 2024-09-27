package encapsulation13;

public class EncapsulationDTO {
	// [멤버변수(필드,속성)]
	// 은닉화 → private
	
	private String name;	// 예금주
	private String accountNo;	// 계좌번호
	private int balance;	// 잔액
	
	//getter
	public String getName() {
		return name;
	}	
	
	public String getAccountNo() {
		return accountNo;
	}
	
	public int getBalance() {
		return balance;
	}
	
	//setter
	public void setName(String username) {
		//this.name=username;
		//this = 객체 자신
		name = username;
	}
	
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;	
		// accountNo = accountNo// 지역변수와 필드가 같은 이름이면 지역변수 우선
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
