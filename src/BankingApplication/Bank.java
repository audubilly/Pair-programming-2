package BankingApplication;

import java.util.*;

public class Bank extends BankVerifications implements Transactions{


    private Customer[] customers = new Customer[10];
    private String [] bankVerifications= new String[10];
    int filledLength=1;

    private final BankAccount bankAccountNotFound= new BankAccount();

    ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();

    public Bank() {

    }

    public Bank(Customer[] customer) {
        this.customers = customer;

    }


    public Customer[] getCustomers() {
        Customer[] status = null;


            status = customers;

        return status;


    }

    public boolean registerCustomers(Customer customer,BankAccount bankAccount ) {
          boolean message=false;
        for (int counter = 0; counter < customers.length; counter++) {
              if(customers[0]==null){
                  customers[0]=customer;
                  bankAccounts.add(bankAccount);
                  message=true;
                  break;

              }
              if (customers[counter] == null) {
                  boolean status=isAnExistingCustomerAccount(customer);
                 if(!status){
                  customers[counter] = customer;
                  bankAccounts.add(bankAccount);
                  filledLength+=1;
                  message=true;
                     break;
                 }

                  break;
              }
          }
    return message;
    }

    private boolean isAnExistingCustomerAccount(Customer customer) {
        boolean status=false;
        for(int counter=0; counter<filledLength;counter++){
            if(customers[counter].getPhoneNumber().equals(customer.getPhoneNumber())||
                    customers[counter].getEmail().equals(customer.getEmail())){
                status=true;
                break;
            }
        }
        return status;
 }

    public String getCustomerAccountAndDetails(String accountType,String accountId) {

        String status="Customer Not found";
       String accountIdentity = IdSorter(accountId);
         BankAccount bankAccount =  bankAccounts.stream()
                .filter(accountProfile -> accountIdentity.equals(accountProfile.getAccountId().toString()))
                 .findFirst().orElse(bankAccountNotFound);

      int counter = bankAccounts.indexOf(bankAccount);
      if(counter>=0){
          if(customerAccountTypeVerification(accountType,bankAccount)){
    status=customers[counter].toString()+bankAccount.toString();}
      else{
          status ="Customer not found under "+accountType;
          }
      }

    return status;
    }

    public String setCustomerPassword(String accountId,String password){
        String status="Customer Not found";
        BankAccount bankAccount =  bankAccounts.stream()
                .filter(accountProfile -> accountId.equals(accountProfile.getAccountId().toString()))
                .findFirst().orElse(bankAccountNotFound);

        int counter = bankAccounts.indexOf(bankAccount);
        if(counter>=0){
            if(password.length()==4){
        bankVerifications[counter]=password;
        status="Password Successful";}
            else {
                status="Incorrect password length";
            }
        }
        return status;
    }
    private boolean customerAccountTypeVerification(String accountType, BankAccount bankAccount) {
        boolean confirmation = false;
        if(accountType.equalsIgnoreCase(bankAccount.getAccountTypes().toString())){
            confirmation=true;
        }
        return confirmation;
    }

    @Override
    public String depositMoney(String accountId, int amount) {
        String status="";
        accountId = IdSorter(accountId);
        String finalAccountId = accountId;
        BankAccount bankAccount =  bankAccounts.stream()
                .filter(accountProfile -> finalAccountId.equals(accountProfile.getAccountId().toString()))
                .findFirst().orElse(bankAccountNotFound);
        if(bankAccount!=bankAccountNotFound){
        status=bankAccount.setDepositMoney(amount);}
        else {
            status="bank account not found";
        }
        return status;
    }

    private String IdSorter(String accountId) {
        String filteredId=accountId;
        String one = String.valueOf(accountId.charAt(0));
        String two = String.valueOf(accountId.charAt(1));
        String three= String.valueOf(accountId.charAt(2));
        String preceding=one+two+three;
        if((preceding).equalsIgnoreCase("CU-")||(preceding).equalsIgnoreCase("SA-")){
           StringBuilder accountIdTrimmed= new StringBuilder(accountId);
           accountIdTrimmed.delete(0,3);
           filteredId=accountIdTrimmed.toString();
        }
        return filteredId;
    }

    @Override
    public String transfer(String accountIdFrom, String accountIDTo, int amount, String password) {
        String status="Transfer failed due to incorrect account number";
        String accountIdOne = IdSorter(accountIdFrom);
        String accountIdTwo = IdSorter(accountIDTo);
        BankAccount bankAccount =  bankAccounts.stream()
                .filter(accountProfile -> accountIdOne.equals(accountProfile.getAccountId().toString()))
                .findFirst().orElse(bankAccountNotFound);
        BankAccount bankAccount2 =  bankAccounts.stream()
                .filter(accountProfile -> accountIdTwo.equals(accountProfile.getAccountId().toString()))
                .findFirst().orElse(bankAccountNotFound);
        int count=bankAccounts.indexOf(bankAccount);
        if(bankAccount!=bankAccountNotFound && bankAccount2!=bankAccountNotFound){
            if(bankVerifications[count].equals(password)){
            status=bankAccount.setWithdrawMoney(amount);
            if(status.equalsIgnoreCase("successful")){
                status+="ly Transferred";
                bankAccount2.setDepositMoney(amount);}
            }else {
                status="Transfer failed due to wrong password";
            }}
        return status;
    }

    @Override
    public String withdrawal(String accountId, int amount, String password) {
        String status="IncorrectPassword";
       String accountIdentity = IdSorter(accountId);
        BankAccount bankAccount =  bankAccounts.stream()
                .filter(accountProfile -> accountIdentity.equals(accountProfile.getAccountId().toString()))
                .findFirst().orElse(bankAccountNotFound);
        int count=bankAccounts.indexOf(bankAccount);
       if(bankVerifications[count].equals(password)){
        status= bankAccount.setWithdrawMoney(amount);}
       return status;
    }


}