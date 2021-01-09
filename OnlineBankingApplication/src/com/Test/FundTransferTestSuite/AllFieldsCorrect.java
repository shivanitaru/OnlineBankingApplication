package com.Test.FundTransferTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllFieldsCorrect {
	public static void main(String[] args) {

		// declaration and instantiation of objects/variables
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Launch website
		// Test name: Correct fields-success
	    // Step # | name | target | value
	    // 1 | open | FundTransfer.jsp | 
	    driver.get("http://localhost:8097/OnlineBankingApplication/FundTransfer.jsp");
	    // 2 | type | id=remitterAccountNo | 2700008
	    driver.findElement(By.id("remitterAccountNo")).sendKeys("2700008");
	    // 3 | type | id=beneficiaryAccountNo | 2700001
	    driver.findElement(By.id("beneficiaryAccountNo")).sendKeys("2700001");
	    // 4 | type | id=beneficiaryName | Vini
	    driver.findElement(By.id("beneficiaryName")).sendKeys("Vini");
	    // 5 | type | id=IFSCCode | SDDS0SDDSSD
	    driver.findElement(By.id("IFSCCode")).sendKeys("SDDS0SDDSSD");
	    // 6 | type | id=amount | 500
	    driver.findElement(By.id("amount")).sendKeys("500");
	    // 7 | click | css=.btn-primary | 
	    driver.findElement(By.cssSelector(".btn-primary")).click();
	  
	}
}
