package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.Fileupload;
import utilities.WaitUtilility;

public class ManageCategory {
	WebDriver driver;
	WaitUtilility waitUtilility=new WaitUtilility();
	Fileupload fileupload= new Fileupload();
	

	@FindBy(css = "a.btn.btn-rounded.btn-danger")
	WebElement newCategoryButton;

	@FindBy(id = "category")
	WebElement enterCategory;
	
	@FindBy(id="134-selectable")
	WebElement enterDiscount;

	@FindBy(css = "input[type='file']")
	WebElement uploadButton;
	
	@FindBy(css="button.btn.btn-danger")
	WebElement submit;
	
	@FindBy(css="div.alert.alert-success")
	WebElement isSuccess;
	

	public ManageCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ManageCategory newCategoryButtonClick() {
		newCategoryButton.click();
		return this;
	}

	public ManageCategory enterCategoryName() {

		enterCategory.sendKeys(Constant.CATEGORY_NAME);
		return this;
	}

	public ManageCategory enterDiscount()  {
		
		enterDiscount.click();
		return this;
	}
	public ManageCategory imageUpload() {
		
		fileupload.sendkeysFileUpload(uploadButton,Constant.IMGPATH);
		return this;
	}
	

	public ManageCategory submit() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,8000)");
		
		waitUtilility.waitElementToBeClicked(driver, submit);
		submit.click();
		return this;
	}
	
	public boolean isSuccessDisplayed()  {
		return isSuccess.isDisplayed();
		
	}
	

}
