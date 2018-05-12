import org.eclipse.jetty.util.thread.Scheduler;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class Test {

    private static WebDriver driver;

    private String email = "student1@gmail.com";
    private String password;

    @BeforeClass
    public static void configure() {
        System.setProperty("webdriver.gecko.driver", "/opt/geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://localhost:5000/");
        driver.findElement(By.linkText("Log in")).click();
    }

    private void loginSite(){
        password = "Pass1234";

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
    }*/

    @org.junit.Test
    public void testCourseSession() {

        loginSite();

        driver.findElement(By.xpath("/html/body/app/div/main/app-dashboard/div/div[2]/div/div[1]/ul/li[1]/div/div[2]")).click();
        driver.findElement(By.xpath("/html/body/app/div/main/app-course-details/div/div[3]/md-tab-group/div[1]/div[2]/div")).click();
        driver.findElement(By.xpath("/html/body/app/div/main/app-course-details/div/div[3]/md-tab-group/div[2]/div[2]/div/ul/div[1]/li[1]/div/div[1]")).click();

        CourseSession pag = PageFactory.initElements(driver, CourseSession.class);
        pag.ConferenceSession("TESTE 1");
    }

    /*@org.junit.Test
    public void testChangePassword() {


        loginSite();

        driver.findElement(By.id("settings-button")).click();
        SeetingsUser pag = PageFactory.initElements(driver, SeetingsUser.class);
        pag.ChangePassword("Pass1234", password);

    }*/
}
