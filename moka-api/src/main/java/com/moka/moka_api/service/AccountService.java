package com.moka.moka_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.moka.moka_api.model.Account;
import com.moka.moka_api.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service

@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public List<Account> getAccountsByUser(String userId) {
        return accountRepository.findByUserId(userId);
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public void deleteAccount(String id) {
        accountRepository.deleteById(id);
    }
}
