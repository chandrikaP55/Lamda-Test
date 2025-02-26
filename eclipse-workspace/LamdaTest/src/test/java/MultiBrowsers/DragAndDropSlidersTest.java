package MultiBrowsers;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class DragAndDropSlidersTest {

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
			ltOptions.put("project", "LamdaSeleniumTest");
			ltOptions.put("selenium_version", "4.0.0");
			ltOptions.put("build", "ParallelExecutionWithChromeAndFirefoxBrowsers");
			ltOptions.put("w3c", true);
			browserOptions.setCapability("LT:Options", ltOptions);
			driver = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions);
		}
	}

	@Test

	public  void dragAndDrop() throws InterruptedException {


		driver.get("https://www.lambdatest.com/selenium-playground");
		driver.manage().window().maximize();


		WebElement dragDropSlidersLink = driver.findElement(By.linkText("Drag & Drop Sliders"));
		dragDropSlidersLink.click();

		WebElement slider3 = driver.findElement(By.xpath(".//*[@id='slider3']/div/input"));

		Actions move = new Actions(driver);
		Actions action = (Actions) move.dragAndDropBy(slider3, 212, 0);
		action.perform();

		WebElement Expected_Range = driver.findElement(By.xpath(".//*[@id='slider3']/div/output"));
		String Expe_range = Expected_Range.getText();
		String Actual_Range = "95";

		Assert.assertEquals(Actual_Range, Expe_range, "The slider value did not update to 95");


	}

	@AfterClass
	public void tearDown() throws Exception {
		if (driver != null) {
			((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
			driver.quit();
		}
	}

}
