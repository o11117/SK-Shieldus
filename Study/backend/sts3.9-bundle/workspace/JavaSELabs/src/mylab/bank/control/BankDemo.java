package mylab.bank.control;

import mylab.bank.entity.Account;
import mylab.bank.entity.Bank;
import mylab.bank.entity.CheckingAccount;
import mylab.bank.entity.SavingsAccount;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class BankDemo {

	public static void main(String[] args) {
		Bank bank = new Bank();
		
		System.out.println("=== 계좌 생성 ===");
        String accNum1 = bank.createSavingsAccount("홍길동", 10000, 3.0);
        String accNum2 = bank.createCheckingAccount("김철수", 20000, 5000.0);
        String accNum3 = bank.createSavingsAccount("이영희", 30000, 2.0);
		
        try {
            
            Account acc1 = bank.findAccount(accNum1);
            Account acc2 = bank.findAccount(accNum2);
            Account acc3 = bank.findAccount(accNum3);

            
            System.out.println("Saving(저축) 계좌가 생성되었습니다: " + acc1);
            System.out.println("체킹 계좌가 생성되었습니다: " + acc2);
            System.out.println("저축 계좌가 생성되었습니다: " + acc3);

            bank.printAllAccounts();
            System.out.println("===================");

            System.out.println("\n=== 입금/출금 테스트 ===");
            bank.deposit(accNum1, 5000);
            System.out.println("5000.0원이 입금되었습니다. 현재 잔액: " + bank.findAccount(accNum1).getBalance() + "원");
            bank.withdraw(accNum2, 3000);
            System.out.println("3000.0원이 출금되었습니다. 현재 잔액: " + bank.findAccount(accNum2).getBalance() + "원");

            System.out.println("\n=== 이자 적용 테스트 ===");
            // 이자 계산 후 입금
            SavingsAccount sa1 = (SavingsAccount) bank.findAccount(accNum1);
            double interest1 = sa1.getBalance() * sa1.getInterestRate() / 100;
            bank.deposit(accNum1, interest1);
            System.out.println(String.format("%.1f원이 입금되었습니다. 현재 잔액: %.1f원", interest1, bank.findAccount(accNum1).getBalance()));
            System.out.println(String.format("이자 %.1f원이 적용되었습니다. 현재 잔액: %.1f원", interest1, bank.findAccount(accNum1).getBalance()));

            System.out.println("\n=== 계좌 이체 테스트 ===");
            bank.withdraw(accNum3, 5000);
            System.out.println(String.format("5000.0원이 출금되었습니다. 현재 잔액: %.1f원", bank.findAccount(accNum3).getBalance()));
            bank.deposit(accNum2, 5000);
            System.out.println(String.format("5000.0원이 입금되었습니다. 현재 잔액: %.1f원", bank.findAccount(accNum2).getBalance()));
            System.out.println("5000.0원이 " + accNum3 + "에서 " + accNum2 + "로 송금되었습니다.");

            bank.printAllAccounts();
            System.out.println("===================");

            System.out.println("예외 처리 테스트");
            try {
                bank.withdraw(accNum2, 10000); 
            } catch (WithdrawalLimitExceededException e) {
                System.out.println("예외 발생: " + e.getMessage());
            }

            try {
                bank.withdraw(accNum2, 6000); 
            } catch (WithdrawalLimitExceededException e) {
                System.out.println("예외 발생: " + e.getMessage());
            }

            try {
                bank.findAccount("AC9999"); 
            } catch (AccountNotFoundException e) {
                System.out.println("예외 발생: 계좌번호 AC9999에 해당하는 계좌를 찾을 수 없습니다.");
            }

        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            e.printStackTrace();
        }
    }

}