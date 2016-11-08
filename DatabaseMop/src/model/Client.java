package model;

public class Client {

	private int id;
	private String name;
	private String birthDate;
	private String phone;
	
	public Client(int id, String name, String birthDate, String phone){
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.phone = phone;
	}
	public Client(){
		this.id = 1;
		this.name = "Name";
		this.birthDate = "1969-05-14";
		this.phone = "0766666666";
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
	
	public String getBirthDate(){
		return this.birthDate;
	}
	public void setBirthDate(String date){
		this.birthDate = date;
	}
	
	public String getPhone(){
		return this.phone;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	
	
}
