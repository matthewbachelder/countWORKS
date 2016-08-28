package com.countworks.restservices;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="BankStatementRecords") 
public class BankStatementRecord {

	private String bankStatementId;
	private String bankRecordId;
	private String dateCreated;
	private String datePeriod;
	private String document;
	
	@DynamoDBHashKey(attributeName="id") 
	public String getBankStatementId(){
		return bankStatementId;
	}
	public void setBankStatementId(String bankStatementId){
		this.bankStatementId = bankStatementId;
	}
	
	@DynamoDBAttribute(attributeName="BankRecordId")
	public String getBankRecordId(){
		return bankRecordId;
	}
	public void setBankRecordId(String bankRecordId){
		this.bankRecordId=bankRecordId;
	}
	
	@DynamoDBAttribute(attributeName="DateCreated")
	public String getDateCreated(){
		return dateCreated;
	}
	public void setDateCreated(String dateCreated){
		this.dateCreated=dateCreated;
	}
	
	@DynamoDBAttribute(attributeName="DatePeriod")
	public String getDatePeriod(){
		return datePeriod;
	}
	public void setDatePeriod(String datePeriod){
		this.datePeriod=datePeriod;
	}
	
	@DynamoDBAttribute(attributeName="Document")
	public String getDocument(){
		return document;
	}
	public void setDocument(String document){
		this.document=document;
	}
	
	
}
