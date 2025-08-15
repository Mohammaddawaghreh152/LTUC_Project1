package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Login_Page;
import utils.DriverFactory;
import utils.TestData;

public class Login_Test {
	
	public WebDriver driver;
	Login_Page loginpage;
	
	public void navigateTo(String url) {
	    driver.navigate().to(url);
	}
	
	
	
	 @BeforeTest
	    public void setup() {
	        driver = DriverFactory.getDriver();
	       driver.get("https://magento.softwaretestingboard.com");
	        loginpage = new Login_Page(driver);
	        
	    }
	
	//Positive Test with valid input data
	 @Test(priority = 1,enabled = true)
	    public void Test_login_account () throws InterruptedException {
		 navigateTo("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");
	    Thread.sleep(1000);
		 loginpage.fillForm(TestData.Valid_email , TestData.ValidPassword);
	        driver.findElement(By.id("send2")).click();
	        Thread.sleep(1500);
	        String pageTitle = driver.findElement(By.cssSelector("span.logged-in")).getText();
	        Assert.assertTrue(pageTitle.contains("Welcome"),
	                " Actual: " + pageTitle);
	    }

	 
	 
	 //Negative Test – Verifies that email_notregistered
	 @Test(priority = 2,enabled = true)
	    public void test_email_notregistered () throws InterruptedException {
		 navigateTo("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");
		    Thread.sleep(1000);
		    loginpage.fillForm(TestData.email_notregistered , TestData.ValidPassword);
	        driver.findElement(By.id("send2")).click();
	        Thread.sleep(1500);
	            String actualMessage = driver.findElement(By.xpath("//div[@data-ui-id='message-error']")).getText();
	            Assert.assertTrue(actualMessage.contains("The account sign-in was incorrect or your account is disabled temporarily"),
	                    "Actual: " + actualMessage);
	        }
	  @AfterMethod
		 public void log_out() throws InterruptedException {
		  try {
			
		 driver.findElement(By.xpath("//button[@class='action switch']")).click();
		Thread.sleep(1000);
		 driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")).click();
		  } 
		  
			  catch (Exception e) {
			        System.out.println("not login ");
			 }
		 
		  }
	 }


