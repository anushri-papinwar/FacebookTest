package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {

	@FindBy(xpath = "//input[@aria-label='First name']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@aria-label='Surname']")
	private WebElement surname;
	
	@FindBy(xpath = "//input[@aria-label='Mobile number or email address']")
	private WebElement mobNumber;
	
	@FindBy(xpath = "//input[@id='password_step_input']")
	private WebElement password;
	
	@FindBy(xpath = "//select[@aria-label='Day']")
	private WebElement selectDay;
	
	@FindBy(xpath = "//select[@aria-label='Month']")
	private WebElement selectMonth;
	
	@FindBy(xpath = "//select[@aria-label='Year']")
	private WebElement selectYear;

	@FindBy(xpath = "//label[text()='Female']")
	private WebElement female;
	

	@FindBy(xpath = "//button[@name='websubmit']")
	private WebElement submitButton;
	
	@FindBy(xpath="//a[text()='Meta Pay']")
	private WebElement metaPay;
	
	@FindBy(xpath="//p[text()='Pay']")
	private WebElement payText;
	
	@FindBy(xpath="//div[@id='pageFooterChildren']//li//a")
    private List<WebElement> allLinks;
	
	
	private WebDriver driver;
	
	public SignUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void createNewAccount() {
		firstName.sendKeys("jj");
		surname.sendKeys("lpkk");
		mobNumber.sendKeys("94210");
		password.sendKeys("Anush3");
		
		Select day = new Select(selectDay);
		day.selectByVisibleText("21");
		
		Select month = new Select(selectMonth);
		month.selectByVisibleText("Jun");
		
		Select year = new Select(selectYear);
		year.selectByVisibleText("2000");
		
		if(!female.isSelected()) {
			female.click();
		}
		
		submitButton.click();
	}
	
	public void clickFooterPageLinks() {
		for(int i=0;i<allLinks.size();i++) {
			
			allLinks.get(i).click();
		}
	}
	
	public String clickMetaPay() {
		metaPay.click();
		return driver.getCurrentUrl();
	}
}
