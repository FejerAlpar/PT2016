package bussinessLogic;


import java.util.List;

import dataAccess.*;
import model.Client;

public class ClientBL {

	private Client myClient;
	private static ClientAccess access;
	
	public ClientBL(Client client){
		myClient = client;
	}
	public ClientBL(){
		myClient = new Client();
	}
	
	public void addData(){
		if (this.checkData()){
			access = new ClientAccess(myClient);
			access.addData();
		}
	}
	
	public static String getName(int id){
		access = new ClientAccess();
		List<Client> clients = access.getData();
		for (Client c : clients) 
			if (c.getID() == id) return c.getName();
		return "";
	}
	public static String getPhone(int id){
		access = new ClientAccess();
		List<Client> clients = access.getData();
		for (Client c : clients) 
			if (c.getID() == id) return c.getPhone();
		return "";
	}
	
	
	public void deleteData(int myID){
	
		access = new ClientAccess(myClient);
		access.deleteData(myID);
	
	}
			
	public void updateData(int myID){
		//replace
		access = new ClientAccess(myClient);
		access.updateData(myID);
	}
	
	private boolean checkData(){
		if (myClient.getID() < 1) return false;
		return true;
	}
	
	public List<Client> getData(){
		access = new ClientAccess();
		List<Client> clients = access.getData();
		return clients;
	}
	
}