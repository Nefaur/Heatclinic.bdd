package com.heatclinic.junittests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.heatclinic.framework.PropertyReader;
import com.heatclinic.pages.CartPage;
import com.heatclinic.pages.CheckoutPage;
import com.heatclinic.pages.HomePage;
import com.heatclinic.pages.LoginPage;
import com.heatclinic.pages.MemberPage;
import com.heatclinic.pages.PageManager;
import com.heatclinic.pages.ProductPage;
import com.heatclinic.pages.SearchFunction;

public class ValidCheckoutJUnit extends ScriptBaseJUnit {

	private HomePage home = PageManager.getInstance().getHome();
	private LoginPage login = PageManager.getInstance().getLogin();
	private MemberPage member = PageManager.getInstance().getMember();
	private SearchFunction search = PageManager.getInstance().getSearch();
	private ProductPage product = PageManager.getInstance().getProductPage();
	private CartPage cart = PageManager.getInstance().getCartPage();
	private CheckoutPage checkOut = PageManager.getInstance().getCheckoutPage();

	private String username = PropertyReader.USERNAME;
	private String password = PropertyReader.PASSWORD;
	private String homepage = PropertyReader.TEST_HOME_URL;
	private String searchtext = PropertyReader.TEST_SEARCH_TEXT;

	@Before
	public void initializeTest() {
		setUp();
	}
	
	@After
	public void endTest() {
		tearDown();
	}
	
	@Test
	public void validCheckout() {
		home.goToHomepage(homepage);
		home.hoverOnSignIn();
		home.clickSignIn();
		login.verify_LoginPage();
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickSubmit();
		member.verify_MemberPage();
		member.verify_Member();
		search.enterSearch(searchtext);
		search.selectQuery();
		search.selectPrice(5);
		search.selectResult(3);
		product.product_Details();
		product.addToCart();
		product.go_to_cartpage();
		cart.verify_Cartpage();
		cart.change_quantity("2");
		cart.change_quantity("1");
		cart.go_to_checkout();
		checkOut.verify_Checkoutpage();
		checkOut.enterShippingInfo();
		checkOut.paymentInfo();
		checkOut.order_Confirmation();
		member.logout();
	}
}
