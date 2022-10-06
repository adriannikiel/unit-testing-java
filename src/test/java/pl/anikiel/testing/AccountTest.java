package pl.anikiel.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void newAccountShouldNotBeActiveAfterCreation() {
        //given
        Account newAccount = new Account();

        //then
        assertFalse(newAccount.isActive(), "Check if new account is not active");
    }

    @Test
    public void accountShouldBeActiveAfterActivation() {
        //given
        Account newAccount = new Account();

        //when
        newAccount.activate();

        //then
        assertTrue(newAccount.isActive(), "'active' is set to true on activated account");
    }

    @Test
    void newlyCreatedAccountShouldNotHaveDefaultDeliveryAddressSet() {
        //given
        Account account = new Account();

        //when
        Address address = account.getDefaultDeliveryAddress();

        //then
        assertNull(address);
    }

    @Test
    void defaultDeliveryAddressShouldNotBeNullAfterSet() {
        //given
        Address address = new Address("Krakowska", "69c");
        Account account = new Account();
        account.setDefaultDeliveryAddress(address);

        //when
        Address defaultDeliveryAddress = account.getDefaultDeliveryAddress();

        //then
        assertNotNull(defaultDeliveryAddress);
    }
}