package BankingApplication;

public interface Transactions {
    String depositMoney(BankAccount bankAccount, int amount);
    String  transferMoney(BankAccount bankAccount, BankAccount bankAccount2, int amount);
    String  withdrawMoney(BankAccount bankAccount, int amount);

}
