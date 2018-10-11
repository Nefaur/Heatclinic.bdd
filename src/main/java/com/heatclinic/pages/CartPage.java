package com.heatclinic.pages;


import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.heatclinic.framework.DriverFactory;
import com.heatclinic.framework.PropertyReader;

public class CartPage {
	
	private WebDriver driver;
	
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/span[2]")
	WebElement ORDER_VALUE;
	
	@FindBy(how=How.NAME,using="quantity")
	WebElement QUANTITY;
		
	@FindBy(how=How.XPATH,using="//div[@class='col-sm-5 cart-product-pricing']//div")
	WebElement PRODUCT_PRICE;
	
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/span[2]")
	WebElement SUMMARY_SUBTOTAL;
	
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[2]/span[2]")
	WebElement SUMMARY_TOTAL_SAVINGS;
	
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[3]/span[2]")
	WebElement SUMMARY_TAXES;
	
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[4]/span[2]")
	WebElement SUMMARY_SHIPPING;
	
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[5]/span[2]")
	WebElement SUMMARY_TOTAL;
	
	@FindBy(how=How.XPATH,using="//a[@class='btn btn-primary']")
	WebElement CHECKOUT_BUTTON;
	
	public CartPage(){
		loadCartPage();
	}
	
	private void loadCartPage() {
		this.driver=DriverFactory.initialize().getdriver();
		PageFactory.initElements(driver, this);
	}
	
	public void verify_Cartpage() {
		delay(8000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		String cartPageURL=driver.getCurrentUrl();
		System.out.println("Cart page URL is: "+cartPageURL);
		String cartPageTitle=driver.getTitle();
		System.out.println("Cart page title is: "+cartPageTitle);
	}
	
	public void change_quantity(String quantity) {
	Select quant=new Select(QUANTITY);
	quant.selectByValue(quantity);
	sleeper(2000);
	System.out.println("Order quantity: "+quantity);
	sleeper(1000);
//	System.out.println(for_removing_dollar_sign(PRODUCT_PRICE.getText()));
//	double productPrice=Integer.parseInt(productPrice);
//	int orderQuantity=Integer.parseInt(quantity);
//	int orderValue=Integer.parseInt(ORDER_VALUE.getText());
//	double finalPrice=productPrice*orderQuantity;
	System.out.println("Order value= "+ORDER_VALUE.getText());
	System.out.println("Subtotal= "+SUMMARY_SUBTOTAL.getText());
	System.out.println("Total savings= "+SUMMARY_TOTAL_SAVINGS.getText());
	System.out.println("Taxes= "+SUMMARY_TAXES.getText());
	System.out.println("Shipping= "+SUMMARY_SHIPPING.getText());
	System.out.println("Final price: "+SUMMARY_TOTAL.getText()+"\n");
	sleeper(2000);
	assertEquals("Assertion failed", ORDER_VALUE.getText(), SUMMARY_TOTAL.getText());
//	int subtotal=Integer.parseInt(SUMMARY_SUBTOTAL.getText());
//	System.out.println("Subtotal= "+SUMMARY_SUBTOTAL);
//	int totalSavings=Integer.parseInt(SUMMARY_TOTAL_SAVINGS.getText());
//	System.out.println("Total savings= "+SUMMARY_TOTAL_SAVINGS);
//	int taxes=Integer.parseInt(SUMMARY_TAXES.getText());
//	System.out.println("Taxes= "+SUMMARY_TAXES);
//	int shipping=Integer.parseInt(SUMMARY_SHIPPING.getText());
//	System.out.println("Shipping= "+SUMMARY_SHIPPING);
//	int total=Integer.parseInt(SUMMARY_TOTAL.getText());
//	System.out.println("Total= "+SUMMARY_TOTAL);
//	int checktotal=subtotal+totalSavings+taxes+shipping;
//	System.out.println("Check Total: "+checktotal);
//	assertEquals(checktotal, total);
	}
	
//	private void for_removing_dollar_sign(String string) {
//		final String dollar = "$";
//		final int dollarsize = dollar.length();
//		String removedollar = string;
//		removedollar = removedollar.replaceFirst(dollar,"0");
//		System.out.println(removedollar);
//	}
	
	public void go_to_checkout() {
		CHECKOUT_BUTTON.click();
	}
	
	private void sleeper(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void delay(int time) {
		String tbrowser=PropertyReader.BROWSER_TO_RUN;
		switch (tbrowser) {
		
		case "chrome":
			sleeper(time-time);
			break;
		
		case "ch-grid":
			sleeper(time-time);
			break;
			
		case "ch-cloud":
			sleeper(time-time);
			break;
			
		case "":
			sleeper(time-time);
			break;
			
		default:
			sleeper(time);
			break;
	}
	
	
}

	
	
	
}
