package BankingApplication;

public interface Transactions {
    String depositMoney(BankAccount bankAccount,int amount);
    String transfer(BankAccount bankAccount,BankAccount bankAccount2,int amount);
    String withdrawal(BankAccount bankAccount,int amount);
}
