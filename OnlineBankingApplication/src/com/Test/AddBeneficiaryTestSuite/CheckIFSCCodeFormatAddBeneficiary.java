package com.Test.AddBeneficiaryTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckIFSCCodeFormatAddBeneficiary {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Step # | name | target | value
	    // 1 | open | LoginPage.jsp | 
		driver.get("http://localhost:8092/OnlineBankingApplication/LoginPage.jsp");
		// 2 | type | name=uname | shivani.taru201@gmail.com
		driver.findElement(By.name("uname")).sendKeys("shivani.taru201@gmail.com");
		// 3 | type | name=pass | UsgrvQ85
	    driver.findElement(By.name("pass")).sendKeys("Vini1234");
	    // 4 | click | css=login_btn | 
	    driver.findElement(By.id("login_btn")).click();
	    
	    // Step # | name | target | value
	    // 1 | open | BeneficiaryDetails.jsp | 
		driver.get("http://localhost:8092/OnlineBankingApplication/BeneficiaryDetails.jsp");
		// 2 | type | name=beneficiaryAccountNo | 2700004
	    driver.findElement(By.id("beneficiaryAccountNo")).sendKeys("2700004");
	    // 3 | type | name=beneficiaryName | Omkar
	    driver.findElement(By.id("beneficiaryName")).sendKeys("Omkar");
	    // 4 | type | name=IFSCCode | asdfgh123567
	    driver.findElement(By.id("IFSCCode")).sendKeys("asdfgh123567");
	    // 5 | type | name=branchName | Bund Garden
	    driver.findElement(By.id("branchName")).sendKeys("Bund Garden");
	    // 6 | type | name=bankName | Bank of Pune
	    driver.findElement(By.id("bankName")).sendKeys("Bank of Pune");
	    // 7 | click | css=btn-primary |
	    driver.findElement(By.cssSelector(".btn-primary")).click();

	}
}
