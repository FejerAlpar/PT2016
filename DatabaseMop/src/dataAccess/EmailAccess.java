package dataAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Email;



public class EmailAccess {
	
	private ResultSet rs;
	private Email myEmail;
	
	public EmailAccess(Email email){
		this.myEmail = email;
	}
	public EmailAccess(){
		this.myEmail = new Email();
	}
	
	public void addData(){
	    try {
	    	String query = "insert into Email.dbo.Emails (id, exp, rec, subject, message, attachment, status)"
	    	        + " values (?, ?, ?, ?, ?, ?, ?)";
	    	PreparedStatement addQuery = DB.connection.prepareStatement(query);
	    	addQuery.setInt(1, myEmail.getId());
	    	addQuery.setInt(2, myEmail.getExp());
	    	addQuery.setInt(3, myEmail.getRec());
	    	addQuery.setString(4, myEmail.getSubject());
	    	addQuery.setString(5, myEmail.getMessage());
	    	addQuery.setInt(6, myEmail.getAttachments());
	    	addQuery.setString(7, myEmail.getStatus());
	    	addQuery.execute();
	    }
	    catch (SQLException e){
	    	System.out.println(e.getMessage());
	    }
	}
	
	public void deleteData(int myID){
		try{
			String query = "delete from Emails where id = ?";
			PreparedStatement deleteQuery = DB.connection.prepareStatement(query);
			deleteQuery.setInt(1, myID);
			deleteQuery.execute();
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
	}
	
	public void updateStatus(int myID, String status){
		try{
			String query = "update Emails set status = ?, where id = ?";
			PreparedStatement updateQuery = DB.connection.prepareStatement(query);
			updateQuery.setString(1, status);
			updateQuery.setInt(2, myID);
			updateQuery.execute();
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
	}
	
	public List<Email> getReceivedEmails(int myId){
		List<Email> emails = new ArrayList<Email>();

		try{
			String query = "select * from Emails where rec in (select emailId from Recipients where acountId = ?)";
			PreparedStatement selectQuery = DB.connection.prepareStatement(query);
			selectQuery.setInt(1, myId);
			rs = selectQuery.executeQuery(query);
			while(rs.next()){
				Email myEmail = new Email(rs.getInt("id"), rs.getInt("exp"), rs.getInt("rec"), rs.getString("subject"), rs.getString("message"), rs.getInt("attachment"), rs.getString("status"));
				emails.add(myEmail);
			}
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
		return emails;
	}
	
	public List<Email> getSentEmails(int myId) {
		List<Email> emails = new ArrayList<Email>();

		try{
			String query = "select * from Emails where exp = ?";
			PreparedStatement selectQuery = DB.connection.prepareStatement(query);
			selectQuery.setInt(1, myId);
			rs = selectQuery.executeQuery(query);
			while(rs.next()){
				Email myEmail = new Email(rs.getInt("id"), rs.getInt("exp"), rs.getInt("rec"), rs.getString("subject"), rs.getString("message"), rs.getInt("attachment"), rs.getString("status"));
				emails.add(myEmail);
			}
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
		return emails;
	}
}
