package com.heatclinic.utilities;

import java.io.IOException;
import org.openqa.selenium.WebElement;

public class AutoItFileUploader {

	public static void clickAuto(WebElement elementtoclick) {
		elementtoclick.click();

		try {
			Runtime.getRuntime().exec("src/test/resources/TestResource/AutoItUploadClicker.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
