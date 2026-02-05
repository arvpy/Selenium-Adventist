package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Fileupload {

	public void sendkeysFileUpload(WebElement element, String path) {
		element.sendKeys(path);

	}

	public void robotClassFileupload(WebElement element, String path) throws InterruptedException, AWTException {
		StringSelection ss = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		Thread.sleep(2000);

		// Robot for macOS
		Robot robot = new Robot();
		robot.setAutoDelay(500);

		robot.keyPress(KeyEvent.VK_META); 
		robot.keyPress(KeyEvent.VK_SHIFT); 
		robot.keyPress(KeyEvent.VK_G); 
		robot.keyRelease(KeyEvent.VK_G);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_META);

		// ⌘ + V (Paste)
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_META);

		// Press Enter
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

}
