package com.udemycpurse.accounts.DAO;


import com.udemycpurse.accounts.Entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountDAO extends JpaRepository<Accounts,Long> {

    Optional<Accounts> findBycustomerId(Long customerId);
}
