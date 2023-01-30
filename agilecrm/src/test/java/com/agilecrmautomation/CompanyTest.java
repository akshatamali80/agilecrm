package com.agilecrmautomation;

import org.testng.annotations.Test;

import com.agilecrm.pages.CompanyPage;
import com.agilecrm.pages.LoginPage;

public class CompanyTest extends BaseClass {

		@Test
		public void a_login() { 
			launchBrowser("chrome");
		driver.navigate().to("https://learnautomation.agilecrm.com/");
		LoginPage login = new LoginPage();
		login.login("cst25@yopmail.com", "Test1234");
		
		CompanyPage company1 = new CompanyPage();
		company1.addCompany();
		

}
}


