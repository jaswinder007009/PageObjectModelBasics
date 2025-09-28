package com.Ex2.people;

import org.openqa.selenium.By;

import com.Ex2.base.BasePage;

public class PeoplePage extends BasePage{
	
	public void PriceQuote() {
		driver.findElement(By.xpath("//a[text()='Price Quote']")).click();
	}

}
