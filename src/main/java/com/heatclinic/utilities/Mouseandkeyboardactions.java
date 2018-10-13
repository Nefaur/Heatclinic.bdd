package com.heatclinic.utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Mouseandkeyboardactions extends ColorVerify {

	public void mouseHover(WebDriver driver, WebElement element) {
		verifyColorOfLinkMenuOnHover(element);
		Actions mhover = new Actions(driver);
		mhover.moveToElement(element).perform();
		verifyColorOfLinkMenuOnHover(element);
	}

	public void mouseClick(WebDriver driver, WebElement element) {
		Actions mclick = new Actions(driver);
		mclick.moveToElement(element).click().build().perform();
	}

	public void mouseHover(WebDriver driver, WebElement parent, WebElement child) {
		verifyColorOfLinkMenuOnHover(parent);
		Actions mhover = new Actions(driver);
		mhover.moveToElement(parent).moveToElement(child).perform();
		verifyColorOfLinkMenuAfterHover(parent, child);
	}

	public void enterkey(WebDriver driver) {
		Actions keyboard = new Actions(driver);
		keyboard.sendKeys(Keys.ENTER);
	}
}
