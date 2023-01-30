package com.agilecrmautomation;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.agilecrm.pages.DealsPage;
import com.agilecrm.pages.LoginPage;

public class DealsTestCase extends BaseClass {

	@BeforeClass
	public void dealLogin()
	{
		launchBrowser("chrome");
		driver.navigate().to("https://cyberworld.agilecrm.com/login");
		LoginPage loginPage=new LoginPage();
		loginPage.login("vijayraj@yopmail.com","Vijay@1234");
	}
	@Test
	public void dealAdd() throws Exception
	{
		click(By.id("dealsmenu"), "click on deals menu");
		DealsPage dealspage=new DealsPage();
		dealspage.changeDealsStatus("New", "Prospect");
		
	

	}

}
