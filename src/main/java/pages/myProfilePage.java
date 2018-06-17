package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class myProfilePage {
	WebDriver driver;

	public myProfilePage(WebDriver driver) {

		this.driver = driver;

	}

	By emailText = By.xpath("(//div[@class='col-xs-7']/input)[3]");


	public String getEmailText() {

		return driver.findElement(emailText).getAttribute("value");
	}

}
