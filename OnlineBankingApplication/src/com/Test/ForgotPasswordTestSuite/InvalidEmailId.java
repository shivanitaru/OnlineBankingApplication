package com.Test.ForgotPasswordTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvalidEmailId {
	public static void main(String[] args) {

		// declaration and instantiation of objects/variables
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Launch website
		
		// Test name: Invalid Email Id
	    // Step # | name | target | value
	    // 1 | open | LoginPage.jsp | 
	    driver.get("http://localhost:8092/OnlineBankingApplication/LoginPage.jsp");
	    // 2 | click | linkText=Forgot your password? | 
	    driver.findElement(By.linkText("Forgot your password?")).click();
	    // 3 | click | css=span | 
	    driver.findElement(By.name("forgotbtn")).click();
	    // 4 | click | name=emailId | 
	    new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.name("emailId"))).click();
	    // 5 | type | name=emailId | abc@gmail.com
	    driver.findElement(By.name("emailId")).sendKeys("abc@gmail.com");
	    // 6 | click | css=.btn-lg | 
	    driver.findElement(By.cssSelector(".btn-lg")).click();

	}
}
