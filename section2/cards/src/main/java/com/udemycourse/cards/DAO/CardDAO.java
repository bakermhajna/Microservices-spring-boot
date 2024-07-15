package com.udemycourse.cards.DAO;

import com.udemycourse.cards.Entity.Cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CardDAO extends JpaRepository<Cards,String> {

    Optional<Cards> findByMobileNumber(String mobileNumber);
}
