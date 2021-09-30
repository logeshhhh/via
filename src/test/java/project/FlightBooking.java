package project;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@SuppressWarnings("unused")
public class FlightBooking extends Base
{
	
	
  @Test
  public void onewaytrip() throws Exception 
  {
	  driver.get("https://in.via.com/");
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.findElement(By.id("wzrk-cancel")).click();
	  
	  driver.findElement(By.id("source")).sendKeys("che");
	  
	  List<WebElement> l1= driver.findElements(By.cssSelector("span[class='name']"));
	  l1.get(0).click(); 
	  
	  driver.findElement(By.id("destination")).sendKeys("hyd");
	  
	  driver.findElement(By.xpath("//ul[@id='ui-id-2']/li[1]/span[2]")).click();
	  
	  driver.findElement(By.xpath("//div[@id='depart-cal']/div[4]/div[2]/div[3]/div[2]")).click();
	  
	  driver.findElement(By.cssSelector("[class='plus']")).click();
	  
	 // driver.findElement(By.xpath("//div[@class='counter-element child']/div/div[3]")).click();
	  
	 // driver.findElement(By.xpath("//div[@class='counter-element infant']/div/div[3]")).click();
	  
	  driver.findElement(By.cssSelector("[class='more']")).click();
	  
	  driver.findElement(By.id("prefCarrier")).clear();
	  
	  driver.findElement(By.id("prefCarrier")).sendKeys("airasia india");
	  
	  driver.findElement(By.xpath("//ul[@id='ui-id-13']/li/span[1]")).click();
	 
	  driver.findElement(By.id("preferredClass")).click();
	  
	  driver.findElement(By.cssSelector("[value='ECONOMY']")).click();
	  
	  driver.findElement(By.id("routingType")).click();
	  
	  driver.findElement(By.cssSelector("[value='DIRECT']")).click();
	 
	  driver.findElement(By.id("search-flight-btn")).click();
	  Thread.sleep(3000);
	  
	  List<WebElement>ls= driver.findElements(By.xpath("//div[@class='u_inlineblk u_width35 u_vertAlignMiddle']"));
	  ls.get(1).click();
	  Thread.sleep(3000);
	  
	  driver.findElement(By.id("adult1FirstName")).sendKeys("john");
		
      driver.findElement(By.id("adult1Surname")).sendKeys("cena");
		
	  driver.findElement(By.id("adult1DOBday")).sendKeys("04");
	  
	  driver.findElement(By.id("contactMobile")).sendKeys("9876543210");
		
		driver.findElement(By.id("contactEmail")).sendKeys("john@gmail.com");
	  
	  driver.findElement(By.xpath("//div[@class='row']/div/div/label")).click();
	  Thread.sleep(1000);
	  
	  driver.findElement(By.id("msgInfoChkBox_label")).click();
	  Thread.sleep(1000);
  }
  
 
}
