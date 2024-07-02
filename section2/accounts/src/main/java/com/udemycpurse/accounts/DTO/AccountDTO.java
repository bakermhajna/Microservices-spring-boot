package com.udemycpurse.accounts.DTO;


import com.udemycpurse.accounts.Entity.BaseEntity;
import lombok.*;

@Data
public class AccountDTO  {

    private Long customerId;
    private Long accountNumber;
    private String accountType;
    private String branchAddress;

}
