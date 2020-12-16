package org.testcases;

import org.base.TestBase;
import org.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;

	public LoginPageTest() throws Exception {
		super();
	}

	
	public void setUp() throws Exception {

		initialization();
		loginpage = new LoginPage();

	}

	

	@Test(priority = 1)
	public void LoginPageTest1() {
		
		loginpage.userLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

}
