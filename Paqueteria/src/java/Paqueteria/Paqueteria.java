
package Paqueteria;

import java.util.Random;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "Paqueteria")
public class Paqueteria {

    @WebMethod(operationName = "enviar")
    public String enviar(@WebParam(name = "cliente") String cliente,
                         @WebParam(name = "producto") String producto,
                         @WebParam(name = "unidades") int unidades) {
        String confirmacion = confirmacionAleatoria();
        String fechaDeEntrega = fechaDeEntregaAleatoria();
        // TODO: Registrar en BD: cliente, producto, confirmación y fecha de entrega
        return confirmacion;
    }
    
    @WebMethod(operationName = "obtenerFechaDeEntrega")
    public String obtenerFechaDeEntrega(@WebParam(name = "confirmacion") String confirmacion) {
        // TODO: Obtener fecha de entrega de la base de datos
        return fechaDeEntregaAleatoria();
    }
    
    private static String confirmacionAleatoria() {
        int entero_1 = enteroAleatorioEntre(1000, 9999);
        int entero_2 = enteroAleatorioEntre(1000, 9999);
        int entero_3 = enteroAleatorioEntre(10, 99);
        return entero_1 + "-" + entero_2 + "-" + entero_3;
    }
    
    private static String fechaDeEntregaAleatoria() {
        String mes = agregarCero(enteroAleatorioEntre(1, 12));
        String dia = agregarCero(enteroAleatorioEntre(1, 28));
        return "2016-" + mes + "-" + dia;
    }
    
    private static int enteroAleatorioEntre(int min, int max) {
        Random r = new Random();
        int enteroAleatorio = r.nextInt(max - min + 1) + min;
        return enteroAleatorio;
    }
    
    private static String agregarCero(int entero) {
        String cadena;
        if (entero < 10)
            cadena = "0" + entero;
        else
            cadena = String.valueOf(entero);
        
        return cadena;
    }
}
