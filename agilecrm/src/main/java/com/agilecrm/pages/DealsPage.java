package com.agilecrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.agilecrmautomation.BaseClass;

public class DealsPage extends BaseClass {

	public void changeDealsStatus(String srcStatus, String dstStatus) throws Exception {
		waitForElementToBeClickable(driver.findElement(By.xpath("//ul[@milestone='"+srcStatus+"']/li[1]")));
		// locate source element
		WebElement srcElement = driver.findElement(By.xpath("//ul[@milestone='"+ srcStatus +"']/li[1]"));
		// get the name of source deal
		String dealsName = driver.findElement(By.xpath("//ul[@milestone='"+srcStatus+"']/li[1]/descendant::a[1]"))
				.getText();
		// locate destination element
		WebElement dstElement = driver.findElement(By.xpath("//ul[@milestone='"+dstStatus+"']/li[1]"));
		Actions action = new Actions(driver);
		// perform drag and drop between source and destination element
		action.dragAndDrop(srcElement, dstElement).build().perform();
		System.out.println(" changing the status of " + dealsName + " from " + srcStatus + " to" + dstStatus);
		// get the name of dest deal
		WebElement dstDealName = driver
				.findElement(By.xpath("//ul[@milestone='" + dstStatus + "]/li[1]/descendant::a[1]"));
		//String dstDealName=dstDealName.getText();
		verifyDealsStatus(dstStatus, dstDealName);
	}

	public void verifyDealsStatus(String expectedStatus, WebElement element) throws Exception {
		// wait until the dst element is clickable
		waitForElementToBeClickable(element);
		// perform click operation
		element.click();
		// get the updated status of deal
		String actualStatus = driver.findElement(By.xpath("//div[@class='pane-body')/descendant::span[2]")).getText();
		// compare the actual and expected deal status

		if (actualStatus.equals(actualStatus)) {
			System.out.println(" Successfully performed drag and drop operation ");
		}

		else {
			throw new Exception(" Drag and drop did worked from source element ");
		}
	}

}
