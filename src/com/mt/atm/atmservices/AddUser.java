package com.mt.atm.atmservices;
import java.sql.SQLException;
import java.util.Scanner;

import com.mt.atm.dao.MySqlImpl;
import com.mt.atm.vo.UserVo;
public class AddUser {

	public static void addUser() throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter account number :");
		long acNo=sc.nextLong();
		System.out.println("enter name");
		String name=sc.next();
		System.out.println("enter account type");
		String acType=sc.next();
		System.out.println("enter mobile number");
		long mobNo=sc.nextLong();
		System.out.println("enter atm pin");
		int pin=sc.nextInt();
		System.out.println("enter account balance");
		double bal=sc.nextDouble();
		System.out.println("select bank");
		displayBanks();
		int bId=sc.nextInt();
		System.out.println(new MySqlImpl().addUser(new UserVo(acNo,name,mobNo,acType,pin,bal,bId))+" rows inserted");
	}
	public static void displayBanks()
	{
		System.out.println("*************\n");
		System.out.println("1.SBI\n2.ICICI\n3.HDFC\n4.BOI\n5.AXIS");
		System.out.println("*************\n");
	}
}
