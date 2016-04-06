package dataAccess;


import model.Order;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class OrderAccess {

	private Order myOrder;
	private ResultSet rs;
	private Statement st;
	
	public OrderAccess(Order order){
		this.myOrder = order;
	}
	public OrderAccess(){
		this.myOrder = new Order();
		this.st = DB.getStatement();
	}
	
	public void addData(){
		try{
		String query = " insert into orders (ID, ClientID, ProductID, Count)"
    	        + " values (?, ?, ?, ?)";
		PreparedStatement addQuery = DB.connection.prepareStatement(query);
    	addQuery.setInt(1, myOrder.getID());
    	addQuery.setInt(2, myOrder.getClientID());
    	addQuery.setInt(3, myOrder.getProductID());
    	addQuery.setInt(4, myOrder.getCount());
    	addQuery.execute();
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
	}
	
	public List<Order> getData(){
		List<Order> orders = new ArrayList<Order>();

		try{
		String query = "select * from orders order by ID";
		rs = st.executeQuery(query);
		while(rs.next()){
			Order newOrder = new Order();
			newOrder.setID(rs.getInt("ID"));
			newOrder.setClientID(rs.getInt("ClientID"));
			newOrder.setProductID(rs.getInt("ProductID"));
			newOrder.setCount(rs.getInt("Count"));
			orders.add(newOrder);
		}
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
		return orders;
	}

	
}