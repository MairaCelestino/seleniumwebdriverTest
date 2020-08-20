package suporte;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Web {
	public static final String AUTOMATE_USERNAME = "maracelestino1";
	public static final String AUTOMATE_ACCESS_KEY = "g2JY4tupWfxsWb9xLmtD";
	public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY
			+ "@hub-cloud.browserstack.com/wd/hub";

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

	public static WebDriver createBrowserStack() {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("os_version", "10");
		caps.setCapability("resolution", "1280x800");
		caps.setCapability("browser", "Chrome");
		caps.setCapability("browser_version", "60.0");
		caps.setCapability("os", "Windows");
		caps.setCapability("browserstack.debug", "true");

		WebDriver browser = null;
		try {
			browser = new RemoteWebDriver(new java.net.URL(URL), caps);
			browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			// Navegando para a página do Taskit!
			browser.get("http://www.juliodelima.com.br/taskit");
		} catch (MalformedURLException e) {
			System.out.println("Houveram problmeas com a URL: " + e.getMessage());
		}

		return browser;
	}

}
