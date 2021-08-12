package com.mt.atm.atmservices;
import java.sql.SQLException;
import java.util.Scanner;
import com.mt.atm.bo.UserBo;
import com.mt.atm.dao.MySqlImpl;

public class SetPin {

	public static void setPin(UserBo obj,long acNo,long mobNo) throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		if(obj.getAccNo()==acNo&&obj.getMobNo()==mobNo)
		{
			System.out.println("Enter New Pin : ");
			int newPin=sc.nextInt();
			if(new MySqlImpl().updatePin(acNo, newPin)!=0)
			{
				System.out.println("your pin has changed successfully!!!");
			}
		}
		else
		{
			System.err.println("your credintials are incorrect");
		}
	}
}
