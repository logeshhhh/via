package project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base 
{
	WebDriver driver;
	@BeforeTest
	  public void beforeTest() 
	  {
		  System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		 
		  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		  
		  
	  }

	  @AfterTest
	  public void afterTest()throws Exception 
	  {
		  Thread.sleep(2000);
		  driver.quit();
	  }
}
