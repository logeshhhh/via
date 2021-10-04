package project;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class MultiCity extends Base
{
	Excel_Import ex= new Excel_Import("D:\\LTI\\TRAINING\\MANUAL TESTING\\Data.xlsx");
	Properties p =new Properties();
	ExtentReports ex1= new ExtentReports();
	
	public void multicity(String from1,String to1,String from2,String to2,String airline,String pre) throws Exception 
	{  p.load(new FileInputStream("settings.property"));
		driver.manage().deleteAllCookies();
		 ex1.attachReporter(new ExtentHtmlReporter("MultiCityFlight.html"));
		 driver.get("https://in.via.com/");
		driver.findElement(By.xpath("//label[normalize-space()='Multi-city']")).click();
		  
		  driver.findElement(By.id("source-0")).clear();
		  driver.findElement(By.id("source-0")).sendKeys(from1);
		  Thread.sleep(1000);
		  driver.findElement(By.id("source-0")).sendKeys(Keys.ARROW_DOWN);
		  Thread.sleep(1000);
		  driver.findElement(By.id("source-0")).sendKeys(Keys.ENTER);
		  driver.findElement(By.name("destination_0")).clear();
		  driver.findElement(By.name("destination_0")).sendKeys(to1);
		  Thread.sleep(1000);
		  driver.findElement(By.id("destination-0")).sendKeys(Keys.ARROW_DOWN);
		  Thread.sleep(1000);
		  driver.findElement(By.id("destination-0")).sendKeys(Keys.ENTER);
		  driver.manage().deleteAllCookies();
		  driver.findElement(By.xpath(p.getProperty("calendar1"))).click();
		  driver.findElement(By.xpath(p.getProperty("departure1"))).click();
		  Thread.sleep(1000);
		  driver.findElement(By.id(p.getProperty("flight2"))).click();
		  driver.findElement(By.id("source-1")).clear();
		  driver.findElement(By.id("source-1")).sendKeys(from2);
		  Thread.sleep(1000);
		  driver.findElement(By.id("source-1")).sendKeys(Keys.ARROW_DOWN);
		  Thread.sleep(1000);
		  driver.findElement(By.id("source-1")).sendKeys(Keys.ENTER);
		  Thread.sleep(1000);
		  driver.findElement(By.name("destination_1")).clear();
		  driver.findElement(By.name("destination_1")).sendKeys(to2);
		  Thread.sleep(1000);
		  driver.findElement(By.name("destination_1")).sendKeys(Keys.ARROW_DOWN);
		  Thread.sleep(1000);
		  driver.findElement(By.name("destination_1")).sendKeys(Keys.ENTER);
		  Thread.sleep(1000);
		  driver.manage().deleteAllCookies();
		  Thread.sleep(1000);
		  driver.manage().deleteAllCookies();
		  driver.findElement(By.xpath(p.getProperty("calendar2"))).click();
		  driver.findElement(By.xpath(p.getProperty("departure2"))).click();
		  driver.findElement(By.id("search-flight-btn")).click();
		  Thread.sleep(4000);
		  
		 
	
	}
	public void booking() throws Exception 
	{	p.load(new FileInputStream("settings.property"));
	 List<WebElement> ls=driver.findElements(By.cssSelector(p.getProperty("book_rt")));
	 ls.get(0).click();
	 driver.findElement(By.xpath(p.getProperty("book_rt1"))).click();
	 driver.findElement(By.xpath(p.getProperty("bookFlights"))).click();
	}
	
	public void details(String title,String fname,String lname,String date,String month,String year,String mobile,String email) throws Exception
	{
		 Select s3=new Select(driver.findElement(By.id("adult1Title")));
		 s3.selectByIndex(2);
		 driver.findElement(By.id("adult1FirstName")).clear();
		 driver.findElement(By.id("adult1FirstName")).sendKeys(fname);
		 List<WebElement> l2= driver.findElements(By.cssSelector("span[class='searchName']"));
		 l2.get(0).click();
		 driver.findElement(By.id("adult1Surname")).clear();
		 driver.findElement(By.id("adult1Surname")).sendKeys(lname);
		
		 
		 driver.findElement(By.id("contactMobile")).sendKeys(mobile);
		 driver.findElement(By.id("contactEmail")).clear();
		 driver.findElement(By.id("contactEmail")).sendKeys(email);
		 Thread.sleep(12000);
		 driver.findElement(By.id("msgInfoChkBox_label")).click();
		 Thread.sleep(8000);
		 driver.findElement(By.id("makePayCTA")).click();
		 Thread.sleep(2000);
	}
		
	@Test(enabled=true,priority=1,description="Book Multi-City Flight with Valid Credentials")
	  public void tc_36() throws Exception 
	  {
		  multicity(ex.getData("Sheet5",1,0), ex.getData("Sheet5",1,1), ex.getData("Sheet5",1,2), ex.getData("Sheet5",1,3), ex.getData("Sheet5",1,4),"all");
		  booking();
		  details(ex.getData("Sheet5",1,5),ex.getData("Sheet5",1,6),ex.getData("Sheet5",1,7),ex.getData("Sheet5",1,8),ex.getData("Sheet5",1,9),ex.getData("Sheet5",1,10),ex.getData("Sheet5",1,11),ex.getData("Sheet5",1,12));
		/*  pay();
		  pay1();*/
		  
		  boolean data=driver.findElement(By.xpath("//button[@id='confirmProceedPayBtn']")).isDisplayed();
		  Assert.assertTrue(data);
		  System.out.println("Landed on payment page");
		  
		  ExtentTest tc=ex1.createTest("MultiCityFlights_1");
		  tc.info("Booking with valid credentials");
		  tc.pass("test pass");	
	  }
	
	@Test(enabled=true,priority=2,description="Book Round way Flight with InValid Credentials")
	  public void tc_38() throws Exception 
	  {
		  multicity(ex.getData("Sheet5",2,0), ex.getData("Sheet5",2,1), ex.getData("Sheet5",2,2), ex.getData("Sheet5",2,3), ex.getData("Sheet5",2,4),"all");
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
		  multicity(ex.getData("Sheet5",3,0), ex.getData("Sheet5",3,1), ex.getData("Sheet5",3,2), ex.getData("Sheet5",3,3), ex.getData("Sheet5",3,4),"all");
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
		  multicity(ex.getData("Sheet5",4,0), ex.getData("Sheet5",4,1), ex.getData("Sheet5",4,2), ex.getData("Sheet5",4,3), ex.getData("Sheet5",4,4),"all");
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
		  multicity(ex.getData("Sheet5",5,0), ex.getData("Sheet5",5,1), ex.getData("Sheet5",5,2), ex.getData("Sheet5",5,3), ex.getData("Sheet5",5,4),"all");
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
