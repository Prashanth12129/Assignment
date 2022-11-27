package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utilities.ElementUtility;

public class IMDBResult extends TestBase
{
		
	@FindBy(linkText = "Pushpa: The Rise - Part 1")
	WebElement movieLink;
	
	public IMDBResult()
	{

		PageFactory.initElements(driver, this);
	}
	

	public void selectSuggestion()
	{
		ElementUtility.waitForElementAndSelect(movieLink);
	}
	
}
				