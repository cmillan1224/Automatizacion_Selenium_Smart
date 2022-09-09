package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaginaPlanEstudios {

    //atributos
    private int opcionListaDesplegable;
    private WebDriver chromeDriver;
    private int ventana;

    //Localizadores de elementos
    @FindBy(css = "#BUTTON1")
    private WebElement botonConfirmar;
    @FindBy(xpath = "//tbody/tr[@id='Grid1ContainerRow_0009']/td[3]")
    private WebElement filaHoraClase;
    @FindBy(id = "W0030Grid1ContainerRow_0001")
    private WebElement filaPlanEstudios;
    @FindBy(id = "W0030BUTTON1")
    private WebElement botonIniciar;
    @FindBy(xpath = "//iframe[@id='gxp0_ifrm']")
    private WebElement iframe;
    @FindBy(id = "vTPEAPROBO")
    private WebElement listaEstadoClases;
    @FindBy(id = "vDIA")
    private WebElement listaDia;
    @FindBy(xpath = "//tbody/tr[@id='Grid1ContainerRow_0001']/td[6]")
    private WebElement filaClasePendiente;
    @FindBy(xpath = "//input[@id='BUTTON1']")
    private WebElement botonAsignar;
    @FindBy(css = "body.Form:nth-child(2) form.Form:nth-child(1) div.gx-content-placeholder:nth-child(2) div.gx-ct-body.Form-fx table.gx-tab-spacing-fix-2.Table:nth-child(2) td.gx-tab-padding-fix-1 table.gx-tab-spacing-fix-2.Table tr:nth-child(3) td.gx-tab-padding-fix-1 div:nth-child(1) span.ErrorViewer.gx_ev.ErrorViewerBullet > div.gx-warning-message")
    private WebElement mensajeErrorAlMatricular;

    private int i=0;
    //Metodos
    public boolean validarMensaje(){
        System.out.println("Mensaje obtenido:"+ mensajeErrorAlMatricular.getText());
        boolean b = mensajeErrorAlMatricular.isDisplayed();
        return b;
    }
    public void clickConfirmarClase(){
        botonConfirmar.click();
    }
    public void seleccionarHoraClase(){
        filaHoraClase.click();
    }
    public void hacerClickEnAsignar(){
        botonAsignar.click();
    }
    public void selecionarClasePendiente(){
        filaClasePendiente.click();
    }
    public void setOpcionListaDesplegable(int opcionListaDesplegable){
        this.opcionListaDesplegable = opcionListaDesplegable;
    }
    public void seleccionarOpcionListaEstadoClase(){
        Select lista = new Select(listaEstadoClases);
        lista.selectByIndex(opcionListaDesplegable);
    }
    public void seleccionarOpcionListaDia(){
        Select lista = new Select(listaDia);
        lista.selectByIndex(opcionListaDesplegable);
    }
    public void cambiarAVentanaPrincipal(){
        chromeDriver.switchTo().defaultContent();
    }
    public void setVentana(int ventana){
        this.ventana = ventana;
    }
    public void cambiarASubVentana(){
        chromeDriver.switchTo().frame(ventana);
    }
    public void hacerClickBotonIniciar(){
        botonIniciar.click();
    }
    public void SeleccionarFila(){
        filaPlanEstudios.click();
    }

    //Constructor
    public PaginaPlanEstudios(WebDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        PageFactory.initElements(chromeDriver,this);
    }
}
