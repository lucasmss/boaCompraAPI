package com.boaCompraAPI.enums;

public enum EVALUATION {
	
	BAIXO("0", "baixo"),
	REGULAR("1", "regular"),
	MEDIO("2", "medio"),
	URGENTE("3", "urgente");
	
	private String code;
	private String evaluation;
	private EVALUATION(String code, String evaluation) {
		this.code = code;
		this.evaluation = evaluation;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}
}
