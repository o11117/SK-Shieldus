package mylab.bank.entity;

public class SavingsAccount extends Account {

	private double interestRate;

	public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
		super(accountNumber, ownerName, balance);
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}
	
	public void applyInterest() {
		 double interest = getBalance() * (interestRate / 100);
	     deposit(interest);
	}
	
	@Override
    public String toString() {
        return String.format("%s ÀÌÀÚÀ²: %.1f%%", super.toString(), interestRate);
    }
}
