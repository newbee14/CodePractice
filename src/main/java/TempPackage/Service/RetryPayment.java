package TempPackage.Service;

import TempPackage.models.PaymentDetails;

public class RetryPayment {

    int RETRY_COUNT=5;
    public void initiateRetry(PaymentDetails paymentDetails){
        //check if Retry count is exceeded; => retryCanotDone()
        //retry initiated
        //convert paymentDetails to JSON and add retry key
        System.out.println("Retry Initiated");
    }
//    retryCannotDone(){
//
//    }
}
