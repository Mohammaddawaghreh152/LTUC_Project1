package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_Page {
	
	  WebDriver driver;
	  
	  public Login_Page(WebDriver driver) {
	        this.driver = driver;
	    }
	  //locators

	    public By emailField = By.name("login[username]");
	    public By passwordField = By.name("login[password]");
	    
	    public By singInButton = By.id("send2");
	   
	 

	    public void fillForm(String e, String p) throws InterruptedException {
	        driver.findElement(emailField).sendKeys(e);
	        driver.findElement(passwordField).sendKeys(p);
	    }



}
