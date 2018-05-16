package Fase1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    private WebDriver driver;

    @FindBy(name="email")
    private WebElement email;

    @FindBy(id="password")
    private WebElement senha;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public Login preencheDados(String email, String senha) {
        this.email.sendKeys(email);
        this.senha.sendKeys(senha);
        PageFactory.initElements(driver, this);
        return this;
    }
}
