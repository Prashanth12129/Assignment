package Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.TestBase;
import Pages.ContentInfo;
import Pages.IMDB;
import Pages.IMDBResult;
import Pages.WIKI;
import TestProperty.FetchProperties;


public class TestValidation extends TestBase
{
	ContentInfo movie;
	IMDBResult imdbResult ;
	IMDB landingScreen ;	
	WIKI wiki ;

	SoftAssert soft= new SoftAssert();

	@BeforeMethod
	public void setUp() throws Exception
	{
		TestBase test = new TestBase();
		test.createBrowserInstance();

		landingScreen = new IMDB();
		landingScreen.sendInput();

		imdbResult = landingScreen.Submit();
		imdbResult.selectSuggestion();
	}


	@Test(priority = 1, description = "Verifying the Release date Info & the country of origin")
	public void verifyReleaseDateAndOriginOfCountry() throws Exception
	{

		movie = new ContentInfo();
		
		String imdbReleaseDate = movie.fetchTheReleaseDateFromIMDB();
		String imdbOriginOfCountry = movie.fetchOriginOfCountryFromIMDB(); 

		System.out.println(" --- Imdb Puspha film release date Info - " + imdbReleaseDate + " ---- ");
		System.out.println(" ---- Imdb Puspha film Orign Of Country -  " + imdbOriginOfCountry + " ---- ");
	
		driver.navigate().to(FetchProperties.getPropertyValueByKey("WikiUrl"));	


		wiki = new WIKI();
	
		String wikiPuspaReleaseDate = wiki.fetchTheReleaseDateFromWiki();
		String originOfFromWiki = wiki.fetchTheCountryOfOriginFromWiki();

		System.out.println(" --- Wiki Puspha film release date Info - " + wikiPuspaReleaseDate + " ---- ");
		System.out.println(" ---- Wiki Puspha film Orign Of Country -  " + originOfFromWiki + " ---- ");

		soft.assertEquals(imdbReleaseDate, wikiPuspaReleaseDate,"Release date is not matching in wiki & imdb"); 

		soft.assertEquals(imdbOriginOfCountry, originOfFromWiki,"Origin of country is not matching"); 
		soft.assertAll();
	}


		
	@AfterMethod 
	public void exitBrowser()
	{

		driver.quit();
	}
}			
