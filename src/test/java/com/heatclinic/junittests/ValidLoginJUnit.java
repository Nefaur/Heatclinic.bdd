package com.heatclinic.junittests;

import org.junit.Test;
import com.heatclinic.framework.PropertyReader;
import com.heatclinic.pages.HomePage;
import com.heatclinic.pages.LoginPage;
import com.heatclinic.pages.MemberPage;
import com.heatclinic.pages.PageManager;

public class ValidLoginJUnit extends ScriptBaseJUnit{

	private String username = PropertyReader.USERNAME;
	private String password = PropertyReader.PASSWORD;
	private String homepage = PropertyReader.TEST_HOME_URL;

	private HomePage home = PageManager.getInstance().getHome();
	private LoginPage login = PageManager.getInstance().getLogin();
	private MemberPage member = PageManager.getInstance().getMember();

	@Test
	public void validLogin() {
		home.goToHomepage(homepage);
		home.hoverOnSignIn();
		home.clickSignIn();
		login.verify_LoginPage();
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickSubmit();
		member.verify_MemberPage();
		member.verify_Member();
		member.logout();
	}
}
