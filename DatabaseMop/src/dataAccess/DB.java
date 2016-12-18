package dataAccess;


import java.sql.*;
 
public class DB {
    //static reference to itself
    private static DB instance = new DB();
    protected static Statement st;
    protected static Connection connection;
    public static final String URL = "jdbc:sqlserver://JD-PC:1433;integratedSecurity=true;";
    public static final String DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 

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
            connection = DriverManager.getConnection(URL, "sa", "secret");
            st = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Error connecting to database");
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