package com.studentconnect.gouni.platform.payment.domain.services;


import com.studentconnect.gouni.platform.payment.domain.Payment;
import com.studentconnect.gouni.platform.payment.domain.comands.CreatePaymentCommand;

public interface PaymentCommandService {
    Payment handle(CreatePaymentCommand command);
}
