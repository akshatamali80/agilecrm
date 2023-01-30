package com.agilecrm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.agilecrmautomation.BaseClass;

public class DealPage extends BaseClass {
	
	public String addDeal(String deal) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		// click(By.xpath("//li[@id='dealsmenu']/a"), "Click on deal menu");
		fluentWait(By.xpath("//div[@id='deals-action']/button"));
		click(By.xpath("//div[@id='deals-action']/button"), "click on add deal");
		driver.findElement(By.xpath("//form[@id='opportunityForm']/descendant::input[@id='name']")).sendKeys(deal);
		driver.findElement(
				By.xpath("//form[@id='opportunityForm']/descendant::input[@name='currency_conversion_value']"))
				.sendKeys("100000");
		// driver.findElement(By.xpath("//form[@id='opportunityForm']/descendant::select[@id='pipeline_milestone']"));
		selectDropdownByText(
				driver.findElement(
						By.xpath("//form[@id='opportunityForm']/descendant::select[@id='pipeline_milestone']")),
				"Lost");
		waitForElementToBeClickable(driver.findElement(By.xpath("//div[@id='deals-new-footer']/a")));
		click(By.xpath("//div[@id='deals-new-footer']/a"), "click on save");
		System.out.println(deal);
		return "deal";

	}
	public void archieveDeal(String a) {
		click(By.xpath(a),"click on deal");
		click(By.xpath("//div[@class='panel-body']/descendant::button[1]"), "click on dropdown");
		click(By.id("dealdetail-archive"), "click on archieve");
		click(By.id("deal-quick-archive"), "click on confirm");
	}

}
