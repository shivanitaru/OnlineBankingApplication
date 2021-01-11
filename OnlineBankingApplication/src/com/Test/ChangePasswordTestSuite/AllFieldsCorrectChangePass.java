package com.Test.ChangePasswordTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllFieldsCorrectChangePass {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Step # | name | target | value
	    // 1 | open | LoginPage.jsp | 
		driver.get("http://localhost:8092/OnlineBankingApplication/LoginPage.jsp");
		// 2 | type | name=uname | shivani.taru201@gmail.com
		driver.findElement(By.name("uname")).sendKeys("shivani.taru201@gmail.com");
		// 3 | type | name=pass | UsgrvQ85
	    driver.findElement(By.name("pass")).sendKeys("UsgrvQ85");
	    // 4 | click | css=login_btn | 
	    driver.findElement(By.id("login_btn")).click();
	    
	    // Step # | name | target | value
	    // 1 | open | ChangePassword.jsp | 
	    driver.get("http://localhost:8092/OnlineBankingApplication/ChangePassword.jsp");
		// 2 | type | name=currentPassword | UsgrvQ85
	    driver.findElement(By.id("currentPassword")).sendKeys("UsgrvQ85");
	    // 3 | type | name=newPassword | Shivani1234
	    driver.findElement(By.id("newPassword")).sendKeys("Shivani1234");
	    // 4 | type | name=confirmNewPassword | Shivani123
	    driver.findElement(By.id("confirmNewPassword")).sendKeys("Shivani1234");
	    // 5 | click | css=btn-primary |
	    driver.findElement(By.cssSelector(".btn-primary")).click();
	    // 6 | click | css=btn |
	    driver.findElement(By.cssSelector(".btn")).click();
	    // 7 | type | name=uname | shivani.taru201@gmail.com
	    driver.findElement(By.name("uname")).sendKeys("shivani.taru201@gmail.com");
	    // 8 | type | name=pass | Shivani1234
	    driver.findElement(By.name("pass")).sendKeys("Shivani1234");
	    // 9 | click | css=login_btn |
	    driver.findElement(By.id("login_btn")).click();

	}

}
