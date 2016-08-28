package com.countworks.restservices;

import java.util.Map;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;


@DynamoDBTable(tableName="BankRecords") 
public class BankRecord {
	
	private String bankRecordId;
	private String corporateId;
	private String bankAccountNumber;
	private String bankRoutingNumber;
	private String voidedCheck; //string link to file
	private String bankUsername;
	private String bankPassword;
	private String dateOfLastUpload;
	private Map<String, String> securityQuestions; //<"Question","Answer">
	private Map<String, String> bankStatements; //<"DateofUpload", "BankStatementClassRecordID"> //TODO create bank statement class
	private AES aes = new AES();
	
	
	@DynamoDBHashKey(attributeName="id") 
	public String getBankRecordId(){
		return bankRecordId;
	}
	public void setBankRecordId(String bankRecordId){
		this.bankRecordId = bankRecordId;
	}
	@DynamoDBAttribute(attributeName="CorporateId")
	public String getCorporateId(){
		return corporateId;
	}
	public void setCorporateId(String corporateId){
		this.corporateId = corporateId;
	}
	
	@DynamoDBAttribute(attributeName="BankAccountNumber")
	public String getBankAccountNumber(){
		return aes.decryptText(bankAccountNumber);
	}
	public void setBankAccountNumber(String bankAccountNumber){
		this.bankAccountNumber= aes.encryptText(bankAccountNumber);
	}
	
	@DynamoDBAttribute(attributeName="BankRoutingNumber")
	public String getBankRoutingNumber(){
		return aes.decryptText(bankRoutingNumber);
	}
	public void setBankRoutingNumber(String bankRoutingNumber){
		this.bankRoutingNumber= aes.encryptText(bankRoutingNumber);
	}

	@DynamoDBAttribute(attributeName="VoidedCheck")
	public String getVoidedCheck(){
		return aes.decryptText(voidedCheck);
	}
	public void setVoidedCheck(String voidedCheck){
		this.voidedCheck= aes.encryptText(voidedCheck);
	}
	
	@DynamoDBAttribute(attributeName="BankUsername")
	public String getBankUsername(){
		return aes.decryptText(bankUsername);
	}
	public void setBankUsername(String bankUsername){
		this.bankUsername= aes.encryptText(bankUsername);
	}
	
	@DynamoDBAttribute(attributeName="BankPassword")
	public String getBankPassword(){
		return aes.decryptText(bankPassword);
	}
	public void setBankPassword(String bankPassword){
		this.bankPassword= aes.encryptText(bankPassword);
	}
	
	@DynamoDBAttribute(attributeName="DateOfLastUpload")
	public String getDateOfLastUpload(){
		return dateOfLastUpload;
	}
	public void setDateOfLastUpload(String dateOfLastUpload){
		this.dateOfLastUpload= dateOfLastUpload;
	}
	
	@DynamoDBAttribute(attributeName="SecurityQuestions") 
	public Map<String, String> getSecurityQuestions(){
		return this.securityQuestions;
	}
	public void setSecurityQuestions(Map<String, String> securityQuestions){
		this.securityQuestions= securityQuestions;
	}
	
	@DynamoDBAttribute(attributeName="BankStatements") 
	public Map<String, String> getBankStatements(){
		return this.bankStatements;
	}
	public void setBankStatements(Map<String, String> bankStatements){
		this.bankStatements= bankStatements;
	}
	
}
