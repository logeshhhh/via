package project;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class MultiCityFlightBooking extends Base 
{
	Excel_Import ex= new Excel_Import("D:\\LTI\\TRAINING\\SELENIUM TESTING\\Data.xlsx");
	Properties p =new Properties();
	ExtentReports ex1= new ExtentReports();
	
	public void multicity(String from1,String to1,String from2,String to2,String airline) throws Exception 
	{
		  p.load(new FileInputStream("settings.property"));
		  driver.get(p.getProperty("url"));
		  ex1.attachReporter(new ExtentHtmlReporter("MultiCityFlight.html"));
		  driver.manage().deleteAllCookies();
		  driver.findElement(By.xpath(p.getProperty("multiCity"))).click();
		  driver.findElement(By.id(p.getProperty("from1"))).clear();
		  driver.findElement(By.id(p.getProperty("from1"))).sendKeys(from1);
		  Thread.sleep(1000);
		  driver.findElement(By.id(p.getProperty("from1"))).sendKeys(Keys.ARROW_DOWN);
		  Thread.sleep(1000);
		  driver.findElement(By.id(p.getProperty("from1"))).sendKeys(Keys.ENTER);
		  Thread.sleep(1000);
		  driver.findElement(By.id(p.getProperty("to1"))).clear();
		  driver.findElement(By.id(p.getProperty("to1"))).sendKeys(to1);
		  Thread.sleep(1000);
		  driver.findElement(By.id(p.getProperty("to1"))).sendKeys(Keys.ARROW_DOWN);
		  Thread.sleep(1000);
		  driver.findElement(By.id(p.getProperty("to1"))).sendKeys(Keys.ENTER);
		  driver.manage().deleteAllCookies();
		  driver.findElement(By.xpath(p.getProperty("calendar1"))).click();
		  driver.findElement(By.xpath(p.getProperty("departure1"))).click();
		  Thread.sleep(1000); 
		  driver.findElement(By.cssSelector(p.getProperty("more"))).click();
		  driver.findElement(By.id(p.getProperty("airline"))).clear();
		  driver.findElement(By.id(p.getProperty("airline"))).sendKeys(airline);
		  driver.findElement(By.id(p.getProperty("airline"))).sendKeys(Keys.DOWN);
		  driver.findElement(By.id(p.getProperty("airline"))).sendKeys(Keys.ENTER);
		  driver.findElement(By.id(p.getProperty("class"))).click();
		  driver.findElement(By.cssSelector(p.getProperty("economy"))).click();
		  driver.findElement(By.id(p.getProperty("routing"))).click();
		  
		  
		  driver.findElement(By.id(p.getProperty("flight2"))).click();
		  driver.findElement(By.id(p.getProperty("from2"))).clear();
		  driver.findElement(By.id(p.getProperty("from2"))).sendKeys(from2);
		  Thread.sleep(1000);
		  driver.findElement(By.id(p.getProperty("from2"))).sendKeys(Keys.ARROW_DOWN);
		  Thread.sleep(1000);
		  driver.findElement(By.id(p.getProperty("from2"))).sendKeys(Keys.ENTER);
		  Thread.sleep(1000);
		  driver.findElement(By.id(p.getProperty("to2"))).clear();
		  driver.findElement(By.id(p.getProperty("to2"))).sendKeys(to2);
		  Thread.sleep(1000);
		  driver.findElement(By.id(p.getProperty("to2"))).sendKeys(Keys.ARROW_DOWN);
		  Thread.sleep(1000);
		  driver.findElement(By.id(p.getProperty("to2"))).sendKeys(Keys.ENTER);
		  Thread.sleep(1000);
		  driver.manage().deleteAllCookies();
		  driver.findElement(By.xpath(p.getProperty("calendar2"))).click();
		  driver.findElement(By.xpath(p.getProperty("departure2"))).click();
		  Thread.sleep(1000);
		  driver.findElement(By.cssSelector(p.getProperty("more"))).click();
		  driver.findElement(By.id(p.getProperty("airline"))).clear();
		  driver.findElement(By.id(p.getProperty("airline"))).sendKeys(airline);
		  driver.findElement(By.id(p.getProperty("airline"))).sendKeys(Keys.DOWN);
		  driver.findElement(By.id(p.getProperty("airline"))).sendKeys(Keys.ENTER);
		  driver.findElement(By.id(p.getProperty("class"))).click();
		  driver.findElement(By.cssSelector(p.getProperty("economy"))).click();
		  driver.findElement(By.id(p.getProperty("routing"))).click();
		  driver.findElement(By.cssSelector(p.getProperty("direct"))).click();
		  
		  driver.findElement(By.id(p.getProperty("searchFlights"))).click();
		  Thread.sleep(5000);
	}
	
	public void booking() throws Exception 
	{
		p.load(new FileInputStream("settings.property"));
	    driver.findElement(By.xpath(p.getProperty("filter"))).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(p.getProperty("selectAll"))).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(p.getProperty("airasia"))).click();
	    Thread.sleep(1000);	  
		 p.load(new FileInputStream("settings.property"));
		 List<WebElement> ls=driver.findElements(By.cssSelector(p.getProperty("book_rt")));
		 ls.get(0).click();
		 driver.findElement(By.xpath(p.getProperty("book_rt1"))).click();
		 driver.findElement(By.xpath(p.getProperty("bookFlights"))).click();
	     Thread.sleep(3000);
	}
	
	public void details(String title,String fname,String lname,String date,String month,String year,String mobile,String email) throws Exception
	{
		driver.findElement(By.id(p.getProperty("title"))).sendKeys(title);
		driver.findElement(By.id(p.getProperty("firstName"))).clear();
		driver.findElement(By.id(p.getProperty("firstName"))).sendKeys(fname);
		driver.findElement(By.id(p.getProperty("lastName"))).clear();
		driver.findElement(By.id(p.getProperty("lastName"))).sendKeys(lname);
		driver.findElement(By.id(p.getProperty("day"))).sendKeys(date);
		driver.findElement(By.id(p.getProperty("month"))).sendKeys(month);
		driver.findElement(By.id(p.getProperty("year"))).sendKeys(year);
		driver.findElement(By.id(p.getProperty("mobile"))).clear();
		driver.findElement(By.id(p.getProperty("mobile"))).sendKeys(mobile);
		driver.findElement(By.id(p.getProperty("email"))).clear();
		driver.findElement(By.id(p.getProperty("email"))).sendKeys(email);
		driver.findElement(By.xpath(p.getProperty("insurance"))).click();
		driver.findElement(By.id(p.getProperty("terms"))).click();
		Thread.sleep(2000);
	}
		
	public void pay() throws Exception
	{
		driver.findElement(By.xpath(p.getProperty("proceedBooking"))).click();
		Thread.sleep(1000);
    }
	public void pay1() throws Exception 
	{
		driver.findElement(By.id(p.getProperty("makePayment"))).click();
		Thread.sleep(2000);
    }
 
	@Test(enabled=true,priority=1,description="Book Multi-City Flight with Valid Credentials")
	  public void tc_36() throws Exception 
	  {
		  multicity(ex.getData("Sheet5",1,0), ex.getData("Sheet5",1,1), ex.getData("Sheet5",1,2), ex.getData("Sheet5",1,3), ex.getData("Sheet5",1,4));
		  booking();
		  details(ex.getData("Sheet5",1,5),ex.getData("Sheet5",1,6),ex.getData("Sheet5",1,7),ex.getData("Sheet5",1,8),ex.getData("Sheet5",1,9),ex.getData("Sheet5",1,10),ex.getData("Sheet5",1,11),ex.getData("Sheet5",1,12));
		  pay();
		  pay1();
		  boolean data=driver.findElement(By.id("ccNum-allcardsuihandler")).isDisplayed();
		  Assert.assertTrue(data);
		  System.out.println("Landed on payment page");
		  
		  ExtentTest tc=ex1.createTest("MultiCityFlights_1");
		  tc.info("Booking with valid credentials");
		  tc.pass("test pass");	
	  }
	
	@Test(enabled=true,priority=2,description="Book Round way Flight with InValid Credentials")
	  public void tc_38() throws Exception 
	  {
		  multicity(ex.getData("Sheet5",2,0), ex.getData("Sheet5",2,1), ex.getData("Sheet5",2,2), ex.getData("Sheet5",2,3), ex.getData("Sheet5",2,4));
		  Thread.sleep(1000);
		  boolean data=driver.findElement(By.xpath("//*[text()='Select Departing Airport']")).isDisplayed();
		  Assert.assertTrue(data);
		  Assert.assertTrue(data);
		  System.out.println(driver.findElement(By.xpath("//*[text()='Select Departing Airport']")));
		  
		  ExtentTest tc=ex1.createTest("MultiCityFlights_2");
		  tc.info("Booking with Invalid credentials");
		  tc.pass("test pass");
	  }
	
	@Test(enabled=true,priority=3,description="Book Round way Flight with InValid Credentials")
	  public void tc_39() throws Exception 
	  {
		  multicity(ex.getData("Sheet5",3,0), ex.getData("Sheet5",3,1), ex.getData("Sheet5",3,2), ex.getData("Sheet5",3,3), ex.getData("Sheet5",3,4));
		  Thread.sleep(1000);
		  boolean data=driver.findElement(By.xpath("//*[text()='Select Arriving Airport']")).isDisplayed();
		  Assert.assertTrue(data);
		  System.out.println(driver.findElement(By.xpath("//*[text()='Select Arriving Airport']")));
		  
		  ExtentTest tc=ex1.createTest("MultiCityFlights_3");
		  tc.info("Booking with Invalid credentials");
		  tc.pass("test pass");
	  }
	
	@Test(enabled=true,priority=4,description="Book Round way Flight with InValid Credentials")
	  public void tc_40() throws Exception 
	  {
		  multicity(ex.getData("Sheet5",4,0), ex.getData("Sheet5",4,1), ex.getData("Sheet5",4,2), ex.getData("Sheet5",4,3), ex.getData("Sheet5",4,4));
		  Thread.sleep(1000);
		  boolean data=driver.findElement(By.xpath("//*[text()='Select Departing Airport']")).isDisplayed();
		  Assert.assertTrue(data);
		  System.out.println(driver.findElement(By.xpath("//*[text()='Select Departing Airport']")));
		  
		  ExtentTest tc=ex1.createTest("MultiCityFlights_4");
		  tc.info("Booking with Invalid credentials");
		  tc.pass("test pass");
	  }
	
	@Test(enabled=true,priority=5,description="Book Round way Flight with InValid Credentials")
	  public void tc_41() throws Exception 
	  {
		  multicity(ex.getData("Sheet5",5,0), ex.getData("Sheet5",5,1), ex.getData("Sheet5",5,2), ex.getData("Sheet5",5,3), ex.getData("Sheet5",5,4));
		  Thread.sleep(1000);
		  boolean data=driver.findElement(By.xpath("//*[text()='Select Arriving Airport']")).isDisplayed();
		  Assert.assertTrue(data);
		  System.out.println(driver.findElement(By.xpath("//*[text()='Select Arriving Airport']")));
		  
		  ExtentTest tc=ex1.createTest("MultiCityFlights_5");
		  tc.info("Booking with Invalid credentials");
		  tc.pass("test pass");
		  ex1.flush();
	  }
}
