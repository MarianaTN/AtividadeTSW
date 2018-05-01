import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.*;

public class CadastroGmailTest {
    private static WebDriver driver;

    @BeforeClass
    public static void configura() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\marit\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://accounts.google.com/signup/v2/webcreateaccount?continue=https%3A%2F%2Faccounts.google.com%2FManageAccount&flowName=GlifWebSignIn&flowEntry=SignUp");
    }

	@Test
	public void test() {
		CadastroGmail pag = PageFactory.initElements(driver, CadastroGmail.class);
		pag.preencheDados("Mariana", "Trevizani");
	}
}
