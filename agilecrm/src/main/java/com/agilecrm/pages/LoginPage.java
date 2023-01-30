package com.agilecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.agilecrmautomation.BaseClass;

public class LoginPage extends BaseClass {
	public void login(String username, String password) {
		WebElement uname = driver.findElement(By.name("email"));
		uname.clear();
		uname.sendKeys(username);

		WebElement pwd = driver.findElement(By.name("password"));
		pwd.clear();
		pwd.sendKeys(password);

		WebElement signIn = driver.findElement(By.xpath("//input[@type='submit']"));
		signIn.click();

		/*if (driver.findElement(By.xpath("//a[@class='close']/parent::*")).isDisplayed()) {
			System.out.println("Invalid username :" + username + "or password :" + password);

		} else {
			driver.findElement(By.xpath("//li[@id='fat-menu']/a")).click();
			driver.findElement(By.xpath("//*[@id=\"fatMenuModal\"]/div[2]/div/div/div/div[3]/div/a")).click();
		}*/

	}

}
