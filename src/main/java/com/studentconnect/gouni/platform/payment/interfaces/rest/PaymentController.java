package com.studentconnect.gouni.platform.payment.interfaces.rest;

import com.studentconnect.gouni.platform.payment.domain.services.PaymentCommandService;
import com.studentconnect.gouni.platform.payment.domain.services.PaymentQueryService;
import com.studentconnect.gouni.platform.payment.interfaces.rest.resources.PaymentResource;
import com.studentconnect.gouni.platform.payment.interfaces.rest.resources.CreatePaymentResource;
import com.studentconnect.gouni.platform.payment.interfaces.rest.transform.PaymentResourceFromEntityAssembler;
import com.studentconnect.gouni.platform.payment.interfaces.rest.transform.CreatePaymentCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin(origins = "https://frontend-five-wheat-92.vercel.app") // Permitir solicitudes desde Angular
@RestController
@RequestMapping(value = "/api/v1/payments", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Payments", description = "Payments Management Endpoints")
public class PaymentController {

    private final PaymentCommandService paymentCommandService;
    private final PaymentQueryService paymentQueryService;

    public PaymentController(PaymentCommandService paymentCommandService, PaymentQueryService paymentQueryService) {
        this.paymentCommandService = paymentCommandService;
        this.paymentQueryService = paymentQueryService;
    }

    // Endpoint POST to create a payment
    @PostMapping
    public ResponseEntity<PaymentResource> createPayment(@RequestBody CreatePaymentResource resource) {
        var createPaymentCommand = CreatePaymentCommandFromResourceAssembler.toCommandFromResource(resource);
        var payment = paymentCommandService.handle(createPaymentCommand);
        var paymentResource = PaymentResourceFromEntityAssembler.toResourceFromEntity(payment);
        return new ResponseEntity<>(paymentResource, HttpStatus.CREATED);
    }

    // Endpoint GET to retrieve all payments
    @GetMapping
    public ResponseEntity<List<PaymentResource>> getAllPayments() {
        var payments = paymentQueryService.getAllPayments();
        var paymentResources = payments.stream()
                .map(PaymentResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(paymentResources);
    }
}
