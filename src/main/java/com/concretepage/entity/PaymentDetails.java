package com.concretepage.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paymentdetails")
public class PaymentDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "payment_id")
	private int paymentId;
	@Column(name = "fullname")
	private String fullname;
	@Column(name = "email")
	private String email;
	@Column(name = "mobile")
	private String mobile;
	@Column(name = "adderss")
	private String adderss;
	@Column(name = "zipcode")
	private String zipcode;
	@Column(name = "paymenttype")
	private String paymenttype;
	@Column(name = "Date")
	private String Date;
	@Column(name = "amount")
	private String amount;
	
	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAdderss() {
		return adderss;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getPaymenttype() {
		return paymenttype;
	}

	public String getDate() {
		return Date;
	}

	public void setAdderss(String adderss) {
		this.adderss = adderss;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}

	public void setDate(String date) {
		Date = date;
	}
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
}