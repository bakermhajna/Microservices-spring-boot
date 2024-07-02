package com.udemycpurse.accounts.DTO;
import com.udemycpurse.accounts.Entity.BaseEntity;
import lombok.*;
@Data
public class CustomerDTO extends BaseEntity {

    private Long coustomerId;
    private String name;
    private String email;
    private String mobileNumber;

}
