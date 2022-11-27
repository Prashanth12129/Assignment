package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utilities.ElementUtility;

public class ContentInfo extends TestBase
{
		@FindBy(xpath = "//a[normalize-space()='December 17, 2021 (India)']")
		WebElement releaseDate;
	
	
		@FindBy(xpath = "//a[normalize-space()='India']")
		WebElement countryOfOrigin;
			
			
		
		public ContentInfo()
		{

			PageFactory.initElements(driver, this);
		}
			
			
		public String fetchTheReleaseDateFromIMDB() throws InterruptedException
		{
			ElementUtility.waitForTheElementAndVerifyISDisplayed(releaseDate);
			Thread.sleep(2000);
			
	
			ElementUtility.scrollIntoView(releaseDate);
			return this.releaseDate.getText();
		}
			
	
		public String fetchOriginOfCountryFromIMDB()
		{
			ElementUtility.waitForTheElementAndVerifyISDisplayed(countryOfOrigin);
			return this.countryOfOrigin.getText();
		}
			
}
