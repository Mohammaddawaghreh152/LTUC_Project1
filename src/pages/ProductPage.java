
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectRandomProduct() throws InterruptedException {
        List<WebElement> products = driver.findElements(By.cssSelector("div.card-md a.content"));
        if (!products.isEmpty()) {
          
        	WebElement randomProduct = products.get(new Random().nextInt(products.size()));
        	randomProduct.click();
        	WebElement addToCartButton =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'h-11') and text()='Add to cart']")));
        	addToCartButton.click();
          
        } else {
            System.out.println("❌ No products found.");
        }
    }
}
