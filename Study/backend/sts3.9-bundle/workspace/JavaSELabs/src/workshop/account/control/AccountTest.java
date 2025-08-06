package workshop.account.control;

import workshop.account.entity.Account;

public class AccountTest {

	public static void main(String[] args) {
		//1. Account ��ü���� - �⺻������ ȣ��
		Account account = new Account();
		
		//����ȣ : ��A1100��, ���¹�ȣ : ��221-22-3477��, �ܾ� : 100000
		account.setCustId("A1100");
		account.setAcctId("221-22-3477");
		account.deposit(1000);
		
		//2.��ü ���� - �����ε��� ������ ȣ��
		new Account("B1200", "221-22-3466", 2000);
	}

}
