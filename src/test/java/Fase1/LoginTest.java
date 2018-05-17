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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest {
    private static WebDriver driver;

    private static String urlLogado = "https://atlantis.isti.cnr.it:5000/course";
    private static String url = "https://atlantis.isti.cnr.it:5000/";

    @BeforeClass
    public  void configura() {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://atlantis.isti.cnr.it:5000/");
        driver.findElement(By.linkText("Log in")).click();

    }

    @Test
    public  void  testProfessorLogin() {
        Login pag = PageFactory.initElements(driver, Login.class);
        pag.preencheDados("teacher@gmail.com", "pass");

        driver.findElement(By.id("log-in-btn")).click();
        boolean logado = new WebDriverWait(driver, 10).until(ExpectedConditions.urlMatches(urlLogado));

        assertTrue(logado);
    }
    @Test
    public void testAlunoLogin(){
        Login pag1 = PageFactory.initElements(driver, Login.class);
        pag1.preencheDados("student1@gmail.com", "pass");

        driver.findElement(By.id("log-in-btn")).click();
        boolean logado = new WebDriverWait(driver, 10).until(ExpectedConditions.urlMatches(urlLogado));

        assertTrue(logado);
    }

    @Test
    public void testLoginInvalidoSenha(){
        Login pag2 = PageFactory.initElements(driver, Login.class);
        pag2.preencheDados("teacher@gmail.com", "pass1");

        driver.findElement(By.id("log-in-btn")).click();

        String logado = driver.getCurrentUrl();
        assertEquals(url,logado);
    }

    @Test
    public void testLoginInvalidoEmail(){
        Login pag3 = PageFactory.initElements(driver, Login.class);
        pag3.preencheDados("studentufjf12@gmail.com", "123456");

        driver.findElement(By.id("log-in-btn")).click();

        String logado = driver.getCurrentUrl();
        assertEquals(url,logado);
    }

    @After
    public void encerra() {driver.close();}
}
