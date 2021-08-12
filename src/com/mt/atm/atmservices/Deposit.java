package com.mt.atm.atmservices;

import java.sql.SQLException;

import com.mt.atm.bo.UserBo;
import com.mt.atm.dao.MySqlImpl;

public class Deposit {

	public static void deposit(UserBo obj,long acno,double amt) throws SQLException
	{
		if(acno==obj.getAccNo())
		{
			int val=new MySqlImpl().updateBal(obj.getAccNo(),obj.getName(),amt);
			AddTransaction.addTransaction(amt,obj.getAccNo());
			if(val!=0)
			{
				System.out.println("amount deposited successfully");
			}
			new MySqlImpl().displayBalance(obj.getAccNo());
		}
		else
		{
			System.err.println("your account number is incorrect!!!");
		}
		
	}
}
