package com.concretepage.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="connections")
public class Connection implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="connection_id")
    private int connectionId;  
	@Column(name="connection_type")	
	private String connectionType;
	@Column (name="connection_name")
	private String connectionName;
	@Column(name="connection_desc")
	private String connectionDesc;
	@Column(name="connection_date")
	private String connectionDate;
	@Column (name="connection_price")
	private int connectionPrice;
	
	
	public int getConnectionId() {
		return connectionId;
	}
	public void setConnectionId(int connectionId) {
		this.connectionId = connectionId;
	}
	public String getConnectionType() {
		return connectionType;
	}
	public void setConnectionType(String connectionType) {
		this.connectionType = connectionType;
	}
	public String getConnectionName() {
		return connectionName;
	}
	public void setConnectionName(String connectionName) {
		this.connectionName = connectionName;
	}
	public String getConnectionDesc() {
		return connectionDesc;
	}
	public void setConnectionDesc(String connectionDesc) {
		this.connectionDesc = connectionDesc;
	}

	public String getConnectionDate() {
		return connectionDate;
	}
	public void setConnectionDate(String connectionDate) {
		this.connectionDate = connectionDate;
	}
	public int getConnectionPrice() {
		return connectionPrice;
	}
	public void setConnectionPrice(int connectionPrice) {
		this.connectionPrice = connectionPrice;
	}
	
} 