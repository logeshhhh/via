package project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;


public class LoginPage extends Base 
{
	Properties p =new Properties();
	ExtentReports ex1= new ExtentReports();
	
	//login
		public void getData(String email,String pwd) 
		{
			 try {
				p.load(new FileInputStream("settings.property"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 driver.get(p.getProperty("url"));
			 driver.findElement(By.id("SignIn")).click();
			 driver.findElement(By.id("loginIdText")).sendKeys(email);
			 driver.findElement(By.id("passwordText")).sendKeys(pwd);
			 driver.findElement(By.id("loginValidate")).click();     
		}
		
	  @Test(enabled=true, description="login with valid credentials")
	  public void tc_1() 
	  {
		  getData("logeshm2000@gmail.com", "password123");  
		  boolean d=driver.findElement(By.xpath("//div[@class='elementPad menuLabel secNavIcon']")).isDisplayed();
		  Assert.assertTrue(d);
		  System.out.println("Login Successful");
		  driver.findElement(By.xpath("//div[contains(@class,'elementPad menuLabel secNavIcon')]")).click();
		  driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
	  }
	  
	  @Test(enabled=true, description="login with invalid credentials")
	  public void tc_2() 
	  {
		  getData("logeshm2000@gmail.com", "newpassword");
		  WebDriverWait wt=new WebDriverWait(driver,2);
		  wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'viaAlertMsg')]")));
		  boolean d=driver.findElement(By.xpath("//div[contains(@class,'viaAlertMsg')]")).isDisplayed();
		  Assert.assertTrue(d);	  
	  }
	  
	  @Test(enabled=true, description="login with invalid credentials")
	  public void tc_3() 
	  {
		  getData("logeshm2000", "newpassword");
		  boolean d=driver.findElement(By.cssSelector("div[class='qtip-content']")).isDisplayed();
		  Assert.assertTrue(d);	  
	  }
	  
	  @Test(enabled=true, description="login with invalid credentials")
	  public void tc_4() 
	  {
		  getData(" ", "");
		  boolean d=driver.findElement(By.cssSelector("div[class='qtip-content']")).isDisplayed();
		  Assert.assertTrue(d);  
	  }
	  
	  @Test(enabled=true, description="login with invalid credentials")
	  public void tc_5() 
	  {
		  getData("logeshm2000@gmail.com ", "");
		  boolean d=driver.findElement(By.cssSelector("div[class='qtip-content']")).isDisplayed();
		  Assert.assertTrue(d);  
	  }
	  
	  @Test(enabled=true, description="login with invalid credentials")
	  public void tc_6() 
	  {
		  getData(" ", "password123");
		  boolean d=driver.findElement(By.cssSelector("div[class='qtip-content']")).isDisplayed();
		  Assert.assertTrue(d);  
	  }
	  
	  //reset
	  public void getData1(String email) 
	  {
		  driver.findElement(By.id("SignIn")).click();
		  driver.findElement(By.cssSelector("[class='panelInlineTxt jsInitLoginValid u_clViaGreen signUpBtn']")).click();
		  driver.findElement(By.id("forgotEmail")).sendKeys(email);
		  driver.findElement(By.cssSelector("[class='inlineBtn panelBtn jsSendOtp']")).click();
	  }
	  
	  @Test(enabled=true, description="reset password with invalid email")
	  public void tc_7()
	  {   
	      getData1("grykk");
	      boolean d=driver.findElement(By.cssSelector("div[class='qtip-content']")).isDisplayed();
	      Assert.assertTrue(d);  
	      System.out.println("Enter valid email");
	  }
	  
	  @Test(enabled=true, description="reset with null email")
	  public void tc_8()
	  {   
	      getData1("");
	      boolean d=driver.findElement(By.cssSelector("div[class='qtip-content']")).isDisplayed();
	      Assert.assertTrue(d); 
	      System.out.println("Enter valid email");
	  }
	  
	  @Test(enabled=true, description="testing with unregistered email")
	  public void tc_9() throws Exception
	  {   
	      getData1("testingdemo@gmail.com");
	      boolean d=driver.findElement(By.xpath("//div[@class='viaAlertMsg']")).isDisplayed();
	      Assert.assertTrue(d); 
	      System.out.println(driver.findElement(By.xpath("//div[@class='viaAlertMsg']")).getText());
	  }
	  
	  /* //google
	  public void getData3(String fname, String pwd)
	  { 
		//driver.findElement(By.id("wzrk-cancel")).click();
	    driver.manage().deleteAllCookies();
	    driver.findElement(By.id("SignIn")).click();
	    driver.findElement(By.id("loginGoogle")).click();   
	    Set<String> allWin=driver.getWindowHandles();
	    List<String> allWin2= new ArrayList(allWin);
	    driver.switchTo().window(allWin2.get(1));
	    driver.findElement(By.xpath("//div[@class='BHzsHc']")).click();
	    driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys(fname);
	    driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
	    driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();  
	  }
	  
	  @Test(enabled=true, description="login with facebook missing credentials")
	  public void tc_10()
	  {   driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
		  driver.get("https://in.via.com/");
	  
	      getData3("ishwarya","password");
	      boolean d=driver.findElement(By.xpath("//div[@class='fsl fwb fcb']")).isDisplayed();
	      Assert.assertTrue(d);
	      driver.close();
	  } */






	//facebook
	  public void getData2(String fname, String pwd)
	  { 
	    driver.findElement(By.id("SignIn")).click();
	    driver.findElement(By.id("loginFacebook")).click();   
	    Set<String> allWin=driver.getWindowHandles();
	    List<String> allWin2= new ArrayList(allWin);
	    driver.switchTo().window(allWin2.get(1));
	    driver.findElement(By.xpath("//input[@id='email']")).sendKeys(fname);
	    driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(pwd);
	    driver.findElement(By.name("login")).click(); 
	    
	  }
	  
	  @Test(enabled=true, description="login with facebook invalid credentials")
	  public void tc_12() throws Exception
	  {   
	      getData2("demo","test123");
	      boolean d=driver.findElement(By.xpath("//div[@class='fsl fwb fcb']")).isDisplayed();
	      Assert.assertTrue(d);
	      driver.close();
	      Thread.sleep(2000);
	  }
	  
	  @Test(enabled=true, description="login with facebook missing credentials")
	  public void tc_13()
	  {  
		  driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
	      driver.manage().deleteAllCookies();
		  driver.get("https://in.via.com/");
	  
	      getData2("","");
	      boolean d=driver.findElement(By.xpath("//div[@class='fsl fwb fcb']")).isDisplayed();
	      Assert.assertTrue(d);
	      driver.close();
	  }
	  
	  @Test(enabled=true, description="login with facebook valid credentials")
	  public void tc_14()
	  {   
		  driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
	      driver.manage().deleteAllCookies();
		  driver.get("https://in.via.com/");
	  
	      getData2("maref16555@busantei.com","testingdemo123$");
	      boolean d=driver.findElement(By.xpath("//div[@class='_50f3']")).isDisplayed();
	      Assert.assertTrue(d);
	      driver.close();
	  }
	  
	}