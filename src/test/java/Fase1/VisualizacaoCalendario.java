package Fase1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VisualizacaoCalendario {

    @FindBy(xpath="/html/body/app/div/main/app-dashboard/div/div[2]/div/div[2]/div[2]/calendar-app/div/div[1]/div[2]/div/i[1]")
    private WebElement ante;

    @FindBy(xpath="/html/body/app/div/main/app-dashboard/div/div[2]/div/div[2]/div[2]/calendar-app/div/div[1]/div[2]/div/i[3]")
    private WebElement depo;

    @FindBy(xpath="/html/body/app/div/main/app-dashboard/div/div[2]/div/div[2]/div[2]/calendar-app/div/div[1]/div[1]/h3")
    private WebElement mes;


    public VisualizacaoCalendario  ConfereCalendarioAnte(){
        ante.click();
        return this;
    }

    public VisualizacaoCalendario  ConfereCalendarioDep(){
        depo.click();
        return this;
    }

    public void CofereMes(String teste){
        teste = mes.getText();

    }

}
