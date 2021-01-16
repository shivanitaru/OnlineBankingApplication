package com.Test.ForgotPasswordTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllFieldsCorrect {

	public static void main(String[] args) {

		// declaration and instantiation of objects/variables
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Launch website

		// Test name: Correct Forgot password process
		// Step # | name | target | value

		// 1 | open | LoginPage.jsp |
		driver.navigate().to("http://localhost:8092/OnlineBankingApplication/LoginPage.jsp");
		// 2 | click | linkText=Forgot your password? |
		driver.findElement(By.linkText("Forgot your password?")).click();
		// 3 | click | css=span |
		driver.findElement(By.name("forgotbtn")).click();
		// 4 | type | name=emailId | shivani.taru201@gmail.com
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.name("emailId"))).click();
		driver.findElement(By.name("emailId")).sendKeys("shivani.taru201@gmail.com");
		// 5 | click | css=.btn-lg |
		driver.findElement(By.cssSelector(".btn-lg")).click();
		// 6 | click | css=.btn |
		driver.findElement(By.cssSelector(".btn")).click();
		// 7 | open | ResetPassword.jsp |
		driver.get("http://localhost:8092/OnlineBankingApplication/ResetPassword.jsp");
		// 8 | type | id=password | Vini1234
		driver.findElement(By.id("password")).sendKeys("Vini1234");
		// 9 | type | id=confirmPassword | Vini1234
		driver.findElement(By.id("confirmPassword")).sendKeys("Vini1234");
		// 10 | click | css=.btn-success |
		driver.findElement(By.cssSelector(".btn-success")).click();
		driver.findElement(By.name("uname")).sendKeys("shivani.taru201@gmail.com");
		// 3 | type | name=pass | UsgrvQ85
	    driver.findElement(By.name("pass")).sendKeys("Vini1234");
	    // 4 | click | css=login_btn | 
	    driver.findElement(By.id("login_btn")).click();
	}
}
