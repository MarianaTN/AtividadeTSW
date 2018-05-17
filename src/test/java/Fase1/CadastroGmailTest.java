package Fase1;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class CadastroGmailTest {

    private static WebDriver driver;

    @BeforeClass
    public static void configura() {
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://accounts.google.com/signup/v2/webcreateaccount?continue=https%3A%2F%2Faccounts.google.com%2FManageAccount&flowName=GlifWebSignIn&flowEntry=SignUp");
    }

//	@Test
//	public void test() {
//		CadastroGmail pag = PageFactory.initElements(driver, CadastroGmail.class);
//		pag.preencheDados("Mariana", "Trevizani");
//	}
}
