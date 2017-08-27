package example;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {
	WebDriver driver ;
	String userprofile ;
  @Test
  public void f() {
	  driver.get("http://13.126.109.72:8080/webapp/");
	  driver.findElement(By.xpath("//input[@type='text']")).sendKeys("test");
	  getscreenshot("input1");
	  driver.findElement(By.xpath("//input[@type='button']")).click();
	  getscreenshot("validation1");
	  Assert.assertTrue(driver.getPageSource().contains("Recorded"));
	  
  }
  
  public void getscreenshot(String strname)
  {
	  System.out.println("User Profile as per Java is "+userprofile);
	  String imgname = strname + "_" + new SimpleDateFormat("ddMMMYYYYhhmmss").format(new Date()) + ".jpg";
	  File scrfile =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 try {
			FileUtils.copyFile(scrfile, new File(userprofile+"\\Screenshots\\"+imgname));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  @BeforeTest
  public void beforeTest() {
	  userprofile = System.getenv("USERPROFILE");
	  System.out.println("User Profile as per Java is "+userprofile);
	  System.setProperty("webdriver.chrome.driver", userprofile+"\\ChromeDriver\\Chromedriver.exe");
	     driver = new ChromeDriver();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
