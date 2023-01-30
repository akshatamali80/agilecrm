package com.agilecrmautomation;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.agilecrm.pages.DealPage;
import com.agilecrm.pages.LoginPage;

public class DealTest extends BaseClass {

	@BeforeClass
	public void deaLogin()
	{
		launchBrowser("chrome");
		driver.navigate().to("https://learnautomation.agilecrm.com/");
		LoginPage login1 = new LoginPage();
		login1.login("cst25@yopmail.com", "Test1234");
	}
	@Test
public void archiveDeal()
	{	
		click(By.xpath("//li[@id='dealsmenu']/a"), "Click on deal menu");
		click(By.xpath("//div[@id='New-list-container']/descendant::a[1]"),"click on deal");
		click(By.xpath("//div[@class='panel-body']/descendant::button[1]"), "click on dropdown");
		click(By.id("dealdetail-archive"), "click on archieve");
		click(By.id("deal-quick-archive"), "click on confirm");
	}
}
		
	

/*ArrayList<String> dealNames = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			String dealName = deal.addDeal("Kanha" +i);
		
			dealNames.add(dealName);

		}*/
/* {
List<WebElement> elements = driver.findElements(By.tagName("a"));
		for (WebElement e : elements) {
			String links = e.getAttribute("href");
			
			DealPage deal = new DealPage();
	deal.archieveDeal(elements);
	
		}}
*/