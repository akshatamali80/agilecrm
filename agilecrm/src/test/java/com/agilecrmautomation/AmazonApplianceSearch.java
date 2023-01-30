package com.agilecrmautomation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonApplianceSearch extends BaseClass {

	
	@Test

	public void amzonappliance() throws InterruptedException, AWTException {
		launchBrowser("chrome");
		driver.navigate().to("https://www.amazon.in/");

		Actions action = new Actions(driver);

		WebElement element = driver.findElement(By.id("desktop-banner"));

		action.contextClick(element).build().perform();
		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		ArrayList<String> x = new ArrayList<String>(driver.getWindowHandles());

		// Set<String> allIds = driver.getWindowHandles();

		// [[window1, window2]]

		driver.switchTo().window(x.get(1)); // here x.get(1) indicates that

		System.out.println(driver.getTitle());
		List<WebElement> productName = driver
				.findElements(By.xpath("//div[@class='DealContent-module__truncate_sWbxETx42ZPStTc9jwySW']"));
		List<WebElement> pricetag = driver.findElements(
				By.xpath("//div[@class='BadgeAutomated-module__badgeOneLineContainer_yYupgq1lKxb5h3bfDqA-B']/div[1]"));

		for (int i = 0; i < productName.size(); i++) {
			String pname = productName.get(i).getText();
			String ptag = pricetag.get(i).getText();

			System.out.println(pname + " : " + ptag);
		}

	}

}

/*
 * driver.navigate().to("https://www.amazon.in/");
 * selectDropdownByText(driver.findElement(By.id("searchDropdownBox")),
 * "Appliances");
 * driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Washing Machine");
 * 
 * click(By.id("nav-search-submit-button"), "click on search button");
 * List<WebElement> applianceNames=driver.findElements(By.xpath(
 * "//div[@class='sg-row']/descendant::h2/a/span")); List<WebElement>
 * appliancePrice=driver.findElements(By.xpath(
 * "//div[@class='sg-row']/descendant::span[@class='a-price']")); for(int i=0;
 * i<applianceNames.size(); i++) {
 * 
 * String name=applianceNames.get(i).getText(); String
 * price=appliancePrice.get(i).getText(); System.out.println(name+ "  : " +price
 * );
 * 
 * 
 * }
 * 
 * 
 * } }
 */
/*
 * String parentWindow = driver.getWindowHandle(); Set<String> allWindow =
 * driver.getWindowHandles(); for (String windowId : allWindow) {
 * 
 * if (!windowId.equals(parentWindow)) { System.out.println("child window id " +
 * windowId); driver.switchTo().window(windowId);
 */