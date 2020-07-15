package com.dice;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
WebDriver driver;
Logger log;
	
	
@Parameters({"browser"})
@BeforeMethod
	public void setUp(String br) {
	log=Logger.getLogger(".\\src\\main\\resources\\log4j.properties");
	log.info("opening driver in " +br+" Test with Thread Id:- "+Thread.currentThread().getId());
	log.info("Test with Thread Id:- "+Thread.currentThread().getId());
	switch (br) {
	case "chrome":	driver=new ChromeDriver();
								break;
	case "firefox" :		driver=new FirefoxDriver();
								break;
	default :				driver=new ChromeDriver();
								break;

	}
		

	}
@Parameters({"browser"})
	@AfterMethod
	public void teardown(String br) {
		log.info("Closing browser :"+br+" Test with Thread Id:- "+Thread.currentThread().getId());
		driver.quit();
	}

}
