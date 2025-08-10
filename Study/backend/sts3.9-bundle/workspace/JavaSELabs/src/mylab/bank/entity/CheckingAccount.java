package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

public class CheckingAccount extends Account {

	private double withdrawalLimit;

	public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawalLimit) {
		super(accountNumber, ownerName, balance);
		this.withdrawalLimit = withdrawalLimit;
	}

	public double getWithdrawalLimit() {
		return withdrawalLimit;
	}
	
	public void throws InsufficientBalanceException withdraw(double amount){
		
	}
	
	public String toString() {
		
	}
}
