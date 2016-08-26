package com.countworks.restservices;

import java.util.Map;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="CorporateRecords") //TODO create table CorporateRecords
public class CorporateRecord {

	private String corporateId;
	private String clientId;
	private String stateId;
	private String federalId;
	private String businessType; //that is line of business
	private String businessLogo;
	private String deliveryPreference;
	private String corporationType;
	private Map<String, String> businessContact; //that is point of contact //includes signature image
	private Map<String, String> profitCenters;  // <""DateCreated", "String type">
	private Map<String, String> closingDocuments;  // <"DocumentName, "String link to document">
	private Map<String, String> loanScheduleDocuments; // <"DocumentName, "String link to document">
	private Map<String, String> corporationDocuments; // <"DocumentName, "String link to document">
	private Map<String, String> pointOfSaleUploads; // <""DateCreated", "String link to document">
	private Map<String, String> bankList; //<"BankName","BankClassRecordID"> 
	private Map<String, String> checkRegisterEntries; //<"DateCreated","CheckRegisterRecordID"> 
	private Map<String, String> employeeList; //<"Employee Name", "EmployeeClassRecordID"> 
	private Map<String, String> employeeAgreements; // <"DocumentName, "String link to document">
	
	
	@DynamoDBHashKey(attributeName="id") 
	public String getCorporateId(){
		return this.corporateId;
	}
	public void setCorporateId(String corporateId){
		this.corporateId = corporateId;
	}
	
	@DynamoDBAttribute(attributeName="ClientId") 
	public String getClientId(){
		return this.clientId;
	}
	public void setClientId(String clientId){
		this.clientId = clientId;
	}
	
	@DynamoDBAttribute(attributeName="StateId") 
	public String getStateId(){
		return this.stateId;
	}
	public void setStateId(String stateId){
		this.stateId= stateId;
	}
	
	@DynamoDBAttribute(attributeName="FederalId") 
	public String getFederalId(){
		return this.federalId;
	}
	public void setFederalId(String federalId){
		this.federalId= federalId;
	}
	
	@DynamoDBAttribute(attributeName="BusinessType") 
	public String getBusinessType(){
		return this.businessType;
	}
	public void setBusinessType(String businessType){
		this.businessType= businessType;
	}
	
	@DynamoDBAttribute(attributeName="BusinessLogo") 
	public String getBusinessLogo(){
		return this.businessLogo;
	}
	public void setBusinessLogo(String businessLogo){
		this.businessLogo= businessLogo;
	}
	
	@DynamoDBAttribute(attributeName="DeliveryPreference") 
	public String getDeliveryPreference(){
		return this.deliveryPreference;
	}
	public void setDeliveryPreference(String deliveryPreference){
		this.deliveryPreference= deliveryPreference;
	}
	
	@DynamoDBAttribute(attributeName="CorporationType") 
	public String getCorporationType(){
		return this.corporationType;
	}
	public void setCorporationType(String corporationType){
		this.corporationType= corporationType;
	}
	
	@DynamoDBAttribute(attributeName="BusinessContact") 
	public Map<String, String> getBusinessContact(){
		return this.businessContact;
	}
	public void setBusinessContact(Map<String, String> businessContact){
		this.businessContact= businessContact;
	}
	
	@DynamoDBAttribute(attributeName="ProfitCenters") 
	public Map<String, String> getProfitCenters(){
		return this.profitCenters;
	}
	public void setProfitCenters(Map<String, String> profitCenters){
		this.profitCenters= profitCenters;
	}
	
	@DynamoDBAttribute(attributeName="ClosingDocuments") 
	public Map<String, String> getClosingDocuments(){
		return this.closingDocuments;
	}
	public void setClosingDocuments(Map<String, String> closingDocuments){
		this.closingDocuments= closingDocuments;
	}
	
	@DynamoDBAttribute(attributeName="LoanScheduleDocuments") 
	public Map<String, String> getLoanScheduleDocuments(){
		return this.loanScheduleDocuments;
	}
	public void setLoanScheduleDocuments(Map<String, String> loanScheduleDocuments){
		this.loanScheduleDocuments= loanScheduleDocuments;
	}
	
	@DynamoDBAttribute(attributeName="CorporationDocuments") 
	public Map<String, String> getCorporationDocuments(){
		return this.corporationDocuments;
	}
	public void setCorporationDocuments(Map<String, String> corporationDocuments){
		this.corporationDocuments= corporationDocuments;
	}
	
	@DynamoDBAttribute(attributeName="PointOfSaleUploads") 
	public Map<String, String> getPointOfSaleUploads(){
		return this.pointOfSaleUploads;
	}
	public void setPointOfSaleUploads(Map<String, String> pointOfSaleUploads){
		this.pointOfSaleUploads= pointOfSaleUploads;
	}
	
	@DynamoDBAttribute(attributeName="BankList") 
	public Map<String, String> getBankList(){
		return this.bankList;
	}
	public void setBankList(Map<String, String> bankList){
		this.bankList= bankList;
	}

	@DynamoDBAttribute(attributeName="CheckRegisterEntries") 
	public Map<String, String> getCheckRegisterEntries(){
		return this.checkRegisterEntries;
	}
	public void setCheckRegisterEntries(Map<String, String> checkRegisterEntries){
		this.checkRegisterEntries= checkRegisterEntries;
	}
	
	@DynamoDBAttribute(attributeName="EmployeeList") 
	public Map<String, String> getEmployeeList(){
		return this.employeeList;
	}
	public void setEmployeeList(Map<String, String> employeeList){
		this.employeeList= employeeList;
	}
	@DynamoDBAttribute(attributeName="EmployeeAgreements") 
	public Map<String, String> getEmployeeAgreements(){
		return this.employeeAgreements;
	}
	public void setEmployeeAgreements(Map<String, String> employeeAgreements){
		this.employeeAgreements= employeeAgreements;
	}
	
	
	
}
