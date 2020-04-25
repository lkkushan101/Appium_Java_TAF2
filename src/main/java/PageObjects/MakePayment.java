package PageObjects;
import org.openqa.selenium.By;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MakePayment {
	AndroidDriver<MobileElement>  driver;
     By inputTel  = By.id("com.experitest.ExperiBank:id/phoneTextField");
	 By inputName = By.id("com.experitest.ExperiBank:id/nameTextField");
	 By amountTracker = By.id("com.experitest.ExperiBank:id/amount");
     By inputCountry = By.id("com.experitest.ExperiBank:id/countryTextField");
     By sendPaymentButton = By.id("com.experitest.ExperiBank:id/sendPaymentButton");
    
     public MakePayment(AndroidDriver<MobileElement>  driver){

	        this.driver = driver;

	    }

    public void setTelephon (String teleno)
    {
    	 driver.findElement(inputTel).sendKeys(teleno);
    }
    public void setName (String name)
    {
    	 driver.findElement(inputName).sendKeys(name);
    }
    public void setCountry (String country)
    {
    	 driver.findElement(inputCountry).sendKeys(country);
    }
     
    public void setTrackerValue (String trackerValue)
    {
    	 driver.findElement(amountTracker).click();
    }
    
    public void clickMakePayment ()
    {
    	 driver.findElement(sendPaymentButton).click();
    }
    
	public void makePayment (String teleNo, String name, String country, String trackerValue)
     {
    	  
     	 this.setTelephon(teleNo);
     	 this.setName(name);
     	 this.setCountry(country);
     	 this.setTrackerValue(trackerValue);
     	 this.clickMakePayment();
        	
     }

}