package com.Ex2.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CRMTopMenu {
	
	WebDriver driver;
	
	public CRMTopMenu(WebDriver driver){
		this.driver = driver;
	}

	// When is a page, then inheritance occurs.

	// When has a occurs then encapsulation occurs
	// Is topmenu a page? -- No
	// Home page has a topmenu - has a
	// Accounts page has a topmenu

	public void goToZohoHome() {
		driver.findElement(By.xpath("//a[text()='Zoho.com']")).click();

	}

	public void goToBigin() {

	}

	public void goToCRMPlus() {

	}

	public void goToDesk() {

	}

	public void goToCampaigns() {

	}

	public void goToRoutelQ() {

	}

	public void goToMail() {

	}

	public void goToAllProducts() {

	}

}
