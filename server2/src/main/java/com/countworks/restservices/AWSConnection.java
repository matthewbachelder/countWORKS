package com.countworks.restservices;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

public class AWSConnection {
	
	private AmazonDynamoDBClient client;
	
	
	
	public AWSConnection(){
		client = new AmazonDynamoDBClient(new ProfileCredentialsProvider("countworks"));
		client.setRegion(Region.getRegion(Regions.US_WEST_2));
	}
	
	
	public AmazonDynamoDBClient getAWSClient(){
		return client;
	}

}
