package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class CheckingAccount extends Account {

	private double withdrawalLimit;

	public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawalLimit) {
		super(accountNumber, ownerName, balance);
		this.withdrawalLimit = withdrawalLimit;
	}

	public double getWithdrawalLimit() {
		return withdrawalLimit;
	}
	
	public void withdraw(double amount) throws InsufficientBalanceException{
		if (amount > withdrawalLimit) {
            throw new WithdrawalLimitExceededException("예외 발생: 출금 한도를 초과했습니다. 한도: " + withdrawalLimit + "원");
        }
        super.withdraw(amount); // 부모 Account 클래스의 출금 로직 실행
	}
	
	 @Override
	    public String toString() {
	        return String.format("%s 출금한도: %.1f원", super.toString(), withdrawalLimit);
	    }
}
