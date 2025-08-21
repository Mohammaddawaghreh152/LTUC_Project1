package test;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AddItemToCartPage;
import pages.CreateNewAccountPage;
import pages.Login_Page;
import utils.DriverFactory;
import utils.TestData;
//import test.Login_Test;

public class Tests {

	public WebDriver driver;
	WebDriverWait wait;
	Random rand = new Random();
	CreateNewAccountPage createNewAccountPage;
	Login_Page loginpage;

	public void navigateTo(String url) {
		driver.navigate().to(url);
	}

	String firstName = TestData.getRandomFirstName();
	String lastName = TestData.getRandomLastName();
	String email = TestData.getEmail(firstName, lastName);

	@BeforeTest
	public void setup() {
		driver = DriverFactory.getDriver();
		driver.get("https://magento.softwaretestingboard.com");
		createNewAccountPage = new CreateNewAccountPage(driver);
		loginpage = new Login_Page(driver);
	}

	// 1
	@Test(priority = 1, enabled = false)
	public void signUp() throws InterruptedException {
		// driver.findElement(By.cssSelector("header[class='page-header']
		// li:nth-child(3) a:nth-child(1)")).click();
		driver.navigate().to("https://magento.softwaretestingboard.com/customer/account/create/");
		createNewAccountPage.fillForm(firstName, lastName, email, TestData.ValidPassword, TestData.ValidPassword);
		driver.findElement(createNewAccountPage.createAccountButton).click();
		Boolean ActualResult = driver.getPageSource().contains("welcome");
		Assert.assertEquals(true, ActualResult);

	}

	// 14
	@Test(priority = 2, enabled = false)
	public void logOut() {
		String conf = "You are signed out";
		driver.findElement(By.cssSelector("div[class='panel header'] button[type='button']")).click();
		driver.findElement(By.cssSelector("div[aria-hidden='false'] li[data-label='or'] a")).click();
		Boolean ActualResult = driver.getPageSource().contains(conf);
		Assert.assertEquals(true, ActualResult);

	}

	// 11
	@Test(priority = 3, enabled = false)
	public void PrivacyandPolicy() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1900)");

		String conf1 = "Privacy Policy";
		String conf2 = "Luma Security";
		String conf3 = "The Information We Collect";
		driver.findElement(By.xpath("//a[normalize-space()='Privacy and Cookie Policy']")).click();
		Boolean ActualResult = driver.getPageSource().contains(conf1);
		Boolean ActualRe = driver.getPageSource().contains(conf2);
		Boolean ActualR = driver.getPageSource().contains(conf3);
		Assert.assertEquals(true, ActualResult && ActualRe && ActualR);

	}

	// 13
	@Test(priority = 4, enabled = false)
	public void InvalidInputsRegister() throws InterruptedException {
		String conferm = "Please enter a valid email address";
		// driver.findElement(By.cssSelector("header[class='page-header']
		// li:nth-child(3) a:nth-child(1)")).click();
		driver.navigate().to("https://magento.softwaretestingboard.com/customer/account/create/");
		createNewAccountPage.fillForm(firstName, lastName, "sljsdss56email", TestData.ValidPassword,
				TestData.ValidPassword);
		driver.findElement(createNewAccountPage.createAccountButton).click();
		Boolean ActualResult = driver.getPageSource().contains(conferm);
		Assert.assertEquals(true, ActualResult);
	}

	@Test(priority = 5, enabled = false)
	public void login() throws InterruptedException {
		navigateTo(
				"https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");
		Thread.sleep(1000);
		loginpage.fillForm(email, TestData.ValidPassword);
		driver.findElement(By.id("send2")).click();
		Thread.sleep(1500);
		String pageTitle = driver.findElement(By.cssSelector("span.logged-in")).getText();
		Assert.assertTrue(pageTitle.contains("Welcome"), " Actual: " + pageTitle);
	}

	@Test(priority = 6, enabled = false)
	public void ResponsiveTest() throws InterruptedException {
		// WebDriverManager.chromedriver().setup();

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

	@Test(priority = 7, enabled = false)
	public void TestSearch() throws InterruptedException {
		utils.TestData.SearchData("jackets forDiva Gym Tee", driver);
		WebElement ShowProductjackets = driver.findElement(By.xpath("//img[@alt='Zoltan Gym Tee']"));
		Boolean ActualResult = ShowProductjackets.isDisplayed();
		Assert.assertEquals(true, ActualResult);

	}

	@Test(priority = 8, enabled = false)
	public void TestSortBy() throws InterruptedException {
		utils.TestData.SearchData("jacket", driver);
		WebElement Dropdown = driver.findElement(By.id("sorter"));
		Select select = new Select(Dropdown);
		List<WebElement> option = select.getOptions();
		int randOption = rand.nextInt(option.size());
		String expectedValue = option.get(randOption).getText();
		select.selectByVisibleText(expectedValue);
		String ActualResult = new Select(driver.findElement(By.id("sorter"))).getFirstSelectedOption().getText();

		Assert.assertEquals(expectedValue, ActualResult, "The selected option is not the same as the one we chose !");

	}

	@Test(priority = 9, enabled = false)
	public void productDetails() throws InterruptedException {
		utils.TestData.SearchData("shirt", driver);
		AddItemToCartPage.RandomProduct(driver);

		WebElement productPrice = driver.findElement(By.cssSelector(".price"));
		Assert.assertTrue(productPrice.isDisplayed(), "The price is not show ! ");

		WebElement productName = driver.findElement(By.cssSelector(".base"));
		Assert.assertTrue(productName.isDisplayed(), "The Name is not show ! ");

		WebElement sku = driver.findElement(By.cssSelector(".product.attribute.sku"));
		Assert.assertTrue(sku.isDisplayed(), "The sku is not show");

		List<WebElement> sizes = driver.findElements(By.cssSelector(".swatch-option.text"));
		Assert.assertTrue(sizes.size() > 0, "The option of size is not found ! ");

		List<WebElement> colors = driver.findElements(By.cssSelector(".swatch-option.color"));
		Assert.assertTrue(colors.size() > 0, "The option of color is not found ! ");

	}

	@Test(priority = 10, enabled = false, invocationCount = 2)
	public void addedToCart() throws InterruptedException {
		String[] manTops = { "Jackets", "Hoodies & Sweatshirts", "Tees", "Tanks" };
		int randTop = rand.nextInt(manTops.length);
		WebElement MouseHoverButton = driver.findElement(By.linkText("Men"));
		Actions action = new Actions(driver);
		action.moveToElement(MouseHoverButton).build().perform();

		Thread.sleep(2000);
		WebElement HoverButton = driver.findElement(By.linkText("Tops"));
		action.moveToElement(HoverButton).build().perform();

		WebElement ja = driver.findElement(By.linkText(manTops[randTop]));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ja);

		AddItemToCartPage.RandomProduct(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,290)");
		AddItemToCartPage.clickaddToCart(driver);
		Thread.sleep(5000);

		if (driver.getPageSource().contains("You added")) {
			Assert.assertTrue(true);
		} else if (driver.getPageSource().contains("not available")) {
			Assert.assertTrue(true);
			System.out.println("The prouduct is not Available");
		}
		Thread.sleep(1000);

	}

	@Test(priority = 11, enabled = false)
	public void viewAndModifyCart() throws InterruptedException {

		WebElement cartIcon = driver.findElement(By.cssSelector(".minicart-wrapper"));
		cartIcon.click();
		Thread.sleep(2000);

		List<WebElement> cartItems = driver.findElements(By.cssSelector(".item.product.product-item"));
		Assert.assertTrue(cartItems.size() > 0, "The Cart Is Empty");

		WebElement viewcart = driver.findElement(By.cssSelector(".action.viewcart"));
		viewcart.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,190)");

		WebElement removeBtn = driver.findElement(By.cssSelector(".action.action-delete"));
		removeBtn.click();

		WebElement cartIconAgain = driver.findElement(By.cssSelector(".minicart-wrapper"));
		cartIconAgain.click();

		List<WebElement> updatedCartItems = driver.findElements(By.cssSelector(".item.product.product-item"));
		Assert.assertTrue(updatedCartItems.size() < cartItems.size(), "The product has not been deleted ! ");

	}

	@Test(priority=12,enabled = false)
	public void RemainProductReLogin() throws InterruptedException {
		signUp();
		addedToCart();
		addedToCart();
		addedToCart();
		WebElement cartIcon = driver.findElement(By.cssSelector(".minicart-wrapper"));
		cartIcon.click();
		Thread.sleep(2000);
		List<WebElement> cartItems = cartIcon.findElements(By.cssSelector(".item.product.product-item"));
		Assert.assertTrue(cartItems.size() > 0, "The Cart Is Empty");
		System.out.println(cartItems.size());
		logOut();
		login();
		Thread.sleep(2000);

		WebElement cartIconAgain = driver.findElement(By.cssSelector(".minicart-wrapper"));
		cartIconAgain.click();
		
		List<WebElement> updatedCartItems = cartIconAgain.findElements(By.cssSelector(".item.product.product-item"));
		Assert.assertTrue(updatedCartItems.size() == cartItems.size(), "Products have been lost !");

	}
	@Test(priority=13,enabled = true)
	public void ProceedingToCheckout() throws InterruptedException {

		addedToCart();
	    addedToCart();
		addedToCart();
		
		WebElement cartIcon = driver.findElement(By.cssSelector(".minicart-wrapper"));
		cartIcon.click();
		Thread.sleep(2000);
		List<WebElement> cartItems = cartIcon.findElements(By.cssSelector(".item.product.product-item"));
		Assert.assertTrue(cartItems.size() > 0, "The Cart Is Empty");

		WebElement buttonProceed = cartIcon.findElement(By.id("top-cart-btn-checkout"));
		buttonProceed.click();
		
		WebElement summary = driver.findElement(By.cssSelector(".block.items-in-cart"));
		summary.click();
		WebElement sss = driver.findElement(By.cssSelector(".minicart-items-wrapper.overflowed"));
		List<WebElement> numofProduct = sss.findElements(By.cssSelector(".product-item"));
		
		Assert.assertTrue(numofProduct.size()>0, "There are no products !");
		
		Boolean text1 = driver.getPageSource().contains("Order Summary");
		Boolean text2 = driver.getPageSource().contains("Shipping Address");
		Boolean text3 = driver.getPageSource().contains("Shipping Methods");
		
        Assert.assertEquals(text1, text3&text2,"There is a problem with loading ! ");		
	

	}
}
