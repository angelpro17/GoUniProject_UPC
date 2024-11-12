package com.studentconnect.gouni.platform.payment.interfaces.rest.transform;


import com.studentconnect.gouni.platform.payment.domain.comands.CreatePaymentCommand;
import com.studentconnect.gouni.platform.payment.interfaces.rest.resources.CreatePaymentResource;

public class CreatePaymentCommandFromResourceAssembler {
    public static CreatePaymentCommand toCommandFromResource(CreatePaymentResource resource) {
        return new CreatePaymentCommand(
                resource.getCardNumber(),
                resource.getCardHolderName(),
                resource.getExpiryDate(),
                resource.getCvv(),
                resource.getAmount()
        );
    }
}
