package com.Test.AddBeneficiaryTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckIfSelfAccountnoCanBeAddedInBeneficiaryTable {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Step # | name | target | value
	    // 1 | open | LoginPage.jsp | 
		driver.get("http://localhost:8092/OnlineBankingApplication/LoginPage.jsp");
		// 2 | type | name=uname | vini.mehta78@gmail.com
		driver.findElement(By.name("uname")).sendKeys("vini.mehta78@gmail.com");
		// 3 | type | name=pass | Vini1234
	    driver.findElement(By.name("pass")).sendKeys("Vini1234");
	    // 4 | click | css=login_btn | 
	    driver.findElement(By.id("login_btn")).click();
	    
	    // Step # | name | target | value
	    // 1 | open | BeneficiaryDetails.jsp | 
		driver.get("http://localhost:8092/OnlineBankingApplication/BeneficiaryDetails.jsp");
		// 2 | type | name=beneficiaryAccountNo | 2700001
	    driver.findElement(By.id("beneficiaryAccountNo")).sendKeys("2700001");
	    // 3 | type | name=beneficiaryName | Shivani
	    driver.findElement(By.id("beneficiaryName")).sendKeys("Shivani");
	    // 4 | type | name=IFSCCode | BKPN0BUNGRD
	    driver.findElement(By.id("IFSCCode")).sendKeys("BKPN0BUNGRD");
	    // 5 | type | name=branchName | Bund Garden
	    driver.findElement(By.id("branchName")).sendKeys("Bund Garden");
	    // 6 | type | name=bankName | Bank of Pune
	    driver.findElement(By.id("bankName")).sendKeys("Bank of Pune");
	    // 7 | click | css=btn-primary |
	    driver.findElement(By.cssSelector(".btn-primary")).click();

	}

}
