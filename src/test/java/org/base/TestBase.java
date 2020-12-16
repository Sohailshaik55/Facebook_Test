package org.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.utils.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() throws Exception {

		try {

			prop = new Properties();

			FileInputStream file = new FileInputStream(
					"D:\\Eclipse\\Workspaces\\Java-1\\Facebook\\src\\test\\java\\org\\configs\\config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		catch (Exception e) {

			e.printStackTrace();
		}

	}

	@BeforeMethod
	public static void initialization() {

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"D:\\Eclipse\\Workspaces\\Java-1\\Facebook\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					"D:\\Selenium Drivers\\geckodriver-v0.28.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageLoad, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.impWait, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();

	}

}
