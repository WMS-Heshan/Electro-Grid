package com.concretepage.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bills")

public class Bill implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bill_id")
	private int billId;

	@Column(name = "bill_no")
	private String billno;

	@Column(name = "cust_id")
	private String custid;

	@Column(name = "unit_type")
	private int unittype;

	@Column(name = "no_units")
	private int nounits;

	@Column(name = "month")
	private String month;

	@Column(name = "costPer_month")
	private float costPer_month;

	@Column(name = "sub_total")
	private float sub_total;

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public String getBillno() {
		return billno;
	}

	public void setBillno(String billno) {
		this.billno = billno;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public int getUnittype() {
		return unittype;
	}

	public void setUnittype(int unittype) {
		this.unittype = unittype;
	}

	public int getNounits() {
		return nounits;
	}

	public void setNounits(int nounits) {
		this.nounits = nounits;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public float getCostPer_month() {
		return costPer_month;
	}

	public void setCostPer_month(float costPer_month) {
		
		this.costPer_month = costPer_month;
	}

	public float getSub_total() {
		if (unittype == 1) {
			unittype = 50;
		} else if (unittype == 2) {
			unittype = 100;
		}
		sub_total = nounits * unittype;
		return sub_total;
	}

	public void setSub_total(float sub_total) {
		this.sub_total = sub_total;
	}

}
