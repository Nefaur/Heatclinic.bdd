package com.heatclinic.steps;



import com.heatclinic.pages.HomePage;
import com.heatclinic.pages.LoginPage;
import com.heatclinic.pages.MemberPage;
import com.heatclinic.pages.PageManager;
import com.heatclinic.pages.SearchFunction;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class SearchWebsite{
	

	private HomePage home=PageManager.getInstance().getHome();
	private LoginPage login=PageManager.getInstance().getLogin();
	private MemberPage member=PageManager.getInstance().getMember();
	private SearchFunction search=PageManager.getInstance().getSearch();

	@Given("Valid User opens browser")
	public void valid_User_opens_browser() {
		System.out.println("Opening website.");
	}

	@When("Valid User goes to {string} website")
	public void valid_User_goes_to_website(String website) {
		home.goToHomepage(website);
	}

	@Then("Valid User hovers to sign_in_link")
	public void valid_User_hovers_to_sign_in_link() {
		home.hoverOnSignIn();
	}

	@Then("Valid User clicks sign_in_link")
	public void valid_User_clicks_sign_in_link() {
		home.clickSignIn();
	}

	@Then("Valid User enters usercredentials in login text fields")
	public void valid_User_enters_usercredentials_in_login_text_fields(DataTable validuser){
	    login.verify_LoginPage();
	    login.dataTable(validuser);
	}

	@Then("Valid User clicks on submit button")
	public void valid_User_clicks_on_submit_button() {
		login.clickSubmit();
	}

	@Then("Valid User is taken to member page")
	public void valid_User_is_taken_to_member_page() {
		member.verify_MemberPage();
		member.verify_Member();
	}

	@Then("Valid User enters text in search field")
	public void valid_User_enters_text_in_search_field(DataTable queries) {
		search.enterSearch(queries);
	}

	@Then("Valid User chooses the selection from search box field")
	public void valid_User_chooses_the_selection_from_search_box_field() {
		search.selectQuery();
	}

	@Then("Valid User filters the selection by choosing price range")
	public void valid_User_filters_the_selection_by_choosing_price_range() {
		search.selectPrice(5);
	}

	@Then("Valid User clicks on third selection from search result")
	public void valid_User_clicks_on_third_selection_from_search_result() {
		search.selectResult(2);
	}

	@Then("Valid User logouts")
	public void valid_User_logouts() {
		member.logout();
	}

	@Then("Valid User closes browser")
	public void valid_User_closes_browser() {
		PageManager.getInstance().closePages();
		System.out.println("Closing browser.");
	}
}
