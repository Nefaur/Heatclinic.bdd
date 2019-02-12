package com.heatclinic.utilities;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;

public class MultipleWindows {

	public void switchToNewTab(WebDriver driver) {
		String mainWindow = driver.getWindowHandle();
		Set<String> set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			String childWindow = itr.next();
			if (!mainWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
			}
		}
	}
}
