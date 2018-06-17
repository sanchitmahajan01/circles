package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class planPage {
    WebDriver driver;
    
	By myAccount = By.xpath("//a[@href='/my_profile']/div");

	
	
	  public planPage(WebDriver driver){

	        this.driver = driver;

	    }
    
	    public void navigatToMyAccount(String url){

	    	driver.get(url);

	    }
	    
}
