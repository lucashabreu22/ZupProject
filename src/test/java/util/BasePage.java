package util;

import java.io.File;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
	
	public void takeSnapShot(String nomeDoArquivoImagem) throws Exception {

		// Convert web driver object to TakeScreenshot
		File  scrShot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		// imageFileDir = System.getProperty("java.io.tmpdir"); 
		String imageFileDir = System.getProperty("user.dir") + "/evidencias/"+nomeDoArquivoImagem+".png";
		FileUtils.copyFile(scrShot, new File(imageFileDir, nomeDoArquivoImagem));
	}
}
