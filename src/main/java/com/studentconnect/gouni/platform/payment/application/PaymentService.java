package com.studentconnect.gouni.platform.payment.application;

import com.studentconnect.gouni.platform.payment.domain.Payment;
import com.studentconnect.gouni.platform.payment.domain.PaymentStatus;
import com.studentconnect.gouni.platform.payment.infraestructure.persistence.PaymentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Transactional
    public Payment processPayment(Payment payment) {
        // Simula la integración con una pasarela de pago
        payment.setStatus(PaymentStatus.COMPLETED);  // Usa el método setStatus

        // Guarda el pago y enmascara datos sensibles después de guardarlo
        Payment savedPayment = paymentRepository.save(payment);
        savedPayment.maskSensitiveData();
        return savedPayment;
    }

    public List<Payment> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        payments.forEach(Payment::maskSensitiveData);  // Enmascara datos en cada pago
        return payments;
    }
}
