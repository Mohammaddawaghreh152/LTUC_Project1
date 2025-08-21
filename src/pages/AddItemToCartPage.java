package pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;





public class AddItemToCartPage {
	 public WebDriver driver;
	  static Random rand = new Random();
	  public static void SearchData(String Data , WebDriver driver) {
			WebElement Search = driver.findElement(By.id("search"));
			//Search.clear();
			//Search.click();
			Search.sendKeys(Data);
			Search.sendKeys(Keys.ENTER);}
			
	 public static void RandomProduct(WebDriver driver) throws InterruptedException {
	    	
	    	WebElement product = driver.findElement(By.cssSelector(".products.list.items.product-items"));
			List<WebElement> products = product.findElements(By.cssSelector(".product-item-link"));
			int randIndex = rand.nextInt(products.size());
			WebElement randomProduct =  products.get(randIndex);

			
			    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", randomProduct);
		
	
	    }

	    public static void clickaddToCart(WebDriver driver) throws InterruptedException { 

	        List<WebElement> sizes = driver.findElements(By.cssSelector("[id^='option-label-size-143-item-']"));
	        if (!sizes.isEmpty()) {
	            sizes.get(new Random().nextInt(sizes.size())).click();
	        }
	        List<WebElement> colors = driver.findElements(By.cssSelector("[id^='option-label-color-93-item-']"));
	        if (!colors.isEmpty()) {
	            colors.get(new Random().nextInt(colors.size())).click();
	        }
	        Thread.sleep(2000);
	        WebElement buttonclick = driver.findElement(By.id("product-addtocart-button"));
	        buttonclick.click();
	        }}
	
	
	

