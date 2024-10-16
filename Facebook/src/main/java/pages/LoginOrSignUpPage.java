package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginOrSignUpPage {
	   
	   @FindBy(xpath="//a[text()='Create new account']")
	   private WebElement createNewAccountButton;
	   
	   @FindBy(xpath="//input[@type='text']")
	   private WebElement username;
	   
	   @FindBy(xpath="//input[@type='password']")
	   private WebElement password;
	   
	   @FindBy(xpath="//button[text()='Log in']")
	   private WebElement logInButton;
	   
	  

       public LoginOrSignUpPage(WebDriver driver) {
    	      PageFactory.initElements(driver,this);
       }
       
       public void clickCreateNewAccountButton() {
    	   createNewAccountButton.click();
       }
       
       
       public void clickLoginButton(String name,String pwd) {
    	   username.sendKeys(name);
    	   password.sendKeys(pwd);
    	   logInButton.click();
       }   
}
