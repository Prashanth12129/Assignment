package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;
import Constants.ApplicationConstants;


public class ElementUtility extends TestBase
{
	public static void waitForTheElementAndSendInput(String input, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, ApplicationConstants.EXPLICIT_WAIT);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(input);
	}

	
	
	
	public static void waitForElementAndSelect(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, ApplicationConstants.EXPLICIT_WAIT);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	
	
	public static void waitForTheElementAndVerifyISDisplayed(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, ApplicationConstants.EXPLICIT_WAIT);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	
	
	
	
	public static void scrollIntoView(WebElement element) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
