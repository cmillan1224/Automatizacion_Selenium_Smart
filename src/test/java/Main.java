
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Main {
    private WebDriver chromeDriver;
    public int i =0;
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

    }
    @Test
    public void hacer_una_busqueda() throws InterruptedException {
        try{
            //Abrimos una URL
            chromeDriver.get("https://schoolpack.smart.edu.co/idiomas/alumnos.aspx");

            //Mapeamos los elementos para hacer login
            WebElement user = chromeDriver.findElement(By.id("vUSUCOD"));
            user.sendKeys("1005058588");

            WebElement password = chromeDriver.findElement(By.id("vPASS"));
            password.sendKeys("Cmillan1224");
            password.sendKeys(Keys.ENTER);

            //Espera hasta que el elemento sea visible
            WebDriverWait esperaExplicita = new WebDriverWait(chromeDriver,Duration.ofSeconds(60));
            esperaExplicita.until(ExpectedConditions.visibilityOfElementLocated(By.id("IMAGE18")));

            WebElement programacion = chromeDriver.findElement(By.id("IMAGE18"));
            programacion.click();

            //esperaExplicita.until(ExpectedConditions.visibilityOfElementLocated(By.id("W0030Grid1ContainerRow_0001")));
            WebElement planDeEstudios = chromeDriver.findElement(By.id("W0030Grid1ContainerRow_0001"));
            planDeEstudios.click();

            WebElement botonIniciar = chromeDriver.findElement(By.id("W0030BUTTON1"));
            botonIniciar.click();

            esperaExplicita.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='gxp0_ifrm']")));
            WebElement iframe = chromeDriver.findElement(By.xpath("//iframe[@id='gxp0_ifrm']"));
            chromeDriver.switchTo().frame(iframe);

            Select listaDesplegable = new Select(chromeDriver.findElement(By.id("vTPEAPROBO")));
            listaDesplegable.selectByVisibleText("Pendientes por programar");

            //Espera hasta que el elemento sea visible
            esperaExplicita.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='TABLE1']")));
            WebElement fila1 = chromeDriver.findElement(By.xpath("//tbody/tr[@id='Grid1ContainerRow_0001']/td[6]"));
            fila1.click();

            Thread.sleep(2000);
            WebElement botonAsignar = chromeDriver.findElement(By.xpath("//input[@id='BUTTON1']"));
            Thread.sleep(2000);
            botonAsignar.click();

            Thread.sleep(2000);
            chromeDriver.switchTo().defaultContent();
            int size = chromeDriver.findElements(By.tagName("iframe")).size();
            System.out.println(size);
            chromeDriver.switchTo().frame(1);


            Select listaDesplegableDia = new Select(chromeDriver.findElement(By.id("vDIA")));
            listaDesplegableDia.selectByIndex(1);

            WebElement horaSeleccionar = chromeDriver.findElement(By.xpath("//tbody/tr[@id='Grid1ContainerRow_0009']/td[3]"));
            horaSeleccionar.click();

            WebElement confirmar = chromeDriver.findElement(By.cssSelector("#BUTTON1"));
            confirmar.click();

            WebElement mensajeValidar = chromeDriver.findElement(By.cssSelector("body.Form:nth-child(2) form.Form:nth-child(1) div.gx-content-placeholder:nth-child(2) div.gx-ct-body.Form-fx table.gx-tab-spacing-fix-2.Table:nth-child(2) td.gx-tab-padding-fix-1 table.gx-tab-spacing-fix-2.Table tr:nth-child(3) td.gx-tab-padding-fix-1 div:nth-child(1) span.ErrorViewer.gx_ev.ErrorViewerBullet > div.gx-warning-message"));
            if(mensajeValidar.isDisplayed() && i<2){
                i++;
                cerrarDriver();
                abrirDriver();
                hacer_una_busqueda();
            }
        }catch (NoSuchElementException e){
            System.out.println("No encontro un WebElement");
            cerrarDriver();
            abrirDriver();
            hacer_una_busqueda();
        }
    }
    @AfterTest
    public void cerrarDriver(){
        //cerrar ventana apagar driver
        chromeDriver.close();
    }
}
