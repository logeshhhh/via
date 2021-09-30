package project;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginPage extends Base 
{
	public void login(String email) 
	{
		  driver.findElement(By.id("wzrk-cancel")).click();
		  driver.findElement(By.id("SignIn")).click();
		  driver.findElement(By.cssSelector("[class='panelInlineTxt jsInitLoginValid u_clViaGreen signUpBtn']")).click();
		  driver.findElement(By.id("forgotEmail")).sendKeys(email);
		  driver.findElement(By.cssSelector("[class='inlineBtn panelBtn jsSendOtp']")).click();
		
		  
	}
	
	public void login1(String email, String pwd)
	{
		  driver.findElement(By.id("wzrk-cancel")).click();
		  driver.findElement(By.id("SignIn")).click();
		  driver.findElement(By.id("loginIdText")).sendKeys(email);
		  driver.findElement(By.id("passwordText")).sendKeys(pwd);
		  driver.findElement(By.id("loginValidate")).click();	 
	}
	
	public void login2(String email, String pwd)
	{
		  driver.findElement(By.id("wzrk-cancel")).click();
		  driver.findElement(By.id("SignIn")).click();
		  driver.findElement(By.id("loginFacebook")).click();
		  
	}
	
	
	
	@Test(enabled=true,description="Testing with valid credentials")
	  public void tc_01()
	{
		  driver.get("https://in.via.com/");
		  login1("logeshm2000@gmail.com","password123");
		  boolean data=driver.findElement(By.id("userNameSecondaryNav")).isDisplayed();
		  Assert.assertTrue(data);
		  System.out.println(driver.findElement(By.id("userNameSecondaryNav")).getText());
	  }
	
	@Test(enabled=false,description="Testing with Invalid credentials")
	  public void tc_02() throws InterruptedException 
	{
		  driver.get("https://in.via.com/");
		  login1("logeshm2000@gmail.com","passworddd");
		  boolean data=driver.findElement(By.xpath("//div[@id='viaAlert']/div[1]/div[1]")).isDisplayed();
		  Assert.assertTrue(data);
		  System.out.println("Login Error. Please try again!");
	  }
	
	@Test(enabled=false,description="Testing with Invalid credentials")
	  public void tc_03() 
	{
		  driver.get("https://in.via.com/");
		  login1("logeshm2000.com","password");
		  boolean data=driver.findElement(By.cssSelector("[class='qtip-content']")).isDisplayed();
		  Assert.assertTrue(data);
		  System.out.println("Enter Valid Email");
	  }
	
	@Test(enabled=false,description="Testing with Invalid credentials")
	  public void tc_04() 
	{
		  driver.get("https://in.via.com/");
		  login1("","");
		  boolean data=driver.findElement(By.cssSelector("[class='qtip-content']")).isDisplayed();
		  Assert.assertTrue(data);
		  System.out.println("Enter Valid Email");
	  }
	@Test(enabled=false,description="Testing with Invalid credentials")
	  public void tc_06() 
	{
		  driver.get("https://in.via.com/");
		  login("jajaja.com");
		  boolean data=driver.findElement(By.cssSelector("[class='qtip-content']")).isDisplayed();
		  Assert.assertTrue(data);
		  System.out.println("Enter your email or mobile to get an OTP!");
	  }
	
	@Test(enabled=false,description="Testing with Invalid credentials")
	  public void tc_07() 
	{
		  driver.get("https://in.via.com/");
		  login("");
		  boolean data=driver.findElement(By.cssSelector("[class='qtip-content']")).isDisplayed();
		  Assert.assertTrue(data);
		  System.out.println("Enter your email or mobile to get an OTP!");
	 }
	@Test(enabled=false,description="Testing with Invalid credentials")
	  public void tc_08() 
	{
		  driver.get("https://in.via.com/");
		  login("");
		  boolean data=driver.findElement(By.cssSelector("[class='qtip-content']")).isDisplayed();
		  Assert.assertTrue(data);
		  System.out.println("Enter your email or mobile to get an OTP!");
	 }
	
 

  
  
  /*
  
  @Test(enabled=false)
  public void TC_05() throws Exception 
  {
	  ExtentReports ex=new ExtentReports();
	  ExtentHtmlReporter s=(new ExtentHtmlReporter("TC_05.html"));
	  ex.attachReporter(s);
	  s.config().setTheme(Theme.DARK);
	  ExtentTest tc=ex.createTest("LoginTest");
	  
	  
	  tc.info("Opening Url").pass("Test Pass");
	  driver.get("https://in.via.com/");
	  
	  tc.info("Closing the Pop-Up").pass("Test Pass");
	  driver.findElement(By.id("wzrk-cancel")).click();
	  
	  tc.info("Click on Sign in").pass("Test Pass");
	  driver.findElement(By.id("SignIn")).click();
	  
	  tc.info("Click on Forgot Password").pass("Test Pass");
	  driver.findElement(By.cssSelector("[class='panelInlineTxt jsInitLoginValid u_clViaGreen signUpBtn']")).click();
	  
	  tc.info("Enter Valid Email/Number").pass("Test Pass");
	  driver.findElement(By.id("forgotEmail")).sendKeys("logeshm2000@gmail.com");
	  
	  tc.info("Click on Send OTP").pass("Test Pass");
	  driver.findElement(By.cssSelector("[class='inlineBtn panelBtn jsSendOtp']")).click();
	  
	  tc.info("Enter Valid OTP").pass("Test Pass");
	  driver.findElement(By.id("otp")).sendKeys("825152");
	  
	  tc.info("Enter Valid New Password").pass("Test Pass");
	  driver.findElement(By.id("newPassword")).sendKeys("password123");
	  
	  tc.info("Click on Reset Password").pass("Test Pass");
	  driver.findElement(By.id("resetPassword")).click();
	  
	  tc.info("Verifying").pass("Test Pass");
	  String a=driver.findElement(By.id("userNameSecondaryNav")).getText();
	  
	  
	  
	  Assert.assertEquals("Hi Logesh",a);
	  
	 
	  
	  ex.flush();
	 
  }
  
  
  
  @Test(enabled=false)
  public void TC_08() throws Exception 
  {
	  ExtentReports ex=new ExtentReports();
	  ExtentHtmlReporter s=(new ExtentHtmlReporter("TC_08.html"));
	  ex.attachReporter(s);
	  s.config().setTheme(Theme.DARK);
	  ExtentTest tc=ex.createTest("LoginTest");
	  
	  
	  tc.info("Opening Url").pass("Test Pass");
	  driver.get("https://in.via.com/");
	  
	  tc.info("Closing the Pop-Up").pass("Test Pass");
	  driver.findElement(By.id("wzrk-cancel")).click();
	  
	  tc.info("Click on Sign in").pass("Test Pass");
	  driver.findElement(By.id("SignIn")).click();
	  
	  tc.info("Click on Login With Facebook").pass("Test Pass");
	  driver.findElement(By.id("loginFacebook")).click();
	  
	  tc.info("Enter InValid Email/Number").pass("Test Pass");
	  driver.findElement(By.id("email")).sendKeys("jajaja");
	  
	 
	  
	  ex.flush();
	 
  }
  
  @Test(enabled=false)
  public void TC_09() throws Exception 
  {
	  ExtentReports ex=new ExtentReports();
	  ExtentHtmlReporter s=(new ExtentHtmlReporter("TC_09.html"));
	  ex.attachReporter(s);
	  s.config().setTheme(Theme.DARK);
	  ExtentTest tc=ex.createTest("LoginTest");
	  
	  
	  tc.info("Opening Url").pass("Test Pass");
	  driver.get("https://in.via.com/");
	  
	  tc.info("Closing the Pop-Up").pass("Test Pass");
	  driver.findElement(By.id("wzrk-cancel")).click();
	  
	  tc.info("Click on Sign in").pass("Test Pass");
	  driver.findElement(By.id("SignIn")).click();
	  
	  tc.info("Click on Login With Google").pass("Test Pass");
	  driver.findElement(By.id("loginGoogle")).click();
	  
	  
	
	  
	  ex.flush();
	 
  }
  */
}
