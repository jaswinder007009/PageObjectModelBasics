package com.Ex2.pages;

import org.openqa.selenium.By;

import com.Ex2.base.BasePage;
import com.Ex2.people.PeoplePage;

public class ZohoAppPage extends BasePage {
	

	public PeoplePage goToPeoplePage() {
	driver.findElement(By.xpath("//div[text()='People']")).click();	
	
	return new PeoplePage();
	}
	
}
