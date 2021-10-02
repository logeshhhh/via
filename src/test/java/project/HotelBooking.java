package project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

@SuppressWarnings("unused")
public class HotelBooking extends Base
{
	public void search(String destination) throws Exception
	{
		//driver.findElement(By.id("wzrk-cancel")).click();
		driver.findElement(By.xpath("//div[@id='Hotels']/a/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='destination']")).clear();
		driver.findElement(By.xpath("//input[@id='destination']")).sendKeys(destination);
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//ul[@id='ui-id-1']/li[2]/span")).click();
		driver.findElement(By.xpath("//input[@id='destination']")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='destination']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//div[@class='element']/div/div")).click();
		driver.findElement(By.xpath("//div[@data-month='9']/div[2]/div[2]/div[7]")).click();
		driver.findElement(By.xpath("//div[@class='element']/div[2]/div")).click();
		driver.findElement(By.xpath("//div[@data-month='9']/div[2]/div[3]/div[6]")).click();
		driver.findElement(By.xpath("//div[@class='element-room']/div/span")).click();
		driver.findElement(By.xpath("//div[@class='counter-element adult js-count via-processed']/div/div[1]")).click();
		driver.findElement(By.xpath("//div[@class='done']")).click();
		Select s1=new Select(driver.findElement(By.id("nationalityCountry")));
		s1.selectByIndex(0);
		Select s2=new Select(driver.findElement(By.id("residenceCountry")));driver.findElement(By.xpath("//label[@for='isolationCheck']")).click();
		s2.selectByIndex(0);
		
		driver.findElement(By.xpath("//div[@class='search-hotel u_vertAlignMiddle u_floatR']")).click();
		Thread.sleep(5000);
	}
	
	public void search1(String title,String fname,String lname,String pan,String mobile,String email) throws Exception
	{
		
		List<WebElement>ls= driver.findElements(By.xpath("//div[@class='selectBtn js-viewRoom via-processed']"));
		ls.get(1).click();
		Thread.sleep(2000);
		
		List<WebElement>ls1= driver.findElements(By.xpath("//div[@class='bookBtn js-bookRoom via-processed']"));
		ls1.get(0).click();
		Thread.sleep(2000);
	
		driver.findElement(By.name("Room0AdultTitle0")).sendKeys(title); 
		driver.findElement(By.name("Room0AdultFirstName0")).clear();
		driver.findElement(By.name("Room0AdultFirstName0")).sendKeys(fname); 	
		driver.findElement(By.name("Room0AdultLastName0")).clear();
     	driver.findElement(By.name("Room0AdultLastName0")).sendKeys(lname); 	
     	driver.findElement(By.name("panNumber")).clear();
		driver.findElement(By.name("panNumber")).sendKeys(pan);
		driver.findElement(By.xpath("//input[@id='contactMobile']")).clear();
		driver.findElement(By.xpath("//input[@id='contactMobile']")).sendKeys(mobile);
		driver.findElement(By.xpath("//input[@id='contactEmail']")).clear();
		driver.findElement(By.xpath("//input[@id='contactEmail']")).sendKeys(email); 
		}
	  
	public void proceed() {
		
		driver.findElement(By.xpath("//label[@id='read_terms_label']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Proceed to Booking']")).click();
	}
	
	public void proceed1() throws Exception
	{
		driver.findElement(By.xpath("//button[@id='confirmProceedPayBtn']")).click();	
	
	}
	
	
	@Test(enabled=true)
	 public void tc_57() throws Exception
	{
		driver.get("https://in.via.com/");
		driver.manage().deleteAllCookies();
		search("chennai");
		Thread.sleep(1000);
		search1("Mr","randy","orton","qwert1234y", "9876543210", "randy@gmail.com");
		Thread.sleep(1000);
		proceed();
		Thread.sleep(1000);
		proceed1();
    	boolean data=driver.findElement(By.id("ccNum-allcardsuihandler")).isDisplayed();
		Assert.assertTrue(data);
	}
	
	
	@Test(enabled=true)
	public void tc_58() throws Exception
	{
		driver.get("https://in.via.com/");
		driver.manage().deleteAllCookies();
		search("chennnnai");
		boolean data=driver.findElement(By.xpath("//*[text()='Select Destination']")).isDisplayed();
		Assert.assertTrue(data);
	}
	
	@Test(enabled=true)
	public void tc_59() throws Exception
	{
		driver.get("https://in.via.com/");
		driver.manage().deleteAllCookies();
		search("chennai");
		Thread.sleep(1000);
		search1("Title","randy","orton","qwert1234y", "9876543210", "randy@gmail.com");
		Thread.sleep(1000);
		proceed();
		boolean data=driver.findElement(By.xpath("//*[text()='Required']")).isDisplayed();
		Assert.assertTrue(data);
	}
	
	@Test(enabled=true)
	public void tc_60() throws Exception
	{
		driver.get("https://in.via.com/");
		driver.manage().deleteAllCookies();
		search("chennai");
		Thread.sleep(1000);
		search1("Mr","","orton","qwert1234y", "9876543210", "randy@gmail.com");
		Thread.sleep(1000);
		proceed();
		boolean data=driver.findElement(By.xpath("//*[text()='Alphabets & Spaces only']")).isDisplayed();
		Assert.assertTrue(data);
	}
	
	@Test(enabled=true)
	public void tc_61() throws Exception
	{
		driver.get("https://in.via.com/");
		driver.manage().deleteAllCookies();
		search("chennai");
		Thread.sleep(1000);
		search1("Mr","randy","","qwert1234y", "9876543210", "randy@gmail.com");
		Thread.sleep(1000);
		proceed();
		boolean data=driver.findElement(By.xpath("//*[text()='Alphabets & Spaces only']")).isDisplayed();
		Assert.assertTrue(data);
	}
	
	@Test(enabled=true)
	public void tc_62() throws Exception
	{
		driver.get("https://in.via.com/");
		driver.manage().deleteAllCookies();
		search("chennai");
		Thread.sleep(1000);
		search1("Mr","randy","orton","123456", "9876543210", "randy@gmail.com");
		Thread.sleep(1000);
		proceed();
		boolean data=driver.findElement(By.xpath("//*[text()='Please Enter Valid Pan Number']")).isDisplayed();
		Assert.assertTrue(data);
	}
	
	@Test(enabled=true)
	public void tc_63() throws Exception
	{
		driver.get("https://in.via.com/");
		driver.manage().deleteAllCookies();
		search("chennai");
		Thread.sleep(1000);
		search1("Mr","randy","orton","qwert1234y", "987avd3210", "randy@gmail.com");
		Thread.sleep(1000);
		proceed();
		boolean data=driver.findElement(By.xpath("//*[text()='Enter Valid Mobile & country code ( Required )']")).isDisplayed();
		Assert.assertTrue(data);
	}
	

	@Test(enabled=true)
	public void tc_64() throws Exception
	{
		driver.get("https://in.via.com/");
		driver.manage().deleteAllCookies();
		search("chennai");
		Thread.sleep(1000);
		search1("Mr","randy","orton","qwert1234y", "9876543210", "randy.com");
		Thread.sleep(1000);
		proceed();
		boolean data=driver.findElement(By.xpath("//*[text()='Enter Valid Email ( Required )']")).isDisplayed();
		Assert.assertTrue(data);
	}
	
	@Test(enabled=true)
	public void tc_65() throws Exception
	{
		driver.get("https://in.via.com/");
		driver.manage().deleteAllCookies();
		search("chennai");
		Thread.sleep(1000);
		search1("Mr","randy","orton","qwert1234y", "9876543210", "randy@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Proceed to Booking']")).click();
		boolean data=driver.findElement(By.xpath("//*[text()='Please accept booking terms']")).isDisplayed();
		Assert.assertTrue(data);
	}
	
	
	@Test(enabled=true)
	public void tc_66() throws Exception
	{
		driver.get("https://in.via.com/");
		driver.manage().deleteAllCookies();
		search("chennai");
		Thread.sleep(1000);
		search1("Mr","randy","orton","qwert1234y", "9876543210", "randy@gmail.com");
		Thread.sleep(1000);
		proceed();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Edit Details']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='Terms & Conditions']")).isEnabled());
	}
  

	
}