package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import circlepackage.App;

public class circlesLoginPage {
	public circlesLoginPage(WebDriver driver2) {
		this.driver = driver2;
	}
	
	WebDriver driver ;

	By username = By.name("email");
	By password = By.name("password");
	By submit = By.xpath("//form[@class='form-signin']//button");





	public void InitiatecirclesLoginPageDriver(WebDriver maindriver) {

		System.out.println("Initilizing");
		this.driver = maindriver;

	}

	public void setUserName(String strUserName) {

		driver.findElement(username).sendKeys(strUserName);

	}

	// Set password in password textbox

	public void setPassword(String strPassword) {

		driver.findElement(password).sendKeys(strPassword);

	}

	// Click on login button

	public void clickLogin() {

		driver.findElement(submit).click();

	}

	public void navigate(String strUrl) {

		driver.get(strUrl);
	}
}
