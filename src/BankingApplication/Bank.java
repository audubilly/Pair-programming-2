package BankingApplication;

public class Bank {

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

}