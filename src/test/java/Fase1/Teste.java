package Fase1;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class Teste {

    private static WebDriver driver;

    @BeforeClass
    public static void configure() {
        System.setProperty("webdriver.gecko.driver", "/opt/geckodriver");
        driver = new FirefoxDriver();
    }

    @org.junit.Test
    public static void testCourseInfo() {
        driver.get("https://atlantis.isti.cnr.it:5000/courses/1/0");
        CourseInfo pag = PageFactory.initElements(driver, CourseInfo.class);
        pag.InsertDescription("Descrição 1 Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1");
    }

    @org.junit.Test
    public void testCourseSession() {
        driver.get("https://atlantis.isti.cnr.it:5000/courses/1/1");
        CourseSession pag = PageFactory.initElements(driver, CourseSession.class);
        pag.ConferenceSession("TESTE 1");
    }



}
