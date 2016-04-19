package model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import model.Simulator;
public class Server implements Runnable {

	private BlockingQueue<Task> bq;
	private AtomicInteger waitingTime;
	private int size;
	public Server() {
		bq = new LinkedBlockingQueue<>();
		waitingTime = new AtomicInteger(0);
	}

	void addTask(Task t) {
		bq.add(t);
		waitingTime.addAndGet(t.getProcessTime());
		size++;
	}

	
	public Task[] getTasks() {
		Task[] tasks = new Task[bq.size()];
		bq.toArray(tasks);
		return tasks;
	}

	public int getNo(){
		return size;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Task t = bq.take();

				
				Thread.sleep(t.getProcessTime() * 1000);
				waitingTime.addAndGet((-1) * t.getProcessTime());
				Simulator.getFrame().displayData("Client "+t.getNr()+" left. \n");
				size--;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		if (bq.isEmpty()) return new String("");
		else{
		for (Task t : bq) {
			sb.append(t.toString());
			sb.append(" ");
		}
		return sb.toString();
		}
	}
	
}
