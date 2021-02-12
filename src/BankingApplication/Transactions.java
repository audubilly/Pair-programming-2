package BankingApplication;

public interface Transactions {
    String depositMoney(String accountId,int amount);
    String transfer(String accountIdFrom,String accountIDTo,int amount,String password);
    String withdrawal(String accountId,int amount, String password);
}
