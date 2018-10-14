package com.heatclinic.steps;

import com.heatclinic.pages.CartPage;
import com.heatclinic.pages.CheckoutPage;
import com.heatclinic.pages.HomePage;
import com.heatclinic.pages.LoginPage;
import com.heatclinic.pages.MemberPage;
import com.heatclinic.pages.PageManager;
import com.heatclinic.pages.ProductPage;
import com.heatclinic.pages.SearchFunction;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class ValidCheckout {

	private HomePage home = PageManager.getInstance().getHome();
	private LoginPage login = PageManager.getInstance().getLogin();
	private MemberPage member = PageManager.getInstance().getMember();
	private SearchFunction search = PageManager.getInstance().getSearch();
	private ProductPage product = PageManager.getInstance().getProductPage();
	private CartPage cart = PageManager.getInstance().getCartPage();
	private CheckoutPage checkOut = PageManager.getInstance().getCheckoutPage();

	@Given("Existing Valid User opens browser")
	public void existing_Valid_User_opens_browser() {
		System.out.println("Opening website.");
	}

	@When("Existing Valid User goes to {string} website")
	public void existing_Valid_User_goes_to_website(String website) {
		home.goToHomepage(website);
	}

	@Then("Existing Valid User hovers to sign_in_link")
	public void existing_Valid_User_hovers_to_sign_in_link() {
		home.hoverOnSignIn();
	}

	@Then("Existing Valid User clicks sign_in_link")
	public void existing_Valid_User_clicks_sign_in_link() {
		home.clickSignIn();
	}

	@Then("Existing Valid User enters username and password in login text fields")
	public void existing_Valid_User_enters_username_and_password_in_login_text_fields(DataTable validuser) {
		login.verify_LoginPage();
		login.dataTable(validuser);
	}

	@Then("Existing Valid User clicks on submit button")
	public void existing_Valid_User_clicks_on_submit_button() {
		login.clickSubmit();
	}

	@Then("Existing Valid User is taken to member page")
	public void existing_Valid_User_is_taken_to_member_page() {
		member.verify_MemberPage();
		member.verify_Member();
	}

	@Then("Existing Valid User enters text in search field")
	public void existing_Valid_User_enters_text_in_search_field(DataTable queries) {
		search.enterSearch(queries);
	}

	@Then("Logged in User chooses the selection from search box field")
	public void logged_in_User_chooses_the_selection_from_search_box_field() {
		search.selectQuery();
	}

	@Then("Logged in User filters the selection by choosing price range")
	public void logged_in_User_filters_the_selection_by_choosing_price_range() {
		search.selectPrice(5);
	}

	@Then("Logged in User clicks on a selection from search result")
	public void logged_in_User_clicks_on_a_selection_from_search_result() {
		search.selectResult(2);
		product.product_Details();
	}

	@Then("Logged in User clicks add to cart")
	public void logged_in_User_clicks_add_to_cart() {
		product.addToCart();
	}

	@Then("Logged in User goes to view cart page")
	public void logged_in_User_goes_to_view_cart_page() {
		product.go_to_cartpage();
	}

	@Then("Logged in User goes to checkout page")
	public void logged_in_User_goes_to_checkout_page() {
		cart.verify_Cartpage();
	}

	@Then("Logged in User increases the number of selected items to two and then decreases to one")
	public void logged_in_user_increases_the_number_of_selected_items_to_two_and_then_decreases_to_one() {
		cart.change_quantity("2");
		cart.change_quantity("1");
	}

	@Then("Logged in User clicks checkout button")
	public void logged_in_User_clicks_checkout_button() {
		cart.go_to_checkout();
	}

	@Then("Logged in User fills in shipping information and clicks Continue")
	public void logged_in_User_fills_in_shipping_information_and_clicks_Continue() {
		checkOut.verify_Checkoutpage();
		checkOut.enterShippingInfo();
	}

	@Then("Logged in User fills in payment information")
	public void logged_in_User_fills_in_payment_information() {
		checkOut.paymentInfo();
	}

	@Then("Logged in User gets purchase confirmation notification")
	public void logged_in_User_gets_purchase_confirmation_notification() {
		checkOut.order_Confirmation();
	}

	@Then("Logged in User logouts")
	public void logged_in_User_logouts() {
		member.logout();
	}

	@Then("Logged out User closes browser")
	public void logged_out_User_closes_browser() {
		PageManager.getInstance().closePages();
		System.out.println("Closing browser.");
	}
}