package com.bz.bankingmanagementsystem.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.bz.bankingmanagementsystem.exceptions.AccountNotFound;
import com.bz.bankingmanagementsystem.interfaces.IBanking;
import com.bz.bankingmanagementsystem.services.BankingImplement;

public class BankingManagement {

	static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args) {
		IBanking banking = new BankingImplement();
		
		banking.welcomeDisplay();
		do {
		try {
			
				System.out.println(" Press 1 :: Deposit Money" +'\n' + " Press 2:: WithDraw Money"+'\n'+"Enter Option ::");
		switch (userInput.nextByte()) {
		case 1:
			banking.deposit();
			break;
		case 2:
			banking.withdrawl();
			break;
		default:
			System.err.println(" Option Not Found");
		}
		
		}catch(InputMismatchException e) {
			System.err.println(" Wrong Input Entered");
		}catch (AccountNotFound e) {
			System.err.println(e);
		}catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(" Press 0 :: To Re-visit Menu ");
		}while(userInput.nextByte() == 0);
	}

}
