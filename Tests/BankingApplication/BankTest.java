package BankingApplication;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    Bank bank;
    Customer customer;
    BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        bank = new Bank();

    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void testThatABankCanHaveCustomers() {
        customer = new Customer("billy", "audu", "adams", "semicolon,Yaba",
                "billyaudu@gmail.com", "09056790444");
        bank.registerCustomers(customer, bankAccount);
        assertEquals(customer, bank.getCustomers()[0]);
    }

    @Test
    void testThatTwoCustomersAreNotAssignedTheSameSpot() {
        customer = new Customer("billy", "audu", "adams", "semicolon,Yaba",
                "billyaudu@gmail.com", "09056790444");
        bankAccount = new BankAccount("Savings", 1000);
        bank.registerCustomers(customer, bankAccount);
//        System.out.println(customer.toString() + bankAccount.toString());

        Customer customer2 = new Customer("bil", "aud", "adams", "semicolon,Yaba",
                "billyaudu@gmail.com", "09056790444");
        BankAccount bankAccount2 = new BankAccount("Current", 1000);
        bank.registerCustomers(customer2, bankAccount2);


//        assertEquals(customer,bank.getCustomers()[0]);
//        assertEquals(customer2, bank.getCustomers()[1]);
    }

    @Test
    void testThatTransactionsArePossible() {
        customer = new Customer("billy", "audu", "adams", "semicolon,Yaba",
                "billyaudu@gmail.com", "09056790444");
        bankAccount = new BankAccount("Savings", 1000);
        bank.registerCustomers(customer, bankAccount);

        Customer customer2 = new Customer("bil", "aud", "adams", "semicolon,Yaba",
                "billyadu@gmail", "090675888353");
        BankAccount bankAccount2 = new BankAccount("CURRENT", 1000);
        bank.registerCustomers(customer2, bankAccount2);

//        System.out.println(bank.withdrawal(bankAccount,2000));
//        assertEquals(1000,bankAccount.getBalance());
//        System.out.println(bank.withdrawal(bankAccount,1000));
//        assertEquals(0,bankAccount.getBalance());
//
//        System.out.println(bank.depositMoney(bankAccount2, -100));
//        assertEquals(1000, bankAccount2.getBalance());

//        System.out.println(bank.getCustomers()[1].toString() + bankAccount2.toString());
        System.out.println(bank.getCustomerAccountDetails("current", bankAccount2.getAccountId().toString()));

    }

    @Test
    void testThatTheCustomersCanSetPassword(){
        customer = new Customer("onye", "agbo", "sule", "semicolon,Yaba",
                "lizbabe@gmail.com", "09057464748");

        bankAccount = new BankAccount("Current", 1000);
        bank.registerCustomers(customer, bankAccount);

//        System.out.println(bank.setCustomerPassword(bankAccount.getAccountId().toString(), "13242"));
//        System.out.println(bankAccount.getAccountId().toString());
        System.out.println(customer.toString());
    }


    @Test
    void testThatTransactionsCanBeMade(){
        customer = new Customer("onye", "agbo", "sule", "semicolon,Yaba",
                "lizbabe@gmail.com", "09057464748");

        bankAccount = new BankAccount("Current", 1000);
        bank.registerCustomers(customer, bankAccount);
        bank.setCustomerPassword(bankAccount.getAccountId().toString(),"12345");

        Customer customer2 = new Customer("jude", "sam", "simon", "semicolon,Yaba",
                "samI@gmail.com", "09058756473");

       BankAccount bankAccount2 = new BankAccount("Savings", 1500);
        bank.registerCustomers(customer2, bankAccount2);
        bank.setCustomerPassword(bankAccount2.getAccountId().toString(), "8765");
//        bank.depositMoney(bankAccount2.getAccountId().toString(),400);
//        assertEquals(1900, bankAccount2.getBalance());

//        System.out.println(bank.withdrawal(bankAccount2.getAccountId().toString(),500,"8765"));
//    assertEquals(1400, bankAccount2.getBalance());

        System.out.println(bank.transfer(bankAccount2.getAccountId().toString()
                ,bankAccount.getAccountId().toString(),500,"8765"));

//    bank.transfer(bankAccount2.getAccountId().toString(), bankAccount.getAccountId().toString(),400, "8765");
//    assertEquals(1000, bankAccount2.getBalance());



    }


}