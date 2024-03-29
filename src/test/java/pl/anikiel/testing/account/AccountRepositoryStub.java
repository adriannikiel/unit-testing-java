package pl.anikiel.testing.account;

import java.util.List;

public class AccountRepositoryStub implements AccountRepository {
    @Override
    public List<Account> getAllAccounts() {
        Address address1 = new Address("Kwiatowa", "33/5");
        Account account1 = new Account(address1);

        Account account2 = new Account();
        Address address3 = new Address("Piekarska", "12b");
        Account account3 = new Account(address3);

        return List.of(account1, account2, account3);
    }

    @Override
    public List<String> getByName(String name) {
        return null;
    }
}
