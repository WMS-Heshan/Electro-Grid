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

import com.concretepage.entity.PaymentDetails;
import com.concretepage.service.IPaymentPortalService;

@Component
@Path("/payment")
public class PaymentEndpoint {
	private static final Logger logger = LoggerFactory.getLogger(PaymentEndpoint.class);	
	@Autowired
	private IPaymentPortalService paymentService;
//get details by id
	@GET
	@Path("/details")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getArticleDetails() {
		List<PaymentDetails> list = paymentService.getAllPaymentDetails(); 
		return Response.ok(list).build();
	}
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPaymentDetailsById(@PathParam("id") Integer id) {
		PaymentDetails paymentdetails = paymentService.getPaymentDetailsById(id);
		return Response.ok(paymentdetails).build();
	}
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPaymentDetails(PaymentDetails paymentdetails) {
        boolean isAdded = paymentService.addPaymentDetails(paymentdetails);
        if (!isAdded) {
        	logger.info("payment deatils already exits.");
	        return Response.status(Status.CONFLICT).build();
        }
	}	
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)	
	public Response updatePaymentDetails(PaymentDetails paymentdetails) {
		paymentService.updatePaymentDetails(paymentdetails);
		return Response.ok(paymentdetails).entity("Payment Details Update Successfully!!!").build();
	}
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)		
	public Response deletePaymentDetails(@PathParam("id") Integer id) {
		paymentService.deletePaymentDetails(id);
		return Response.status(200).entity("Payment Deleted Successfully!!!").build();
	}	
}