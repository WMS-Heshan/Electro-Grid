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

import com.concretepage.entity.Connection;
import com.concretepage.service.IConnectionService;

@Component
@Path("/connection")
public class ConnectionEndpoint {
	private static final Logger logger = LoggerFactory.getLogger(ConnectionEndpoint.class);	
	@Autowired
	private IConnectionService connectionService;
	@GET
	@Path("/details")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getConnectionDetails() {
		List<Connection> list = connectionService.getAllConnections(); 
		return Response.ok(list).build();
	}
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getConnectionById(@PathParam("id") Integer id) {
		Connection connection = connectionService.getConnectionById(id);
		return Response.ok(connection).build();
	}
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addConnection(Connection connection) {
        boolean isAdded = connectionService.addConnection(connection);
        if (!isAdded) {
        	logger.info("Connection already exits.");
	        return Response.status(Status.CONFLICT).build();
        }
        return Response.created(URI.create("/spring-app/connection/"+ connection.getConnectionId())).build();
	}	
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)	
	public Response updateConnection(Connection connection) {
		connectionService.updateConnection(connection);
		return Response.ok(connection).build();
	}
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)		
	public Response deleteConnection(@PathParam("id") Integer id) {
		connectionService.deleteConnection(id);
		return Response.status(200).entity("Connection Deleted Successfully!!").build();
	}	
}