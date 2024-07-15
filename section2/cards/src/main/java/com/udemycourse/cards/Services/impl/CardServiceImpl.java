package com.udemycourse.cards.Services.impl;

import com.udemycourse.cards.Constans.CardConstans;
import com.udemycourse.cards.DAO.CardDAO;
import com.udemycourse.cards.DTO.CardDTO;
import com.udemycourse.cards.Entity.Cards;
import com.udemycourse.cards.Exceptions.CardAlreadyExistException;
import com.udemycourse.cards.Exceptions.RecourceNotFoundException;
import com.udemycourse.cards.Mapper.CardMapper;
import com.udemycourse.cards.Services.ICardService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardServiceImpl implements ICardService {

    @Autowired
    private CardDAO CardDao;

    @Override
    public void createCard(String mobileNumber)throws CardAlreadyExistException {
        Optional<Cards> findByCardId=CardDao.findByMobileNumber(mobileNumber);
        if(findByCardId.isPresent())throw new CardAlreadyExistException("Card Already Exist");
        Cards savedCard=CardDao.save(createNewCard(mobileNumber));
    }

    private Cards createNewCard(String mobileNumber) {
        Cards newCard = new Cards();
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setMobileNumber(mobileNumber);
        newCard.setCardType(CardConstans.MasterCard);
        newCard.setTotalLimit(CardConstans.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0L);
        newCard.setAvailableAmount(CardConstans.NEW_CARD_LIMIT);
        return newCard;
    }

    @Override
    public CardDTO fetchCard(String mobileNumber) {
       Cards card=CardDao.findByMobileNumber(mobileNumber).orElseThrow(()->new RecourceNotFoundException("Card ID not exist"));
       CardDTO cardDto=CardMapper.mapToCardDto(card,new CardDTO());
       return cardDto;
    }

    @Override
    public boolean updateCard(CardDTO cardDTO) {
        String cardID=cardDTO.getCardId();
        Cards card = CardDao.findById(cardID).orElseThrow(() -> new RecourceNotFoundException("Card ID not exist"));
        Cards newCard = CardMapper.mapToCard(cardDTO, card);
        Cards save = CardDao.save(newCard);
        return  true;

    }

    @Override
    public boolean deleteCard(String cardId) {
        CardDao.findByMobileNumber(cardId).orElseThrow(()->new RecourceNotFoundException("Card ID not exist"));
        CardDao.deleteById(cardId);
        return true;
    }
}
