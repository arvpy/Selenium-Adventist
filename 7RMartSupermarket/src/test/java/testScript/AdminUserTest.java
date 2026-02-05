package testScript;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;
import constants.Messages;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.FakerUtility;

public class AdminUserTest extends Base {
	FakerUtility fakerUtility=new FakerUtility();
	HomePage home;
	AdminUserPage admin;
	
	@Test(description = "Adding new user to admin page")
	
	@Parameters({"uname","pwd","staff_type"})  
	public void createUser(String uname,String pwd,String stafftype) {
		
		String newname=fakerUtility.getFirstName();
		String newpwd=fakerUtility.getPassword();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(uname, pwd);
		
		home=loginPage.click();
		admin=home.moreInfoClick();
		admin.newButtonclick();
		admin.enterUserDetails(newname,newpwd).enterStaffType(stafftype).save();
		
		boolean isSuccessDisplayed=admin.isSuccessDisplayed();
		Assert.assertTrue(isSuccessDisplayed,Messages.USER_ADDED_FAILURE);	
		
	}
}
