package com.mt.atm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mt.atm.bo.TransactionBo;
import com.mt.atm.bo.UserBo;
import com.mt.atm.connection.ConnectionDb;
import com.mt.atm.vo.TransactionVo;
import com.mt.atm.vo.UserVo;

public class MySqlImpl implements UserDao {

	public void initializeDb()
	{
		try
		{
			ConnectionDb.con=DriverManager.getConnection(ConnectionDb.url,ConnectionDb.username,ConnectionDb.pwd);
			//System.out.println("DB Connected Successfully");
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public UserBo pinCheck(int pin) throws SQLException
	{
		String select="select * from account a join bank b on a.bid=b.bid where pin=?";
		PreparedStatement pm=ConnectionDb.con.prepareStatement(select);
		pm.setInt(1, pin);
		ResultSet rs=pm.executeQuery();
		if(rs.next()!=false)
		{
			UserBo ub=new UserBo();
			ub.setId(rs.getInt("id"));
			ub.setAccNo(rs.getLong("acno"));
			ub.setName(rs.getString("name"));
			ub.setMobNo(rs.getLong("mobileno"));
			ub.setAcType(rs.getString("actype"));
			ub.setPin(rs.getInt("pin"));
			ub.setBal(rs.getDouble("balance"));
			ub.setBankName(rs.getString("bname"));
			return ub;
		}
		return null;
	}
	public UserBo checkAccount(long acNo) throws SQLException
	{
		String select="select * from account a join bank b on a.bid=b.bid where acno=?";
		PreparedStatement pm=ConnectionDb.con.prepareStatement(select);
		pm.setDouble(1, acNo);
		ResultSet rs=pm.executeQuery();
		if(rs.next()!=false)
		{
			UserBo ub=new UserBo();
			ub.setId(rs.getInt("id"));
			ub.setAccNo(rs.getLong("acno"));
			ub.setName(rs.getString("name"));
			ub.setMobNo(rs.getLong("mobileno"));
			ub.setAcType(rs.getString("actype"));
			ub.setPin(rs.getInt("pin"));
			ub.setBal(rs.getDouble("balance"));
			ub.setBankName(rs.getString("bname"));
			return ub;
		}
		return null;
	}
	public int updateBal(long acno,double amt) throws SQLException
	{
		String update="update account set balance=balance-? where acno=?";
		
		PreparedStatement pm=ConnectionDb.con.prepareStatement(update);
		pm.setDouble(1, amt);
		pm.setLong(2, acno);
		int updateCount=pm.executeUpdate();
		return updateCount;
	}
	public int addTransaction(TransactionVo obj) throws SQLException
	{
		String insert="insert into transactions(tran_amount,tran_date,acno) values(?,curdate(),?)";
		PreparedStatement pm=ConnectionDb.con.prepareStatement(insert);
		pm.setDouble(1, obj.getTranAmt());
		pm.setLong(2, obj.getAcNo());
		int updateCount=pm.executeUpdate();
		return updateCount;
	}
	public int updateBal(long acNo,String name,double amt) throws SQLException
	{
		String update="update account set balance=balance+? where acno=? and name=?";
		PreparedStatement pm=ConnectionDb.con.prepareStatement(update);
		pm.setDouble(1, amt);
		pm.setLong(2, acNo);
		pm.setString(3, name);
		int updateCount=pm.executeUpdate();
		return updateCount;
	}
	public int updatePin(long acNo,int newPin) throws SQLException
	{
		String update="update account set pin=? where acno=?";
		PreparedStatement pm=ConnectionDb.con.prepareStatement(update);
		pm.setInt(1, newPin);
		pm.setLong(2, acNo);
		int updateCount=pm.executeUpdate();
		return updateCount;
	}
	public void displayBalance(long acNo) throws SQLException
	{
		String select="select * from account where acno=?";
		PreparedStatement pm=ConnectionDb.con.prepareStatement(select);
		pm.setLong(1, acNo);
		ResultSet rs=pm.executeQuery();
		rs.next();
		System.out.println("Dear "+rs.getString("name")+", Your current balance is : "+rs.getDouble("balance"));
	}
	public ArrayList<TransactionBo> fetchTransaction(long acNo) throws SQLException
	{
		String select="select * from transactions where acno=?";
		PreparedStatement pm=ConnectionDb.con.prepareStatement(select);
		pm.setLong(1, acNo);
		ResultSet rs=pm.executeQuery();
		ArrayList<TransactionBo> al=new ArrayList<>();
		while(rs.next())
		{
			al.add(new TransactionBo(rs.getInt("tid"),rs.getDouble("tran_amount")
					,rs.getString("tran_date"),rs.getLong("acno")));
		}
		return al;
	}
	public int addUser(UserVo obj) throws SQLException
	{
		String insert="insert into account(acno,name,mobileno,actype,pin,balance,bid) values(?,?,?,?,?,?,?)";
		PreparedStatement pm=ConnectionDb.con.prepareStatement(insert);
		pm.setLong(1, obj.getAccNo());
		pm.setString(2, obj.getName());
		pm.setLong(3, obj.getMobNo());
		pm.setString(4, obj.getAcType());
		pm.setInt(5, obj.getPin());
		pm.setDouble(6, obj.getBal());
		pm.setInt(7, obj.getbId());
		int updateCount=pm.executeUpdate();
		return updateCount;
	}
	public void closeConnection()
	{
		try
		{
			ConnectionDb.con.close();
			System.out.println("connection closed");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
