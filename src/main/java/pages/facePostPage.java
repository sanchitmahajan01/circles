package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import circlepackage.App;

public class facePostPage {
	public facePostPage(WebDriver driver2) {
		this.driver = driver2;
	}

	WebDriver driver;

	By username = By.id("email");
	By password = By.id("pass");
	By submit = By.xpath("//label[@id='loginbutton']/input");

	public void navigate(String strUrl) {

		driver.get(strUrl);
	}

	public void enterPost(String strPost) {
		driver.findElement(By.xpath("//*[text()[contains(.,'Compose Post')]]/i")).click();
		WebElement post = driver.findElement(By.xpath("//div[@contenteditable='true']"));
		post.sendKeys(strPost);
		String keysPressed = Keys.chord(Keys.CONTROL, Keys.ENTER);
		post.sendKeys(keysPressed);

	}

}
