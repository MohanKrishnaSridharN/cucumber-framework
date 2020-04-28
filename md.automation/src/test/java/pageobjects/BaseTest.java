package pageobjects;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import cucumber.api.Scenario;


public class BaseTest {

	public static WebDriver driver;
	public static String browserName = "";

	@Parameters({ "browser" })
	@BeforeClass
	public static void browserName(String browser) {

		browserName = browser;
		System.out.println("****************browser=" + browser);
		System.out.println("****************browserName=" + browserName);
	}

	@SuppressWarnings("deprecation")
	public static void launchBrowser() {
		System.out.println("*************Browser=" + browserName);
		if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/Users/mohankrishna/eclipse-workspace/md.automation/src/test/resources/drivers/chromedriver");
			driver = new ChromeDriver();
			driver.get("https://dev1.menudrive.com/enterprise/login.php");
		} else if (browserName.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver",
					"/Users/mohankrishna/eclipse-workspace/md.automation/src/test/resources/drivers/geckodriver");
			// System.setProperty("webdriver.firefox.marionette","/Users/mohankrishna/eclipse-workspace/md.automation/src/test/resources/drivers/geckodriver");
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile myprofile = profile.getProfile("default");
			System.out.println("test print");

			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability(FirefoxDriver.PROFILE, myprofile);
			capabilities.setCapability("marionette", true);
			driver = new FirefoxDriver(capabilities);
			driver.get("https://dev1.menudrive.com/enterprise/login.php");
		}

	}

	public static void closeBrowser() {
		if (browserName.equals("Chrome")) {
			// driver.close();
			driver.quit();
		} else if (browserName.equals("FireFox")) {
			// driver.close();
			driver.quit();
		}
	}

	public static void captureScreenShot(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				String testName = scenario.getName();
				scenario.embed(screenshot, "image/png");
				scenario.write(testName);
			} catch (ClassCastException cce) {
				cce.printStackTrace();
			}
		}
	}

}
