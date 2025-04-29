package com.creatio.crm.framework.base;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.creatio.crm.framework.utilities.PropUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

// All Classes and Common methods related to browsers

public class BasePage  {
	
	// This class will have all the common methods related to Browser Confgiuratios, to initalize the TestScripts.
	
	private static WebDriver driver = null;
	public Properties prop = PropUtil.readData("Config.properties");
	
	
	
	// Method to Launch the browser based on the browser name coming from Test Runner file
	
	@Before
	public void setUpBrowser() {
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			
			driver = new ChromeDriver();
			
		} else if(browserName.equalsIgnoreCase("FireFox")) {
			
			driver = new FirefoxDriver();
			
		} else if(browserName.equalsIgnoreCase("Edge")) {
			
			driver = new EdgeDriver();
			
		} else if(browserName.equalsIgnoreCase("Safari")) {
			
			driver = new SafariDriver();
			
		} else {
			
			Assert.fail("Invalid Browser Name");
		}
		
		
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		
	}
	
	
	
	
	// Method to tear down or close the browser window.
	@After(order=0)
	public void tearDown() {
		
		//driver.close();
		
		driver.quit();
		
	}

	
	
	// One more Method is required for BDD Cucumber After Test Executions
	@After(order=1) // In After High to Low will run, 1 then 0
	public void failedTestListener(Scenario scenario) throws IOException {
		
		if(scenario.isFailed()) {
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
			byte[] fileContent = FileUtils.readFileToByteArray(file);
			scenario.attach(fileContent, "image/png", "Screenshot");		
		}
		
	}

	
	
	
	// Within the class the private driver can be used
	// To access the driver outside the classes, we need to have encapsulation used. 
	// Creating the method with public and returning the driver to get it accessibility.
	
	// Method to share browser session (driver) details with outher classes.
	public WebDriver getDriver() {
		return driver;
	}
	
	// Method to modify browser session (driver) details from all other classes.
	public void setDriver(WebDriver newDriver) {
		driver = newDriver;
	}
	
	
}
