package com.agilecrmautomation;

import org.testng.annotations.Test;

import com.agilecrm.pages.ContactPage;
import com.agilecrm.pages.LoginPage;

public class ContactTest extends BaseClass {

@Test
public void contactTestMethod() throws InterruptedException
	
	{
		ContactTest contact = new ContactTest();
		launchBrowser("chrome");

		driver.navigate().to("https://learnautomation.agilecrm.com/");
		LoginPage login1 = new LoginPage();
		login1.login("cst25@yopmail.com", "Test1234");
		ContactPage object = new ContactPage();
		object.addContact();
		object.searchContact();
		object.updateContact();
		object.deleteContact();

	}

}
