package com.Ex2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Ex2.base.BasePage;
import com.aventstack.extentreports.Status;

public class ZohoHomePage extends BasePage {


	public LoginPage goToSignIn() throws InterruptedException {
		System.out.println("Printing driver" + driver);
		System.out.println("Starting sleep");
		Thread.sleep(5000);
		System.out.println("Ending sleep");
		System.out.println("Finding element");


		//driver.findElement(By.xpath("(//a[text()='Sign In'])[1]")).click();
		click("signInButton_XPATH");
		
		
		System.out.println("Element found");
		
		return new LoginPage();

	}

	public void goToCRM() {
		System.out.println("In go to crm method");

		driver.findElement(By.xpath("//span[text()='CRM']")).click();

	}

	public void goToMail() {
		driver.findElement(By.xpath("//span[text()='Mail']")).click();

	}

	public void goToBooks() {
		driver.findElement(By.xpath("//span[text()='Books']")).click();

	}

	public void goToPeople() {
		driver.findElement(By.xpath("//span[text()='People']")).click();

	}

	public void goToPayroll() {
		driver.findElement(By.xpath("//span[text()='Payroll']")).click();

	}

}