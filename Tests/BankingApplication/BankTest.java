package BankingApplication;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    Bank bank;
    Customer customer;
    BankAccount bankAccount;
    BankAccount bankAccount2;
    Customer []customer2= new Customer[2];
    Bank bank2;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        bank2= new Bank(customer2);
        bankAccount2=new BankAccount();

    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void testThatABankCanHaveCustomerOrCustomers(){
        customer = new Customer("billy1","audu","adams","semicolon,Yaba",
                "billyaudu@gmail.com","09056790444" );
        bankAccount = new BankAccount("Current",1000);

        Customer customer2 = new Customer("bil1","aud","adams","semicolon,Yaba",
                "billyaudu@gmail.com","09056790444" );
        BankAccount bankAccount2 = new BankAccount("Savings",1000);

        bank.registerCustomers(customer,bankAccount);
        bank.registerCustomers(customer2,bankAccount2);
        System.out.println(bank.getCustomerAccountAndDetails("current",
                bankAccount.getAccountId().toString()));
        System.out.println(bank.getCustomerAccountAndDetails("savings",
                bankAccount2.getAccountId().toString()));
        System.out.println(bank.getCustomerAccountAndDetails("current",bankAccount2.getAccountId().toString()));
        assertEquals(customer,bank.getCustomers()[0]);


    }

    @Test
    void testThatACustomerIsNotAssignedTheSameTypeOfAccountTwice(){
        customer = new Customer("billy2","audu","adams","semicolon,Yaba",
                "billyaudu@gmail.com","09056790444" );
        bankAccount = new BankAccount("Current",1000);
        bank.registerCustomers(customer,bankAccount);
        System.out.println(bank.getCustomerAccountAndDetails("Current",bankAccount.getAccountId().toString()));
        Customer customer2 = new Customer("billy2","audu","adams","semicolon,Yaba",
                "billyauduz@gmail.com","09056790434" );
        bankAccount2 = new BankAccount("Current",1000);
        bank.registerCustomers(customer2,bankAccount2);
        System.out.println(bank.getCustomerAccountAndDetails("Current",bankAccount2.getAccountId().toString()));
        Customer customer3 = new Customer("billy2","audu","adams","semicolon,Yaba",
                "billyauduz@gmail.com","09056790434" );
       BankAccount bankAccount3 = new BankAccount("Current",1000);
        bank.registerCustomers(customer3,bankAccount3);


 }

    @Test
    void testThatTwoCustomersAreNotAssignedTheSameAccountNumber(){
        customer = new Customer("billy3","audu","adams","semicolon,Yaba",
                "billyaudu@gmail.com","09056790444" );
        bankAccount = new BankAccount("Savings",1000);
        bank.registerCustomers(customer, bankAccount);
//        System.out.println(customer.toString() + bankAccount.toString());

      Customer customer2 = new Customer("bil3","aud","adams","semicolon,Yaba",
                "billyaudus@gmail.com","09056790443" );
       BankAccount bankAccount2 = new BankAccount("Current",1000);
        bank.registerCustomers(customer2,bankAccount2);



        assertEquals(customer,bank.getCustomers()[0]);
        assertEquals(customer2, bank.getCustomers()[1]);
    }

    @Test
    void testForPasswordsCanBeSetToAnAccount(){
        customer = new Customer("billy3","audu","adams","semicolon,Yaba",
                "billyaudu@gmail.com","09056790444" );
        bankAccount = new BankAccount("Savings",1000);
        bank.registerCustomers(customer, bankAccount);
        System.out.println(bankAccount.getAccountId().toString());
        System.out.println( bank.setCustomerPassword(bankAccount.getAccountId().toString(),"12345"));


    }
    @Test
    void testThaBasicTransactionsArePossible(){
        Customer billy = new Customer("billy4","audu","adams","semicolon,Yaba",
                "billyaudu@gmail.com","09056790444" );
        bankAccount = new BankAccount("Savings",1000);
        bank.registerCustomers(billy,bankAccount);
        bank.setCustomerPassword(bankAccount.getAccountId().toString(),"12345");


        Customer titi = new Customer("Titi4","titus","agba-agba","semi-colon","titi@semi-colon","1234");
        BankAccount bankAccount2 = new BankAccount("Current",2000);
        bank.registerCustomers(titi,bankAccount2);


        bank.depositMoney(bankAccount.getAccountId().toString(),2000);
        assertEquals(3000,bankAccount.getBalance());


        System.out.println( bank.withdrawal(bankAccount.getAccountId().toString(),200,"12345"));
        assertEquals(2800,bankAccount.getBalance());


        System.out.println( bank.transfer(bankAccount.getAccountId().toString(),bankAccount2.getAccountId().toString(),800,"12345"));
        assertEquals(2000,bankAccount.getBalance());



    }
}