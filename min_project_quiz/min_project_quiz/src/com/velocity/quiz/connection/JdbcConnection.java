package com.velocity.quiz.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    public Connection getConnection() throws ClassNotFoundException,SQLException{
    	 
    	Class.forName("com.mysql.jdbc.Driver");
    	 
    	Connection con = DriverManager.getConnection
    			("jdbc:mysql://localhost:3306/quiz","root","root");
    	
    	return con;
    	
    }
}
