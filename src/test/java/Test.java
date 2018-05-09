import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class Test {

    private static WebDriver driver;

    private String email = "student2@gmail.com";
    private String password = "pass";

    @BeforeClass
    public static void configure() {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://atlantis.isti.cnr.it:5000/");
        driver.findElement(By.linkText("Log in")).click();
    }

    private void loginSite(){
        Login pagLogin = PageFactory.initElements(driver, Login.class);
        pagLogin.preencheDados(email, password);
    }

    @org.junit.Test
    public void testCourseInfo() {

        loginSite();

        driver.get("https://atlantis.isti.cnr.it:5000/courses/1/0");
        CourseInfo pag = PageFactory.initElements(driver, CourseInfo.class);
        pag.InsertDescription("Descrição 1 Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1");
    }

    @org.junit.Test
    public void testCourseSession() {

        loginSite();

        driver.get("https://atlantis.isti.cnr.it:5000/courses/1/1");
        CourseSession pag = PageFactory.initElements(driver, CourseSession.class);
        pag.ConferenceSession("TESTE 1");
    }

    @org.junit.Test
    public void testChangePassword() {

        loginSite();

        driver.get("https://atlantis.isti.cnr.it:5000/settings");
        SeetingsUser pag = PageFactory.initElements(driver, SeetingsUser.class);
        pag.ChangePassword("pass123", password);
    }



}
