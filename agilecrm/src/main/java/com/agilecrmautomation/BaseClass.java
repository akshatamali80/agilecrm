package com.agilecrmautomation;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver = null;

	public static void launchBrowser(String browser) {
		switch (browser) {
		case "chrome":
			// System.setProperty("webdriver.chrome.driver", "D:\\Tools\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			//ChromeOptions option=new ChromeOptions();
			
			//option.setHeadless(True);
			driver = new ChromeDriver();
			
			break;

		case "mozila":
			// System.setProperty("webdriver.gecko.driver", "D:\\Tools\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new ChromeDriver();
			break;

		case "edge":
//			System.setProperty("webdriver.edge.driver", "D:\\Tools\\msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new ChromeDriver();

		default:
			// System.setProperty("webdriver.chrome.driver", "D:\\Tools\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}
		// driver.navigate().to("https://cyberworld.agilecrm.com/login");
	}

	public static void click(By by, String msg) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).click();
		System.out.println(msg);

	}

	public static void waitForVisibilityOfElement(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public static void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public static void fluentWait(final By by) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				System.out.println("waiting for element to be available");

				return driver.findElement(by);
			}
		});
	}

	public static void selectDropdownByText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public static void selectDropdownByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);

	}

	public static void selectDropdownByValue(WebElement element, String val) {
		Select select = new Select(element);
		select.selectByValue(val);
	}

	public static ChromeOptions setChromeCapabilities() {
		ChromeOptions option = new ChromeOptions();
	
		option.addArguments("start-maximized");
		//option.setHeadless(True);
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		option.setExperimentalOption("prefs", prefs);
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		return option;
	}

}
