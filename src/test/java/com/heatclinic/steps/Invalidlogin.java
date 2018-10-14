package com.heatclinic.steps;

import com.heatclinic.pages.HomePage;
import com.heatclinic.pages.LoginPage;
import com.heatclinic.pages.PageManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Invalidlogin {

	private HomePage home = PageManager.getInstance().getHome();
	private LoginPage login = PageManager.getInstance().getLogin();

	@Given("Invalid User opens browser")
	public void invalid_user_opens_browser() {
		System.out.println("Opening website.");
	}

	@When("Invalid User goes to {string} website")
	public void invalid_user_goes_to_website(String website) {
		home.goToHomepage(website);
	}

	@Then("Invalid User hovers to sign_in_link")
	public void invalid_user_hovers_to_sign_in_link() {
		home.hoverOnSignIn();
	}

	@Then("Invalid User clicks sign_in_link")
	public void invalid_user_clicks_sign_in_link() {
		home.clickSignIn();
	}

	@Then("Invalid User enters {string} as username")
	public void invalid_User_enters_as_username(String username) {
		login.verify_LoginPage();
		login.enterUsername(username);
	}

	@Then("Invalid User enters {string} as password")
	public void invalid_User_enters_as_password(String password) {
		login.enterPassword(password);
	}

	@Then("Invalid User clicks on submit button")
	public void invalid_User_clicks_on_submit_button() {
		login.clickSubmit();
	}

	@Then("Invalid User gets failed login message")
	public void invalid_user_gets_failed_login_message() {
		login.failedLogin();
	}

	@Then("Invalid User closes browser")
	public void invalid_user_closes_browser() {
		PageManager.getInstance().closePages();
		System.out.println("Closing browser.");
	}

}
