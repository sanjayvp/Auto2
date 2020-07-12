package com.dice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dice.base.BasePageObject;

public class LoginPage extends BasePageObject<LoginPage> {
private By emailfield=By.xpath("//input[@id='email']");
private By passwordfield=By.xpath("//input[@id='password']");	
private By signinButton= By.xpath("//button[@type='submit']");

public LoginPage(WebDriver driver) {
		super(driver);
		
	}

public void openLoginPage(String url) {
	getPage(url);
}
public void fillupEmailAndPassword(String email,String pswd) {
	type(email,emailfield);
	type(pswd,passwordfield);
	
}
public ProfilePage pushSigninButton() {
	click(signinButton);
	return new ProfilePage(driver);
}

	
	
}
