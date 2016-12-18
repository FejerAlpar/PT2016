package bussinessLogic;


import java.util.List;

import dataAccess.AccountAccess;
import model.Account;

public class AccountBL {

	private Account myAccount;
	private static AccountAccess access;
	
	public AccountBL(Account account){
		myAccount = account;
	}
	public AccountBL(){
		myAccount = new Account();
	}
	
	public void addData(){
		if (this.checkData()){
			access = new AccountAccess(myAccount);
			access.addData();
		}
	}
	
	public static String getName(int id){
		access = new AccountAccess();
		List<Account> accounts = access.getData();
		for (Account c : accounts) 
			if (c.getID() == id) return c.getName();
		return "";
	}
	public static String getEmail(int id){
		access = new AccountAccess();
		List<Account> accounts = access.getData();
		for (Account c : accounts) 
			if (c.getID() == id) return c.getEmail();
		return "";
	}
	
	
	public void deleteData(int myID){
	
		access = new AccountAccess(myAccount);
		access.deleteData(myID);
	
	}
			
	public void updateData(int myID){
		//replace
		access = new AccountAccess(myAccount);
		access.updateData(myID);
	}
	
	private boolean checkData(){
		if (myAccount.getID() < 1) return false;
		return true;
	}
	
	public List<Account> getData(){
		access = new AccountAccess();
		List<Account> accounts = access.getData();
		return accounts;
	}
	
}