package abstraction06;


class Account{
	//field
	String name; //예금주
	String accountNo; // 계좌번호
	int balance; // 잔액
	
	//method
	//입금
	void deposit(int money) {
		balance+=money;
		System.out.println(money+"원이 입금 되었습니다.");
	}
	
	//출금
	void withDraw(int money) {
		if(balance>=money) {
			balance-=money;
			System.out.println(money+"원이 출금 되었습니다.");
		}
		else {
			System.out.println("잔액이 부족합니다.");
		}
	}
	
	//통장정리
	void printAccount() {
		System.out.printf("[ %s님의 계좌정보 ]\n계좌번호 : %s\n잔액 : %d\n",name,accountNo,balance);
	}
	
}


public class AccountApp {

	public static void main(String[] args) {
		// 계좌 개설
		Account ac1 = new Account();
		ac1.printAccount();	// null님의 계좌번회 null, 잔액 : 0
		
		// 필드 초기화
		ac1.accountNo ="123-456";
		ac1.name = "사쿠라기";
		ac1.balance = 10000;
		System.out.println("\n----필드 초기화 후----\n");
		ac1.printAccount();
		
		//인출
		System.out.println("\n---- 인출 ----\n");
		ac1.withDraw(11000);
		ac1.withDraw(5000);
		ac1.printAccount();
		
		//입금
		System.out.println("\n---- 입금 ----\n");
		ac1.deposit(1000);
		ac1.printAccount();
		
		Account ac2 = new Account();
		ac2.name = "미토";
		ac2.accountNo = "410-111";
		ac2.balance =10000;
		ac2.printAccount();
		
	}	// main

}	// class
