package com.CambriaProject.qa.Base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class Base
{
	
	WebDriver driver;
	public Properties props;
	
	public Base()
	{
        props=new Properties();
		File propFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\CambriaProject\\qa\\Config\\Config.properties");
		
		try 
		{
		FileInputStream fis =new FileInputStream(propFile);	
		props.load(fis);
		}
		catch(Throwable e) 
		{
			e.printStackTrace();
		}
		
	}

}
