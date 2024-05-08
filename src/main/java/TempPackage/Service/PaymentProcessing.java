package TempPackage.Service;

import TempPackage.models.PaymentDetails;

public class PaymentProcessing implements InitiatePayment{


    @Override
    public void preProcessor(PaymentDetails paymentDetails) {
        //Task Status Update
        initiatePayment(paymentDetails);
    }

    @Override
    public boolean initiatePayment(PaymentDetails paymentDetails) {
        System.out.println("Payment initiated");
        if(!validationCheck(paymentDetails)) paymentRejected(paymentDetails);
        try {
            paymentGatewayProcessing(paymentDetails);
            postProcessor(paymentDetails);
            return true;
        }
        catch (Exception e){
            //Handle Retry
            RetryPayment retryPayment= new RetryPayment();
            retryPayment.initiateRetry(paymentDetails);
        }
        System.out.println("Payment Completed");
        return false;
    }

    @Override
    public void postProcessor(PaymentDetails paymentDetails) {
        //initiate alert
        //update DB
    }

    void paymentRejected(PaymentDetails paymentDetails){
        //update DB
        //some ops
    }


    public boolean paymentGatewayProcessing(PaymentDetails paymentDetails){
        try {
            System.out.println("Payment Gateway op done");
        }
        catch (Exception e){
            //logging
            //throw exception
        }
        return true;
    }

    private boolean validationCheck(PaymentDetails paymentDetails){
        //Basic validation
        return true;

    }
}
