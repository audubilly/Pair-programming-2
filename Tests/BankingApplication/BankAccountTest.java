package BankingApplication;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    BankAccount bankAccount;
    BankAccount bankAccount2;
    BankAccount bankAccount3;
    @BeforeEach
    void setUp() {

        bankAccount = new BankAccount();
        bankAccount2= new BankAccount("SAVINGS");
        bankAccount3 = new BankAccount("Savings","111");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testThatAllGettersAndSettersAreWorking(){
        bankAccount.setDepositMoney(100);
        assertEquals(100, bankAccount.getDepositMoney());
        bankAccount.getWithdrawMoney();
        bankAccount3.setWithdrawMoney(22);
        bankAccount3.getDepositMoney();
        bankAccount3.setWithdrawMoney(22);
        bankAccount3.getBalance();
        bankAccount3.getAccountTypes();
        System.out.println(bankAccount.toString());

        bankAccount.setWithdrawMoney(1000);
        assertEquals(1000, bankAccount.getWithdrawMoney());
        bankAccount.setWithdrawMoney(100);
        assertEquals(100, bankAccount.getWithdrawMoney());

        assertEquals(0,bankAccount.getBalance());

        bankAccount.setAccountTypes("savings");
        assertEquals(AccountTypes.SAVINGS, bankAccount.getAccountTypes());

    }
    @Test
    void testThatToStringMethodWorks(){
        bankAccount.setAccountTypes("Current");
        bankAccount.setDepositMoney(200);
        bankAccount.setDepositMoney(-200);
        System.out.println(bankAccount.toString());
    }

    @Test
    void testThatBankAccountTypesCanBeGotten(){
       BankAccount bankAccount1 = new BankAccount("Savings");
       assertEquals(AccountTypes.SAVINGS, bankAccount1.getAccountTypes());
        System.out.println(bankAccount1.getAccountId());


        BankAccount bankAccount2 = new BankAccount("Current");
        assertEquals(AccountTypes.CURRENT, bankAccount2.getAccountTypes());
        System.out.println(bankAccount2.getAccountId());


        BankAccount bankAccount3 = new BankAccount("Savings", 1000);
        assertEquals(AccountTypes.SAVINGS, bankAccount3.getAccountTypes());
        System.out.println(bankAccount3.toString());


    }
}