package com.udemycourse.cards.Services;

import com.udemycourse.cards.DTO.CardDTO;

public interface ICardService {



    void createCard(String mobileNumber);

    CardDTO fetchCard(String CardId);

    boolean updateCard(CardDTO CardDTO);

    boolean deleteCard(String CardId);
}
