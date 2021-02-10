package BankingApplication;

import java.security.SecureRandom;

public class BankAccount {
    private int withdrawAmount;
    private int depositAmount;
    private String accountTypes;
    private String accountNumber;
    private int accountBalance;


    SecureRandom random = new SecureRandom();

    public BankAccount() {
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BankAccount(int accountTypes) {
        setAccountTypes(accountTypes);
        this.accountNumber = generateAccountNumber();
    }

    public BankAccount(int accountTypes, String accountNumber) {


    }

    public BankAccount(int accountTypes,int depositAmount) {
        setAccountTypes(accountTypes);
        this.accountNumber = generateAccountNumber();
        this.accountBalance = depositAmount;
    }



    private String generateAccountNumber() {
        String accountNumber = null;
        if (accountTypes.equals("Savings")) {
            accountNumber = "1010" + forSavings();
        }
        if (accountTypes.equals("Current")){
            accountNumber = "2020" + forSavings();
    }
        return accountNumber;
}
    private String forSavings() {
        String savingsAccountNumber = null;
        savingsAccountNumber = String.valueOf(random.nextInt(3));
        savingsAccountNumber += String.valueOf(random.nextInt(5));
        return savingsAccountNumber;
    }


    public int getWithdrawMoney() {
        return withdrawAmount;
    }

    public String  setWithdrawMoney(int withdrawAmount) {
        String status ="";
        this.withdrawAmount = withdrawAmount;
        if (accountBalance >= withdrawAmount) {
            accountBalance = accountBalance - withdrawAmount;
            status = "Successful";
        } else
            {
            status = "Insufficient funds";
        }
        return status;
    }
    public int getDepositMoney() {
        return depositAmount;
    }

    public String setDepositMoney(int depositAmount) {
        String status = " Successful deposit";
        if (depositAmount > 0) {
            this.depositAmount = depositAmount;
            accountBalance = accountBalance + depositAmount;
        }else{
            status = " Invalid Amount";
        }
        return status;
    }


    public int getBalance() {
        return accountBalance;
    }

    public void setAccountTypes(int accountTypes) {
        switch (accountTypes){
            case 1 -> this.accountTypes = "Savings";
            case 2 -> this.accountTypes = "Current";
        }
        this.accountNumber = generateAccountNumber();

    }

    public String getAccountTypes() {
        return accountTypes;
    }

    @Override
    public String toString() {
        return String.format("%nYour account balance is %d%nAnd your account type is a %s account%nthe account Number is %s%n }", getBalance(),getAccountTypes(), getAccountNumber());
    }
}


