package Fase1;

import org.junit.AfterClass;
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

public class ControleAlunosCursoTest {

    private static WebDriver driver;
    private static String urlLogado = "https://atlantis.isti.cnr.it:5000/course";
    private static String url = "https://atlantis.isti.cnr.it:5000/";


    public static void configura() {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(url);
        driver.findElement(By.linkText("Log in")).click();
        Login pag1 = PageFactory.initElements(driver, Login.class);
        pag1.preencheDados("student2@gmail.com", "pass");

        driver.findElement(By.id("log-in-btn")).click();
        boolean logado = new WebDriverWait(driver, 10).until(ExpectedConditions.urlMatches(urlLogado));

        assertTrue(logado); }


        @AfterClass
        public static void tearDownTest(){
        driver.quit(); }

    @Test
    public void testControleAlunosCursoSingle(){
        ControleAlunosCurso aluno1= PageFactory.initElements(driver, ControleAlunosCurso.class);
        aluno1.preencheDadosSingle("studentufjf12@gmail.com");
        driver.findElement(By.id("log-in-btn")).click();

        String aluno = driver.getCurrentUrl();
        assertEquals(url,aluno);
    }

    @Test
    public void testControleAlunosCursoMulti(){
        ControleAlunosCurso aluno1= PageFactory.initElements(driver, ControleAlunosCurso.class);
        aluno1.preencheDadosSingle("studentufjf@gmail.com";"student1@gmail.com");
        driver.findElement(By.id("log-in-btn")).click();

        String aluno = driver.getCurrentUrl();
        assertEquals(url,aluno);
    }
}
