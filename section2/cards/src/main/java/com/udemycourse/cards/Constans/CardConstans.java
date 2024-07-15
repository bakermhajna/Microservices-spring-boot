package com.udemycourse.cards.Constans;

public class CardConstans {

    private CardConstans() {
        // restrict instantiation
    }

    public static final String  VISA = "VISA";
    public static final String  MasterCard = "Master Card";
    public static final Long NEW_CARD_LIMIT = 1000L;

    public static final String  STATUS_201 = "201";
    public static final String  MESSAGE_201 = "Card created successfully";
    public static final String  STATUS_200 = "200";
    public static final String  MESSAGE_200 = "Request processed successfully";
    public static final String  STATUS_417 = "417";
    public static final String  MESSAGE_417_UPDATE= "Update operation failed. Please try again or contact Dev team";
    public static final String  MESSAGE_417_DELETE= "Delete operation failed. Please try again or contact Dev team";
}
