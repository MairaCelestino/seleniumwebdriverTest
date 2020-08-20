package tests.resources;

import static org.junit.Assert.assertEquals;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import pages.LoginPage;
import suporte.Web;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuarioPageObjectsTest.csv")
public class InformacoesUsuarioPageObjectsTest {
	private WebDriver browser;

	@Before
	public void setUp() {
		//browser = Web.createChrome();
		browser = Web.createBrowserStack(); //executando na nuvem
	}

	@Test
	public void testAdicionarUmaInformacaoAdicionalDoUsuario(
			@Param(name="login") String login,
			@Param(name="senha") String senha, 
			@Param(name="tipo") String type,
			@Param(name="contato") String contact, 
			@Param(name="mensagemEsperada") String mensagemEsperada)
	{
		String textToast = new LoginPage(browser).clickSignIn()
//		 				.typeLogin("julio0001")
//						.typePassword("123456")
//						.clickSignIn();
				.fazerLogin(login,senha)
				.clickMe()
				.clickTabMoreDataAboutYou()
				.clickButtonAddMoreDataAboutYou()
				.addContact(type, contact)
				.captureTextToast();
		
		assertEquals(mensagemEsperada, textToast);
	}

	@After
	public void testDown() {
		browser.quit();
	}
}
