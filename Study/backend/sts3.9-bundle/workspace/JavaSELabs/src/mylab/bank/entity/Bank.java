package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;

import mylab.bank.exception.AccountNotFoundException;

public class Bank {
	private List<Account> accounts = new ArrayList<>();
	private int nextAccountNumber;
	
	public Bank(){
		
	}
	
	public String createSavingsAccount(String ownerName, double balance, double interestRate) {
		
	}
	
	public String createCheckingAccount(String ownerName, double balance, double withdrawalLimit) {
		
	}
	
	public Account throws AccountNotFoundException findAccount(String accountNumber) {
		
	}
	
	public void throws AccountNotFoundException deposit(String accountNumber, double amount) {
		
	}
	
	public void throws AccountNotFoundException, InsufficientBalanceExceptionficientBalanceException withdraw(String accountNumber, double amount) {
		
	}
	
	public void throws AccountNotFoundException, InsufficientBalanceExceptionficientBalanceException transfer(String ownerName String accountNumber, double amount) {
		
	}
	
	public void printAllAccounts() {
		
	}
}
