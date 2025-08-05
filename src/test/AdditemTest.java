


package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.HomePage;
import pages.ProductPage;
import utils.DriverFactory;
import org.testng.annotations.*;
public class AdditemTest {

    WebDriver driver;
    HomePage homePage;
    ProductPage productPage;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   @BeforeTest
    public void setUp() {
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
    }

    @Test(invocationCount = 5)
    public void testRandomCategoryAndProduct() throws InterruptedException {
        homePage.openSite();
        
        homePage.clickRandomMainCategory();
        homePage.clickRandomSubCategory();
        productPage.selectRandomProduct();
    }

    @AfterClass
    public void tearDown() {
     //   DriverFactory.quitDriver();
    }
}
