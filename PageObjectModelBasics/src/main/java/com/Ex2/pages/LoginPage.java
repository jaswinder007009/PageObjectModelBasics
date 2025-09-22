package com.Ex2.pages;

import org.openqa.selenium.By;

import com.Ex2.base.BasePage;

public class LoginPage extends BasePage {

	public void doLogin(String username, String password) throws InterruptedException {
		System.out.println("Waiting for email button");
		driver.findElement(By.id("login_id")).sendKeys(username);
		System.out.println("Email entered");
		System.out.println("Waiting for next button");

		driver.findElement(By.id("nextbtn")).click();
		System.out.println("Next button clicked");
		System.out.println("Waiting for password button");

		driver.findElement(By.id("password")).sendKeys(password);
		System.out.println("Password entered");
		System.out.println("Waiting for submit button");

		driver.findElement(By.xpath("//button//span[text()='Sign in']")).click();
		System.out.println("Submission done");

		Thread.sleep(5000);
		
	}

}
