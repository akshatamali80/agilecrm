package com.agilecrm.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.agilecrmautomation.BaseClass;

public class CompanyPage1 extends BaseClass {
	
	public void addCompany() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement addCompanyButton=driver.findElement(By.xpath("//button[contains(text(),'Add Company')]"));
		Actions action=new Actions(driver);
		action.click(addCompanyButton).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='company_name']")));
		
		WebElement companyName=driver.findElement(By.xpath("//input[@id='company_name']"));
		action.click(companyName).sendKeys("VishuTheCuteBoy").build().perform();
		WebElement url=driver.findElement(By.xpath("//form[@id='companyForm']/descendant::input[@id='company_url']"));
		action.click(url).sendKeys("vishu@charmingboy.com").build().perform();
		WebElement continueForm=driver.findElement(By.id("continue-company"));
		action.click(continueForm).build().perform();
		WebElement tags=driver.findElement(By.xpath("//form[@id='continueCompanyForm']/descendant::input[@name='tags']"));
		action.click(tags).sendKeys("bete mouj kr di").build().perform();
		WebElement email=driver.findElement(By.xpath("//div[contains(@class,'second')]/descendant::input[@id='email']"));
		action.click(email).sendKeys("vishu@love.com").build().perform();
		//WebElement selectemail=driver.findElement(By.xpath("//div[contains(@class,'second')]/descendant::select[@name='email-select']"));
		Select select=new Select(driver.findElement(By.xpath("//div[contains(@class,'second')]/descendant::select[@name='email-select']")));
		
	}
	

}
