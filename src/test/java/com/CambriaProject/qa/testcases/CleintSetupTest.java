package com.CambriaProject.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.CambriaProject.qa.Base.Base;


public class CleintSetupTest extends Base {
	
	
	public CleintSetupTest()
	{
		super();
	}
	public WebDriver driver;
	@BeforeMethod
	public void StartLogging()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get(props.getProperty("url"));
		driver.findElement(By.partialLinkText("login")).click();
		
		WebElement URL=driver.findElement(By.name("Input.Email"));
		URL.sendKeys(props.getProperty("UserID"));
		WebElement Password=driver.findElement(By.name("Input.Password"));
		Password.sendKeys(props.getProperty("Password"));
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.partialLinkText("Sear")).click();
		}
	@AfterMethod 
	public void Endaction()
	{
	driver.quit();
	}
	
	
	@Test(priority=1)
	public void VerifyGeneralDisplay()
	{
		
		driver.findElement(By.cssSelector("#search_var")).sendKeys("RP00108828");
		driver.findElement(By.xpath("//body/div[@id='frame']/div[@id='main']/div[@id='container-grid']/div[@id='container']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/input[2]")).click();
	
		
		Assert.assertTrue(driver.findElement(By.linkText("RP00108828")).isDisplayed()); 
	}
	
@Test(priority=2)
public void PolicyDateDisplay()
{
	driver.findElement(By.cssSelector("#search_var")).sendKeys("RP00108828");
	driver.findElement(By.xpath("//body/div[@id='frame']/div[@id='main']/div[@id='container-grid']/div[@id='container']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/input[2]")).click();

	String GeneralDate=driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();	
	driver.findElement(By.linkText("RP00108828")).click();
	String PolicyData=driver.findElement(By.xpath("//body/div[@id='frame']/div[@id='main']/div[@id='container-grid']/div[@id='container']/div[1]/div[1]/div[3]/div[2]")).getText();
	Assert.assertEquals(GeneralDate, PolicyData);
}
@Test(priority=3)
public void PolicyClientName()
{
	driver.findElement(By.cssSelector("#search_var")).sendKeys("RP00108828");
	driver.findElement(By.xpath("//body/div[@id='frame']/div[@id='main']/div[@id='container-grid']/div[@id='container']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/input[2]")).click();

	String GeneralClientName=driver.findElement(By.xpath("//td[contains(text(),'Cambria Group - Grange - Barnet Jaguar Land Rover')]")).getText();
	String ExpectedClientName="Cambria Group Grange - Barnet Jaguar Land Rover";
	Assert.assertEquals(GeneralClientName, ExpectedClientName);
}
@Test(priority=4)
public void policyCustomer()
{
	driver.findElement(By.cssSelector("#search_var")).sendKeys("RP00108828");
	driver.findElement(By.xpath("//body/div[@id='frame']/div[@id='main']/div[@id='container-grid']/div[@id='container']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/input[2]")).click();

	String GeneralCustomerName=driver.findElement(By.xpath("//tbody/tr[1]/td[4]")).getText();
	String ExpectedCustomerName="Colin Brown";
	Assert.assertEquals(GeneralCustomerName, ExpectedCustomerName);
}

@Test(priority=5)
public void policyRegNo()
{
	driver.findElement(By.cssSelector("#search_var")).sendKeys("RP00108828");
	driver.findElement(By.xpath("//body/div[@id='frame']/div[@id='main']/div[@id='container-grid']/div[@id='container']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/input[2]")).click();

	String GeneralRegNo=driver.findElement(By.xpath("//td[contains(text(),'HJ69JWC')]")).getText();
	String ExpectedRegNo="HJ69JW4";
	Assert.assertEquals(GeneralRegNo, ExpectedRegNo);
}
@Test(priority=6)
public void policyType()
{
	driver.findElement(By.cssSelector("#search_var")).sendKeys("RP00108828");
	driver.findElement(By.xpath("//body/div[@id='frame']/div[@id='main']/div[@id='container-grid']/div[@id='container']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/input[2]")).click();

	String GeneralType=driver.findElement(By.xpath("//td[contains(text(),'Cosmetic Maintenance Plan')]")).getText();
	String ExpectedType="Cosmetic Maintenance Plan";
	Assert.assertEquals(GeneralType, ExpectedType);
}
@Test(priority=7)
public void policyStatus()
{
	driver.findElement(By.cssSelector("#search_var")).sendKeys("RP00108828");
	driver.findElement(By.xpath("//body/div[@id='frame']/div[@id='main']/div[@id='container-grid']/div[@id='container']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/input[2]")).click();

	String GeneralStatus=driver.findElement(By.xpath("//td[contains(text(),'Active')]")).getText();
	String ExpectedStatus="Active";
	Assert.assertEquals(GeneralStatus, ExpectedStatus);
}
@Test(priority=8)
public void policyClaims()
{
	driver.findElement(By.cssSelector("#search_var")).sendKeys("RP00108828");
	driver.findElement(By.xpath("//body/div[@id='frame']/div[@id='main']/div[@id='container-grid']/div[@id='container']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/input[2]")).click();

	String GeneralClaims=driver.findElement(By.xpath("//tbody/tr[1]/td[8]")).getText();
	System.out.println(GeneralClaims);
	//char ExpectedClaims="0";
	Assert.assertEquals(GeneralClaims,"0");
}
@Test(priority=9)
public void policyDetailDD()
{
	driver.findElement(By.cssSelector("#search_var")).sendKeys("RP00108828");
	driver.findElement(By.xpath("//body/div[@id='frame']/div[@id='main']/div[@id='container-grid']/div[@id='container']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/input[2]")).click();

	driver.findElement(By.xpath("//body")).click();
	String GeneralCDetails=driver.findElement(By.xpath("//span[contains(text(),'Customer')]")).getText();
	String ExpectedCDetails="Customer";
	Assert.assertEquals(GeneralCDetails, ExpectedCDetails);
	
}
@Test(priority=10)
public void ClaimButton()
{
	driver.findElement(By.cssSelector("#search_var")).sendKeys("RP00108828");
	driver.findElement(By.xpath("//body/div[@id='frame']/div[@id='main']/div[@id='container-grid']/div[@id='container']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/input[2]")).click();

	driver.findElement(By.xpath("//a[contains(text(),'RP00108828')]")).click();
	Assert.assertTrue(driver.findElement(By.linkText("View Claims")).isDisplayed()); 
	
}
//@Test(priority=11)
//public void ClaimButton()
//{
//	driver.findElement(By.xpath("//a[contains(text(),'RP00108828')]")).click();
//	Assert.assertTrue(driver.findElement(By.linkText("View Claims")).isDisplayed()); 
//	
//}
@Test(priority=11)
public void VerifySearch0()
{
	driver.findElement(By.cssSelector("#search_var")).sendKeys("0");
	driver.findElement(By.xpath("//body/div[@id='frame']/div[@id='main']/div[@id='container-grid']/div[@id='container']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/input[2]")).click();
	String TestPage=driver.findElement(By.xpath("//body/div[@id='frame']/div[@id='main']/div[@id='container-grid']/div[@id='container']/div[1]/div[1]")).getText();
	System.out.println(TestPage);
	
	//Assert.assertTrue(driver.findElement(By.linkText("RP00108828")).isDisplayed()); 
	}

}

