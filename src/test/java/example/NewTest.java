package example;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {
	WebDriver driver ;
  @Test
  public void f() {
	  driver.get("http://localhost:8090/samplemaven/");
	  driver.findElement(By.xpath("//input[@type='text']")).sendKeys("test");
	  driver.findElement(By.xpath("//input[@type='button']")).click();
	  Assert.assertTrue(driver.getPageSource().contains("Recoreded"));
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "D:\\SeleniumTest\\ChromeDriver\\Chromedriver.exe");
	     driver = new ChromeDriver();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
