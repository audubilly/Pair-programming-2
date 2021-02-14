package BankingApplication;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankingHallTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void customerCreation() {
     Customer customer =   BankingHall.customerCreation("Onyie","agbo","eliza","benue",
                "madam@yahoo.com","080123455");
        assertNotNull(customer);
    }

    @Test
    void bankAccount() {
        BankAccount bankAccount= BankingHall.bankAccount("Savings",200);
        assertNotNull(bankAccount);
    }
}