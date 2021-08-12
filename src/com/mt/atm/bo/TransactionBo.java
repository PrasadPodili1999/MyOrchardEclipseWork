package com.mt.atm.bo;

public class TransactionBo {

	private int tid;
	private double tranAmt;
	private String tranDate;
	private long acNo;
	public TransactionBo() {
	}
	public TransactionBo(int tid, double tranAmt, String tranDate, long acNo) {
		this.tid = tid;
		this.tranAmt = tranAmt;
		this.tranDate = tranDate;
		this.acNo = acNo;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public double getTranAmt() {
		return tranAmt;
	}
	public void setTranAmt(double tranAmt) {
		this.tranAmt = tranAmt;
	}
	public String getTranDate() {
		return tranDate;
	}
	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}
	public long getAcNo() {
		return acNo;
	}
	public void setAcNo(long acNo) {
		this.acNo = acNo;
	}
	
}
