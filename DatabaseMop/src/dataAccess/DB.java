package dataAccess;


import java.sql.*;
 
public class DB {
    //static reference to itself
    private static DB instance = new DB();
    protected static Statement st;
    protected static Connection connection;
    public static final String URL = "jdbc:mysql://localhost:3306/ecommerce";
    public static final String USER = "root";
    public static final String PASSWORD = "";
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver"; 
     
    //private constructor
    public DB() {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
     
    private Connection createConnection() {
       
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            st = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("ERROR: Unable to Connect to Database.");
        }
        return connection;
    }   
     
    public static Connection getConnection() {
        return instance.createConnection();
    }
    
    public static Statement getStatement(){
    	return st;
    }
}