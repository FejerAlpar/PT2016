package model;

public class Product {

	private int id;
	private String name;
	private int price;
	private int stock;
	
	public Product(int id, String name, int price, int stock){
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	public Product(){
		this.id = 1;
		this.name = "Name";
		this.price = 1;
		this.stock = 0;
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
	
	public int getPrice(){
		return this.price;
	}
	public void setPrice(int price){
		this.price = price;
	}
	
	public int getStock(){
		return this.stock;
	}
	public void setStock(int stock){
		this.stock = stock;
	}
	
}
