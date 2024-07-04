package com.udemycpurse.accounts.DTO;


import com.udemycpurse.accounts.Entity.BaseEntity;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
public class AccountDTO  {

    @NotEmpty(message = "customer id can not be a null or empty")
    private Long customerId;
    @NotEmpty(message = "account number can not be a null or empty")
    private Long accountNumber;
    @NotEmpty(message = "account type can not be a null or empty")
    private String accountType;
    private String branchAddress;

}
