package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaSingIn {

    //Encuentra y asigna el webElement
    @FindBy(id = "vUSUCOD")
    private WebElement campoUser;
    @FindBy(id = "vPASS")
    private WebElement campoPassword;

    private void ingresarUsuario(String usuario){
        campoUser.sendKeys(usuario);
    }
    private void ingresarPassword(String password){
        campoPassword.sendKeys(password);
    }
    private void darClickSingIn(){
        campoPassword.sendKeys(Keys.ENTER);
    }

    public void identificarse(String usuario, String password){
        ingresarUsuario(usuario);
        ingresarPassword(password);
        darClickSingIn();
    }
    //Constructor
    public PaginaSingIn(WebDriver chromeDriver){
        PageFactory.initElements(chromeDriver,this);
    }
}
