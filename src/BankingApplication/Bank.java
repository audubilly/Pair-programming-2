package BankingApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Bank implements Transactions {

    private Customer[] customers = new Customer[10];
    private final  BankAccount bankAccountNotFound = new BankAccount();
    ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();


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
            if (customers[counter] == null) {
                customers[counter] = customer;
                bankAccounts.add(bankAccount);
                break;
            }
        }
    }

    public String getCustomerDetails(String accountType, String accountNumber){
        String status = "customer not found";
       BankAccount bankAccount = bankAccounts.stream()
               .filter(accountProfile ->accountNumber.equals(accountProfile.getAccountNumber()))
               .findFirst().orElse(bankAccountNotFound) ;

       int counter = bankAccounts.indexOf(bankAccount);
       if(counter >= 0){
           status = customers[counter].toString() + bankAccount.toString();
       }
       return status;


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