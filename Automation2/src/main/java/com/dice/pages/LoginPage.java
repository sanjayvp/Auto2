package com.dice.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dice.base.BasePageObject;

public class LoginPage extends BasePageObject<LoginPage> {
private By emailfield=By.xpath("//input[@id='email']");
private By passwordfield=By.xpath("//input[@id='password']");	
private By signinButton= By.xpath("//button[@type='submit']");
public  By ErrorMessageLocator=By.xpath("//*[@data-automation-id='login-failure-help-message']");
Logger log;
public LoginPage(WebDriver driver,Logger log) {
		super(driver);
		this.log=log;
		
	}

public void openLoginPage(String url) {
	log.info("opening url "+url+" Thread Id:- "+Thread.currentThread().getId());
	getPage(url);
	
}
public void fillupEmailAndPassword(String email,String pswd) {
	type(email,emailfield);
	type(pswd,passwordfield);
	
}
public ProfilePage pushSigninButton() {
	log.info("Clicking on sign In Button "+" Thread Id:- "+Thread.currentThread().getId());
	click(signinButton);
	return new ProfilePage(driver);
}

public  String  getLoginErrorMessage() {
	waitForVisibilityOf(ErrorMessageLocator, 10);
	String er=driver.findElement(ErrorMessageLocator).getText();
	return er;
	
}





	
	
}
