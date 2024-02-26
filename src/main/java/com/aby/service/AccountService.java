package com.aby.service;

import com.aby.model.Account;
import com.aby.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AccountService {

    @Autowired
    private AccountRepository personRepository;

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> searchAccounts(String ownerId, String number, String name) {
        // Implement search logic here, considering ownerId, number, and name filters
        if (number != null) {
            return getAccountByNumber(number);
        }
        if (name != null) {
            return getAccountByName(name);
        }
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(String id) {
        return accountRepository.findById(id);
    }

    public List<Account> getAccountByName(String name) {
        return accountRepository.findByName(name);
    }

    public List<Account> getAccountByNumber(String number) {
        return accountRepository.findByNumber(number);
    }

    public Account updateAccount(Account account) {
        Account updated = getAccountById(account.getId()).get();
        updated.setBalance(account.getBalance());
        updated.setNumber(account.getNumber());
        updated.setName(account.getName());


        return accountRepository.save(account);
    }

    public void deleteAccountById(String id) {
        accountRepository.deleteById(id);
    }

}