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
				"C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Launch website

		// Test name: Correct Forgot password process
		// Step # | name | target | value

		// 1 | open | LoginPage.jsp |
		driver.navigate().to("http://localhost:8097/OnlineBankingApplication/LoginPage.jsp");
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
		driver.get("http://localhost:8097/OnlineBankingApplication/ResetPassword.jsp");
		// 8 | type | id=password | Vini1234
		driver.findElement(By.id("password")).sendKeys("Vini1234");
		// 9 | type | id=confirmPassword | Vini1234
		driver.findElement(By.id("confirmPassword")).sendKeys("Vini1234");
		// 10 | click | css=.btn-success |
		driver.findElement(By.cssSelector(".btn-success")).click();
	}
}
