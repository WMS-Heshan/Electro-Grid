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

import com.concretepage.entity.Inquiry;
import com.concretepage.service.IInquiryService;

@Component
@Path("/inquiry")
public class InquiryEndPoint {
	private static final Logger logger = LoggerFactory.getLogger(InquiryEndPoint.class);	
	@Autowired
	private IInquiryService inquiryService;
	@GET
	@Path("/inqdetails")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getInquiryDetails() {
		List<Inquiry> list = inquiryService.getAllInquiry(); 
		return Response.ok(list).build();
	}
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getInquiryById(@PathParam("id") Integer id) {
		Inquiry inquiry = inquiryService.getInquiryById(id);
		return Response.ok(inquiry).build();
	}
	@POST
	@Path("/inqadd")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addInquiry(Inquiry inquiry) {
        boolean isAdded = inquiryService.addInquiry(inquiry);
        if (!isAdded) {
        	logger.info("Inquiry already exits.");
	        return Response.status(Status.CONFLICT).build();
        }
        return Response.created(URI.create("/spring-app/inquiry/"+ inquiry.getInquiry_Id())).build();
	}	
	@PUT
	@Path("/inqupdate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)	
	public Response updateInquiry(Inquiry inquiry) {
		inquiryService.updateInquiry(inquiry);
		return Response.ok(inquiry).build();
	}
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)		
	public Response deleteInquiry(@PathParam("id") Integer id) {
		inquiryService.deleteInquiry(id);
		return Response.noContent().build();
	}	
}