package test;

//import java.util.Random;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.BeforeTest;


import pages.CreateNewAccountPage;
import utils.DriverFactory;
import utils.TestData;


public class CreateAccoutTest1   {
	
	
	public WebDriver driver;
	CreateNewAccountPage createNewAccountPage;
	
	public void navigateTo(String url) {
	    driver.navigate().to(url);
	}
	
	String  firstName = TestData.getRandomFirstName();
    String lastName = TestData.getRandomLastName();
    String email = TestData.getEmail(firstName, lastName);
	
    
    
	  @BeforeTest
	    public void setup() {
	        driver = DriverFactory.getDriver();
	        driver.get("https://magento.softwaretestingboard.com");
	        createNewAccountPage = new CreateNewAccountPage(driver);
	    }

	  
	  
	  
	  
	  
	  //Positive Test all valid required 
	@Test( priority = 1,enabled = false)
    public void testSubmitForm() throws InterruptedException {
		navigateTo("https://magento.softwaretestingboard.com/customer/account/create/");	 
		 createNewAccountPage.fillForm(firstName, lastName, email, TestData.ValidPassword, TestData.ValidPassword);
		 driver.findElement(createNewAccountPage.createAccountButton).click();
		 String actual_Message = driver.findElement(By.cssSelector("div.message-success.success.message")).getText();
		 Assert.assertTrue(actual_Message.contains("Thank you for registering"),
	                " Actual message: " + actual_Message);
	    }
	
	
	
	// Test invalid email.
	 @Test(priority = 2 ,enabled = false)
	    public void testInvalidEmail() throws InterruptedException {
		 navigateTo("https://magento.softwaretestingboard.com/customer/account/create/");
		 createNewAccountPage.fillForm(firstName, lastName, TestData.Invalid_Email, TestData.ValidPassword, TestData.ValidPassword);
		 driver.findElement(createNewAccountPage.createAccountButton).click();
	        String actualMessage = driver.findElement(By.cssSelector("div#email_address-error.mage-error")).getText();
	        Assert.assertTrue(actualMessage.contains("Please enter a valid email address"),
	                "Actual: " + actualMessage);
	    }
	 
	 
	 //mismatch password
	
	 @Test(priority = 3,enabled = false)
	    public void testMismatchedPasswords() throws InterruptedException {
		 navigateTo("https://magento.softwaretestingboard.com/customer/account/create/");
		 createNewAccountPage.fillForm(firstName, lastName, email, TestData.ValidPassword, TestData.Mismatch_password);
		 driver.findElement(createNewAccountPage.createAccountButton).click();
	       
	        String actualMessage = driver.findElement(By.id("password-confirmation-error")).getText();
	        Assert.assertTrue(actualMessage.contains("Please enter the same value again."),
	                " Actual: " + actualMessage);
	    }
	 
	 
	 
	 
	 
	 
	 
	// Test short password
	 @Test(priority = 4,enabled = true)
	    public void testPasswordShort () throws InterruptedException {
		 navigateTo("https://magento.softwaretestingboard.com/customer/account/create/");
		 createNewAccountPage.fillForm(firstName, lastName, email, TestData.Short_password, TestData.Short_password);
		 driver.findElement(createNewAccountPage.createAccountButton).click();

	        String actualMessage =driver.findElement(By.id("password-error")).getText();
	        Assert.assertTrue(actualMessage.contains("Minimum length of this field must be equal or greater than 8 symbols"),
	                " Actual: " + actualMessage);
	    }
	 
	 
	 
	 
	
	 
	
	
		 
      
}