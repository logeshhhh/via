package project;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TravellerDetails extends Base
{
	
	Excel_Import ex= new Excel_Import("src/test/resources/data/Data.xlsx");                                     //importing data from Excel
	Properties p =new Properties();
	ExtentReports ex1= new ExtentReports();
	
	
	public void flight(String from,String to,String airline) throws Exception 
	{  
		  p.load(new FileInputStream("settings.property"));
		  driver.get(p.getProperty("url")); 																	//url
		  ex1.attachReporter(new ExtentHtmlReporter("TravellerDetails.html"));		
		  driver.manage().deleteAllCookies();	
		  driver.findElement(By.id(p.getProperty("from"))).clear();											    //from
		  driver.findElement(By.id(p.getProperty("from"))).sendKeys(from);
		  List<WebElement> l1= driver.findElements(By.cssSelector(p.getProperty("fromdrop")));
		  l1.get(0).click(); 
		  driver.findElement(By.id(p.getProperty("to"))).clear();                                               //to
		  driver.findElement(By.id(p.getProperty("to"))).sendKeys(to);
		  
		  driver.findElement(By.xpath(p.getProperty("todrop"))).click();
		  Thread.sleep(1000);
		  
		  driver.findElement(By.xpath(p.getProperty("departure"))).click();          							//depature
		  driver.findElement(By.cssSelector(p.getProperty("more"))).click();									//more options
		  driver.findElement(By.id(p.getProperty("airline"))).clear();                                          //preferred airline
		  driver.findElement(By.id(p.getProperty("airline"))).sendKeys(airline);
		  driver.findElement(By.xpath(p.getProperty("airlineselect"))).click();
		  driver.findElement(By.id(p.getProperty("class"))).click();                                            //class
		  driver.findElement(By.cssSelector(p.getProperty("economy"))).click();
		  driver.findElement(By.id(p.getProperty("routing"))).click();                                          //routing
		  driver.findElement(By.cssSelector(p.getProperty("direct"))).click(); 
		  driver.findElement(By.id(p.getProperty("searchFlights"))).click();                                    //search flights
		  Thread.sleep(5000);
		  
		  List<WebElement>ls= driver.findElements(By.xpath(p.getProperty("book")));                             //book
		  ls.get(0).click();
		  Thread.sleep(5000);
		
	}
	
	public void details(String title,String fname,String lname,String date,String month,String year,String mobile,String email) throws Exception
	{
		
		p.load(new FileInputStream("settings.property"));
		driver.findElement(By.id(p.getProperty("title"))).sendKeys(title);										//title
		driver.findElement(By.id(p.getProperty("firstName"))).clear();                                          //first name
		driver.findElement(By.id(p.getProperty("firstName"))).sendKeys(fname);
		driver.findElement(By.id(p.getProperty("lastName"))).clear();                                           //last name
		driver.findElement(By.id(p.getProperty("lastName"))).sendKeys(lname);
		driver.findElement(By.id(p.getProperty("day"))).sendKeys(date);                                         //date
		driver.findElement(By.id(p.getProperty("month"))).sendKeys(month);                                      //month
		driver.findElement(By.id(p.getProperty("year"))).sendKeys(year);                                        //year
		driver.findElement(By.id(p.getProperty("mobile"))).clear();                                             //mobile
		Thread.sleep(1000);
		driver.findElement(By.id(p.getProperty("mobile"))).sendKeys(mobile);               
		Thread.sleep(1000);
		driver.findElement(By.id(p.getProperty("email"))).clear();                                              //email
		Thread.sleep(1000);
		driver.findElement(By.id(p.getProperty("email"))).sendKeys(email);
		Thread.sleep(1000);
	}
	public void insurance() throws Exception
	{
		driver.findElement(By.xpath(p.getProperty("insurance"))).click();                                       //insurance
		Thread.sleep(1000);
	}
	public void msginfo() throws Exception
	{
		driver.findElement(By.xpath(p.getProperty("terms"))).click();                                           //terms
		Thread.sleep(1000);
	}	
	public void pay() throws Exception
	{
		driver.findElement(By.xpath(p.getProperty("proceedBooking"))).click();                                  //proceed booking
		Thread.sleep(2000);
	}
		public void pay1() throws Exception 
		{
			driver.findElement(By.id(p.getProperty("makePayment"))).click();                                    //make payment
			Thread.sleep(2000);
	}
	
  @Test(enabled=false,priority=1,description="Booking with Valid Credentials")
  public void tc_44() throws Exception 
  {
	  flight(ex.getData("Sheet3",1,0), ex.getData("Sheet3",1,1), ex.getData("Sheet3",1,2));
	  Thread.sleep(1000);
	  details(ex.getData("Sheet3",1,3),ex.getData("Sheet3",1,4),ex.getData("Sheet3",1,5),ex.getData("Sheet3",1,6),ex.getData("Sheet3",1,7),ex.getData("Sheet3",1,8),ex.getData("Sheet3",1,9),ex.getData("Sheet3",1,10));
	  insurance();
	  msginfo();
	  pay();
	  pay1();
	  boolean data=driver.findElement(By.id("ccNum-allcardsuihandler")).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println("Landed on payment page");
	  
	  ExtentTest tc=ex1.createTest("TravellerDetailsTest1");
	  tc.info("Booking with valid credentials");
	  tc.pass("test pass");	
  }
  
  @Test(enabled=true,priority=2,description="Booking with Invalid Credentials")
  public void tc_45() throws Exception 
  {
	  flight(ex.getData("Sheet3",2,0), ex.getData("Sheet3",2,1), ex.getData("Sheet3",2,2));
	  Thread.sleep(1000);
	  details(ex.getData("Sheet3",2,3),ex.getData("Sheet3",2,4),ex.getData("Sheet3",2,5),ex.getData("Sheet3",2,6),ex.getData("Sheet3",2,7),ex.getData("Sheet3",2,8),ex.getData("Sheet3",2,9),ex.getData("Sheet3",2,10));
	  Thread.sleep(1000);
	  insurance();
	  msginfo();
	  pay();
	  boolean data=driver.findElement(By.xpath("//*[text()='Required']")).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println(driver.findElement(By.xpath("//*[text()='Required']")).getText());
	 
	  ExtentTest tc=ex1.createTest("TravellerDetailsTest2");
	  tc.info("Booking with Invalid Title");
	  tc.pass("test pass");	 
  }
  
  @Test(enabled=false,priority=3,description="Booking with Invalid Credentials")
  public void tc_46() throws Exception 
  {
	
	  flight(ex.getData("Sheet3",3,0), ex.getData("Sheet3",3,1), ex.getData("Sheet3",3,2));
	  Thread.sleep(1000);
	  details(ex.getData("Sheet3",3,3),ex.getData("Sheet3",3,4),ex.getData("Sheet3",3,5),ex.getData("Sheet3",3,6),ex.getData("Sheet3",3,7),ex.getData("Sheet3",3,8),ex.getData("Sheet3",3,9),ex.getData("Sheet3",3,10));
	  Thread.sleep(1000);
	  insurance();
	  msginfo();
	  pay();
	  boolean data=driver.findElement(By.xpath("//*[text()='Alphabets & Spaces only']")).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println(driver.findElement(By.xpath("//*[text()='Alphabets & Spaces only']")).getText());
		 
	  ExtentTest tc=ex1.createTest("TravellerDetailsTest3");
	  tc.info("Booking with Invalid First Name");
	  tc.pass("test pass");	 
  }
  
  @Test(enabled=false,priority=4,description="Booking with Invalid Credentials")
  public void tc_47() throws Exception 
  {
	  flight(ex.getData("Sheet3",4,0), ex.getData("Sheet3",4,1), ex.getData("Sheet3",4,2));
	  Thread.sleep(1000);
	  details(ex.getData("Sheet3",4,3),ex.getData("Sheet3",4,4),ex.getData("Sheet3",4,5),ex.getData("Sheet3",4,6),ex.getData("Sheet3",4,7),ex.getData("Sheet3",4,8),ex.getData("Sheet3",4,9),ex.getData("Sheet3",4,10));
	  insurance();
	  Thread.sleep(1000);
	  msginfo();
	  Thread.sleep(1000);
	  pay();
	  boolean data=driver.findElement(By.xpath("//*[text()='Alphabets & Spaces only']")).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println(driver.findElement(By.xpath("//*[text()='Alphabets & Spaces only']")).getText());
		 
	  ExtentTest tc=ex1.createTest("TravellerDetailsTest4");
	  tc.info("Booking with Invalid Last Name");
	  tc.pass("test pass");	
	  
  }
  
  @Test(enabled=false,priority=5,description="Booking with Invalid Credentials")
  public void tc_48() throws Exception 
  {
	  flight(ex.getData("Sheet3",5,0), ex.getData("Sheet3",5,1), ex.getData("Sheet3",5,2));
	  Thread.sleep(1000);
	  details(ex.getData("Sheet3",5,3),ex.getData("Sheet3",5,4),ex.getData("Sheet3",5,5),ex.getData("Sheet3",5,6),ex.getData("Sheet3",5,7),ex.getData("Sheet3",5,8),ex.getData("Sheet3",5,9),ex.getData("Sheet3",5,10));
	  insurance();
	  msginfo();
	  pay();
	  boolean data=driver.findElement(By.xpath("//*[text()='Required']")).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println(driver.findElement(By.xpath("//*[text()='Required']")).getText());
		 
	  ExtentTest tc=ex1.createTest("TravellerDetailsTest5");
	  tc.info("Booking with Invalid Date");
	  tc.pass("test pass");	
	  
  }
  
  @Test(enabled=false,priority=6,description="Booking with Invalid Credentials")
  public void tc_49() throws Exception 
  {
	  flight(ex.getData("Sheet3",6,0), ex.getData("Sheet3",6,1), ex.getData("Sheet3",6,2));
	  Thread.sleep(1000);
	  details(ex.getData("Sheet3",6,3),ex.getData("Sheet3",6,4),ex.getData("Sheet3",6,5),ex.getData("Sheet3",6,6),ex.getData("Sheet3",6,7),ex.getData("Sheet3",6,8),ex.getData("Sheet3",6,9),ex.getData("Sheet3",6,10));
	  insurance();
	  msginfo();
	  pay();
	  boolean data=driver.findElement(By.xpath("//*[text()='Required']")).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println(driver.findElement(By.xpath("//*[text()='Required']")).getText());
		 
	  ExtentTest tc=ex1.createTest("TravellerDetailsTest6");
	  tc.info("Booking with Invalid Month");
	  tc.pass("test pass");	
	  
  }
  
  @Test(enabled=false,priority=7,description="Booking with Invalid Credentials")
  public void tc_50() throws Exception 
  {
	  flight(ex.getData("Sheet3",7,0), ex.getData("Sheet3",7,1), ex.getData("Sheet3",7,2));
	  Thread.sleep(1000);
	  details(ex.getData("Sheet3",7,3),ex.getData("Sheet3",7,4),ex.getData("Sheet3",7,5),ex.getData("Sheet3",7,6),ex.getData("Sheet3",7,7),ex.getData("Sheet3",7,8),ex.getData("Sheet3",7,9),ex.getData("Sheet3",7,10));
	  insurance();
	  msginfo();
	  pay();
	  boolean data=driver.findElement(By.xpath("//*[text()='Required']")).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println(driver.findElement(By.xpath("//*[text()='Required']")).getText());
		 
	  ExtentTest tc=ex1.createTest("TravellerDetailsTest7");
	  tc.info("Booking with Invalid Year");
	  tc.pass("test pass");	
	  
  }
  
  @Test(enabled=false,priority=8,description="Booking with Invalid Credentials")
  public void tc_51() throws Exception 
  {
	  flight(ex.getData("Sheet3",8,0), ex.getData("Sheet3",8,1), ex.getData("Sheet3",8,2));
	  Thread.sleep(1000);
	  details(ex.getData("Sheet3",8,3),ex.getData("Sheet3",8,4),ex.getData("Sheet3",8,5),ex.getData("Sheet3",8,6),ex.getData("Sheet3",8,7),ex.getData("Sheet3",8,8),ex.getData("Sheet3",8,9),ex.getData("Sheet3",8,10));
	  insurance();
	  msginfo();
	  pay();
	  boolean data=driver.findElement(By.xpath("//*[text()='Enter Valid Mobile & country code ( Required )']")).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println(driver.findElement(By.xpath("//*[text()='Enter Valid Mobile & country code ( Required )']")).getText());
		 
	  ExtentTest tc=ex1.createTest("TravellerDetailsTest8");
	  tc.info("Booking with Invalid Mobile Number");
	  tc.pass("test pass");	
	  
  }
  
  @Test(enabled=false,priority=9,description="Booking with Missing Credentials")
  public void tc_52() throws Exception 
  {
	  flight(ex.getData("Sheet3",9,0), ex.getData("Sheet3",9,1), ex.getData("Sheet3",9,2));
	  Thread.sleep(1000);
	  details(ex.getData("Sheet3",9,3),ex.getData("Sheet3",9,4),ex.getData("Sheet3",9,5),ex.getData("Sheet3",9,6),ex.getData("Sheet3",9,7),ex.getData("Sheet3",9,8),ex.getData("Sheet3",9,9),ex.getData("Sheet3",9,10));
	  insurance();
	  msginfo();
	  pay();
	  boolean data=driver.findElement(By.xpath("//*[text()='Enter Valid Mobile & country code ( Required )']")).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println(driver.findElement(By.xpath("//*[text()='Enter Valid Mobile & country code ( Required )']")).getText());
		 
	  ExtentTest tc=ex1.createTest("TravellerDetailsTest9");
	  tc.info("Booking with Missing Mobile Number");
	  tc.pass("test pass");
	  
  }
  
  @Test(enabled=false,priority=10,description="Booking with Invalid Credentials")
  public void tc_53() throws Exception 
  {
	  flight(ex.getData("Sheet3",10,0), ex.getData("Sheet3",10,1), ex.getData("Sheet3",10,2));
	  Thread.sleep(1000);
	  details(ex.getData("Sheet3",10,3),ex.getData("Sheet3",10,4),ex.getData("Sheet3",10,5),ex.getData("Sheet3",10,6),ex.getData("Sheet3",10,7),ex.getData("Sheet3",10,8),ex.getData("Sheet3",10,9),ex.getData("Sheet3",10,10));
	  insurance();
	  msginfo();
	  pay();
	  Thread.sleep(1000);
	  boolean data=driver.findElement(By.xpath("//*[text()='Enter Valid Email ( Required )']")).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println(driver.findElement(By.xpath("//*[text()='Enter Valid Email ( Required )']")).getText());
		 
	  ExtentTest tc=ex1.createTest("TravellerDetailsTest10");
	  tc.info("Booking with Invalid Email");
	  tc.pass("test pass");
	  
  }
  
  @Test(enabled=false,priority=11,description="Booking with Missing Credentials")
  public void tc_54() throws Exception 
  {
	  flight(ex.getData("Sheet3",11,0), ex.getData("Sheet3",11,1), ex.getData("Sheet3",11,2));
	  Thread.sleep(1000);
	  details(ex.getData("Sheet3",11,3),ex.getData("Sheet3",11,4),ex.getData("Sheet3",11,5),ex.getData("Sheet3",11,6),ex.getData("Sheet3",11,7),ex.getData("Sheet3",11,8),ex.getData("Sheet3",11,9),ex.getData("Sheet3",11,10));
	  insurance();
	  msginfo();
	  pay();
	  boolean data=driver.findElement(By.xpath("//*[text()='Enter Valid Email ( Required )']")).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println(driver.findElement(By.xpath("//*[text()='Enter Valid Email ( Required )']")).getText());
		 
	  ExtentTest tc=ex1.createTest("TravellerDetailsTest11");
	  tc.info("Booking with Missing Email");
	  tc.pass("test pass");
	  
	  
  }
  
  @Test(enabled=false,priority=12,description="Booking with Missing Credentials")
  public void tc_55() throws Exception 
  {
	  
	 
	  flight(ex.getData("Sheet3",12,0), ex.getData("Sheet3",12,1), ex.getData("Sheet3",12,2));
	  Thread.sleep(1000);
	  details(ex.getData("Sheet3",12,3),ex.getData("Sheet3",12,4),ex.getData("Sheet3",12,5),ex.getData("Sheet3",12,6),ex.getData("Sheet3",12,7),ex.getData("Sheet3",12,8),ex.getData("Sheet3",12,9),ex.getData("Sheet3",12,10));
	  msginfo();
	  pay();
	  pay1();
	  boolean data=driver.findElement(By.id("ccNum-allcardsuihandler")).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println(driver.findElement(By.id("ccNum-allcardsuihandler")).getText());
		 
	  ExtentTest tc=ex1.createTest("TravellerDetailsTest12");
	  tc.info("Booking without Insurace");
	  tc.pass("test pass");
	  
	  
  }
  @Test(enabled=false,priority=13,description="Booking with Missing Credentials")
  public void tc_56() throws Exception 
  {
	  
	 
	  flight(ex.getData("Sheet3",13,0), ex.getData("Sheet3",13,1), ex.getData("Sheet3",13,2));
	  Thread.sleep(1000);
	  details(ex.getData("Sheet3",13,3),ex.getData("Sheet3",13,4),ex.getData("Sheet3",13,5),ex.getData("Sheet3",13,6),ex.getData("Sheet3",13,7),ex.getData("Sheet3",13,8),ex.getData("Sheet3",13,9),ex.getData("Sheet3",13,10));
	  insurance();
	  pay();
	  boolean data=driver.findElement(By.xpath("//*[text()='Please accept booking terms']")).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println(driver.findElement(By.xpath("//*[text()='Please accept booking terms']")).getText());
		 
	  ExtentTest tc=ex1.createTest("TravellerDetailsTest13");
	  tc.info("Booking with missing Terms and Conditions");
	  tc.pass("test pass");
	  ex1.flush();
	  
  }
  
 
}
