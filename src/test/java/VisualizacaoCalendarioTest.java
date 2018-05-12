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
    public void testaBotaoDepois(){
        VisualizacaoCalendario calendarioATestar =  PageFactory.initElements(driver, VisualizacaoCalendario.class);
        String MesStart = calendarioATestar.CofereMes();
        calendarioATestar.ConfereCalendarioAnte();
        
        // driver.findElement(By.class("cal-cell-top")).click();
        assertEquals(MesStart, calendarioATestar.CofereMes());
    }


//    @Test
//    public void testaBotaoAntes(){
//         driver.findElement(By.id("material-icons no-padding-left")).click();
//    }
//
//    @Test
//    public void testaDiaCalendario(){
//        driver.findElement(By.id("cal-cell-top")).click();
//
//    }
}
