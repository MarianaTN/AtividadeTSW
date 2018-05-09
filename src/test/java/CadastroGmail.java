import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CadastroGmail {

    private WebDriver driver;

    @FindBy(name="firstName")
    private WebElement nome;

    @FindBy(id="lastName")
    private WebElement sobrenome;

    public CadastroGmail(WebDriver driver) {
        this.driver = driver;
    }

    public CadastroGmail preencheDados(String nome, String sobrenome) {
        this.nome.sendKeys(nome);
        this.sobrenome.sendKeys(sobrenome);
        PageFactory.initElements((WebDriver) driver, this);
        return this;
    }
}
