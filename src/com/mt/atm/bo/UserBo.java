package com.mt.atm.bo;

public class UserBo {

	private int id;
	private long accNo;
	private String name;
	private long mobNo;
	private String acType;
	private int pin;
	private double bal;
	private String bankName;
	public UserBo()
	{
		super();
	}
	public UserBo(int id,long accNo, String name, long mobNo, String acType, int pin, double bal, String bankName) {
		super();
		this.accNo = accNo;
		this.name = name;
		this.mobNo = mobNo;
		this.acType = acType;
		this.pin = pin;
		this.bal = bal;
		this.bankName = bankName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
}
