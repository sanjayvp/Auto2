package com.dice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dice.base.BasePageObject;

public class ProfilePage extends BasePageObject<ProfilePage>{
	
	private By AddProfileButton=By.xpath("(//*[text()='Add to Profile'])[4]");
 public ProfilePage(WebDriver driver) {
	 super(driver);
	 
 }
 public void waitForProfilePageToLoad() {
	 waitForVisibilityOf(AddProfileButton, 20);
 }
 
 
}
