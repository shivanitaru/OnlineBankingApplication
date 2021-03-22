package com.Test.LoginTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllFieldsCorrect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Test name: all fields correct-login
	    // Step # | name | target | value
	    // 1 | open | LoginPage.jsp | 
		driver.get("http://localhost:8092/OnlineBankingApplication/LoginPage.jsp");
		// 2 | type | name=uname | vini.mehta78@gmail.com
	    driver.findElement(By.name("uname")).sendKeys("vini.mehta78@gmail.com");
		// 3 | type | name=pass | Vini1234
	    driver.findElement(By.name("pass")).sendKeys("Vini1234");
	    // 4 | click | css=login_btn | 
	    driver.findElement(By.id("login_btn")).click();

	}

}
