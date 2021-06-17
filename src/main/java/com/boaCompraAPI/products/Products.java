package com.boaCompraAPI.products;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.boaCompraAPI.enums.EVALUATION;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "TBL_PRODUCTS")
public class Products implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "PRODUCTNAME")
	private String productName;

	@Column(name = "PRODUCTQUANTITY")
	private Long productQuantity;

	@Column(name = "NEGATIVEBALANCE")
	private Long negativeBalance;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "PRODUCT_EVALUATION", nullable = false)
	private EVALUATION evaluation;

	@Column(name = "PRODUCTPRICE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "0,00")
	private BigDecimal productPrice;

	@Column(name = "PRODUCTCODE", nullable = false)
	private int productCode;

	@Column(name = "PRODUCTDISCOUNT")
	private Long productDiscount;

	@Column(name = "MINSTOCK", nullable = false)
	private Long minStock;

	@Column(name = "MAXSTOCK")
	private Long maxStock;

	@Column(name = "MANUFACTURINEXPENSES")
	@Digits(integer = 3, fraction = 2)
	@DecimalMin(value = "0,00", inclusive = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "0,00")
	private BigDecimal manufacturingExpenses;

	@Column(name = "PRODUCTPROFITPERCENT")
	private BigDecimal productProfitPercent;

	@Column(name = "PRODUCTPROFITREAIS")
	@Digits(integer = 3, fraction = 2)
	@DecimalMin(value = "0,00", inclusive = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "0,00")
	private BigDecimal productProfitReais;

	@Column(name = "PRODUCTCATEGORY")
	private String productCategory;

	@Column(name = "PRODUCTCBRAND")
	private String productBrand;

	@Column(name = "UNITOFMEASUREMENT")
	private String unitOfMeasurement;

	@Column(name = "STATUS")
	private boolean status;

	@Column(name = "BARCODE")
	private String BarCode;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@Column(name = "PRODUCTRECEPTDATE")
	private LocalDateTime productReceiptDate;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@Column(name = "EXPIRATIONDATE")
	private LocalDateTime expirationDate;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@CreationTimestamp
	@Column(name = "CREATEDATE")
	private LocalDateTime created;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@UpdateTimestamp
	@Column(name = "UPDATEDATE")
	private LocalDateTime updated;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Long productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Long getNegativeBalance() {
		return negativeBalance;
	}

	public void setNegativeBalance(Long negativeBalance) {
		this.negativeBalance = negativeBalance;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EVALUATION getService() {
		return evaluation;
	}

	public void setService(EVALUATION evaluation) {
		this.evaluation = evaluation;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public Long getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(Long productDiscount) {
		this.productDiscount = productDiscount;
	}

	public Long getMinStock() {
		return minStock;
	}

	public void setMinStock(Long minStock) {
		this.minStock = minStock;
	}

	public Long getMaxStock() {
		return maxStock;
	}

	public void setMaxStock(Long maxStock) {
		this.maxStock = maxStock;
	}

	public BigDecimal getManufacturingExpenses() {
		return manufacturingExpenses;
	}

	public void setManufacturingExpenses(BigDecimal manufacturingExpenses) {
		this.manufacturingExpenses = manufacturingExpenses;
	}

	public BigDecimal getProductProfitPercent() {
		return productProfitPercent;
	}

	public void setProductProfitPercent(BigDecimal productProfitPercent) {
		this.productProfitPercent = productProfitPercent;
	}

	public BigDecimal getProductProfitReais() {
		return productProfitReais;
	}

	public void setProductProfitReais(BigDecimal productProfitReais) {
		this.productProfitReais = productProfitReais;
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

	public String getUnitOfMeasurement() {
		return unitOfMeasurement;
	}

	public void setUnitOfMeasurement(String unitOfMeasurement) {
		this.unitOfMeasurement = unitOfMeasurement;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getBarCode() {
		return BarCode;
	}

	public void setBarCode(String barCode) {
		BarCode = barCode;
	}

	public LocalDateTime getProductReceiptDate() {
		return productReceiptDate;
	}

	public void setProductReceiptDate(LocalDateTime productReceiptDate) {
		this.productReceiptDate = productReceiptDate;
	}

	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}