package dataAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Account;



public class AccountAccess {
	
	private ResultSet rs;
	private Account myAccount;
	private Statement st;
	
	public AccountAccess(Account account){
		this.myAccount = account;
	}
	public AccountAccess(){
		this.myAccount = new Account();
		this.st = DB.getStatement();
	}
	
	public void addData(){
	    try {
	    	String query = "insert into Email.dbo.Accounts (id, name, email, password)"
	    	        + " values (?, ?, ?, ?)";
	    	PreparedStatement addQuery = DB.connection.prepareStatement(query);
	    	addQuery.setInt(1, myAccount.getID());
	    	addQuery.setString(2, myAccount.getName());
	    	addQuery.setString(3, myAccount.getPassword());
	    	addQuery.setString(4, myAccount.getEmail());
	    	addQuery.execute();
	    }
	    catch (SQLException e){
	    	System.out.println(e.getMessage());
	    }
	}
	
	public void deleteData(int myID){
		try{
			String query = "delete from Accounts where id = ?";
			PreparedStatement deleteQuery = DB.connection.prepareStatement(query);
			deleteQuery.setInt(1, myID);
			deleteQuery.execute();
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
	}
	
	public void updateData(int myID){
		try{
			String query = "update Accounts set name=?,email=?,password=? where id = ?";
			PreparedStatement updateQuery = DB.connection.prepareStatement(query);
			updateQuery.setString(1, myAccount.getName());
			updateQuery.setString(2, myAccount.getEmail());
			updateQuery.setString(3, myAccount.getPassword());
			updateQuery.setInt(4, myID);
			updateQuery.execute();
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
	}
	
	public List<Account> getData(){
		List<Account> Accounts = new ArrayList<Account>();

		try{
		String query = "select * from Accounts order by id";
		rs = st.executeQuery(query);
		while(rs.next()){
			Account newAccount = new Account();
			newAccount.setID(rs.getInt("id"));
			newAccount.setName(rs.getString("name"));
			newAccount.setPassword(rs.getString("password"));
			newAccount.setEmail(rs.getString("email"));
			Accounts.add(newAccount);
		}
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
		return Accounts;
	}
}
