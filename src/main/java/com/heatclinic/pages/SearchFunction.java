package com.heatclinic.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.heatclinic.framework.DriverFactory;
import com.heatclinic.utilities.CheckWebLinks;
import com.heatclinic.utilities.Delayed;
import com.heatclinic.utilities.JavaScriptActions;
import com.heatclinic.utilities.Mouseandkeyboardactions;
import com.heatclinic.utilities.ScreenCapture;

import io.cucumber.datatable.DataTable;

public class SearchFunction {

	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='search']")
	private WebElement searchBar;

	@FindBy(how = How.XPATH, using = "//li[@class='col-sm-3 ta-column']//ul/descendant::li")
	private List<WebElement> searchResults;

	@FindBy(how = How.XPATH, using = "//h4[contains(text(),'Price')]")
	private WebElement priceRange;

	@FindBy(how = How.XPATH, using = "//a//div[@class='js-image image card-image']//img")
	private List<WebElement> sauceNames;

	@FindBy(how = How.XPATH, using = "//span[@class='small-text pull-right page-results-counter']")
	private WebElement resultCounter;

	private Mouseandkeyboardactions mousekeyboard = new Mouseandkeyboardactions();
	private JavaScriptActions js = new JavaScriptActions();
	private Delayed slowBrowser = new Delayed();
	private CheckWebLinks checkWebLinks = new CheckWebLinks();
	private ScreenCapture capture = new ScreenCapture();

	public SearchFunction() {
		loadSearchFunction();
	}

	private void loadSearchFunction() {
		this.driver = DriverFactory.initialize().getdriver();
		PageFactory.initElements(driver, this);
	}

	public void enterSearch(String search) {
		capture.webElementScreenShot(driver, searchBar);
		searchBar.sendKeys(search);
	}

	public void enterSearch(DataTable queries) {
		slowBrowser.delay(2000);
		List<List<String>> list = queries.asLists(String.class);
		for (int i = 1; i < list.size(); i++) { // i starts from 1 because i=0 represents the header
			System.out.println("Search text is: " + list.get(i).get(0));
			searchBar.sendKeys((list.get(i).get(0)));
		}
	}

	public void checkLinks(String tagname, String attribute) {
		checkWebLinks.checkingLinkConnection(driver, tagname, attribute);
	}

	public void selectQuery() {
		slowBrowser.delay(2000);
		List<WebElement> list = searchResults;
		System.out.println("Total number of suggestions in search box: " + list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().contains(searchBar.getText())) {
				list.get(i).click();
				break;
			}
		}
	}

	public void selectPrice(int minPrice) {
		int price = 0;
		switch (minPrice) {
		case 0:
			price = 1;
			break;

		case 5:
			price = 2;
			break;

		case 10:
			price = 3;
			break;

		case 15:
			price = 4;
			break;
		}

		String price_xpath = "//div//div[@id='collapse1']//div[@class='panel-body']//div[" + price + "]//label[1]";
		WebElement selected_Price_Rangerice_Range = driver.findElement(By.xpath(price_xpath));
		capture.webElementScreenShot(driver, priceRange);
		priceRange.click();
		slowBrowser.sleeper(3000);
		System.out.println("Price selected: " + selected_Price_Rangerice_Range.getText());
		capture.webElementScreenShot(driver, selected_Price_Rangerice_Range);
		mousekeyboard.mouseClick(driver, selected_Price_Rangerice_Range);
		slowBrowser.sleeper(2000);
		System.out.println("Number of results found: " + resultCounter.getText());
		slowBrowser.delay(4000);
		List<WebElement> imagename = sauceNames;
		int number = imagename.size();
		System.out.println("Total number of Sauce names found= " + number);
		slowBrowser.sleeper(2000);
	}

	public void selectResult(int resultnumber) {
		String result_xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[" + resultnumber
				+ "]/div[1]/a[1]/div[1]";
		WebElement result = driver.findElement(By.xpath(result_xpath));
		js.javaClickWebElement(result, driver);
		slowBrowser.sleeper(2000);
		System.out.println("Product page URL is: " + driver.getCurrentUrl());
		System.out.println("Product page title is: " + driver.getTitle());
		slowBrowser.sleeper(2000);
	}
}
