package model;

public class Order {

	private int id;
	private int clientID;
	private int productID;
	private int count;
	
	public Order(int id, int cid, int pid, int count){
		this.id = id;
		this.clientID = cid;
		this.productID = pid;
		this.count = count;
	}
	public Order(){
		this.id = 1;
		this.clientID = 1;
		this.productID = 1;
		this.count = 0;
	}
	
	public int getID(){
		return this.id;
	}
	public void setID(int id){
		this.id = id;
	}
	
	public int getClientID(){
		return this.clientID;
	}
	public void setClientID(int id){
		this.clientID = id;
	}
	
	public int getProductID(){
		return this.productID;
	}
	public void setProductID(int id){
		this.productID = id;
	}
	
	public int getCount(){
		return this.count;
	}
	public void setCount(int count){
		this.count=count;
	}
}
