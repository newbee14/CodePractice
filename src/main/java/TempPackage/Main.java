package TempPackage;


/*
User:
    Basic Details;
    PaymentOptions options



PaymentOptions:

    List<Interface Payment types>;



Interface Payment types:

Holders Name :
Number :
CVV:
Expiry:
Issuer Name:
Issuer Address:

Card implement Interface Payment types

Bank Account implement Interface Payment types
==========

Service

24hour
scheduler for check if any plan is due for payment => Kafka=> Consumer Group => Commit only at completion of my service

PaymentProcessing Part

Dead Letter Queue => Failed Event => retry Counter =5 => Cancel the plan
=========
PaymentProcessing Part

recievedEvent=> preProcessor

Interface PaymentProcessingSteps preProcessor(), Interface initiatePayment, postProcessor() (Send an email, db update)

Interface initiatePayment(Details)
CardPayment impl initiatePayment(Details)
BankPayment impl initiatePayment(Details)

 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Server Up");
    }
}
