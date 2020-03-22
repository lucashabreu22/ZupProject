package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
	WebDriver driver;
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public BasePage() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		this.driver = new ChromeDriver();
	}
	public void navegateTo(String url) {
		driver.navigate().to(url);
	}
	public WebDriver getDriver() {
		return driver;
	}
	public void closeNavegador() {
		getDriver().close();
	}
}
