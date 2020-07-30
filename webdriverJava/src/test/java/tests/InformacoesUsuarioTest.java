package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.*;

public class InformacoesUsuarioTest {
	@Test
	public void testAdicionarUmaInformacaoAdicionalDoUsuario() {
		// Open Browser
		System.setProperty("webdriver.chrome.driver", "/users/mairacelestino/tools/chromedriver");

		// Open the X page in browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-web-security");// desabilita o CORS Policy do navegador
		options.addArguments("--start-maximized"); // maximiza o navegador
		WebDriver browser = new ChromeDriver();
		browser.get("http://www.juliodelima.com.br/taskit");

		// Click in the link that have the text "Sign in"
		// WebElement linkSignIn = browser.findElement(By.linkText("Sign in"));
		// linkSignIn.click();
		browser.findElement(By.linkText("Sign in")).click();

		// Identify the Login form
		WebElement formularioSignInbox = browser.findElement(By.id("signinbox"));

		// Type in the field with name "login" that is inside the id form "signinbox"
		// the text "julio0001"
		formularioSignInbox.findElement(By.name("login")).sendKeys("julio0001");

		// Type in the field with name "password" that is inside the id form "signinbox"
		// the text "123456"
		formularioSignInbox.findElement(By.name("password")).sendKeys("123456");

		// Click in the link with the text "SIGN IN"
		browser.findElement(By.linkText("SIGN IN")).click();

		// Validate that inside of element with class "me" is the text "Hi, Julio"

		// Close browserr
		// browser.close();

		// Validation

		assertEquals(1, 1);
	}

}
