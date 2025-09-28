package com.Ex2.base;

import org.testng.Assert;
import org.testng.Reporter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelReader;
import utilities.ExtentManager;
import utilities.Utilities;
import utilities.MonitoringMail;


public class BasePage {

	public static WebDriver driver;
	public static ZohoHomeTopMenu home_top_menu;
	public static CRMTopMenu crm_top_menu;

	private static Properties OR = new Properties();
	private static Properties config = new Properties();
	private static FileInputStream fis;
	private static Logger log = Logger.getLogger("depinoyLo");
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "//src//test//resources//com//Ex2//excel//testdata.xlsx");
	//public static MonitoringMail mail = new MonitoringMail();
	public static WebDriverWait wait;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;
	public static WebElement dropdown;
	public static MonitoringMail mail = new MonitoringMail();


	// public static WindowManager windowManager;

	public BasePage() {
		System.out.println("Hiiiiii");
		if (driver == null) {

			try {
				fis = new FileInputStream(System.getProperty("user.dir")
						+ "/src/test/resources/com/Ex2/properties/Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir")
						+ "/src/test/resources/com/Ex2/properties/OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Jenkins Browser filter configuration
			if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {

				browser = System.getenv("browser");
			} else {

				browser = config.getProperty("browser");

			}

			config.setProperty("browser", browser);

			System.out.println("If browser condition started");
			if (config.getProperty("browser").equals("chrome")) {

				WebDriverManager.chromedriver().setup();
				//driver = new ChromeDriver();
				log.debug("Chrome launched !!!!");
				
				
				System.out.println("If browser condition ended");

				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-infobars");
				System.out.println("Getting into base class");
				//WebDriverManager.chromedriver().setup();
				System.out.println("OPtions");
				options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

				// Disable the "Save password" info-bar
				options.setExperimentalOption("prefs",
						Map.of("credentials_enable_service", false, "profile.password_manager_enabled", false));
				driver = new ChromeDriver(options);

				// driver = new ChromeDriver();
				System.out.println("Opening ZOHO");

				System.out.println("Opening via config");

				
			} else if (config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app/Contents/MacOS/firefox");
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				log.debug("Firefox launched !!!!");

			} else if (config.getProperty("browser").equals("ie")) {

				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				log.debug("Internet Explorer launched !!!!");

			}
			
			driver.get(config.getProperty("testsiteurl"));
			System.out.println("ended config");

			
			log.debug("Navigated to :" + config.getProperty("testsiteuRL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 5);
			home_top_menu = new ZohoHomeTopMenu();
			crm_top_menu = new CRMTopMenu(driver);
			// windowManager = new WindowManager(driver);
			
			

		}
		
	}
	
	public static void quit() {
		driver.quit();
	}
	
	//Common Keywords
	public static void click(String locator) {

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).click();
		}
		System.out.println("This is the locator " + locator + "config: "+ OR.getProperty(locator));
		log.debug("Clicking on an Element : "+locator);
		test.log(Status.INFO, "Clicking on : " + locator);
	}

	public static void type(String locator, String value) {

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		}

		log.debug("Typing in an Element : "+locator+" entered value as : "+value);
		
		test.log(Status.INFO, "Typing in : " + locator + " entered value as " + value);

	}
	

	public void select(String locator, String value) {

		if (locator.endsWith("_CSS")) {
			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
		} else if (locator.endsWith("_XPATH")) {
			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
		} else if (locator.endsWith("_ID")) {
			dropdown = driver.findElement(By.id(OR.getProperty(locator)));
		}
		
		Select select = new Select(dropdown);
		select.selectByVisibleText(value);

		log.debug("Selecting from an element : "+locator+" value as : "+value);
		test.log(Status.INFO, "Selecting from dropdown : " + locator + " value as " + value);

	}

	public boolean isElementPresent(By by) {

		try {

			driver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {

			return false;

		}

	}

	public static void verifyEquals(String expected, String actual) throws IOException {

		try {

			Assert.assertEquals(actual, expected);

		} catch (Throwable t) {

			Utilities.captureScreenshot();
			// ReportNG
			Reporter.log("<br>" + "Verification failure : " + t.getMessage() + "<br>");
			Reporter.log("<a target=\"_blank\" href=" + Utilities.screenshotName + "><img src=" + Utilities.screenshotName
					+ " height=200 width=200></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");
			// Extent Reports
			test.log(Status.FAIL, " Verification failed with exception : " + t.getMessage());
			test.addScreenCaptureFromPath(Utilities.screenshotName);

		}
	}
}