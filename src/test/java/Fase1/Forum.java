package Fase1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Forum {
    private WebDriver driver;

    @FindBy(id="input-post-title")
    private WebElement title;

    @FindBy(id="input-post-comment")
    private WebElement comment;

    @FindBy(name = "inputComment")
    private WebElement comentario;


    public Forum(WebDriver driver) {
        this.driver = driver;
    }
    public Forum preencheDados(String title, String comment) {
        this.title.sendKeys(title);
        this.comment.sendKeys(comment);
        PageFactory.initElements(driver, this);
        return this;
    }
    public Forum preencheComentarioResposta(String comentario){
        this.comentario.sendKeys(comentario);
        PageFactory.initElements(driver,this);
        return this;
    }
}
