package com.dice;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.dice.pages.LoginPage;
import com.dice.pages.ProfilePage;

public class LoginTest extends BaseTest {
	public String Loginurl = "https://www.dice.com/dashboard/login";
public String validemail= "aerosoftn@gmail.com";
public String validpassword = "ganitanand12@";
	private String exptitle = "Dashboard Home Feed | Dice.com";

	@Test
	public void positiveLoginTest() {
		LoginPage loginpg = new LoginPage(driver,log);
		log.info("opening loginpage"+" Thread Id:- "+Thread.currentThread().getId());
		loginpg.openLoginPage(Loginurl);
		log.info("fill up email and password"+" Thread Id:- "+Thread.currentThread().getId()); 
		loginpg.fillupEmailAndPassword(validemail, validpassword);
		ProfilePage profilepg = loginpg.pushSigninButton();
		profilepg.waitForProfilePageToLoad();
		log.info("verify actual title"+" Thread Id:- "+Thread.currentThread().getId());
		Assert.assertTrue(profilepg.getTitle().equals(exptitle), "Actual title is not as expected");

	}

	@Test(dataProvider="CSVDataprovider",dataProviderClass=CSVDataProvider.class)
	public void negativeLoginTest(Map<String,String> testData) throws Exception {
		String expectedErrorMessage = "Email and/or password incorrect";
		String testno=testData.get("no");
		String email=testData.get("userid");
		String password=testData.get("password");
		String description=testData.get("description");
		
			
		System.out.println("Test no is : "+testno+" for "+description+"where email/pasword are "+email+" , "+password);
		LoginPage loginpg = new LoginPage(driver,log);
		loginpg.openLoginPage(Loginurl);
		// fill up email and password
		loginpg.fillupEmailAndPassword(email, password);
		loginpg.pushSigninButton();
		Thread.sleep(3000);
		String actualErrorMessage = loginpg.getLoginErrorMessage();
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage), "Actual ErrorMessage is not as expected");

	}
}
