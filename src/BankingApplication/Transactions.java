package BankingApplication;

public interface Transactions {
    String depositMoney(String accountID,int amount);
    String transfer(String accountIDFrom, String accountIDTo,int amount, String password);
    String withdrawal( String accountID,int amount, String password);

}
