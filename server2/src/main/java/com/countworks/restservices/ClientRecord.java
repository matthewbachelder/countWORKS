package com.countworks.restservices;

import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
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
	public String getLasttName(){
		return aes.decryptText(lastName);
	}
	public void setLastname(String lastName){
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
	
}
