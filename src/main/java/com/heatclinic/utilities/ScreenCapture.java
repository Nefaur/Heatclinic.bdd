package com.heatclinic.utilities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class ScreenCapture {

	private ATUTestRecorder recorder;
	private JavaScriptActions js = new JavaScriptActions();
	private Delayed slowBrowser = new Delayed();

	public void startCapture(String filepath, String filename, Boolean audioEnable) {

		try {
			recorder = new ATUTestRecorder(filepath, filename, audioEnable);
			recorder.start();
			System.out.println("Starting recording....");
		} catch (ATUTestRecorderException e) {
			e.printStackTrace();
		}
	}

	public void endCapture() {

		try {
			recorder.stop();
			System.out.println("Ending recording.");
		} catch (ATUTestRecorderException e) {
			e.printStackTrace();
		}
	}

	public void screenCapture(WebDriver driver, String filename) {

		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File("target/Screenshots/" + filename + ".png");
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void webElementScreenShot(WebDriver driver, WebElement ele) {

		try {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			BufferedImage fullImg = ImageIO.read(screenshot);
			Point point = ele.getLocation();
			double viewPortMagnify = 1.26;
			double xAdjust = point.getX() * viewPortMagnify;
			double yAdjust = point.getY() * viewPortMagnify;
			System.out.println("Location:" + point);
			int eleWidth = ele.getSize().getWidth();
			int eleHeight = ele.getSize().getHeight();
			System.out.println("Width:" + eleWidth + " Height:" + eleHeight);
			js.drawBorder(ele, driver);
			slowBrowser.sleeper(1000);
			BufferedImage eleScreenshot;
			eleScreenshot = fullImg.getSubimage((int) xAdjust, (int) yAdjust, eleWidth, eleHeight);
			ImageIO.write(eleScreenshot, "png", screenshot);
			File screenshotLocation = new File("target/Screenshots/" + ele.getLocation() + ele.getSize() + "Height"
					+ eleHeight + "Width" + eleWidth + ele.getText() + ele.getTagName() + ".png");
			FileUtils.copyFile(screenshot, screenshotLocation);
			System.out.println("WebElement screenshot saved in disk.");
			slowBrowser.sleeper(1000);
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
