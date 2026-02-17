package testScript;

import org.testng.annotations.Test;

import constants.Messages;

import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class LoginPageTest extends Base {
	HomePage home;

	@Test(description = "Logging in with correct username and correct password",groups = "smoke_test")
	@Parameters({ "uname", "pwd" })
	public void verifyUserLogin(String username, String password) {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		
		home = loginPage.click();
		
		boolean dashboardIsDisplayed = loginPage.isDashboardDisplayed();
		Assert.assertTrue(dashboardIsDisplayed, Messages.ERROR_MSG_LOGIN);
	}

	@Test(description = "Logging in with correct username and incorrect password",retryAnalyzer = retry.Retry.class)
	public void verifycorrectUserInCorrectPwd() throws IOException {
		
		String username = ExcelUtilities.getStringData(2, 0, "loginPage");
		String password = ExcelUtilities.getStringData(2, 1, "loginPage");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		
		loginPage.click();
		
		boolean dashboardIsDisplayed = loginPage.isDashboardDisplayed();
		Assert.assertTrue(dashboardIsDisplayed, Messages.ERROR_MSG_LOGIN);

	}

	@Test(description = "Logging in with incorrect username and correct password")
	public void verifyIncorrectUserCorrectPwd() throws IOException {
		
		String username = ExcelUtilities.getStringData(1, 0, "loginPage");
		String password = ExcelUtilities.getStringData(1, 1, "loginPage");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		
		loginPage.click();
		
		boolean dashboardIsDisplayed = loginPage.isDashboardDisplayed();
		Assert.assertTrue(dashboardIsDisplayed, Messages.ERROR_MSG_LOGIN);

	}

	
	@Test(description = "Logging in with all combinations of username and password",dataProvider = "credentials", groups = "smoke_test")
	public void verifyUserLoginAllCombos(String username, String password) {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		
		home = loginPage.click();
		
		boolean dashboardIsDisplayed = loginPage.isDashboardDisplayed();
		Assert.assertTrue(dashboardIsDisplayed, Messages.ERROR_MSG_LOGIN);
		
		
	}

	@DataProvider(name = "credentials")
	public Object[][] dp() {
		return new Object[][] { new Object[] { "admin", "admin" }, new Object[] { "ad", "admin" },
		new Object[] { "admin", "ad" }, new Object[] { "ad", "ad" }, };
	}
}
