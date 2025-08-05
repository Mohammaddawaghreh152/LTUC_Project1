package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openSite() throws InterruptedException {
        driver.get("https://action.jo/en");
        Thread.sleep(2000);
      
    }

    public void clickRandomMainCategory() throws InterruptedException {
        List<WebElement> categories = driver.findElements(By.cssSelector("a[href*='/en/category/']"));
        if (!categories.isEmpty()) {
        	Thread.sleep(3000);
            WebElement randomCat = categories.get(new Random().nextInt(categories.size()));
         
           
            randomCat.click();
            Thread.sleep(3000); 
        }
    }

    public void clickRandomSubCategory() throws InterruptedException {
        List<WebElement> subCats = driver.findElements(By.cssSelector("a[role='menuitem']"));
        if (!subCats.isEmpty()) {
            WebElement randomSub = subCats.get(new Random().nextInt(subCats.size()));
           
            System.out.println("📁 Sub Category: " + randomSub.getText());
          
            randomSub.click();
            Thread.sleep(3000);
        }
    }
}
