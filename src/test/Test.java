	package tests;
		
		import java.util.Random;
		
		import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.edge.EdgeDriver;
		import org.testng.Assert;
		import org.testng.annotations.BeforeTest;
		import org.testng.annotations.Test;
		
		public class Tests {
			
		
			WebDriver driver = new EdgeDriver();
			String webSite = "https://magento.softwaretestingboard.com/";
			Random random = new Random();
			String[] firstName = { "yazan", "mohammad", "mahmoud", "kalel", "ahmad", "abed" };
			String fname = firstName[random.nextInt(firstName.length)];
			String[] lastName = { "yanal", "kasem", "naeem", "ibraheem", "jakop" };
			String lname = firstName[random.nextInt(lastName.length)];
			String password = "sdM.12se";
			int num=random.nextInt(84262);
			String email=fname+lname+num+"@gmail.com";
			
		
			@BeforeTest
			public void setup() {
				driver.get(webSite);
				driver.manage().window().maximize();
		
			}
		    //1
			@Test(priority=1,enabled = true)
			public void signUp() throws InterruptedException {
				//driver.findElement(By.cssSelector("header[class='page-header'] li:nth-child(3) a:nth-child(1)")).click();
				driver.navigate().to("https://magento.softwaretestingboard.com/customer/account/create/");
				driver.findElement(By.id("firstname")).sendKeys(fname);
				driver.findElement(By.id("lastname")).sendKeys(lname);
				driver.findElement(By.id("email_address")).sendKeys(email);
				driver.findElement(By.id("password")).sendKeys(password);
				driver.findElement(By.id("password-confirmation")).sendKeys(password);
				driver.findElement(By.cssSelector("button[title='Create an Account'] span")).click();
				Boolean ActualResult=driver.getPageSource().contains("welcome");
				Assert.assertEquals(true, ActualResult);
				
			}
			//11
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
			//13
			@Test(priority=4,enabled=true)
			public void InvalidInputsRegister() throws InterruptedException {
				String conferm="Please enter a valid email address";
				//driver.findElement(By.cssSelector("header[class='page-header'] li:nth-child(3) a:nth-child(1)")).click();
				driver.navigate().to("https://magento.softwaretestingboard.com/customer/account/create/");
                driver.findElement(By.id("firstname")).sendKeys(fname);
				driver.findElement(By.id("lastname")).sendKeys(lname);
				driver.findElement(By.id("email_address")).sendKeys("ernlkwsfk25");
				driver.findElement(By.id("password")).sendKeys(password);
				driver.findElement(By.id("password-confirmation")).sendKeys(password);
				driver.findElement(By.cssSelector("button[title='Create an Account'] span")).click();
			    Boolean ActualResult=driver.getPageSource().contains(conferm);
			    Assert.assertEquals(true, ActualResult);
			}
			
			//14
			@Test(priority=2,enabled=true)
			public void logOut() {
				String conf="You are signed out";
				driver.findElement(By.cssSelector("div[class='panel header'] button[type='button']")).click();
				driver.findElement(By.cssSelector("div[aria-hidden='false'] li[data-label='or'] a")).click();
				Boolean ActualResult=driver.getPageSource().contains(conf);
				Assert.assertEquals(true, ActualResult);
				
			}
		
		}
		
		
		
