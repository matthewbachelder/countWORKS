package com.countworks.restservices;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Path("/client")
public class Client {
	
	
	@GET
	@Path("test")
	public String printCountWorks(){
		return "Welcome to countWORKS RESTful Service - Client API";
	}
	
	
    @POST
    @Path("/create-new-client")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response newClientRecord(ClientRecord client) {
    	
    	
    	return Response.status(500).entity("").build();
    	
    }
	

}