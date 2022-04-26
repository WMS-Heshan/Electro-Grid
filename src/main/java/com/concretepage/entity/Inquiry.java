package com.concretepage.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//Table Creation

@Entity
@Table(name = "inquiries")
public class Inquiry implements Serializable {
	private static final long serialVersionUID = 1L;
	//Create Column and Variables
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inquiry_id")
	private int inquiry_Id;
	@Column(name = "full_name")
	private String full_name;
	@Column(name = "phone_no")
	private String phone_no;
	@Column(name = "email")
	private String email;
	@Column(name = "address")
	private String address;
	@Column(name = "description")
	private String description;

	// Create Getters and Setters
	public int getInquiry_Id() {
		return inquiry_Id;
	}

	public void setInquiry_Id(int inquiry_Id) {
		this.inquiry_Id = inquiry_Id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}