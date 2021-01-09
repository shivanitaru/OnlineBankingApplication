// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class ChangePasswordTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void incorrectoldpassword() {
    driver.get("http://localhost:8097/OnlineBankingApplication/ChangePassword.jsp");
    driver.findElement(By.id("currentPassword")).sendKeys("Shivani1");
    driver.findElement(By.id("newPassword")).sendKeys("Vini1234");
    driver.findElement(By.id("confirmNewPassword")).sendKeys("Vini1234");
    driver.findElement(By.cssSelector(".btn-primary")).click();
    driver.findElement(By.cssSelector(".btn")).click();
    driver.findElement(By.name("uname")).sendKeys("vini.mehta78@gmail.com");
    driver.findElement(By.name("pass")).sendKeys("Vini1234");
    driver.findElement(By.id("login_btn")).click();
  }
  @Test
  public void newpassandconfirmnewpassnotsame() {
    driver.get("http://localhost:8097/OnlineBankingApplication/ChangePassword.jsp");
    driver.findElement(By.id("currentPassword")).sendKeys("Shivani1");
    driver.findElement(By.id("newPassword")).sendKeys("Vini1234");
    driver.findElement(By.id("confirmNewPassword")).sendKeys("Vini1235");
    driver.findElement(By.cssSelector(".btn-primary")).click();
    driver.findElement(By.cssSelector(".btn")).click();
    driver.findElement(By.name("uname")).sendKeys("vini.mehta78@gmail.com");
    driver.findElement(By.name("pass")).sendKeys("Vini1234");
    driver.findElement(By.id("login_btn")).click();
  }
  @Test
  public void allfieldscorrectchangepass() {
    driver.get("http://localhost:8097/OnlineBankingApplication/ChangePassword.jsp");
    driver.findElement(By.id("currentPassword")).sendKeys("wXCdzO67");
    driver.findElement(By.id("newPassword")).sendKeys("Vini1234");
    driver.findElement(By.id("confirmNewPassword")).sendKeys("Vini1234");
    driver.findElement(By.cssSelector(".btn-primary")).click();
    driver.findElement(By.cssSelector(".btn")).click();
    driver.findElement(By.name("uname")).sendKeys("shivani.taru201@gmail.com");
    driver.findElement(By.name("pass")).sendKeys("Vini1234");
    driver.findElement(By.id("login_btn")).click();
  }
}