package tests;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	// static AppiumDriver<MobileElement> driver;
	static WebDriver driver;

	@BeforeTest
	public void setup() {

		try {

			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
			cap.setCapability(CapabilityType.VERSION, "7.1.1");
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 6");
			cap.setCapability(MobileCapabilityType.UDID, "ZY2235VZDL");
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			cap.setCapability("appPackage", "com.disha.quickride");
			cap.setCapability("appActivity", "com.disha.quickride.androidapp.startup.QRSplashActivity");
			driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			Thread.sleep(8000);
		} catch (Exception exp) {
			System.out.println("Cause is : " + exp.getCause());
			System.out.println("Message is : " + exp.getMessage());
			exp.printStackTrace();
		}

	}

	@Test
	public void quickRide_Automation() throws InterruptedException {
		Tests.quickride();
		System.out.println("Hi...Successfully Done.");
	}

	@AfterTest
	public void teardown() {
		// driver.close();
		driver.quit();

	}

}
