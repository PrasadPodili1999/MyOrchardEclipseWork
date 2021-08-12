package com.mt.atm.atmservices;

import java.sql.SQLException;

import com.mt.atm.dao.MySqlImpl;
import com.mt.atm.vo.TransactionVo;

public class AddTransaction {

	public static void addTransaction(double amt,long acNo) throws SQLException
	{
		TransactionVo obj=new TransactionVo(amt,acNo);
		int val=new MySqlImpl().addTransaction(obj);
		if(val!=0) {
			System.out.println("transaction successfull!!");
		}
		else {
			System.err.println("transaction failed!!");
		}
		
	}
}
