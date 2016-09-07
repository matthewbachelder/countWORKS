package com.countworks.restservices;

import java.util.Map;
import java.util.Random;
import java.util.UUID;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="ClientRecords")
public class ClientRecord {

	private String clientId;
	private String firstName;
	private String lastName;
	private String primaryEmail;
	private String phone;
	private String sitePassword;
	private Map<String, String> corporationList; //<"CorporationName", "CorporationClassRecordID">
	private AES aes = new AES();
	
	public ClientRecord(){
		
	}
	public ClientRecord(String firstName, String lastName, String phone, String primaryEmail, String sitePassword){
		this.firstName=firstName;
		this.lastName=lastName;
		this.phone=phone;
		this.primaryEmail=primaryEmail;
		this.sitePassword = sitePassword;
	}
	
	@DynamoDBHashKey(attributeName="id") 
	public String getClientId(){
		return clientId;
	}
	public void setClientId(String clientId){
		this.clientId = clientId;
	}
	
	
	@DynamoDBAttribute(attributeName="FirstName")
	public String getFirstName(){
		return aes.decryptText(firstName);
	}
	public void setFirstName(String firstName){
		this.firstName= aes.encryptText(firstName);
	}
	
	@DynamoDBAttribute(attributeName="LastName")
	public String getLastName(){
		return aes.decryptText(lastName);
	}
	public void setLastName(String lastName){
		this.lastName= aes.encryptText(lastName);
	}
	
	@DynamoDBAttribute(attributeName="PrimaryEmail")
	public String getPrimaryEmail(){
		return aes.decryptText(primaryEmail);
	}
	public void setPrimaryEmail(String primaryEmail){
		this.primaryEmail= aes.encryptText(primaryEmail);
	}
	
	@DynamoDBAttribute(attributeName="Phone")
	public String getPhone(){
		return aes.decryptText(phone);
	}
	public void setPhone(String phone){
		this.phone = aes.encryptText(phone);
	}
	
	@DynamoDBAttribute(attributeName="sitePassword")
	public String getSitePassword(){
		return aes.decryptText(sitePassword);
	}
	public void setSitePassword(String sitePassword){
		this.sitePassword = aes.encryptText(sitePassword);
	}

	@DynamoDBAttribute(attributeName="CorporationList") 
	public Map<String, String> getCorporationList(){
		return this.corporationList;
	}
	public void setCorporationList(Map<String, String> corporationList){
		this.corporationList= corporationList;
	}
	
	public void encrypt(){
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setSitePassword(sitePassword);
		this.setPhone(phone);
		this.setPrimaryEmail(primaryEmail);
	}
	
	
	public String createNewClient(){
		
		try{
		String result = "";
		AWSConnection client = new AWSConnection();
		
		UUID clientId = UUID.randomUUID();
		this.clientId = clientId.toString();
		
		
		DynamoDBMapper mapper = new DynamoDBMapper(client.getAWSClient());
        mapper.save(this);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return "ok;";
		
	}
	
}
