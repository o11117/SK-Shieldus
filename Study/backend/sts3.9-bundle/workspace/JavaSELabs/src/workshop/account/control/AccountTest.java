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
				
		//1-2 getter method call
		System.out.println("����ȣ = " + account.getCustId());
		System.out.println("���¹�ȣ = " + account.getAcctId());
		System.out.println("�ܾ� = " + account.getBalance());
		
		//2.��ü ���� - �����ε��� ������ ȣ��
		Account account2 = new Account("B1200", "221-22-3466", 2000);
		System.out.println("����ȣ = " + account2.getCustId());
		System.out.println("���¹�ȣ = " + account2.getAcctId());
		System.out.println("�ܾ� = " + account2.getBalance());
	
		System.out.println("10000�� �Ա�");
		account2.deposit(10000);
		System.out.println("�ܾ� = " + account2.getBalance());

		System.out.println("10000�� ���");
		account2.withdraw(10000);
		System.out.println("�ܾ� = " + account2.getBalance());

	}

}
