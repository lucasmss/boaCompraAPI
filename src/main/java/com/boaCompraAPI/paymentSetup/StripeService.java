//package com.boaCompraAPI.paymentSetup;
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import com.stripe.Stripe;
//
//@Service
//public class StripeService {
//
//    @Value("${STRIPE_SECRET_KEY}")
//    private String secretKey;
//    
//    @PostConstruct
//    public void init() {
//        Stripe.apiKey = secretKey;
//    }
//}