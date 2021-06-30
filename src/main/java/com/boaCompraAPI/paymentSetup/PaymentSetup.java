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
import com.stripe.model.checkout.Session;
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
	    ResponseEntity<Object> createSession(String email, String token) throws StripeException {
		  Stripe.apiKey = secretKey;
	    	SessionCreateParams params =
	    		        SessionCreateParams.builder()
	    		          .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
	    		          .setMode(SessionCreateParams.Mode.PAYMENT)
	    		          .setSuccessUrl("https://example.com/success")
	    		          .setCancelUrl("https://example.com/cancel")
	    		          .addLineItem(
	    		          SessionCreateParams.LineItem.builder()
	    		            .setQuantity(1L)
	    		            .setPriceData(
	    		              SessionCreateParams.LineItem.PriceData.builder()
	    		                .setCurrency("brl")
	    		                .setUnitAmount(20l)
	    		                .setProductData(
	    		                  SessionCreateParams.LineItem.PriceData.ProductData.builder()
	    		                    .setName("T-shirt")
	    		                    .build())
	    		                .build())
	    		            .build())
	    		          .build();

	    		      Session session = Session.create(params);

	    		      Map<String, String> responseData = new HashMap();
	    		      responseData.put("id", session.getId());
	        return ResponseEntity.ok().body(responseData);
	    }

}
