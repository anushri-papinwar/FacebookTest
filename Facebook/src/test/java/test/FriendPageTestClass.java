package test;

import java.io.IOException;
//done
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
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
import pages.FriendPage;
import pages.HomePage;
import pages.LoginOrSignUpPage;
import utils.Utility;

public class FriendPageTestClass extends Browser{

	private ChromeOptions options;
	private FirefoxOptions foptions;
	private WebDriver driver;
	private LoginOrSignUpPage loginOrSignUpPage;
	private FriendPage friendPage;
	private HomePage homePage;
	private String testID;

	@Parameters("browser")
	@BeforeTest
	void openBrowser(String expectedBrowser) {

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
//		options = new ChromeOptions();
//		options.addArguments("--disable-notifications");
//		//driver = new ChromeDriver(options);
//		foptions = new FirefoxOptions();
//		foptions.addPreference("dom.webnotifications.enabled", false);
//		driver = new FirefoxDriver(foptions);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//	}
	@BeforeClass
	void initializePOM() {

		loginOrSignUpPage = new LoginOrSignUpPage(driver);
		homePage = new HomePage(driver);
		friendPage = new FriendPage(driver);

	}

	@BeforeMethod
	void logintoApplicationAndSearchAFriend() throws  IOException {
		driver.get("https://www.facebook.com");
		loginOrSignUpPage.clickLoginButton(Utility.getDataFromExcel("Credentials",1, 0),Utility.getDataFromExcel("Credentials",1, 1));
		homePage.searchAFriend();

	}




	@Test(priority = 2,groups= {"Sanity","Regression"})
	void validationOfSendButton() throws InterruptedException {
		testID = "T103";
		String actualMSG = "H";
		String expectedMSG = friendPage.sendMessageToFriend(actualMSG);
		Assert.assertEquals(actualMSG, expectedMSG);

	}

	@Test(priority = 5,groups= {"High"})
	void validationOfFriendPageURL() {
		testID = "T104";
		String actualURL = friendPage.aboutSection();
		System.out.println(actualURL);
		String expectedURL = driver.getCurrentUrl();
		System.out.println(expectedURL);
		Assert.assertEquals(actualURL, expectedURL);
	}

	@Test(priority = 3)
	void validationOfFavourites() {
		testID = "T105";
		String expectedImage = friendPage.clickFriends();
        String actualImage = friendPage.clickFavourites();
        Assert.assertEquals(actualImage, expectedImage);
	}

	@AfterMethod
	void logoutFromApplication() throws InterruptedException, IOException {
		homePage.clickProfileButton();
		homePage.toLogOut();
		Utility.captureScreenshot(driver,testID);

	}

	@AfterClass
	void removePOM() {
		loginOrSignUpPage = null;
		homePage = null;
		friendPage = null;
		System.gc();
	}

	@AfterTest
	void closeBrowser() {
		driver.quit();
	}

//	public static void main(String[] args) throws InterruptedException {
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable-notifications");
//		WebDriver driver = new ChromeDriver(options);
//		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.get("https://www.facebook.com");
//		LoginOrSignUpPage loginOrSignUpPage = new LoginOrSignUpPage(driver);
//		loginOrSignUpPage.clickLoginButton("Anushri Papinwar");
//		HomePage homePage = new HomePage(driver);
//		homePage.searchAFriend();
//		
//		FriendPage friendPage = new FriendPage(driver);
//		String actualURL = friendPage.aboutSection();
//		System.out.println(actualURL);
//		String expectedURL = driver.getCurrentUrl();
//		System.out.println(expectedURL);
//		Assert.assertEquals(actualURL, expectedURL);
//		Thread.sleep(5000);
//    	homePage.toLogOut();
////		homePage.cutProfile();
//	}
}
