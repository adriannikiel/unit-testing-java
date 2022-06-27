package pl.anikiel.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void myTest() {
        Account newAccount = new Account();

        assertFalse(newAccount.isActive(), "Check if new account is not active");
    }
}