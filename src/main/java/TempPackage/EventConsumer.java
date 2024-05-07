package TempPackage;

import TempPackage.Service.PaymentProcessing;
import TempPackage.models.PaymentDetails;

public class EventConsumer {


    public void consumePaymentEvent(Object obj){
        PaymentProcessing paymentProcessing= new PaymentProcessing();
        paymentProcessing.preProcessor((PaymentDetails) obj);

    }

    public void consumeRetryEvent(){
        PaymentProcessing paymentProcessing= new PaymentProcessing();
    }
}
