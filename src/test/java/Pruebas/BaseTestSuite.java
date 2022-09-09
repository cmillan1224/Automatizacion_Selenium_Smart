package Pruebas;

import PageObjects.PaginaOpciones;
import PageObjects.PaginaPlanEstudios;
import PageObjects.PaginaSingIn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.time.Duration;

public class BaseTestSuite {

    protected WebDriver chromeDriver;

    //Se declaran las paginas a utilizar
    protected PaginaSingIn paginaPrincipal;
    protected PaginaOpciones paginaOpciones;
    protected PaginaPlanEstudios paginaPlanEstudios;

    //Se inicializan las paginas enviando el chromeDriver
    public void inicializarPaginas(WebDriver Driver){
       paginaPrincipal = new PaginaSingIn(Driver);
       paginaOpciones = new PaginaOpciones(Driver);
       paginaPlanEstudios = new PaginaPlanEstudios(Driver);
    }
    @BeforeTest
    public void abrirDriver(){
        //Encontrar archivo .exe de chromedriver
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //Creamos opciones sobre nuestro driver
        ChromeOptions options = new ChromeOptions();
        //options.setCapability("Marionette", true);

        //Nueva instancia de chromedriver
        chromeDriver = new ChromeDriver(options);
        chromeDriver.manage().window().maximize();

        //Definimos un tiempo de espera hasta que aceptamos un timeout
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        inicializarPaginas(chromeDriver);

        //Abrimos una URL
        chromeDriver.get("https://schoolpack.smart.edu.co/idiomas/alumnos.aspx");
    }

    @AfterTest
    public void cerrarDriver(){
        //cerrar ventana apagar driver
        chromeDriver.close();
    }
}
