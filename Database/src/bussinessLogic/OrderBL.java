package bussinessLogic;
import java.io.*;
import java.util.List;
import dataAccess.OrderAccess;
import model.*;

public class OrderBL {

	private Order myOrder;
	private OrderAccess access;
	
	public OrderBL(Order order){
		myOrder = order;
		myOrder.setID(getNextID());
	}
	public OrderBL(){
		myOrder = new Order();
	}
	
	
	private int getNextID(){
		access = new OrderAccess();
		List<Order> orders = access.getData();
		return orders.get(orders.size()-1).getID()+1;
}
	
	public int addData(){
		if (this.checkData()){
			if (myOrder.getCount() > ProductBL.getCount(myOrder.getProductID()))
				return -1;
			else{
				access = new OrderAccess(myOrder);
				access.addData();
				ProductBL.setStock(myOrder.getProductID(),myOrder.getCount());
				return 1;
			}
		}
		else return 0;
	}

	public void bill(int id){
		List<Order> orders = this.getData();
		for (Order o : orders)
			if (o.getID() == id){
				try{
				FileWriter fileWriter = new FileWriter("bill.txt");
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				bufferedWriter.write("Order ID: ");
				bufferedWriter.write(String.valueOf(id));
				bufferedWriter.newLine();
				bufferedWriter.write("Client Name: ");
				bufferedWriter.write(ClientBL.getName(o.getClientID()));
				bufferedWriter.write(" Client phone number: ");
				bufferedWriter.write(ClientBL.getPhone(id));
				bufferedWriter.newLine();
				bufferedWriter.write("Product name: ");
				bufferedWriter.write(ProductBL.getName(id));
				bufferedWriter.write(" Unit price: ");
				bufferedWriter.write(String.valueOf(ProductBL.getPrice(id)));
				bufferedWriter.write(" Count: ");
				bufferedWriter.write(String.valueOf(o.getCount()));
				bufferedWriter.newLine();
				bufferedWriter.write("Total: ");
				bufferedWriter.write(String.valueOf(o.getCount()*ProductBL.getPrice(id)));
				bufferedWriter.close();
				}
				catch (IOException e){
					System.out.println(e.getMessage());
				}
			}
	}
	
	private boolean checkData(){
		if (myOrder.getID() < 1) return false;
		if (myOrder.getClientID() < 1) return false;
		if (myOrder.getProductID() < 1) return false;
		if (myOrder.getCount() < 1) return false;
		return true;
	}
	public List<Order> getData(){
		access = new OrderAccess();
		List<Order> orders = access.getData();
		return orders;
	}
	
}