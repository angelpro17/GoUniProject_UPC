package com.studentconnect.gouni.platform.payment.infraestructure.persistence;

import com.studentconnect.gouni.platform.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}

