package com.velocity.quiz.registerpage;

import java.sql.SQLException;
import java.util.Scanner;

public class WelcomePage {
	
	Scanner sc= new Scanner(System.in);
	
	public void welcomePage() throws ClassNotFoundException, SQLException {
	System.out.println("=-=-=-=-=-=- WELL-COME TO QUIZ CONTEST -=-=-=-=-=-");
	System.out.println(" ");
	
	System.out.println("For sign up : Enter 1 ");
	System.out.println("For log in : Enter 2 ");
	
	System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	
	System.out.println("Enter your response :");
	int i=sc.nextInt();
	
	System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	
	if(i==1) {
		SignUpPage signup= new SignUpPage();
		signup.signUp();
		
	}
	else if(i==2) {
		
		LogInPage login = new LogInPage();
		login.logIn();
	}
	else {
		System.out.println("Invalid Inpute... please give correct resposnce.");
		System.out.println(" ");
		WelcomePage welcome = new WelcomePage();
		welcome.welcomePage();
	}
	}
}
