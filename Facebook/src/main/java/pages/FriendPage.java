package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FriendPage {

	@FindBy(xpath = "//span[text()='Message']")
	private WebElement messageButton;

	@FindBy(xpath = "(//div[@aria-label='Message'])[2]")
	private WebElement enterMessageButton;

	@FindBy(xpath = "//div[@aria-label='Press Enter to send']")
	private WebElement sendButton;
	
	@FindBy(xpath="//span[text()='About']")
	private WebElement aboutSection;
	
	@FindBy(xpath="//span[@role='presentation']//span//span")
	private WebElement sentMSG;
	
	
	@FindBy(xpath="//div[@aria-label='Friends']")
	private WebElement friendsButton;
	
	@FindBy(xpath="(//div[@role='menuitem'])[1]")
	private WebElement favouritesButton;
	
	@FindBy(xpath="//div[@tabindex='0']//div[2]//div//span//div[@dir='auto']")
	private WebElement recentmsg;
	
	
	@FindBy(xpath="(//div[@role='menu']//img)[1]")
	private WebElement favouriteImage;
	
	private WebDriver driver;
	private Actions actions;
	
	public String aboutSection() {
		aboutSection.click();
		return driver.getCurrentUrl();            
    }

	public FriendPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public String sendMessageToFriend(String str) throws InterruptedException {
		messageButton.click();

		enterMessageButton.sendKeys("Hello World");
		Thread.sleep(5000);

		sendButton.click();
		return recentmsg.getText();
	}
	
	public String clickFriends() {
		friendsButton.click();
		return favouriteImage.getAttribute("src");
	
		
	}
	
	public String clickFavourites() {
		actions = new Actions(driver);
		actions.moveToElement(favouritesButton).click().build().perform();
		friendsButton.click();
		return favouriteImage.getAttribute("src");
	}
	
}
