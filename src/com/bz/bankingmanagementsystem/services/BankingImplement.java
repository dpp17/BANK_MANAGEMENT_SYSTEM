package com.bz.bankingmanagementsystem.services;

import java.sql.SQLException;

import com.bz.bankingmanagementsystem.connection.BankingDAO;
import com.bz.bankingmanagementsystem.exceptions.AccountNotFound;
import com.bz.bankingmanagementsystem.interfaces.IBanking;

public class BankingImplement implements IBanking{

	static BankingDAO connection = new BankingDAO();
	
	public void welcomeDisplay() {
		System.err.println("===================================");
		System.out.println("  ::  Welcome To Address_Book  ::  ");
		System.err.println("==================================="+'\n');
		
	}
	
	//////////////////  DEPOSIT BALANCE  /////////////////////
	public void deposit() throws AccountNotFound{
		try {
			connection.deposit();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	//////////////////WITHDRAW BALANCE  /////////////////////
	public void withdrawl() throws AccountNotFound {
		try {
			connection.withdrawl();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
