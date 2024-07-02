package com.udemycpurse.accounts.DAO;

import com.udemycpurse.accounts.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CustomerDAO extends JpaRepository<Customer,Long> {

    Optional<Customer> findBymobileNumber(String MobileNumber);

}

