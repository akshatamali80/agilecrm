package com.agilecrm.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.agilecrmautomation.BaseClass;

public class CompanyPage extends BaseClass {

	public void addCompany() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		click(By.xpath("//li[@id='companiesmenu']/a/i"), "clickoncompany");
		click(By.xpath("//button[contains(text(),'Add Company')]"), "click on add company button");
		driver.findElement(By.id("company_name")).sendKeys("basecom");
		// driver.findElement(By.id("continue-company")).click();
		click(By.id("continue-company"), "clickon continue editing");

		Select select = new Select(driver.findElement(By.name("country")));
		// select.selectByVisibleText("India");
		// select.selectByIndex(12);
		if (!select.isMultiple()) {
			List<WebElement> alloptions = select.getOptions();

			for (WebElement element : alloptions) {
				String option = element.getText();
				System.out.println(option);
			}

		}
		driver.findElement(By.xpath("//*[@id=\"company-update\"]")).click();
		// List<WebElement> countryselect=select.getOptions();
		// for(WebElement element:countryselect) {
		// String text=element.getText();
		// if(text.equalsIgnoreCase("Austria"))
		// {

		// }
		/// }

		// System.out.println(text);

		driver.findElement(By.xpath("//div[@class='contact-lhs-actions']/a[1]")).click();
		driver.findElement(By.xpath("//div[contains(@class,'second')]/descendant::input[@id='email']"))
				.sendKeys("krish@yopmail.com");
		Select select1 = new Select(driver
				.findElement(By.xpath("//div[contains(@class,'second')]/descendant::select[@name='email-select']")));
	}
}
