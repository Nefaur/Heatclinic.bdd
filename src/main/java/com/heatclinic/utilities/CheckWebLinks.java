package com.heatclinic.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class CheckWebLinks {

	public void checkingLinkConnection(WebDriver driver, String tagname, String attribute) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> linksList = driver.findElements(By.tagName(tagname));
		System.out.println("Total number of links: "+linksList.size());
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		for (int i = 0; i < linksList.size(); i++) {
			if (linksList.get(i).getAttribute(attribute) != null) {
				activeLinks.add(linksList.get(i));
			}
		}
		System.out.println("Number of active links: "+activeLinks.size());
		for(int j=0; j<activeLinks.size();j++) {
			try {
				HttpURLConnection connection=(HttpURLConnection)new URL(activeLinks.get(j).getAttribute(attribute)).openConnection();
				connection.connect();
				String response=connection.getResponseMessage();
				connection.disconnect();
				System.out.println(activeLinks.get(j).getAttribute(attribute)+"---"+response);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}