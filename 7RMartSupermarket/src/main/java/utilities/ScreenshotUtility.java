package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {
	public void captureFailureScreenShot(WebDriver driver, String name) throws IOException {
		
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE); 
																	
		
		String basePath = System.getProperty("user.dir") + File.separator + "OutputScreenshots";
		File f1 = new File(basePath);
		if (!f1.exists()) {
			f1.mkdirs();// 
		}
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date(0));
	
		File finalDestination = new File(
                basePath + File.separator + name + "_" + timeStamp + ".png"
        );
		FileHandler.copy(screenShot, finalDestination);

	}
}
