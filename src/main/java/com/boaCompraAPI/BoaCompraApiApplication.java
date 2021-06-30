package com.boaCompraAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stripe.Stripe;

@SpringBootApplication
public class BoaCompraApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoaCompraApiApplication.class, args);
	}

}
