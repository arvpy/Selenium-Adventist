package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[@class ='nav-link']/img")
	WebElement admin;
	
	@FindBy(css="i[class= 'ace-icon fa fa-power-off']")
	WebElement logout;
	
	@FindBy(xpath = "//a[contains(@class, 'small-box-footer') and contains(@href, 'list-admin')]")
	WebElement moreInfo;
	
	@FindBy(xpath="//a[contains(@href,'list-news')and contains(@class,'small-box-footer')]")
	WebElement moreInfoManageNews;
	
	@FindBy(xpath="//a[@class='small-box-footer' and contains(@href,'category')]")
	WebElement moreInfo_Category;
	
	
	public HomePage adminClick() {
		admin.click();
		return this;
	}
	public HomePage logoutClick() {
		logout.click();
		return this;
	}
	public AdminUserPage moreInfoClick() {
		moreInfo.click();
		return new AdminUserPage(driver);
	}
	
	public ManageNewsPage moreInfoManageNewsClick() {
		moreInfoManageNews.click();
		return new ManageNewsPage(driver);
	}
	
	public ManageCategory moreInfo_CategoryClick() {
		moreInfo_Category.click();
		return new  ManageCategory(driver);
	}
	
	

}
