package Pruebas;

import PageObjects.PaginaPlanEstudios;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;
import java.time.Duration;

public class Main extends BaseTestSuite {
    private int contador = 0;

    @Test
    public void hacer_una_busqueda() throws InterruptedException {
        try {
            //Mapeamos los elementos para hacer login
            paginaPrincipal.identificarse("1005058588","Cmillan1224");
            paginaOpciones.hacerClickEnProgramacion();
            paginaPlanEstudios.SeleccionarFila();
            paginaPlanEstudios.hacerClickBotonIniciar();
            paginaPlanEstudios.setVentana(0);
            Thread.sleep(2000);
            paginaPlanEstudios.cambiarASubVentana();
            paginaPlanEstudios.setOpcionListaDesplegable(2);
            paginaPlanEstudios.seleccionarOpcionListaEstadoClase();
            paginaPlanEstudios.selecionarClasePendiente();
            Thread.sleep(2000);
            paginaPlanEstudios.hacerClickEnAsignar();
            paginaPlanEstudios.cambiarAVentanaPrincipal();
            paginaPlanEstudios.setVentana(1);
            Thread.sleep(2000);
            paginaPlanEstudios.cambiarASubVentana();
            paginaPlanEstudios.setOpcionListaDesplegable(1);
            paginaPlanEstudios.seleccionarOpcionListaDia();
            paginaPlanEstudios.seleccionarHoraClase();
            paginaPlanEstudios.clickConfirmarClase();
            boolean error= paginaPlanEstudios.validarMensaje();

            if (error && contador < 2) {
                contador++;
                cerrarDriver();
                abrirDriver();
                hacer_una_busqueda();
            }
        } catch (NoSuchElementException e) {
            System.out.println("No encontro un WebElement");
            cerrarDriver();
            abrirDriver();
            hacer_una_busqueda();
        }
    }
}
