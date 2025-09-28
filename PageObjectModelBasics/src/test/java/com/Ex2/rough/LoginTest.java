package com.Ex2.rough;

import com.Ex2.base.BasePage;
import com.Ex2.pages.LoginPage;
import com.Ex2.pages.ZohoAppPage;
import com.Ex2.pages.ZohoHomePage;
import com.Ex2.people.PeoplePage;

public class LoginTest {

	public static void main(String args[]) throws InterruptedException {
		
		ZohoHomePage zhp = new ZohoHomePage();
	    LoginPage lp = zhp.goToSignIn();
	    ZohoAppPage zap= lp.doLogin("jaswindersinghchawla05@gmail.com", "TesterUser@123");
		PeoplePage pp= zap.goToPeoplePage(); 
		pp.PriceQuote();
		
		
		
		Thread.sleep(3000);
	//	BasePage.crm_top_menu.goToZohoHome();
		
		
		
		/*ZohoHomePage zhp = new ZohoHomePage();

		zhp.goToSignIn();
		LoginPage lp = new LoginPage();
		lp.doLogin("jaswindersinghchawla05@gmail.com", "TesterUser@123");
		
		ZohoAppPage zap = new ZohoAppPage();
		zap.goToPeoplePage(); */

	//	BasePage.crm_top_menu.goToZohoHome();

	}

}
