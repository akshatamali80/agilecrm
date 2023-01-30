package com.agilecrmautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.agilecrm.pages.LinksPage;

public class FlipcartImageLinkVerification extends BaseClass {

	@BeforeTest
	public void flipcart() {
		launchBrowser("chrome");
		driver.navigate().to("https://www.flipkart.com/");
		}
	@Test
	public void getLinks() {
		LinksPage link=new LinksPage();
		link.getLinksOfFlipcart();
}
}
