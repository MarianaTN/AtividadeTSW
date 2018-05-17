import Fase1.CourseInfo;
import Fase1.CourseSession;
import Fase1.Login;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class Test {

    private static WebDriver driver;
    private static String infoTab;
    private static String forumab;
    private static String fileTab;
    private static String sessionTab;
    private static String attenderTab;
    private static String password;
    private static String email;

    @BeforeClass
    public static void configure() {

        initializeVariable();

        System.setProperty("webdriver.gecko.driver", "/opt/geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://localhost:5000/");
        driver.findElement(By.linkText("Log in")).click();
    }

   /* @org.junit.Test
    public void testCourseInfo() {

        loginSite();

        driver.get("https://localhost:5000/courses/1/0");
        CourseInfo pag = PageFactory.initElements(driver, CourseInfo.class);
        pag.InsertDescription("Descrição 1 Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1Descrição 1");
    }

    @org.junit.Test
    public void testChangePassword() {
        loginSite();

        driver.findElement(By.id("settings-button")).click();
        SeetingsUser pag = PageFactory.initElements(driver, SeetingsUser.class);
        pag.ChangePassword("Pass1234", password);

    }
    */

    @org.junit.Test
    public void testCourseInfo() {

        loginSite();

        goToFirstCourse(infoTab);

        CourseInfo pag = PageFactory.initElements(driver, CourseInfo.class);
        pag.InsertDescription("teste 1");
    }

    @org.junit.Test
    public void testCourseDetails() {

        loginSite();

        goToFirstCourse(infoTab);
        goToFirstCourse(attenderTab);
        goToFirstCourse(sessionTab);
        goToFirstCourse(fileTab);

    }

    public void AddCourse(){
        loginSite();

        driver.findElement(By.id("add-new-course-btn")).click();
        CourseInfo pag = PageFactory.initElements(driver, CourseInfo.class);
        pag.AddCourse("TESTE 1");
    }

    @org.junit.Test
    public void testCourseSession() {

        loginSite();

        goToFirstCourse(sessionTab);

        CourseSession pag = PageFactory.initElements(driver, CourseSession.class);
        pag.ConferenceSession("TESTE 1");
    }

    private static void initializeVariable(){

        String path = "/html/body/app/div/main/app-course-details/div/div[3]/md-tab-group/div[2]/div[2]/div/ul/div[1]/li[1]/div/";

        infoTab = path + "div[0]";
        sessionTab  =  path + "div[1]";
        forumab = path +  "div[2]";
        fileTab = path +  "div[3]";
        attenderTab =  path + "div[4]";
        email = "student1@gmail.com";
        password = "pass";

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

    private void goToFirstCourse(String xpathTab){
        driver.findElement(By.xpath("/html/body/app/div/main/app-dashboard/div/div[2]/div/div[1]/ul/li[1]/div/div[2]")).click();
        driver.findElement(By.xpath("/html/body/app/div/main/app-course-details/div/div[3]/md-tab-group/div[1]/div[2]/div")).click();
        driver.findElement(By.xpath(xpathTab)).click();
    }
}
