package com.velocity.quiz.main;

import java.sql.SQLException;

import com.velocity.quiz.registerpage.WelcomePage;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		WelcomePage welcome = new WelcomePage();
		welcome.welcomePage();

	}

}
