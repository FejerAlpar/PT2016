package model;


import dataAccess.DB;
import gui.*;

public class Main {
	
	public static void main(String[] args){
		
		@SuppressWarnings("unused")
		DB myDB = new DB();
		DB.getConnection();
		@SuppressWarnings("unused")
		GUI myGUI = new GUI();
}
}
