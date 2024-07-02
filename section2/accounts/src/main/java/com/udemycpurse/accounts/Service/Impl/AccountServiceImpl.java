package com.udemycpurse.accounts.Service.Impl;

import com.udemycpurse.accounts.Constants.AccountsConstants;
import com.udemycpurse.accounts.DAO.AccountDAO;
import com.udemycpurse.accounts.DAO.CustomerDAO;
import com.udemycpurse.accounts.DTO.AccountDTO;
import com.udemycpurse.accounts.DTO.CustomerDTO;
import com.udemycpurse.accounts.Entity.Accounts;
import com.udemycpurse.accounts.Entity.Customer;
import com.udemycpurse.accounts.Exceptions.CustomerAlreadyExistException;
import com.udemycpurse.accounts.Exceptions.RecourceNotFoundException;
import com.udemycpurse.accounts.Mapper.CoustomerMapper;
import com.udemycpurse.accounts.Service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;


@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService

{
    @Autowired
    private AccountDAO accountDAO;
    @Autowired
    private CustomerDAO customerDAO;

    /**
     * @param coustomerdto
     */
    @Override
    public void createAccount(CustomerDTO coustomerdto)throws CustomerAlreadyExistException{
        Optional<Customer> findbymobile=customerDAO.findBymobileNumber(coustomerdto.getMobileNumber());
        if(findbymobile.isPresent())throw new CustomerAlreadyExistException("customer already exist");
        Customer customer= CoustomerMapper.mapToCustomer(coustomerdto,new Customer());
        Customer savedCustomer=customerDAO.save(customer);
        Accounts savedAccount=accountDAO.save(createNewAccount(CoustomerMapper.mapToCustomerDto(savedCustomer,new CustomerDTO())));

    }

    @Override
    public CustomerDTO fetchAccount(String mobileNumber) {
        Customer customer= customerDAO.findBymobileNumber(mobileNumber).orElseThrow(()-> new RecourceNotFoundException("Customer","MobileNumber",mobileNumber));
        Accounts account= accountDAO.findBycustomerId(customer.getCustomerId()).orElseThrow(()-> new RecourceNotFoundException("Account","customer id",customer.getCustomerId().toString()));
        CustomerDTO customerdto=CoustomerMapper.mapToCustomerDto(customer,new CustomerDTO());
        customerdto.setAccounts(account);
        return customerdto;
    }

    private Accounts createNewAccount(CustomerDTO customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);
        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        return newAccount;
    }
}
