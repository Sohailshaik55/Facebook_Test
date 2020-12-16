package org.pageobjects;

import org.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

	public LoginPage() throws Exception {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	WebElement username;

	@FindBy(id = "password")
	WebElement pass;

	@FindBy(xpath = "button=[@type='submit']")
	WebElement loginBtn;

	
	public void userLogin(String uname, String pwd) {

		username.sendKeys(uname);
		pass.sendKeys(pwd);
		loginBtn.click();

	}

}
