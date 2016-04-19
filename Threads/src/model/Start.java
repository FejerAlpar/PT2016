package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start {
	private InputFrame frame;
	public Start(){
		frame = new InputFrame();
		frame.addButtonListener(new ButtonListener());
		
	}
	public static void main(String[] args){
		new Start();
		
	}
	class ButtonListener implements ActionListener{
		

		@Override
		public void actionPerformed(ActionEvent e) {
			Simulator sim = new Simulator(frame.getFT(),frame.getFreq(),frame.getMin(),frame.getMax(),frame.getMinReg(),frame.getMaxReg());
			Thread th = new Thread(sim);
			th.start();
			
		}
	}
}
