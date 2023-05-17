package com.CambriaProject.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.CambriaProject.qa.Base.Base;

public class LoginTest extends Base {
	public WebDriver driver;
	
	public LoginTest()
	{
	 super();
	}
@BeforeMethod
public void BrowserLauching()
{
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	 long start = System.currentTimeMillis();
	driver.get(props.getProperty("url"));
	driver.findElement(By.partialLinkText("login")).click();
	 long finish = System.currentTimeMillis();
	 long totalTime = (finish - start)/1000; 
	 System.out.println("Total Time for page load - "+totalTime);
}
@AfterMethod
public void Browserclose()
{
driver.close();	
}
@Test(priority=1)
public void Login_With_Invalid_Character__Email_ID_Data()
	{
	WebElement URL=driver.findElement(By.name("Input.Email"));
	URL.sendKeys("bbggtt");
	WebElement Password=driver.findElement(By.name("Input.Password"));
	Password.sendKeys("Test@123");
	driver.findElement(By.tagName("button")).click();
	
	Assert.assertTrue(driver.findElement(By.cssSelector("#Input_Email-error")).isDisplayed()); 
	
	
	}
@Test(priority=2)
public void Login_with_Email_ID_without_domain_name_or_without_com_Extention()
	{
	WebElement URL=driver.findElement(By.name("Input.Email"));
	URL.sendKeys("mamatha@facileconsulting");
	WebElement Password=driver.findElement(By.name("Input.Password"));
	Password.sendKeys("Test@123");
	driver.findElement(By.tagName("button")).click();
	Assert.assertTrue(driver.findElement(By.xpath("//li[contains(text(),'Invalid login attempt.')]")).isDisplayed()); 
	
	}
@Test(priority=5)
public void Login_With_Valid_Email_ID()
{
	WebElement URL=driver.findElement(By.name("Input.Email"));
	URL.sendKeys("mamatha@facileconsulting.com");
	WebElement Password=driver.findElement(By.name("Input.Password"));
	Password.sendKeys("Test@123");
	driver.findElement(By.tagName("button")).click();
	
	Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Mamtha')]")).isDisplayed()); 
}
@Test(priority=4)
public void Login_without_Email_ID()
{
	WebElement URL=driver.findElement(By.name("Input.Email"));
	URL.sendKeys("");
	WebElement Password=driver.findElement(By.name("Input.Password"));
	Password.sendKeys("Test@123");
	driver.findElement(By.tagName("button")).click();
	
	Assert.assertTrue(driver.findElement(By.xpath("//li[contains(text(),'The Email field is required.')]")).isDisplayed()); 
}
@Test(priority=6)
public void Login_With_Invalid_Password_Data()
{
	WebElement URL=driver.findElement(By.name("Input.Email"));
	URL.sendKeys("mamatha@facileconsulting.com");
	WebElement Password=driver.findElement(By.name("Input.Password"));
	Password.sendKeys("bbggtt");
	driver.findElement(By.tagName("button")).click();
	
	Assert.assertTrue(driver.findElement(By.xpath("//li[contains(text(),'Invalid login attempt.')]")).isDisplayed()); 
}
@Test(priority=7)
public void Login_With_INValid_Password_Different_User()
{
	WebElement URL=driver.findElement(By.name("Input.Email"));
	URL.sendKeys("mamatha@facileconsulting.com");
	WebElement Password=driver.findElement(By.name("Input.Password"));
	Password.sendKeys("Asheesh@12345");
	driver.findElement(By.tagName("button")).click();
	
	Assert.assertTrue(driver.findElement(By.xpath("//li[contains(text(),'Invalid login attempt.')]")).isDisplayed()); 
}
@Test(priority=8)
public void Login_with_Valid_Password_Invalid_Email_ID()
{
	WebElement URL=driver.findElement(By.name("Input.Email"));
	URL.sendKeys("asheesh@facileconsulting.com");
	WebElement Password=driver.findElement(By.name("Input.Password"));
	Password.sendKeys("Test@123");
	driver.findElement(By.tagName("button")).click();
	
	Assert.assertTrue(driver.findElement(By.xpath("//li[contains(text(),'Invalid login attempt.')]")).isDisplayed()); 
}
@Test(priority=9)
public void Login_with_emptyData_Password()
{

	WebElement URL=driver.findElement(By.name("Input.Email"));
	URL.sendKeys("mamatha@facileconsulting.com");
	WebElement Password=driver.findElement(By.name("Input.Password"));
	Password.sendKeys("");
	driver.findElement(By.tagName("button")).click();
	
	Assert.assertTrue(driver.findElement(By.xpath("//body/div[@id='frame']/div[@id='main']/div[@id='container-grid']/div[@id='container']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/section[1]/form[1]/div[3]/span[1]")).isDisplayed()); 
}
@Test(priority=10)
public void LogOut_Functionality()
{
	WebElement URL=driver.findElement(By.name("Input.Email"));
	URL.sendKeys(props.getProperty("UserID"));
	WebElement Password=driver.findElement(By.name("Input.Password"));
	Password.sendKeys(props.getProperty("Password"));
	driver.findElement(By.tagName("button")).click();
	driver.findElement(By.xpath("//header/div[@id='user']/div[3]/form[1]/button[1]/i[1]")).click();
	String Lurl="https://test-warranty.cambria-local.co.uk/";
	String Aurl=driver.getCurrentUrl();
	Assert.assertEquals(Lurl, Aurl);
	
}
@Test(priority=11)
public void Seeting_button_Functionality()
{
	WebElement URL=driver.findElement(By.name("Input.Email"));
	URL.sendKeys(props.getProperty("UserID"));
	WebElement Password=driver.findElement(By.name("Input.Password"));
	Password.sendKeys(props.getProperty("Password"));
	driver.findElement(By.tagName("button")).click();
	driver.findElement(By.xpath("//header/div[@id='user']/div[3]/a[1]/i[1]")).click();
	String ESettingHomeTitle="Profile";
String ASettingHomeTitle=driver.getTitle();
	Assert.assertEquals(ASettingHomeTitle,ESettingHomeTitle);		
}
@Test(priority=12)
public void Seeting_Page_Preload_Data()
{
	WebElement URL=driver.findElement(By.name("Input.Email"));
	URL.sendKeys(props.getProperty("UserID"));
	WebElement Password=driver.findElement(By.name("Input.Password"));
	Password.sendKeys(props.getProperty("Password"));
	driver.findElement(By.tagName("button")).click();
	driver.findElement(By.xpath("//header/div[@id='user']/div[3]/a[1]/i[1]")).click();
	String EUser_ID="mamatha@facileconsulting.com";
	String AUser_ID=driver.findElement(By.xpath("//input[@id='Username']")).getText();
	Assert.assertEquals(AUser_ID, EUser_ID);
	

}
//@Test(priority=13)
//public void Seeting_Page_Postload_Data()
//{
//	WebElement URL=driver.findElement(By.name("Input.Email"));
//	URL.sendKeys(props.getProperty("UserID"));
//	WebElement Password=driver.findElement(By.name("Input.Password"));
//	Password.sendKeys(props.getProperty("Password"));
//	driver.findElement(By.tagName("button")).click();
//
//	driver.findElement(By.xpath("//header/div[@id='user']/div[3]/a[1]/i[1]")).click();
//	driver.findElement(By.xpath("//input[@id='Input_PhoneNumber']")).sendKeys("123456789");
//	String EPhon_ID="123456789";
//	String APhon_ID=driver.findElement(By.xpath("//input[@id='Input_PhoneNumber']")).getText();
//	Assert.assertEquals(EPhon_ID, APhon_ID);
//}	
}
