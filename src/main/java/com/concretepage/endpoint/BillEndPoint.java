package com.concretepage.endpoint;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.concretepage.entity.Bill;
import com.concretepage.service.BillService;

@Component
@Path("/bill")
public class BillEndPoint {
	private static final Logger logger = LoggerFactory.getLogger(BillEndPoint.class);
	
	@Autowired
	private BillService  billService;
	
	@GET
	@Path("/details")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getArticleDetails() {
		List<Bill> list = billService.getAllArticles(); 
		return Response.ok(list).build();
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addBill(Bill bill) {
        boolean isAdded =  billService.addBill(bill);
        if (!isAdded) {
        	logger.info("Bill already exits.");
	        return Response.status(Status.CONFLICT).build();
        }
        return Response.created(URI.create("/spring-app/bill/")).entity("Bill Added Successfully").build();
	}	
}
