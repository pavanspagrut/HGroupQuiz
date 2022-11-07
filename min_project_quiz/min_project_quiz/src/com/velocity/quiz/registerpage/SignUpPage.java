package com.velocity.quiz.registerpage;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.velocity.quiz.connection.JdbcConnection;

public class SignUpPage {

	Scanner sc = new Scanner(System.in);
	
	JdbcConnection connection= new JdbcConnection();

	public void signUp() throws ClassNotFoundException, SQLException {
		
		System.out.println("Enter your first name :");
		String firstName = sc.next();
		System.out.println("Enter your last name :");
		String lastName = sc.next();
		System.out.println("Set your User name :");
		String userName = sc.next();
		System.out.println("Set your Password :");
		String password = sc.next();
		
		PreparedStatement ps= connection.getConnection().prepareStatement
				("insert into user(userFirstName,userLastName,username,userpassword) values (?,?,?,?)");
		
		ps.setString(1, firstName);
		ps.setString(2,lastName);
		ps.setString(3, userName);
		ps.setString(4, password);
		
		ps.executeUpdate();
		
		System.out.println("Registeration successfull.");
		
		ps.close();
		
		System.out.println("Login Yourself....");
		System.out.println(" ");
		
		LogInPage login= new LogInPage();
		login.logIn();

	}

}
