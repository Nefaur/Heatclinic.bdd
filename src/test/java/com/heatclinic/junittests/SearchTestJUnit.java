package com.heatclinic.junittests;

import org.junit.Test;

import com.heatclinic.framework.PropertyReader;
import com.heatclinic.pages.HomePage;
import com.heatclinic.pages.LoginPage;
import com.heatclinic.pages.MemberPage;
import com.heatclinic.pages.PageManager;
import com.heatclinic.pages.SearchFunction;

public class SearchTestJUnit extends ScriptBaseJUnit{

	private HomePage home = PageManager.getInstance().getHome();
	private LoginPage login = PageManager.getInstance().getLogin();
	private MemberPage member = PageManager.getInstance().getMember();
	private SearchFunction search = PageManager.getInstance().getSearch();

	private String username = PropertyReader.USERNAME;
	private String password = PropertyReader.PASSWORD;
	private String homepage = PropertyReader.TEST_HOME_URL;
	private String searchtext = PropertyReader.TEST_SEARCH_TEXT;
	
	@Test
	public void searchTest() {
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
		search.selectResult(2);
		member.logout();
	}
}
