package com.studentconnect.gouni.platform.payment.domain.comands;


import java.math.BigDecimal;

public class CreatePaymentCommand {
    private final String cardNumber;
    private final String cardHolderName;
    private final String expiryDate;
    private final String cvv;
    private final BigDecimal amount;

    public CreatePaymentCommand(String cardNumber, String cardHolderName, String expiryDate, String cvv, BigDecimal amount) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.amount = amount;
    }

    // Getters
    public String getCardNumber() { return cardNumber; }
    public String getCardHolderName() { return cardHolderName; }
    public String getExpiryDate() { return expiryDate; }
    public String getCvv() { return cvv; }
    public BigDecimal getAmount() { return amount; }
}
