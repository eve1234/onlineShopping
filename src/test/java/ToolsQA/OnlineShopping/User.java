package ToolsQA.OnlineShopping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class User {

	WebDriver driver ;
	
  @BeforeMethod
  public void launchBrowser() {
	 // System.getProperty("webDriver.chrome.driver",  "/Users/yvonneak/Documents/webDrivers/chromedriver.exe");
	  driver= new ChromeDriver();  
  }
  
  @Test(priority=1)
  public void lanuchApplication(){

	driver.get("http://www.gcrit.com/build3/admin");
	String pageTitle=driver.getTitle();
	Assert.assertEquals("GCR Shop", driver.getTitle());
  }
  
  @Test(priority=2)
  public void verifyElements(){
	  driver.get("http://www.gcrit.com/build3/");
	  boolean elementUserLogin=driver.findElement(By.linkText("login")).isDisplayed();
	  Assert.assertEquals(true, elementUserLogin);
	  Assert.assertEquals(true, driver.findElement(By.linkText("create an account")).isDisplayed());
  
  }
  
  @Test(priority=3)
  public void customerRegistration() throws InterruptedException{
	  driver.get("http://www.gcrit.com/build3/create_account.php");
	  driver.findElement(By.name("gender")).click();
	  driver.findElement(By.name("firstname")).sendKeys("myfirstname");
	  driver.findElement(By.name("lastname")).sendKeys("mylastname");
	  driver.findElement(By.name("dob")).sendKeys("10/10/1990");
	  driver.findElement(By.name("email_address")).sendKeys("myemailj553@gmail.com");
	  driver.findElement(By.name("street_address")).sendKeys("abc xyz");
	  driver.findElement(By.name("postcode")).sendKeys("tre 098");
	  driver.findElement(By.name("city")).sendKeys("Hyderbad");
	  driver.findElement(By.name("state")).sendKeys("Telangana");
	  Select dropdown=new Select(driver.findElement(By.name("country")));
	  dropdown.selectByVisibleText("India");
	  
	  driver.findElement(By.name("telephone")).sendKeys("0987654309");
	  
	  driver.findElement(By.name("password")).sendKeys("abcd7654");

	  driver.findElement(By.name("confirmation")).sendKeys("abcd7654");
	  
	  driver.findElement(By.id("tdb4")).click();
	  Thread.sleep(20000);
	  Assert.assertEquals("Your Account Has Been Created!", driver.findElement(By.tagName("h1")).getText());
	 
	 
  }
  @Test (priority=4)
  public void login(){
	  driver.get("http://www.gcrit.com/build3/login.php");
	  driver.findElement(By.name("email_address")).sendKeys("satyaj543@gmail.com");
	  driver.findElement(By.name("password")).sendKeys("abcd7654");
	  driver.findElement(By.id("tdb5")).click();
	  
	  Assert.assertEquals(true, driver.findElement(By.id("tdb4")).isEnabled());
  }
  
 @AfterMethod
  public void closeBrowser(){
	 driver.close();
 }
}