package testScript;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;

public class ManageNewsPageTest extends Base{
	HomePage home;
	ManageNewsPage ManageNews;
  @Test(description = "Adding news")
  @Parameters({"uname","pwd","news"})
  public void ManageNews(String username,String password,String news) {
	  	LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username,password);
		
		home=loginPage.click();
		ManageNews=home.moreInfoManageNewsClick();
		ManageNews.newButtonClick().enterNews(news).save();
		
		boolean newsAdded=ManageNews.isNewsAddedSuccessfully();
		Assert.assertTrue(newsAdded,Messages.NEWS_ADDED_FAILURE);	
  }
}
