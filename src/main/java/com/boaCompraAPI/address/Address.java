package com.boaCompraAPI.address;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_ADDRESS")
public class Address implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "CEP", nullable = false)
	private String cep;

	@Column(name = "LOGRADOURO", nullable = false)
	private String logradouro;

	@Column(name = "COMPLEMENTO", nullable = false)
	private String complemento;

	@Column(name = "BAIRRO", nullable = false)
	private String bairro;

	@Column(name = "UF", nullable = false)
	private String uf;
	
	@Column(name = "DESCRICAO_ENDERECO", nullable = false)
	private String descricao_address;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDescricao_address() {
		return descricao_address;
	}

	public void setDescricao_address(String descricao_address) {
		this.descricao_address = descricao_address;
	}
}
