package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;


public class AdminUserPage {
	WebDriver driver;
	PageUtilities  pageUtilities=new PageUtilities();

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(css = "a[class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(id = "username")
	WebElement username;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "user_type")
	WebElement usertype;
	@FindBy(name = "Create")
	WebElement save;
	@FindBy(css="div.alert.alert-success")
	WebElement successAlert;

	

	public AdminUserPage newButtonclick() {
		newButton.click();
		return this;
	}

	public AdminUserPage enterUserDetails(String username1,String password1) {
		username.sendKeys(username1);
		password.sendKeys(password1);
		return this;
	}

	public AdminUserPage enterStaffType(String user_Type) {
		
		pageUtilities.selectByValueDropdown(usertype,user_Type);
		return this;
		
	}

	public AdminUserPage save() {
		save.click();
		return this;
	}
	
	public boolean isSuccessDisplayed() {
		return successAlert.isDisplayed();
	}

}
