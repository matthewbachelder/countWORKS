package com.countworks.restservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;


import java.util.Date;

@Path("/isUp")
public class Up {
	
	
	@GET
	@Path("test")
	public String printCountWorks(){
		return "Welcome to countWORKS RESTful Service";
	}
	
	@GET
    @Path("ping")
    public String getServerTime() {
        System.out.println("RESTful Service 'countWORKS' is running ==> ping");
        return "received ping on "+new Date().toString();
    }

}