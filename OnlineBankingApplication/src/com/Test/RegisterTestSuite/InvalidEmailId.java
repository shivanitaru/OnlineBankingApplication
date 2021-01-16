package com.Test.RegisterTestSuite;

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


	    // Test name: all fields correct-register
	    // Step # | name | target | value
	    // 1 | open | RegistrationPage.jsp | 
	    driver.get("http://localhost:8092/OnlineBankingApplication/RegistrationPage.jsp");
	    // 2 | type | name=FirstName | Shivani
	    driver.findElement(By.name("FirstName")).sendKeys("Shivani");
	    // 3 | type | name=MiddleName | Vijay
	    driver.findElement(By.name("MiddleName")).sendKeys("Vijay");
	    // 4 | type | name=LastName | Taru
	    driver.findElement(By.name("LastName")).sendKeys("Taru");
	    // 5 | type | name=FatherFirstName | Vijay
	    driver.findElement(By.name("FatherFirstName")).sendKeys("Vijay");
	    // 6 | type | name=FatherMiddleName | sd
	    driver.findElement(By.name("FatherMiddleName")).sendKeys("sd");
	    // 7 | type | name=FatherLastName | Taru
	    driver.findElement(By.name("FatherLastName")).sendKeys("Taru");
	    // 8 | click | css=.custom_radio > .input1:nth-child(3) | 
	    driver.findElement(By.cssSelector(".custom_radio > .input1:nth-child(3)")).click();
	    // 9 | type | name=dob | 1999-11-13
	    driver.findElement(By.name("dob")).sendKeys("1999-11-13");
	    // 10 | type | name=address | Hadapsar
	    driver.findElement(By.name("address")).sendKeys("Hadapsar");
	    // 11 | type | name=city | Pune
	    driver.findElement(By.name("city")).sendKeys("Pune");
	    // 12 | type | name=state | Maharashtra
	    driver.findElement(By.name("state")).sendKeys("Maharashtra");
	    // 13 | type | name=pincode | 411005
	    driver.findElement(By.name("pincode")).sendKeys("411005");
	    // 14 | type | name=mobile | 8149412559
	    driver.findElement(By.name("mobile")).sendKeys("8149412559");
	    // 15 | type | name=email | shivani.taru201@gmail.com
	    driver.findElement(By.name("email")).sendKeys("abcsdkl");
	    // 16 | type | name=nationality | India
	    driver.findElement(By.name("nationality")).sendKeys("India");
	    // 17 | type | name=aadhaar | 856341526355
	    driver.findElement(By.name("aadhaar")).sendKeys("856341526355");
	    // 18 | type | name=pancard | DSDGA1235S
	    driver.findElement(By.name("pancard")).sendKeys("DSDGA1235S");
	    // 19 | type | name=accountType | Saving
	    driver.findElement(By.name("accountType")).sendKeys("Saving");
	    // 20 | type | name=branchName | Hadapsar
	    driver.findElement(By.name("branchName")).sendKeys("Hadapsar");
	    // 21 | click | css=.primary | 
	    driver.findElement(By.name("submit")).click();
	}
}
