package Tests;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import PageObjects.LoginScreen;
import PageObjects.MainScreen;
import PageObjects.MakePayment;
import Utility.*;
public class Appium1 {
	  public AndroidDriver<MobileElement> driver;
	
	@BeforeClass
	public void setUp() throws FileNotFoundException, IOException, ParseException{
		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", JSONReader.ReadJSONFile("BROWSER_NAME", "./Data/data.json"));

		capabilities.setCapability("deviceName",JSONReader.ReadJSONFile("deviceName", "./Data/data.json"));
		capabilities.setCapability("platformName",JSONReader.ReadJSONFile("platformName", "./Data/data.json"));
		capabilities.setCapability("appPackage", JSONReader.ReadJSONFile("appPackage", "./Data/data.json"));
		capabilities.setCapability("appActivity", JSONReader.ReadJSONFile("appActivity", "./Data/data.json"));
	   
	    driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	}

	@Test
	public void testCal() throws Exception {
		LoginScreen logSc = new LoginScreen(driver);
		logSc.setUserName(JSONReader.ReadJSONFile("User", "./Data/data.json"));
		logSc.setPassword(JSONReader.ReadJSONFile("User", "./Data/data.json"));
		logSc.clickLogin();
		
		MainScreen mainPage = new MainScreen(driver);
		mainPage.clickPaymentButton();
		
		MakePayment mkPayment = new MakePayment(driver);
		mkPayment.makePayment(JSONReader.ReadJSONFile("tele", "./Data/data.json"), JSONReader.ReadJSONFile("name", "./Data/data.json"), JSONReader.ReadJSONFile("User", "./Data/data.json"), "0.5");
	}

	@AfterClass
	public void teardown(){
		//close the app
		driver.quit();
	}
	}
	


