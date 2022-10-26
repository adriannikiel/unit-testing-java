package pl.anikiel.testing.account;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AccountServiceTest {

    @Test
    void getAllActiveAccounts() {
        //given
        AccountRepository accountRepository = new AccountRepositoryStub();
        AccountService accountService = new AccountService(accountRepository);

        //when
        List<Account> accountList = accountService.getAllActiveAccounts();

        //then
        assertThat(accountList).hasSize(2);
    }
}