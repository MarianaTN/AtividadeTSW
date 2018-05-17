package Fase1;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByPartialLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VisualizacaoCalendarioTest {

    private static WebDriver driver;
    private static String urlLogado = "https://atlantis.isti.cnr.it:5000/course";
    private static String url = "https://atlantis.isti.cnr.it:5000/";

    @BeforeClass
    public static void configura() {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(url);
        driver.findElement(By.linkText("Log in")).click();
        Login pag1 = PageFactory.initElements(driver, Login.class);
        pag1.preencheDados("student2@gmail.com", "pass");

        driver.findElement(By.id("log-in-btn")).click();
        boolean logado = new WebDriverWait(driver, 10).until(ExpectedConditions.urlMatches(urlLogado));

        assertTrue(logado);


    }



    @AfterClass
    public static void tearDownTest(){
            driver.quit();
    }


    @Test
    public void testaBotaoAntes(){
        VisualizacaoCalendario calendarioATestar =  PageFactory.initElements(driver, VisualizacaoCalendario.class);
        String MesStart = driver.findElement(By.className("calendar-title")).getText();
        calendarioATestar.ConfereCalendarioAnte();
        String MesSelect = driver.findElement(By.className("calendar-title")).getText();

        // driver.findElement(By.class("cal-cell-top")).click();
        if(MesStart.equals(MesSelect)){
          //  assertEquals(MesStart, MesStart);
            System.out.println("teste invalido");
        }else {
            System.out.println("teste valido");
            //assertEquals(MesStart, "Mes invalido");
        }
    }
    @Test
    public void testaBotaoDepois(){
        VisualizacaoCalendario calendarioATestar =  PageFactory.initElements(driver, VisualizacaoCalendario.class);
        String MesStart = driver.findElement(By.className("calendar-title")).getText();
        calendarioATestar.ConfereCalendarioDep();
        String MesSelect = driver.findElement(By.className("calendar-title")).getText();

        // driver.findElement(By.class("cal-cell-top")).click();
        if(MesStart.equals(MesSelect)){
            //  assertEquals(MesStart, MesStart);
            System.out.println("teste invalido");
        }else {
            System.out.println("teste valido");
            //assertEquals(MesStart, "Mes invalido");
        }

    }
}


//    @Fase2.Test
//    public void testaBotaoAntes(){
//         driver.findElement(By.id("material-icons no-padding-left")).click();
//    }
//
//    @Fase2.Test
//    public void testaDiaCalendario(){
//        driver.findElement(By.id("cal-cell-top")).click();
//
//    }

