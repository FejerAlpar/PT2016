package model;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class SimulatorFrame extends JFrame{
	private JPanel panel = new JPanel();
	private JScrollPane sp;
	private JTextArea ta;
	private JPanel panel2 = new JPanel();
	private JScrollPane sp2;
	private JTextArea ta2;
	
	public SimulatorFrame(){
		this.setSize(1500,1000);
		this.setLayout(new GridLayout(1,2));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel.setLayout(new GridLayout(1,1));
		panel2.setLayout(new GridLayout(1,1));
		ta = new JTextArea(10,10);
		ta2 = new JTextArea(10,10);
		sp = new JScrollPane(ta);
		sp2 = new JScrollPane(ta2);
		panel.add(sp);
		panel2.add(sp2);
		this.add(panel);
		this.add(panel2);
		this.setVisible(true);
		
	}
	
	public void displayData(String s){
		panel.removeAll();
		panel.revalidate();
		ta.append(s);
		sp = new JScrollPane(ta);
		panel.add(sp);
		panel.repaint();
		panel.revalidate();
	}
	public void displayData2(String s){
		panel2.removeAll();
		panel2.revalidate();
		ta2.setText(s);
		sp2 = new JScrollPane(ta2);
		panel2.add(sp2);
		panel2.repaint();
		panel2.revalidate();
	}

	
}
