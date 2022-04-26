package com.concretepage.endpoint;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.concretepage.entity.Customer;
import com.concretepage.service.ICustomerService;

@Component
@Path("/customer")
public class CustomerEndpoint {
	private static final Logger logger = LoggerFactory.getLogger(CustomerEndpoint.class);
	@Autowired
	private ICustomerService customerService;

	@GET
	@Path("/details")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCustomerDetails() {
		List<Customer> list = customerService.getAllCustomers();
		return Response.ok(list).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCustomerById(@PathParam("id") Integer id) {
		Customer customer = customerService.getCustomerById(id);
		return Response.ok(customer).build();
	}

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCustomer(Customer customer) {
		boolean isAdded = customerService.addCustomer(customer);
		if (!isAdded) {
			logger.info("Customer already exits.");
			return Response.status(Status.CONFLICT).build();
		}
	return Response.created(URI.create("/Electro-grid/customer/" + customer.getCustomerId())).entity("Customer Added Successfully!!!").build();
	}

	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCustomer(Customer customer) {
		customerService.updateCustomer(customer);
		return Response.status(200).entity("Customer Details Update Successfull!!!").build();
	}
	
	

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteCustomer(@PathParam("id") Integer id) {
		customerService.deleteCustomer(id);
		return Response.status(200).entity("Customer Deleted Successfully!!!").build();
	}
}