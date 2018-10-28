package com.heatclinic.junittests;

import java.util.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import com.heatclinic.framework.PropertyReader;
import com.heatclinic.pages.HomePage;
import com.heatclinic.pages.LoginPage;
import com.heatclinic.pages.PageManager;
import edu.emory.mathcs.backport.java.util.Arrays;

@RunWith(Parameterized.class)
public class InvalidLoginJUnit extends ScriptBaseJUnit {
	private HomePage home = PageManager.getInstance().getHome();
	private LoginPage login = PageManager.getInstance().getLogin();
	private String homepage = PropertyReader.TEST_HOME_URL;

	private String username;
	private String password;

	public InvalidLoginJUnit(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	@Before
	public void initializeTest() {
		setUp();
	}
	
	@After
	public void endTest() {
		tearDown();
	}

	@Parameters
	public static Collection<Object[]> userdata() {
		return Arrays.asList(new Object[][] { 
				{ "moltenboy.robin@gmail.com", "123456789" },
				{ "moltenboy@gmail.com", "A1234567@" }, 
				{ "moltenboy@gmail.com", "" }, 
				{ "", "A1234567@" } });
	}

	@Test
	public void invalidLoginTest() {
		home.goToHomepage(homepage);
		home.hoverOnSignIn();
		home.clickSignIn();
		login.verify_LoginPage();
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickSubmit();
		login.failedLogin();
	}
}
