package com.mt.atm.dao;

import java.sql.SQLException;

import com.mt.atm.bo.UserBo;
import com.mt.atm.vo.UserVo;

public interface UserDao {

	public void initializeDb();
	public UserBo pinCheck(int pin) throws SQLException;
	public UserBo checkAccount(long acNo) throws SQLException;
	public int updateBal(long acno,double amt) throws SQLException;
	public int updateBal(long acno,String name,double amt) throws SQLException;
	public void displayBalance(long acno) throws SQLException;
	public int updatePin(long acNo,int newPin) throws SQLException;
	public int addUser(UserVo obj) throws SQLException;
	public void closeConnection();
}
