package BankingApplication;

public class Bank implements Transactions {

    private Customer[] customers = new Customer[10];
    private BankAccount [] bankAccounts = new BankAccount[10];

    public Bank() {
    }

    public Bank(Customer[] customer) {
        this.customers = customer;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customer,BankAccount bankAccount ) {
        for (int counter = 0; counter < customers.length; counter++) {
            if (customers[counter] == null && bankAccounts[counter] == null) {
                customers[counter] = customer;
                bankAccounts[counter] = bankAccount;
                break;
            }
        }
    }


    @Override
    public String depositMoney(BankAccount bankAccount, int amount) {
        String status = "";
        status = bankAccount.setDepositMoney(amount);
        return status;
    }


    @Override
    public String transferMoney(BankAccount bankAccount, BankAccount bankAccount2, int amount) {
        String status = "Transfer successful";

        status = bankAccount.setWithdrawMoney(amount);
        if(status.equalsIgnoreCase("successful")){
            bankAccount2.setDepositMoney(amount);
        } else{
            status = "Transfer failed";
        }
        return status;
    }



    @Override
    public String withdrawMoney(BankAccount bankAccount, int amount) {
        return bankAccount.setWithdrawMoney(amount);
    }

}