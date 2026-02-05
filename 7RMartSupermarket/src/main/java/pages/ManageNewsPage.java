package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	WebDriver driver;
	
	public ManageNewsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(css="a.btn.btn-rounded.btn-danger")
	WebElement NewButton;
	
	@FindBy(id="news")
	WebElement news;
	
	@FindBy(name="create")
	WebElement save;
	
	@FindBy(css="div.alert-success")
	WebElement newsAddedSuccessfully;
	
	
	public ManageNewsPage newButtonClick() {
		NewButton.click();
		return new ManageNewsPage(driver);
	}
	public ManageNewsPage enterNews(String newsenter) {
		news.sendKeys(newsenter);
		return new ManageNewsPage(driver);
	}
	public ManageNewsPage save() {
		save.click();
		return new ManageNewsPage(driver);
	}
	
	public boolean isNewsAddedSuccessfully() {
		return newsAddedSuccessfully.isDisplayed();
	}
	

}
