package com.Ex2.pages;

import org.openqa.selenium.By;

import com.Ex2.base.BasePage;

public class LoginPage extends BasePage {

	public ZohoAppPage doLogin(String username, String password) throws InterruptedException {
		Thread.sleep(5000);
System.out.println("Enter username");
		driver.findElement(By.id("login_id")).sendKeys(username);
		driver.findElement(By.id("nextbtn")).click();
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//button//span[text()='Sign in']")).click();
		Thread.sleep(5000);
		
		return new ZohoAppPage();
	}

}
