package com.heatclinic.framework;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

public class DriverFactory {

	private ThreadLocal<WebDriver> driverBase = new ThreadLocal<WebDriver>();
	private static DriverFactory instance = null;
	private static String Hub_URL = "http://192.168.137.1:4444/wd/hub";

	public static final String USERNAME = "nefaurbhuiyan1";
	public static final String AUTOMATE_KEY = "YBtZTy2e8jPmbemabR4t";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	private DriverFactory() {
	}

	public static DriverFactory initialize() {
		return initialize(null);
	}

	public static DriverFactory initialize(String browser) {
		if (instance == null) {
			instance = new DriverFactory();
		}

		if (browser == null) {
			browser = "";
		}

		if (instance.driverBase.get() == null) {
			WebDriver driver;
			DesiredCapabilities caps;
			System.out.println("Starting browser: " + browser);
			
			switch (browser.toLowerCase()) {
			case "chrome":
				ChromeDriverManager.getInstance().arch32().setup();
				driver = new ChromeDriver();
				instance.driverBase.set(driver);
				break;

			case "firefox":
				FirefoxDriverManager.getInstance().arch32().setup();
				FirefoxOptions options = new FirefoxOptions();
				options.setCapability("marionette", true);
				driver = new FirefoxDriver(options);
				instance.driverBase.set(driver);
				break;

			case "ie":
				InternetExplorerDriverManager.getInstance().arch32().setup();
				driver = new InternetExplorerDriver();
				instance.driverBase.set(driver);
				break;

			case "ch-grid":
				caps = new DesiredCapabilities();
				caps.setPlatform(Platform.ANY);
				caps.setBrowserName("chrome");
				try {
					driver = new RemoteWebDriver(new URL(Hub_URL), caps);
					instance.driverBase.set(driver);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				break;

			case "ff-grid":
				caps = new DesiredCapabilities();
				caps.setPlatform(Platform.ANY);
				caps.setBrowserName("firefox");
				caps.setCapability("marionette", true);
				System.out.println("Trying to set driver.");
				try {
					driver = new RemoteWebDriver(new URL(Hub_URL), caps);
					instance.driverBase.set(driver);
					System.out.println("Driver set.");
				} catch (MalformedURLException e) {
					System.out.println("Unable to set driver.");
					e.printStackTrace();
				}
				break;

			case "ie-grid":
				caps = new DesiredCapabilities();
				caps.setPlatform(Platform.ANY);
				caps.setBrowserName("internet explorer");
				caps.setVersion("10");
				try {
					driver = new RemoteWebDriver(new URL(Hub_URL), caps);
					instance.driverBase.set(driver);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				break;

			case "ch-cloud":
				caps = new DesiredCapabilities();
				caps.setCapability("browser", "Chrome");
				caps.setCapability("browser_version", "62.0");
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "10");
				caps.setCapability("resolution", "2048x1536");
				try {
					driver = new RemoteWebDriver(new URL(URL), caps);
					instance.driverBase.set(driver);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				break;

			case "safari-mac-cloud":
				caps = new DesiredCapabilities();
				caps.setCapability("browser", "Safari");
				caps.setCapability("browser_version", "11.0");
				caps.setCapability("os", "OS X");
				caps.setCapability("os_version", "High Sierra");
				caps.setCapability("resolution", "1920x1080");

				try {
					driver = new RemoteWebDriver(new URL(URL), caps);
					instance.driverBase.set(driver);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				break;

			case "ff-cloud":
				caps = new DesiredCapabilities();
				caps.setCapability("browser", "Firefox");
				caps.setCapability("browser_version", "60.0");
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "10");
				caps.setCapability("resolution", "2048x1536");
				try {
					driver = new RemoteWebDriver(new URL(URL), caps);
					instance.driverBase.set(driver);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				break;

			case "":
				ChromeDriverManager.getInstance().arch32().setup();
				ChromeOptions options1 = new ChromeOptions();
				options1.addArguments("window-size=1400,800");
				options1.addArguments("headless");
				driver = new ChromeDriver(options1);
				instance.driverBase.set(driver);
				break;

			default:
				break;
			}
		}
		return instance;
	}

	public WebDriver getdriver() {
		return driverBase.get();
	}

	public void tearDown() {
		driverBase.get().quit();
		driverBase.remove();
		driverBase.set(null);
	}
}
