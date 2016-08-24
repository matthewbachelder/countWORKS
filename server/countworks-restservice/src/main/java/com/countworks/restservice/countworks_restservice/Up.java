package com.countworks.restservice.countworks_restservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Date;

@Path("/up")
public class Up {
	
	@GET
    @Path("ping")
    public String getServerTime() {
        System.out.println("RESTful Service 'countWORKS' is running ==> ping");
        return "received ping on "+new Date().toString();
    }
	
}