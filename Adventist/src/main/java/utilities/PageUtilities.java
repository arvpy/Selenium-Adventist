package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtilities {

	public void selectByValueDropdown(WebElement element, String value) {

		Select select = new Select(element);
		select.selectByValue(value);

	}

	public void selectByVisibleTextDropdown(WebElement element, String value) {

		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public void selectByIndexDropdown(WebElement element, int value) {

		Select select = new Select(element);
		select.selectByIndex(value);
	}

	public void selectByContainsVisibleTextDropdown(WebElement element, String value) {

		Select select = new Select(element);
		select.selectByContainsVisibleText(value);

	}

	public void scrollIntoView(By locator, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));

	}
	
	public void scroll(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,8000)");

	}


	public void dragAndDrop(WebElement sourceLocator, WebElement targetLocator, WebDriver driver) {

		Actions actions = new Actions(driver);
		actions.dragAndDrop(sourceLocator, targetLocator).perform();
	}



}
