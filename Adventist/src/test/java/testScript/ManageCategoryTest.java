package testScript;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategory;

public class ManageCategoryTest extends Base{
	HomePage home;
	ManageCategory manage;
	
	@Parameters({"uname","pwd"})
	@Test(description = "Adding new Category", retryAnalyzer = retry.Retry.class)
	public void createCategory(String username,String password) throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		
		home = loginPage.click();
		manage=home.moreInfo_CategoryClick();
		manage.newCategoryButtonClick().enterCategoryName().enterDiscount().imageUpload().submit();
		
		Assert.assertTrue(manage.isSuccessDisplayed(),Messages.CATEGORY_ADDED_FAILURE);	

	}
}
