package com.udemycpurse.accounts.Service;

import com.udemycpurse.accounts.DTO.AccountDTO;
import com.udemycpurse.accounts.DTO.CustomerDTO;

public interface IAccountService {

    /**
     * @param coustomer
     */
    void createAccount(CustomerDTO coustomer);
    CustomerDTO fetchAccount(String mobileNumber);

}
