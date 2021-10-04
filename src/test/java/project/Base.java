package project;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base 
{
	
		public WebDriver driver;
	  @BeforeTest
	  public void beforeTest() throws Exception
	  {
		  Properties p =new Properties();
		  p.load(new FileInputStream("settings.property"));
		  
		  if(p.getProperty("browser").equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", p.getProperty("cpath"));
				driver=new ChromeDriver();
				ChromeOptions options =new ChromeOptions();
				options.addArguments("--disable-notifications");
				driver=new ChromeDriver(options);
			}
			else if(p.getProperty("browser").equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", p.getProperty("fpath"));
				driver=new FirefoxDriver();
			}
		  
		  	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  	driver.manage().window().maximize();
	  }

	  @AfterTest
	  public void afterTest() throws Exception 
	  {
		  
		  Thread.sleep(1000);
		  driver.quit();
		  
	  }

}
