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

public class RoundTripFlightBooking extends Base
{
	Excel_Import ex= new Excel_Import("src/test/resources/data/Data.xlsx");
	Properties p =new Properties();
	ExtentReports ex1= new ExtentReports();
	
	public void roundtrip(String from,String to,String airline) throws Exception 
	{
		  p.load(new FileInputStream("settings.property"));
		  driver.get(p.getProperty("url"));
		  ex1.attachReporter(new ExtentHtmlReporter("RoundTripFlight.html"));                          //url
		  driver.manage().deleteAllCookies(); 
		  driver.findElement(By.xpath(p.getProperty("roundTrip"))).click();							   //roundtrip
		  driver.findElement(By.id(p.getProperty("from"))).clear();									   //from
		  driver.findElement(By.id(p.getProperty("from"))).sendKeys(from);
		  Thread.sleep(1000);
		  driver.findElement(By.id(p.getProperty("from"))).sendKeys(Keys.ARROW_DOWN);
		  Thread.sleep(1000);
		  driver.findElement(By.id(p.getProperty("from"))).sendKeys(Keys.ENTER);
		  Thread.sleep(1000);
		  driver.findElement(By.id(p.getProperty("to"))).clear();									   //to
		  driver.findElement(By.id(p.getProperty("to"))).sendKeys(to);
		  Thread.sleep(1000);
		  driver.findElement(By.id(p.getProperty("to"))).sendKeys(Keys.ARROW_DOWN);
		  Thread.sleep(1000);
		  driver.findElement(By.id(p.getProperty("to"))).sendKeys(Keys.ENTER);
		
		  driver.findElement(By.id("departure")).click();                                              //departure
		  Thread.sleep(1000);
		  driver.findElement(By.xpath(p.getProperty("departure"))).click();
		  Thread.sleep(1000);
		  driver.findElement(By.id("return")).click();												   //return
		  Thread.sleep(1000);
		  driver.findElement(By.xpath(p.getProperty("return"))).click();
		  Thread.sleep(1000);
		  
		  driver.findElement(By.cssSelector(p.getProperty("more"))).click();                           //more options
		  driver.findElement(By.id(p.getProperty("airline"))).clear();                                 //preferred airline
		  driver.findElement(By.id(p.getProperty("airline"))).sendKeys(airline);
		  driver.findElement(By.id(p.getProperty("airline"))).sendKeys(Keys.DOWN);
		  driver.findElement(By.id(p.getProperty("airline"))).sendKeys(Keys.ENTER);
		  driver.findElement(By.id(p.getProperty("class"))).click();                                   //class
		  driver.findElement(By.cssSelector(p.getProperty("economy"))).click();
		  driver.findElement(By.id(p.getProperty("routing"))).click();                                 //routing
		  driver.findElement(By.cssSelector(p.getProperty("direct"))).click();
		  driver.findElement(By.id(p.getProperty("searchFlights"))).click();                           //search flights
		  Thread.sleep(10000);
	}
	
	public void booking() throws Exception 
	{
		 p.load(new FileInputStream("settings.property"));
	     driver.findElement(By.xpath(p.getProperty("filter"))).click();                                //filter
	     Thread.sleep(1000);
	     driver.findElement(By.xpath(p.getProperty("selectAll"))).click();                             //select all
	     Thread.sleep(1000);
	     driver.findElement(By.xpath(p.getProperty("airasia"))).click();                               //airasia india
	     Thread.sleep(1000);	  
		 List<WebElement> ls=driver.findElements(By.cssSelector(p.getProperty("book_rt")));            //book 1st flight
		 ls.get(0).click();
		 driver.findElement(By.xpath(p.getProperty("book_rt1"))).click();                              //book 2nd flight
		 driver.findElement(By.xpath(p.getProperty("bookFlights"))).click();
	     Thread.sleep(3000);
	}
	
	public void details(String title,String fname,String lname,String date,String month,String year,String mobile,String email) throws Exception
	{
		driver.findElement(By.id(p.getProperty("title"))).sendKeys(title);                             //title
		driver.findElement(By.id(p.getProperty("firstName"))).clear();                                 //first name
		driver.findElement(By.id(p.getProperty("firstName"))).sendKeys(fname);                         
		driver.findElement(By.id(p.getProperty("lastName"))).clear();                                  //last name
		driver.findElement(By.id(p.getProperty("lastName"))).sendKeys(lname);
		driver.findElement(By.id(p.getProperty("day"))).sendKeys(date);                                //date
		driver.findElement(By.id(p.getProperty("month"))).sendKeys(month);                             //month
		driver.findElement(By.id(p.getProperty("year"))).sendKeys(year);                               //year
		driver.findElement(By.id(p.getProperty("mobile"))).clear();                                    //mobile
		driver.findElement(By.id(p.getProperty("mobile"))).sendKeys(mobile);   
		driver.findElement(By.id(p.getProperty("email"))).clear();                                     //email
		driver.findElement(By.id(p.getProperty("email"))).sendKeys(email);
		driver.findElement(By.xpath(p.getProperty("insurance"))).click();                              //insurance
		Thread.sleep(1000);
	}
	public void terms() throws Exception
	{
		driver.findElement(By.xpath("//label[@id='msgInfoChkBox_label']")).click();                    //terms and conditions
		Thread.sleep(1000);
	}
		
	public void pay() throws Exception
	{
		driver.findElement(By.xpath(p.getProperty("proceedBooking"))).click();                         //proceed booking
		Thread.sleep(2000);
    }
	public void pay1() throws Exception 
	{
		driver.findElement(By.id(p.getProperty("makePayment"))).click();                               //make payment
		Thread.sleep(3000);
    }
	
	@Test(enabled=true,priority=1,description="Book Round way Flight with Valid Credentials")
	  public void tc_31() throws Exception 
	  {
		  roundtrip(ex.getData("Sheet4",1,0), ex.getData("Sheet4",1,1), ex.getData("Sheet4",1,2));
		  booking();
		  details(ex.getData("Sheet4",1,3),ex.getData("Sheet4",1,4),ex.getData("Sheet4",1,5),ex.getData("Sheet4",1,6),ex.getData("Sheet4",1,7),ex.getData("Sheet4",1,8),ex.getData("Sheet4",1,9),ex.getData("Sheet4",1,10));
		  terms();
		  pay();
		  pay1();
		  boolean data=driver.findElement(By.id("ccNum-allcardsuihandler")).isDisplayed();
		  Assert.assertTrue(data);
		  System.out.println("Landed on payment page");
		  
		  ExtentTest tc=ex1.createTest("RoundTripFlights_1");
		  tc.info("Booking with valid credentials");
		  tc.pass("test pass");
	  }
	
	@Test(enabled=true,priority=2,description="Book Round Trip Flight with InValid Credentials")
	  public void tc_33() throws Exception 
	  {
		 roundtrip(ex.getData("Sheet4",2,0), ex.getData("Sheet4",2,1), ex.getData("Sheet4",2,2));
		 boolean data=driver.findElement(By.xpath("//*[text()='Select Departing Airport']")).isDisplayed();
		 Assert.assertTrue(data);
		 System.out.println(driver.findElement(By.xpath("//*[text()='Select Departing Airport']")).getText());
		  
		  ExtentTest tc=ex1.createTest("RoundTripFlights_2");
		  tc.info("Booking with Invalid Departing Airport");
		  tc.pass("test pass");
	  }
	
	 @Test(enabled=true,priority=3,description="Book Round Trip Flight with InValid Credentials")
	  public void tc_34() throws Exception 
	  {
		  roundtrip(ex.getData("Sheet4",3,0), ex.getData("Sheet4",3,1), ex.getData("Sheet4",3,2));
		  boolean data=driver.findElement(By.xpath("//*[text()='Select Arriving Airport']")).isDisplayed();
		  Assert.assertTrue(data);
		  System.out.println(driver.findElement(By.xpath("//*[text()='Select Arriving Airport']")).getText());
		  
		  ExtentTest tc=ex1.createTest("RoundTripFlights_3");
		  tc.info("Booking with Invalid Arriving Airport");
		  tc.pass("test pass");
	  }
	 
	 @Test(enabled=true,priority=4,description="Book Round Trip Flight with InValid Credentials")
	  public void tc_35() throws Exception 
	  {
		  roundtrip(ex.getData("Sheet4",4,0), ex.getData("Sheet4",4,1), ex.getData("Sheet4",4,2));
		  boolean data=driver.findElement(By.xpath("//*[text()='Select Arriving Airport']")).isDisplayed();
		  Assert.assertTrue(data);
		  System.out.println(driver.findElement(By.xpath("//*[text()='Select Arriving Airport']")).getText());
		  
		  ExtentTest tc=ex1.createTest("RoundTripFlights_4");
		  tc.info("Booking with Invalid Arriving Airport");
		  tc.pass("test pass");
		  ex1.flush();
	  }
	  
}
