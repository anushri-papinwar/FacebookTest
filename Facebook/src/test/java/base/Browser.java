package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Browser {
	public WebDriver launchChromeBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		return driver;
	}

	public WebDriver launchFirefoxBrowser() {
		FirefoxOptions foptions = new FirefoxOptions();
		foptions.addPreference("dom.webnotifications.enabled", false);
		WebDriver driver = new FirefoxDriver(foptions);
		return driver;
	}

	public WebDriver launchBrowser(String expectedBrowser) {
		WebDriver driver = null;
		if (expectedBrowser.equals("Chrome")) {
			driver = launchChromeBrowser();
		}
		if (expectedBrowser.equals("Firefox")) {

			driver = launchFirefoxBrowser();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return driver;
	}
}
