package testScript;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.util.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class HomePageTest extends Base {
	HomePage home;
	@Test(description = "Logging out of Home Page")
	public void loginAndLogout() throws IOException {
		
		String username=ExcelUtilities.getStringData(1, 0,"homePage");
		String password=ExcelUtilities.getStringData(1, 1,"homePage");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		
		home=loginPage.click();
		home.adminClick().logoutClick();
		String expected= Constant.EXPECTED_LOGOUT_URL;
		String actual=driver.getTitle();
		Assert.assertEquals(actual, expected,Messages.ERROR_MSG_LOGOUT);
		

	}

}
