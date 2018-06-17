package circlepackage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class FaceBook {
	static AndroidDriver driver;
	static TouchAction actions = new TouchAction(driver);

	@BeforeClass
	public void setUp() throws Exception {

		// location of the app
		File app = new File("C:\\", "Facebook.apk");

		// To create an object of Desired Capabilities
		DesiredCapabilities capability = new DesiredCapabilities();
		// OS Name
		capability.setCapability("device", "Android");
		capability.setCapability(CapabilityType.BROWSER_NAME, "");
		capability.setCapability(CapabilityType.VERSION, "6.0.1");
		capability.setCapability("app", app.getAbsolutePath());
		capability.setCapability("deviceName", "sanchit 2");
		capability.setCapability("platformName", "Android");
		// set the package name of the app
		capability.setCapability("appPackage", "com.facebook.katana");
		// set the Launcher activity name of the app
		capability.setCapability("appActivity", "com.facebook.katana");
		capability.setCapability("appWaitActivity", "com.facebook.katana.activity.FbMainTabActivity");
		capability.setCapability("autoGrantPermissions", "true");
		// driver object with new Url and Capabilities
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void testApp() throws MalformedURLException, InterruptedException {

		System.out.println("App launched");
		Thread.sleep(5000);

		String xpathExpression = "By.className(\"android.view.ViewGroup\")";
		@SuppressWarnings("unchecked")
		List<WebElement> listofposts = driver.findElements(By.xpath(xpathExpression));
		
		for (WebElement post : listofposts)
		{
			if (post.getText().toString() == "somepost")
			{
				System.out.println("TestPassed !!");
				
			}
			else
				System.out.println("Test Failed !!");
		}
		
		
		Thread.sleep(5000);
	}
}

