package com.agilecrmautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.agilecrm.pages.ContactPage;
import com.agilecrm.pages.LoginPage;

public class LoginAgileCrm extends BaseClass {
	@BeforeClass
	public void loginAgileCrm()

	{
		launchBrowser("chrome");
		driver.navigate().to("https://learnautomation.agilecrm.com");
		LoginPage loginpage = new LoginPage();
		loginpage.login("cst25@yopmail.com", "Test1234");
	}

	@Test
	public void agileContact() throws InterruptedException {
		click(By.id("contactsmenu"), "click on contact menu");
		click(By.id("contacts-list-view-checkbox"), "select all checkbox");
		driver.findElement(By.xpath("//*[@id=\"contactlimitouterdiv\"]/span/div/a")).click();
		click(By.xpath("//button[text()='delete']"), "click on delete button");

		driver.findElement(By.id("contactsmenu")).click();
		Thread.sleep(4000);
		WebElement checkbox = driver.findElement(By.id("contacts-list-view-checkbox"));
		Thread.sleep(3000);
		checkbox.click();
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		ContactPage contact = new ContactPage();
		contact.addContact();
	}

}
