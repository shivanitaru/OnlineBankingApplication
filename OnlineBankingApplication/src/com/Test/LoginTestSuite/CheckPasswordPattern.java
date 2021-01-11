package com.Test.LoginTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckPasswordPattern {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Test name: Check Password Pattern
	    // Step # | name | target | value
	    // 1 | open | LoginPage.jsp |
		driver.get("http://localhost:8092/OnlineBankingApplication/LoginPage.jsp");
		// 2 | type | name=uname | shivani.taru201@gmail.com
	    driver.findElement(By.name("uname")).sendKeys("shivani.taru201@gmail.com");
	    // 3 | type | name=pass | Usgr85
	    driver.findElement(By.name("pass")).sendKeys("Usgr85");
	    // 4 | click | css=login_btn |
	    driver.findElement(By.id("login_btn")).click();
		    
	}

}
