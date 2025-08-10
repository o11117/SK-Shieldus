package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;

import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

public class Bank {
	private List<Account> accounts = new ArrayList<>();
	private int nextAccountNumber;
	
	public Bank() {
		nextAccountNumber = 1000;
	}
	
	public String createSavingsAccount(String ownerName, double balance, double interestRate) {
		String accountNumber = "AC" + nextAccountNumber++;
		SavingsAccount sa = new SavingsAccount(accountNumber,ownerName,balance,interestRate);
		accounts.add(sa);
		return accountNumber;
	}
	
	public String createCheckingAccount(String ownerName, double balance, double withdrawalLimit){
		String accountNumber = "AC" + nextAccountNumber++;
		CheckingAccount ca = new CheckingAccount(accountNumber,ownerName,balance,withdrawalLimit);
		accounts.add(ca);
		return accountNumber;
	}
	
	public Account findAccount(String accountNumber) throws AccountNotFoundException{
		for (Account account:accounts) {
			if (account.getAccountNumber().equals(accountNumber)) {
				return account;
			}
		}
			//make Exception
		        throw new AccountNotFoundException("계정을 찾을 수 없습니다: " + accountNumber);
	}
	
	public void deposit (String accountNumber, double amount) throws AccountNotFoundException{
		Account account = findAccount(accountNumber);
		account.deposit(amount);
	}
	
	public void withdraw(String accountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException{
		Account account = findAccount(accountNumber);
		account.withdraw(amount);
	}
	
	public void transfer(String fromAccountNumber, String toAccountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException {
		Account fromAccount = findAccount(fromAccountNumber);
        Account toAccount = findAccount(toAccountNumber);
        
        fromAccount.withdraw(amount); // 출금
        toAccount.deposit(amount);    // 입금
	}
	
	public void printAllAccounts() {
		System.out.println("===== 모든 계좌 목록 =====");
        for (Account account : accounts) {
            System.out.println(account);
        }
	}
}
