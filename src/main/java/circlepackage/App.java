package circlepackage;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.circlesLoginPage;
import pages.faceBookLoginPage;
import pages.facePostPage;
import pages.myProfilePage;
import pages.planPage;

public class App {

	static WebDriver driver = init();

	static circlesLoginPage login = new circlesLoginPage(driver);
	static myProfilePage profile = new myProfilePage(driver);
	static planPage planPage = new planPage(driver);
	static faceBookLoginPage faceBookLoginPage = new faceBookLoginPage(driver);
	static facePostPage facePostPage = new facePostPage(driver);
	
	public static WebDriver init()
	{
		
		String path = System.getProperty("user.dir") + File.separator + "gecko64" + File.separator + "geckodriver.exe";

		System.setProperty("webdriver.firefox.marionette",path);
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}


	public static void main(String[] args) {
		validateEmailTextTest();

	}

	@Test
	private static void validateEmailTextTest() {

		login.navigate("https://shop.circles.life/login");
		login.setUserName("circlesqatest@gmail.com");
		login.setPassword("circlesqatest@gmail.com");
		login.clickLogin();

		planPage.navigatToMyAccount("https://shop.circles.life/my_profile");

		assertEquals(profile.getEmailText().toString(), "circlesqatest@gmail.com", "Result of Email Matching");

	}
	@Test
	private static void postOnFaceBook() {
		
		faceBookLoginPage.navigate("https://facebook.com");
		faceBookLoginPage.setUserName("circlesqatest@gmail.com");
		faceBookLoginPage.setPassword("Qwerty@321");
		faceBookLoginPage.clickLogin();
		faceBookLoginPage.navigate("https://www.facebook.com/");
		facePostPage.enterPost("somepost");
	}
	
	
	
	
}
