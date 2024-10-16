package test;

import java.io.IOException;
//done
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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
import pages.HomePage;
import pages.LoginOrSignUpPage;
import utils.Utility;

public class LoginSignUpFacebook extends Browser {

	private ChromeOptions options;
	private FirefoxOptions foptions;
	private WebDriver driver;
	private LoginOrSignUpPage loginOrSignUpPage;
	private HomePage homePage;
	private String testID;

	@Parameters("browser")
	@BeforeTest
	void openBrowser(String expectedBrowser) {
//
//		if (expectedBrowser.equals("Chrome")) {
//			options = new ChromeOptions();
//			options.addArguments("--disable-notifications");
//			driver = new ChromeDriver(options);
//		} 
//		if (expectedBrowser.equals("Firefox")) {
//
//			foptions = new FirefoxOptions();
//			foptions.addPreference("dom.webnotifications.enabled", false);
//			driver = new FirefoxDriver(foptions);
//		}
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
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
//		foptions.addPreference("dom.webnotifications.enabled", false);
//		driver = new FirefoxDriver(foptions);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	}

	@BeforeClass
	void initializePOM() {

		loginOrSignUpPage = new LoginOrSignUpPage(driver);
		homePage = new HomePage(driver);
	}

	@BeforeMethod
	void openApplication() {
		driver.get("https://www.facebook.com");
	}
//
//	@Test(priority = 1)
//	void verificationOfValidlogin() throws InterruptedException {
//      testID = "T106";
//		String expectedName = "Anushri Papinwar";
//		loginOrSignUpPage.clickLoginButton(expectedName);
//		homePage.clickProfileButton();
//		String actualName = homePage.getProfileName();
//		Assert.assertEquals(actualName, expectedName);
//		homePage.clickProfileButton();
//		homePage.toLogOut();
//	}

	@Test(priority = 2,groups= {"High"})
	void validationOfCreateNewAccountButton() {
		testID = "T107";
		loginOrSignUpPage.clickCreateNewAccountButton();
		String expectedURL = "https://www.facebook.com/r.php";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL);
	}

	@AfterMethod
	void afterMethod() throws IOException {
		Utility.captureScreenshot(driver,testID);

	}
	@AfterClass
	void removePOM() {
		loginOrSignUpPage = null;
		homePage = null;
		System.gc();
	}

	@AfterTest
	void closeBrowser() {
		driver.quit();
	}
	

}
