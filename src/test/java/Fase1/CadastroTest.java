package Fase1;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CadastroTest {
    private static WebDriver driver;

    private String urlLogado = "https://atlantis.isti.cnr.it:5000/course";

    @BeforeClass
    public static void configura() {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://atlantis.isti.cnr.it:5000/");
        driver.findElement(By.id("signUpButton")).click();

    }

    @Test
    public void testCadastro() {
        Cadastro pag = PageFactory.initElements(driver, Cadastro.class);
        pag.preencheDados("studentufjf@gmail.com","Student Ufjf", "123456Ab", "123456Ab");

        driver.findElement(By.xpath("/html/body/app/div/main/app-presentation/login-modal/div/div[1]/div/form/div[5]/div/re-captcha/div/div/div")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("sign-up-btn")).click();
        boolean logado = new WebDriverWait(driver, 10).until(ExpectedConditions.urlMatches(urlLogado));

        assertTrue(logado);
    }

    @Test
    public void testCadastroInvalidoEmail() {
        Cadastro pag = PageFactory.initElements(driver, Cadastro.class);
        pag.preencheDados("studentufjf@gmail.com","Student Ufjf", "123456", "123456");

        driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div/div/span/div[5]")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("disabled-signup-btn")).click();
        boolean logado = new WebDriverWait(driver, 10).until(ExpectedConditions.urlMatches(urlLogado));

        assertFalse(logado);
    }

    @Test
    public void testCadastroInvalidoSenha() {
        Cadastro pag = PageFactory.initElements(driver, Cadastro.class);
        pag.preencheDados("studentufjf12@gmail.com","Student Ufjf", "123456Ab", "abcde");

        driver.findElement(By.xpath("/html/body/app/div/main/app-presentation/login-modal/div/div[1]/div/form/div[5]/div/re-captcha/div/div/div")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("disabled-signup-btn")).click();
        boolean logado = new WebDriverWait(driver, 10).until(ExpectedConditions.urlMatches(urlLogado));

        assertFalse(logado);
    }

	@After
	public void encerra() {driver.close();}
}
