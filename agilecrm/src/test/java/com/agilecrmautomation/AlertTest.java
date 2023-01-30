package com.agilecrmautomation;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class AlertTest extends BaseClass {
  @Test
  

	  public void informationAlert(String browser) throws InterruptedException {
		
			launchBrowser("chrome");
			driver.navigate().to("https://www.amazon.in");
	        JavascriptExecutor js=(JavascriptExecutor)driver;
	        js.executeScript("alert('This is sample alert!');");
	       driver.switchTo().alert().accept();
	       Thread.sleep(4000);
		}
	  @Test
		public void confirmationAlert() throws Exception {
		
			launchBrowser("chrome");
			driver.navigate().to("https://www.amazon.in");
	        JavascriptExecutor js=(JavascriptExecutor)driver;
	        js.executeScript("confirm('This is sample alert!');");
	        driver.switchTo().alert().accept();
	        Thread.sleep(4000);
		}
	    @Test
		
		public void promptAlert() {
	
			launchBrowser("chrome");
			
			driver.navigate().to("https://www.amazon.in");
	        JavascriptExecutor js=(JavascriptExecutor)driver;
	        js.executeScript("prompt('This is sample alert!');");
	       driver.switchTo().alert().accept();

  }
}
