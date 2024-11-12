package com.studentconnect.gouni.platform.payment.domain.services;

import com.studentconnect.gouni.platform.payment.domain.Payment;
import java.util.List;

public interface PaymentQueryService {
    List<Payment> getAllPayments();
}
