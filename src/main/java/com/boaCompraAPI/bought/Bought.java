package com.boaCompraAPI.bought;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.boaCompraAPI.enums.STATUSPAY;
import com.boaCompraAPI.payment.PaymentForm;
import com.boaCompraAPI.products.Products;
import com.sun.istack.NotNull;

@Entity
@Table(name = "TBL_BOUGHT")
public class Bought implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "status_payment", nullable = false)
	private STATUSPAY statusPay;
	
	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "paymentForm_id")
	private PaymentForm paymentForm;
	
	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "products_id")
	private Products products;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public STATUSPAY getStatusPay() {
		return statusPay;
	}

	public void setStatusPay(STATUSPAY statusPay) {
		this.statusPay = statusPay;
	}

	public PaymentForm getPaymentForm() {
		return paymentForm;
	}

	public void setPaymentForm(PaymentForm paymentForm) {
		this.paymentForm = paymentForm;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
