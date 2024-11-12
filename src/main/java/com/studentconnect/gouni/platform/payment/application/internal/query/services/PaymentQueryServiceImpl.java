package com.studentconnect.gouni.platform.payment.application.internal.query.services;

import com.studentconnect.gouni.platform.payment.domain.Payment;
import com.studentconnect.gouni.platform.payment.domain.services.PaymentQueryService;
import com.studentconnect.gouni.platform.payment.infraestructure.persistence.PaymentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaymentQueryServiceImpl implements PaymentQueryService {
    private final PaymentRepository paymentRepository;

    public PaymentQueryServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}
