package com.mt.atm.atmservices;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mt.atm.bo.TransactionBo;
import com.mt.atm.bo.UserBo;
import com.mt.atm.dao.MySqlImpl;

public class MiniStatement {

	public static void showMiniStatement(UserBo obj) throws SQLException
	{
		/*System.out.println("**********"+obj.getBankName().toUpperCase()+"**********\n");
		System.out.println("Account Number 		:"+obj.getAccNo());
		System.out.println("Account Holder Name 	:"+obj.getName().toUpperCase());
		System.out.println("Mobile Number 		:"+obj.getMobNo());
		System.out.println("Account Type 		:"+obj.getAcType());
		System.out.println("Account Balance 	:"+obj.getBal()+"\n");
		System.out.println("**************************************");*/
		ArrayList<TransactionBo> al=new MySqlImpl().fetchTransaction(obj.getAccNo());
		if(al.size()>0)
		{
			for(TransactionBo i:al)
			{
				System.out.println("tran_id		: "+i.getTid());
				System.out.println("tran_amount	: "+i.getTranAmt());
				System.out.println("tran_date	: "+i.getTranDate());
				System.out.println("account Num	: "+i.getAcNo());
			}
		}
		
	}
}
