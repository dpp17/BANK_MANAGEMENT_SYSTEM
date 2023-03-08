package com.bz.bankingmanagementsystem.connection;


import java.sql.*;
import java.util.Scanner;

import com.bz.bankingmanagementsystem.exceptions.AccountNotFound;

public class ConnectionJDBC {

	static int balance = 0;
	static long accountNumberOne = 0; 
	static Scanner userInput = new Scanner(System.in);
	
	////////////////// CHECK_VALID_ACCOUNT /////////////////////
	private static boolean CheckAccountNumber(long accountNumber) throws  ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Banking_Management","root","Lambop@12345");
		Statement statement = con.createStatement();
		ResultSet res = statement.executeQuery("select * from AccountDetails where accountNumber = "+accountNumber+";");
		if(res.getRow() == 0) {
			return false;
		}
		return true;		
	}
	
	//////////////////  WITHDRAW BALANCE  /////////////////////
	public static void withdrawl() throws ClassNotFoundException, SQLException {
		
		System.out.println(" Enter AccountNumber :: ");
		long accountNumber = userInput.nextLong();
		if(!CheckAccountNumber(accountNumber)) {
			System.err.println("asdasdasda");
			throw new AccountNotFound(" :: Account not found :: ");
		}
		else {
		System.out.println(" Enter pinNumber ::");
		int pin = userInput.nextInt();
		System.out.println(" Enter Withdraw_Ammount ::");
		int withdraw = userInput.nextInt();
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Banking_Management","root","Lambop@12345");
		Statement statement = con.createStatement();
		ResultSet res = statement.executeQuery("select * from AccountDetails where accountNumber = "+accountNumber+" and pinNumber = "+pin+";");
		while(res.next()) {
			balance = res.getInt("balance");
			if(balance < withdraw) {
				System.out.println(" In-sufficient Balance :: "  + balance);
			}else {
			balance = balance - withdraw;
			}
		}
		statement.close();
		
		PreparedStatement statement2 = con.prepareStatement("Update AccountDetails set balance = "+balance+" where accountNumber = "+accountNumber+";");
		
				int confirm = statement2.executeUpdate();
		System.out.println(confirm);
		System.out.println(balance + " :: Remaining Balance");
		System.out.println(withdraw + " ::  Withdrawl Amount");
		
		statement2.close();
		con.close();
	
		}
	}
	
		//////////////////  DEPOSIT BALANCE  /////////////////////
		public static void deposit() throws ClassNotFoundException, SQLException {
		
		System.out.println(" Enter AccountNumber :: ");
		long accountNumber = userInput.nextLong();
		if(!CheckAccountNumber(accountNumber)) {
			System.err.println("sadasdascasc");
			throw new AccountNotFound(" :: Account not found :: ");
		}
		else {
		System.out.println(" Enter pinNumber ::");
		int pin = userInput.nextInt();
		System.out.println(" Enter Withdraw_Ammount ::");
		int withdraw = userInput.nextInt();
	
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Banking_Management",        "root",          "Lambop@12345");
		Statement statement = con.createStatement();
		ResultSet res = statement.executeQuery("select * from AccountDetails where accountNumber = "+accountNumber+" and pinNumber = "+pin+";");
		while(res.next()) {
			balance = res.getInt("balance");
			balance = balance + withdraw;
		}
		statement.close();
		
		PreparedStatement statement2 = con.prepareStatement("Update AccountDetails set balance = "+balance+" where accountNumber = "+accountNumber+";");
		
				int confirm = statement2.executeUpdate();
		System.out.println(confirm);
		System.out.println(balance + " :: Remaining Balance");
		System.out.println(withdraw + " ::  Withdrawl Amount");
		
		statement2.close();
		con.close();
		}
	
	}
}
