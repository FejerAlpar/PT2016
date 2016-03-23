package polynomial.gui;

import java.awt.event.*;
import javax.swing.*;
import polynomial.logic.*;
import polynomial.model.*;

@SuppressWarnings("serial")
public class Gui extends JFrame implements ActionListener{

	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	
	private JButton derive = new JButton("Derive");
	private JButton integrate = new JButton("Integrate");
	private JButton add = new JButton("+");
	private JButton subtract = new JButton("-");
	private JButton multiply = new JButton("*");
	private JButton divide = new JButton("/");
	
	private JLabel po1 = new JLabel("Polynomial 1:");
	private JLabel po2 = new JLabel("Polynomial 2:");
	private JLabel re = new JLabel("Result:");
	
	private JTextField pol1 = new JTextField(50);
	private JTextField pol2 = new JTextField(50);
	private JTextArea res = new JTextArea(2,50);
	
	
	public Gui(){
		this.setSize(1000, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		derive.addActionListener(this);
		integrate.addActionListener(this);
		add.addActionListener(this);
		subtract.addActionListener(this);
		multiply.addActionListener(this);
		divide.addActionListener(this);
		integrate.addActionListener(this);
		derive.addActionListener(this);
		
		panel1.add(po1);
		panel1.add(pol1);
		panel1.add(derive);
		panel1.add(integrate);
		panel1.setVisible(true);
		this.add(panel1,"North");
		
		panel2.add(po2);
		panel2.add(pol2);
		panel2.add(add);
		panel2.add(subtract);
		panel2.add(multiply);
		panel2.add(divide);
		panel2.setVisible(true);
		this.add(panel2,"Center");
		
		panel3.add(re);
		res.setEditable(false);
		panel3.add(res);
		panel3.setVisible(true);
		this.add(panel3,"South");
		
		this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add){
			res.setText(Operation.add(new Polynomial(pol1.getText()), new Polynomial(pol2.getText())).toString());
		}
		if (e.getSource() == integrate){
			res.setText(Operation.integrate(new Polynomial(pol1.getText())).toString());
		}
		if (e.getSource() == divide){
			res.setText(Operation.divide(new Polynomial(pol1.getText()), new Polynomial(pol2.getText())).toString());
		}
		if (e.getSource() == derive){
			res.setText(Operation.derive(new Polynomial(pol1.getText())).toString());
		}
		if (e.getSource() == subtract){
			res.setText(Operation.sub(new Polynomial(pol1.getText()), new Polynomial(pol2.getText())).toString());
		}
		if (e.getSource() == multiply){
			res.setText(Operation.multiply(new Polynomial(pol1.getText()), new Polynomial(pol2.getText())).toString());
		}
	}
}
