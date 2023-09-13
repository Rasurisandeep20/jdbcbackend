package com.dnb.jdbcdemo2.service;
import java.util.List;
import java.util.Optional;

import com.dnb.jdbcdemo2.dto.Account;
import com.dnb.jdbcdemo2.exception.IdNotFoundException;

public interface AccountService {

	public Account createAccount(Account account);

	public Optional<Account> getAccountById(String accountId);

	public Iterable<Account> getAllAccounts();

	public boolean deleteAccountByID(String accountId) throws IdNotFoundException;
}