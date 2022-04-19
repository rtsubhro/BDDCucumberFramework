package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {

	public WebDriver driver;

	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void switchtoChildWindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> windowIds = windowHandles.iterator();

		String parentWindowId = windowIds.next();

		String childWindowId = windowIds.next();

		driver.switchTo().window(childWindowId);
	}
}
