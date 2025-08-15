package test;
		
		import java.util.HashMap;
		import java.util.Map;
		import org.openqa.selenium.By;
        import org.openqa.selenium.JavascriptExecutor;
        import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.chrome.ChromeOptions;
		import org.testng.Assert;
		import org.testng.annotations.BeforeTest;
		import org.testng.annotations.Test;
 
		import pages.CreateNewAccountPage;
import utils.DriverFactory;
		import utils.TestData;
		
		public class Tests {
			
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
 
		 
			//11 Privacy and Cookie Policy
			@Test (priority=3,enabled=true)
					public void PrivacyandPolicy() throws InterruptedException {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,1900)");
				
				String conf1 ="Privacy Policy";
				String conf2 ="Luma Security";
				String conf3 ="The Information We Collect";
				driver.findElement(By.xpath("//a[normalize-space()='Privacy and Cookie Policy']")).click();
				Boolean ActualResult=driver.getPageSource().contains(conf1);
				Boolean ActualRe=driver.getPageSource().contains(conf2);
				Boolean ActualR=driver.getPageSource().contains(conf3);
				Assert.assertEquals(true, ActualResult&&ActualRe&&ActualR);
		
			}
	
			
			//14
			@Test(priority=2,enabled=false)
			public void logOut() throws InterruptedException {
				String conf="You are signed out";
				driver.findElement(By.cssSelector("div[class='panel header'] button[type='button']")).click();
				driver.findElement(By.cssSelector("div[aria-hidden='false'] li[data-label='or'] a")).click();
				Boolean ActualResult=driver.getPageSource().contains(conf);
				Assert.assertEquals(true, ActualResult);
				
			}
		
			@Test(priority=5,enabled=false)
			public void ResponsiveTest() throws InterruptedException {
				 //WebDriverManager.chromedriver().setup();
 
			        // Emulator Mobile (iPhone X)
			        Map<String, String> mobileEmulation = new HashMap<>();
			        mobileEmulation.put("deviceName", "iPhone XR");
 
			        ChromeOptions chromeOptions = new ChromeOptions();
			        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
 
			        WebDriver driver = new ChromeDriver(chromeOptions);
 
			        driver.get("https://magento.softwaretestingboard.com");
					driver.manage().window().maximize();
			        Thread.sleep(3000);
 
			        WebElement menuButton = driver.findElement(By.xpath("//a[@aria-label='store logo']//img"));
			        if (menuButton.isDisplayed()) {
			            System.out.println("She Web Site is Responsive (iPhone XR)");
			        } else {
			            System.out.println("The Web Site id Not Responsive (iPhone XR)");
			        }
 
				
			}
			
			
		}
		
		
		
		
		
		
		
		