package BankingApplication;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void testThatABankCanHaveCustomers(){
        customer = new Customer("billy","audu","adams","semicolon,Yaba",
                "billyaudu@gmail.com","09056790444" );
        bank.setCustomers(customer,bankAccount);
        assertEquals(customer,bank.getCustomers()[0]);
    }

    @Test
    void testThatTwoCustomersAreNotAssignedTheSameSpot(){
        customer = new Customer("billy","audu","adams","semicolon,Yaba",
                "billyaudu@gmail.com","09056790444" );
        bankAccount = new BankAccount(1,1000);
        bank.setCustomers(customer, bankAccount);
        System.out.println(customer.toString() + bankAccount.toString());

//      Customer customer2 = new Customer("bil","aud","adams","semicolon,Yaba",
//                "billyaudu@gmail.com","09056790444" );
//        bank.setCustomers(customer2);
//
//        assertEquals(customer,bank.getCustomers()[0]);
//        assertEquals(customer2, bank.getCustomers()[1]);
    }
}