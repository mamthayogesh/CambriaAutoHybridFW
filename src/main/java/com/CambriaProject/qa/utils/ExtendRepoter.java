package com.CambriaProject.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendRepoter {
	
	public static ExtentReports generateExtentReport()
	{
		ExtentReports extentReport= new ExtentReports();
		File extentReportFile=new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter spark = new ExtentSparkReporter(extentReportFile);
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Cambria Test Automation Result Report");
		spark.config().setDocumentTitle("Automation Testing Report of Cambria ");
		spark.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentReport.attachReporter(spark);
		
		Properties ConfigProp=new Properties();
		File ConfigPropFile= new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\CambriaProject\\qa\\Config\\Config.properties");
		try{
			FileInputStream fisConfig=new FileInputStream(ConfigPropFile);
			ConfigProp.load(fisConfig);
			
		}catch(Throwable e){
			e.printStackTrace();
		}
		
				extentReport.setSystemInfo("Application URL",ConfigProp.getProperty("url"));
				extentReport.setSystemInfo("UserID",ConfigProp.getProperty("UserID"));
				extentReport.setSystemInfo("Password",ConfigProp.getProperty("Password"));
				return extentReport;
				
				
				
	}

}
