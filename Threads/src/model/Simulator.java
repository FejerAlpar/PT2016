package model;

public class Simulator implements Runnable {

	private Scheduler sch;
	public static SimulatorFrame frame;
	private int minProcessTime;
	private int maxProcessTime;
	private int finishedTime;
	private int freq;
	private int minReg;
	private int maxReg;
	public Simulator(int ft, int freq, int minT, int maxT, int minR, int maxR){
		minReg = minR;
		maxReg = maxR;
		finishedTime = ft;
		minProcessTime = minT;	
		maxProcessTime = maxT;
		this.freq = freq;
		frame = new SimulatorFrame();
		sch = new Scheduler(minReg);
		
	}
	
	public static SimulatorFrame getFrame(){
		return frame;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int currentTime = 0;
		int nr = 1;
		while (currentTime < finishedTime){
			currentTime++;
			frame.displayData2(sch.toString());
			//for (int j=0; j<sch.getNo(); j++) if (sch.getServer(j).getNo() == 0 && sch.getNo() > minReg) {
			//	sch.deleteServer(j);
				//j++;
			//	frame.displayData("Register "+j+" closed.\n");
			//	j--;
			//}
			if ((currentTime % freq == 0)){
				int i = 0;
				
				
				for(int j = 1; j<sch.getNo(); j++) if (sch.getServer(j).getNo()<sch.getServer(i).getNo()) i=j;
				int processTime = (int)(Math.random()*(maxProcessTime-minProcessTime)+minProcessTime);
				Task t = new Task(currentTime,processTime,nr);
				nr++;
				if (sch.getServer(i).getNo()>3 && sch.getNo()<maxReg){
					sch.addServer();
					i+=2;
					frame.displayData("Register "+sch.getNo()+" opened.\n");
					sch.dispatchTaskOnSever(t,i);
				}
				else{
					sch.dispatchTaskOnSever(t,i);
				}
				i++;
				
				frame.displayData("Client "+t.getNr()+" arrived to register "+i+". Arrival time: "+t.getArrivalTime()+". Process time: "+t.getProcessTime()+".\n");
			
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
		
	}

	

}
