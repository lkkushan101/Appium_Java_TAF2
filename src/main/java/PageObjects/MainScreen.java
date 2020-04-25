package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MainScreen {
	AndroidDriver<MobileElement>  driver;

	    By makePaymentBtn  = By.id("com.experitest.ExperiBank:id/makePaymentButton");
	    public MainScreen(AndroidDriver<MobileElement> driver ){

	        this.driver = driver;

	    }

	    public void clickPaymentButton() throws InterruptedException{
            Thread.sleep(5000);
	        driver.findElement(makePaymentBtn).click();

	    }


}