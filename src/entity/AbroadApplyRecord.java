package entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DatabaseDrive.Conn;

public class AbroadApplyRecord {
	private int serialNum   ;
	private String userId;
	private String userName;
	private String applyTime;
	private String country;
	private String reasontype;
	private String beginTime;
	private String endTime;
	private String fundSource;
	private String reasonDetails;
	private String abroadState;
	private String auditState;

	
	public AbroadApplyRecord(){
		
	}
	
	public AbroadApplyRecord(int number, String id,String name,String country,
			String applyTime 
			,String reasontype,String begintime,String endtime 
			,String fs,String rd ,String as,String  audit){
		this.serialNum=number;
		this.userId=id;
		this.userName=name;
		this.country=country;
		this.applyTime = applyTime;
		this.reasontype=reasontype;
		this.beginTime= begintime;
		this.endTime=endtime;
		this.fundSource =fs;
		this.reasonDetails =rd;
		this.abroadState=as;
		this.auditState=audit;
	}
	public AbroadApplyRecord(String id,String name,String country
			,String applyTime
			,String reasontype,String begintime,String endtime 
			,String fs,String rd ,String as,String  audit){
		this.userId=id;
		this.userName=name;
		this.country=country;
		this.applyTime = applyTime;
		this.reasontype=reasontype;
		this.beginTime= begintime;
		this.endTime=endtime;
		this.fundSource =fs;
		this.reasonDetails =rd;
		this.abroadState=as;
		this.auditState=audit;
	}
	
	public int getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(int serialNum) {
		this.serialNum = serialNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getReasontype() {
		return reasontype;
	}

	public void setReasontype(String reasontype) {
		this.reasontype = reasontype;
	}

	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getFundSource() {
		return fundSource;
	}
	public void setFundSource(String fundSource) {
		this.fundSource = fundSource;
	}
	public String getAbroadState() {
		return abroadState;
	}
	public void setAbroadState(String abroadState) {
		this.abroadState = abroadState;
	}
	public String getReasonDetails() {
		return reasonDetails;
	}
	public void setReasonDetails(String reasonDetails) {
		this.reasonDetails = reasonDetails;
	}
	public String getAuditState() {
		return auditState;
	}
	public void setAuditState(String auditState) {
		this.auditState = auditState;
	}

	public String getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	public void setSerialNum(Integer serialNum) {
		this.serialNum = serialNum;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.serialNum+" "+this.userId+" "+this.userName+" "+this.country
				+" "+this.applyTime+" "+this.reasontype+" "+
				this.beginTime+" "+this.endTime+" "+this.reasonDetails+" "+
				this.fundSource+" "+this.abroadState+" "+this.auditState;
	}
	
	
}
