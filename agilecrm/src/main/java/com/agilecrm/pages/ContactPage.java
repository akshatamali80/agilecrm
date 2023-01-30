package com.agilecrm.pages;

import com.agilecrmautomation.BaseClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class ContactPage extends BaseClass {
	String firstName = "Pranav";
	String lastName = "salunkhe";
	String emailId = "prsalunkhe@gmail.com";
	String mobNumber = "7565456677";

	public void addContact() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		//waitForVisibilityOfElement(driver.findElement(By.id("view-list")));
		click(By.id("contactsmenu"), "click on contactmenu");
		Thread.sleep(4000);
		 waitForVisibilityOfElement(driver.findElement(By.xpath("//div[@id='view-list']/div/button")));
		click(By.xpath("//div[@id='view-list']/div/button"), "click on addcontact");
		waitForVisibilityOfElement(driver.findElement(By.id("fname")));
		driver.findElement(By.id("fname")).sendKeys(firstName);
		click(By.xpath("//a[@href=\"#continue-contact\"]"), "click on continue edit");
		click(By.xpath("//a[@type='submit']"), "cllick on update");
	}

	public void searchContact() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.xpath("//li[@id='calendarmenu']/preceding::button[3]")).click();
		click(By.xpath("//a[text()='All']"), "click on all checkbox");
		click(By.xpath("//a[text()='Contacts']"), "click on contact checkbox");
		driver.findElement(By.id("searchText")).sendKeys(firstName);
		click(By.xpath("//i[@class='search material-icons']"), "click on serch button");
		waitForVisibilityOfElement(driver.findElement(By.id("search-model-list")));
		driver.findElement(By.id("search-model-list")).click();
	}

	public void updateContact() {

		driver.findElement(
				By.xpath("//*[@id=\"contact-details-block\"]/div/div/div/div/div/div[1]/div/div/div[7]/a[1]")).click();
		driver.findElement(By.name("lname")).sendKeys(" johnson123");
		driver.findElement(By.id("update")).click();
	}

	public void deleteContact() {
		waitForVisibilityOfElement(driver
				.findElement(By.xpath("//div[@class='panel-middle-align-mobile m-b-sm']/preceding::div[1]/button")));
		driver.findElement(By.xpath("//div[@class='panel-middle-align-mobile m-b-sm']/preceding::div[1]/button"))
				.click();

		click(By.xpath("//div[@class='panel-middle-align-mobile m-b-sm']/preceding::div[1]/button/following::li[10]/a"),
				"click on deelet");

		waitForVisibilityOfElement(driver.findElement(By.id("success_callback")));
		driver.findElement(By.id("success_callback")).click();

	}

}