package com.boaCompraAPI.paymentSetup;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.PaymentIntent;
import com.stripe.model.checkout.Session;
import com.stripe.net.RequestOptions;
import com.stripe.param.ChargeRetrieveParams;
import com.stripe.param.PaymentIntentCreateParams;
import com.stripe.param.checkout.SessionCreateParams;

import io.swagger.annotations.Api;

@RestController
@Validated
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1")
@Api(tags = { "PaymentSetup" })
public class PaymentSetup {
	
	@Value("sk_test_51J7LpXF1zbo7ZPCRSQBKPEEvUeZNQfB5agS5pEVYDguGSqaylTSObiCkeKh2mLmEsL9WrHF5vMNk9BPCjBryzeCM00SvHY80ih")
    private String secretKey;
    
    private static void init() {
		Stripe.apiKey = "Your_secret_key";
	}
    
   
	  @PostMapping("/paymentSetup")
	    public @ResponseBody
	    ResponseEntity<Object> createPayment(String email, String token) throws StripeException {
		  Stripe.apiKey = secretKey;
		PaymentIntentCreateParams createParams = new PaymentIntentCreateParams.Builder()
				.setCurrency("brl")
				.setAmount(15 * 100l)
				.build();
				
	    		PaymentIntent intent = PaymentIntent.create(createParams);      
	        return ResponseEntity.ok().body(intent);
	    }
}
