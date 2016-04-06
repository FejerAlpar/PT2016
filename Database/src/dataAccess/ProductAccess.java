package dataAccess;

import model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class ProductAccess {
	
	private ResultSet rs;
	private Product myProduct;
	private Statement st;
	
	public ProductAccess(Product product){
		this.myProduct = product;
	}
	public ProductAccess(){
		this.myProduct = new Product();
		this.st = DB.getStatement();
	}
	
	public void addData(){
	    try {
	    	String query = " insert into products (id, name, price, stock)"
	    	        + " values (?, ?, ?, ?)";
	    	PreparedStatement addQuery = DB.connection.prepareStatement(query);
	    	addQuery.setInt(1, myProduct.getID());
	    	addQuery.setString(2, myProduct.getName());
	    	addQuery.setInt(3, myProduct.getPrice());
	    	addQuery.setInt(4, myProduct.getStock());
	    	addQuery.execute();
	    }
	    catch (SQLException e){
	    	System.out.println(e.getMessage());
	    }
	}
	
	public void deleteData(int myID){
		try{
			String query = "delete from products where id = ?";
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
			String query = "update products set id=?, name=?,price=?,stock=? where id = ?";
			PreparedStatement updateQuery = DB.connection.prepareStatement(query);
			updateQuery.setInt(1, myProduct.getID());
			updateQuery.setString(2, myProduct.getName());
			updateQuery.setInt(3, myProduct.getPrice());
			updateQuery.setInt(4, myProduct.getStock());
			updateQuery.setInt(5, myID);
			updateQuery.execute();
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
	}
	
	public List<Product> getData(){
		List<Product> products = new ArrayList<Product>();

		try{
		String query = "select * from products order by id";
		rs = st.executeQuery(query);
		while(rs.next()){
			Product newProduct = new Product();
			newProduct.setID(rs.getInt("id"));
			newProduct.setName(rs.getString("name"));
			newProduct.setPrice(rs.getInt("price"));
			newProduct.setStock(rs.getInt("stock"));
			products.add(newProduct);
		}
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
		return products;
	}
}
