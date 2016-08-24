package com.countworks.restservices;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="ClientRecords")
public class ClientRecord {

	private int clientId;
	
	@DynamoDBHashKey(attributeName="id") 
	public int getClientId(){
		return clientId;
	}
	public void setClientId(int clientId){
		this.clientId = clientId;
	}
	
	
}
