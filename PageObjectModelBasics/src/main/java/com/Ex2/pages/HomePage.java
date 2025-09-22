package com.Ex2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Ex2.base.BasePage;

public class HomePage extends BasePage {
	
	public void goToSignUp() throws InterruptedException {
		System.out.println("Printing driver" + driver);
		System.out.println("Starting sleep");
		Thread.sleep(5000);
		System.out.println("Ending sleep");
		System.out.println("Finding element");

		driver.findElement(By.xpath("(//a[text()='Sign In'])[1]")).click();
		System.out.println("Element found");
		

	}
	

	
	

	
}