package com.agilecrm.pages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.agilecrmautomation.BaseClass;

public class LinksPage extends BaseClass {

	public void getLinksOfAmazon() {
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		for (WebElement e : elements) {
			String links = e.getAttribute("href");
			if (links != null && links.startsWith("http")) {
				URL url;
				try {
					url = new URL(links);
					URLConnection urlConnection = url.openConnection();
					HttpsURLConnection connection = (HttpsURLConnection) urlConnection;
					connection.connect();
					int statusCode = connection.getResponseCode();
					if (statusCode != 200) {
						System.out.println(statusCode + " url:" + links);
					}
					// connection.disconnect();
				} catch (IOException e1) {

					e1.printStackTrace();
				}

			}

		}
	}

	public void getLinksOfFlipcart() {
		List<WebElement> elements = driver.findElements(By.tagName("img"));
		for (WebElement e : elements) {
			String link = e.getAttribute("src");
			if (link != null && link.startsWith("https")) {
				URL url;
				try {
					url = new URL(link);
					URLConnection urlConnection = url.openConnection();
					HttpsURLConnection connection = (HttpsURLConnection) urlConnection;
					connection.connect();
					int statusCode = connection.getResponseCode();
					if (statusCode != 403) {
						System.out.println(statusCode + " url:" + link);
					}
					connection.disconnect();
				} catch (IOException e1) {

					e1.printStackTrace();
				
				}

			}
		}
	}

}
