package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utilities.ElementUtility;

public class WIKI extends TestBase
{
		@FindBy(xpath = "//tbody/tr[12]/td[1]/div[1]/ul[1]/li[1]")
		WebElement releaseDate;
		
	
		@FindBy(xpath = "//td[normalize-space()='India']")
		WebElement countryOfOrigin;
		
		
		
		
		public WIKI()
		{

			PageFactory.initElements(driver, this);
		}
		
		
		public String fetchTheReleaseDateFromWiki()
		{
			ElementUtility.waitForTheElementAndVerifyISDisplayed(releaseDate);
			return this.releaseDate.getText();
		}
		
		

		
		public String fetchTheCountryOfOriginFromWiki()
		{
			ElementUtility.waitForTheElementAndVerifyISDisplayed(countryOfOrigin);
			
			return this.countryOfOrigin.getText();
		}
}
