package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	
	@FindBy(xpath="//input[@aria-autocomplete='list']")
	private WebElement enterPersonName;
	
	@FindBy(xpath="//div[@aria-label='Your profile']")	
	//@FindBy(xpath="/html/body/div[1]/div/div[1]/div/div[2]/div[5]/div[1]/span/div/div[1]/div/svg/g/image")
	private WebElement clickProfile;
	
	@FindBy(xpath="//ul[@role='listbox']//li[1]")
	private WebElement searchPerson;
	
	 @FindBy(xpath="//a[@href='/me/']//span")
	   private WebElement profileName;
	
	@FindBy(xpath="//span[text()='Log out']")
	private WebElement logOutButton;
	
	@FindBy(xpath="//a[@role='button'][1]")
	private WebElement completeCut;
	
	private Actions actions;
	private WebDriver driver;
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver,this);
		this.driver = driver;
	}
	
	
	
	public void searchAFriend() {
		enterPersonName.sendKeys("Megha Papinwar");
		searchPerson.click();
		
	}
	public void clickProfileButton() {
		  clickProfile.click();
	}
	
	  
       public String getProfileName() {
    	   return profileName.getText().trim();

       
       }
	
	public void toLogOut() throws InterruptedException {
		  
		    
			
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			WebElement logOut = wait.until(ExpectedConditions.elementToBeClickable(logOutButton)); 
           
		    
		    
			actions = new Actions(driver);
			actions.moveToElement(logOutButton).click().build().perform();
			
	}
	
	public void cutProfile() {
	completeCut.click();
		
	}
	
	
}
