package MultiBrowsers;

import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SimpleFormDemoTest {

	public static RemoteWebDriver driver = null;
	boolean status = false;

	@BeforeClass
	@Parameters("browser")
	public void setUp(String browser) throws Exception {
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions browserOptions = new ChromeOptions();
			browserOptions.setPlatformName("Windows 10");
			browserOptions.setBrowserVersion("132");
			HashMap<String, Object> ltOptions = new HashMap<String, Object>();
			ltOptions.put("username", "chandrikasunkara07");
			ltOptions.put("accessKey", "LT_iAixXKOWhEAwMnoruJJLZFqC0cj0GrMT8uvi1KrAscaYkYT");
			ltOptions.put("project", "LamdaSeleniumTest");
			ltOptions.put("selenium_version", "4.0.0");
			ltOptions.put("build", "ParallelExecutionWithChromeAndFirefoxBrowsers");
			ltOptions.put("w3c", true);
			browserOptions.setCapability("LT:Options", ltOptions);
			driver = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions);
		} else if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions browserOptions = new FirefoxOptions();
			browserOptions.setPlatformName("Windows 10");
			browserOptions.setBrowserVersion("132");
			HashMap<String, Object> ltOptions = new HashMap<String, Object>();
			ltOptions.put("username", "chandrikasunkara07");
			ltOptions.put("accessKey", "LT_iAixXKOWhEAwMnoruJJLZFqC0cj0GrMT8uvi1KrAscaYkYT");
			ltOptions.put("project", "LamdaSeleniumTest");
			ltOptions.put("selenium_version", "4.0.0");
			ltOptions.put("build", "ParallelExecutionWithChromeAndFirefoxBrowsers");
			ltOptions.put("w3c", true);
			browserOptions.setCapability("LT:Options", ltOptions);
			driver = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions);
		} else if (browser.equalsIgnoreCase("edge")) {
			EdgeOptions browserOptions = new EdgeOptions();
			browserOptions.setPlatformName("Windows 10");
			browserOptions.setBrowserVersion("132");
			HashMap<String, Object> ltOptions = new HashMap<String, Object>();
			ltOptions.put("username", "chandrikasunkara07");
			ltOptions.put("accessKey", "LT_iAixXKOWhEAwMnoruJJLZFqC0cj0GrMT8uvi1KrAscaYkYT");
			ltOptions.put("project", "LamdaSeleniumTest3");
			ltOptions.put("selenium_version", "4.0.0");
			ltOptions.put("build", "ParallelExecutionWithChromeAndFirefoxBrowsers");
			ltOptions.put("w3c", true);
			browserOptions.setCapability("LT:Options", ltOptions);
			driver = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions);
		}
	}



	@Test
	public  void inputForm() {

		driver.get("https://www.lambdatest.com/selenium-playground");
		driver.manage().window().maximize();


		//		Test 1

		WebElement simpleFormDemoLink = driver.findElement(By.linkText("Simple Form Demo"));
		simpleFormDemoLink.click();

		String currentURL = driver.getCurrentUrl();
		Assert.assertTrue(currentURL.contains("simple-form-demo"), "URL does not contain 'simple-form-demo'");
		String message = "Welcome to LambdaTest";
		WebElement messageTextbox = driver.findElement(By.xpath("//input[@id='user-message']"));
		messageTextbox.sendKeys(message);

		WebElement getCheckedValueButton = driver.findElement(By.xpath("//button[@id='showInput']"));
		getCheckedValueButton.click();

		WebElement messageDisplayed = driver.findElement(By.xpath("//div[@id='user-message']/p[@id='message']"));
		String displayedMessage = messageDisplayed.getText();
		Assert.assertEquals(displayedMessage, message, "The displayed message does not match the entered message");      

	}

	@AfterClass
	public void tearDown() throws Exception {
		if (driver != null) {
			((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
			driver.quit();
		}
	}

}
