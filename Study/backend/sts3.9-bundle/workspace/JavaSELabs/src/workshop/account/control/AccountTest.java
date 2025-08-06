package workshop.account.control;

import workshop.account.entity.Account;

public class AccountTest {

	public static void main(String[] args) {
		//1. Account 객체생성 - 기본생성자 호출
		Account account = new Account();
		
		//고객번호 : “A1100”, 계좌번호 : “221-22-3477”, 잔액 : 100000
		account.setCustId("A1100");
		account.setAcctId("221-22-3477");
		account.deposit(1000);
		
		//2.객체 생성 - 오버로딩된 생성자 호출
		new Account("B1200", "221-22-3466", 2000);
	}

}
