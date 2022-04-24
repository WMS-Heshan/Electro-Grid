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
	@Column(name="line")
    private String line;
	@Column(name="year")	
	private String year;
	public int getConnectionId() {
		return connectionId;
	}
	public void setConnectionId(int connectionId) {
		this.connectionId = connectionId;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
} 