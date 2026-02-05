package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtilility;

public class LoginPage {
	WebDriver driver;
	WaitUtilility waitUtilility=new WaitUtilility();
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement username;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement submit;
	
	@FindBy(xpath="//p[text()='Dashboard']")
	WebElement Dashboard;
	
	public LoginPage login(String uname,String pwd) {
		
		username.sendKeys(uname);
		password.sendKeys(pwd);
		return this;
		
	}
	public HomePage click() {
		waitUtilility.waitElementToBeClicked(driver, submit);
		
		
		submit.click();
		return new HomePage(driver);
	}
	
	public boolean isDashboardDisplayed() {
		return Dashboard.isDisplayed();
	}
}
