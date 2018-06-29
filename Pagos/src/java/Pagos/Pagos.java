
package Pagos;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "Pagos")
public class Pagos {

    @WebMethod(operationName = "obtenerCliente")
    public String obtenerCliente(@WebParam(name = "tarjeta") String tarjeta) {
        return tarjeta;
    }
    
    @WebMethod(operationName = "cobrar")
    public boolean cobrar(@WebParam(name = "cliente") String cliente, 
                          @WebParam(name = "monto") double monto) {
        
        boolean cobrado;
        double capacidad = obtenerCapacidadDeCliente(cliente);
        
        if (monto <= capacidad) {
            descontarMonto(cliente, monto);
            cobrado = true;
        } else
            cobrado = false;
        
        return cobrado;
    }
    
    public static double obtenerCapacidadDeCliente(String cliente) {
        // TODO: revisar en BD si tiene capacidad suficiente
        double capacidad = 50.00;
        return capacidad;
    }
    
    public static void descontarMonto(String cliente, double monto) {
        // TODO: Descontar monto de BD
        int basura;
    }
}
