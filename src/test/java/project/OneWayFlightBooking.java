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

public class OneWayFlightBooking extends Base
{

	Excel_Import ex= new Excel_Import("src/test/resources/data/Data.xlsx");
	Properties p =new Properties();
	ExtentReports ex1= new ExtentReports();
	
	public void oneway(String from,String to,String airline) throws Exception 
	{ 
		  p.load(new FileInputStream("settings.property"));
		  driver.get(p.getProperty("url"));                                                             //url
		  ex1.attachReporter(new ExtentHtmlReporter("OneWayFlight.html")); 							    //from
		  driver.manage().deleteAllCookies();
		  driver.findElement(By.id(p.getProperty("from"))).clear();
		  driver.findElement(By.id(p.getProperty("from"))).sendKeys(from);
		  Thread.sleep(1000);
		  driver.findElement(By.id(p.getProperty("from"))).sendKeys(Keys.ARROW_DOWN);
		  Thread.sleep(1000);
		  driver.findElement(By.id(p.getProperty("from"))).sendKeys(Keys.ENTER);
		  Thread.sleep(1000);
		  driver.findElement(By.id(p.getProperty("to"))).clear();                                       //to
		  driver.findElement(By.id(p.getProperty("to"))).sendKeys(to);
		  Thread.sleep(1000);
		  driver.findElement(By.id(p.getProperty("to"))).sendKeys(Keys.ARROW_DOWN);
		  Thread.sleep(1000);
		  driver.findElement(By.id(p.getProperty("to"))).sendKeys(Keys.ENTER);
		  
		  driver.findElement(By.id("departure")).click();                                               //depature
		  
		  driver.findElement(By.xpath(p.getProperty("departure"))).click();
		  driver.findElement(By.cssSelector(p.getProperty("more"))).click();                            //more options
		  driver.findElement(By.id(p.getProperty("airline"))).clear();                                  //airline
		  driver.findElement(By.id(p.getProperty("airline"))).sendKeys(airline);
		  driver.findElement(By.id(p.getProperty("airline"))).sendKeys(Keys.DOWN);
		  driver.findElement(By.id(p.getProperty("airline"))).sendKeys(Keys.ENTER);
		  driver.findElement(By.id(p.getProperty("class"))).click();                                    //class
		  driver.findElement(By.cssSelector(p.getProperty("economy"))).click();
		  driver.findElement(By.id(p.getProperty("routing"))).click();                                  //routing
		  driver.findElement(By.cssSelector(p.getProperty("direct"))).click();
		  driver.findElement(By.id(p.getProperty("searchFlights"))).click();                            //search flights
		  Thread.sleep(5000);
	}
	
	public void details(String title,String fname,String lname,String date,String month,String year,String mobile,String email) throws Exception
	{
		p.load(new FileInputStream("settings.property"));
		
		   driver.findElement(By.xpath(p.getProperty("filter"))).click();                               //fliter
		    Thread.sleep(1000);
		    driver.findElement(By.xpath(p.getProperty("selectAll"))).click();                           //select all
		    Thread.sleep(1000);
		   driver.findElement(By.xpath(p.getProperty("airasia"))).click();                              //airasia india
		   Thread.sleep(1000);	
		List<WebElement>ls= driver.findElements(By.xpath(p.getProperty("book")));                       //book
	    ls.get(0).click();
	    Thread.sleep(3000);
		driver.findElement(By.id(p.getProperty("title"))).sendKeys(title);                              //title
		driver.findElement(By.id(p.getProperty("firstName"))).clear();
		driver.findElement(By.id(p.getProperty("firstName"))).sendKeys(fname);                          //first name
		driver.findElement(By.id(p.getProperty("lastName"))).clear();                                   
		driver.findElement(By.id(p.getProperty("lastName"))).sendKeys(lname);                           //last name
		driver.findElement(By.id(p.getProperty("day"))).sendKeys(date);                                 //date
		driver.findElement(By.id(p.getProperty("month"))).sendKeys(month);                              //month
		driver.findElement(By.id(p.getProperty("year"))).sendKeys(year);                                //year
		driver.findElement(By.id(p.getProperty("mobile"))).clear();                                     //mobile
		driver.findElement(By.id(p.getProperty("mobile"))).sendKeys(mobile);
		driver.findElement(By.id(p.getProperty("email"))).clear();                                      //email
		driver.findElement(By.id(p.getProperty("email"))).sendKeys(email);

		driver.findElement(By.xpath(p.getProperty("insurance"))).click();                               //insurance
		Thread.sleep(1000);
		driver.findElement(By.xpath(p.getProperty("terms"))).click();                                   //terms and conditions
		Thread.sleep(1000);
	}
		
	public void pay() throws Exception
	{
		driver.findElement(By.xpath(p.getProperty("proceedBooking"))).click();                          //proceed booking
		Thread.sleep(1000);
    }
	public void pay1() throws Exception 
	{
		driver.findElement(By.id(p.getProperty("makePayment"))).click();                                //make payment
		Thread.sleep(3000);
    }
	
	
	

  @Test(enabled=false,priority=1,description="Book 1-way Flight with Valid Credentials")
  public void tc_26() throws Exception 
  {
	  oneway(ex.getData("Sheet4",1,0), ex.getData("Sheet4",1,1), ex.getData("Sheet4",1,2));
	  Thread.sleep(1000);
	  details(ex.getData("Sheet4",1,3),ex.getData("Sheet4",1,4),ex.getData("Sheet4",1,5),ex.getData("Sheet4",1,6),ex.getData("Sheet4",1,7),ex.getData("Sheet4",1,8),ex.getData("Sheet4",1,9),ex.getData("Sheet4",1,10));
	  pay();
	  pay1();
	  boolean data=driver.findElement(By.id("ccNum-allcardsuihandler")).isDisplayed();                   //checking for credit card detail in payment page
	  Assert.assertTrue(data);
	  System.out.println("Landed on payment page");
	  
	  ExtentTest tc=ex1.createTest("OneWayFlights_1");
	  tc.info("Booking with valid credentials");
	  tc.pass("test pass");	
  }
  
  @Test(enabled=true,priority=2,description="Book 1-way Flight with InValid Credentials")
  public void tc_28() throws Exception 
  {
	  oneway(ex.getData("Sheet4",2,0), ex.getData("Sheet4",2,1), ex.getData("Sheet4",2,2));
	  boolean data=driver.findElement(By.xpath("//*[text()='Select Departing Airport']")).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println(driver.findElement(By.xpath("//*[text()='Select Departing Airport']")));       //Checking for Select Departing Airport message
	  
	  ExtentTest tc=ex1.createTest("OneWayFlights_2");
	  tc.info("Booking with Invalid Departing Airport");
	  tc.pass("test pass");	
  }
  
  @Test(enabled=false,priority=3,description="Book 1-way Flight with InValid Credentials")
  public void tc_29() throws Exception 
  {
	  oneway(ex.getData("Sheet4",3,0), ex.getData("Sheet4",3,1), ex.getData("Sheet4",3,2));
	  boolean data=driver.findElement(By.xpath("//*[text()='Select Arriving Airport']")).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println(driver.findElement(By.xpath("//*[text()='Select Arriving Airport']")));		//Checking for Select Arriving Airport message
	  
	  ExtentTest tc=ex1.createTest("OneWayFlights_3");
	  tc.info("Booking with Invalid Arriving Airport");
	  tc.pass("test pass");
  }
  
  @Test(enabled=false,priority=4,description="Book 1-way Flight with InValid Credentials")
  public void tc_30() throws Exception 
  {
	  oneway(ex.getData("Sheet4",4,0), ex.getData("Sheet4",4,1), ex.getData("Sheet4",4,2));
	  boolean data=driver.findElement(By.xpath("//*[text()='Select Arriving Airport']")).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println(driver.findElement(By.xpath("//*[text()='Select Arriving Airport']")));		//Checking for Select Arriving Airport message
	  
	  ExtentTest tc=ex1.createTest("OneWayFlights_4");
	  tc.info("Booking with Invalid Arriving Airport");
	  tc.pass("test pass");
	  ex1.flush();
  }
}
