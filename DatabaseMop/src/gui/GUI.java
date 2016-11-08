package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.TableModelEvent;

import model.*;
import java.util.List;
import bussinessLogic.*;

@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener {
	private JPanel pPanel = new JPanel();
	private JPanel ptPanel = new JPanel();
	private JPanel cPanel = new JPanel();
	private JPanel ctPanel = new JPanel();
	private JPanel oPanel = new JPanel();
	private JPanel otPanel = new JPanel();
	private JPanel mPanel = new JPanel();
	private JPanel mtPanel = new JPanel();
	
	private JTable pTable = new JTable();
	private JScrollPane psTable = new JScrollPane();
	private JTable cTable = new JTable();
	private JScrollPane csTable = new JScrollPane();
	private JTable oTable = new JTable();
	private JScrollPane osTable = new JScrollPane();
	
	private JButton addP = new JButton("add product");
	private JButton delP = new JButton("delete product");
	private JButton upP = new JButton("update product");
	private JButton addC = new JButton("add client");
	private JButton delC = new JButton("delete client");
	private JButton upC = new JButton("update client");
	private JButton bill = new JButton("bill");
	private JButton order = new JButton("place order");
	
	private JLabel blank = new JLabel("");
	private JLabel blank2 = new JLabel("");
	private JLabel blank3 = new JLabel("");
	private JLabel blank4 = new JLabel("");
	private JLabel pIDLabel = new JLabel("ID:");
	private JTextField pID = new JTextField(50);
	private JLabel pNameLabel = new JLabel("Name:");
	private JTextField pName = new JTextField(50);
	private JLabel pPriceLabel = new JLabel("Price:");
	private JTextField pPrice = new JTextField(50);
	private JLabel pStockLabel = new JLabel("Stock:");
	private JTextField pStock = new JTextField(50);
	private JLabel cIDLabel = new JLabel("ID:");
	private JTextField cID = new JTextField(50);
	private JLabel cNameLabel = new JLabel("Name:");
	private JTextField cName = new JTextField(50);
	private JLabel cDateLabel = new JLabel("Date of Birth:");
	private JTextField cDate = new JTextField(50);
	private JLabel cPhoneLabel = new JLabel("Phone Number:");
	private JTextField cPhone = new JTextField(50);
	private JLabel countLabel = new JLabel("Count:");
	private JTextField count = new JTextField(50);
	
	private JLabel oIDLabel = new JLabel("ID:");
	private JComboBox<Integer> oID = new JComboBox<Integer>();
	private JLabel bpIDLabel = new JLabel("ID:");
	private JLabel bopIDLabel = new JLabel("Product ID:");
	private JComboBox<Integer> bpID = new JComboBox<Integer>();
	private JComboBox<Integer> bpID2 = new JComboBox<Integer>();
	private JLabel bcIDLabel = new JLabel("ID:");
	private JLabel bocIDLabel = new JLabel("Client ID:");
	private JComboBox<Integer> bcID = new JComboBox<Integer>();
	private JComboBox<Integer> bcID2 = new JComboBox<Integer>();
	private JLabel orderLabel = new JLabel ("New Order:");
	
	private JTextArea message = new JTextArea(100,50);
	private JScrollPane sMessage = new JScrollPane(message);
	
	public GUI(){
		this.setSize(1800,1000);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(4,2,10,10));
		
		ptPanel.setLayout(new GridLayout(1,1));
		pTable.getModel().addTableModelListener(pTable);
		pTable = getProductTable();
		psTable = new JScrollPane(pTable);
		ptPanel.add(psTable);
		this.add(ptPanel);
		pPanel.setLayout(new GridLayout(7,2,10,10));
		pPanel.setBackground(Color.WHITE);
		pPanel.add(pIDLabel);
		pPanel.add(pID);
		pPanel.add(pNameLabel);
		pPanel.add(pName);
		pPanel.add(pPriceLabel);
		pPanel.add(pPrice);
		pPanel.add(pStockLabel);
		pPanel.add(pStock);
		addP.addActionListener(this);
		pPanel.add(addP);
		pPanel.add(blank);
		pPanel.add(bpIDLabel);
		bpID = getProductIDs();
		pPanel.add(bpID);
		delP.addActionListener(this);
		pPanel.add(delP);
		upP.addActionListener(this);
		pPanel.add(upP);
		this.add(pPanel);
		
		ctPanel.setLayout(new GridLayout(1,1));
		cTable = getClientTable();
		csTable = new JScrollPane(cTable);
		ctPanel.add(csTable);
		this.add(ctPanel);
		cPanel.setLayout(new GridLayout(7,2,10,10));
		cPanel.setBackground(Color.WHITE);
		cPanel.add(cIDLabel);
		cPanel.add(cID);
		cPanel.add(cNameLabel);
		cPanel.add(cName);
		cPanel.add(cDateLabel);
		cPanel.add(cDate);
		cPanel.add(cPhoneLabel);
		cPanel.add(cPhone);
		addC.addActionListener(this);
		cPanel.add(addC);
		cPanel.add(blank2);
		cPanel.add(bcIDLabel);
		bcID = getClientIDs();
		cPanel.add(bcID);
		delC.addActionListener(this);
		cPanel.add(delC);
		upC.addActionListener(this);
		cPanel.add(upC);
		this.add(cPanel);
		
		
		otPanel.setLayout(new GridLayout(1,1));
		oTable = getOrderTable();
		osTable = new JScrollPane(oTable);
		otPanel.add(osTable);
		this.add(otPanel);
		oPanel.setLayout(new GridLayout(7,2,10,10));
		oPanel.setBackground(Color.WHITE);
		oPanel.add(oIDLabel);
		oID = getOrderIDs();
		oPanel.add(oID);
		bill.addActionListener(this);
		oPanel.add(bill);
		this.add(oPanel);
		
		mtPanel.setLayout(new GridLayout(7,2,10,10));
		mtPanel.setBackground(Color.WHITE);
		mtPanel.add(orderLabel);
		mtPanel.add(blank3);
		mtPanel.add(bocIDLabel);
		bcID2 = getClientIDs();
		mtPanel.add(bcID2);
		mtPanel.add(bopIDLabel);
		bpID2 = getProductIDs();
		mtPanel.add(bpID2);
		mtPanel.add(countLabel);
		mtPanel.add(count);
		mtPanel.add(blank4);
		order.addActionListener(this);
		mtPanel.add(order);
		this.add(mtPanel);
		mPanel.setLayout(new GridLayout(1,1,10,10));
		mPanel.setBackground(Color.WHITE);
		message.setEditable(false);
		mPanel.add(sMessage);
		this.add(mPanel);
		
		this.setVisible(true);
	}
	
	
	public JComboBox<Integer> getOrderIDs(){
		List<Order> orders = new OrderBL().getData();
		Integer[] IDs = new Integer[500];
		int i=0;
		for (Order o : orders){
			IDs[i] = o.getID();
			i++;
		}
		return new JComboBox<Integer>(IDs);
	}
	
	public JComboBox<Integer> getClientIDs(){
		List<Client> clients = new ClientBL().getData();
		Integer[] IDs = new Integer[500];
		int i=0;
		for (Client c : clients){
			IDs[i] = c.getID();
			i++;
		}
		return new JComboBox<Integer>(IDs);
	}
	
	public JComboBox<Integer> getProductIDs(){
		List<Product> products = new ProductBL().getData();
		Integer[] IDs = new Integer[500];
		int i=0;
		for (Product p : products){
			IDs[i] = p.getID();
			i++;
		}
		return new JComboBox<Integer>(IDs);
	}
	
	public JTable getOrderTable(){
		List<Order> orders = new OrderBL().getData();
		Object columnNames[]={"ID","ClientID","ProductID","Count"};
		Object rowData[][] = new Object[500][500];
		int i=0;
		for (Order o : orders){
			rowData[i][0] = o.getID();
			rowData[i][1] = o.getClientID();
			rowData[i][2] = o.getProductID();
			rowData[i][3] = o.getCount();
			i++;
		}
		return new JTable(rowData,columnNames);
	}
	
	public JTable getClientTable(){
		List<Client> clients = new ClientBL().getData();
		Object columnNames[]={"ID","Name","birthDate","phoneNumber"};
		Object rowData[][] = new Object[500][500];
		int i=0;
		for (Client c : clients){
			rowData[i][0] = c.getID();
			rowData[i][1] = c.getName();
			rowData[i][2] = c.getBirthDate();
			rowData[i][3] = c.getPhone();
			i++;
		}
		return new JTable(rowData,columnNames);
	}
	
	public JTable getProductTable(){
		List<Product> products = new ProductBL().getData();
		Object columnNames[]={"ID","Name","Price","Stock"};
		Object rowData[][] = new Object[500][500];
		int i=0;
		for (Product p : products){
			rowData[i][0] = p.getID();
			rowData[i][1] = p.getName();
			rowData[i][2] = p.getPrice();
			rowData[i][3] = p.getStock();
			i++;
		}
		return new JTable(rowData,columnNames);
	}
	public void tableChanged(TableModelEvent e) {
		pTable.repaint();
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addP){
			ProductBL newProduct = new ProductBL(new Product(Integer.parseInt(pID.getText()),pName.getText(),Integer.parseInt(pPrice.getText()),Integer.parseInt(pStock.getText())));
			newProduct.addData();
			@SuppressWarnings("unused")
			GUI newGUI = new GUI();
			this.dispose();
		}
		if (e.getSource() == delP){
			ProductBL newProduct = new ProductBL(new Product());
			newProduct.deleteData((int)bpID.getSelectedItem());
			@SuppressWarnings("unused")
			GUI newGUI = new GUI();
			this.dispose();
		}
		if (e.getSource() == upP){
			ProductBL newProduct = new ProductBL(new Product(Integer.parseInt(pID.getText()),pName.getText(),Integer.parseInt(pPrice.getText()),Integer.parseInt(pStock.getText())));
			newProduct.updateData((int)bpID.getSelectedItem());
			@SuppressWarnings("unused")
			GUI newGUI = new GUI();
			this.dispose();
		}
		if (e.getSource() == addC){
			ClientBL newClient = new ClientBL(new Client(Integer.parseInt(cID.getText()),cName.getText(),cDate.getText(),cPhone.getText()));
			newClient.addData();
			@SuppressWarnings("unused")
			GUI newGUI = new GUI();
			this.dispose();
		}
		if (e.getSource() == delC){
			ClientBL newClient = new ClientBL(new Client());
			newClient.deleteData((int)bcID.getSelectedItem());
			@SuppressWarnings("unused")
			GUI newGUI = new GUI();
			this.dispose();
		}
		if (e.getSource() == upC){
			ClientBL newClient = new ClientBL(new Client(Integer.parseInt(cID.getText()),cName.getText(),cDate.getText(),cPhone.getText()));
			newClient.updateData((int)bcID.getSelectedItem());
			@SuppressWarnings("unused")
			GUI newGUI = new GUI();
			this.dispose();
		}
		if (e.getSource() == order){
			OrderBL newOrder = new OrderBL(new Order(0,(int)bcID2.getSelectedItem(),(int)bpID2.getSelectedItem(),Integer.parseInt(count.getText())));
			int success = newOrder.addData();
			if(success == 1){
				
				
			@SuppressWarnings("unused")
			GUI newGUI = new GUI();
			this.dispose();
			}
			else if (success == -1) message.setText("Understock");
		}
		if (e.getSource() == bill){
			OrderBL newOrder = new OrderBL();
			newOrder.bill((int) oID.getSelectedItem());
		}
	}
	
}
