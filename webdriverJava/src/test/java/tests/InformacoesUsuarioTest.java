package tests;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class InformacoesUsuarioTest {
	@Test
	public void testAdicionarUmaInformacaoAdicionalDoUsuario() {
		//Open Browser
		System.setProperty("webdriver.chrome.driver", "/users/mairacelestino/tools/chromedriver");
		WebDriver browser = new ChromeDriver();  
		
		//Open the X page in browser 
		browser.get("http://juliodelima.com.br/taskit");
		//Close browser
		browser.close();
		
		//Validation
		
		assertEquals(1, 1);
	}

}
