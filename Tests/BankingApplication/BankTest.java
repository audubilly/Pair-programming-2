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
        bank.setCustomers(customer, bankAccount);
        assertEquals(customer, bank.getCustomers()[0]);
    }

    @Test
    void testThatTwoCustomersAreNotAssignedTheSameSpot() {
        customer = new Customer("billy", "audu", "adams", "semicolon,Yaba",
                "billyaudu@gmail.com", "09056790444");
        bankAccount = new BankAccount(1, 1000);
        bank.setCustomers(customer, bankAccount);
//        System.out.println(customer.toString() + bankAccount.toString());

        Customer customer2 = new Customer("bil", "aud", "adams", "semicolon,Yaba",
                "billyaudu@gmail.com", "09056790444");
        BankAccount bankAccount2 = new BankAccount(2, 1000);
        bank.setCustomers(customer2, bankAccount2);


//        assertEquals(customer,bank.getCustomers()[0]);
//        assertEquals(customer2, bank.getCustomers()[1]);
    }

    @Test
    void testThatTransactionsArePossible() {
        customer = new Customer("billy", "audu", "adams", "semicolon,Yaba",
                "billyaudu@gmail.com", "09056790444");
        bankAccount = new BankAccount(1, 1000);
        bank.setCustomers(customer, bankAccount);

        Customer customer2 = new Customer("bil", "aud", "adams", "semicolon,Yaba",
                "billyaudu@gmail.com", "09056790444");
        BankAccount bankAccount2 = new BankAccount(2, 1000);
        bank.setCustomers(customer2, bankAccount2);

//        System.out.println(bank.withdrawal(bankAccount,2000));
//        assertEquals(1000,bankAccount.getBalance());
//        System.out.println(bank.withdrawal(bankAccount,1000));
//        assertEquals(0,bankAccount.getBalance());
//
        System.out.println(bank.depositMoney(bankAccount2, -100));
        assertEquals(1000, bankAccount2.getBalance());
        // ToDO
//

    }
}