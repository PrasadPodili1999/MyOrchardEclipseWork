package com.mt.atm.atmservices;

import java.sql.SQLException;

import com.mt.atm.bo.UserBo;
import com.mt.atm.dao.MySqlImpl;

public class MoneyTransfer {

	public static void moneyTransfer(UserBo obj1,UserBo obj2,double amt) throws SQLException{
		
		if(amt<=obj2.getBal())
		{
			int val=new MySqlImpl().updateBal(obj1.getAccNo(),obj1.getName(),amt);
			AddTransaction.addTransaction(amt,obj1.getAccNo());
			AddTransaction.addTransaction(amt,obj2.getAccNo());
			if(val!=0)
			{
				System.out.println("amount credited to "+obj1.getName());
			}
			int val1=new MySqlImpl().updateBal(obj2.getAccNo(),amt);
			if(val1!=0)
			{
				System.out.println("amount debited from "+obj2.getAccNo()+"("+obj2.getName()+")");
			}
			new MySqlImpl().displayBalance(obj1.getAccNo());
			new MySqlImpl().displayBalance(obj2.getAccNo());
			
		}
	}
}
