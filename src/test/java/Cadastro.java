import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cadastro {
    private WebDriver driver;

    @FindBy(id="email")
    private WebElement email;

    @FindBy(id="nickName")
    private WebElement name;

    @FindBy(id="password")
    private WebElement senha;

    @FindBy(id="confirmPassword")
    private WebElement confirmaSenha;

    public Cadastro(WebDriver driver) {
        this.driver = driver;
    }
    public Cadastro preencheDados(String email, String name, String senha, String confirmaSenha) {
        this.email.sendKeys(email);
        this.name.sendKeys(name);
        this.senha.sendKeys(senha);
        this.confirmaSenha.sendKeys(confirmaSenha);
        PageFactory.initElements(driver, this);
        return this;
    }
}
