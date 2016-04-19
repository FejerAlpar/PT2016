package model;

public class Task {

	private int arrivalTime;
	private int processTime;
	private int nr;
	public Task(int aT, int pT,int nr){
		this.arrivalTime = aT;
		this.processTime = pT;
		this.setNr(nr);
	}
	
	public int getArrivalTime(){
		return this.arrivalTime;
	}
	public void setArrivalTime(int time){
		this.arrivalTime = time;
	}
	
	public int getProcessTime(){
		return this.processTime;
	}
	public void setProcessTime(int time){
		this.processTime = time;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Client"+nr;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}
}
