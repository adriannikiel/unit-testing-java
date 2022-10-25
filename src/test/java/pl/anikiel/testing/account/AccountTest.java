package pl.anikiel.testing.account;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class AccountTest {

    @Test
    public void newAccountShouldNotBeActiveAfterCreation() {
        //given
        Account newAccount = new Account();

        //then
        assertFalse(newAccount.isActive(), "Check if new account is not active");

        assertThat(newAccount.isActive()).isFalse();
    }

    @Test
    public void accountShouldBeActiveAfterActivation() {
        //given
        Account newAccount = new Account();

        //when
        newAccount.activate();

        //then
        assertTrue(newAccount.isActive(), "'active' is set to true on activated account");

        assertThat(newAccount.isActive()).isTrue();
    }

    @Test
    void newlyCreatedAccountShouldNotHaveDefaultDeliveryAddressSet() {
        //given
        Account account = new Account();

        //when
        Address address = account.getDefaultDeliveryAddress();

        //then
        assertNull(address);

        assertThat(address).isNull();
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

        assertThat(defaultDeliveryAddress).isNotNull();
    }

    @RepeatedTest(5)
    void newAccountWithNotNullAddressShouldBeActive() {
        //given
        Address address = new Address("Puławska", "46/6");

        //when
        Account account = new Account(address);

        //then
        assumingThat(address != null, () -> {
            assertTrue(account.isActive());
        });
    }

    @Test
    void invalidEmailShouldThrowException() {
        //given
        Account account = new Account();

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> account.setEmail("wrongEmail"));
    }

    @Test
    void validEmailShouldBeSet() {
        //given
        Account account = new Account();

        //when
        account.setEmail("adrian@anikiel.pl");

        //then
        assertThat(account.getEmail()).isEqualTo("adrian@anikiel.pl");
    }
}