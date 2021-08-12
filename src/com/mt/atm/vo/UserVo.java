package com.mt.atm.vo;

public class UserVo {

	private long accNo;
	private String name;
	private long mobNo;
	private String acType;
	private int pin;
	private double bal;
	private int bId;
	public UserVo()
	{
		super();
	}
	public UserVo(long accNo, String name, long mobNo, String acType, int pin, double bal, int bId) {
		super();
		this.accNo = accNo;
		this.name = name;
		this.mobNo = mobNo;
		this.acType = acType;
		this.pin = pin;
		this.bal = bal;
		this.bId = bId;
	}
	
	
	public long getAccNo() {
		return accNo;
	}
	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobNo() {
		return mobNo;
	}
	public void setMobNo(long mobNo) {
		this.mobNo = mobNo;
	}
	public String getAcType() {
		return acType;
	}
	public void setAcType(String acType) {
		this.acType = acType;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public double getBal() {
		return bal;
	}
	public void setBal(double bal) {
		this.bal = bal;
	}
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	
	
}
