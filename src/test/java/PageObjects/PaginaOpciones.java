package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaOpciones {

    @FindBy(id = "IMAGE18")
    private WebElement programacion;

    public void hacerClickEnProgramacion(){
        programacion.click();
    }
    public PaginaOpciones(WebDriver chromeDriver){
        PageFactory.initElements(chromeDriver,this);
    }
}
