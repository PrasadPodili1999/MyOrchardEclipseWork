package com.mt.atm.atmservices;

import java.sql.SQLException;

import com.mt.atm.bo.UserBo;
import com.mt.atm.dao.MySqlImpl;

public class Withdraw {

	public static void withdraw(UserBo obj,double amt) throws SQLException
	{
		if(amt<=obj.getBal())
		{
			System.out.println("collect your cash!!");
			int val=new MySqlImpl().updateBal(obj.getAccNo(),amt);
			AddTransaction.addTransaction(amt,obj.getAccNo());
			if(val!=0)
			{
				System.out.println("amount withdrawn successfully");
			}
			new MySqlImpl().displayBalance(obj.getAccNo());
		}
		else
		{
			System.err.println("your account balance is insufficient!!");
		}
	}
}
