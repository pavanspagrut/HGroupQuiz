package com.velocity.quiz.QuestionPage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.velocity.quiz.connection.JdbcConnection;

import java.util.Random;

public class Questions {
	
	JdbcConnection connection= new JdbcConnection();
	Scanner sc = new Scanner(System.in);
	
	public void getQuestions() throws ClassNotFoundException, SQLException {
		
		int count=0;
		
		PreparedStatement ps = connection.getConnection().prepareStatement("select * from QuizQuestions order by rand() ASC limit ?");
		
		
		ps.setInt(1, 1 );
		
		ResultSet rs= ps.executeQuery();
		int id = 1;
		String question="";
		String option="";
		String correctAns="";
		
 
		
	while( rs.next()) {
			id = rs.getInt("question_id");
			question = rs.getString("Question");
			option= rs.getString("mcq");
			correctAns=rs.getString("correctAns");
			
		
	}
		    System.out.println("No >>"+id);
			System.out.println("question >> "+question);
			System.out.println("Options >> "+option);
			  System.out.println("Enter your Answer >> ");
			    String userInput=sc.nextLine().toLowerCase();
			    
		      if(userInput.equals(correctAns)) {
		    	System.out.println("Your answer is Correct.");
		    	count++;
		    	getQuestions();
		    }
		      else
		    {
		    	System.out.println("Your answer is wrong.");
		    	getQuestions();
		    }
			 
		
		rs.close();
		ps.close();
		/*
		System.out.println("question >> "+question);
		System.out.println("Options >> "+option);
	    System.out.println("Enter your Answer >> ");
	    String userInput=sc.nextLine().toLowerCase();
	    
	    
	    if(userInput.equals(correctAns)) {
	    	count++;
	   // getQuestions();
	    
	    }else
	    {
	    	System.out.println("Your answer is wrong.");
	    }*/

		
	    
	    System.out.println("Your score is >> "+count);
	   // System.out.println("user name >> "+userDetail);
	}

}
