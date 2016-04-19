package model;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class InputFrame extends JFrame{


	private JPanel panel2 = new JPanel();
	private JTextField fin = new JTextField(25);
	private JLabel finLabel = new JLabel("Finish time:");
	private JTextField minReg = new JTextField(25);
	private JLabel minRegLabel = new JLabel("Min number of registers: ");
	private JTextField maxReg = new JTextField(25);
	private JLabel maxRegLabel = new JLabel("Max number of registers: ");
	private JTextField clientFreq = new JTextField(25);
	private JLabel clientFreqLabel = new JLabel("Client frequency: ");
	private JLabel minTimeLabel = new JLabel("Min waiting time: ");
	private JTextField minTime = new JTextField(25);
	private JLabel maxTimeLabel = new JLabel("Max waiting time: ");
	private JTextField maxTime = new JTextField(25);
	private JLabel blank = new JLabel("");
	private JButton start = new JButton("Start");

	public InputFrame(){
		this.setSize(1500,1000);
		this.setLayout(new GridLayout(1,2));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		

		panel2.setSize(500,1000);
		panel2.setLayout(new GridLayout(30,2));
		panel2.add(finLabel);
		panel2.add(fin);
		panel2.add(minRegLabel);
		panel2.add(minReg);
		panel2.add(maxRegLabel);
		panel2.add(maxReg);
		panel2.add(clientFreqLabel);
		panel2.add(clientFreq);
		panel2.add(minTimeLabel);
		panel2.add(minTime);
		panel2.add(maxTimeLabel);
		panel2.add(maxTime);
		panel2.add(blank);
		panel2.add(start);

		panel2.setVisible(true);
		
		this.add(panel2);
		this.setVisible(true);
		
	}
	
	int getFT(){
		return Integer.parseInt(fin.getText());
	}
	int getMinReg(){
		return Integer.parseInt(minReg.getText());
	}
	int getMaxReg(){
		return Integer.parseInt(maxReg.getText());
	}
	int getFreq(){
		return Integer.parseInt(clientFreq.getText());
	}
	int getMin(){
		return Integer.parseInt(minTime.getText());
	}
	int getMax(){
		return Integer.parseInt(maxTime.getText());
	}
	
	void addButtonListener(ActionListener bal) {
		
        start.addActionListener(bal);
    }

	
	
	
}
