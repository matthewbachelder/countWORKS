package com.countworks.restservices;

import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="EmployeeRecords") 
public class EmployeeRecord {
	
	
	private String employeeId;
	private String corporateId;
	private String firstName;
	private String lastName;
	private String email;
	private String socialSecurityNumber;
	private Map<String, String> documents;
	private AES aes = new AES();
	
	@DynamoDBHashKey(attributeName="id") 
	public String getEmployeeId(){
		return employeeId;
	}
	public void setEmployeeId(String employeeId){
		this.employeeId = employeeId;
	}
	
	@DynamoDBAttribute(attributeName="CorporateId")
	public String getCorporateId(){
		return this.corporateId;
	}
	public void setCorporateId(String corporateId){
		this.corporateId = corporateId;
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
	
	@DynamoDBAttribute(attributeName="Email")
	public String getEmail(){
		return aes.decryptText(email);
	}
	public void setEmail(String email){
		this.email= aes.encryptText(email);
	}
	
	@DynamoDBAttribute(attributeName="SocialSecurityNumber")
	public String getSocialSecurityNumber(){
		return aes.decryptText(socialSecurityNumber);
	}
	public void setSocialSecurityNumber(String socialSecurityNumber){
		this.socialSecurityNumber= aes.encryptText(socialSecurityNumber);
	}
	
	@DynamoDBAttribute(attributeName="Documents") 
	public Map<String, String> getDocuments(){
		return this.documents;
	}
	public void setDocuments(Map<String, String> documents){
		this.documents= documents;
	}

}
