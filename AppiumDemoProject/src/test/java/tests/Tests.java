package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Tests extends BaseClass {

	public static void quickride() throws InterruptedException {

		System.out.println("Allow Media Access");
		driver.findElement(By.xpath("//*[@resource-id=\"com.android.packageinstaller:id/permission_allow_button\"]"))
				.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		System.out.println("Allow Location Access");
		driver.findElement(By.xpath("//*[@resource-id=\"com.android.packageinstaller:id/permission_allow_button\"]"))
				.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Check for Login link on Homepage and Click");
		driver.findElement(By.xpath("//*[@resource-id=\"com.disha.quickride:id/login_button\"]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Enter Mobile Number as Username");
		driver.findElement(By.xpath("//*[@resource-id=\"com.disha.quickride:id/login_phone_editText\"]"))
				.sendKeys("9038159085");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		System.out.println("Enter Password");
		driver.findElement(By.xpath("//*[@resource-id=\"com.disha.quickride:id/login_pwd_editText\"]"))
				.sendKeys("Test@123");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		System.out.println("Click on Login Button");
		driver.findElement(By.xpath("//*[@resource-id=\"com.disha.quickride:id/login_button\"]")).click();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		System.out.println("Destination Field Click");
		driver.findElement(By.xpath("//*[@resource-id=\"com.disha.quickride:id/tv_to_location\"]")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		System.out.println("Enter Destination Location");
		driver.findElement(By.xpath("//*[@resource-id=\"com.disha.quickride:id/searchForLocation\"]"))
				.sendKeys("Nandi");
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		System.out.println("Select the Destination");
		driver.findElement(By.xpath("//*[@resource-id=\"com.disha.quickride:id/selectedLocationName\"]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@resource-id=\"com.disha.quickride:id/btn_ride_create\"]")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		if (driver.findElements(By.xpath("//*[@resource-id=\"com.disha.quickride:id/inviteButton\"]")).size() > 0) {
			driver.findElement(By.xpath("//*[@resource-id=\"com.disha.quickride:id/inviteButton\"]")).click();
			System.out.println("Request has been sent.");

		} else {
			System.out.println("There is no ride at this moment.");
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@resource-id=\"com.disha.quickride:id/cancelRideButton\"]")).click();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@resource-id=\"com.disha.quickride:id/user_reason3\"]")).click();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@resource-id=\"com.disha.quickride:id/submitButton\"]")).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			String FindRide = driver
					.findElement(By.xpath("//*[@resource-id=\"com.disha.quickride:id/btn_ride_create\"]")).getText();
			if (FindRide.equalsIgnoreCase("FIND RIDE")) {
				System.out.println("No Rider Found. Ride Cancelled. ");
			}
		}
	}
}
