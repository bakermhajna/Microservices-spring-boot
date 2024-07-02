package com.udemycpurse.accounts.DTO;


import com.udemycpurse.accounts.Entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
public class AccountDTO extends BaseEntity {

    private Long coustomerId;
    private Long accountNumber;
    private String accountType;
    private String branchAddress;

}
