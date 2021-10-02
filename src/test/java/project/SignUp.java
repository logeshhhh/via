package project;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUp extends Base
{
	public void getData(String email, String name, String pwd, String mobile) 
	{
		  //driver.findElement(By.id("wzrk-cancel")).click();
		  driver.findElement(By.id("SignIn")).click();
		  driver.findElement(By.xpath("//span[normalize-space()='SIGN UP']")).click();
		  driver.findElement(By.xpath("//input[@id='emailIdSignUp']")).sendKeys(email);
		  driver.findElement(By.xpath("//input[@id='nameSignUp']")).sendKeys(name);
		  driver.findElement(By.xpath("//input[@id='passwordSignUp']")).sendKeys(pwd);
		  driver.findElement(By.xpath("//input[@id='mobileNoSignUp']")).sendKeys(mobile);
		  driver.findElement(By.xpath("//input[@id='signUpValidate']")).click(); 
	}
		
	
	@Test(enabled=true, description="Testing with valid credentials")
	  public void tc_13() {
		  driver.get("https://in.via.com/");
		  getData("testingdemo1245@gmail.com", "Demo", "testingdemo", "9689996734");
		  boolean data=driver.findElement(By.xpath("//div[@class='elementPad menuLabel secNavIcon']")).isDisplayed();
		  Assert.assertTrue(data);
		  System.out.println("Sign Up successful");
	  }
	  
	  @Test(enabled=true, description="Testing with existing email and mobile")
	  public void tc_14() {
		  driver.get("https://in.via.com/");
		  getData("testingdemo111@gmail.com", "Demo", "testingdemo", "7689456734");
		  boolean data=driver.findElement(By.xpath("//div[contains(text(),'Sign In')]")).isDisplayed();
		  Assert.assertTrue(data);
		  System.out.println("Email/Mobile already registered with us");
	  }
	  
	  @Test(enabled=true, description="Testing with existing email")
	  public void tc_15() {
		  driver.get("https://in.via.com/");
		  getData("testingdemo111@gmail.com", "Demo", "testingdemo", "9289456734");
		  boolean data=driver.findElement(By.xpath("//div[contains(text(),'Sign In')]")).isDisplayed();
		  Assert.assertTrue(data);
		  System.out.println("Email/Mobile already registered with us");
	  }
	  
	  @Test(enabled=true, description="Testing with existing mobile")
	  public void tc_16() {
		  driver.get("https://in.via.com/");
		  getData("testingvia234@gmail.com", "Demo", "testingdemo", "7689456734");
		  boolean data=driver.findElement(By.xpath("//div[contains(text(),'Sign In')]")).isDisplayed();
		  Assert.assertTrue(data);
		  System.out.println("Email/Mobile already registered with us");
	  }
	  
	  @Test(enabled=true, description="Testing with invalid email")
	  public void tc_17() {
		  driver.get("https://in.via.com/");
		  getData("testingdemo111gmail.com", "Demo", "testingdemo", "9867356473");
		  boolean data=driver.findElement(By.xpath("//div[contains(text(),'Sign In')]")).isDisplayed();
		  Assert.assertTrue(data);
		  System.out.println("Enter Valid Email");
	  }
	  
	  @Test(enabled=true, description="Testing with invalid mobile")
	  public void tc_18() {
		  driver.get("https://in.via.com/");
		  getData("testingvia890@gmail.com", "Demo", "testingdemo", "1a&&56");
		  boolean data=driver.findElement(By.xpath("//div[contains(text(),'Sign In')]")).isDisplayed();
		  Assert.assertTrue(data);
		  System.out.println("Enter Valid Mobile");
	  }
	  
	  @Test(enabled=true, description="Testing with invalid password")
	  public void tc_19() {
		  driver.get("https://in.via.com/");
		  getData("testingvia567@gmail.com", "Demo", "test", "7689206734");
		  boolean data=driver.findElement(By.xpath("//div[contains(text(),'Sign In')]")).isDisplayed();
		  Assert.assertTrue(data);
		  System.out.println("Password must be atleast 8 characters long");
	  }
	 
	  @Test(enabled=true, description="Testing with invalid name")
	  public void tc_20() {
		  driver.get("https://in.via.com/");
		  getData("testprojectvia567@gmail.com", "12345", "testingdemo", "7689200004");
		  boolean data=driver.findElement(By.xpath("//div[contains(text(),'Sign In')]")).isDisplayed();
		  Assert.assertTrue(data);
		  System.out.println("Enter Valid Name");
	  }
	  
	  @Test(enabled=true, description="Testing with null credentials")
	  public void tc_21() {
		  driver.get("https://in.via.com/");
		  getData("","","","");
		  boolean data=driver.findElement(By.xpath("//div[contains(text(),'Sign In')]")).isDisplayed();
		  Assert.assertTrue(data);
		  System.out.println("Enter valid email");
	  }
	  
	  @Test(enabled=true, description="Testing without email")
	  public void tc_22() {
		  driver.get("https://in.via.com/");
		  getData("","Demo","testingdemo","9034873894");
		  boolean data=driver.findElement(By.xpath("//div[contains(text(),'Sign In')]")).isDisplayed();
		  Assert.assertTrue(data);
		  System.out.println("Enter valid email");
	  }
	  
	  @Test(enabled=true, description="Testing without name")
	  public void tc_23() {
		  driver.get("https://in.via.com/");
		  getData("testingviademo@yahoo.com","","testingdemo","9034903894");
		  boolean data=driver.findElement(By.xpath("//div[contains(text(),'Sign In')]")).isDisplayed();
		  Assert.assertTrue(data);
		  System.out.println("Enter valid name");
	  }
	  
	  @Test(enabled=true, description="Testing without password")
	  public void tc_24() {
		  driver.get("https://in.via.com/");
		  getData("testingdemo98@gmail.com","Demo","","9034873894");
		  boolean data=driver.findElement(By.xpath("//div[contains(text(),'Sign In')]")).isDisplayed();
		  Assert.assertTrue(data);
		  System.out.println("Password must be atleast 8 characters long");
	  }
	  
	  @Test(enabled=true, description="Testing without mobile")
	  public void tc_25() {
		  driver.get("https://in.via.com/");
		  getData("testingvia123@yahoo.com","Demo","testingdemo","");
		  boolean data=driver.findElement(By.xpath("//div[contains(text(),'Sign In')]")).isDisplayed();
		  Assert.assertTrue(data);
		  System.out.println("Mobile Required");
	  }
	  
	  
	}