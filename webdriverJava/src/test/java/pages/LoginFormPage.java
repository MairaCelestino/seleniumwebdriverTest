package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage {
	private WebDriver browser;

	public LoginFormPage(WebDriver browser) {
		this.browser = browser;
	}

	public LoginFormPage typeLogin(String login) {
		browser.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);

		return this;
	}

	public LoginFormPage typePassword(String password) {
		browser.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);

		return this;
	}

	public SecretPage clickSignIn() {
		browser.findElement(By.linkText("SIGN IN")).click();
		
		return new SecretPage(browser);
	}
	
	public SecretPage fazerLogin(String login, String password) {
		typeLogin(login);
		typePassword(password);
		clickSignIn();
//		browser.findElement(By.id("signinbox")).findElement(By.name("Login")).sendKeys(login);
//		browser.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);
//		browser.findElement(By.linkText("SIGN IN")).click();
		
		return new SecretPage(browser);
		
	}
}
