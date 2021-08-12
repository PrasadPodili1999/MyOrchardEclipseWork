package com.mt.atm.vo;

public class TransactionVo {

	private double tranAmt;
	//private String tranDate;
	private long acNo;
	
	public TransactionVo() {
		super();
	}
	public TransactionVo(double tranAmt, long acNo) {
		this.tranAmt = tranAmt;
		
		this.acNo = acNo;
	}
	public double getTranAmt() {
		return tranAmt;
	}
	public void setTranAmt(double tranAmt) {
		this.tranAmt = tranAmt;
	}
	
	public long getAcNo() {
		return acNo;
	}
	public void setAcNo(long acNo) {
		this.acNo = acNo;
	}
	
}
