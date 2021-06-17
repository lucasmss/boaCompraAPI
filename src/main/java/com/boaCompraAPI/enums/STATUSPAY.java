package com.boaCompraAPI.enums;

public enum STATUSPAY {
	
	ANALISE("0", "analise"),
	APROVADO("1", "aprovado"),
	NEGADO("2", "negado"),
	
	private String code;
	private String statusPay;
	
	private STATUSPAY(String code, String statusPay) {
		this.code = code;
		this.statusPay = statusPay;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getStatusPay() {
		return statusPay;
	}
	public void setStatusPay(String statusPay) {
		this.statusPay = statusPay;
	}

}
