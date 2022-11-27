package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import TestProperty.FetchProperties;
import Utilities.ElementUtility;



public class IMDB extends TestBase
{
		@FindBy(xpath = "//input[@id='suggestion-search']")
		WebElement searchInput;
		
		
		@FindBy(xpath = "//button[@id='suggestion-search-button']")
		WebElement searchBtn;
		
		public IMDB()
		{

			PageFactory.initElements(driver, this);
		}
		
	
		public IMDBResult Submit()
		{
			ElementUtility.waitForElementAndSelect(searchInput);
			this.searchBtn.click();
			return new IMDBResult();
		}
		
		public void sendInput() throws Exception
		{
			ElementUtility.waitForTheElementAndSendInput(FetchProperties.getPropertyValueByKey("MovieName")
					, searchInput);
		
		}
		
}
