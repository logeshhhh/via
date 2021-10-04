package project;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class SignUp extends Base
{
	Properties p =new Properties();
	Excel_Import ex= new Excel_Import("src/test/resources/data/LoginData.xlsx"); //excel data sheet importing
	ExtentReports ext=new ExtentReports(); 
	ExtentTest tc;

	public void getData(String email, String name, String pwd, String mobile) throws Exception {
	  
	  p.load(new FileInputStream("settings1.property"));
	  ext.attachReporter(new ExtentHtmlReporter("signup.html"));
	  
	  driver.get(p.getProperty("url"));
	  driver.findElement(By.id(p.getProperty("signin"))).click();
	  driver.findElement(By.xpath(p.getProperty("signup"))).click();
	  driver.findElement(By.xpath(p.getProperty("email"))).sendKeys(email);
	  driver.findElement(By.xpath(p.getProperty("name"))).sendKeys(name);
	  driver.findElement(By.xpath(p.getProperty("pwd"))).sendKeys(pwd);
	  driver.findElement(By.xpath(p.getProperty("mob"))).sendKeys(mobile);
	  driver.findElement(By.xpath(p.getProperty("fin"))).click(); 
	}
	
  @Test(enabled=true, description="Testing with valid credentials")
  public void tc_13() throws Exception {
	  

	  getData(ex.getData("Sheet1", 1, 0),ex.getData("Sheet1", 1, 1),ex.getData("Sheet1", 1, 2),ex.getData("Sheet1", 1, 3));
	  boolean data=driver.findElement(By.xpath(p.getProperty("valid"))).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println(driver.findElement(By.xpath(p.getProperty("valid"))).getText());
	  tc=ext.createTest("SignupTest1.html");
	  tc.info("Testing with valid credentials");
	  tc.pass("test pass");
	  
  }
  
  @Test(enabled=true, description="Testing with existing email and mobile")
  public void tc_14() throws Exception {
	  
	  
	  getData(ex.getData("Sheet1", 2, 0),ex.getData("Sheet1", 2, 1),ex.getData("Sheet1", 2, 2),ex.getData("Sheet1", 2, 3));
	  boolean data=driver.findElement(By.xpath(p.getProperty("invalid"))).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println("Email/Mobile already registered with us");
	  tc=ext.createTest("SignupTest2.html");
	  tc.info("Testing with existing email and mobile");
	  tc.pass("test pass");
	  
  }
  
  @Test(enabled=true, description="Testing with existing email")
  public void tc_15() throws Exception {
	  
	  
	  getData(ex.getData("Sheet1", 3, 0),ex.getData("Sheet1", 3, 1),ex.getData("Sheet1", 3, 2),ex.getData("Sheet1", 3, 3));
	  boolean data=driver.findElement(By.xpath(p.getProperty("invalid"))).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println("Email/Mobile already registered with us");
	  tc=ext.createTest("SignupTest3.html");
	  tc.info("Testing with existing email");
	  tc.pass("test pass");
	  
  }
  
  @Test(enabled=true, description="Testing with existing mobile")
  public void tc_16() throws Exception {
	  
	 
	  getData(ex.getData("Sheet1", 4, 0),ex.getData("Sheet1", 4, 1),ex.getData("Sheet1", 4, 2),ex.getData("Sheet1", 4, 3));
	  boolean data=driver.findElement(By.xpath(p.getProperty("invalid"))).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println("Email/Mobile already registered with us");
	  tc=ext.createTest("SignupTest4.html");
	  tc.info("Testing with existing mobile");
	  tc.pass("test pass");
	  
  }
  
  @Test(enabled=true, description="Testing with invalid email")
  public void tc_17() throws Exception {
	  
	  getData(ex.getData("Sheet1", 5, 0),ex.getData("Sheet1", 5, 1),ex.getData("Sheet1", 5, 2),ex.getData("Sheet1", 5, 3));
	  boolean data=driver.findElement(By.xpath(p.getProperty("invalid"))).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println("Enter Valid Email");
	  tc=ext.createTest("SignupTest5.html");
	  tc.info("Testing with invalid email");
	  tc.pass("test pass");
	  
  }
  
  @Test(enabled=true, description="Testing with invalid mobile")
  public void tc_18() throws Exception {
	  
	  
	  getData(ex.getData("Sheet1", 6, 0),ex.getData("Sheet1", 6, 1),ex.getData("Sheet1", 6, 2),ex.getData("Sheet1", 6, 3));
	  boolean data=driver.findElement(By.xpath(p.getProperty("invalid"))).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println("Enter Valid Mobile");
	  tc=ext.createTest("SignupTest6.html");
	  tc.info("Testing with invalid mobile");
	  tc.pass("test pass");
	  
  }
  
  @Test(enabled=true, description="Testing with invalid password")
  public void tc_19() throws Exception {
	  
	  
	  getData(ex.getData("Sheet1", 7, 0),ex.getData("Sheet1", 7, 1),ex.getData("Sheet1", 7, 2),ex.getData("Sheet1", 7, 3));
	  boolean data=driver.findElement(By.xpath(p.getProperty("invalid"))).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println("Password must be atleast 8 characters long");
	  tc=ext.createTest("SignupTest7.html");
	  tc.info("Testing with invalid password");
	  tc.pass("test pass");
	 
  }
 
  @Test(enabled=true, description="Testing with invalid name")
  public void tc_20() throws Exception {
	  
	 
	  getData(ex.getData("Sheet1", 8, 0),ex.getData("Sheet1", 8, 1),ex.getData("Sheet1", 8, 2),ex.getData("Sheet1", 8, 3));
	  boolean data=driver.findElement(By.xpath(p.getProperty("invalid"))).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println("Enter Valid Name");
	  tc=ext.createTest("SignupTest8.html");
	  tc.info("Testing with invalid name");
	  tc.pass("test pass");
	  
  }
  
  @Test(enabled=true, description="Testing with null credentials")
  public void tc_21() throws Exception {
	  
	  
	  getData(ex.getData("Sheet1", 9, 0),ex.getData("Sheet1", 9, 1),ex.getData("Sheet1", 9, 2),ex.getData("Sheet1", 9, 3));
	  boolean data=driver.findElement(By.xpath(p.getProperty("invalid"))).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println("Enter valid email");
	  tc=ext.createTest("SignupTest9.html");
	  tc.info("Testing with null credentials");
	  tc.pass("test pass");
	  
  }
  
  @Test(enabled=true, description="Testing without email")
  public void tc_22() throws Exception {
	  
	  
	  getData(ex.getData("Sheet1", 10, 0),ex.getData("Sheet1", 10, 1),ex.getData("Sheet1", 10, 2),ex.getData("Sheet1", 10, 3));
	  boolean data=driver.findElement(By.xpath(p.getProperty("invalid"))).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println("Enter valid email");
	  tc=ext.createTest("SignupTest10.html");
	  tc.info("Testing without email");
	  tc.pass("test pass");
	  
  }
  
  @Test(enabled=true, description="Testing without name")
  public void tc_23() throws Exception {
	  
	  
	  getData(ex.getData("Sheet1", 11, 0),ex.getData("Sheet1", 11, 1),ex.getData("Sheet1", 11, 2),ex.getData("Sheet1", 11, 3));
	  boolean data=driver.findElement(By.xpath(p.getProperty("invalid"))).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println("Enter valid name");
	  tc=ext.createTest("SignupTest11.html");
	  tc.info("Testing without name");
	  tc.pass("test pass");
	  
  }
  
  @Test(enabled=true, description="Testing without password")
  public void tc_24() throws Exception {
	  
	 
	  getData(ex.getData("Sheet1", 12, 0),ex.getData("Sheet1", 12, 1),ex.getData("Sheet1", 12, 2),ex.getData("Sheet1", 12, 3));
	  boolean data=driver.findElement(By.xpath(p.getProperty("invalid"))).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println("Password must be atleast 8 characters long");
	  tc=ext.createTest("SignupTest12.html");
	  tc.info("Testing without password");
	  tc.pass("test pass");
	  
  }
  
  @Test(enabled=true, description="Testing without mobile")
  public void tc_25() throws Exception {
	  
	  
	  getData(ex.getData("Sheet1", 13, 0),ex.getData("Sheet1", 13, 1),ex.getData("Sheet1", 13, 2),ex.getData("Sheet1", 13, 3));
	  boolean data=driver.findElement(By.xpath(p.getProperty("invalid"))).isDisplayed();
	  Assert.assertTrue(data);
	  System.out.println("Mobile Required");
	  tc=ext.createTest("SignupTest13.html");
	  tc.info("Testing without mobile");
	  tc.pass("test pass");
	  ext.flush();
  }
  
  
  
}