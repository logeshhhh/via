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

public class HotelBooking extends Base
{
	Excel_Import ex= new Excel_Import("D:\\LTI\\TRAINING\\MANUAL TESTING\\HotelData.xlsx");
	Properties p =new Properties();
	ExtentReports ex1= new ExtentReports();
	
	public void search(String destination) throws Exception
	{
		p.load(new FileInputStream("settings.property"));
		driver.get(p.getProperty("url"));
		ex1.attachReporter(new ExtentHtmlReporter("HotelBookingReport1.html"));
	
		driver.manage().deleteAllCookies();
		driver.findElement(By.xpath("//div[@id='Hotels']/a/span")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath(p.getProperty("destin"))).sendKeys(destination);
		Thread.sleep(2000);
		driver.findElement(By.xpath(p.getProperty("destin"))).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.xpath(p.getProperty("destin"))).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='checkIn']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(p.getProperty("checkin"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='checkOut']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(p.getProperty("checkout"))).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@class='element-room']/div/span")).click();
		driver.findElement(By.xpath("//div[@class='counter-element adult js-count via-processed']/div/div[1]")).click();
		driver.findElement(By.xpath("//div[@class='done']")).click();
		
		Select s1=new Select(driver.findElement(By.id("nationalityCountry")));
		s1.selectByIndex(0);
		Select s2=new Select(driver.findElement(By.id("residenceCountry")));
		s2.selectByIndex(0);
		driver.findElement(By.xpath("//label[@for='isolationCheck']")).click();
	
		driver.findElement(By.xpath(p.getProperty("searchhotels"))).click();
		Thread.sleep(5000);
	}
	
	public void search1(String title,String fname,String lname,String pan,String mobile,String email) throws Exception
	{

		List<WebElement>ls= driver.findElements(By.xpath(p.getProperty("selectrooms")));
		ls.get(1).click();
		Thread.sleep(2000);
		
		List<WebElement>ls1= driver.findElements(By.xpath(p.getProperty("bookroom")));
		ls1.get(0).click();
		Thread.sleep(2000);
	
		driver.findElement(By.name("Room0AdultTitle0")).sendKeys(title); 
		WebElement w1=driver.findElement(By.name("Room0AdultFirstName0"));
				   w1.clear();
				   w1.sendKeys(fname);
		WebElement w2=driver.findElement(By.name("Room0AdultLastName0"));
		           w2.clear();
		           w2.sendKeys(lname);
     	WebElement w3=driver.findElement(By.name("panNumber"));
     			   w3.clear();
                   w3.sendKeys(pan);
		WebElement w4=driver.findElement(By.xpath(p.getProperty("hmobile")));
		           w4.clear();
		           w4.sendKeys(mobile);
	    WebElement w5=driver.findElement(By.xpath(p.getProperty("hemail")));           
		           w5.clear();
		           w5.sendKeys(email);
		
		}
	  
	public void proceed()
	{

		driver.findElement(By.xpath(p.getProperty("Terms&conditions"))).click();
		driver.findElement(By.xpath(p.getProperty("proceedtobooking"))).click();
	}
	
	public void proceed1() throws Exception
	{
		driver.findElement(By.xpath(p.getProperty("confirmproceedbtn"))).click();
	
	}
	
	
	@Test(enabled=true,description="Book hotel with valid credentials")
	 public void tc_57() throws Exception
	{
		search(ex.getData("Sheet1", 1, 0));
		Thread.sleep(1000);
		search1(ex.getData("Sheet1", 1, 1),ex.getData("Sheet1", 1, 2),ex.getData("Sheet1", 1, 3),ex.getData("Sheet1", 1, 4),ex.getData("Sheet1", 1, 5),ex.getData("Sheet1", 1, 6));
		Thread.sleep(1000);
		proceed();
		Thread.sleep(1000);
		proceed1();
    	boolean data=driver.findElement(By.id("ccNum-allcardsuihandler")).isDisplayed();
		Assert.assertTrue(data);
		System.out.println("Landed on payment page");
		
		ExtentTest tc=ex1.createTest("HotelBookingTest1");
		tc.info("Book hotel with valid credentials");
		tc.pass("test pass");	

	}
	
	
	@Test(enabled=true,description="Unable to book hotel with invalid destination")
	public void tc_58() throws Exception
	{
		search(ex.getData("Sheet1", 2, 0));
		boolean data=driver.findElement(By.xpath("//*[text()='Select Destination']")).isDisplayed();
		Assert.assertTrue(data);
		System.out.println(driver.findElement(By.xpath("//*[text()='Select Destination']")).getText());
		
		ExtentTest tc=ex1.createTest("HotelBookingTest2");
		tc.info("Unable to book hotel with invalid destination");
		tc.pass("test pass");

	}
	
	@Test(enabled=true,description="Unable to book hotel with invalid title")
	public void tc_59() throws Exception
	{
		search(ex.getData("Sheet1", 3, 0));
		Thread.sleep(1000);
		search1(ex.getData("Sheet1", 3, 1),ex.getData("Sheet1", 3, 2),ex.getData("Sheet1", 3, 3),ex.getData("Sheet1", 3, 4),ex.getData("Sheet1", 3, 5),ex.getData("Sheet1", 3, 6));
		Thread.sleep(1000);
		proceed();
		boolean data=driver.findElement(By.xpath("//*[text()='Required']")).isDisplayed();
		Assert.assertTrue(data);
		System.out.println(driver.findElement(By.xpath("//*[text()='Required']")).getText());
		
		ExtentTest tc=ex1.createTest("HotelBookingTest3");
		tc.info("Unable to book hotel with invalid title");
		tc.pass("test pass");

	}
	
	@Test(enabled=true,description="Unable to book hotel with invalid first name")
	public void tc_60() throws Exception
	{
		search(ex.getData("Sheet1", 4, 0));
		Thread.sleep(1000);
		search1(ex.getData("Sheet1", 4, 1),ex.getData("Sheet1", 4, 2),ex.getData("Sheet1", 4, 3),ex.getData("Sheet1", 4, 4),ex.getData("Sheet1", 4, 5),ex.getData("Sheet1", 4, 6));
		Thread.sleep(1000);
		proceed();
		boolean data=driver.findElement(By.xpath("//*[text()='Alphabets & Spaces only']")).isDisplayed();
		Assert.assertTrue(data);
		System.out.println(driver.findElement(By.xpath("//*[text()='Alphabets & Spaces only']")).getText());
		
		ExtentTest tc=ex1.createTest("HotelBookingTest4");
		tc.info("Unable to book hotel with invalid first name");
		tc.pass("test pass");

	}
	
	@Test(enabled=true,description="Unable to book hotel with invalid last name")
	public void tc_61() throws Exception
	{
		search(ex.getData("Sheet1", 5, 0));
		Thread.sleep(1000);
		search1(ex.getData("Sheet1", 5, 1),ex.getData("Sheet1", 5, 2),ex.getData("Sheet1", 5, 3),ex.getData("Sheet1", 5, 4),ex.getData("Sheet1", 5, 5),ex.getData("Sheet1", 5, 6));
		Thread.sleep(1000);
		proceed();
		boolean data=driver.findElement(By.xpath("//*[text()='Alphabets & Spaces only']")).isDisplayed();
		Assert.assertTrue(data);
		System.out.println(driver.findElement(By.xpath("//*[text()='Alphabets & Spaces only']")).getText());

		ExtentTest tc=ex1.createTest("HotelBookingTest5");
		tc.info("Unable to book hotel with invalid last name");
		tc.pass("test pass");

	}
	
	@Test(enabled=true,description="Unable to book hotel with invalid pan number")
	public void tc_62() throws Exception
	{
		search(ex.getData("Sheet1", 6, 0));
		Thread.sleep(1000);
		search1(ex.getData("Sheet1", 6, 1),ex.getData("Sheet1", 6, 2),ex.getData("Sheet1", 6, 3),ex.getData("Sheet1", 6, 4),ex.getData("Sheet1", 6, 5),ex.getData("Sheet1", 6, 6));
		Thread.sleep(1000);
		proceed();
		boolean data=driver.findElement(By.xpath("//*[text()='Please Enter Valid Pan Number']")).isDisplayed();
		Assert.assertTrue(data);
		System.out.println(driver.findElement(By.xpath("//*[text()='Please Enter Valid Pan Number']")).getText());

		ExtentTest tc=ex1.createTest("HotelBookingTest6");
		tc.info("Unable to book hotel with invalid pan number");
		tc.pass("test pass");
	}
	
	@Test(enabled=true,description="Unable to book hotel with invalid mobile number")
	public void tc_63() throws Exception
	{
		search(ex.getData("Sheet1", 7, 0));
		Thread.sleep(1000);
		search1(ex.getData("Sheet1", 7, 1),ex.getData("Sheet1", 7, 2),ex.getData("Sheet1", 7, 3),ex.getData("Sheet1", 7, 4),ex.getData("Sheet1", 7, 5),ex.getData("Sheet1", 7, 6));
		Thread.sleep(1000);
		proceed();
		boolean data=driver.findElement(By.xpath("//*[text()='Enter Valid Mobile & country code ( Required )']")).isDisplayed();
		Assert.assertTrue(data);
		System.out.println(driver.findElement(By.xpath("//*[text()='Enter Valid Mobile & country code ( Required )']")).getText());

		ExtentTest tc=ex1.createTest("HotelBookingTest7");
		tc.info("Unable to book hotel with invalid mobile number");
		tc.pass("test pass");
	}
	

	@Test(enabled=true,description="Unable to book hotel with invalid email id")
	public void tc_64() throws Exception
	{
		search(ex.getData("Sheet1", 8, 0));
		Thread.sleep(1000);
		search1(ex.getData("Sheet1", 8, 1),ex.getData("Sheet1", 8, 2),ex.getData("Sheet1", 8, 3),ex.getData("Sheet1", 8, 4),ex.getData("Sheet1", 8, 5),ex.getData("Sheet1", 8, 6));
		Thread.sleep(1000);
		proceed();
		boolean data=driver.findElement(By.xpath("//*[text()='Enter Valid Email ( Required )']")).isDisplayed();
		Assert.assertTrue(data);
		System.out.println(driver.findElement(By.xpath("//*[text()='Enter Valid Email ( Required )']")).getText());

		ExtentTest tc=ex1.createTest("HotelBookingTest8");
		tc.info("Unable to book hotel with invalid email id");
	    tc.pass("test pass");
	}
	
	@Test(enabled=true,description="Unable to book hotel with invalid checkbox")
	public void tc_65() throws Exception
	{
		search(ex.getData("Sheet1", 9, 0));
		Thread.sleep(1000);
		search1(ex.getData("Sheet1", 9, 1),ex.getData("Sheet1", 9, 2),ex.getData("Sheet1", 9, 3),ex.getData("Sheet1", 9, 4),ex.getData("Sheet1", 9, 5),ex.getData("Sheet1", 9, 6));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Proceed to Booking']")).click();
		boolean data=driver.findElement(By.xpath("//*[text()='Please accept booking terms']")).isDisplayed();
		Assert.assertTrue(data);
		System.out.println(driver.findElement(By.xpath("//*[text()='Please accept booking terms']")).getText());

		ExtentTest tc=ex1.createTest("HotelBookingTest9");
		tc.info("Unable to book hotel with invalid checkbox");
		tc.pass("test pass");
	}
	
	
	@Test(enabled=true,description="Checking the edit option")
	public void tc_66() throws Exception
	{
		search(ex.getData("Sheet1", 10, 0));
		Thread.sleep(1000);
		search1(ex.getData("Sheet1", 10, 1),ex.getData("Sheet1", 10, 2),ex.getData("Sheet1", 10, 3),ex.getData("Sheet1", 10, 4),ex.getData("Sheet1", 10, 5),ex.getData("Sheet1", 10, 6));
		Thread.sleep(1000);
		proceed();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Edit Details']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='Terms & Conditions']")).isEnabled());
		System.out.println(driver.findElement(By.xpath("//a[normalize-space()='Terms & Conditions']")).getText());
		ExtentTest tc=ex1.createTest("HotelBookingTest10");
		tc.info("Checking the edit option");
		tc.pass("test pass");
		ex1.flush();
	}
	
  	 
}