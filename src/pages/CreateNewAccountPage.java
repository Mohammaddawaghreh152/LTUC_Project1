package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;





public class CreateNewAccountPage {
    WebDriver driver;
    
    public CreateNewAccountPage(WebDriver driver){
       this.driver = driver;
   }
   
  
    //locators 
    public By firstNameField = By.name("firstname");
    public  By lastNameField = By.name("lastname");
    public  By emailField = By.name("email");
    public  By passwordField = By.name("password");
    public  By confirmPasswordField = By.name("password_confirmation");
    public  By createAccountButton = By.cssSelector("button.action.submit.primary");
    
    
    public void fillForm(String f, String l, String mail, String password, String confirmPassword) throws InterruptedException {
        driver.findElement(firstNameField).sendKeys(f);
        driver.findElement(lastNameField).sendKeys(l);
        driver.findElement(emailField).sendKeys(mail);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
    }
     
}
