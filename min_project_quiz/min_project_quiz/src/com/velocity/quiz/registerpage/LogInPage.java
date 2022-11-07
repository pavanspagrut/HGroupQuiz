package com.velocity.quiz.registerpage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.velocity.quiz.QuestionPage.Questions;
import com.velocity.quiz.connection.JdbcConnection;

public class LogInPage {
	Scanner sc = new Scanner(System.in);

	JdbcConnection connection = new JdbcConnection();

	public void logIn() throws ClassNotFoundException, SQLException {
		System.out.println("Enter user name :");
		String username = sc.next();
		System.out.println("Enter password :");
		String password = sc.next();

		verifyUser(username, password);

	}

	private void verifyUser(String username, String password) throws ClassNotFoundException, SQLException {

		PreparedStatement ps = connection.getConnection().prepareStatement("select * from user where username=? ");

		ps.setString(1, username);

		ResultSet rs = ps.executeQuery();
		String username1 = "";
		String password1 = "";
		while (rs.next()) {

			username1 = rs.getString("username");
			password1 = rs.getString("userpassword");

		}
		
		rs.close();

		if (username1.equals(username)&& password1.equals(password)) {

			System.out.println("Login successfull....");
			
			System.out.println("Welcome to Quizz Contest....");
			
			Questions ques= new Questions();
			ques.getQuestions();
			
		} 
		
		else {
			System.out.println("Username or Password is Incorrect.");
			logIn();
		}

	}

}
