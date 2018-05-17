package Fase1;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ForumTest {
    private static WebDriver driver;

    private String url = "https://atlantis.isti.cnr.it:5000/course";

    @BeforeClass
    public static void configura() {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://atlantis.isti.cnr.it:5000/");
        Login pag = PageFactory.initElements(driver, Login.class);
        driver.findElement(By.linkText("Log in")).click();
        pag.preencheDados("teacher@gmail.com", "pass");
        driver.findElement(By.id("log-in-btn")).click();

    }

    @Test
    public void testAcessoForum() throws InterruptedException {
        Forum forum = PageFactory.initElements(driver, Forum.class);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/app/div/main/app-dashboard/div/div[3]/div/div[1]/ul/li[1]/div/div[2]")).click();

        driver.findElement(By.id("forum-tab-icon")).click();
        driver.findElement(By.id("add-entry-icon")).click();

        forum.preencheDados("Titulo 3", "Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 ");
        driver.findElement(By.id("post-modal-btn")).click();

       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/app/div/main/app-course-details/div/div[4]/md-tab-group/div[2]/div[3]/div/ul/div[1]/div/li")).click();
        driver.findElement(By.xpath("/html/body/app/div/main/app-course-details/div/div[4]/md-tab-group/div[2]/div[3]/div/div/div[1]/div[2]/a")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        forum.preencheComentarioResposta("Comentário 1123 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1");
        driver.findElement(By.id("post-modal-btn")).click();

        driver.findElement(By.xpath("/html/body/app/div/main/app-course-details/div/div[3]/md-tab-group/div[2]/div[3]/div/div/div[1]/div[2]/a")).click();

        forum.preencheComentarioResposta("Comentário novo Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1 Comentário 1");
        driver.findElement(By.id("post-modal-btn")).click();

        boolean achouComentario = driver.getPageSource().contains("Comentário novo");
        assertTrue(achouComentario);

    }

    @Test
    public void testDesativarForum() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.partialLinkText("Pseudoscientific course")).click();
        driver.findElement(By.id("forum-tab-icon")).click();

        //desativa
        driver.findElement(By.id("edit-forum-icon")).click();
        driver.findElement(By.id("label-forum-checkbox")).click();
        driver.findElement(By.id("put-modal-btn")).click();

    }

    @Test
    public void testAtivarForum() throws InterruptedException {
        testDesativarForum();
        driver.findElement(By.xpath("/html/body/app/div/main/app-dashboard/div/div[3]/div/div[1]/ul/li[1]/div/div[2]")).click();
        driver.findElement(By.id("forum-tab-icon")).click();

        //ativa
        driver.findElement(By.id("edit-forum-icon")).click();
        driver.findElement(By.id("label-forum-checkbox")).click();
        driver.findElement(By.id("put-modal-btn")).click();
    }

}
