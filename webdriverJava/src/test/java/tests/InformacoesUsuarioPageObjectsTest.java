package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.LoginPage;
import suporte.Web;

public class InformacoesUsuarioPageObjectsTest {
	private WebDriver browser;

	@Before
	public void setUp() {
		browser = Web.createChrome();
	}

	@Test
	public void testAdicionarUmaInformacaoAdicionalDoUsuario() {
		new LoginPage(browser).clickSignIn()
//		 				.typeLogin("julio0001")
//						.typePassword("123456")
//						.clickSignIn();
				.fazerLogin("julio0001", "123456");
	}

	@After
	public void testDown() {
		browser.quit();
	}
}
