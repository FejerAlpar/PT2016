package bussinessLogic;


import java.util.List;

import dataAccess.EmailAccess;
import model.Email;

public class EmailBL {

	private Email myEmail;
	private static EmailAccess access;
	
	public EmailBL(Email email){
		myEmail = email;
	}
	public EmailBL(){
		myEmail = new Email();
	}
	
	public void addData(){
		if (this.checkData()){
			access = new EmailAccess(myEmail);
			access.addData();
		}
	}
	
	public static int getExp(int id){
		access = new EmailAccess();
		List<Email> emails = access.getData();
		for (Email c : emails) 
			if (c.getId() == id) return c.getExp();
		return 0;
	}
	public static int getRec(int id){
		access = new EmailAccess();
		List<Email> emails = access.getData();
		for (Email c : emails) 
			if (c.getId() == id) return c.getRec();
		return 0;
	}
	
	
	public void deleteData(int myID){
	
		access = new EmailAccess(myEmail);
		access.deleteData(myID);
	
	}
			
	public void updateData(int myID){
		//replace
		access = new EmailAccess(myEmail);
		access.updateData(myID);
	}
	
	private boolean checkData(){
		if (myEmail.getId() < 1) return false;
		return true;
	}
	
	public List<Email> getData(){
		access = new EmailAccess();
		List<Email> emails = access.getData();
		return emails;
	}
	
}