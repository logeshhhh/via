package project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TravelersDetails extends Base
{
	public void flight(String from,String to,String airline) throws Exception 
	{
		
		  driver.findElement(By.id("source")).clear();
		  driver.findElement(By.id("source")).sendKeys(from);
		  
		  List<WebElement> l1= driver.findElements(By.cssSelector("span[class='name']"));
		  l1.get(0).click(); 
		  driver.findElement(By.id("destination")).clear();
		  driver.findElement(By.id("destination")).sendKeys(to);
		  
		  driver.findElement(By.xpath("//ul[@id='ui-id-2']/li[1]/span[2]")).click();
		  
		  driver.findElement(By.xpath("//div[@id='depart-cal']/div[4]/div[2]/div[3]/div[2]")).click();
		  
		  driver.findElement(By.cssSelector("[class='more']")).click();
		  
		  driver.findElement(By.id("prefCarrier")).clear();
		  
		  driver.findElement(By.id("prefCarrier")).sendKeys(airline);
		  
		  driver.findElement(By.xpath("//ul[@id='ui-id-13']/li/span[1]")).click();
		 
		  driver.findElement(By.id("preferredClass")).click();
		  
		  driver.findElement(By.cssSelector("[value='ECONOMY']")).click();
		  
		  driver.findElement(By.id("routingType")).click();
		  
		  driver.findElement(By.cssSelector("[value='DIRECT']")).click();
		 
		  driver.findElement(By.id("search-flight-btn")).click();
		  Thread.sleep(3000);
		  
		  List<WebElement>ls= driver.findElements(By.xpath("//div[@class='u_inlineblk u_width35 u_vertAlignMiddle']"));
		  ls.get(1).click();
		  Thread.sleep(2000);
		
	}
	
	public void details(String title,String fname,String lname,String date,String month,String year,String mobile,String email) throws Exception
	{
		
		driver.findElement(By.id("adult1Title")).sendKeys(title);
		driver.findElement(By.id("adult1FirstName")).clear();
		driver.findElement(By.id("adult1FirstName")).sendKeys(fname);
		
		driver.findElement(By.id("adult1Surname")).clear();
		driver.findElement(By.id("adult1Surname")).sendKeys(lname);
		
		driver.findElement(By.id("adult1DOBday")).sendKeys(date);
		
		driver.findElement(By.id("adult1DOBmonth")).sendKeys(month);
		
		driver.findElement(By.id("adult1DOByear")).sendKeys(year);
		
		driver.findElement(By.id("contactMobile")).clear();
		driver.findElement(By.id("contactMobile")).sendKeys(mobile);
		
		driver.findElement(By.id("contactEmail")).clear();
		driver.findElement(By.id("contactEmail")).sendKeys(email);
		
		driver.findElement(By.xpath("//div[@class='row']/div/div/label")).click();
		
		driver.findElement(By.id("msgInfoChkBox_label")).click();
		
		driver.findElement(By.id("makePayCTA")).click();
	}
		public void pay() throws Exception 
		{
		driver.findElement(By.id("confirmProceedPayBtn")).click();
		Thread.sleep(2000);
	}
	
  @Test(enabled=true,priority=1)
  public void tc_44() throws Exception 
  {
	  
	  driver.get("https://in.via.com/");
	  driver.findElement(By.id("wzrk-cancel")).click();
	  flight("che", "hyd", "airasia india");
	  Thread.sleep(1000);
	  details("Mr", "john","cena", "04", "may", "2000", "9876543210", "john@gmail.com");
	  pay();
	  boolean data=driver.findElement(By.id("ccNum-allcardsuihandler")).isDisplayed();
	  Assert.assertTrue(data);
	  
  }
  
  @Test(enabled=true,priority=2)
  public void tc_45() throws Exception 
  {
	  driver.get("https://in.via.com/");
	  flight("che", "hyd", "airasia india");
	  Thread.sleep(1000);
	  details("Title", "john","cena", "04", "may", "2000", "9876543210", "john@gmail.com");
	  boolean data=driver.findElement(By.xpath("//*[text()='Required']")).isDisplayed();
	  Assert.assertTrue(data);
	  
  }
  
  @Test(enabled=true,priority=3)
  public void tc_46() throws Exception 
  {
	  driver.get("https://in.via.com/");
	  flight("che", "hyd", "airasia india");
	  Thread.sleep(1000);
	  details("Mr", "","cena", "04", "may", "2000", "9876543210", "john@gmail.com");
	  boolean data=driver.findElement(By.xpath("//*[text()='Alphabets & Spaces only']")).isDisplayed();
	  Assert.assertTrue(data);
	  
  }
  
  @Test(enabled=true,priority=4)
  public void tc_47() throws Exception 
  {
	  driver.get("https://in.via.com/");
	  flight("che", "hyd", "airasia india");
	  Thread.sleep(1000);
	  details("Mr", "john","", "04", "may", "2000", "9876543210", "john@gmail.com");
	  boolean data=driver.findElement(By.xpath("//*[text()='Alphabets & Spaces only']")).isDisplayed();
	  Assert.assertTrue(data);
	  
  }
  
  @Test(enabled=true,priority=5)
  public void tc_48() throws Exception 
  {
	  driver.get("https://in.via.com/");
	  flight("che", "hyd", "airasia india");
	  Thread.sleep(1000);
	  details("Mr", "john","cena", "Day", "may", "2000", "9876543210", "john@gmail.com");
	  boolean data=driver.findElement(By.xpath("//*[text()='Required']")).isDisplayed();
	  Assert.assertTrue(data);
	  
  }
  
  @Test(enabled=true,priority=6)
  public void tc_49() throws Exception 
  {
	  driver.get("https://in.via.com/");
	  flight("che", "hyd", "airasia india");
	  Thread.sleep(1000);
	  details("Mr", "john","cena","04", "Month", "2000", "9876543210", "john@gmail.com");
	  boolean data=driver.findElement(By.xpath("//*[text()='Required']")).isDisplayed();
	  Assert.assertTrue(data);
	  
  }
  
  @Test(enabled=true,priority=7)
  public void tc_50() throws Exception 
  {
	  driver.get("https://in.via.com/");
	  flight("che", "hyd", "airasia india");
	  Thread.sleep(1000);
	  details("Mr", "john","cena","04", "may", "Year", "9876543210", "john@gmail.com");
	  boolean data=driver.findElement(By.xpath("//*[text()='Required']")).isDisplayed();
	  Assert.assertTrue(data);
	  
  }
  
  @Test(enabled=true,priority=8)
  public void tc_51() throws Exception 
  {
	  driver.get("https://in.via.com/");
	  flight("che", "hyd", "airasia india");
	  Thread.sleep(1000);
	  details("Mr", "john","cena","04", "may", "2000", "987abcd210", "john@gmail.com");
	  boolean data=driver.findElement(By.xpath("//*[text()='Enter Valid Mobile & country code ( Required )']")).isDisplayed();
	  Assert.assertTrue(data);
	  
  }
  
  @Test(enabled=true,priority=9)
  public void tc_52() throws Exception 
  {
	  driver.get("https://in.via.com/");
	  flight("che", "hyd", "airasia india");
	  Thread.sleep(1000);
	  details("Mr", "john","cena","04", "may", "2000", "", "john@gmail.com");
	  boolean data=driver.findElement(By.xpath("//*[text()='Enter Valid Mobile & country code ( Required )']")).isDisplayed();
	  Assert.assertTrue(data);
	  
  }
  
  @Test(enabled=true,priority=10)
  public void tc_53() throws Exception 
  {
	  driver.get("https://in.via.com/");
	  flight("che", "hyd", "airasia india");
	  Thread.sleep(1000);
	  details("Mr", "john","cena","04", "may", "2000", "9876543210", "john.com");
	  boolean data=driver.findElement(By.xpath("//*[text()='Enter Valid Email ( Required )']")).isDisplayed();
	  Assert.assertTrue(data);
	  
  }
  
  @Test(enabled=true,priority=11)
  public void tc_54() throws Exception 
  {
	  driver.get("https://in.via.com/");
	  flight("che", "hyd", "airasia india");
	  Thread.sleep(1000);
	  details("Mr", "john","cena","04", "may", "2000", "9876543210", "");
	  boolean data=driver.findElement(By.xpath("//*[text()='Enter Valid Email ( Required )']")).isDisplayed();
	  Assert.assertTrue(data);
	  
  }
  
 
}
