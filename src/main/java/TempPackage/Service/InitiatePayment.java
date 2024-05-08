package TempPackage.Service;

import TempPackage.models.PaymentDetails;

public interface InitiatePayment {
    void preProcessor(PaymentDetails paymentDetails);
    boolean initiatePayment(PaymentDetails paymentDetails);
    void postProcessor(PaymentDetails paymentDetails);
}
