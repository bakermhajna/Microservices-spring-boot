package com.udemycourse.cards.Mapper;

import com.udemycourse.cards.DTO.CardDTO;
import com.udemycourse.cards.Entity.Cards;

public class CardMapper {



    public static CardDTO mapToCardDto(Cards card, CardDTO cardDTO){
        cardDTO.setCardId(card.getCardId());
        cardDTO.setCardNumber(card.getCardNumber());
        cardDTO.setCardType(card.getCardType());
        cardDTO.setAmountUsed(card.getAmountUsed());
        cardDTO.setMobileNumber(card.getMobileNumber());
        cardDTO.setAvailableAmount(card.getAvailableAmount());
        cardDTO.setTotalLimit(card.getTotalLimit());
        return cardDTO;
    }


    public static Cards mapToCard(CardDTO cardDTO , Cards card){
        card.setCardId(cardDTO.getCardId());
        card.setCardNumber(cardDTO.getCardNumber());
        card.setCardType(cardDTO.getCardType());
        card.setMobileNumber(cardDTO.getMobileNumber());
        card.setAvailableAmount(cardDTO.getAvailableAmount());
        card.setAmountUsed(cardDTO.getAmountUsed());
        card.setTotalLimit(cardDTO.getTotalLimit());
        return card;
    }

}
