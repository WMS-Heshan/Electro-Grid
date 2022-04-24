
package com.concretepage.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="employees")
public class Employee implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="employee_id")
    private int employeeId;  
	@Column(name="name")
    private String name;
	@Column(name="phone_number")	
	private String phone_number;
	@Column(name="email_address")	
	private String email_address;
	@Column(name="employee_type")	
	private String employee_type;
	@Column(name="Description")	
	private String Description;
	
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void SetEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonenumber() {
		return phone_number;
	}
	public void setPhonenumber(String phone_number) {
		this.phone_number = phone_number;
		}
	public String getEmail_address() {
		return email_address;
	}
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}
	public String getEmployee_type() {
		return employee_type;
	}
	public void setEmployee_type(String employee_type) {
		this.employee_type = employee_type;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
} 
