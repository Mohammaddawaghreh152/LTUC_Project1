package utils;
//import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestData {
	  public WebDriver driver;
	  static Random rand = new Random();
	  public static String getRandomFirstName() {
	        String[] names = {"amira", "rogina", "dana", "mais", "dareen"};
	        return names[rand.nextInt(names.length)];
	    }

	    public static String getRandomLastName() {
	        String[] names = {"alaa", "saif", "abduallah", "hamzeh", "marwan", "abedalrahman", "omar","yazan"};
	        return names[rand.nextInt(names.length)];
	        
	    }

	    public static String getEmail(String first, String last) {
	        return first + last + rand.nextInt(7000) + "@gmail.com";
	    }
	    

	    public static String ValidPassword = "Mm12345%";
	   public static String Invalid_Email_formate = "mohammad%gmail.com";
	    public static String Mismatch_password = "Mm5889321!";
	    public static String Short_password = "Mm1";
	    public static String Valid_email = "mohammad233@gmail.com";
	    public static String email_notregistered = "mohammadwajeh1254829@gmail.com";

	    public static void SearchData(String Data , WebDriver driver) {
	    	WebElement Search = driver.findElement(By.id("search"));
			Search.sendKeys(Data);
			Search.sendKeys(Keys.ENTER);
	    	
	    }}