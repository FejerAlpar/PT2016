package bussinessLogic;

import dataAccess.*;
import model.Product;

import java.util.List;

public class ProductBL {

	private Product myProduct;
	private static ProductAccess access;
	
	public ProductBL(Product product){
		myProduct = product;
	}
	public ProductBL(){
		myProduct = new Product();
	}
	

	
	public void addData(){
		if (this.checkData()){
			access = new ProductAccess(myProduct);
			access.addData();
		}
	}
	
	public void deleteData(int myID){
	
		access = new ProductAccess(myProduct);
		access.deleteData(myID);
	
	}
			
	public void updateData(int myID){
		
		access = new ProductAccess(myProduct);
		access.updateData(myID);
	}
	
	public static int getCount(int id){
		access = new ProductAccess();
		List<Product> products = access.getData();
		for (Product p : products) 
			if (p.getID() == id) return p.getStock();
		return 0;
	}
	public static String getName(int id){
		access = new ProductAccess();
		List<Product> products = access.getData();
		for (Product p : products) 
			if (p.getID() == id) return p.getName();
		return "";
	}
	public static int getPrice(int id){
		access = new ProductAccess();
		List<Product> products = access.getData();
		for (Product p : products) 
			if (p.getID() == id) return p.getPrice();
		return 0;
	}
	
	public static void  setStock(int id, int count){
		access = new ProductAccess();
		List<Product> products = access.getData();
		for (Product p : products) 
			if (p.getID() == id){
				p.setStock(p.getStock()-count);
				ProductBL stock = new ProductBL(p);
				stock.updateData(p.getID());
			};
	}
	
	public List<Product> getData(){
		access = new ProductAccess();
		List<Product> products = access.getData();
		return products;
	}
	

	
	private boolean checkData(){
		if (myProduct.getID() < 1) return false;
		if (myProduct.getPrice() <=0) return false;
		if (myProduct.getStock() < 0) return false;
		return true;
	}
	
}
