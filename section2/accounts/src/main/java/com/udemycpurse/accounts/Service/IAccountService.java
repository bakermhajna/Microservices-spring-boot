package com.udemycpurse.accounts.Service;

import com.udemycpurse.accounts.DTO.CustomerDTO;

public interface IAccountService {

    /**
     * @param coustomer
     */
    void createAccount(CustomerDTO coustomer);

    /**
     * @param mobileNumber
     * @return
     */
    CustomerDTO fetchAccount(String mobileNumber);

    /**
     * @param customerDTO
     * @return
     */
    boolean updateAccount(CustomerDTO customerDTO);

    /**
     * @param mobileNumber
     * @return
     */
    boolean deleteAccount(String mobileNumber);
}
