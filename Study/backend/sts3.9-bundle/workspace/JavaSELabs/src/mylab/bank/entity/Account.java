package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

public class Account {
	private String accountNumber;
	private String ownerName;
	private double balance;
	
	public Account(String accountNumber, String ownerName, double balance) {
		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw (double amount) throws InsufficientBalanceException {
		if (balance < amount) {
            throw new InsufficientBalanceException("ÀÜ¾× ºÎÁ·: ÇöÀç ÀÜ¾× " + balance + "¿ø");
        }
        balance -= amount;
	}
	
	@Override
    public String toString() {
        return String.format("°èÁÂ¹øÈ£: %s , ¼ÒÀ¯ÀÚ: %s , ÀÜ¾×: %.1f¿ø ,", 
                              accountNumber, ownerName, balance);
    }
}
