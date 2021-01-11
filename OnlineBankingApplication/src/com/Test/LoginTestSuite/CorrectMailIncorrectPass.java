package com.Test.LoginTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CorrectMailIncorrectPass {
	
	public static void main(String[] args) {
			
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Test name: Correct Mail Incorrect Pass
	    // Step # | name | target | value
	    // 1 | open | LoginPage.jsp |
		driver.get("http://localhost:8092/OnlineBankingApplication/LoginPage.jsp");
		// 2 | type | name=uname | shivani
	    driver.findElement(By.name("uname")).sendKeys("shivani.taru201@gmail.com");
	    // 3 | type | name=pass | UsgrvQ85
	    driver.findElement(By.name("pass")).sendKeys("PQcbnx13");
	    // 4 | click | css=login_btn |
	    driver.findElement(By.id("login_btn")).click();
		    
	}

}
