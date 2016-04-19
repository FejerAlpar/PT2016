package model;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {

	private List<Server> servers;//list

	public Scheduler(int n){
		servers = new ArrayList<Server>(n);
		for (int i=0; i<n; i++) servers.add(new Server());
		for (Server s : servers){
			Thread th = new Thread(s);
			th.start();
		}
	}
	
	public void addServer(){
		Server s = new Server();
		servers.add(s);
		Thread th = new Thread(s);
		th.start();
	}
	
	public void dispatchTaskOnSever(Task t, int i){
		Server s = servers.get(i);
		s.addTask(t);
	}
	
	public int getNo(){
		return servers.size();
	}
	
	public Server getServer(int i) {
		return servers.get(i);
	}

	public void setServer(Server server, int i) {
		this.servers.set(i, server);
	}
	public void deleteServer(int i){
		servers.remove(i);
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		if (servers.isEmpty()) return new String("");
		else{
			int i=1;
		for (Server s : servers) {
			sb.append("Register");
			sb.append(i);
			i++;
			sb.append(": ");
			sb.append(s.toString());
			sb.append("\n");
		}
		return sb.toString();
		}
	}
	
}
