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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class InputFormSubmitTest {

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
	public void SimpleForm() {
		// TODO Auto-generated method stub

		driver.get("https://www.lambdatest.com/selenium-playground");
		driver.manage().window().maximize();

		WebElement dragDropSlidersLink = driver.findElement(By.linkText("Input Form Submit"));
		dragDropSlidersLink.click();

		WebElement submit = driver.findElement(By.xpath("//div[@class='text-right mt-20']/button"));
		submit.click();

		WebElement name = driver.findElement(By.xpath(
				"//div[@class='form-group w-4/12 smtablet:w-full text-section pr-20 smtablet:pr-0']/input[@type='text']"));
		String Expected_validation = name.getAttribute("validationMessage");
		String Actual_validation = "Please fill out this field.";

		Assert.assertEquals(Actual_validation, Expected_validation);

		name.sendKeys("TestName");

		WebElement email = driver.findElement(By.xpath(
				"//div[@class='form-group w-4/12 smtablet:w-full text-section pr-20 smtablet:pr-0']/input[@type='email']"));
		email.sendKeys("Test123@gmail.com");

		WebElement password = driver
				.findElement(By.xpath("//div[@class='form-group w-4/12 smtablet:w-full']/input[@type='password']"));
		password.sendKeys("Test@1234");

		WebElement company = driver.findElement(By.xpath("//*[@id=\"company\"]"));
		company.sendKeys("TestCompany");

		WebElement website = driver
				.findElement(By.xpath("//div[@class='form-group w-6/12 smtablet:w-full']/input[@id=\"websitename\"]"));
		website.sendKeys("Testdomain.com");

		WebElement country = driver.findElement(By.xpath(
				"//div[@class='form-group w-6/12 smtablet:w-full pr-20 smtablet:pr-0']/select[@name='country']"));
		Select select = new Select(country);
		select.selectByVisibleText("United States");

		WebElement city = driver
				.findElement(By.xpath("//div[@class='form-group w-6/12 smtablet:w-full']/input[@id='inputCity']"));
		city.sendKeys("TestCity");

		WebElement address1 = driver.findElement(By.xpath(
				"//div[@class='form-group w-6/12 smtablet:w-full pr-20 smtablet:pr-0']/input[@id='inputAddress1']"));
		address1.sendKeys("TestAddress1");

		WebElement address2 = driver
				.findElement(By.xpath("//div[@class='form-group w-6/12 smtablet:w-full']/input[@id='inputAddress2']"));
		address2.sendKeys("TestAddress2");

		WebElement state = driver.findElement(By.xpath(
				"//div[@class='form-group w-6/12 smtablet:w-full pr-20 smtablet:pr-0']/input[@id='inputState']"));
		state.sendKeys("TestState");

		WebElement zipcode = driver
				.findElement(By.xpath("//div[@class='form-group w-6/12 smtablet:w-full']/input[@id='inputZip']"));
		zipcode.sendKeys("360002");

		submit.click();

		WebElement successmessage = driver.findElement(
				By.xpath("//p[@class='success-msg hidden']"));
		String Actualmessage = successmessage.getText();
		String Expectedmessage = "Thanks for contacting us, we will get back to you shortly.";

		Assert.assertEquals(Actualmessage, Expectedmessage);
	}

	@AfterClass
	public void tearDown() throws Exception {
		if (driver != null) {
			((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
			driver.quit();
		}
	}


}
