package com.Test.FundTransferTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckAmountMoreThanBalance {
	public static void main(String[] args) {

		// declaration and instantiation of objects/variables
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

	// Test name: Check amount more than balance
    // Step # | name | target | value
    // 1 | open | FundTransfer.jsp | 
    driver.get("http://localhost:8097/OnlineBankingApplication/FundTransfer.jsp");
    // 2 | type | id=remitterAccountNo | 2700001
    driver.findElement(By.id("remitterAccountNo")).sendKeys("2700001");
    // 3 | type | id=beneficiaryAccountNo | 2700002
    driver.findElement(By.id("beneficiaryAccountNo")).sendKeys("2700002");
    // 4 | type | id=beneficiaryName | Vini
    driver.findElement(By.id("beneficiaryName")).sendKeys("Vini");
    // 5 | type | id=IFSCCode | SDDS0SDDSSD
    driver.findElement(By.id("IFSCCode")).sendKeys("SDDS0SDDSSD");
    // 6 | type | id=amount | 4000
    driver.findElement(By.id("amount")).sendKeys("4000");
    // 7 | click | css=.btn-primary | 
    driver.findElement(By.cssSelector(".btn-primary")).click();
	}
}
