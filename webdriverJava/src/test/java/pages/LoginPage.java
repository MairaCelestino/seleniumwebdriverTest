package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver browser;
	
	public LoginPage(WebDriver browser) {
		this.browser = browser;
	}
	
	public LoginFormPage clickSignIn() {
		browser.findElement(By.linkText("Sign in")).click();
		
		return new LoginFormPage(browser);
	}

}
