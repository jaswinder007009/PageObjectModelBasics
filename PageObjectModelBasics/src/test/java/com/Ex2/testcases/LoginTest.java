package com.Ex2.testcases;

import org.testng.annotations.Test;

import com.Ex2.pages.LoginPage;
import com.Ex2.pages.ZohoAppPage;
import com.Ex2.pages.ZohoHomePage;
import com.Ex2.people.PeoplePage;

public class LoginTest extends BaseTest{
	
	@Test
	public void loginTest() throws InterruptedException {
		
		ZohoHomePage zhp = new ZohoHomePage();
	    LoginPage lp = zhp.goToSignIn();
        //log.info("Clicking on element");

	    ZohoAppPage zap= lp.doLogin("jaswindersinghchawla05@gmail.com", "TesterUser@123");
		PeoplePage pp= zap.goToPeoplePage(); 
		pp.PriceQuote();
		
		
	}

}
