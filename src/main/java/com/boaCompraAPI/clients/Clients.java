package com.boaCompraAPI.clients;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.boaCompraAPI.enums.GENDER;

@Entity
@Table(name = "TBL_CLIENTS")
public class Clients implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "BIRTH", nullable = false)
	private String birth;

	@Column(name = "CPF", nullable = false, unique = true)
	private String cpf;

	@Column(name = "GENDER", nullable = false)
	private GENDER gender;

	@Email
	@Column(name = "EMAIL", nullable = false)
	private String email;

	@Column(name = "TELPHONE")
	private String telphone;

	@Column(name = "CELL")
	private String cell;
	
	@Column(name = "DATA_USE_TERM", nullable = false)
	private boolean date_use_term;
	
	@Column(name = "SENDIG_EMAIL_TERM", nullable = false)
	private boolean sending_email_term;
	
	@Column(name = "ADMIN_PERMISSION")
	private boolean admin_permission;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public GENDER getGender() {
		return gender;
	}

	public void setGender(GENDER gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public boolean isDate_use_term() {
		return date_use_term;
	}

	public void setDate_use_term(boolean date_use_term) {
		this.date_use_term = date_use_term;
	}

	public boolean isSending_email_term() {
		return sending_email_term;
	}

	public void setSending_email_term(boolean sending_email_term) {
		this.sending_email_term = sending_email_term;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isAdmin_permission() {
		return admin_permission;
	}

	public void setAdmin_permission(boolean admin_permission) {
		this.admin_permission = admin_permission;
	}
}
