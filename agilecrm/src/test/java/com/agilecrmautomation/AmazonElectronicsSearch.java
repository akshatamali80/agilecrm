package com.agilecrmautomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonElectronicsSearch extends BaseClass {

	
	
	@Test
	
		public void amazonTest() {
		launchBrowser("chrome");
		driver.navigate().to("https://www.amazon.in/");
		
		selectDropdownByText(driver.findElement(By.id("searchDropdownBox")), "Electronics");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop");

		click(By.id("nav-search-submit-button"), "click on search button");
		List<WebElement> laptopNames = driver.findElements(By.xpath("//div[@class='sg-row']/descendant::h2/a/span"));
		List<WebElement> laptopPrice = driver.findElements(By.xpath("//div[@class='sg-row']/descendant::span[@class='a-price']//span[@class='a-price-whole']"));
		for (int i = 0; i < laptopNames.size(); i++) {

			String name = laptopNames.get(i).getText();
			String price = laptopPrice.get(i).getText();
			String lprice = price.replace(",", "");

			int laptoprice = Integer.parseInt(lprice);
			if (laptoprice > 30000) {

				System.out.println(name + "  : " + laptoprice);
			}

		}
	}

}
