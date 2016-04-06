package dataAccess;

import model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class ClientAccess {
	
	private ResultSet rs;
	private Client myClient;
	private Statement st;
	
	public ClientAccess(Client client){
		this.myClient = client;
	}
	public ClientAccess(){
		this.myClient = new Client();
		this.st = DB.getStatement();
	}
	
	public void addData(){
	    try {
	    	String query = " insert into clients (id, name, birthDate, phoneNumber)"
	    	        + " values (?, ?, ?, ?)";
	    	PreparedStatement addQuery = DB.connection.prepareStatement(query);
	    	addQuery.setInt(1, myClient.getID());
	    	addQuery.setString(2, myClient.getName());
	    	addQuery.setString(3, myClient.getBirthDate());
	    	addQuery.setString(4, myClient.getPhone());
	    	addQuery.execute();
	    }
	    catch (SQLException e){
	    	System.out.println(e.getMessage());
	    }
	}
	
	public void deleteData(int myID){
		try{
			String query = "delete from clients where id = ?";
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
			String query = "update clients set id=?, name=?,birthDate=?,phoneNumber=? where id = ?";
			PreparedStatement updateQuery = DB.connection.prepareStatement(query);
			updateQuery.setInt(1, myClient.getID());
			updateQuery.setString(2, myClient.getName());
			updateQuery.setString(3, myClient.getBirthDate());
			updateQuery.setString(4, myClient.getPhone());
			updateQuery.setInt(5, myID);
			updateQuery.execute();
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
	}
	
	public List<Client> getData(){
		List<Client> clients = new ArrayList<Client>();

		try{
		String query = "select * from clients order by id";
		rs = st.executeQuery(query);
		while(rs.next()){
			Client newClient = new Client();
			newClient.setID(rs.getInt("id"));
			newClient.setName(rs.getString("name"));
			newClient.setBirthDate(rs.getString("birthDate"));
			newClient.setPhone(rs.getString("phoneNumber"));
			clients.add(newClient);
		}
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
		return clients;
	}
}
