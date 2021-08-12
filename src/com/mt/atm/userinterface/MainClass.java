package com.mt.atm.userinterface;
import java.sql.SQLException;
import java.util.Scanner;

import com.mt.atm.atmservices.AddUser;
import com.mt.atm.atmservices.Deposit;
import com.mt.atm.atmservices.MiniStatement;
import com.mt.atm.atmservices.MoneyTransfer;
import com.mt.atm.atmservices.SetPin;
import com.mt.atm.atmservices.Withdraw;
import com.mt.atm.bo.UserBo;
import com.mt.atm.dao.MySqlImpl;
public class MainClass {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		UserBo obj=null;
		int loopVar=1;
		new MySqlImpl().initializeDb();
		do
		{
			
			System.out.println("do you want to create new account? y/n");
			char choice=sc.next().charAt(0);
			if(choice=='y')
			{
				try
				{
					AddUser.addUser();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			
			try
			{
				
				System.out.println("to perform operations enter your account pin(xxxx) : ");
				int pin=sc.nextInt();
			    obj=new MySqlImpl().pinCheck(pin);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			if(obj!=null)
			{
				displayMenu();
				System.out.println("please enter your choice : ");
				int choice1=sc.nextInt();
				switch(choice1)
				{
				case 1:
					System.out.println("enter amount to withdraw : ");
					double amt=sc.nextDouble();
					try {
						Withdraw.withdraw(obj, amt);
					}
					catch(SQLException e)
					{
						e.printStackTrace();
					}
					break;
				case 2:
					System.out.println("enter account number : ");
					long acNo=sc.nextLong();
					System.out.println("enter amount to deposit : ");
					double amount=sc.nextDouble();
					try
					{
						Deposit.deposit(obj, acNo, amount);
					}
					catch(SQLException e)
					{
						e.printStackTrace();
					}
					break;
				case 3:
					System.out.println("enter account number to whom you want to transfer: ");
					long acNo1=sc.nextLong();
					System.out.println("enter amount to transfer : ");
					double trnsferAmt=sc.nextDouble();
					try
					{
					   UserBo obj1=new MySqlImpl().checkAccount(acNo1);
					   MoneyTransfer.moneyTransfer(obj1, obj, trnsferAmt);
					   
					}
					catch(SQLException e)
					{
						e.printStackTrace();
					}
					break;
				case 4:
					try {
						MiniStatement.showMiniStatement(obj);
					}
					catch(SQLException e)
					{
						e.printStackTrace();
					}
					break;
				case 5:
					System.out.println("enter your account number");
					long acNum=sc.nextLong();
					System.out.println("enter your mobile number");
					long mobNo=sc.nextLong();
					try {
						SetPin.setPin(obj, acNum, mobNo);
					}
					catch(SQLException e)
					{
						e.printStackTrace();
					}
					break;
				case 6:
					loopVar++;
					break;

				default:System.err.println("invalid choice, please select above options only");
				}
			}
			else
			{
				System.err.println("you have entered wrong pin!!!");
			}
			
		}while(loopVar==1);
		
		
		

	}
	static void displayMenu()
	{
		System.out.println("********Menu******\n");
		System.out.println("1.Cash Withdraw");
		System.out.println("2.Deposit");
		System.out.println("3.Money Transfer");
		System.out.println("4.Mini Statement");
		System.out.println("5.Reset Pin");
		System.out.println("6.exit");
		//System.out.println("6.create new account\n");
		System.out.println("*******************");
	}

}
