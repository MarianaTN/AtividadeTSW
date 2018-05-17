package Fase1;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ForumTest {
    private static WebDriver driver;

    private String url = "https://atlantis.isti.cnr.it:5000/course";

    @Before
    public static void configura() {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://atlantis.isti.cnr.it:5000/");
        //realiza login
        Login pag = PageFactory.initElements(driver, Login.class);
        driver.findElement(By.linkText("Log in")).click();
        pag.preencheDados("teacher@gmail.com", "pass");
        driver.findElement(By.id("log-in-btn")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //acesso ao primeiro curso e a aba forum
        driver.findElement(By.xpath("/html/body/app/div/main/app-dashboard/div/div[3]/div/div[1]/ul/li[1]/div/div[2]")).click();
        driver.findElement(By.id("forum-tab-icon")).click();

    }

    @Test
    public void testAcessoForum() throws InterruptedException {
        Forum forum = PageFactory.initElements(driver, Forum.class);
        //adicionar comentario
        driver.findElement(By.id("add-entry-icon")).click();

        forum.preencheDados("Titulo 1", "Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 ");
        //send
        driver.findElement(By.id("post-modal-btn")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //não ta achando os elementos abaixo
        //selecionar comentario
        driver.findElement(By.xpath("/html/body/app/div/main/app-course-details/div/div[4]/md-tab-group/div[2]/div[3]/div/ul/div[1]")).click();
        //novo comentario
        driver.findElement(By.xpath("/html/body/app/div/main/app-course-details/div/div[4]/md-tab-group/div[2]/div[3]/div/div/div[1]/div[2]/a/i")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        forum.preencheComentarioResposta("Comentário 1123 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1");
        //send
        driver.findElement(By.id("post-modal-btn")).click();
        //resposta comentario
        driver.findElement(By.xpath("/html/body/app/div/main/app-course-details/div/div[4]/md-tab-group/div[2]/div[3]/div/div/div[2]/div[1]/app-comment/div/div[1]/div[2]/a")).click();

        forum.preencheComentarioResposta("Comentário novo Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1");
        //send
        driver.findElement(By.id("post-modal-btn")).click();

        boolean achouComentario = driver.getPageSource().contains("Comentário novo");
        assertTrue(achouComentario);

    }

    @Test
    public void testDesativarForum() throws InterruptedException {
        //botao de editar
        driver.findElement(By.id("edit-forum-icon")).click();
        //checkbox ativa/desativa
        driver.findElement(By.id("label-forum-checkbox")).click();
        //send
        driver.findElement(By.id("put-modal-btn")).click();

        String msgDesativado = driver.findElement(By.xpath("/html/body/app/div/main/app-course-details/div/div[4]/md-tab-group/div[2]/div[3]/div/div/app-error-message/div/h5")).getText();
        assertEquals("The forum is not activated!",msgDesativado);

    }

    @Test
    public void testAtivarForum() throws InterruptedException {
        //botao de editar
        driver.findElement(By.id("edit-forum-icon")).click();
        //checkbox ativa/desativa
        driver.findElement(By.id("label-forum-checkbox")).click();
        //send
        driver.findElement(By.id("put-modal-btn")).click();

        boolean ativado = driver.getPageSource().contains("/html/body/app/div/main/app-course-details/div/div[4]/md-tab-group/div[2]/div[3]/div/ul/div[1]");
        assertTrue(ativado);
    }

    @After
    public void encerra() {driver.close();}
}
