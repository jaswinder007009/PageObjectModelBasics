package com.Ex2.rough;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Ex2.pages.HomePage;
import com.Ex2.pages.LoginPage;

public class LoginTest {
	
	public static void main(String args []) throws InterruptedException   {
		

		
		
		HomePage hp = new HomePage();
		hp.goToSignUp();
		
		LoginPage dl = new LoginPage();
		dl.doLogin("jaswindersinghchawla05@gmail.com", "TesterUser@123");
		
		
		
	
	}

}
