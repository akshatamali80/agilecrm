package com.agilecrmautomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.agilecrm.pages.CompanyPage1;
import com.agilecrm.pages.LoginPage;

public class CompanyTest1 extends BaseClass {
	@BeforeClass
	public void companyLogin()

	 {
		launchBrowser("chrome");
		driver.navigate().to("https://learnautomation.agilecrm.com/");
		LoginPage login = new LoginPage();
		login.login("cst25@yopmail.com", "Test1234");
	 }
	 @Test
	 public void companyAdd()
	 {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		click(By.xpath("//li[@id='companiesmenu']/a/i"), "clickoncompany");
		CompanyPage1 addcompany=new CompanyPage1();
		addcompany.addCompany();

	}

}

