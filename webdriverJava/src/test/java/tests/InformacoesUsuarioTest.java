package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import suporte.Generator;
import suporte.Screenshot;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

public class InformacoesUsuarioTest {
	private WebDriver browser;
	
	@Rule
	public TestName test = new TestName();

	@Before
	public void setUp() {
		// Open Browser
		System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");

		// Open the X page in browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-web-security");// desabilita o CORS Policy do navegador
		options.addArguments("--start-maximized"); // maximiza o navegador
		browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
		WebElement me = browser.findElement(By.className("me"));
		String textoElementoMe = me.getText();
		assertEquals("Hi, Julio", textoElementoMe);

		// Click in the link that contains the class "Me"
		browser.findElement(By.className("me")).click();

		// Click in the link that contains the text "MORE DATA ABOUT YOU"
		browser.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

	}

	// @Test
	public void testAdicionarUmaInformacaoAdicionalDoUsuario() {

		// CLick the button for your XPATH //button[@data-target='addmoredata']
		browser.findElement(By.xpath("//button[@data-target='addmoredata']")).click();

		// Identify the popup where the if addmoredata form is
		WebElement popupAddMoreData = browser.findElement(By.id("addmoredata"));

		// In combo of name "Type" choice the option "Phone"
		WebElement campoType = popupAddMoreData.findElement(By.name("type"));
		new Select(campoType).selectByVisibleText("Phone");

		// In the Name field "contact" type the number "+351961436981"
		popupAddMoreData.findElement(By.name("contact")).sendKeys("+351961436981");

		// Click in the link that contains the text "SAVE" that is the popup
		popupAddMoreData.findElement(By.linkText("SAVE")).click();

		// In the message of id "toast-container" validate that the text is "Your
		// contact has been added!"
		WebElement mensagePop = browser.findElement(By.id("toast-container"));
		String mensage = mensagePop.getText();
		assertEquals("Your contact has been added!", mensage);

	}

	@Test
	public void removerUmContatoDeUmUsuario() {

		// Login in the Application
		// Click in the Hi, Julio menu
		// Go for Ad more data
		// Click in the element for your XPATH
		// //span[text()='+351961436981']/following-sibling::a     +5511999999999 +5511999999990
		browser.findElement(By.xpath("//span[text()='+5511999999990']/following-sibling::a")).click();

		// Confirm the JavaScrip window
		browser.switchTo().alert().accept();

		// Validate that message "Rest in peace, dear phone!" was displayed
		WebElement mensagePop = browser.findElement(By.id("toast-container"));
		String mesage = mensagePop.getText();
		assertEquals("Rest in peace, dear phone!", mesage);
		
		//String screenshotArquivo = "C:/Users/mcelestino/screenshot/" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png" ;
		String screenshotArquivo = "C:/Users/mcelestino/screenshot/" + Generator.dataHoraParaArquivo() + "test1.png" ;
		Screenshot.tirar(browser, screenshotArquivo);

		// Wait up to 10 seconds for the window to disappear
		WebDriverWait wait = new WebDriverWait(browser, 10);
		wait.until(ExpectedConditions.stalenessOf(mensagePop));

		// Click in the that contains the text Logout
		browser.findElement(By.linkText("Logout")).click();
	}

	@After
	public void tearDown() {
		// Close browser
		// browser.quit();

	}
}
