package BankingApplication;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    BankAccount bankAccount;
    @BeforeEach
    void setUp() {

        bankAccount = new BankAccount();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testThatAllGettersAndSettersAreWorking(){
        bankAccount.setDepositMoney(100);
        assertEquals(100, bankAccount.getDepositMoney());

        bankAccount.setWithdrawMoney(100);
        assertEquals(100, bankAccount.getWithdrawMoney());

        assertEquals(0,bankAccount.getBalance());

        bankAccount.setAccountTypes(1);
        assertEquals("Savings", bankAccount.getAccountTypes());

    }
    @Test
    void testThatToStringMethodWorks(){
        bankAccount.setAccountTypes(2);
        bankAccount.setDepositMoney(200);
        System.out.println(bankAccount.toString());
    }

    @Test
    void testThatBnkAccountTypesCanBeGotten(){
       BankAccount bankAccount1 = new BankAccount(1);
       assertEquals("Savings", bankAccount1.getAccountTypes());
        System.out.println(bankAccount1.getAccountNumber());


        BankAccount bankAccount2 = new BankAccount(2);
        assertEquals("Current", bankAccount2.getAccountTypes());
        System.out.println(bankAccount2.getAccountNumber());


        BankAccount bankAccount3 = new BankAccount(2, 1000);
        assertEquals("Current", bankAccount3.getAccountTypes());
        System.out.println(bankAccount3.toString());


    }
}