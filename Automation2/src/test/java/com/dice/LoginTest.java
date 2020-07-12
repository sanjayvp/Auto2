package com.dice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dice.pages.LoginPage;
import com.dice.pages.ProfilePage;

public class LoginTest extends BaseTest{
	public String Loginurl="https://www.dice.com/dashboard/login";
	public String email="aerosoftn@gmail.com";
	public String password="ganitanand12@";
	private String exptitle="Dashboard Home Feed | Dice.com";
@Test
public void positiveLoginTest() {
	LoginPage loginpg=new LoginPage(driver);
	loginpg.openLoginPage(Loginurl);
	//fill up email and password
	loginpg.fillupEmailAndPassword(email, password);
	ProfilePage profilepg=loginpg.pushSigninButton();
	profilepg.waitForProfilePageToLoad();
	Assert.assertTrue(profilepg.getTitle().equals(exptitle), "Actual title is not as expected");

	
}
}
