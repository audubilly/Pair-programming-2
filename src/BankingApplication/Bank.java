package BankingApplication;

import java.lang.reflect.Array;
import java.util.*;

public class Bank  extends BankVerification implements Transactions {

    private Customer[] customers = new Customer[10];
    private String[] bankVerifications = new String[10];
    int filledLength = 1;

    private final BankAccount bankAccountNotFound = new BankAccount();
    ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();


    public Bank() {
    }

    public Bank(Customer[] customer) {
        this.customers = customer;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void registerCustomers(Customer customer, BankAccount bankAccount) {
        for (int counter = 0; counter < customers.length; counter++) {
            if (customers[0] == null) {
                customers[0] = customer;
                bankAccounts.add(bankAccount);
                break;
            }

            if (customers[counter] == null) {
                boolean status = isAnExistingCustomerAccount(customer);
                if (!status) {
                    customers[counter] = customer;

                    bankAccounts.add(bankAccount);
                    filledLength += 1;
                    break;
                }
                System.out.println("customer already has an Account");
                break;
            }
        }
    }

    private boolean isAnExistingCustomerAccount(Customer customer) {
        boolean status = false;
        for (int counter = 0; counter < filledLength; counter++) {
            if (customers[counter].getPhoneNumber().equals(customer.getPhoneNumber()) ||
                    customers[counter].getEmail().equals(customer.getEmail())) {
                status = true;
                break;
            }
        }
        return status;
    }

    public String getCustomerAccountDetails(String accountType, String accountID) {
        String status = " Customer Not Found";
        BankAccount bankAccount = bankAccounts.stream()
                .filter(accountProfile -> accountID.equals(accountProfile.getAccountId().toString()))
                .findFirst().orElse(bankAccountNotFound);

        int counter = bankAccounts.indexOf(bankAccount);
        if (counter >= 0) {
            if (customerAccountTypeVerification(accountType, bankAccount)) {
                status = customers[counter].toString() + bankAccount.toString();
            } else {
                status = "customer not found with " + accountType;
            }
        }
        return status;
    }

    public String setCustomerPassword(String accountID, String password) {
        String status = " Customer not found ";
        BankAccount bankAccount = bankAccounts.stream()
                .filter(accountProfile -> accountID.equals(accountProfile.getAccountId().toString()))
                .findFirst().orElse(bankAccountNotFound);

        int counter = bankAccounts.indexOf(bankAccount);
        if (counter >= 0) {
            bankVerifications[counter] = password;
            status = "password successful";

        }
        return status;
    }

    private boolean customerAccountTypeVerification(String accountType, BankAccount bankAccount) {
        boolean confirmation = false;
        if (accountType.equalsIgnoreCase(bankAccount.getAccountTypes().toString())) {
            confirmation = true;
        }
        return confirmation;
    }


    @Override
    public String depositMoney(String accountID, int amount) {
        String status = "";
        BankAccount bankAccount = bankAccounts.stream()
                .filter(accountProfile -> accountID.equals(accountProfile.getAccountId().toString()))
                .findFirst().orElse(bankAccountNotFound);
        status = bankAccount.setDepositMoney(amount);
        return status;
    }

    @Override
    public String transfer(String accountIDFrom, String accountIDTo, int amount, String password) {
        String status = "Transfer Successful";
        BankAccount bankAccount = bankAccounts.stream()
                .filter(accountProfile -> accountIDFrom.equals(accountProfile.getAccountId().toString()))
                .findFirst().orElse(bankAccountNotFound);
        BankAccount bankAccount2 = bankAccounts.stream()
                .filter(accountProfile -> accountIDTo.equals(accountProfile.getAccountId().toString()))
                .findFirst().orElse(bankAccountNotFound);
        int counter = bankAccounts.indexOf(bankAccount);
        if (bankAccount != bankAccountNotFound && bankAccount2 != bankAccountNotFound) {
            if(bankVerifications[counter].equals(password)){
            status = bankAccount.setWithdrawMoney(amount);
            if (status.equalsIgnoreCase("successful")) {
                status+="ly Transferred ";
                bankAccount2.setDepositMoney(amount);
            } } else {
                status = "Transfer failed due to wrong password";
            }
        }
        return status;
    }

    @Override
    public String withdrawal(String accountID, int amount, String password) {
        String status = "Incorrect password";
        BankAccount bankAccount = bankAccounts.stream()
                .filter(accountProfile -> accountID.equals(accountProfile.getAccountId().toString()))
                .findFirst().orElse(bankAccountNotFound);
        int counter = bankAccounts.indexOf(bankAccount);
        if (bankVerifications[counter].equals(password)) {
            status = bankAccount.setWithdrawMoney(amount);
        }
        return status;
    }
}

