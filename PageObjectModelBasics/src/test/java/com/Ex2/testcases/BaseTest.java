package com.Ex2.testcases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.Ex2.base.BasePage;

public class BaseTest {
	
	@AfterSuite
	public void tearDown() {
		BasePage.quit();
	}
	

}
