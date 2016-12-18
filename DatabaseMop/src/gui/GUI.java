package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;

import bussinessLogic.AccountBL;
import model.Account;

@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener {
	private JPanel cPanel = new JPanel();
	private JPanel ctPanel = new JPanel();
	
	private JTable pTable = new JTable();
	private JTable cTable = new JTable();
	private JScrollPane csTable = new JScrollPane();
	private JButton addC = new JButton("add account");
	private JButton delC = new JButton("delete account");
	private JButton upC = new JButton("update account");
	
	private JLabel blank2 = new JLabel("");
	private JLabel cIDLabel = new JLabel("ID:");
	private JTextField cID = new JTextField(50);
	private JLabel cNameLabel = new JLabel("Name:");
	private JTextField cName = new JTextField(50);
	private JLabel cDateLabel = new JLabel("Date of Password:");
	private JTextField cDate = new JTextField(50);
	private JLabel cPhoneLabel = new JLabel("Phone Number:");
	private JTextField cPhone = new JTextField(50);
	private JLabel bcIDLabel = new JLabel("ID:");
	private JComboBox<Integer> bcID = new JComboBox<Integer>();
	
	
	public GUI(){
		this.setSize(1800,1000);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(4,2,10,10));
	
		ctPanel.setLayout(new GridLayout(1,1));
//		cTable = getAccountTable();
//		csTable = new JScrollPane(cTable);
//		ctPanel.add(csTable);
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
//		bcID = getAccountIDs();
		cPanel.add(bcID);
		delC.addActionListener(this);
		cPanel.add(delC);
		upC.addActionListener(this);
		cPanel.add(upC);
		this.add(cPanel);
		
		this.setVisible(true);
	}
	
	public JComboBox<Integer> getAccountIDs(){
		List<Account> accounts = new AccountBL().getData();
		Integer[] IDs = new Integer[500];
		int i=0;
		for (Account c : accounts){
			IDs[i] = c.getID();
			i++;
		}
		return new JComboBox<Integer>(IDs);
	}
	
	public JTable getAccountTable(){
		List<Account> accounts = new AccountBL().getData();
		Object columnNames[]={"ID","Name","Email","Password"};
		Object rowData[][] = new Object[500][500];
		int i=0;
		for (Account c : accounts){
			rowData[i][0] = c.getID();
			rowData[i][1] = c.getName();
			rowData[i][2] = c.getPassword();
			rowData[i][3] = c.getEmail();
			i++;
		}
		return new JTable(rowData,columnNames);
	}
	
	public void tableChanged(TableModelEvent e) {
		pTable.repaint();
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == addC){
			AccountBL newAccount = new AccountBL(new Account(Integer.parseInt(cID.getText()),cName.getText(),cDate.getText(),cPhone.getText()));
			newAccount.addData();
			@SuppressWarnings("unused")
			GUI newGUI = new GUI();
			this.dispose();
		}
		if (e.getSource() == delC){
			AccountBL newAccount = new AccountBL(new Account());
			newAccount.deleteData((int)bcID.getSelectedItem());
			@SuppressWarnings("unused")
			GUI newGUI = new GUI();
			this.dispose();
		}
		if (e.getSource() == upC){
			AccountBL newAccount = new AccountBL(new Account(Integer.parseInt(cID.getText()),cName.getText(),cDate.getText(),cPhone.getText()));
			newAccount.updateData((int)bcID.getSelectedItem());
			@SuppressWarnings("unused")
			GUI newGUI = new GUI();
			this.dispose();
		}	
	}	
}
