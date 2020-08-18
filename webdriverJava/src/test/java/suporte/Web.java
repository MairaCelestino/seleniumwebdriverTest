package suporte;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Web {
	public static WebDriver createChrome() {
		// Open Browser
		System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver",
		// "/users/mairacelestino/tools/chromedriver");

		// Open the X page in browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-web-security");// desabilita o CORS Policy do navegador
		options.addArguments("--start-maximized"); // maximiza o navegador
		WebDriver browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		browser.get("http://www.juliodelima.com.br/taskit");

		return browser;
	}

}
