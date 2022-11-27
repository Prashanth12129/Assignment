package Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Constants.ApplicationConstants;
import TestProperty.FetchProperties;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase 
{
	public static WebDriver driver;

	public void createBrowserInstance() throws Exception {

			// fetching the browser & url from the Properties.file 
		
		
		String Url = FetchProperties.getPropertyValueByKey("Url");
		String browser = FetchProperties.getPropertyValueByKey("Browser");


		if (browser.equalsIgnoreCase("CHROME")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(" ----- Launching the chrome browser ------ ");

		} else if (browser.equalsIgnoreCase("FIREFOX")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(" ---- Launching the fire fox browser ---- ");

		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new InternetExplorerDriver();
			System.out.println(" ---- Launching the internet explore browser ---- ");

		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(ApplicationConstants.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS
				);

		driver.manage().timeouts().implicitlyWait(ApplicationConstants.Implicit_Wait, TimeUnit.SECONDS);
		driver.get(Url);
		
		
		System.out.println(" ---- Url is lunched ---- ");
		
	

	}


	public void closeBrowser() {

		driver.quit();


	}
}
