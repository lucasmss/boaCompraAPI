package com.boaCompraAPI.DTO;

import java.time.LocalDateTime;

import com.boaCompraAPI.enums.EVALUATION;
import com.boaCompraAPI.products.Products;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ProductsDTO {

	private String productName;

	private Long productQuantity;
	
	private String description;
	
	private EVALUATION evaluation;
	
	private String photos;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime expirationDate;

	private Long negativeBalance;

	private int productCode;

	private String productCategory;

	private String productBrand;

	private boolean status;

	private String barCode;

	public ProductsDTO(Products products) {

		this.productName = products.getProductName();
		this.description = products.getDescription();
		this.evaluation = products.getEvaluation();
		this.photos = products.getPhotos();
		this.productQuantity = products.getProductQuantity();
		this.negativeBalance = products.getNegativeBalance();
		this.productCode = products.getProductCode();
		this.productCategory = products.getProductCategory();
		this.productBrand = products.getProductBrand();
		this.status = products.isStatus();
		this.barCode = products.getBarCode();
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EVALUATION getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(EVALUATION evaluation) {
		this.evaluation = evaluation;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public Long getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Long productQuantity) {
		this.productQuantity = productQuantity;
	}

	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Long getNegativeBalance() {
		return negativeBalance;
	}

	public void setNegativeBalance(Long negativeBalance) {
		this.negativeBalance = negativeBalance;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

}
