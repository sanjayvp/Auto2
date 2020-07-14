package com.dice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
WebDriver driver;
	
	
@Parameters({"browser"})
@BeforeMethod
	public void setUp(String br) {
	switch (br) {
	case "chrome":	driver=new ChromeDriver();
								break;
	case "firefox" :		driver=new FirefoxDriver();
								break;
	default :				driver=new ChromeDriver();
								break;

	}
		

	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
