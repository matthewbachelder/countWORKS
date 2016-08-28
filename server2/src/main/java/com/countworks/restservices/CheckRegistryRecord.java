package com.countworks.restservices;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="CheckRegistryRecords") 
public class CheckRegistryRecord {

	private String checkRegistryId;
	private String corporateId;
	private String checkImage;
	private String checkAmount;
	private String checkNumber;
	private String payee;
	private String expenseType;
	
	
	@DynamoDBHashKey(attributeName="id") 
	public String getCheckRegistryId(){
		return this.checkRegistryId;
	}
	public void setCheckRegistryId(String checkRegistryId){
		this.checkRegistryId = checkRegistryId;
	}
	
	@DynamoDBAttribute(attributeName="CorporateId")
	public String getCorporateId(){
		return this.corporateId;
	}
	public void setCorporateId(String corporateId){
		this.corporateId = corporateId;
	}
	
	@DynamoDBAttribute(attributeName="CheckImage") 
	public String getCheckImage(){
		return this.checkImage;
	}
	public void setCheckImage(String checkImage){
		this.checkImage = checkImage;
	}
	
	@DynamoDBAttribute(attributeName="CheckAmount") 
	public String getCheckAmount(){
		return this.checkAmount;
	}
	public void setCheckAmount(String checkAmount){
		this.checkAmount = checkAmount;
	}
	
	@DynamoDBAttribute(attributeName="CheckNumber") 
	public String getCheckNumber(){
		return this.checkNumber;
	}
	public void setCheckNumber(String checkNumber){
		this.checkNumber = checkNumber;
	}
	
	@DynamoDBAttribute(attributeName="CheckNumber") 
	public String getPayee(){
		return this.payee;
	}
	public void setPayee(String payee){
		this.payee = payee;
	}
	
	@DynamoDBAttribute(attributeName="ExpenseType") 
	public String getExpenseType(){
		return this.expenseType;
	}
	public void setExpenseType(String expenseType){
		this.expenseType = expenseType;
	}
	
	
}
