package com.studentconnect.gouni.platform.payment.interfaces.rest.dto;

import com.studentconnect.gouni.platform.payment.domain.Payment;
import com.studentconnect.gouni.platform.payment.domain.PaymentStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentResponseDTO {

    private Long id;
    private String maskedCardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String maskedCvv;
    private BigDecimal amount;
    private PaymentStatus status;
    private LocalDateTime createdAt;

    public static PaymentResponseDTO fromPayment(Payment payment) {
        PaymentResponseDTO dto = new PaymentResponseDTO();
        dto.id = payment.getId();
        dto.maskedCardNumber = payment.getMaskedCardNumber();
        dto.cardHolderName = payment.getCardHolderName();
        dto.expiryDate = payment.getExpiryDate();
        dto.maskedCvv = payment.getMaskedCvv();
        dto.amount = payment.getAmount();
        dto.status = payment.getStatus();
        dto.createdAt = payment.getCreatedAt();
        return dto;
    }
}
