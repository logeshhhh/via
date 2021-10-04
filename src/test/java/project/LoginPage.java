package project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class LoginPage extends Base 
{
	Excel_Import ex= new Excel_Import("src/test/resources/data/LoginData.xlsx");
	Properties p =new Properties();
	ExtentReports ext=new ExtentReports();
	ExtentTest tc;

	//login
	public void getData(String email,String pwd) throws Exception {
		p.load(new FileInputStream("settings1.property"));
		ext.attachReporter(new ExtentHtmlReporter("login.html"));
		
		 driver.get(p.getProperty("url"));
		 driver.findElement(By.id(p.getProperty("signinl"))).click();
		 driver.findElement(By.id(p.getProperty("emaill"))).sendKeys(email);
		 driver.findElement(By.id(p.getProperty("pwdl"))).sendKeys(pwd);
		 driver.findElement(By.id(p.getProperty("login"))).click();     
	}
	
  @Test(enabled=true, description="login with valid credentials")
  public void tc_01() throws Exception {
	 getData(ex.getData("Sheet2", 1, 0),ex.getData("Sheet2", 1, 1));  
	 boolean d=driver.findElement(By.xpath(p.getProperty("validl"))).isDisplayed();
	  Assert.assertTrue(d);
	  System.out.println("Login Successful");
	  driver.findElement(By.xpath(p.getProperty("validl"))).click();
	  driver.findElement(By.xpath(p.getProperty("logout"))).click();
	  tc=ext.createTest("LoginTest1.html");
	  tc.info("login with valid credentials");
	  tc.pass("test pass");
	  ext.flush();
  }
  
  @Test(enabled=true, description="login with invalid credentials")
  public void tc_02() throws Exception {
	  getData(ex.getData("Sheet2", 2, 0),ex.getData("Sheet2", 2, 1));
	  Thread.sleep(2000);
	  boolean d=driver.findElement(By.xpath(p.getProperty("invalidl"))).isDisplayed();
	  Assert.assertTrue(d);	
	  tc=ext.createTest("LoginTest2.html");
	  tc.info("login with invalid credentials");
	  tc.pass("test pass");
	  ext.flush();
  }
  @Test(enabled=true, description="login with invalid credentials")
  public void tc_03() throws Exception {
	  getData(ex.getData("Sheet2", 3, 0),ex.getData("Sheet2", 3, 1));
	  boolean d=driver.findElement(By.cssSelector(p.getProperty("invalidl1"))).isDisplayed();
	  Assert.assertTrue(d);	
	  tc=ext.createTest("LoginTest3.html");
	  tc.info("login with invalid credentials");
	  tc.pass("test pass");
	  ext.flush();
	  
  }
  @Test(enabled=true, description="login with null credentials")
  public void tc_04() throws Exception {
	  getData(ex.getData("Sheet2", 4, 0),ex.getData("Sheet2", 4, 1));
	  boolean d=driver.findElement(By.cssSelector(p.getProperty("invalidl1"))).isDisplayed();
	  Assert.assertTrue(d); 
	  tc=ext.createTest("LoginTest4.html");
	  tc.info("login with null credentials");
	  tc.pass("test pass");
	  ext.flush();
  }
  
  @Test(enabled=true, description="login with null password")
  public void tc_05() throws Exception {
	  getData(ex.getData("Sheet2", 5, 0),ex.getData("Sheet2", 5, 1));
	  boolean d=driver.findElement(By.cssSelector(p.getProperty("invalidl1"))).isDisplayed();
	  Assert.assertTrue(d);  
	  tc=ext.createTest("LoginTest5.html");
	  tc.info("login with null password");
	  tc.pass("test pass");
	  ext.flush();
  }
  
  @Test(enabled=true, description="login with null email")
  public void tc_06() throws Exception {
	  getData(ex.getData("Sheet2", 6, 0),ex.getData("Sheet2", 6, 1));
	  boolean d=driver.findElement(By.cssSelector(p.getProperty("invalidl1"))).isDisplayed();
	  Assert.assertTrue(d);  
	  tc=ext.createTest("LoginTest6.html");
	  tc.info("login with null email");
	  tc.pass("test pass");
	  ext.flush();
  }
  
  
  //reset
  public void getData1(String email) 
  {
	  driver.get(p.getProperty("url"));
	  driver.findElement(By.id(p.getProperty("rsign"))).click();
	  driver.findElement(By.cssSelector(p.getProperty("reset"))).click();
	  driver.findElement(By.id(p.getProperty("forgot"))).sendKeys(email);
	  driver.findElement(By.cssSelector(p.getProperty("click"))).click();
  }
  
  @Test(enabled=true, description="reset password with invalid email")
  public void tc_07() {  
      getData1(ex.getData("Sheet2", 7, 0));
      boolean d=driver.findElement(By.cssSelector(p.getProperty("invalidl1"))).isDisplayed();
      Assert.assertTrue(d);  
      System.out.println("Enter valid email");
      tc=ext.createTest("LoginTest7.html");
	  tc.info("reset password with invalid email");
	  tc.pass("test pass");
	  ext.flush();
  }
  @Test(enabled=true, description="reset with null email")
  public void tc_08(){  
      getData1(ex.getData("Sheet2", 8, 0));
      boolean d=driver.findElement(By.cssSelector(p.getProperty("invalidl1"))).isDisplayed();
      Assert.assertTrue(d); 
      System.out.println("Enter valid email");
      tc=ext.createTest("LoginTest8.html");
	  tc.info("reset with null email");
	  tc.pass("test pass");
	  ext.flush();
  }
  
  @Test(enabled=true, description="reset with unregistered email")
  public void tc_09() throws Exception{  
      getData1(ex.getData("Sheet2", 9, 0));
      boolean d=driver.findElement(By.xpath(p.getProperty("otp"))).isDisplayed();
      Assert.assertTrue(d); 
      Thread.sleep(2000);
      System.out.println(driver.findElement(By.xpath(p.getProperty("alert"))).getText());
      tc=ext.createTest("LoginTest9.html");
	  tc.info("reset with unregistered email");
	  tc.pass("test pass");
	  ext.flush();
  }
  
  @Test(enabled=true, description="reset with existing email")
  public void tc_10() throws Exception{  
      getData1(ex.getData("Sheet2", 10, 0));
      Scanner sc = new Scanner(System.in);  
      System.out.println("Enter the OTP");
      Thread.sleep(50000);
      driver.findElement(By.xpath(p.getProperty("otpip"))).sendKeys(sc.nextLine());
      Thread.sleep(20000);
      driver.findElement(By.xpath(p.getProperty("rpwd"))).sendKeys(ex.getData("Sheet2", 10, 1));
      driver.findElement(By.xpath(p.getProperty("rfin"))).click();
      boolean d= driver.findElement(By.xpath(p.getProperty("valid"))).isDisplayed();
      Assert.assertTrue(d); 
      tc=ext.createTest("LoginTest10.html");
	  tc.info("reset with existing email");
	  tc.pass("test pass");
	  ext.flush();
  }
  
  


//facebook
 
  public void getData2(String fname, String pwd)
  	{ 
		driver.get(p.getProperty("url"));
	    driver.findElement(By.id(p.getProperty("signinl"))).click();
	    driver.findElement(By.id(p.getProperty("flogin"))).click();   
	    Set<String> allWin=driver.getWindowHandles();
	    List<String> allWin2= new ArrayList(allWin);
	    driver.switchTo().window(allWin2.get(1));
	    driver.findElement(By.xpath(p.getProperty("femail"))).sendKeys(fname);
	    driver.findElement(By.xpath(p.getProperty("fpass"))).sendKeys(pwd);
	    driver.findElement(By.name(p.getProperty("flog"))).click(); 
	    
  	}
  
  @Test(enabled=true, description="login with facebook invalid credentials")
  public void tc_11() throws Exception
  {   
      getData2(ex.getData("Sheet2", 11, 0),ex.getData("Sheet2", 11, 1));
      boolean d=driver.findElement(By.xpath(p.getProperty("facebook"))).isDisplayed();
      Assert.assertTrue(d);
      tc=ext.createTest("LoginTest11.html");
	  tc.info("login with facebook invalid credentials");
	  tc.pass("test pass");
	  ext.flush();
      driver.close();
      
  }
  
  @Test(enabled=true, description="login with facebook missing credentials")
  public void tc_12()
  {   driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
      driver.manage().deleteAllCookies();
  
      getData2(ex.getData("Sheet2", 12, 0),ex.getData("Sheet2", 12, 1));
      boolean d=driver.findElement(By.xpath(p.getProperty("facebook"))).isDisplayed();
      Assert.assertTrue(d);
      tc=ext.createTest("LoginTest12.html");
	  tc.info("login with facebook missing credentials");
	  tc.pass("test pass");
	  ext.flush();
      driver.close();
  }
  
  
  
}