package com.udemycourse.cards.DTO;


import lombok.Data;

@Data
public class CardDTO {

    private String cardId;
    private String mobileNumber;
    private String cardNumber;
    private String cardType;
    private Long totalLimit;
    private Long amountUsed;
    private Long availableAmount;
}
