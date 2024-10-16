package test;

import java.io.IOException;
//done
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Browser;
import pages.LoginOrSignUpPage;
import pages.SignUpPage;
import utils.Utility;

public class CreateAccountTestClass extends Browser{

	private WebDriver driver;
	private LoginOrSignUpPage loginOrSignUpPage;
	private SignUpPage signUpPage;
	private String testID;
	
	@Parameters("browser")
	@BeforeTest
	void openBrowser(String expectedBrowser) {
        driver = launchBrowser(expectedBrowser);		
	}
	
//	@BeforeTest
//	void launchBrowser() {
////		options = new ChromeOptions();
////		options.addArguments("--disable-notifications");
////		driver = new ChromeDriver(options);
//		foptions = new FirefoxOptions();
//		foptions.addPreference("dom.webnotifications.enabled", false);
//		driver = new FirefoxDriver(foptions);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//	}

	@BeforeClass
	void initializePOM() {
        loginOrSignUpPage = new LoginOrSignUpPage(driver);
		signUpPage = new SignUpPage(driver);
	}

	@BeforeMethod
	void openApplication() {
		driver.get("https://www.facebook.com");
    	loginOrSignUpPage.clickCreateNewAccountButton();
    }

	@Test(priority = 1,groups= {"Sanity","Regression"})
	void validationcreateAccountButton() {
		testID = "T101";
		String URL1 = driver.getCurrentUrl();
		signUpPage.createNewAccount();
		String URL2 = driver.getCurrentUrl();
 	    Assert.assertEquals(URL1, URL2);
    }

	@Test(priority = 50,groups= {"High"})
	void verificationOfMetaPayLink() throws InterruptedException {
		testID = "T102";
		String expectedTitle = "Meta Pay | Meta";
		signUpPage.clickMetaPay();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(driver -> driver.getWindowHandles().size() > 1);
	    ArrayList<String> childWindow = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(childWindow.get(1));
		Thread.sleep(5000);
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	
	@AfterMethod
	void afterM() throws IOException {
		Utility.captureScreenshot(driver,testID);
	}

	@AfterClass
	void removePOM() {
        loginOrSignUpPage = null;
		signUpPage = null;
		System.gc();
	}

	@AfterTest
	void closeBrowser() {
		driver.quit();
	}

}
