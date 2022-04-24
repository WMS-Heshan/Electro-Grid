package com.concretepage.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.concretepage.entity.Employee;

public class JerseyClient {
	//Employee Details API Methods
	public void getEmployeeDetails() {
		Client client = ClientBuilder.newClient();
		WebTarget base = client.target("http://localhost:8080/spring-app/employee");
		WebTarget details = base.path("details");
		List<Employee> list = details.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Employee>>() {});
		
	    list.stream().forEach(employee -> 
	        System.out.println(employee.getEmployeeId()+", "+ employee.getName()+", "+ employee.getPhonenumber()+","+ employee.getEmailaddress()+","+ employee.getEmployeetype()+","+ employee.getDescription()));
		  
	    
	    client.close();
	}
	public void getEmployeeById(int employeeId) {
		Client client = ClientBuilder.newClient();
		WebTarget base = client.target("http://localhost:8081/spring-app/employee");
		WebTarget employeeById = base.path("{id}").resolveTemplate("id",employeeId);
		Employee employee = employeeById.request(MediaType.APPLICATION_JSON)
				.get(Employee.class);
		
        System.out.println(employee.getEmployeeId()+", "+ employee.getName()+", "+employee.getPhonenumber()+","+ employee.getEmailaddress()+","+ employee.getEmployeetype()+","+ employee.getDescription());
        
	    client.close();
	}
	public void addEmployee(Employee employee) {
		Client client = ClientBuilder.newClient();
		WebTarget base = client.target("http://localhost:8080/spring-app/employee");
		WebTarget add = base.path("add");
		Response response = add.request(MediaType.APPLICATION_JSON)
				.post(Entity.json(employee));
		
		System.out.println("Response Http Status: "+ response.getStatus());
        System.out.println(response.getLocation());
        
	    client.close();
	}
	public void updateEmployee(Employee employee) {
		Client client = ClientBuilder.newClient();
		WebTarget base = client.target("http://localhost:8080/spring-app/employee");
		WebTarget update = base.path("update");
		Response response = update.request(MediaType.APPLICATION_JSON)
				.put(Entity.json(employee));
		
		System.out.println("Response Http Status: "+ response.getStatus());
		Employee resEmployee = response.readEntity(Employee.class);
		System.out.println(resEmployee.getEmployeeId()+", "+ resEmployee.getName()+", "+ resEmployee.getPhonenumber() +", "+resEmployee.getEmailaddress() +","+ resEmployee.getEmployeetype() +","+ resEmployee.getDescription());;
        
	    client.close();
	}
	public void deleteEmplyee(int employeeId) {
		Client client = ClientBuilder.newClient();
		WebTarget base = client.target("http://localhost:8080/spring-app/employee");
		WebTarget deleteById = base.path("{id}").resolveTemplate("id", employeeId);
		Response response = deleteById.request(MediaType.APPLICATION_JSON)
				.delete();
		
		System.out.println("Response Http Status: "+ response.getStatus());
		if(response.getStatus() == 204) {
			System.out.println("Data deleted successfully.");
		}
        
	    client.close();
	}	
	public static void main(String[] args) {
		JerseyClient jerseyClient = new JerseyClient();
	    jerseyClient.getEmployeeDetails();
		//jerseyClient.getArticleById(102);
		
		Employee employee = new Employee();
		employee.setName("Spring REST Security using Hibernate2");
		employee.setPhonenumber("Spring"); 
		//jerseyClient.addArticle(article);
		
		employee.setEmployeeId(105);
		//jerseyClient.updateArticle(article);
		
		//jerseyClient.deleteArticle(105);
	}
}
