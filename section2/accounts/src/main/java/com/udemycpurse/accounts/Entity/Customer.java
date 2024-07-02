package com.udemycpurse.accounts.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter@Setter@AllArgsConstructor@NoArgsConstructor@ToString

public class Customer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String name;

    private String email;

    private String mobileNumber;

}
