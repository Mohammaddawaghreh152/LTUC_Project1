package test;

/*

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;
import java.util.Random;
*/
public class AddItemToCartTest {
	
	
	
}
/*
    WebDriver driver;
    Actions action;
    Random rand;
    WebDriverWait wait;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com");
        action = new Actions(driver);
        rand = new Random();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testRandomNavigation() throws InterruptedException {
        List<WebElement> mainMenus = driver.findElements(By.cssSelector("ul.ui-menu > li.level0 > a"));

        WebElement randomMainMenu = mainMenus.get(rand.nextInt(mainMenus.size()));
        action.moveToElement(randomMainMenu).perform();
        Thread.sleep(1000);

        List<WebElement> subMenus = randomMainMenu.findElements(By.xpath("../ul/li/a"));

        if (!subMenus.isEmpty()) {
            WebElement randomSubMenu = subMenus.get(rand.nextInt(subMenus.size()));
            action.moveToElement(randomSubMenu).perform();
            Thread.sleep(1000);
            randomSubMenu.click();
        } else {
            randomMainMenu.click();
        }

        List<WebElement> products = driver.findElements(By.cssSelector(".product-item-link"));

        if (!products.isEmpty()) {
            WebElement randomProduct = products.get(rand.nextInt(products.size()));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", randomProduct);
            Thread.sleep(1000);

            
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", randomProduct);
        }

        Thread.sleep(3000);

        List<WebElement> sizes = driver.findElements(By.cssSelector("[id^='option-label-size-143-item-']"));
        if (!sizes.isEmpty()) {
            sizes.get(new Random().nextInt(sizes.size())).click();
        }
        List<WebElement> colors = driver.findElements(By.cssSelector("[id^='option-label-color-93-item-']"));
        if (!colors.isEmpty()) {
            colors.get(new Random().nextInt(colors.size())).click();
        }
        driver.findElement(By.id("product-addtocart-button")).click();
        Thread.sleep(3000);  
        String actual_Message = driver.findElement(By.xpath("//div[contains(@data-bind,'prepareMessageForHtml')]")).getText();
		 Assert.assertTrue(actual_Message.contains("You added"),
	                " Actual message: " + actual_Message);
    }

    @AfterTest
    public void tearDown() {
      //  if (driver != null) {
        //    driver.quit();
        }
    }

*/