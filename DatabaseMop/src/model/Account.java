package model;

public class Account {

	private int id;
	private String name;
	private String password;
	private String email;
	
	public Account(int id, String name, String email, String password){
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
	}
	public Account(){
		this.id = 1;
		this.name = "John Doe";
		this.password = "1900-01-01";
		this.email = "0766666666";
	}
	
	public int getID(){
		return this.id;
	}
	public void setID(int id){
		this.id = id;
	}
	
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public String getPassword(){
		return this.password;
	}
	public void setPassword(String pass){
		this.password = pass;
	}
	
	public String getEmail(){
		return this.email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	
	
}
