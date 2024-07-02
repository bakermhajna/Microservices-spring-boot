package com.udemycpurse.accounts.Mapper;

import com.udemycpurse.accounts.DTO.AccountDTO;
import com.udemycpurse.accounts.Entity.Accounts;

public class AccountMapper {

    public static AccountDTO mapToAccountsDto(Accounts account, AccountDTO accountsDto) {
        accountsDto.setCustomerId(account.getCustomerId());
        accountsDto.setAccountNumber(account.getAccountNumber());
        accountsDto.setAccountType(account.getAccountType());
        accountsDto.setBranchAddress(account.getBranchAddress());
        return accountsDto;
    }

    public static Accounts mapToAccounts(AccountDTO accountsDto, Accounts account) {
        account.setAccountNumber(accountsDto.getAccountNumber());
        account.setAccountType(accountsDto.getAccountType());
        account.setBranchAddress(accountsDto.getBranchAddress());
        return account;
    }
}
