package BankingApplication;


import java.util.UUID;

public class BankAccount {
    private int withdrawAmount;
    private int depositAmount;
    private Enum accountTypes;
    private UUID accountId;
    private int accountBalance;




    public BankAccount() {
    }

    public UUID getAccountId() {
        return accountId;
    }

    public BankAccount(String accountTypes) {
        setAccountTypes(accountTypes);
        this.accountId = generateAccountNumber();
    }

    public BankAccount(String accountTypes,String accountId) {

    }

    public BankAccount(String accountTypes,int depositAmount) {
        setAccountTypes(accountTypes);
        this.accountId = generateAccountNumber();
        this.accountBalance = depositAmount;
    }

    private UUID generateAccountNumber() {
        UUID accountNumber = null;
        if (accountTypes==AccountTypes.SAVINGS) {
            accountNumber =  UUID.randomUUID();

        }
        if (accountTypes==AccountTypes.CURRENT){
            accountNumber = UUID.randomUUID();
    }
        return accountNumber;
}

    public int getWithdrawMoney() {
        return withdrawAmount;
    }

    public String setWithdrawMoney(int withdrawAmount) {
        String status="";
        this.withdrawAmount = withdrawAmount;
        if(accountBalance>=withdrawAmount){
        accountBalance = accountBalance - withdrawAmount;
            status="Successful";
        }
        else {
            status="Insufficient Funds";
        }
        return status;
    }

    public int getDepositMoney() {
        return depositAmount;
    }

    public String setDepositMoney(int depositAmount) {
        String status="Successful deposit";
        if(depositAmount>0){this.depositAmount = depositAmount;
        accountBalance = accountBalance + depositAmount;}
        else {status="Invalid amount";
        }
        return status;
    }


    public int getBalance() {
        return accountBalance;
    }

    public void setAccountTypes(String accountTypes) {
       accountTypes = accountTypes.toLowerCase();
        switch (accountTypes){
            case  "savings" -> {this.accountTypes=AccountTypes.SAVINGS;
                                 this.accountId = generateAccountNumber();
            }
            case "current" ->{this.accountTypes=AccountTypes.CURRENT;
                this.accountId = generateAccountNumber();
            }
        }


    }

    public Enum getAccountTypes() {
        return accountTypes;
    }

    @Override
    public String toString() {
        return String.format("%nYour account balance is %d%nAnd your account type is a %s account%nThe account Id is %s%s%n }",
                getBalance(),getAccountTypes(),(accountTypes==AccountTypes.SAVINGS?"SA-":"CU-"), getAccountId());
    }
}


