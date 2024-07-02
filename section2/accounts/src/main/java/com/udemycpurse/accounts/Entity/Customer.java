package com.udemycpurse.accounts.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter@Setter@AllArgsConstructor@NoArgsConstructor@ToString

public class Customer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coustomerId;
    private String name;
    private String email;
    private String mobileNumber;

}
