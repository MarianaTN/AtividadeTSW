package Fase1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ControleAlunosCurso {

    private WebDriver driver;

    @FindBy(xpath="//*[@id=\"attenders-tab-icon\"]")
    private WebElement attends;

    @FindBy (xpath = "//*[@id=\"course-list\"]/li[1]/div")
    private WebElement curso;


    @FindBy(id = "add-attenders-icon")
    private WebElement mais;

    @FindBy(id="nput-attender-simple")
    private WebElement email_1;

    @FindBy(id="nput-attender-simple")
    private WebElement email_2;

    public ControleAlunosCurso(WebDriver driver) {
        this.driver = driver;
    }

    public ControleAlunosCurso preencheDadosSingle(String email) {
        this.email_1.sendKeys(email);
        PageFactory.initElements(driver, this);
        return this; }

    public ControleAlunosCurso preencheDadosMulti(String email, String email_2) {
       this.email_2.sendKeys(email_2);
        this.email_1.sendKeys(email_1);
        PageFactory.initElements(driver, this);
        return this;



}
