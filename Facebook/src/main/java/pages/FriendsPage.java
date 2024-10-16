package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FriendsPage {
	@FindBy(xpath="//span[contains(text(),'Friends')]")
	private WebElement clickFriends;
	
	
	private WebDriver driver;
	
	public FriendsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver = driver;
	}
	public String clickOnFriends() {
		clickFriends.click();
		return driver.getCurrentUrl();
	}
}
