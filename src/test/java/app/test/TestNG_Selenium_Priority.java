package app.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
 * Running this class as TestNG Test produces test results in \selenium-testNG-test\test-output folder
 * Running as maven test goal,produces test results in \selenium-testNG-test\target\surefire-reports folder
 */
public class TestNG_Selenium_Priority {

	WebDriver driver;

	@Test
	@BeforeTest
	public void testSetup() {
		System.out.println("TestNG_Selenium_Priority-testSetup");
		ChromeDriver chrome = new ChromeDriver();
		driver = chrome;
		Duration time = Duration.ofSeconds(5);
		driver.manage().timeouts().implicitlyWait(time);
		String url = "https://hc4w02110.itcs.hpe.com/UsherAPI/";
		driver.get(url);
	}

	@Test
	@AfterTest
	public void testClose() {
		System.out.println("TestNG_Selenium_Priority-testClose");
		driver.close();
	}

	@BeforeMethod
	public void runBeforeMethod() {
		System.out.println("TestNG_Selenium_Priority.runBeforeTestMethod()");
	}

	@AfterMethod
	public void runAfterMethod() {
		System.out.println("TestNG_Selenium_Priority.runAfterTestMethod()");
	}

	@BeforeClass
	public void setUpTestClass() {
		System.out.println("TestNG_Selenium_Priority.setUpTestClass()");
	}

	@AfterClass
	public void closeTestClass() {
		System.out.println("TestNG_Selenium_Priority.closeTestClass()");
	}

	@Test
	public void verifyHomePageTitle() {
		System.out.println("TestNG_Selenium_Priority.verifyHomePageTitle()");
		String title = driver.getTitle();
		String expected = "SSET";
		AssertJUnit.assertEquals(title, expected);

	}

	@Test
	public void verifyHomePageElement() {
		System.out.println("TestNG_Selenium_Priority.verifyHomePageElement()");
		By finder = By.tagName("h2");
		WebElement h2 = driver.findElement(finder);
		String text = h2.getText();
		AssertJUnit.assertEquals(text, "HPE SSET");

	}

	@Test
	public void checkEmployeeLoginLink() {
		String xpath = "//*[@id=\"root\"]/div/div/div/div[2]/a[1]";
		WebElement empLogin = driver.findElement(By.xpath(xpath));
		String empText = empLogin.getText();
		String expectd = "HPE Employee Login";
		AssertJUnit.assertEquals(empText, expectd);

	}

	@Test
	public void checkPartnerLoginLink() {
		System.out.println("TestNG_Selenium_Priority.checkPartnerLoginLink()");
		WebElement partnerLogin = driver.findElement(By.className("StyledButton-sc-323bzc-0"));
		List<WebElement> list = driver.findElements(By.tagName("a"));

		partnerLogin = driver.findElement(By.linkText("Partners Login"));
		partnerLogin = driver.findElement(By.partialLinkText("Partners"));

		String empText = partnerLogin.getText();
		String expectd = "Partners Login";
		AssertJUnit.assertEquals(empText, expectd);
	}

	/*
	 * Options : Run this tests related to login page in seperate test class
	 * Disable/ignore current test Change the priority of test cases that causes
	 * conflicts with other test cases add dependency between tests Define browser
	 * initilaization before each and very test case methods --That increases test
	 * execution time Navigate the browser back to home page after this test
	 * completion
	 */
	// @Test(enabled = false)
	@Test(priority = 4)
	public void verifyPartnerLoginURL() {
		System.out.println("TestNG_Selenium_Priority.verifyPartnerLoginURL()");
		WebElement partnerLogin = driver.findElement(By.className("StyledButton-sc-323bzc-0"));
		List<WebElement> list = driver.findElements(By.tagName("a"));

		partnerLogin = driver.findElement(By.linkText("Partners Login"));
		partnerLogin = driver.findElement(By.partialLinkText("Partners"));
		partnerLogin.click();
		String url = "https://cfstg.passport.hpe.com/hppcf/login.do?hpappid=209787_HPESSET_ITG_HPE";
		String newUrl = driver.getCurrentUrl();
		boolean flag = false;
		// assertEquals(flag, true);
		AssertJUnit.assertEquals(newUrl, url);
		// Restore the home page so that next test cases will run with home page
		driver.navigate().back();
		// driver.navigate().forward();
	}

	// @Test
	@Test(priority = 5)
	public void verifyPartnerLoginPageTitle() {
		System.out.println("TestNG_Selenium_Priority.verifyPartnerLoginPageTitle()");
		WebElement partnerLogin = driver.findElement(By.className("StyledButton-sc-323bzc-0"));
		List<WebElement> list = driver.findElements(By.tagName("a"));

		partnerLogin = driver.findElement(By.linkText("Partners Login"));
		partnerLogin = driver.findElement(By.partialLinkText("Partners"));
		partnerLogin.click();
		String loginTitle = driver.getTitle();

		String expected = "Sign in | HPE? Official Site";
		AssertJUnit.assertEquals(loginTitle, expected);
	}

	@Test
	public void verifyHomePageH1Element() {
		System.out.println("TestNG_Selenium_Priority.verifyHomePageH1Element()");
		String selector = "#root > div > div > div > h1.StyledHeading-sc-1rdh4aw-0.jWcWlI";
		By finder2 = By.cssSelector(selector);
		WebElement h1 = driver.findElement(finder2);
		String text = h1.getText();

		AssertJUnit.assertEquals(text, "Solution Sales Enablement Tool");

	}
}
