package com.udemycpurse.accounts.DTO;
import com.udemycpurse.accounts.Entity.Accounts;
import com.udemycpurse.accounts.Entity.BaseEntity;
import lombok.*;
@Data
public class CustomerDTO extends BaseEntity {

    private Long customerId;
    private String name;
    private String email;
    private String mobileNumber;
    private Accounts accounts;
}
