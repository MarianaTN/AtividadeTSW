import org.eclipse.jetty.util.thread.Scheduler;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class Test {

    private static WebDriver driver;

    private String email = "student2@gmail.com";
    private String password = "Tester123";

    @BeforeClass
    public static void configure() {
        System.setProperty("webdriver.gecko.driver", "/opt/geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://localhost:5000/");
        driver.findElement(By.linkText("Log in")).click();
    }

    private void loginSite(){
        Login pagLogin = PageFactory.initElements(driver, Login.class);
        pagLogin.preencheDados(email, password);
        driver.findElement(By.id("log-in-btn")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

   /* @org.junit.Test
    public void testCourseInfo() {

        loginSite();

        driver.get("https://localhost:5000/courses/1/0");
        CourseInfo pag = PageFactory.initElements(driver, CourseInfo.class);
        pag.InsertDescription("Descrição 1 Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1");
    }

    @org.junit.Test
    public void testCourseSession() {

        loginSite();

        driver.get("https://localhost:5000/courses/1/1");
        CourseSession pag = PageFactory.initElements(driver, CourseSession.class);
        pag.ConferenceSession("TESTE 1");
    }*/

    @org.junit.Test
    public void testChangePassword() {

        loginSite();

        driver.findElement(By.id("settings-button")).click();

        SeetingsUser pag = PageFactory.initElements(driver, SeetingsUser.class);
        pag.ChangePassword("Tester123", password);

        this.password = "Tester123";

        loginSite();

    }
}
